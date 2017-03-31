package gov.gsa.Tests.wageDeterminations;

import gov.gsa.Navigation.HomePageNavigation;
import gov.gsa.Navigation.SearchNavigation;
import gov.gsa.Pages.WageDeterminationSearchPage;
import gov.gsa.Utilities.CommonUtils;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static gov.gsa.Utilities.CommonUtils.testLabelAndDataExists;
import static gov.gsa.Utilities.CommonUtils.testLabelContains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by RKumar on 2/28/2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WDSCASearchTest extends WDSearchHelper{

    // Any variables needed here

    public static String services_performed="Elevator Services";
    public static String asserted_message="Please navigate to the Service Contract Act section of the legacy WDOL site to retrieve a Collective Bargaining Agreement (CBA) WD or to create a new CBA WD";

    @BeforeClass
    public static void start() throws InterruptedException {
        WDSearchHelper.wd_type = "SCA";
        WDSearchHelper.searchTerm = "1967-0442";
        WDSearchHelper.autocomplete_searchTerm = "1973-0479";
        WDSearchHelper.inactive_searchTerm = "1994-2002";
        setUp();
    }

    // empty search - tests wd tag shows up above results and that pagination is greater than 1
    @Test
    public void wdEmptySearchTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSCASearch(index, " ");
        System.out.println(WageDeterminationSearchPage.wdTag());
        assertEquals("Empty Search does not render any results",WageDeterminationSearchPage.wdTag(), "SCA WAGE DETERMINATION");
        System.out.println("Wage Determination tag exists");
    }

    @Test
    public void wdSCATitleTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSCASearch(index, searchTerm);
        CommonUtils.DataField wdTitle = WageDeterminationSearchPage.wdNumber();
        testLabelAndDataExists(wdTitle);
        testLabelContains(wdTitle, "SCA Wage Determination");
    }

    @Test
    public void wdSCAServiceTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSCASearch(index, searchTerm);
        CommonUtils.DataField wdService = WageDeterminationSearchPage.wdService();
        testLabelAndDataExists(wdService);
        testLabelContains(wdService, "Service");
    }


    // check if inactive tag exists for SCA
    @Test
    public void inactiveTagTestSCA() throws InterruptedException {
        SearchNavigation.gotoIsActiveFalseSearch(index,inactive_searchTerm);
        System.out.println(WageDeterminationSearchPage.wdInactiveTag());
        assertEquals("Inactive Tag is not present",WageDeterminationSearchPage.wdInactiveTag(), "INACTIVE");
        System.out.println("Inactive tag exists");
    }

    //check for sca filter tag
    @Test
    public void scaFilterTagTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSCASearch(index,"");
        assertEquals("SCA Wage Determination Tag is not present",WageDeterminationSearchPage.checkSCAFilterTag(),"SCA WAGE DETERMINATION");

    }

    //check for elevator services through filters
    @Test
    public void standardServiceFilterTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSCASearch(index,"");
        assertEquals("Search results does not match with Service Filter",WageDeterminationSearchPage.checkElevatorServicesFilterTag(),services_performed);
    }

    //check for even sca number through filters
    @Test
    public void standardServiceEvenNumberFilterTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSCASearch(index,"");
        assertTrue("Search results does not contain Even Number", WageDeterminationSearchPage.checkForEvenWdNumber());
    }

    //check for odd sca numbers through filters
    @Test
    public void standardServiceOddNumberFilterTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSCASearch(index,"");
        assertTrue("Search results does not contain Odd Number", !WageDeterminationSearchPage.checkForOddWdNumber());
    }

    //check for asserted message for same locality and yes, contract based on cba
    @Test
    public void subjectToCBAFilterTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertEquals("Search Result does not contain message for Subject to CBA Filter",WageDeterminationSearchPage.checkAssertedMessage(),asserted_message );
    }

    //Check for Published/Last Revised Date
    @Test
    public void wdSCADateTest() throws InterruptedException{
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSCASearch(index, searchTerm);
        CommonUtils.DataField revision = WageDeterminationSearchPage.wdRevisionNum();
        CommonUtils.DataField date = WageDeterminationSearchPage.wdDate();
        testLabelAndDataExists(date);
        if(new Integer(revision.data) == 1){
            testLabelContains(date,"Published Date");
            System.out.println("Published Date Field is Present in SCA Search");
        }
        else{
            testLabelContains(date,"Last Revised Date");
            System.out.println("Last Revised Date Field is Present in SCA Search");
        }
    }

    @After
    public void clearFilter(){
        WageDeterminationSearchPage.clearAll();
    }

    @AfterClass
    public static void end(){
        closeOut();
    }

}
