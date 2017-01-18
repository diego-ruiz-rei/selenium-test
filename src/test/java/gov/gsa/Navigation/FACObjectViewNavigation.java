package gov.gsa.Navigation;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.ObjectView;
import org.junit.BeforeClass;
import org.openqa.selenium.By;

/**
 * Created by michael.kellogg on 12/7/16.
 */
public class FACObjectViewNavigation extends ObjectView{

    //FAL Number - 20.218, 14.248
    private static String FACSearchTerm = "93.155";

    public static void gotoFACObjectView() throws InterruptedException {
        //driver.get(base_url + "programs/610e64ea171eeff29c952688eaf3c7e4/view");
        System.out.println("Search results page");
        Thread.sleep(1000);
        Base.driver.findElement(By.cssSelector(".search-inputbar")).sendKeys(FACSearchTerm);
        Base.driver.findElement(By.cssSelector(".search-btn")).click();
        Thread.sleep(1000);
        Base.driver.findElement(By.cssSelector(".assistance-listing-title > a")).click();
        Thread.sleep(1000);
        //this.appWait();
    }

}
