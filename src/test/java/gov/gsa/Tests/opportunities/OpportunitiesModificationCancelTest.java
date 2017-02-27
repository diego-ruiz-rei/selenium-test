package gov.gsa.Tests.opportunities;
import gov.gsa.Navigation.OpportunitiesObjectViewNavigation;
import gov.gsa.Pages.OpportunitiesObjectViewPage;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import gov.gsa.Utilities.CommonUtils.DataField;

import org.apache.commons.lang.ArrayUtils;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static gov.gsa.Utilities.CommonUtils.*;
import static org.junit.Assert.*;


/**
 * Created by RKumar on 2/24/2017.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OpportunitiesModificationCancelTest extends Base {

    public static String updated_Opportunity = "021374cdc6fe1bf1d8953fea6baca905";
    public static String canceled_Opportunity = "116243cfd37fcf39662e2bc427381828";
    public static String updated_dates_Opportunity = "92f2ee13116885b29718a63debe6064f";
    public static String updated_setaside_Opportunity = "efe9c041ce7f02ae5a4ef89981e898d1";

    @BeforeClass
    public static void start() throws InterruptedException {
        Base.setUp();
    }

    @Test
    public void updatedOpportunityTypeTest() throws InterruptedException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(updated_Opportunity);
        DataField opportunity_type = OpportunitiesObjectViewPage.opportunityType();
        testLabelAndDataExists(opportunity_type);
        testLabelContains(opportunity_type, "Opportunity Type");
        testDataContains(opportunity_type, "Updated");
    }

    @Test
    public void canceledOpportunityTypeTest() throws InterruptedException{
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(canceled_Opportunity);
        DataField opportunity_type = OpportunitiesObjectViewPage.opportunityType();
        testLabelAndDataExists(opportunity_type);
        testLabelContains(opportunity_type, "Opportunity Type");
        testDataContains(opportunity_type, "Canceled");
    }

    @Test
    public void updatedPostedDateTest() throws InterruptedException{
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(updated_dates_Opportunity);
        CommonUtils.DataField updatedPostedDate = OpportunitiesObjectViewPage.updatedPostedDate();
        testLabelAndDataExists(updatedPostedDate);
        testLabelContains(updatedPostedDate, "Update/Amendment Posted Date");
    }

    @Test
    public void updatedResponseDateTest() throws InterruptedException{
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(updated_dates_Opportunity);
        CommonUtils.DataField updatedResponseDate = OpportunitiesObjectViewPage.updatedResponseDate();
        testLabelAndDataExists(updatedResponseDate);
        testLabelContains(updatedResponseDate, "Update/Amendment Response Date");
    }

    @Test
    public void updatedArchiveDateTest() throws InterruptedException{
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(updated_dates_Opportunity);
        CommonUtils.DataField updatedArchiveDate = OpportunitiesObjectViewPage.updatedArchiveDate();
        testLabelAndDataExists(updatedArchiveDate);
        testLabelContains(updatedArchiveDate, "Update/Amendment Archive Date");
    }

    @Test
    public void updatedSetAsideTest() throws InterruptedException{
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(updated_setaside_Opportunity);
        CommonUtils.DataField updatedSetAside = OpportunitiesObjectViewPage.updatedSetAside();
        testLabelAndDataExists(updatedSetAside);
        testLabelContains(updatedSetAside, "Update/Amendment Set Aside");
    }

    @AfterClass
    public static void end(){
        Base.closeOut();
    }

}
