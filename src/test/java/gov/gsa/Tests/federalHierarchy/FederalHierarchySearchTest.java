package gov.gsa.Tests.federalHierarchy;

import gov.gsa.Navigation.HomePageNavigation;
import gov.gsa.Navigation.SearchNavigation;
import gov.gsa.Pages.FederalHierarchySearchPage;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.text.ParseException;

import static gov.gsa.Utilities.CommonUtils.testLabelAndDataExists;
import static gov.gsa.Utilities.CommonUtils.testLabelContains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FederalHierarchySearchTest extends Base {

    //Test Data
    public String index = "Federal Hierarchy";
    public String inactive_searchTerm = "";
    public String fh_searchTerm = "agriculture, department of Rural Utilities Service";
    public String fh_searchTitle = "agriculture, department of";
    public String autocomplete_searchTerm = "federal emergency management agency";
    public String featured_result_searchTerm = "RURAL HOUSING SERVICE";
    public String fh_cgacCode="PENSION BENEFIT GUARANTY CORPORATION";
    public String fh_searchTermFpdsCodeOld="UNITED STATES INSTITUTE OF PEACE";
    public String duns_searchTerm = "";

    // Any variables needed here

    @BeforeClass
    public static void start() throws InterruptedException {
        setUp();
    }

    // empty search
    @Test
    public void emptySearchTestTag() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,"");
        System.out.println(FederalHierarchySearchPage.fhTag());
        assertEquals(FederalHierarchySearchPage.fhTag(), "FEDERAL HIERARCHY");
        System.out.println("Federal Hierarchy tag exists");
    }

    // empty search checks for more than 1 page
    @Test
    public void emptySearchTestPagination() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,"");
        System.out.println(FederalHierarchySearchPage.fhResultPageCount());
        assertTrue("fh results are greater than one page", FederalHierarchySearchPage.fhResultPageCount() > 1);
        System.out.println("fh results are greater than 1 page");
    }

    // uses search term
    @Test
    public void testSearchTerm() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,fh_searchTerm);
        System.out.println(FederalHierarchySearchPage.fhTag());
        assertEquals(FederalHierarchySearchPage.fhTag(), "FEDERAL HIERARCHY");
        System.out.println("Federal Hierarchy tag exists");
    }

    // checks to see if first search item has the search keywords
    @Test
    public void testSearchTermTitle() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,fh_searchTerm);
        System.out.println(FederalHierarchySearchPage.firstResultTitle());
        assertTrue(FederalHierarchySearchPage.firstResultTitle().equalsIgnoreCase(fh_searchTitle));
        System.out.println("First Search Item Is Correct");
    }

    // checking if autocomplete window exists
    @Test
    public void autoCompleteTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        assertTrue(CommonUtils.autoCompleteExists(index,autocomplete_searchTerm));
    }


    // checks to see if featured search returned title that was searched for
    @Test
    public void testFeaturedResultTitle() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,featured_result_searchTerm);
        System.out.println(FederalHierarchySearchPage.featuredResultTitle());
        assertEquals(FederalHierarchySearchPage.featuredResultTitle(), featured_result_searchTerm);
        System.out.println("Federal Hierarchy tag exists");
    }

    // checks if fields present in search result
    @Test
    public void featuredResultTitleTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, featured_result_searchTerm);
        assertTrue(FederalHierarchySearchPage.resultTitle().length() > 0);
        System.out.println("Result Title Exists");
    }

    @Test
    public void featuredResultDescriptionTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, featured_result_searchTerm);
        System.out.println(FederalHierarchySearchPage.resultDescription());
        assertTrue(FederalHierarchySearchPage.resultDescription().length() > 0);
        System.out.println("Result Description Exists");
    }

