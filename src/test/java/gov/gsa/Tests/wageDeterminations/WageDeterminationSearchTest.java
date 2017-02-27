package gov.gsa.Tests.wageDeterminations;

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
        WageDeterminationSearchNavigation.gotoWDObjectView(" ");
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
        assertTrue(CommonUtils.autoCompleteExists("AR20160001"));
    }

    // test DBA common fields exist in search results
    @Test
    public void searchFieldsExistTest() throws InterruptedException {
        WageDeterminationSearchNavigation.gotoWDObjectView("AR20160287");

        // gather field data into variables here
        DataField wdTitle = WageDeterminationSearchPage.wdNumber();
        DataField wdState = WageDeterminationSearchPage.wdState();
        DataField wdCounty = WageDeterminationSearchPage.wdCounty();
        DataField wdRevision = WageDeterminationSearchPage.wdRevisionNum();
        DataField wdConstructionType = WageDeterminationSearchPage.wdConstructionType();
        DataField wdDate = WageDeterminationSearchPage.wdDate();

        // checking if field label and data exist for the following fields
        CommonUtils.testLabelAndDataExists(wdTitle, true);
        CommonUtils.testLabelAndDataExists(wdState, true);
        CommonUtils.testLabelAndDataExists(wdCounty, true);
        CommonUtils.testLabelAndDataExists(wdRevision, true);
        CommonUtils.testLabelAndDataExists(wdConstructionType, true);
        CommonUtils.testLabelAndDataExists(wdDate, true);

    }

    // test DBA common fields text results
    @Test
    public void searchFieldsTextTest() throws InterruptedException {
        WageDeterminationSearchNavigation.gotoWDObjectView("AR20160287");

        // gather field data into variables here
        DataField wdTitle = WageDeterminationSearchPage.wdNumber();
        DataField wdState = WageDeterminationSearchPage.wdState();
        DataField wdCounty = WageDeterminationSearchPage.wdCounty();
        DataField wdRevision = WageDeterminationSearchPage.wdRevisionNum();
        DataField wdConstructionType = WageDeterminationSearchPage.wdConstructionType();
        DataField wdDate = WageDeterminationSearchPage.wdDate();

        // checking if field label and data exist for the following fields
        CommonUtils.testDataContains(wdTitle, "AR20160287");
        CommonUtils.testDataContains(wdState, "Arkansas");
        CommonUtils.testDataContains(wdCounty, "Washington");
        CommonUtils.testDataContains(wdRevision, "0");
        CommonUtils.testDataContains(wdConstructionType, "Highway");
        CommonUtils.testDataContains(wdDate, "Jan 8, 2016");

    }

    // test SCA common fields exist in search results
    @Test
    public void searchFieldsExistSCATest() throws InterruptedException {
        WageDeterminationSearchNavigation.gotoWDObjectView("1981-0682");

        // gather field data into variables here
        DataField wdTitle = WageDeterminationSearchPage.wdNumber();
        DataField wdState = WageDeterminationSearchPage.wdState();
        DataField wdCounty = WageDeterminationSearchPage.wdCounty();
        DataField wdRevision = WageDeterminationSearchPage.wdRevisionNum();
        DataField wdConstructionType = WageDeterminationSearchPage.wdConstructionType();
        DataField wdDate = WageDeterminationSearchPage.wdDate();

        // checking if field label and data exist for the following fields
        CommonUtils.testLabelAndDataExists(wdTitle, true);
        CommonUtils.testLabelAndDataExists(wdState, true);
        CommonUtils.testLabelAndDataExists(wdCounty, true);
        CommonUtils.testLabelAndDataExists(wdRevision, true);
        CommonUtils.testLabelAndDataExists(wdConstructionType, true);
        CommonUtils.testLabelAndDataExists(wdDate, true);

    }

    // test SCA common fields text results
    @Test
    public void searchFieldsTextSCATest() throws InterruptedException {
        WageDeterminationSearchNavigation.gotoWDObjectView("1981-0682");

        // gather field data into variables here
        DataField wdTitle = WageDeterminationSearchPage.wdNumber();
        DataField wdState = WageDeterminationSearchPage.wdState();
        DataField wdCounty = WageDeterminationSearchPage.wdCounty();
        DataField wdRevision = WageDeterminationSearchPage.wdRevisionNum();
        DataField wdConstructionType = WageDeterminationSearchPage.wdConstructionType();
        DataField wdDate = WageDeterminationSearchPage.wdDate();

        // checking if field label and data exist for the following fields
        CommonUtils.testDataContains(wdTitle, "1981-0682");
        CommonUtils.testDataContains(wdState, "Pennsylvania");
        CommonUtils.testDataContains(wdCounty, "Berks,Cumberland,Dauphin,Juniata,Lancaster,Lebanon,Mifflin,Montour,Northumberland,Perry,Snyder,Union,Bucks,Chester,Delaware,Lehigh,Montgomery,Northampton,Philadelphia,Allegheny,Armstrong,Beaver,Bedford,Blair,Butler,Cambria,Cameron,Centre,Clarion,Clearfield,Clinton,Crawford,Elk,Erie,Fayette,Forest,Fulton,Greene,Huntingdon,Indiana,Jefferson,Lawrence,McKean,Mercer,Potter,Somerset,Venango,Warren,Washington,Westmoreland,Bradford,Carbon,Columbia,Lackawanna,Luzerne,Lycoming,Monroe,Pike,Schuylkill,Sullivan,Susquehanna,Tioga,Wayne,Wyoming,Adams,York,Franklin");
        CommonUtils.testDataContains(wdRevision, "46");
        CommonUtils.testDataContains(wdConstructionType, "Forestry and Land Management Services");
        CommonUtils.testDataContains(wdDate, "Dec 30, 2016");

    }

    // check if inactive tag exists for DBA
    @Test
    public void inactiveTagTestDBA() throws InterruptedException {
        WageDeterminationSearchNavigation.gotoWDObjectView("ky20100141");
        System.out.println(WageDeterminationSearchPage.wdInactiveTag());
        assertEquals(WageDeterminationSearchPage.wdInactiveTag(), "INACTIVE");
        System.out.println("Inactive tag exists");
    }

    // check if inactive tag exists for SCA
    @Test
    public void inactiveTagTestSCA() throws InterruptedException {
        WageDeterminationSearchNavigation.gotoWDObjectView("1994-2002");
        System.out.println(WageDeterminationSearchPage.wdInactiveTag());
        assertEquals(WageDeterminationSearchPage.wdInactiveTag(), "INACTIVE");
        System.out.println("Inactive tag exists");
    }

    //"1994-2002"

    @AfterClass
    public static void end(){
        closeOut();
    }

}
