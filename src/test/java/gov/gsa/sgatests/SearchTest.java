package gov.gsa.sgatests;

import gov.gsa.sga.Base;
import gov.gsa.sga.Search;
import org.apache.bcel.generic.SWITCH;
import org.apache.xpath.operations.Or;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.runners.MethodSorters;

import java.lang.String;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SearchTest {

    Search search = new Search();

    @Test
    public void searchAll() throws Exception{

        search.appWait();
        Assert.assertTrue(search.isElementPresent(By.cssSelector(".usa-search-submit-text")));

        search.goToSearch();

        //Check 10 records are present in Search results page
        Assert.assertTrue(search.isElementPresent(By.cssSelector(".m_T-5x")));
        System.out.println("\n--Search Results Page - Search All--");
        //System.out.println("Number of result Found in Search Page : "+driver.findElements(By.cssSelector(".m_T-5x")).size());
        assertTrue(search.getDriver().findElements(By.cssSelector(".m_T-5x")).size()>1);

        //Check Pagination
        Assert.assertTrue(search.isElementPresent(By.cssSelector(".page-button")));
        Assert.assertTrue(search.getDriver().findElements(By.cssSelector(".page-button")).size()>1);
        System.out.println("Pagination Size found : "+search.getDriver().findElements(By.cssSelector(".page-button")).size());
        System.out.println("Search Results Found for Empty Search !");
    }

    @Test
    public void search() throws Exception {
        search.keywordSearch();
    }

    @After
    public void end(){
        search.closeOut();
    }



}
