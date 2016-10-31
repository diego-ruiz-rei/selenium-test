package gov.gsa.cfda.auit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertEquals;

public class SelTest extends Base {

    @Test
    public void simpleTest() throws Exception{
        //load homepage and run tasks
        String url = base_url+":"+port;
        driver.get(url);
        waitForJSandJQueryToLoad();

        FluentWait wait = new FluentWait(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(200, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        //simple search test
        wait.until(angularHasFinishedProcessing());
        driver.findElement(By.cssSelector(".search-inputbar")).sendKeys("11.111");
        driver.findElement(By.cssSelector(".search-btn")).click();
        wait.until(angularHasFinishedProcessing());
        WebElement element = (WebElement) wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".search-result-list-item")));
        WebElement specificEl = element.findElement(By.cssSelector(".fal-program-number"));
        System.out.println(specificEl.getText());
        assertEquals("11.111",specificEl.getText());
    }

}
