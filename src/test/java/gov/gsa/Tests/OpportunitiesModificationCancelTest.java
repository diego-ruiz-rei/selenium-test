package gov.gsa.Tests;
import gov.gsa.Navigation.OpportunitiesObjectViewNavigation;
import gov.gsa.Pages.OpportunitiesObjectViewPage;
import gov.gsa.Utilities.Base;
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

    @AfterClass
    public static void end(){
        Base.closeOut();
    }

}
