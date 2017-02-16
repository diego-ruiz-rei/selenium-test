package gov.gsa.Tests;

import gov.gsa.Navigation.ExclusionsSearchNavigation;
import gov.gsa.Navigation.WageDeterminationSearchNavigation;
import gov.gsa.Pages.ExclusionsSearchPage;
import gov.gsa.Pages.ExclusionsSearchPage;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import gov.gsa.Utilities.CommonUtils.DataField;
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


    // Any variables needed here

    @BeforeClass
    public static void start() throws InterruptedException {
        setUp();
    }

    // empty search - tests wd tag shows up above results and that pagination is greater than 1
    @Test
    public void emptySearchTest() throws InterruptedException {
        ExclusionsSearchNavigation.gotoObjectView(" ");
        System.out.println(ExclusionsSearchPage.exTag());
        assertEquals(ExclusionsSearchPage.exTag(), "EXCLUSION");
        System.out.println("Exclusion tag exists");

        // checking pagination is greater than 0
        System.out.println(ExclusionsSearchPage.exResultPageCount());
        assertTrue("pagination is greater than 1", ExclusionsSearchPage.exResultPageCount() > 1);
        System.out.println("search results exists");
    }

    // keyword search - tests if search string exists in the title
    @Test
    public void keywordSearchTest() throws InterruptedException {
        ExclusionsSearchNavigation.gotoObjectView("BOB METGUD");
        System.out.println(ExclusionsSearchPage.exTitle());
        assertEquals(ExclusionsSearchPage.exTitle(), "BOB METGUD");
    }

    // auto complete - tests if autocomplete exists
    @Test
    public void autoCompleteTest() throws InterruptedException {
        assertTrue(CommonUtils.autoCompleteExists("melissa dawn ferrell"));
    }

    // test common fields exist in search results
    @Test
    public void searchFieldsExistTest() throws InterruptedException {
        ExclusionsSearchNavigation.gotoObjectView("CENTURY METALS INC.");

        // gather field data into variables here
        DataField exDuns = ExclusionsSearchPage.exDuns();
        DataField exCageCode = ExclusionsSearchPage.exCageCode();
        DataField exAddress = ExclusionsSearchPage.exAddress();
        DataField exClassification = ExclusionsSearchPage.exClassification();
        DataField exActivationDate = ExclusionsSearchPage.exActivationDate();
        DataField exTerminationDate = ExclusionsSearchPage.exTerminationDate();

        // checking if field label and data exist for the following fields
        CommonUtils.testLabelAndDataExists(exDuns, true);
        CommonUtils.testLabelAndDataExists(exCageCode, true);
        CommonUtils.testLabelAndDataExists(exAddress, true);
        CommonUtils.testLabelAndDataExists(exClassification, true);
        CommonUtils.testLabelAndDataExists(exActivationDate, true);
        CommonUtils.testLabelAndDataExists(exTerminationDate, true);
    }

    // test DBA common fields text results
    @Test
    public void searchFieldsTextTest() throws InterruptedException {
        ExclusionsSearchNavigation.gotoObjectView("CENTURY METALS INC.");

        // gather field data into variables here
        DataField exDuns = ExclusionsSearchPage.exDuns();
        DataField exCageCode = ExclusionsSearchPage.exCageCode();
        DataField exAddress = ExclusionsSearchPage.exAddress();
        DataField exClassification = ExclusionsSearchPage.exClassification();
        DataField exActivationDate = ExclusionsSearchPage.exActivationDate();
        DataField exTerminationDate = ExclusionsSearchPage.exTerminationDate();

        // checking if field label and data exist for the following fields
        CommonUtils.testDataContains(exDuns, "070376092");
        CommonUtils.testDataContains(exCageCode, "6HXG7");
        CommonUtils.testDataContains(exAddress, "27924 SE 268TH ST, RAVENSDALE, WA 980518814");
        CommonUtils.testDataContains(exClassification, "Firm");
        CommonUtils.testDataContains(exActivationDate, "May 21, 2012");
        CommonUtils.testDataContains(exTerminationDate, "Apr 2, 2022");
    }

    // test that we are able to parse the termination date displayed
    @Test
    public void checkDateFormat() throws InterruptedException {
        ExclusionsSearchNavigation.gotoObjectView("GIANT LABOR SOLUTIONS LLC");

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
        ExclusionsSearchNavigation.gotoObjectView("JANE ANN BAILEY");
        System.out.println(ExclusionsSearchPage.exTerminationDate());
        CommonUtils.testDataContains(ExclusionsSearchPage.exTerminationDate(), "Indefinite");
    }

    @AfterClass
    public static void end(){
        closeOut();
    }

}
