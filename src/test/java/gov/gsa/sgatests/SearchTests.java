package gov.gsa.sgatests;

import gov.gsa.sga.Base;
import org.apache.bcel.generic.SWITCH;
import org.apache.xpath.operations.Or;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import java.lang.String;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SearchTests extends Base {

    @Test
    public void homePageElements() throws Exception{
        //Home Page test
        wait.until(angularHasFinishedProcessing());
        assertEquals("SAM Client Starter", driver.getTitle());
        System.out.println("\n--Home Page Elements--");
        System.out.println("Page Title : "+driver.getTitle());

        //Search By Index Dropdown test
        Assert.assertTrue((isElementPresent(By.id("filter"))));
        assertEquals("All", driver.findElement(By.cssSelector("option")).getText());
        assertEquals("Opportunities", driver.findElement(By.cssSelector("option[value=\"fbo\"]")).getText());
        assertEquals("Assistance Listings", driver.findElement(By.cssSelector("option[value=\"cfda\"]")).getText());
        System.out.println("Index Dropdown Present : "+driver.findElement(By.id("filter")).getText());

        //Search Box Present
        Assert.assertTrue(isElementPresent(By.cssSelector(".search-inputbar")));
        System.out.println("Search Bar present");

        //Search Button Present
        Assert.assertTrue(isElementPresent(By.cssSelector(".usa-search-submit-text")));
        System.out.println("Search Button present");
    }

    @Test
    public void searchAll() throws Exception{

        wait.until(angularHasFinishedProcessing());
        Assert.assertTrue(isElementPresent(By.cssSelector(".usa-search-submit-text")));
        driver.findElement(By.cssSelector(".search-btn")).click();
        wait.until(angularHasFinishedProcessing());

        //Check 10 records are present in Search results page
        Assert.assertTrue(isElementPresent(By.cssSelector(".m_T-5x")));
        System.out.println("\n--Search Results Page - Search All--");
        //System.out.println("Number of result Found in Search Page : "+driver.findElements(By.cssSelector(".m_T-5x")).size());
        assertTrue(driver.findElements(By.cssSelector(".m_T-5x")).size()>1);

        //Check Pagination
        Assert.assertTrue(isElementPresent(By.cssSelector(".page-button")));
        Assert.assertTrue(driver.findElements(By.cssSelector(".page-button")).size()>1);
        System.out.println("Pagination Size found : "+driver.findElements(By.cssSelector(".page-button")).size());
        System.out.println("Search Results Found for Empty Search !");
    }

    @Test
    public void search() throws Exception {
        keywordSearch(searchParameters);
    }


    public void keywordSearch(String[][] keywords) throws InterruptedException {

        wait.until(angularHasFinishedProcessing());
        System.out.println("--Search Results Page - Search with Parameters--");
        for(int i=0;i<keywords.length;i++) {
            wait.until(angularHasFinishedProcessing());

            //select index , enter search term and click on search button
            driver.findElement(By.cssSelector("img.marginCenter")).click();
            new Select(driver.findElement(By.id("filter"))).selectByVisibleText(keywords[i][0]);
            driver.findElement(By.cssSelector(".search-inputbar")).sendKeys(keywords[i][1]);
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(".search-btn")).click();
            Thread.sleep(1000);

            //trim quotes for exact match keywords
            keywords[i][1] = keywords[i][1].replace("\"", "");

            WebElement element = null;

            //check any search results found
            if (driver.findElements(By.cssSelector(".m_T-5x")).size() >= 1) {
                if (keywords[i][2] == "number") {
                    //check for Solicitation Number
                    if (driver.findElement(By.cssSelector(".m_B-0")).getText().contains("Solicitation Number")) {
                        element = (WebElement) wait.until(
                                ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/app/main/search/div/div[2]/div[2]/opportunities-result/div[2]/ul/li[1]/ul/li")));
                        //    ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app/main/search/div/div[2]/div[1]/opportunities-result/div[2]/ul/li[1]/ul/li")));
                    }
                    //check for FAL Number
                    else {
                        element = (WebElement) wait.until(
                                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fal-program-number")));
                    }
                    assertEquals(keywords[i][1], element.getText());

                } else if (keywords[i][2] == "title") {
                    //check for title element
                    element = (WebElement) wait.until(
                            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".assistance-listing-title")));
                    assertEquals(keywords[i][1], element.getText());

                } else if ((keywords[i][2] == "wildcard") || (keywords[i][2] == "all")) {

                    element = (WebElement) wait.until(
                            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".assistance-listing-title")));
                    //check number of search result is greater than 1 and Pagination exists
                    assertTrue(driver.findElements(By.cssSelector(".m_T-5x")).size() > 1);
                    Assert.assertTrue(isElementPresent(By.cssSelector(".page-button")));
                    assertTrue(driver.findElements(By.cssSelector(".page-button")).size()>1);

                }

                System.out.println("\nSearch Index : " + keywords[i][0]);
                System.out.println("Search Parameter : " + keywords[i][1]);
                System.out.println("Element in Search Results Page : " + element.getText());
                System.out.println("Search Result Found for Search term !");

                driver.findElement(By.cssSelector(".search-inputbar")).clear();
            } else {
                //Check No results found message
                element = (WebElement) wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app/main/search/div/div[2]/div/p")));
                System.out.println("\nSearch Parameter : "+keywords[i][1]);
                assertEquals("No results found for '"+keywords[i][1]+"'", element.getText());
                System.out.println("No results Found for Search term");

                driver.findElement(By.cssSelector(".search-inputbar")).clear();
            }
        }

    }
}
