package gov.gsa.Navigation;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.ObjectView;
import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class FederalHierarchyObjectViewNavigation extends ObjectView {

    public static void gotoFhObjectView(String fh_SearchTerm) throws InterruptedException {
        //System.out.println("Search results page");
        //Base.driver.findElement(By.cssSelector(".search-inputbar")).clear();
        //Thread.sleep(2000);

        Base.driver.findElement(By.cssSelector(".search-inputbar")).clear();
        Thread.sleep(2000);
        Base.driver.findElement(By.cssSelector(".search-inputbar")).sendKeys(fh_SearchTerm);
        new Select(Base.driver.findElement(By.id("filter"))).selectByVisibleText("Federal Hierarchy");
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
