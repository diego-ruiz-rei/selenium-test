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

    public static void searchResults(String index, String searchTerm) throws InterruptedException {
        Base.driver.findElement(By.cssSelector(".search-inputbar")).clear();
        Thread.sleep(2000);
        Base.driver.findElement(By.cssSelector(".search-inputbar")).sendKeys(searchTerm);
        new Select(Base.driver.findElement(By.id("filter"))).selectByVisibleText(index);
        Base.driver.findElement(By.cssSelector(".search-btn")).click();
        Thread.sleep(3000);

    }

    public static void gotoSearchResultsPage(String index, String searchTerm) throws InterruptedException {
        searchResults(index,searchTerm);
        if(!Base.driver.findElement(By.id("checkbox-active")).isSelected())
            Base.driver.findElement(By.id("checkbox-active")).click();
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
        searchResults(index,searchTerm);
        if(Base.driver.findElement(By.id("checkbox-active")).isSelected())
            Base.driver.findElement(By.id("checkbox-active")).click();
        Thread.sleep(2000);
    }

    public static void gotoSCASearch(String index,String searchTerm) throws InterruptedException {
        gotoSearchResultsPage(index,searchTerm);
        if(!Base.driver.findElement(By.id("radio-sca")).isSelected())
            Base.driver.findElement(By.id("radio-sca")).click();
        Thread.sleep(2000);
    }

    public static void gotoDBASearch(String index,String searchTerm) throws InterruptedException {
        gotoSearchResultsPage(index,searchTerm);
        if(!Base.driver.findElement(By.id("radio-dba")).isSelected())
            Base.driver.findElement(By.id("radio-dba")).click();
        Thread.sleep(2000);
    }

}
