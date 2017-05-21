package gov.gsa.Navigation;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.ObjectView;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by michael.kellogg on 12/7/16.
 */
public class OpportunitiesObjectViewNavigation extends ObjectView {

    //private static String opp_SearchTerm = "F4FRQT3091A007";
    //private static String opp_SearchTerm = "N0002404R6111";

    public static void gotoOppObjectView(String opp_SearchTerm) throws InterruptedException {
        //System.out.println("Search results page");
        Thread.sleep(2000);
        Base.driver.findElement(By.cssSelector("#search-div > form > div.relative.div-fill > div > sam-autocomplete > div > div > input")).clear();
        Thread.sleep(2000);
        Base.driver.findElement(By.cssSelector("#search-div > form > div.relative.div-fill > div > sam-autocomplete > div > div > input")).sendKeys(opp_SearchTerm);
        new Select(Base.driver.findElement(By.id("filter"))).selectByVisibleText("Contract Opportunities");
        Base.driver.findElement(By.cssSelector(".search-btn")).click();
        Thread.sleep(3000);
        Base.driver.findElement(By.cssSelector(".opportunity-title > a")).click();
        Thread.sleep(4000);
        // this.appWait();
    }

    public static void gotoOppObjectViewByID(String opp_noticeId) throws InterruptedException {
        Base.driver.get(full_url + "/opportunities/" + opp_noticeId);
        Thread.sleep(2000);

    }

}
