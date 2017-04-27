package gov.gsa.Tests.opportunities;

import gov.gsa.Navigation.OpportunitiesObjectViewNavigation;
import gov.gsa.Pages.OpportunitiesAwardsTabObjectViewPage;
import gov.gsa.Pages.OpportunitiesObjectViewPage;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils.DataField;

import gov.gsa.Utilities.ObjectView;
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
import java.util.List;

import static gov.gsa.Utilities.CommonUtils.*;
import static org.junit.Assert.*;

/**
 * Created by RKumar on 4/24/2017.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OpportunitiesAwardsTabTest extends Base{

    public static String awards_Opportunity = "ad617288a06bc01bfd9a0017688fbfa6";

    @BeforeClass
    public static void start() throws InterruptedException {
        Base.setUp();
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(awards_Opportunity);
    }

    @Test
    public void awardNoticeSideMenuTest() throws InterruptedException {
        assertEquals("Award Notices is not found in Side menu","Award Notices", ObjectView.awardNotices());
        assertEquals("Award Summary is not found in Side Menu","Award Summary", ObjectView.awardSummary());
    }

    @Test
    public void awardsSummaryTitleTest() throws InterruptedException {
        assertEquals("Award Summary Title is not found in Side Menu","Awards Summary", OpportunitiesAwardsTabObjectViewPage.awardsSummaryTitle());
    }

    @Test
    public void totalNumberOfAwardsTest() throws InterruptedException {
        DataField total_number = OpportunitiesAwardsTabObjectViewPage.totalNumberOfAwards();
        testLabelAndDataExists(total_number);
        testLabelContains(total_number, "Total Number of Awards");
    }

    @Test
    public void totalAmountAwardedTest() throws InterruptedException {
        DataField total_awarded = OpportunitiesAwardsTabObjectViewPage.totalAmountAwarded();
        testLabelAndDataExists(total_awarded);
        testLabelContains(total_awarded, "Total Amount Awarded");
    }

    @Test
    public void totalNumberOfRecipientsTest() throws InterruptedException {
        DataField total_recipients = OpportunitiesAwardsTabObjectViewPage.totalNumberOfRecipients();
        testLabelAndDataExists(total_recipients);
        testLabelContains(total_recipients, "Total Number of Recipients");
    }

    @Test
    public void resultsComparisonTest() throws InterruptedException {
        assertEquals("Results does not match with Total Number of Awards",OpportunitiesAwardsTabObjectViewPage.numberOfResults(), OpportunitiesAwardsTabObjectViewPage.totalNumberOfAwards().data);
    }

    @Test
    public void listOfAwardsTest() throws InterruptedException {
        assertTrue("Awards List is not displayed",OpportunitiesAwardsTabObjectViewPage.listOfRecords()>1);
    }

    @Test
    public void sortByCompanyTest() throws Exception {
        assertTrue(OpportunitiesAwardsTabObjectViewPage.sortByCompany());
    }

    @Test
    public void sortByDollarAmountTest() throws Exception {
        assertTrue(OpportunitiesAwardsTabObjectViewPage.sortByDollarAmount());
    }

    @Test
    public void contractorAwardedDUNSTest() throws InterruptedException {
        List<DataField> duns = OpportunitiesAwardsTabObjectViewPage.contractorAwardedDUNS();
        for(DataField d:duns) {
            testLabelAndDataExists(d);
            testLabelContains(d, "Contractor Awarded DUNS");
        }
    }

    @Test
    public void contractorAwardDollarAmountTest() throws InterruptedException {
        List<DataField> amount = OpportunitiesAwardsTabObjectViewPage.contractorAwardDollarAmount();
        for(DataField d:amount) {
            testLabelAndDataExists(d);
            testLabelContains(d, "Contract Award Dollar Amount");
        }
    }

    @Test
    public void contractorAwardedAddressTest() throws InterruptedException {
        List<DataField> address = OpportunitiesAwardsTabObjectViewPage.contractorAwardedAddress();
        for(DataField d:address) {
            testLabelAndDataExists(d);
            testLabelContains(d, "Contractor Awarded Address");
        }
    }

    @Test
    public void contractorAwardNumberTest() throws InterruptedException {
        List<DataField> number = OpportunitiesAwardsTabObjectViewPage.contractAwardNumber();
        for(DataField d:number) {
            testLabelAndDataExists(d);
            testLabelContains(d, "Contract Award Number");
        }
    }

    @Test
    public void contractorAwardDateTest() throws InterruptedException {
        List<DataField> date = OpportunitiesAwardsTabObjectViewPage.contractorAwardDate();
        for(DataField d:date) {
            testLabelAndDataExists(d);
            testLabelContains(d, "Contract Award Date");
            testLabelContains(d, "Contract Award Date");
        }
    }

    @AfterClass
    public static void end(){
        Base.closeOut();
    }
}
