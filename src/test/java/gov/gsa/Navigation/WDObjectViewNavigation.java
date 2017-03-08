package gov.gsa.Navigation;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.ObjectView;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by RKumar on 3/7/2017.
 */
public class WDObjectViewNavigation extends ObjectView{
    public static void gotoWDObjectView(String wd_SearchTerm) throws InterruptedException {
        Base.driver.findElement(By.cssSelector(".search-inputbar")).clear();
        Thread.sleep(2000);
        Base.driver.findElement(By.cssSelector(".search-inputbar")).sendKeys(wd_SearchTerm);
        new Select(Base.driver.findElement(By.id("filter"))).selectByVisibleText("Wage Determinations");
        Base.driver.findElement(By.cssSelector(".search-btn")).click();
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".wage-determination-number > a")));
        Base.driver.findElement(By.cssSelector(".wage-determination-number > a")).click();
        WebElement title_element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#wage-determination > h1")));
    }
}
