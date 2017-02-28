package gov.gsa.Tests.wageDeterminations;

import gov.gsa.Navigation.SearchNavigation;
import gov.gsa.Pages.WageDeterminationSearchPage;
import gov.gsa.Utilities.CommonUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import gov.gsa.Utilities.CommonUtils.DataField;

import static gov.gsa.Utilities.CommonUtils.testLabelAndDataExists;
import static gov.gsa.Utilities.CommonUtils.testLabelContains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WDDBASearchTest extends WDSearchHelper {


    // Any variables needed here
    @BeforeClass
    public static void start() throws InterruptedException {
        WDSearchHelper.searchTerm = "NM20170031";
        WDSearchHelper.autocomplete_searchTerm = "tx20170011";
        WDSearchHelper.inactive_searchTerm = "ky20100141";

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
    public void wdDBATitleTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, searchTerm);
        CommonUtils.DataField wdTitle = WageDeterminationSearchPage.wdNumber();
        testLabelAndDataExists(wdTitle);
        testLabelContains(wdTitle, "DBA Wage Determination");
    }

    @Test
    public void wdDBAConstructionTypeTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, searchTerm);
        DataField wdConstructionType = WageDeterminationSearchPage.wdConstructionType();
        testLabelAndDataExists(wdConstructionType);
        testLabelContains(wdConstructionType, "Construction Type");
    }


    // check if inactive tag exists for DBA
    //@Test
    public void inactiveTagTestDBA() throws InterruptedException {
        SearchNavigation.gotoIsActiveFalseSearch(index,inactive_searchTerm);
        System.out.println(WageDeterminationSearchPage.wdInactiveTag());
        assertEquals(WageDeterminationSearchPage.wdInactiveTag(), "INACTIVE");
        System.out.println("Inactive tag exists");
    }



    @AfterClass
    public static void end(){
        closeOut();
    }

}
