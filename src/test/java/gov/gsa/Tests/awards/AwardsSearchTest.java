package gov.gsa.Tests.awards;

import gov.gsa.Navigation.HomePageNavigation;
import gov.gsa.Navigation.SearchNavigation;
import gov.gsa.Pages.AwardsSearchResultsPage;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;

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
    public String autocomplete_searchTerm_1 = "VA24812F5816";
    public String contract_award_type_filter = "069058";
    public String naics_filter_1 = "561720 -- Janitorial Services";
    public String naics_filter_field = "JANITORIAL SERVICES (561720)";
    public String naics_filter_2 = "238220 -- Plumbing, Heating, and Air-Conditioning Contractors";
    AwardsSearchResultsPage awardsSearchResultsPage = new AwardsSearchResultsPage();

    @BeforeClass
    public static void start() throws InterruptedException {
        setUp();
    }


    // Awards Tag
    @Test
    public void awardsTagTest() throws InterruptedException {
        //HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,"");
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        assertEquals("Awards Tag does not Exist", AwardsSearchResultsPage.awardsTag(),"Award");
        System.out.println("Awards Tag is Present");
    }

    //test for pagination
    @Test
    public void paginationTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,"");
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        assertTrue("Awards Pagination Does not exist", AwardsSearchResultsPage.resultsPageCount() > 1);
        System.out.println("Awards Pagination on Empty Search exists");
    }

   //test for auto-complete
    @Test
    public void autoCompleteTest() throws InterruptedException {
        //HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertTrue(CommonUtils.autoCompleteExists(index,autocomplete_searchTerm_1));
    }

    //test for title
    @Test
    public void titleTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        assertTrue("Title Does not exist", AwardsSearchResultsPage.exTitle());
    }

    //test for number of results
    @Test
    public void resultNumberTest() throws InterruptedException, ParseException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        assertTrue("Message does not exist", CommonUtils.extractTotalResults() >= 1);
    }

    //test for vendor name label and data
    @Test
    public void vendorNameTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        assertTrue("Vendor name does not exist", AwardsSearchResultsPage.vendorName());
    }

    //test for vendor address label and data
    @Test
    public void vendorAddressTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        assertTrue("Vendor address does not exist", AwardsSearchResultsPage.vendorAddress());
    }

    //test for duns number label and data
    @Test
    public void dunsNumberTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.dunsNumber();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "DUNS");
    }

    //test for global vendor label and data
    @Test
    public void globalVendorTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.globalVendor();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "Global Vendor");
    }

    //test for global duns label and data
    @Test
    public void globalDunsTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.globalDuns();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "Global DUNS");
    }

    //test for department label and data
    @Test
    public void departmentTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.checkDepartment();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "Department/Ind. Agency");
    }

    //test for office label and data
    @Test
    public void officeTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.checkOffice();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "Office");
    }

    //test for action-obligation label and data
    @Test
    public void actionObligationTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.checkActionObligation();
        //testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "Action Obligation");
    }

    //test for award or idv type label and data
    @Test
    public void awardTypeTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.checkAwardType();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "Award Type");
    }

    //test for reference idv label and data
    @Test
    public void referenceIdvTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.checkReferencedIDV();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "Referenced IDV");
    }

    //test for date signed label and data
    @Test
    public void dateSignedTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.checkDateSigned();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "Date Signed");
    }

    //test for naicscode label and data
    @Test
    public void naicsCodeTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.checkNaicsCode();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "NAICS Code");
    }

    //test for psc code label and data
    @Test
    public void pscCodeTest()throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        CommonUtils.DataField fieldDataElement = AwardsSearchResultsPage.checkPscCode();
        testLabelAndDataExists(fieldDataElement);
        testLabelContains(fieldDataElement, "PSC Code");
    }

    //test for contract type filter
    @Test
    public void contractTypeFilterTest() throws InterruptedException{
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,"");
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        assertTrue("Contract Type Label does not exist", AwardsSearchResultsPage.checkContractTypeFilter());
    }

    //test for icd type filter
    @Test
    public void icdTypeFilterTest() throws InterruptedException{
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,"");
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        assertTrue("IDV Type Label does not exist", AwardsSearchResultsPage.checkICDTypeFilter());
    }

    //Validate Award-IDV Types filter renders results - for ICD
    @Test
    public void icdAwardDropdownFilterTest() throws InterruptedException{
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,autocomplete_searchTerm);
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        assertTrue("Field Label/Value or type selected is Incorrect", AwardsSearchResultsPage.checkAwardDropdownICD());
    }

    //Validate Award-IDV Types filter renders results - for Contract
    @Test
    public void contractAwardDropdownFilterTest() throws InterruptedException{
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,contract_award_type_filter);
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        assertTrue("Field Label/Value or type selected is Incorrect", AwardsSearchResultsPage.checkAwardDropdownContract());
    }

    //Validate multiple values can be selected for Award-IDV Types
    @Test
    public void multipleAwardTypeFilterTest() throws InterruptedException, ParseException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,"");
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        assertTrue("Field Label/Value or type selected is Incorrect", AwardsSearchResultsPage.checkMultipleAwardTypeFilter());

    }

    //Validate multiple values can be selected for Contract Types
    @Test
    public void multipleContractTypeFilterTest() throws InterruptedException, ParseException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertTrue("Field Label/Value or type selected is Incorrect", AwardsSearchResultsPage.checkMultipleContractTypeFilter());

    }

    //Validate Contract Types filter renders results
    @Test
    public void contractDropdownFilterTest() throws InterruptedException, ParseException{
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,"");
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        assertTrue("Field Label/Value or type selected is Incorrect", AwardsSearchResultsPage.checkContractDropdownTypeFilter());
    }

    //Validate NAICS filter renders result
    @Test
    public void naicsFilterTest() throws InterruptedException{
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,"");
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        assertTrue("Naics test fails",AwardsSearchResultsPage.checkNaicsFilter(naics_filter_1, naics_filter_field));
    }

    //Validate multiple values can be selected for NAICS Type
    @Test
    public void naicsFilterMultipleTest() throws InterruptedException, ParseException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,"");
        awardsSearchResultsPage.beforeTest("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span");
        assertTrue("Naics test fails",AwardsSearchResultsPage.checkNaicsMultipleFilter(naics_filter_1, naics_filter_2));
    }

    @After
    public void clearFilter(){
        AwardsSearchResultsPage.clearAll();
    }

    @AfterClass
    public static void end(){
        closeOut();
    }
}
