package gov.gsa.Navigation;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.ObjectView;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by michael.kellogg on 12/7/16.
 */
public class OpportunitiesObjectViewNavigation extends ObjectView {

    private static String opp_SearchTerm = "F4FRQT3091A007";

    public static void gotoOppObjectView() throws InterruptedException {
        //System.out.println("Search results page");
        Thread.sleep(1000);
        Base.driver.findElement(By.name("search")).sendKeys(opp_SearchTerm);
        new Select(Base.driver.findElement(By.id("filter"))).selectByVisibleText("Opportunities");
        Base.driver.findElement(By.cssSelector(".search-btn")).click();
        Thread.sleep(1000);
        Base.driver.findElement(By.cssSelector(".opportunity-title > a")).click();
        Thread.sleep(1000);
        // this.appWait();
    }

}
