package gov.gsa.Tests.opportunities;

import gov.gsa.Navigation.SearchNavigation;
import gov.gsa.Pages.OpportunitiesSearchResultsPage;
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
 * Created by prashant.pillai on 3/1/17.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OpportunitiesSearchTest extends Base {

    //Test Data
    public String index = "Opportunities";
    public String archived_searchTerm = "SPE4A516TT128";
    public String active_searchTerm = "HDTRA1-14-R-0020";
    public String autocomplete_searchTerm = "16--insulation blanket, cabin, aircraft";
    public String presolicitation_searchTerm="N6554011T5343";
    public String combinedsynopsis_searchTerm="SPRTA114Q0054";
    public String surplussale_searchTerm="W912P-16-T-0056";
    public String sourcessought_searchTerm="RFIP0700NAS16-0756";
    public String justifyapprove_searchTerm="W9128F-16-R-0006";
    public String awardnotice_searchTerm="5GA0066A";
    public String fairopportunity_searchTerm="W9133L16F2Y04";
    public String specialnotice_searchTerm="C27JFPMU";
    public String modifyamendSearchTerm="FM44186201AW01";

    @BeforeClass
    public static void start() throws InterruptedException {
        setUp();
    }

    // Opportunities Tag
    @Test
    public void opportunitiesTagTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertEquals("Opportunities Tag does not Exist",OpportunitiesSearchResultsPage.opportunitiesTag(),"OPPORTUNITY");
        System.out.println("Opportunities Tag is Present");

    }

    // Opportunities Archived Tag
    @Test
    public void opportunitiesArchivedTagTest() throws InterruptedException {
        SearchNavigation.gotoIsActiveFalseSearch(index,archived_searchTerm);
        assertEquals("Opportunities Archived Tag does not Exist",OpportunitiesSearchResultsPage.opportunitiesArchivedTag(),"ARCHIVED");
        System.out.println("Opportunities Archived Tag is Present");
    }

    // Test Autocomplete
    @Test
    public void autoCompleteTest() throws InterruptedException {
        assertTrue(CommonUtils.autoCompleteExists(index,autocomplete_searchTerm));
    }

    //Pagination test
    @Test
    public void paginationTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertTrue("Opportunities Pagination Does not exist", OpportunitiesSearchResultsPage.resultsPageCount() > 1);
        System.out.println("Opportunities Pagination on Empty Search exists");
    }


  //Test for Department
    @Test
    public void departmentTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField dept = OpportunitiesSearchResultsPage.department();
        testLabelAndDataExists(dept);
        testLabelContains(dept, "Department");

    }

    //Test for Office
    @Test
    public void officeTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField officeData = OpportunitiesSearchResultsPage.officeName();
        testLabelAndDataExists(officeData);
        testLabelContains(officeData, "Office");
    }

    //Test for Location
    @Test
    public void locationTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField locationData = OpportunitiesSearchResultsPage.locationName();
        testLabelAndDataExists(locationData);
        testLabelContains(locationData, "Location");
    }

    //Test for SolicitationNumber
    @Test
    public void solicitationNumberTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField solicitationNumberData = OpportunitiesSearchResultsPage.solicitation();
        testLabelAndDataExists(solicitationNumberData);
        testLabelContains(solicitationNumberData, "Solicitation Number");
    }

    //Test for Posted date
    @Test
    public void postedDateTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField postedDateTestData = OpportunitiesSearchResultsPage.postedDate();
        testLabelAndDataExists(postedDateTestData);
        testLabelContains(postedDateTestData, "Posted Date");
    }

    //Test for Type
    @Test
    public void typeTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        DataField typeTestData = OpportunitiesSearchResultsPage.type();
        testLabelAndDataExists(typeTestData);
        testLabelContains(typeTestData, "Type");
    }

    //test for title
    @Test
    public void titleTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        assertTrue("Title Does not exist", OpportunitiesSearchResultsPage.exTitle());
    }

    //test for description
    @Test
    public void descriptionTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        assertTrue("Description Does not exist", OpportunitiesSearchResultsPage.exDescription());
    }

    //test for pre-solicitation
    @Test
    public void presolicitationTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,presolicitation_searchTerm);
        assertTrue("Pre-solicitation Does not exist", OpportunitiesSearchResultsPage.presolicitation());
    }

    //test for combined synopsis
    @Test
    public void combinedSynopsisTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,combinedsynopsis_searchTerm);
        assertTrue("Combined Synopsis Does not exist", OpportunitiesSearchResultsPage.combinedSynopsis());
    }

    //test for saleOfSurplus
    @Test
    public void saleOfSurplusTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,surplussale_searchTerm);
        assertTrue("Sale of Surplus Does not exist", OpportunitiesSearchResultsPage.saleOfSurplus());
    }

    //test for sources sought
    @Test
    public void sourcesSoughtTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,sourcessought_searchTerm);
        assertTrue("Sources sought Does not exist", OpportunitiesSearchResultsPage.sourcesSought());
    }

    //test for justification & approval
    @Test
    public void justifyApproveTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,justifyapprove_searchTerm);
        assertTrue("Justification & Approval Does not exist", OpportunitiesSearchResultsPage.justifyApprove());
    }

    //test for award
    @Test
    public void awardTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,awardnotice_searchTerm);
        assertTrue("Award Notice Does not exist", OpportunitiesSearchResultsPage.awardCheck());
    }

    //test for fair opportunity
    @Test
    public void fairOpportunityTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,fairopportunity_searchTerm);
        assertTrue("Fair Opportunity Does not exist", OpportunitiesSearchResultsPage.fairOpportunity());
    }

    //test for Special Notice
    @Test
    public void specialNoticeTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,specialnotice_searchTerm);
        assertTrue("Special Notice Does not exist", OpportunitiesSearchResultsPage.specialNotice());
    }

    //test for Modification/Amendment
    @Test
    public void modifyAmendTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,modifyamendSearchTerm);
        assertTrue("Modification/Amendment Does not exist", OpportunitiesSearchResultsPage.modifyAmend());
    }

    @AfterClass
    public static void end(){
        closeOut();
    }



}
