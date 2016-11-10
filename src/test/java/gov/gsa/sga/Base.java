package gov.gsa.sga;

import org.junit.After;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertEquals;

public class Base{
    protected WebDriver driver;
    protected String chromedriverbin = "";
    protected String phantomjsbin = "/usr/bin/phantomjs";
    protected String base_url = System.getProperty("siteTarget");
    protected String port = "80";
    protected FluentWait wait;

    public Base(){
        setUp();
    }

    public void setUp() {
        if(!System.getProperty("phantomjsbin","").equals("")){
            phantomjsbin = System.getProperty("phantomjsbin","bin/phantomjs");//linux only
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setJavascriptEnabled(true);
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjsbin);
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[]{
                "--web-security=false",
                "--ssl-protocol=any",
                "--ignore-ssl-errors=true"
            });

            driver = new PhantomJSDriver(caps);
        } else {
            chromedriverbin = System.getProperty("chromedriverbin","bin/chromedriver.exe");//windows
            System.setProperty("webdriver.chrome.driver", chromedriverbin);
            ChromeOptions opts = new ChromeOptions();
            if(!System.getProperty("cicd","").equals("")) {
                opts.addArguments(new String[]{
                        "--display :1.5"
                });
            }
            driver = new ChromeDriver(opts);

        }
        if(!System.getProperty("port","").equals("")) {
            port = System.getProperty("port");
        }
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        //load homepage and run tasks
        String url = "";
        if(port.equals("80")){
            url = base_url;
        } else {
            url = base_url + ":" + port;
        }
        driver.get(url);
        waitForJSandJQueryToLoad();

        wait = new FluentWait(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
    }

    protected boolean waitForJSandJQueryToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("js loaded");
                return ((JavascriptExecutor)driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(jsLoad);
    }

    public static ExpectedCondition angularHasFinishedProcessing() {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
            String hasAngularFinishedScript = "var callback = arguments[arguments.length - 1];\n" +
                "try {\n" +
                "    var testabilities = window.getAllAngularTestabilities();\n" +
                "    var count = testabilities.length;\n" +
                "    var decrement = function() {\n" +
                "      count--;\n" +
                "      if (count === 0) {\n" +
                "        callback('true');\n" +
                "      }\n" +
                "    };\n" +
                "    testabilities.forEach(function(testability) {\n" +
                "      testability.whenStable(decrement);\n" +
                "    });\n" +
                "  } catch (err) {\n" +
                "    callback('false');\n" +
                "  }";

            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            String isProcessingFinished = javascriptExecutor.executeAsyncScript(hasAngularFinishedScript).toString();
            //System.out.println("test--"+isProcessingFinished);
            return Boolean.valueOf(isProcessingFinished);
            }
        };
    }
    
    public void appWait(){
        wait.until(this.angularHasFinishedProcessing());
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public WebDriver getDriver(){
       return driver;
    }

    public void closeOut(){
        driver.quit();
    }
}