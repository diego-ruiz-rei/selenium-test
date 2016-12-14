package gov.gsa.Tests;


import gov.gsa.Navigation.SearchNavigation;
import gov.gsa.Pages.SearchPage;
import gov.gsa.Utilities.Base;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import static junit.framework.Assert.assertTrue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SearchTest extends Base{

    @BeforeClass
    public static void start() {
        setUp();
    }

    //@Test
    public void searchAll() throws Exception{

        //SearchNavigation.appWait();
        Thread.sleep(1000);
        Assert.assertTrue(Base.driver.findElements(By.cssSelector(".usa-search-submit-text")).size() > 0);

        SearchNavigation.goToSearch();

        //Check 10 records are present in Search results page
        Assert.assertTrue(Base.driver.findElements(By.cssSelector(".m_T-5x")).size() > 0);
        System.out.println("\n--Search Results Page - Search All--");
        //System.out.println("Number of result Found in Search Page : "+driver.findElements(By.cssSelector(".m_T-5x")).size());
        assertTrue(Base.driver.findElements(By.cssSelector(".m_T-5x")).size()>1);

        //Check Pagination
        Assert.assertTrue(Base.driver.findElements(By.cssSelector(".page-button")).size() > 0);
        Assert.assertTrue(Base.driver.findElements(By.cssSelector(".page-button")).size()>1);
        System.out.println("Pagination Size found : "+Base.driver.findElements(By.cssSelector(".page-button")).size());
        System.out.println("Search Results Found for Empty Search !");
    }

    @Test
    public void search() throws Exception {
        SearchPage.keywordSearch();
    }

   @After
    public void end(){
       closeOut();
    }

}
