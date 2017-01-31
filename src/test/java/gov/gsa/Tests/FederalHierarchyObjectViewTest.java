package gov.gsa.Tests;

import gov.gsa.Pages.FederalHierarchyObjectViewPage;
import gov.gsa.Pages.OpportunitiesObjectViewPage;
import gov.gsa.Utilities.Base;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import gov.gsa.Navigation.FederalHierarchyObjectViewNavigation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FederalHierarchyObjectViewTest extends Base {


    // Any variables needed here

    @BeforeClass
    public static void start() throws InterruptedException {
        setUp();
    }

    // empty search
    @Test
    public void emptySearchTestTag() throws InterruptedException {
        FederalHierarchyObjectViewNavigation.gotoFhObjectView("");
        System.out.println(FederalHierarchyObjectViewPage.fhTag());
        assertEquals(FederalHierarchyObjectViewPage.fhTag(), "FEDERAL HIERARCHY");
        System.out.println("Federal Hierarchy tag exists");
    }

    // empty search checks for more than 1 page
    @Test
    public void emptySearchTestPagination() throws InterruptedException {
        //FederalHierarchyObjectViewNavigation.gotoFhObjectView("");
        System.out.println(FederalHierarchyObjectViewPage.fhResultPageCount());
        assertTrue("fh results are greater than one page", FederalHierarchyObjectViewPage.fhResultPageCount() > 1);
        System.out.println("fh results are greater than 1 page");
    }

    // uses search term
    @Test
    public void testSearchTerm() throws InterruptedException {
        FederalHierarchyObjectViewNavigation.gotoFhObjectView("agriculture, department of");
        System.out.println(FederalHierarchyObjectViewPage.fhTag());
        assertEquals(FederalHierarchyObjectViewPage.fhTag(), "FEDERAL HIERARCHY");
        System.out.println("Federal Hierarchy tag exists");
    }

    // checks to see if first search item has the search keywords
    @Test
    public void testSearchTermTitle() throws InterruptedException {
        //FederalHierarchyObjectViewNavigation.gotoFhObjectView("agriculture, department of");
        System.out.println(FederalHierarchyObjectViewPage.firstResultTitle());
        assertEquals(FederalHierarchyObjectViewPage.firstResultTitle(), "AGRICULTURE, DEPARTMENT OF");
        System.out.println("First Search Item Is Correct");
    }

    // checking if autocomplete window exists
    @Test
    public void testAutocomplete() throws InterruptedException{
        FederalHierarchyObjectViewNavigation.gotoAutoComplete("dep");
        assertTrue(FederalHierarchyObjectViewPage.autocompleteExists());
        System.out.println("AutoComplete present");
    }


    // checks to see if featured search returned title that was searched for
    @Test
    public void testFeaturedResultTitle() throws InterruptedException {
        FederalHierarchyObjectViewNavigation.gotoFhObjectView("FEDERAL BUREAU OF INVESTIGATION");
        System.out.println(FederalHierarchyObjectViewPage.featuredResultTitle());
        assertEquals(FederalHierarchyObjectViewPage.featuredResultTitle(), "FEDERAL BUREAU OF INVESTIGATION");
        System.out.println("Federal Hierarchy tag exists");
    }

    // checks if fields present in search result
    @Test
    public void testFeaturedResultFields() throws InterruptedException {
        FederalHierarchyObjectViewNavigation.gotoFhObjectView("assistant administrator for enforcement");
        System.out.println(FederalHierarchyObjectViewPage.resultTitle());
        System.out.println(FederalHierarchyObjectViewPage.resultDescription());
        System.out.println(FederalHierarchyObjectViewPage.resultDepartment());
        System.out.println(FederalHierarchyObjectViewPage.resultSubTier());
        System.out.println(FederalHierarchyObjectViewPage.resultAlsoKnownAs());

        assertTrue(FederalHierarchyObjectViewPage.resultTitle().length() > 0);
        System.out.println("Result Title Exists");

        assertTrue(FederalHierarchyObjectViewPage.resultDescription().length() > 0);
        System.out.println("Result Description Exists");

        assertTrue(FederalHierarchyObjectViewPage.resultDepartment().length() > 0);
        System.out.println("Result Department Exists");

        assertTrue(FederalHierarchyObjectViewPage.resultSubTier().length() > 0);
        System.out.println("Result SubTier Exists");

        assertTrue(FederalHierarchyObjectViewPage.resultAlsoKnownAs().length() > 0);
        System.out.println("Result Also Known As Exists");
    }

    @Test
    public void testFpdsOrgId() throws InterruptedException {
        FederalHierarchyObjectViewNavigation.gotoFhObjectView("agriculture, department of");
        System.out.println(FederalHierarchyObjectViewPage.organizationTypeCode());

        // check that type code exists
        assertTrue(FederalHierarchyObjectViewPage.organizationTypeCode().length() > 0);
        System.out.println("fpds org id exists");

        // check that type code equals what we expect it to
        assertEquals(FederalHierarchyObjectViewPage.organizationTypeCode(),"FPDS Org ID: 1200");
        System.out.println("fpds org id equals what is expected");

    }

    @Test
    public void testFpdsCode() throws InterruptedException {
        FederalHierarchyObjectViewNavigation.gotoFhObjectView("PENSION BENEFIT GUARANTY CORPORATION");
        System.out.println(FederalHierarchyObjectViewPage.organizationTypeCode());

        // check that type code exists
        assertTrue(FederalHierarchyObjectViewPage.organizationTypeCode().length() > 0);
        System.out.println("Organization Type Code Exists");

        // check that type code equals what we expect it to
        assertEquals(FederalHierarchyObjectViewPage.organizationTypeCode(),"FPDS Org ID: 1665");
        System.out.println("fOrganization Type Code equals what is expected");
    }

    @AfterClass
    public static void end(){
        closeOut();
    }

}
