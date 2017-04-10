package gov.gsa.Tests.awards;

import gov.gsa.Navigation.HomePageNavigation;
import gov.gsa.Navigation.SearchNavigation;
import gov.gsa.Pages.AwardsSearchResultsPage;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static gov.gsa.Utilities.CommonUtils.testLabelAndDataExists;
import static gov.gsa.Utilities.CommonUtils.testLabelContains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by prashant.pillai on 4/10/17.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AwardsSearchTest extends Base {

    //test data
    public String index="Awards";
    public String active_searchTerm = "VA24615F0356";
    public String autocomplete_searchTerm = "VA24614A0067";

    @BeforeClass
    public static void start() throws InterruptedException {
        setUp();
    }

    // Awards Tag
    @Test
    public void awardsTagTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertEquals("Awards Tag does not Exist", AwardsSearchResultsPage.awardsTag(),"AWARD");
        System.out.println("Awards Tag is Present");
    }

    //test for pagination
    @Test
    public void paginationTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertTrue("Awards Pagination Does not exist", AwardsSearchResultsPage.resultsPageCount() > 1);
        System.out.println("Awards Pagination on Empty Search exists");
    }

    //test for auto-complete
    @Test
    public void autoCompleteTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        assertTrue(CommonUtils.autoCompleteExists(index,autocomplete_searchTerm));
    }

    //test for title
    @Test
    public void titleTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        assertTrue("Title Does not exist", AwardsSearchResultsPage.exTitle());
    }

    //test for number of results
    @Test
    public void resultNumberTest() throws InterruptedException{
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        assertTrue("Message does not exist", AwardsSearchResultsPage.extractTotalResults());
    }

    @Test
    public void vendorNameTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        assertTrue("Vendor name does not exist", AwardsSearchResultsPage.vendorName());
    }

    @Test
    public void vendorAddressTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        assertTrue("Vendor address does not exist", AwardsSearchResultsPage.vendorAddress());
    }

    @Test
    public void dunsNumberTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.dunsNumber();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "DUNS");
    }

    @Test
    public void globalVendorTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.globalVendor();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "Global Vendor");
    }

    @Test
    public void globalDunsTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.globalDuns();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "Global DUNS");
    }


    @Test
    public void departmentTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.checkDepartment();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "Department/Ind. Agency");
    }

    @Test
    public void officeTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.checkOffice();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "Office");
    }

    @Test
    public void actionObligationTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.checkActionObligation();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "Action Obligation");
    }

    @Test
    public void awardTypeTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.checkAwardType();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "Award Type");
    }

    @Test
    public void referenceIdvTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.checkReferencedIDV();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "Referenced IDV");
    }

    @Test
    public void dateSignedTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.checkDateSigned();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "Date Signed");
    }

    @Test
    public void naicsCodeTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.checkNaicsCode();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "NAICS Code");
    }

    @Test
    public void pscCodeTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.checkPscCode();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "PSC Code");
    }

    @AfterClass
    public static void end(){
        closeOut();
    }
}
