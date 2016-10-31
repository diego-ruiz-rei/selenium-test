package gov.gsa.cfda.auit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertEquals;

public class SelTest extends Base {
    @Test
    public void simpleTest() throws Exception{
        //simple search fal number check test
        wait.until(angularHasFinishedProcessing());
        driver.findElement(By.cssSelector(".search-inputbar")).sendKeys("11.111");
        driver.findElement(By.cssSelector(".search-btn")).click();
        wait.until(angularHasFinishedProcessing());
        WebElement element = (WebElement) wait.until(
                //ExpectedConditions.visibilityOfElementLocated(By.tagName("assistance-listing-result")));
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fal-program-number")));
        //WebElement specificEl = element.findElement(By.cssSelector(".fal-program-number"));
        System.out.println(element.getText());
        assertEquals("11.111",element.getText());
    }
    @Test
    public void simpleFALTest(){
        //simple fal title check test
        wait.until(angularHasFinishedProcessing());
        driver.findElement(By.cssSelector(".search-inputbar")).sendKeys("11.111");
        driver.findElement(By.cssSelector(".search-btn")).click();
        wait.until(angularHasFinishedProcessing());
        WebElement element = (WebElement) wait.until(
                //ExpectedConditions.visibilityOfElementLocated(By.tagName("assistance-listing-result")));
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".assistance-listing-title")));
        WebElement specificEl = element.findElement(By.tagName("a"));
        specificEl.click();
        wait.until(angularHasFinishedProcessing());
        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println(title.getText());
        assertEquals("Foreign-Trade Zones in the United States",title.getText());
    }
}
