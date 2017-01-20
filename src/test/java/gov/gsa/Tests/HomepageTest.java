package gov.gsa.Tests;

import gov.gsa.Navigation.HomePageNavigation;
import gov.gsa.Pages.HomePage;
import gov.gsa.Utilities.Base;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class HomepageTest extends Base{

    @BeforeClass
    public static void start() throws InterruptedException {

        setUp();

        try {
            HomePageNavigation.gotoHomePage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void homePageElements() throws Exception {
       //Home Page test
       //HomePage.appWait();
       assertEquals("SAM Client Starter", HomePage.getPageTitle());
       System.out.println("\nHome Page is Present and Title matches");
    }

    @Test
    public void homeDropdown() throws Exception {
        //Search By Index Dropdown test
        //HomePage.appWait();
        //assertTrue((HomePage.isElementPresent(By.id("filter"))));
        assertTrue(HomePage.filterDropdownExists());
        assertEquals("All", HomePage.defaultOption("option"));
        assertEquals("Opportunities", HomePage.specificOption("opp"));
        assertEquals("Assistance Listings", HomePage.specificOption("cfda"));
        assertEquals("Federal Hierarchy", HomePage.specificOption("fh"));
        assertEquals("Entities", HomePage.specificOption("ent"));
        assertEquals("Exclusions", HomePage.specificOption("ex"));
        assertEquals("Wage Determinations", HomePage.specificOption("wd"));

        System.out.println("\nIndex Dropdown Present and Values Match");
    }

    @Test
    public void searchBar() throws Exception {
        //Search Box Present
        assertTrue(HomePage.searchInputBarExists());
        System.out.println("\nSearch Bar present");
    }

    @Test
    public void searchButton() throws Exception {
        //Search Button Present
        assertTrue(HomePage.searchButtonExists());
        System.out.println("\nSearch Button present");
    }

    @AfterClass
    public static void end(){
        closeOut();
    }
}
