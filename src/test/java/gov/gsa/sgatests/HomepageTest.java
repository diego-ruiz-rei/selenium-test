package gov.gsa.sgatests;

import gov.gsa.sga.Base;
import gov.gsa.sga.HomePage;
import org.junit.*;
import org.openqa.selenium.By;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertEquals;

public class HomepageTest {
    static HomePage home = new HomePage();

    @BeforeClass
    public static void start() throws InterruptedException {
        try {
            home.gotoHomePage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void homePageElements() throws Exception {
       //Home Page test
       home.appWait();
       assertEquals("SAM Client Starter", home.getPageTitle());
       System.out.println("\nHome Page is Present and Title matches");
    }

    @Test
    public void homeDropdown() throws Exception {
        //Search By Index Dropdown test
        home.appWait();
        //assertTrue((home.isElementPresent(By.id("filter"))));
        assertTrue(home.filterDropdown());
        assertEquals("All", home.defaultOption("option"));
        assertEquals("Opportunities", home.specificOption("fbo"));
        assertEquals("Assistance Listings", home.specificOption("cfda"));
        assertEquals("Federal Hierarchy", home.specificOption("fh"));
        assertEquals("Entities", home.specificOption("ent"));

        System.out.println("\nIndex Dropdown Present and Values Match");
    }

    @Test
    public void searchBar() throws Exception {
        //Search Box Present
        assertTrue(home.searchInputBar());
        System.out.println("\nSearch Bar present");
    }

    @Test
    public void searchButton() throws Exception {
        //Search Button Present
        assertTrue(home.searchButton());
        System.out.println("\nSearch Button present");
    }

    @AfterClass
    public static void end(){
        home.closeOut();
    }
}
