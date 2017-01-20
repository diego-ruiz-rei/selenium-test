package gov.gsa.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class Base{
    public static WebDriver driver;
    private static String chromedriverbin = "";
    private static String phantomjsbin = "/usr/bin/phantomjs";
    private static String base_url = System.getProperty("siteTarget");
    private static String port = "80";
    public static String full_url = "";
    public static FluentWait wait;

    public static void setUp() {
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
        full_url = url;
        driver.get(url);
        waitForJSandJQueryToLoad();

        wait = new FluentWait(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
    }

    private static boolean waitForJSandJQueryToLoad() {
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

    // REPLACE THIS STATEMENT WITH DRIVER.FINDELEMENTSBYID
//    public boolean isElementPresent(By by) {
//        try {
//            driver.findElement(by);
//            return true;
//        } catch (NoSuchElementException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }



    public static WebDriver getDriver(){
        return driver;
    }

    public static void closeOut(){
        driver.quit();
    }
}