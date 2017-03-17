package gov.gsa.Tests.assistanceListings;

import gov.gsa.Navigation.SearchNavigation;
import gov.gsa.Pages.AssistanceListingSearchPage;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static gov.gsa.Utilities.CommonUtils.testLabelAndDataExists;
import static gov.gsa.Utilities.CommonUtils.testLabelContains;
import static gov.gsa.Utilities.CommonUtils.*;
import static org.junit.Assert.*;

/**
 * Created by RKumar on 2/28/2017.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssistanceListingSearchTest extends Base{
    //Test Data
    public String index = "Assistance Listings";
    public String historical_searchTerm = "97.060";
    public String active_searchTerm = "16.025";
    public String autocomplete_searchTerm = "cooperating technical partners";
    public String exact_searchTerm ="Partners for Fish and Wildlife";


    @BeforeClass
    public static void start() throws InterruptedException {
        setUp();
    }

    // Assistance Tag
    @Test
    public void assistanceTagTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertEquals("Federal Assistance Listing Tag does not Exist", AssistanceListingSearchPage.assistanceTag(),"FEDERAL ASSISTANCE LISTING");
        System.out.println("Federal Assistance Listing Tag is Present");

    }

    // Assistance Historical Index Tag
    @Test
    public void historicalTagTest() throws InterruptedException {
        SearchNavigation.gotoIsActiveFalseSearch(index,historical_searchTerm);
        assertEquals("Assistance Historical Tag does not Exist",AssistanceListingSearchPage.historicalTag(),"HISTORICAL");
        System.out.println("Assistance Historical Tag is Present");
    }


    // checking pagination is greater than 0
    @Test
    public void paginationTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, " ");
        assertTrue("Pagination does not Exist", AssistanceListingSearchPage.resultsPageCount() > 1);
        System.out.println("Search results and Pagination exists");
    }

    // keyword search - tests if search string exists in the title
    @Test
    public void keywordSearchTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,"\""+exact_searchTerm+"\"");
        System.out.println(AssistanceListingSearchPage.title());
        assertEquals("Assistance Title does not match with Search term",AssistanceListingSearchPage.title(), exact_searchTerm);
    }

    // auto complete - tests if autocomplete exists
    @Test
    public void autoCompleteTest() throws InterruptedException {
        assertTrue(CommonUtils.autoCompleteExists(index,autocomplete_searchTerm));
    }

    //Description
    @Test
    public void descriptionTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        System.out.println(AssistanceListingSearchPage.description());
        assertTrue("Assistance Listing Description does not exist",AssistanceListingSearchPage.description().length() > 0);
    }

    //CFDA Number
    @Test
    public void cfdaNumberTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField cfda_number = AssistanceListingSearchPage.cfdaNumber();
        testLabelAndDataExists(cfda_number);
        testLabelContains(cfda_number, "CFDA Number");
    }

    //Department
    @Test
    public void departmentTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField dept = AssistanceListingSearchPage.department();
        testLabelAndDataExists(dept);
        testLabelContains(dept, "Department/Ind. Agency");
    }

    //Office
    @Test
    public void officeTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField office = AssistanceListingSearchPage.office();
        testLabelAndDataExists(office);
        testLabelContains(office, "Office");
    }

    //Funded
    @Test
    public void fundedTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField funded = AssistanceListingSearchPage.funded();
        testLabelAndDataExists(funded);
        testLabelContains(funded, "Funded");
    }

    //last date modified
    @Test
    public void lastDateModifiedTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField date = AssistanceListingSearchPage.lastDateModified();
        testLabelAndDataExists(date);
        testLabelContains(date, "Last Date Modified");
    }

    //Type of Assistance
    @Test
    public void typeOfAssistanceTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField type = AssistanceListingSearchPage.typeOfAssistance();
        testLabelAndDataExists(type);
        testLabelContains(type, "Type Of Assistance");
    }

    //History Section
    @Test
    public void historySectionResultsTest() throws InterruptedException {
        SearchNavigation.gotoIsActiveFalseSearch(index,historical_searchTerm);
        assertTrue("No Data in History Section",AssistanceListingSearchPage.historySectionResults() > 1);

    }

    @AfterClass
    public static void end(){
        closeOut();
    }

}