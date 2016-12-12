package gov.gsa.Tests;

import gov.gsa.Navigation.FACObjectViewNavigation;
import gov.gsa.Pages.FACObjectViewPage;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.GraphObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FACObjectViewTest extends Base{

    @BeforeClass
    public static void start() throws InterruptedException {

        setUp();

        try {
            FACObjectViewNavigation.gotoFACObjectView();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void falTitleTest(){
        assertTrue(FACObjectViewPage.falTitleExists());
    }

    @Test
    public void logoTest(){
        assertTrue(FACObjectViewPage.logo());
        System.out.println("Logo is Present in the Object View page");
    }

    @Test
    public void falHeader(){
        assertTrue("FAC Title is not found",FACObjectViewPage.falTitleExists());
        //assertTrue("Popular Name is empty",FACObjectViewPage.popularname() != "");
        System.out.println("FAC Header Section is Found");
    }

    @Test
    public void sideMenuTest(){
        assertTrue(FACObjectViewPage.falSideMenuPresent());
        System.out.println("Side Menu is Present in the Object View page");
    }

    @Test
    public void popularNameTest(){
        ArrayList<String> popular = FACObjectViewPage.popularname();
        if (popular.get(0) == "Popular Name not available")
            System.out.println("FAL does not have Popular Name field");
        else {
            assertTrue("Popular Name is empty", popular.get(0).contains("Popular Name:"));
            assertTrue("Popular Name Data is empty", popular.get(1).length() > 1);
            System.out.println("Popular Name Label and Data exists");
        }
    }

    @Test
    public void agencyNameTest() {
        ArrayList<String> agency = FACObjectViewPage.agencyname();
        assertTrue("Agency Name is empty", agency.get(0).contains("AGENCY:"));
        assertTrue("Agency Data is empty", agency.get(1).length() > 1);
        System.out.println("Agency Name Label and Data exists");
    }

    @Test
    public void cfdaNumberTest() {
        ArrayList<String> falnum = FACObjectViewPage.cfdaNumber();
        assertTrue("CFDA Number is empty", falnum.get(0).contains("CFDA Number:"));
        assertTrue("CFDA Number is empty", falnum.get(1).length() > 1);
        System.out.println("CFDA Number Label and Data exists");
    }

    @Test
    public void relatedAssistance() {
        assertTrue(FACObjectViewPage.relatedAssistance().length() > 1);
        System.out.println("Related Assistance Content is present");
    }

    @Test
    public void overviewTitle(){
        assertEquals("Overview title is not present", "Overview", FACObjectViewPage.overview());
        System.out.println("Overview Section is Present");
    }

    @Test
    public void objectives(){
        assertTrue("Objectives Content is not present", FACObjectViewPage.objectives().length() > 1);
        System.out.println("Objectives data is Present");
    }

    @Test
    public void examplesOfFundedProjects() {
        assertTrue("Examples of Funded Project Content is not present", FACObjectViewPage.examplesOfFunded().length() > 1);
        System.out.println("Examples of Funded Project data is Present");
    }

    @Test
    public void authorizationsTitle() {
        assertEquals("Authorization title is not present", "Authorizations", FACObjectViewPage.authorizationTitle());
        System.out.println("Authorization Section is Present");
    }

    @Test
    public void authorizations() {
        assertTrue("Authorization Data is not present", FACObjectViewPage.authorization().length() > 1);
        System.out.println("Authorization Data is Present");
    }

    @Test
    public void financialTitle() {
        assertEquals("Financial Information title is not present", "Financial Information",FACObjectViewPage.financialTitle() );
        System.out.println("Financial Information Section is Present");
    }

    @Test
    public void accomplishmentsData() {
        assertTrue("Accomplishments data is not present",FACObjectViewPage.accomplishments().length() > 1);
        System.out.println("Accomplishments data is present");
    }

    @Test
    public void rangeAndAverageOfFinancialAssistance() {
        assertTrue("Range and Average of Financial Assistance Content is not present", FACObjectViewPage.rangeAndAverage().length() > 1);
        System.out.println("Range and Average of Financial Assistance Data is Present");
    }

    @Test
    public void accountIdentificationTest() {
        assertTrue("Account Identification Content is not present", FACObjectViewPage.accountIdentification().length() > 1);
        System.out.println("Account Identification Data is Present");
    }

    @Test
    public void criteriaTitleTest() {
        assertEquals("Criteria for Applying is not present", "Criteria for Applying", FACObjectViewPage.criteriaTitle());
        System.out.println("Criteria for Applying Section is Present");
    }

    @Test
    public void typesOfAssistanceTest() {
        assertTrue("Type of Assistance Content is not present", FACObjectViewPage.typesOfAssistance().length() > 1);
        System.out.println("Type of Assistance Content is Present");
    }

    @Test
    public void credentialsAndDocumentation() {
        assertTrue("Credentials and Documentation Content is not present", FACObjectViewPage.crendentialsDocumentation().length() > 10);
        System.out.println("Credentials and Documentation Content is Present");
    }

    @Test
    public void applicantEligibilityTest() {
        ArrayList<String> applicant = FACObjectViewPage.applicantEligibility();
        assertEquals("Applicant Eligibility - Designation Title is not present", "Designations", applicant.get(0));
        assertTrue("Applicant Eligibility - Designation Content is not present", applicant.get(1).length() > 10);
        assertTrue("Applicant Eligibility Content is not present", applicant.get(2).length() > 10);
        System.out.println("Applicant Eligibility Content and Designations are Present");
    }

    @Test
    public void beneficiaryEligibilityTest() {
        ArrayList<String> beneficiary = FACObjectViewPage.applicantEligibility();
        assertEquals("Beneficiary Eligibility - Designation Title is not present", "Designations",beneficiary.get(0) );
        assertTrue("Beneficiary Eligibility - Designation Content is not present", beneficiary.get(1).length() > 10);
        assertTrue("Beneficiary Eligibility Content is not present", beneficiary.get(2).length() > 10);
        System.out.println("Beneficiary Eligibility Content is Present");
    }

    @Test
    public void lengthAndTimePhasingOfAssistance() {
        assertTrue("Length and Time Phasing of Assistance Content is not present", FACObjectViewPage.lengthAndPhasing().length() > 10);
        System.out.println("Length and Time Phasing of Assistance Content is Present");
    }

    @Test
    public void useOfAssistanceTest() {
        ArrayList<String> assistance = FACObjectViewPage.useOfAssistance();
        assertEquals("Use of Assistance Eligibility - Designation Title is not present", "Designations", assistance.get(0));
        assertTrue("Use of Assistance Eligibility - Designation Content is not present", assistance.get(1).length() > 10);
        assertTrue("Use of Assistance Content is not present", assistance.get(2).length() > 10);
        System.out.println("Use of Assistance Content is Present");
    }

    @Test
    public void applyingForAssistanceTitle() {
        assertEquals("Applying for Assistance Section is not present", "Applying for Assistance", FACObjectViewPage.applyingAssistanceTitle());
        System.out.println("Applying for Assistance Section is Present");
    }

    @Test
    public void deadlinesTest() {
        assertTrue("Deadlines Content is not present", FACObjectViewPage.deadlines().length() > 10);
        System.out.println("Deadlines Content is Present");
    }

    @Test
    public void preapplicationCoordination() {
        assertTrue("Preapplication Coordination Content is not present", FACObjectViewPage.preapplication().length() > 1);
        System.out.println("Preapplication Coordination Content is Present");
    }

    @Test
    public void applicationProceduresTest() {
        assertTrue("Application Procedures Content is not present", FACObjectViewPage.applicationProcedures().length() > 10);
        System.out.println("Application Procedures Content is Present");
    }

    @Test
    public void criteriaForSelectingProposals() {
        assertTrue("Criteria for Selecting Proposals Content is not present", FACObjectViewPage.criteriaSelectingProposals().length() > 10);
        System.out.println("Criteria for Selecting Proposals Content is Present");
    }

    @Test
    public void awardProcedures() {
        assertTrue("Award Procedure Content is not present", FACObjectViewPage.awardProcedure().length() > 10);
        System.out.println("Award Procedure Content is Present");
    }

    @Test
    public void dateRangeForApprovalDisapproval() {
        assertTrue("Date Range for Approval/Disapproval Content is not present", FACObjectViewPage.daterange().length() > 10);
        System.out.println("Date Range for Approval/Disapproval Content is Present");
    }

    @Test
    public void renewalsTest() {
        assertTrue("Renewals Content is not present", FACObjectViewPage.renewals().length() > 1);
        System.out.println("Renewals Content is Present");
    }

    @Test
    public void appealsTest() {
        assertTrue("Appeals Content is not present", FACObjectViewPage.appeals().length() > 1);
        System.out.println("Appeals Content is Present");
    }

    @Test
    public void complianceRequirementsTitle() {
        assertEquals("Compliance Requirements Section is not present", "Compliance Requirements", FACObjectViewPage.complianceTitle());
        System.out.println("Compliance Requirements Section is Present");
    }

    @Test
    public void reportsTest() {
        assertTrue("Reports Content is not present", FACObjectViewPage.reports().length() > 1);
        System.out.println("Reports Content is Present");
    }

    @Test
    public void auditsTest() {
        assertTrue("Audits Content is not present", FACObjectViewPage.audits().length() > 1);
        System.out.println("Audits Content is Present");
    }

    @Test
    public void recordsTest() {
        assertTrue("Records Content is not present", FACObjectViewPage.records().length() > 1);
        System.out.println("Records Content is Present");
    }

    @Test
    public void regulationsGuidelinesLiterature() {
        assertTrue("Regulations, Guidelines, and Literature Content is not present", FACObjectViewPage.regulations().length() > 1);
        System.out.println("Regulations, Guidelines, and Literature Content is Present");
    }

    @Test
    public void formulaAndMatchingRequirements() {
        assertTrue("Formula and Matching Requirements Content is not present", FACObjectViewPage.formulaAndMatching().length() > 1);
        System.out.println("Formula and Matching Requirements Content is Present");
    }

    @Test
    public void contactInformationTitle() {
        assertEquals("Contact Information Section is not present", "Contact Information", FACObjectViewPage.contactTitle());
        System.out.println("Contact Information Section is Present");
    }

    @Test
    public void regionalOrLocalOffice() {
        assertTrue("Regional or Local Office Content is not present", FACObjectViewPage.regionalOrLocal().length() > 1);
        System.out.println("Regional or Local Office Content is Present");
    }

   @Test
    public void headquartersOfficeTest() {
        assertTrue("Headquarters Office Content is not present", FACObjectViewPage.headquarters().length() > 1);
        System.out.println("Headquarters Office Content is Present");
    }

    @Test
    public void historyTitleTest() {
        assertEquals("History Section is not present", "History", FACObjectViewPage.historyTitle());
        System.out.println("History Section is Present");
    }

    @Test
    public void historyTest() {
        assertTrue("History Content is not present", FACObjectViewPage.historyContent().length() > 1);
        System.out.println("History Content is Present");
    }


    @Test
    public void sideMenuItemsTest() {
        assertEquals("Overview is not found in Side menu","Overview",FACObjectViewPage.overview());
        assertEquals("Authorizations", FACObjectViewPage.authorizations());
        assertEquals("Financial Information", FACObjectViewPage.financial());
        assertEquals("Criteria for Applying", FACObjectViewPage.criteria());
        assertEquals("Applying for Assistance", FACObjectViewPage.applyingforassistance());
        assertEquals("Compliance Requirements", FACObjectViewPage.compliance());
        assertEquals("Contact Information", FACObjectViewPage.contact());
        assertEquals("History", FACObjectViewPage.history());
        System.out.println("Side Menu Items Match in the FAL Object View page");
    }

    @Test
    public void falObligationsGraph() throws Exception {
        GraphObject graphObject = FACObjectViewPage.obligationsGraph();
        List<WebElement> xaxis = graphObject.getXaxis();
        assertEquals("FY 15", xaxis.get(0).getText());
        assertEquals("FY 16 (est.)", xaxis.get(1).getText());
        assertEquals("FY 17 (est.)", xaxis.get(2).getText());

        assertTrue(graphObject.getGraphsize() == 3);
        System.out.println("Obligations Graph is present and 3 bars are present");

    }

    @Test
    public void falObligationsTabular() throws Exception {
        List<WebElement> tabular = FACObjectViewPage.obligationsTabularView();

        assertTrue(tabular.get(0).getText().contains("Totals"));
        System.out.println("Obligations Tabular View is present ");
    }

    @AfterClass
    public static void end(){
        closeOut();
    }
}
