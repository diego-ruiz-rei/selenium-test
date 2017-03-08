package gov.gsa.Tests.federalHierarchy;

import gov.gsa.Navigation.FederalHierarchyObjectViewNavigation;
import gov.gsa.Pages.FederalHierarchyObjectViewPage;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import gov.gsa.Utilities.GraphObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Ascii.toUpperCase;
import static gov.gsa.Utilities.CommonUtils.testLabelAndDataExists;
import static gov.gsa.Utilities.CommonUtils.testLabelContains;
import static org.junit.Assert.*;


/**
 * Created by RKumar on 2/21/2017.
 */



public class FHObjectViewHelper extends Base{

    @Test
    public void fhTitleTest() throws InterruptedException{
        assertTrue(FederalHierarchyObjectViewPage.fhTitle());
        System.out.println("Title is Present in the FH Object View page");
    }

    @Test
    public void fhlogoTest(){
        assertTrue(FederalHierarchyObjectViewPage.logo());
        System.out.println("Logo is Present in the FH Object View page");
    }

    @Test
    public void fpdsOrgIdTest() throws InterruptedException {
        CommonUtils.DataField fpds_org_id = FederalHierarchyObjectViewPage.fpdsOrgID();
        testLabelAndDataExists(fpds_org_id);
        testLabelContains(fpds_org_id, "FPDS Org ID");
    }

    @Test
    public void statusTest() throws InterruptedException {
        CommonUtils.DataField status = FederalHierarchyObjectViewPage.status();
        testLabelContains(status, "Status Active");
    }

    @Test
    public void noOfResultsTest() throws InterruptedException{
        assertTrue("Number of results is missing in FH Object View page",FederalHierarchyObjectViewPage.noOfResults().contains("1"));
        System.out.println("Number of Results are displayed");
    }

    @Test
    public void listOfSubTierAgenciesTest() throws InterruptedException{
        assertTrue("List of Sub Tier Agencies does not exist",FederalHierarchyObjectViewPage.listOfSubTier());
        System.out.println("SubTier Agencies are listed in the FH Object View page");
    }

    @Test
    public void paginationTest() throws InterruptedException{
        assertTrue("Pagination does not exist",FederalHierarchyObjectViewPage.pagination());
        System.out.println("Pagination is present in the FH Object View page");
    }


}