/*
        System.out.println(FederalHierarchySearchPage.resultDepartment());
        System.out.println(FederalHierarchySearchPage.resultSubTier());
        System.out.println(FederalHierarchySearchPage.resultAlsoKnownAs());


        assertTrue(FederalHierarchySearchPage.resultDepartment().length() > 0);
        System.out.println("Result Department Exists");

        assertTrue(FederalHierarchySearchPage.resultSubTier().length() > 0);
        System.out.println("Result SubTier Exists");

        assertTrue(FederalHierarchySearchPage.resultAlsoKnownAs().length() > 0);
        System.out.println("Result Also Known As Exists");
    }
*/

    //check fpds org id label and value
    /*@Test
    public void fpdsOrgIdTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,fh_searchTerm);
        CommonUtils.DataField fpdsFieldText = FederalHierarchySearchPage.testFpdsOrg();
        testLabelAndDataExists(fpdsFieldText);s
        testLabelContains(fpdsFieldText, "FPDS Org ID");
    }*/

    //test for fpds code label and value
    /*@Test
    public void fpdsOrgCodeTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,fh_searchTermFpdsCode);
        CommonUtils.DataField fpdsCodeFieldText = FederalHierarchySearchPage.testFpdsCode();
        testLabelAndDataExists(fpdsCodeFieldText);
        testLabelContains(fpdsCodeFieldText, "FPDS Code");
    }*/

    //todo : Find test data
    //test for fpds code(old) label. Does not check for value
    /*@Test
    public void fpdsOrgCodeOldTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,fh_searchTermFpdsCodeOld);
        CommonUtils.DataField fpdsCodeOldFieldText = FederalHierarchySearchPage.testFpdsCodeOld();
        //testLabelAndDataExists(fpdsCodeOldFieldText);
        testLabelContains(fpdsCodeOldFieldText, "FPDS Code (Old)");
    }*/





    /*//@Test
    public void testFpdsCode() throws InterruptedException {
        FederalHierarchySearchNavigation.gotoFhObjectView("PENSION BENEFIT GUARANTY CORPORATION");
        System.out.println(FederalHierarchySearchPage.organizationTypeCode());

        // check that type code exists
        assertTrue(FederalHierarchySearchPage.organizationTypeCode().length() > 0);
        System.out.println("Organization Type Code Exists");

        // check that type code equals what we expect it to
        assertEquals(FederalHierarchySearchPage.organizationTypeCode(),"FPDS Org ID: 1665");
        System.out.println("fOrganization Type Code equals what is expected");
    }*/

    // test for title
    @Test
    public void titleTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,fh_searchTerm);
        assertTrue("Title Does not exist", FederalHierarchySearchPage.extractTitle());
    }

    //test for description
    @Test
    public void descriptionTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,fh_searchTerm);
        assertTrue("Description Does not exist", FederalHierarchySearchPage.extractDescription());
    }

    //Test for Department
    @Test
    public void departmentTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,fh_searchTerm);
        CommonUtils.DataField deptField = FederalHierarchySearchPage.departmentCheck();
        testLabelAndDataExists(deptField);
        testLabelContains(deptField, "Department");

    }

    //Test for sub-tier label
    @Test
    public void subTierTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,fh_searchTerm);
        assertEquals(FederalHierarchySearchPage.subTierCheck(), "Sub-Tier");
    }


    //Test for "also known as" label and data
    @Test
    public void aliasNameTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,fh_searchTerm);
        assertEquals("Also Known as Tag does not Exist", FederalHierarchySearchPage.aliasNameCheck(),"Also Known As:");

    }

    //total results
    @Test
    public void resultNumberTest() throws InterruptedException, ParseException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertTrue("Message does not exist", CommonUtils.extractTotalResults() >= 1);
    }

    @Test
    public void cgacCodeFeaturedResultTest() throws InterruptedException{
        SearchNavigation.gotoSearchResultsPage(index,fh_cgacCode);
        System.out.println(FederalHierarchySearchPage.checkCgacCodeFeaturedResult());

    }

    @Test
    public void cgacCodeDepartmentTest() throws InterruptedException{

    }

    @Test
    public void cgacCodeSubTierTest() throws InterruptedException{

    }



    @AfterClass
    public static void end(){
        closeOut();
    }

}
