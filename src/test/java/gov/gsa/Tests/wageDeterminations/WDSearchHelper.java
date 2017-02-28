package gov.gsa.Tests.wageDeterminations;

import gov.gsa.Navigation.SearchNavigation;
import gov.gsa.Pages.WageDeterminationSearchPage;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import gov.gsa.Utilities.CommonUtils.DataField;

import static gov.gsa.Utilities.CommonUtils.testLabelAndDataExists;
import static gov.gsa.Utilities.CommonUtils.testLabelContains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by RKumar on 2/28/2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WDSearchHelper extends Base{

    //Test Data
    public String index = "Wage Determinations";
    public static String searchTerm = "";
    public static String autocomplete_searchTerm = "";
    public static String inactive_searchTerm = "";


    // checking pagination is greater than 0
    @Test
    public void wdPaginationTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, " ");
        System.out.println(WageDeterminationSearchPage.wdResultPageCount());
        assertTrue("Wage Determination pagination is greater than 1", WageDeterminationSearchPage.wdResultPageCount() > 1);
        System.out.println("Wage Determination results exists");
    }

    // keyword search - tests if search string exists in the wage determination number title
    @Test
    public void wdKeywordSearchTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,searchTerm);
        DataField wdTitle = WageDeterminationSearchPage.wdNumber();
        CommonUtils.testDataContains(wdTitle, searchTerm);
    }

    // auto complete - tests if autocomplete exists
    @Test
    public void wdAutoCompleteTest() throws InterruptedException {
        assertTrue(CommonUtils.autoCompleteExists(index,autocomplete_searchTerm));
    }

    // test DBA and SCA common fields exist in search results
    @Test
    public void wdStateTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, searchTerm);
        CommonUtils.DataField wdState = WageDeterminationSearchPage.wdState();
        testLabelAndDataExists(wdState);
        testLabelContains(wdState, "State");
    }

    @Test
    public void wdRevisionTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, searchTerm);
        CommonUtils.DataField wdRevision = WageDeterminationSearchPage.wdRevisionNum();
        testLabelAndDataExists(wdRevision);
        testLabelContains(wdRevision, "Revision");
    }

    @Test
    public void wdCountyTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, searchTerm);
        CommonUtils.DataField wdCounty = WageDeterminationSearchPage.wdCounty();
        testLabelAndDataExists(wdCounty);
        testLabelContains(wdCounty, "County/ies");
    }


    @Test
    public void wdLastRevisedDateTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, searchTerm);
        CommonUtils.DataField wdDate = WageDeterminationSearchPage.wdDate();
        testLabelAndDataExists(wdDate);
        testLabelContains(wdDate, "Last Revised Date");
    }


    @AfterClass
    public static void end(){
        closeOut();
    }

}
