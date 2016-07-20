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

        wait.until(angularHasFinishedProcessing());

        //switch to super user
        driver.findElement(By.linkText("Sign In As")).click();
        WebElement modal = driver.findElement(By.id("ngdialog1"));
        Select userSelect = new Select (modal.findElement(By.tagName("select")));
        userSelect.selectByVisibleText("Super User");
        modal.findElement(By.tagName("button")).click();
        wait.until(angularHasFinishedProcessing());
        System.out.println(driver.getTitle());
        assertEquals("Home - CFDA: Home",driver.getTitle());

        //go to programs page
        driver.get(url+"/programs");
        waitForJSandJQueryToLoad();
        wait.until(angularHasFinishedProcessing());
        System.out.println(driver.getTitle());
        assertEquals("My Listings - CFDA: My Listings",driver.getTitle());

        //go to search
        driver.get(url+"/search?keyword=10.055");
        waitForJSandJQueryToLoad();
        wait.until(angularHasFinishedProcessing());

        String loading_xpath = "//div[contains(@class,'loadingModal')]";
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loading_xpath)));

        System.out.println(driver.getTitle());
        assertEquals("Search Programs - CFDA: Search Programs",driver.getTitle());

        WebElement tableClass = driver.findElement(By.cssSelector(".dataTable"));
        String divId = tableClass.getAttribute("id");
        System.out.println(divId);
        WebElement table = driver.findElement(By.id(divId));


        String link_xpath = "//table[@id='"+divId+"']/tbody/tr/td[2]/a";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(link_xpath)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(link_xpath)));
        driver.findElement(By.xpath(link_xpath)).click();
        wait.until(angularHasFinishedProcessing());
    }

}
