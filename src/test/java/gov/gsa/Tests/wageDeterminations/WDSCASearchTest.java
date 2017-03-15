package gov.gsa.Tests.wageDeterminations;

import gov.gsa.Navigation.SearchNavigation;
import gov.gsa.Pages.WageDeterminationSearchPage;
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
 * Created by RKumar on 2/28/2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WDSCASearchTest extends WDSearchHelper{


    // Any variables needed here
    @BeforeClass
    public static void start() throws InterruptedException {
        WDSearchHelper.searchTerm = "1967-0442";
        WDSearchHelper.autocomplete_searchTerm = "1973-0479";
        WDSearchHelper.inactive_searchTerm = "1994-2002";
        setUp();
    }

    // empty search - tests wd tag shows up above results and that pagination is greater than 1
    @Test
    public void wdEmptySearchTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, " ");
        System.out.println(WageDeterminationSearchPage.wdTag());
        assertEquals(WageDeterminationSearchPage.wdTag(), "DBA WAGE DETERMINATION");
        System.out.println("Wage Determination tag exists");
    }

    @Test
    public void wdSCATitleTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, searchTerm);
        CommonUtils.DataField wdTitle = WageDeterminationSearchPage.wdNumber();
        testLabelAndDataExists(wdTitle);
        testLabelContains(wdTitle, "SCA Wage Determination");
    }

    @Test
    public void wdSCAServiceTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, searchTerm);
        CommonUtils.DataField wdService = WageDeterminationSearchPage.wdService();
        testLabelAndDataExists(wdService);
        testLabelContains(wdService, "Service");
    }


    // check if inactive tag exists for SCA
    @Test
    public void inactiveTagTestSCA() throws InterruptedException {
        SearchNavigation.gotoIsActiveFalseSearch(index,inactive_searchTerm);
        System.out.println(WageDeterminationSearchPage.wdInactiveTag());
        assertEquals(WageDeterminationSearchPage.wdInactiveTag(), "INACTIVE");
        System.out.println("Inactive tag exists");
    }

    //check for sca filter tag
    @Test
    public void scaFilterTagTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertEquals(WageDeterminationSearchPage.checkSCAFilterTag(),"SCA WAGE DETERMINATION");

    }

    //check for elevator services through filters
    @Test
    public void selectServiceTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertEquals(WageDeterminationSearchPage.checkElevatorServicesFilterTag(),"Elevator Services");

    }

    //check for even sca number through filters
    @Test
    public void evenNumberTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertTrue("WD number is even", WageDeterminationSearchPage.checkForEvenWdNumber());
    }

    //check for odd sca numbers through filters
    @Test
    public void oddNumberTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertTrue("WD number is even", !WageDeterminationSearchPage.checkForOddWdNumber());
    }




    @AfterClass
    public static void end(){
        closeOut();
    }

}
