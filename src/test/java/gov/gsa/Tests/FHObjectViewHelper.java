package gov.gsa.Tests;

import gov.gsa.Navigation.FederalHierarchyObjectViewNavigation;
import gov.gsa.Navigation.FederalHierarchySearchNavigation;
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



public class FHObjectViewHelper {

    public void fhTitle() throws InterruptedException{
        assertTrue(FederalHierarchyObjectViewPage.fhTitle());
        System.out.println("Title is Present in the FH Object View page");
    }


    public void fhlogo(){
        assertTrue(FederalHierarchyObjectViewPage.logo());
        System.out.println("Logo is Present in the FH Object View page");
    }


    public void fpdsOrgId() throws InterruptedException {
        CommonUtils.DataField fpds_org_id = FederalHierarchyObjectViewPage.fpdsOrgID();
        testLabelAndDataExists(fpds_org_id);
        testLabelContains(fpds_org_id, "FPDS Org ID");
    }

    public void status() throws InterruptedException {
        CommonUtils.DataField status = FederalHierarchyObjectViewPage.status();
        testLabelContains(status, "Status Active");
    }

    public void fhDescription() throws InterruptedException{
        assertTrue("Description is missing in FH Object View page",FederalHierarchyObjectViewPage.description());
        System.out.println("Description is Present in the FH Object View page");
    }


    public void subTierAgenciesSectionTitle() throws InterruptedException{
        assertTrue("Sub Tier Agencies Section Title is missing in FH Object View page",FederalHierarchyObjectViewPage.subTierAgencyOrOfficeSection().contains("Sub-Tier Agencies"));
        System.out.println("Sub-Tier Agencies Title is Present ");
    }

    public void officesSectionTitle() throws InterruptedException{
        assertTrue("Offices Section Title is missing in FH Object View page",FederalHierarchyObjectViewPage.subTierAgencyOrOfficeSection().contains("Offices"));
        System.out.println("Offices Title is Present ");
    }

    public void noOfResults() throws InterruptedException{
        assertTrue("Number of results is missing in FH Object View page",FederalHierarchyObjectViewPage.noOfResults().contains("1 - 10"));
        System.out.println("Number of Results are displayed");
    }

    public void listOfSubTierAgencies() throws InterruptedException{
        assertTrue("List of Sub Tier Agencies does not exist",FederalHierarchyObjectViewPage.listOfSubTier());
        System.out.println("SubTier Agencies are listed in the FH Object View page");
    }

    public void pagination() throws InterruptedException{
        assertTrue("Pagination does not exist",FederalHierarchyObjectViewPage.pagination());
        System.out.println("Pagination is present in the FH Object View page");
    }


    public void departmentLinkInAgencyObjectViewPage() throws InterruptedException{
        CommonUtils.DataField department = FederalHierarchyObjectViewPage.departmentLinkInAgencyObjectView();
        testLabelAndDataExists(department);
        testLabelContains(department, "DEPARTMENT");
    }


}

