package gov.gsa.Navigation;

import gov.gsa.Utilities.Base;
import org.openqa.selenium.By;

/**
 * Created by michael.kellogg on 12/7/16.
 */
public class SearchNavigation{
    public static void goToSearch() throws InterruptedException{
        Base.driver.findElement(By.cssSelector(".search-btn")).click();
        Thread.sleep(1000);
        //this.appWait();
    }
}
