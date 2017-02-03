package gov.gsa.Tests;

import gov.gsa.Navigation.FederalHierarchySearchNavigation;
import gov.gsa.Pages.FederalHierarchySearchPage;
import gov.gsa.Utilities.Base;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FederalHierarchySearchTest extends Base {


    // Any variables needed here

    @BeforeClass
    public static void start() throws InterruptedException {
        setUp();
    }

    // empty search
    @Test
    public void emptySearchTestTag() throws InterruptedException {
        FederalHierarchySearchNavigation.gotoFhObjectView("");
        System.out.println(FederalHierarchySearchPage.fhTag());
        assertEquals(FederalHierarchySearchPage.fhTag(), "FEDERAL HIERARCHY");
        System.out.println("Federal Hierarchy tag exists");
    }

    // empty search checks for more than 1 page
    @Test
    public void emptySearchTestPagination() throws InterruptedException {
        FederalHierarchySearchNavigation.gotoFhObjectView("");
        System.out.println(FederalHierarchySearchPage.fhResultPageCount());
        assertTrue("fh results are greater than one page", FederalHierarchySearchPage.fhResultPageCount() > 1);
        System.out.println("fh results are greater than 1 page");
    }

    // uses search term
    @Test
    public void testSearchTerm() throws InterruptedException {
        FederalHierarchySearchNavigation.gotoFhObjectView("agriculture, department of");
        System.out.println(FederalHierarchySearchPage.fhTag());
        assertEquals(FederalHierarchySearchPage.fhTag(), "FEDERAL HIERARCHY");
        System.out.println("Federal Hierarchy tag exists");
    }

    // checks to see if first search item has the search keywords
    @Test
    public void testSearchTermTitle() throws InterruptedException {
        //FederalHierarchySearchNavigation.gotoFhObjectView("agriculture, department of");
        System.out.println(FederalHierarchySearchPage.firstResultTitle());
        assertEquals(FederalHierarchySearchPage.firstResultTitle(), "AGRICULTURE, DEPARTMENT OF");
        System.out.println("First Search Item Is Correct");
    }

    // checking if autocomplete window exists
    @Test
    public void testAutocomplete() throws InterruptedException{
        FederalHierarchySearchNavigation.gotoAutoComplete("dep");
        assertTrue(FederalHierarchySearchPage.autocompleteExists());
        System.out.println("AutoComplete present");
    }


    // checks to see if featured search returned title that was searched for
    @Test
    public void testFeaturedResultTitle() throws InterruptedException {
        FederalHierarchySearchNavigation.gotoFhObjectView("FEDERAL BUREAU OF INVESTIGATION");
        System.out.println(FederalHierarchySearchPage.featuredResultTitle());
        assertEquals(FederalHierarchySearchPage.featuredResultTitle(), "FEDERAL BUREAU OF INVESTIGATION");
        System.out.println("Federal Hierarchy tag exists");
    }

    // checks if fields present in search result
    @Test
    public void testFeaturedResultFields() throws InterruptedException {
        FederalHierarchySearchNavigation.gotoFhObjectView("assistant administrator for enforcement");
        System.out.println(FederalHierarchySearchPage.resultTitle());
        System.out.println(FederalHierarchySearchPage.resultDescription());
        System.out.println(FederalHierarchySearchPage.resultDepartment());
        System.out.println(FederalHierarchySearchPage.resultSubTier());
        System.out.println(FederalHierarchySearchPage.resultAlsoKnownAs());

        assertTrue(FederalHierarchySearchPage.resultTitle().length() > 0);
        System.out.println("Result Title Exists");

        assertTrue(FederalHierarchySearchPage.resultDescription().length() > 0);
        System.out.println("Result Description Exists");

        assertTrue(FederalHierarchySearchPage.resultDepartment().length() > 0);
        System.out.println("Result Department Exists");

        assertTrue(FederalHierarchySearchPage.resultSubTier().length() > 0);
        System.out.println("Result SubTier Exists");

        assertTrue(FederalHierarchySearchPage.resultAlsoKnownAs().length() > 0);
        System.out.println("Result Also Known As Exists");
    }

    @Test
    public void testFpdsOrgId() throws InterruptedException {
        FederalHierarchySearchNavigation.gotoFhObjectView("agriculture, department of");
        System.out.println(FederalHierarchySearchPage.organizationTypeCode());

        // check that type code exists
        assertTrue(FederalHierarchySearchPage.organizationTypeCode().length() > 0);
        System.out.println("fpds org id exists");

        // check that type code equals what we expect it to
        assertEquals(FederalHierarchySearchPage.organizationTypeCode(),"FPDS Org ID: 1200");
        System.out.println("fpds org id equals what is expected");

    }

    @Test
    public void testFpdsCode() throws InterruptedException {
        FederalHierarchySearchNavigation.gotoFhObjectView("PENSION BENEFIT GUARANTY CORPORATION");
        System.out.println(FederalHierarchySearchPage.organizationTypeCode());

        // check that type code exists
        assertTrue(FederalHierarchySearchPage.organizationTypeCode().length() > 0);
        System.out.println("Organization Type Code Exists");

        // check that type code equals what we expect it to
        assertEquals(FederalHierarchySearchPage.organizationTypeCode(),"FPDS Org ID: 1665");
        System.out.println("fOrganization Type Code equals what is expected");
    }

    @AfterClass
    public static void end(){
        closeOut();
    }

}
