package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class SearchPage{
    //Test Data specific to Search - Format {index,keyword,type}
    private static String[][] searchParameters = {{"All","","all"},
            {"All","Foreign-Trade Zones in the United States","title"},
            {"Assistance Listings","11.111","number"},
            //{"Opportunities","DTFANM-08-R-00058","number"},
            {"All","10.001","number"},
            {"All","8(g) State Coastal Zone","title"},
            {"All","\"Yakima River Basin Water Enhancement (YRBWE)\"","title"},
            {"Assistance Listings","11.420","number"},
            {"All","transitional *","wildcard"},
            {"Assistance Listings","97.*","wildcard"},
            {"Opportunities","12.12312","title"},
    };

//    // I don't know if this is required, may be removed
//    public SearchPage(){
//        super();
//    }

    public String[][] getSearchParameters(){
        return searchParameters;
    }

    public static void keywordSearch() throws InterruptedException {
        String[][] keywords = searchParameters;
        //this.appWait();
        Thread.sleep(1000);
        System.out.println("--Search Results Page - Search with Parameters--");
        for(int i=0;i<keywords.length;i++) {
            //this.appWait();
            Thread.sleep(1000);
            //select index , enter search term and click on search button
            new Select(Base.driver.findElement(By.id("filter"))).selectByVisibleText(keywords[i][0]);
            Base.driver.findElement(By.cssSelector(".search-inputbar")).sendKeys(keywords[i][1]);
            Base.driver.findElement(By.cssSelector(".search-btn")).click();
            //this.appWait();
            Thread.sleep(1000);

            //trim quotes for exact match keywords
            keywords[i][1] = keywords[i][1].replace("\"", "");

            WebElement element = null;

            //check any search results found
            if (Base.driver.findElements(By.cssSelector(".m_T-5x")).size() >= 1) {
                if (keywords[i][2] == "number") {
                    //check for Solicitation Number
                    if (Base.driver.findElement(By.cssSelector(".m_B-0")).getText().contains("Solicitation Number")) {
                        //TODO: add a class, xpath too unreliable (ie. when agency filter is/isn't present)
                        element = (WebElement) Base.wait.until(
                                ExpectedConditions.visibilityOfElementLocated(By.id("solicitation-number")));

                    }
                    //check for FAL Number
                    else {
                        element = (WebElement) Base.wait.until(
                                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fal-program-number")));
                        assertEquals(keywords[i][1], element.getText());
                    }
                    //assertEquals(keywords[i][1], element.getText());

                } else if (keywords[i][2] == "title") {
                    //check for title element
                    element = (WebElement) Base.wait.until(
                            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".assistance-listing-title")));
                    assertEquals(keywords[i][1], element.getText());

                } else if ((keywords[i][2] == "wildcard") || (keywords[i][2] == "all")) {

                    element = (WebElement) Base.wait.until(
                            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".assistance-listing-title")));
                    //check number of search result is greater than 1 and Pagination exists
                    assertTrue(Base.driver.findElements(By.cssSelector(".m_T-5x")).size() > 1);
                    Assert.assertTrue(Base.driver.findElements(By.cssSelector(".page-button")).size() > 0);
                    assertTrue(Base.driver.findElements(By.cssSelector(".page-button")).size()>1);

                }

                System.out.println("\nSearch Index : " + keywords[i][0]);
                System.out.println("Search Parameter : " + keywords[i][1]);
                System.out.println("Element in Search Results Page : " + element.getText());
                System.out.println("Search Result Found for Search term !");

                Base.driver.findElement(By.cssSelector(".search-inputbar")).clear();
            } else {
                //Check No results found message
                element = (WebElement) Base.wait.until(
                        ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".no-results-found")));
                System.out.println("\nSearch Parameter : "+keywords[i][1]);
                assertTrue(("No results found for '"+keywords[i][1]+"'").contains(element.getText()));
                System.out.println("No results Found for Search term");

                Base.driver.findElement(By.cssSelector(".search-inputbar")).clear();
            }

        }



    }
}
