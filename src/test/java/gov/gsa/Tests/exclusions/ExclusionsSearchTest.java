package gov.gsa.Tests.exclusions;

import gov.gsa.Navigation.SearchNavigation;
import gov.gsa.Pages.ExclusionsSearchPage;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import gov.gsa.Utilities.CommonUtils.DataField;
import static gov.gsa.Utilities.CommonUtils.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExclusionsSearchTest extends Base {

    //Test Data
    public String index = "Exclusions";
    public String active_searchTerm = "BOB METGUD";
    public String autocomplete_searchTerm = "melissa dawn ferrell";
    public String exact_searchTerm = "\"CENTURY METALS INC.\"";
    public String valid_Termination_Date = "\"GIANT LABOR SOLUTIONS LLC\"";
    public String indefinite_Termination_Date = "\"JANE ANN BAILEY\"";

    // Any variables needed here
    @BeforeClass
    public static void start() throws InterruptedException {
        setUp();
    }

    // empty search - tests wd tag shows up above results and that pagination is greater than 1
    @Test
    public void emptySearchTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, " ");
        System.out.println(ExclusionsSearchPage.exTag());
        assertEquals(ExclusionsSearchPage.exTag(), "EXCLUSION");
        System.out.println("Exclusion tag exists");
    }


    // checking pagination is greater than 0
    @Test
    public void paginationTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, " ");
        System.out.println(ExclusionsSearchPage.exResultPageCount());
        assertTrue("Pagination does not Exist", ExclusionsSearchPage.exResultPageCount() > 1);
        System.out.println("Search results and Pagination exists");
    }

    // keyword search - tests if search string exists in the title
    @Test
    public void keywordSearchTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,active_searchTerm);
        System.out.println(ExclusionsSearchPage.exTitle());
        assertEquals(ExclusionsSearchPage.exTitle(), active_searchTerm);
    }

    // auto complete - tests if autocomplete exists
    @Test
    public void autoCompleteTest() throws InterruptedException {
        assertTrue(CommonUtils.autoCompleteExists(index,autocomplete_searchTerm));
    }

    // test common fields exist in search results
    @Test
    public void exDunsNumberTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, exact_searchTerm);
        DataField exDuns = ExclusionsSearchPage.exDuns();
        testLabelAndDataExists(exDuns);
        testLabelContains(exDuns, "DUNS");
    }


    @Test
    public void exCageCodeTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, exact_searchTerm);
        DataField exCageCode = ExclusionsSearchPage.exCageCode();
        testLabelAndDataExists(exCageCode);
        testLabelContains(exCageCode, "CAGE Code");
    }

    @Test
    public void exAddressTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, exact_searchTerm);
        DataField exAddress = ExclusionsSearchPage.exAddress();
        testLabelAndDataExists(exAddress);
        testLabelContains(exAddress, "Address");
    }

    @Test
    public void exClassificationTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, exact_searchTerm);
        DataField exClassification = ExclusionsSearchPage.exClassification();
        testLabelAndDataExists(exClassification);
        testLabelContains(exClassification, "Classification");
    }

    @Test
    public void exActivationDateTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, exact_searchTerm);
        DataField exActivationDate = ExclusionsSearchPage.exActivationDate();
        testLabelAndDataExists(exActivationDate);
        testLabelContains(exActivationDate, "Activation Date");
    }

    @Test
    public void exTerminationDateTest() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index, exact_searchTerm);
        DataField exTerminationDate = ExclusionsSearchPage.exTerminationDate();
        testLabelAndDataExists(exTerminationDate);
        testLabelContains(exTerminationDate, "Termination Date");
    }


    // test that we are able to parse the termination date displayed
    //@Test
    public void checkDateFormat() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,valid_Termination_Date);

        // date format I want to compare against our date
        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        Date date = null;

        try {
            date = dateFormat.parse(ExclusionsSearchPage.exTerminationDate().data);
            System.out.println("was able to parse the date");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertTrue(date != null);
    }

    // test if this record displays indefinite for termination date
    @Test
    public void checkDateIndefinite() throws InterruptedException {
        SearchNavigation.gotoSearchResultsPage(index,indefinite_Termination_Date);
        System.out.println(ExclusionsSearchPage.exTerminationDate());
        CommonUtils.testDataContains(ExclusionsSearchPage.exTerminationDate(), "Indefinite");
    }

    @AfterClass
    public static void end(){
        closeOut();
    }

}
