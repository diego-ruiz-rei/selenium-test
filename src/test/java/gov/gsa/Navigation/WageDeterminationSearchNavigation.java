package gov.gsa.Navigation;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.ObjectView;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class WageDeterminationSearchNavigation extends ObjectView {

    public static void gotoWDObjectView(String wd_SearchTerm) throws InterruptedException {

        Base.driver.findElement(By.cssSelector(".search-inputbar")).clear();
        Thread.sleep(2000);
        Base.driver.findElement(By.cssSelector(".search-inputbar")).sendKeys(wd_SearchTerm);
        new Select(Base.driver.findElement(By.id("filter"))).selectByVisibleText("Wage Determinations");
        Base.driver.findElement(By.cssSelector(".search-btn")).click();
        Thread.sleep(2000);
    }

    public static void gotoAutoComplete(String fh_SearchTerm) throws InterruptedException {
        Base.driver.findElement(By.cssSelector(".search-inputbar")).clear();
        Thread.sleep(2000);
        Base.driver.findElement(By.cssSelector(".search-inputbar")).sendKeys(fh_SearchTerm);
        Thread.sleep(2000);
    }

}
