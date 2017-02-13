package gov.gsa.Tests;

import gov.gsa.Navigation.WageDeterminationSearchNavigation;
import gov.gsa.Pages.FederalHierarchySearchPage;
import gov.gsa.Pages.WageDeterminationSearchPage;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import gov.gsa.Utilities.CommonUtils.DataField;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WageDeterminationSearchTest extends Base {


    // Any variables needed here

    @BeforeClass
    public static void start() throws InterruptedException {
        setUp();
    }

    // empty search - tests wd tag shows up above results and that pagination is greater than 1
    @Test
    public void emptySearchTest() throws InterruptedException {
        WageDeterminationSearchNavigation.gotoWDObjectView("");
        System.out.println(WageDeterminationSearchPage.wdTag());
        assertEquals(WageDeterminationSearchPage.wdTag(), "DBA WAGE DETERMINATION");
        System.out.println("Wage Determination tag exists");

        // checking pagination is greater than 0
        System.out.println(WageDeterminationSearchPage.wdResultPageCount());
        assertTrue("Wage Determination pagination is greater than 1", WageDeterminationSearchPage.wdResultPageCount() > 1);
        System.out.println("Wage Determination results exists");
    }

    // keyword search - tests if search string exists in the wage determination number title
    @Test
    public void keywordSearchTest() throws InterruptedException {
        WageDeterminationSearchNavigation.gotoWDObjectView("AR20160092");
        DataField wdTitle = WageDeterminationSearchPage.wdNumber();
        CommonUtils.testDataContains(wdTitle, "AR20160092");
    }

    // auto complete - tests if autocomplete exists
    @Test
    public void autoCompleteTest() throws InterruptedException {
       assertTrue(CommonUtils.autoCompleteExists("AR2"));
    }




//    // wage determination number field
//        System.out.println(WageDeterminationSearchPage.wdNumber().label);
//        System.out.println(WageDeterminationSearchPage.wdNumber().data);
//
//    // state field
//        System.out.println(WageDeterminationSearchPage.wdState().label);
//        System.out.println(WageDeterminationSearchPage.wdState().data);
//
//    // county field
//        System.out.println(WageDeterminationSearchPage.wdCounty().label);
//        System.out.println(WageDeterminationSearchPage.wdCounty().data);
//
//    // revision number field
//        System.out.println(WageDeterminationSearchPage.wdRevisionNum().label);
//        System.out.println(WageDeterminationSearchPage.wdRevisionNum().data);
//
//    // construction type field
//        System.out.println(WageDeterminationSearchPage.wdConstructionType().label);
//        System.out.println(WageDeterminationSearchPage.wdConstructionType().data);
//
//    // date field
//        System.out.println(WageDeterminationSearchPage.wdDate().label);
//        System.out.println(WageDeterminationSearchPage.wdDate().data);



    @AfterClass
    public static void end(){
        closeOut();
    }

}
