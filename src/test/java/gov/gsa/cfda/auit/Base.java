package gov.gsa.cfda.auit;

import org.junit.After;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertEquals;

public class Base{
    protected WebDriver driver;
    protected String phantomjsbin = "/usr/bin/phantomjs";
    protected String base_url = System.getProperty("siteTarget");
    protected String port = "3000";

    @Before
    public void setUp() {
        if(!System.getProperty("phantomjsbin","").equals("")){
            phantomjsbin = System.getProperty("phantomjsbin");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setJavascriptEnabled(true);
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjsbin);
            driver = new PhantomJSDriver(caps);
        } else {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    protected boolean waitForJSandJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for jQuery to load
        /*ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    System.out.println("jquery found + loaded");
                    return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    System.out.println("jquery not found");
                    // no jQuery present
                    return true;
                }
            }
        };*/

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

    protected static ExpectedCondition angularHasFinishedProcessing() {
        System.out.println("errr");
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
                System.out.println("test--"+isProcessingFinished);
                return Boolean.valueOf(isProcessingFinished);
            }
        };
    }

    @After
    public void closeOut(){
        driver.quit();
    }
}