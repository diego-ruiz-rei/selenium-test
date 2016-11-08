package gov.gsa.cfda.auit;

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


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SelTest extends Base {

    @Test
    public void homePageElements() throws Exception{
        //Home Page test
        wait.until(angularHasFinishedProcessing());
        assertEquals("SAM Client Starter", driver.getTitle());
        System.out.println("--Home Page Elements--");
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
        System.out.println("--Search Results Page - Search All--");
        System.out.println("Number of result Found in Search Page : "+driver.findElements(By.cssSelector(".m_T-5x")).size());
        assertEquals(10,driver.findElements(By.cssSelector(".m_T-5x")).size());

        //Check Pagination
        Assert.assertTrue(isElementPresent(By.cssSelector(".usa-button-outline")));
        assertEquals(5,driver.findElements(By.cssSelector(".usa-button-outline")).size());
        System.out.println("Pagination Size found : "+driver.findElements(By.cssSelector(".usa-button-outline")).size());
    }


    @Test
    public void searchAssistance() throws Exception {

        keywordSearch("All",AllKeywords);
        keywordSearch("Opportunities",OpportunitiesKeywords);
        keywordSearch("Assistance Listings",AssistanceKeywords);
        searchNoResult(NoKeywords);
        searchWildcard(wildcard);

    }

    public void searchWildcard(String[] keywords) {
        wait.until(angularHasFinishedProcessing());
        driver.findElement(By.cssSelector("img.marginCenter")).click();
        System.out.println("--Search Results Page - Search with Parameters--");
        //new Select(driver.findElement(By.id("filter"))).selectByVisibleText(index);
        for (int i = 0; i < keywords.length; i++) {
            driver.findElement(By.cssSelector(".search-inputbar")).sendKeys(keywords[i]);
            driver.findElement(By.cssSelector(".search-btn")).click();

            //trim quotes for exact match keywords
            keywords[i] = keywords[i].replace("\"","");

            wait.until(angularHasFinishedProcessing());
            //Check 10 records are present in Search results page
            Assert.assertTrue(isElementPresent(By.cssSelector(".m_T-5x")));
            System.out.println("--Search Results Page - Search All--");
            System.out.println("Number of result Found in Search Page : "+driver.findElements(By.cssSelector(".m_T-5x")).size());
            assertTrue(driver.findElements(By.cssSelector(".m_T-5x")).size()>1);
            System.out.println("**Search result found in Search Page ");

            //Check Pagination
            Assert.assertTrue(isElementPresent(By.cssSelector(".usa-button-outline")));
            assertEquals(5,driver.findElements(By.cssSelector(".usa-button-outline")).size());
            System.out.println("Pagination Size found : "+driver.findElements(By.cssSelector(".usa-button-outline")).size());
            driver.findElement(By.cssSelector(".search-inputbar")).clear();

        }
    }



    public void keywordSearch(String index,String[] keywords) {
        wait.until(angularHasFinishedProcessing());
        driver.findElement(By.cssSelector("img.marginCenter")).click();
        System.out.println("--Search Results Page - Search with Parameters--");
        new Select(driver.findElement(By.id("filter"))).selectByVisibleText(index);
        for (int i = 0; i < keywords.length; i++) {
            driver.findElement(By.cssSelector(".search-inputbar")).sendKeys(keywords[i]);
            driver.findElement(By.cssSelector(".search-btn")).click();

            //trim quotes for exact match keywords
            keywords[i] = keywords[i].replace("\"","");

            wait.until(angularHasFinishedProcessing());
            WebElement element;

            if (index=="Opportunities") {
                element = (WebElement) wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app/main/search/div/div[2]/div[1]/opportunities-result/div[2]/ul/li[1]/ul/li")));
            }
            else if (index=="Assistance Listings") {
                element = (WebElement) wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fal-program-number")));
            }
            else  {
                element = (WebElement) wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".assistance-listing-title")));
            }

            System.out.println("Search Index : "+index);
            System.out.println("Search Parameter : "+element.getText());
            assertEquals(keywords[i], element.getText());
            driver.findElement(By.cssSelector(".search-inputbar")).clear();

        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }


    public void searchNoResult(String[] keywords) throws Exception{

        wait.until(angularHasFinishedProcessing());
        driver.findElement(By.cssSelector("img.marginCenter")).click();
        System.out.println("--Search Results Page - No Results found--");
        //new Select(driver.findElement(By.id("filter"))).selectByVisibleText(index);
        for (int i = 0; i < keywords.length; i++) {
            driver.findElement(By.cssSelector(".search-inputbar")).sendKeys(keywords[i]);
            driver.findElement(By.cssSelector(".search-btn")).click();

            //trim quotes for exact match keywords
            keywords[i] = keywords[i].replace("\"","");

            wait.until(angularHasFinishedProcessing());
            WebElement element;
            element = (WebElement) wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app/main/search/div/div[2]/div/p")));
            System.out.println("Search Parameter : "+keywords[i]);
            assertEquals("No results found for '"+keywords[i]+"'", element.getText());

            driver.findElement(By.cssSelector(".search-inputbar")).clear();

        }
    }


    /*
    @Test
    public void simpleFALTest(){
        //simple fal title check test
        wait.until(angularHasFinishedProcessing());
        driver.findElement(By.cssSelector(".search-inputbar")).sendKeys("11.111");
        driver.findElement(By.cssSelector(".search-btn")).click();
        wait.until(angularHasFinishedProcessing());
        WebElement element = (WebElement) wait.until(
                //ExpectedConditions.visibilityOfElementLocated(By.tagName("assistance-listing-result")));
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".assistance-listing-title")));
        WebElement specificEl = element.findElement(By.tagName("a"));
        specificEl.click();
        wait.until(angularHasFinishedProcessing());
        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println(title.getText());
        assertEquals("Foreign-Trade Zones in the United States",title.getText());
    }
    */
}
