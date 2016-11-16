package gov.gsa.sga;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.seleniumemulation.IsTextPresent;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class FACObjectView extends ObjectView{

    //Test Data
    //FAL Number - 20.218
    protected String FACSearchTerm = "Motor Carrier Safety Assistance";
    //protected String FACSearchTerm = "Foreign-Trade Zones in the United States";


    public FACObjectView(){
        super();
    }

    public void gotoFACObjectView() throws InterruptedException {
        System.out.println("Search results page");
        //this.getDriver().findElement(By.name("search")).clear();
        this.getDriver().findElement(By.name("search")).sendKeys(FACSearchTerm);
        this.getDriver().findElement(By.cssSelector(".search-btn")).click();
        Thread.sleep(1000);

        System.out.println(driver.findElement(By.cssSelector(".assistance-listing-title")).getText());
        driver.findElement(By.cssSelector(".assistance-listing-title")).click();
        this.getDriver().findElement(By.linkText(FACSearchTerm)).click();
        Thread.sleep(2000);
        this.appWait();
    }

    public void FACHeader(){
        System.out.println("--Header Test--");

        assertTrue(isElementPresent(By.tagName("h1")));
        assertEquals(FACSearchTerm,this.getDriver().findElement(By.tagName("h1")).getText());
        System.out.println("FAC Object View title match with Search Term "+driver.findElement(By.tagName("h1")).getText());

        String popularname = driver.findElement(By.xpath("/html/body/app/main/ng-component/div/div/div[2]/p")).getText();
        assertTrue(popularname.contains("Popular Name:"));
        String popularnamedata = popularname.substring(popularname.lastIndexOf(':')+1).trim();
        //assertTrue(popularname.contains(popularnamedata));
        assertTrue(this.getDriver().getPageSource().contains(popularnamedata));
        System.out.println(popularname+"\nPopular Name Title and Data exists!!");

        String agencyname = driver.findElement(By.xpath("/html/body/app/main/ng-component/div/div/p/span[1]")).getText();
        assertTrue(agencyname.contains("AGENCY:"));
        String agencydata = agencyname.substring(agencyname.lastIndexOf(':')+1).trim();
        assertTrue(agencyname.contains(agencydata));
        System.out.println(agencyname+"\nAgency Name Title and Data exists!!");

        String fal = driver.findElement(By.xpath("/html/body/app/main/ng-component/div/div/p/span[2]")).getText();
        assertTrue(fal.contains("FAL Number:"));
        String faldata = fal.substring(fal.lastIndexOf(':')+1).trim();
        assertTrue(fal.contains(faldata));
        System.out.println(fal+"\nFAL Number Title and Data exists!!");

        String relatedassistance = driver.findElement(By.xpath("/html/body/app/main/ng-component/div/div/p/span[3]/strong")).getText();
        assertTrue(relatedassistance.contains("Related Federal Assistance:"));
        assertTrue(isElementPresent(By.xpath("/html/body/app/main/ng-component/div/div/p/span[3]/span")));
        System.out.println(relatedassistance+"\nRelated Assistance Title and Data exists!!");


    }

    public void getFACObjectPage() throws InterruptedException {


        Thread.sleep(2000);
        System.out.println("I am here");

      //  assertEquals("FAL Number: 11.111", driver.findElement(By.xpath("//span[2]")).getText());
      // assertEquals("FY 15FY 16 (est.)FY 17 (est.)Obligation(s)$0.0$500,000$1,000,000$1,500,000$2,000,000", driver.findElement(By.id("chart")).getText());
       assertEquals("Totals", driver.findElement(By.cssSelector("tr.totals > td")).getText());
       assertEquals("Designations", driver.findElement(By.cssSelector("h4")).getText());
       assertTrue(isElementPresent(By.cssSelector("#historyItem > p")));
    }

}
