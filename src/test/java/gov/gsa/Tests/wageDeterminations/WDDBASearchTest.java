package gov.gsa.Tests.wageDeterminations;

import gov.gsa.Navigation.HomePageNavigation;
import gov.gsa.Navigation.SearchNavigation;
import gov.gsa.Pages.WageDeterminationSearchPage;
import gov.gsa.Utilities.CommonUtils;
import gov.gsa.Utilities.CommonUtils.DataField;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static gov.gsa.Utilities.CommonUtils.testLabelAndDataExists;
import static gov.gsa.Utilities.CommonUtils.testLabelContains;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WDDBASearchTest extends WDSearchHelper {

    // Any variables needed here
    @BeforeClass
    public static void start() throws InterruptedException {
        WDSearchHelper.wd_type = "DBA";
        WDSearchHelper.searchTerm = "AK20170001";
        WDSearchHelper.autocomplete_searchTerm = "tx20170011";
        WDSearchHelper.inactive_searchTerm = "ky20100141";

        setUp();
    }

    // empty search - tests wd tag shows up above results and that pagination is greater than 1
    @Test
    public void wdEmptySearchTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoDBASearch(index, " ");
        System.out.println(WageDeterminationSearchPage.wdTag());
        assertEquals("DBA Wage Determination tag is not Found",WageDeterminationSearchPage.wdTag(), "DBA WAGE DETERMINATION");
        System.out.println("Wage Determination tag exists");
    }

    @Test
    public void wdDBATitleTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoDBASearch(index, searchTerm);
        CommonUtils.DataField wdTitle = WageDeterminationSearchPage.wdNumber();
        testLabelAndDataExists(wdTitle);
        testLabelContains(wdTitle, "DBA Wage Determination");
    }

    @Test
    public void wdDBAConstructionTypeTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoDBASearch(index, searchTerm);
        DataField wdConstructionType = WageDeterminationSearchPage.wdConstructionType();
        testLabelAndDataExists(wdConstructionType);
        testLabelContains(wdConstructionType, "Construction Type");
    }


    // check if inactive tag exists for DBA
    @Test
    public void inactiveTagTestDBA() throws InterruptedException {
        SearchNavigation.gotoIsActiveFalseSearch(index,inactive_searchTerm);
        System.out.println(WageDeterminationSearchPage.wdInactiveTag());
        assertEquals(WageDeterminationSearchPage.wdInactiveTag(), "INACTIVE");
        System.out.println("Inactive tag exists");
    }

    //check DBA Published or Last Revised Date
    @Test
    public void wdDBADateTest() throws InterruptedException{
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoDBASearch(index,searchTerm);
        DataField revision = WageDeterminationSearchPage.wdRevisionNum();
        DataField date = WageDeterminationSearchPage.wdDate();
        testLabelAndDataExists(date);
        if(new Integer(revision.data) == 0){
            testLabelContains(date,"Published Date");
            System.out.println("Published Date Field is Present in the WD Object View page");
        }
        else{
            testLabelContains(date,"Last Revised Date");
            System.out.println("Last Revised Date Field is Present in the WD Object View page");
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
