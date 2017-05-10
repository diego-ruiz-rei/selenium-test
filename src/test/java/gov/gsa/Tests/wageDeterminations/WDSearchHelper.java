package gov.gsa.Tests.wageDeterminations;

import gov.gsa.Navigation.HomePageNavigation;
import gov.gsa.Navigation.SearchNavigation;
import gov.gsa.Pages.WageDeterminationSearchPage;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import gov.gsa.Utilities.CommonUtils.DataField;

import java.text.ParseException;

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
    public static String wd_type = "";
    public static String searchTerm = "";
    public static String autocomplete_searchTerm = "";
    public static String inactive_searchTerm = "";
    public static String state_filter="Alabama";
    public static String county_filter="Autauga";

    @BeforeClass
    public static void start() throws InterruptedException {
        setUp();
    }

    // checking pagination is greater than 0
    @Test
    public void wdPaginationTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        if (wd_type.equals("SCA"))
            SearchNavigation.gotoSCASearch(index, "");
        else
            SearchNavigation.gotoDBASearch(index, "");
        System.out.println(WageDeterminationSearchPage.wdResultPageCount());
        assertTrue("Wage Determination pagination is greater than 1", WageDeterminationSearchPage.wdResultPageCount() > 1);
        System.out.println("Wage Determination results exists");
    }

    // keyword search - tests if search string exists in the wage determination number title
    @Test
    public void wdKeywordSearchTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        if (wd_type.equals("SCA"))
            SearchNavigation.gotoSCASearch(index, searchTerm);
        else
            SearchNavigation.gotoDBASearch(index, searchTerm);
        //SearchNavigation.gotoSearchResultsPage(index,searchTerm);
        DataField wdTitle = WageDeterminationSearchPage.wdNumber();
        CommonUtils.testDataContains(wdTitle, searchTerm);
    }

    // auto complete - tests if autocomplete exists
    @Test
    public void wdAutoCompleteTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertTrue(CommonUtils.autoCompleteExists(index,autocomplete_searchTerm));
    }

    // test DBA and SCA common fields exist in search results
   @Test
    public void wdStateTest() throws InterruptedException {
        //HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index, searchTerm);
        CommonUtils.DataField wdState = WageDeterminationSearchPage.wdState();
        testLabelAndDataExists(wdState);
        testLabelContains(wdState, "State");
    }

    @Test
    public void wdRevisionTest() throws InterruptedException {
        //HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index, searchTerm);
        CommonUtils.DataField wdRevision = WageDeterminationSearchPage.wdRevisionNum();
        testLabelAndDataExists(wdRevision);
        testLabelContains(wdRevision, "Revision #");
    }

    @Test
    public void wdCountyTest() throws InterruptedException {
        HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index, searchTerm);
        CommonUtils.DataField wdCounty = WageDeterminationSearchPage.wdCounty();
        testLabelAndDataExists(wdCounty);
        testLabelContains(wdCounty, "County/ies");
    }

    //test to check state field contains same state name as in state filter
    @Test
    public void stateFilterTest() throws InterruptedException {
        //HomePageNavigation.gotoHomePage();
        if (wd_type == "SCA")
            SearchNavigation.gotoSCASearch(index, "");
        else
            SearchNavigation.gotoDBASearch(index, "");
        assertEquals(WageDeterminationSearchPage.checkStateFilter(),state_filter);
    }

    //test to check county/ies field contains same county name as in county filter
    @Test
    public void countyFilterTest() throws InterruptedException {
        //HomePageNavigation.gotoHomePage();
        if (wd_type == "SCA")
            SearchNavigation.gotoSCASearch(index, "");
        else
            SearchNavigation.gotoDBASearch(index, "");
        String countyList=WageDeterminationSearchPage.checkCountyFilter();
        assertTrue("County/ies field contains county selected",countyList.contains(county_filter) || countyList.contains("Statewide") );
    }

    //total results
    @Test
    public void resultNumberTest() throws InterruptedException, ParseException {
        //HomePageNavigation.gotoHomePage();
        SearchNavigation.gotoSearchResultsPage(index,"");
        assertTrue("Message does not exist", CommonUtils.extractTotalResults() >= 1);
    }


    @AfterClass
   public static void end(){
        closeOut();
    }

}
