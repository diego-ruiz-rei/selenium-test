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


import java.text.ParseException;
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

    //Test Data for View Changes
    public static String synopsis_view_changes_opportunity = "c752657782129a4eddc1e39675a40c52";
    public static String new_data_view_changes_opportunity = "8b34bb89e0a3b3b562dd9d9fb65d4b89";
    public static String classification_view_changes_opportunity = "d79c65bcad52fb8d1cd5bb6a1e26f151";
    public static String general_information_view_changes_opportunity = "d79c65bcad52fb8d1cd5bb6a1e26f151";
    public static String special_legislation_view_changes_opportunity = "6261e9d373fffcb3f05bc067447e1a7a";

    //Test Data for History Section
    public static String history_section = "c752657782129a4eddc1e39675a40c52";
    public static String message = "Note: There have been updates to this opportunity. To view the most recent update/amendment, click here";


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

    @Test
    public void synopsisViewHideButtonToggleTest() throws InterruptedException{
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(synopsis_view_changes_opportunity);
        assertEquals("Hide Changes button does not exist",OpportunitiesObjectViewPage.synopsisViewHideChangesButton(), "Hide Changes");
    }

    @Test
    public void synopsisChangesFromDateTest() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(synopsis_view_changes_opportunity);
        assertTrue("Date does not match",OpportunitiesObjectViewPage.synopsisChangesFrom().contains(CommonUtils.formatDate(OpportunitiesObjectViewPage.historySectionDate())));
    }

    @Test
    public void synopsisTagExistsTest() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(synopsis_view_changes_opportunity);
        assertTrue("There are no updates to Synopsis Text",OpportunitiesObjectViewPage.synopsisTagExists().length()>=1);
    }

    @Test
    public void synopsisNewDataTest() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(new_data_view_changes_opportunity);
        assertTrue("New Data text is not displayed in Synopsis section",OpportunitiesObjectViewPage.synopsisTagExists().contains("New Data"));
    }

    @Test
    public void generalInformationViewHideButtonToggleTest() throws InterruptedException{
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(general_information_view_changes_opportunity);
        assertEquals("Hide Changes button does not exist",OpportunitiesObjectViewPage.generalInformationViewHideChangesButton(), "Hide Changes");
    }

    @Test
    public void generalInformationChangesFromDateTest() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(general_information_view_changes_opportunity);
        assertTrue("Date does not match",OpportunitiesObjectViewPage.generalInformationChangesFrom().contains(CommonUtils.formatDate(OpportunitiesObjectViewPage.historySectionDate())));
    }

    @Test
    public void generalInformationUpdateResponseDateTagExistsTest() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(new_data_view_changes_opportunity);
        assertTrue("There are no updates to Update/Amendment Responce Date Text",OpportunitiesObjectViewPage.generalInformationUpdateResponseDateTagExists().length()>=1);
    }

    @Test
    public void generalInformationArchivingPolicyTagExistsTest() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(general_information_view_changes_opportunity);
        assertTrue("There are no updates to Archiving Policy Text",OpportunitiesObjectViewPage.generalInformationArchivingPolicyTagExists().length()>=1);
    }

    @Test
    public void generalInformationUpdateArchiveDateTagExistsTest() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(new_data_view_changes_opportunity);
        assertTrue("There are no updates to Update Archive date Text",OpportunitiesObjectViewPage.generalInformationUpdateArchiveDateTagExists().length()>=1);
    }

    @Test
    public void generalInformationSpecialLegislationTagExistsTest() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(special_legislation_view_changes_opportunity);
        assertTrue("There are no updates to Special Legislation Text",OpportunitiesObjectViewPage.generalInformationSpecialLegislationTagExists().length()>=1);
    }

    @Test
    public void classificationViewHideButtonToggleTest() throws InterruptedException{
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(classification_view_changes_opportunity);
        assertEquals("Hide Changes button does not exist",OpportunitiesObjectViewPage.classificationViewHideChangesButton(), "Hide Changes");
    }

    @Test
    public void classificationChangesFromDateTest() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(classification_view_changes_opportunity);
        assertTrue("Date does not match",OpportunitiesObjectViewPage.classificationChangesFrom().contains(CommonUtils.formatDate(OpportunitiesObjectViewPage.historySectionDate())));
    }

    @Test
    public void classificationUpdateSetAsideTagExistsTest() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(classification_view_changes_opportunity);
        assertTrue("There are no updates to Update/Amendment Set Aside Text",OpportunitiesObjectViewPage.classificationUpdateSetAsideTagExists().length()>=1);
    }

    @Test
    public void classificationCodeTagExistsTest() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(new_data_view_changes_opportunity);
        assertTrue("There are no updates to Classification Code Text",OpportunitiesObjectViewPage.classificationCodeTagExists().length()>=1);
    }

    @Test
    public void classificationPlaceOfPerformanceTagExistsTest() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(classification_view_changes_opportunity);
        assertTrue("There are no updates to Place of Performance Text",OpportunitiesObjectViewPage.classificationPlaceOfPerformanceTagExists().length()>=1);
    }

    //History Section tests
    @Test
    public void historySectionTitleTest() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(history_section);
        assertTrue("History Section Title does not exist",OpportunitiesObjectViewPage.historySectionTitle().equals("History"));
    }

    @Test
    public void historySectionCountTest() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(history_section);
        assertTrue("History Section does not contains notices",OpportunitiesObjectViewPage.historySectionCount()>1);
    }

    @Test
    public void originalNoticeTextTest() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(history_section);
        assertTrue("History Section does not contains notices",OpportunitiesObjectViewPage.originalNoticeText().contains("Original"));
    }

    @Test
    public void previousVersionTest() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(history_section);
        String history_section_date = OpportunitiesObjectViewPage.historySectionDate();
        assertTrue("History Section - Previous Version link does not lead to correct page",history_section_date.contains(OpportunitiesObjectViewPage.previousVersionNoticePage()));
    }

    @Test
    public void updatedVersionMessageLink() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(history_section);
        assertTrue("History Section - Previous Version Message is not displayed",OpportunitiesObjectViewPage.updatedNoticeMessage().equals(message));
    }

    @Test
    public void updatedVersionLinkTest() throws InterruptedException, ParseException {
        OpportunitiesObjectViewNavigation.gotoOppObjectViewByID(history_section);
        assertTrue("History Section - Previous Version Message does not lead to correct page",OpportunitiesObjectViewPage.updatedNoticeLink().equals("current"));
    }

    @AfterClass
    public static void end(){
        Base.closeOut();
    }

}
