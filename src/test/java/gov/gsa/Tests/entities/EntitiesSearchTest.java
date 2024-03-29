package gov.gsa.Tests.entities;

import gov.gsa.Navigation.HomePageNavigation;
import gov.gsa.Navigation.SearchNavigation;
import gov.gsa.Pages.EntitiesSearchResultsPage;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.text.ParseException;

import static gov.gsa.Utilities.CommonUtils.testLabelAndDataExists;
import static gov.gsa.Utilities.CommonUtils.testLabelContains;
import static gov.gsa.Utilities.CommonUtils.*;
import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EntitiesSearchTest extends Base{

    //Test Data
    public String index = "Entity Registrations";
    public String inactive_searchTerm = "016139227";
    public String active_searchTerm = "SMITH COUNTY EMERGENCY SHELTER FOR WOMEN AND CHILDREN, INC.";
    public String autocomplete_searchTerm = "FRANKLIN, COUNTY OF";
    public String exact_searchTerm = "\"WATERSWORX, LLC\"";
    public String duns_searchTerm = "\"079756806\"";

    @BeforeClass
    public static void start() throws InterruptedException {
        setUp();
    }

    // Entities Tag
    @Test
    public void entitiesTagTest() throws InterruptedException {
       // HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertEquals("Entities Tag does not Exist",EntitiesSearchResultsPage.entitiesTag(),"Entity");
        System.out.println("Entities Tag is Present");

    }

    // Entities Inactive Tag
    @Test
    public void entitiesInactiveTagTest() throws InterruptedException {
        SearchNavigation.gotoIsActiveFalseSearch(index,inactive_searchTerm);
        assertEquals("Entities Inactive Tag does not Exist",EntitiesSearchResultsPage.entitiesInactiveTag(),"Inactive");
        System.out.println("Entities Inactive Tag is Present");
    }

    @Test
    public void DUNSNumberTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField duns = EntitiesSearchResultsPage.duns();
        testLabelAndDataExists(duns);
        testLabelContains(duns, "DUNS");
    }

    @Test
    public void NCAGECodeTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField ncage_code = EntitiesSearchResultsPage.ncageCode();
        testLabelAndDataExists(ncage_code);
        testLabelContains(ncage_code, "NCAGE Code");
    }

    @Test
    public void entityAddressTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField address = EntitiesSearchResultsPage.entityAddress();
        testLabelAndDataExists(address);
        testLabelContains(address, "Entity Address");
    }

    @Test
    public void expirationDateTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField exp_date = EntitiesSearchResultsPage.expirationDate();
        testLabelAndDataExists(exp_date);
        testLabelContains(exp_date, "Expiration Date");
    }

    @Test
    public void purposeOfRegistrationTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField purpose = EntitiesSearchResultsPage.purposeOfRegistration();
        testLabelAndDataExists(purpose);
        testLabelContains(purpose, "Purpose of Registration");
    }

    @Test
    public void delinquentFederalDebtTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField federal = EntitiesSearchResultsPage.delinquentFederalDebt();
        testLabelAndDataExists(federal);
        testLabelContains(federal, "Delinquent Federal Debt:");
    }

    // Test Autocomplete
    @Test
    public void autoCompleteTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertTrue(CommonUtils.autoCompleteExists(index,autocomplete_searchTerm));
    }


    //Pagination test
    @Test
    public void paginationTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertTrue("Entities Pagination Does not exist", EntitiesSearchResultsPage.resultsPageCount() > 1);
        System.out.println("Entities Pagination on Empty Search exists");
    }

    // exact Match test
    @Test
    public void exactMatchTitleTest() throws InterruptedException {
        exact_searchTerm = exact_searchTerm.replace("\"","");
        System.out.println("Input Search Term : "+ exact_searchTerm);
        SearchNavigation.gotoSearchResultsPage(index,exact_searchTerm);
        assertEquals("Entities Exact match NOT found on Title",EntitiesSearchResultsPage.entitiesTitle(), exact_searchTerm);
        System.out.println("Entities Exact match found on Title");
    }

    // DUNS exact Match test
    @Test
    public void searchOnDUNSTest() throws InterruptedException {
        duns_searchTerm = duns_searchTerm.replace("\"","");
        System.out.println("Input DUNS Search Term : "+ duns_searchTerm);
        SearchNavigation.gotoSearchResultsPage(index,duns_searchTerm);
        assertEquals("Entities Exact match NOT found on DUNS Number",EntitiesSearchResultsPage.dunsExactMatch(), duns_searchTerm);
        System.out.println("Entities Exact match found on DUNS Number");
    }

    //total results
    @Test
    public void resultNumberTest() throws InterruptedException, ParseException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertTrue("Message does not exist", CommonUtils.extractTotalResults() >= 1);
    }

    @After
    public void clearFilter(){

        EntitiesSearchResultsPage.clearAll();
    }


    @AfterClass
    public static void end(){
        closeOut();
    }

}
