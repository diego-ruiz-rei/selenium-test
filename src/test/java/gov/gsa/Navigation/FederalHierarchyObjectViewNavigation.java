package gov.gsa.Navigation;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.ObjectView;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Created by RKumar on 2/21/2017.
 */
public class FederalHierarchyObjectViewNavigation extends ObjectView{
    public static void gotoFHObjectView(String opp_SearchTerm) throws InterruptedException {
        Base.driver.findElement(By.cssSelector(".search-inputbar")).clear();
        Thread.sleep(2000);
        Base.driver.findElement(By.cssSelector(".search-inputbar")).sendKeys(opp_SearchTerm);
        new Select(Base.driver.findElement(By.id("filter"))).selectByVisibleText("Federal Hierarchy");
        Base.driver.findElement(By.cssSelector(".search-btn")).click();
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".federal-hierarchy-title > a")));
        Base.driver.findElement(By.cssSelector(".federal-hierarchy-title > a")).click();
        WebElement title_element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".intro-section > h1")));
    }

}
