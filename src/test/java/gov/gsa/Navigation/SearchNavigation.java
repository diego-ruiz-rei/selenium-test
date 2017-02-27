package gov.gsa.Navigation;

import gov.gsa.Utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SearchNavigation{
    public static void goToSearch() throws InterruptedException{
        Base.driver.findElement(By.cssSelector(".search-btn")).click();
        Thread.sleep(1000);
        //this.appWait();
    }

    public static void gotoSearchResultsPage(String index, String searchTerm) throws InterruptedException {
        Base.driver.findElement(By.cssSelector(".search-inputbar")).clear();
        Thread.sleep(2000);
        Base.driver.findElement(By.cssSelector(".search-inputbar")).sendKeys(searchTerm);
        new Select(Base.driver.findElement(By.id("filter"))).selectByVisibleText(index);
        Base.driver.findElement(By.cssSelector(".search-btn")).click();
        Thread.sleep(2000);
    }

    public static void gotoAutoComplete(String index,String searchTerm) throws InterruptedException {
        Base.driver.findElement(By.cssSelector(".search-inputbar")).clear();
        Thread.sleep(2000);
        new Select(Base.driver.findElement(By.id("filter"))).selectByVisibleText(index);
        Base.driver.findElement(By.cssSelector(".search-inputbar")).sendKeys(searchTerm);
        Thread.sleep(2000);
    }

    public static void gotoIsActiveFalseSearch(String index,String searchTerm) throws InterruptedException {
        Base.driver.findElement(By.cssSelector(".search-inputbar")).clear();
        Thread.sleep(2000);
        new Select(Base.driver.findElement(By.id("filter"))).selectByVisibleText(index);
        Base.driver.findElement(By.cssSelector(".search-inputbar")).sendKeys(searchTerm);
        Thread.sleep(2000);
        Base.driver.findElement(By.cssSelector(".search-btn")).click();
        if(Base.driver.findElement(By.id("checkbox-active")).isSelected())
            Base.driver.findElement(By.id("checkbox-active")).click();
        Thread.sleep(2000);
    }
}
