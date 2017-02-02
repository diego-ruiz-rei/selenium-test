package gov.gsa.Tests;

import gov.gsa.Navigation.SearchNavigation;
import gov.gsa.Pages.EntitiesSearchResultsPage;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import gov.gsa.Navigation.FederalHierarchyObjectViewNavigation;

import static gov.gsa.Utilities.CommonUtils.testLabelAndDataExists;
import static gov.gsa.Utilities.CommonUtils.testLabelContains;
import static gov.gsa.Utilities.CommonUtils.*;
import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EntitiesSearchTest extends Base{

    //Test Data
    public String index = "Entities";
    public String inactive_searchTerm = "ANESHIA Y. SMITH INSTITUTE FOR WOMEN AND GIRLS, INC.";
    public String active_searchTerm = "SMITH COUNTY EMERGENCY SHELTER FOR WOMEN AND CHILDREN, INC.";
    public String autocomplete_searchTerm = "res";
    public String exact_searchTerm = "\"WATERSWORX, LLC\"";
    public String duns_searchTerm = "\"079756806\"";

    @BeforeClass
    public static void start() throws InterruptedException {
        setUp();
    }

    // Entities Tag
    @Test
    public void entitiesTagTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertEquals(EntitiesSearchResultsPage.entitiesTag(),"ENTITY");
        System.out.println("Entities Tag is Present");
    }

    // Entities Inactive Tag
    @Test
    public void entitiesInactiveTagTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,inactive_searchTerm);
        assertEquals(EntitiesSearchResultsPage.entitiesInactiveTag(),"INACTIVE");
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
        testLabelContains(federal, "Delinquent Federal Debt");
    }

    // Test Autocomplete
    @Test
    public void autocompleteTest() throws InterruptedException{
        SearchNavigation.gotoAutoComplete(index,autocomplete_searchTerm);
        assertTrue(EntitiesSearchResultsPage.autocompleteExists());
        System.out.println("AutoComplete present");
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
        assertEquals(EntitiesSearchResultsPage.entitiesTitle(), exact_searchTerm);
        System.out.println("Exact match found");
    }

    // DUNS exact Match test
    @Test
    public void searchOnDUNSTest() throws InterruptedException {
        duns_searchTerm = duns_searchTerm.replace("\"","");
        System.out.println("Input DUNS Search Term : "+ duns_searchTerm);
        SearchNavigation.gotoSearchResultsPage(index,duns_searchTerm);
        assertEquals(EntitiesSearchResultsPage.dunsExactMatch(), duns_searchTerm);
        System.out.println("Search by DUNS renders results");
    }


    @AfterClass
    public static void end(){
        closeOut();
    }

}
