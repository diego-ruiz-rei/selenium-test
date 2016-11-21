package gov.gsa.sgatests;

import gov.gsa.sga.*;
import gov.gsa.sga.Base;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FACObjectViewTest {

    static FACObjectView facobject = new FACObjectView();

    @BeforeClass
    public static void start() throws InterruptedException {
        try {
            facobject.gotoFACObjectView();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void falTitleTest(){
        assertTrue(facobject.falTitle());
    }

    @Test
    public void logoTest(){
        assertTrue(facobject.logo());
        System.out.println("Logo is Present in the Object View page");
    }

    @Test
    public void falHeader(){
        assertTrue("FAC Title is not found",facobject.falTitle());
        //assertTrue("Popular Name is empty",facobject.popularname() != "");
        System.out.println("FAC Header Section is Found");
    }

    @Test
    public void sideMenuTest(){
        assertTrue(facobject.falSideMenuPresent());
        System.out.println("Side Menu is Present in the Object View page");
    }

    @Test
    public void popularNameTest(){
        ArrayList<String> popular = facobject.popularname();
        assertTrue("Popular Name is empty", popular.get(0).contains("Popular Name:"));
        assertTrue("Popular Name Data is empty", popular.get(1).length() > 1);
        System.out.println("Popular Name Label and Data exists");
    }

    @Test
    public void agencyNameTest() {
        ArrayList<String> agency = facobject.agencyname();
        assertTrue("Agency Name is empty", agency.get(0).contains("AGENCY:"));
        assertTrue("Agency Data is empty", agency.get(1).length() > 1);
        System.out.println("Agency Name Label and Data exists");
    }

    @Test
    public void falNumberTest() {
        ArrayList<String> falnum = facobject.falNumber();
        assertTrue("FAL Number is empty", falnum.get(0).contains("FAL Number:"));
        assertTrue("FAL Number is empty", falnum.get(1).length() > 1);
        System.out.println("FAL Number Label and Data exists");
    }

    @Test
    public void overviewTitle(){
        assertEquals("Overview title is not present", "Overview", facobject.overview());
        System.out.println("Overview Section is Present");
    }

    @Test
    public void objectives(){
        assertTrue("Objectives Content is not present", facobject.objectives().length() > 1);
        System.out.println("Objectives data is Present");
    }

    @Test
    public void examplesOfFundedProjects() {
        assertTrue("Examples of Funded Project Content is not present", facobject.examplesOfFunded().length() > 1);
        System.out.println("Examples of Funded Project data is Present");
    }

    @Test
    public void authorizationsTitle() {
        assertEquals("Authorization title is not present", "Authorizations", facobject.authorizationTitle());
        System.out.println("Authorization Section is Present");
    }

    @Test
    public void authorizations() {
        assertTrue("Authorization Data is not present", facobject.authorization().length() > 1);
        System.out.println("Authorization Data is Present");
    }

    @Test
    public void financialTitle() {
        assertEquals("Financial Information title is not present", "Financial Information",facobject.financialTitle() );
        System.out.println("Financial Information Section is Present");
    }

    @Test
    public void accomplishmentsData() {
        assertTrue("Accomplishments data is not present",facobject.accomplishments().length() > 1);
        System.out.println("Accomplishments data is present");
    }

    @Test
    public void rangeAndAverageOfFinancialAssistance() {
        assertTrue("Range and Average of Financial Assistance Content is not present", facobject.rangeAndAverage().length() > 1);
        System.out.println("Range and Average of Financial Assistance Data is Present");
    }

    @Test
    public void accountIdentificationTest() {
        assertTrue("Account Identification Content is not present", facobject.accountIdentification().length() > 1);
        System.out.println("Account Identification Data is Present");
    }

    @Test
    public void criteriaTitleTest() {
        assertEquals("Criteria for Applying is not present", "Criteria for Applying", facobject.criteriaTitle());
        System.out.println("Criteria for Applying Section is Present");
    }

    @Test
    public void typesOfAssistanceTest() {
        assertTrue("Type of Assistance Content is not present", facobject.typesOfAssistance().length() > 1);
        System.out.println("Type of Assistance Content is Present");
    }

    @Test
    public void credentialsAndDocumentation() {
        assertTrue("Credentials and Documentation Content is not present", facobject.crendentialsDocumentation().length() > 10);
        System.out.println("Credentials and Documentation Content is Present");
    }

    @Test
    public void applicantEligibilityTest() {
        ArrayList<String> applicant = facobject.applicantEligibility();
        assertEquals("Applicant Eligibility - Designation Title is not present", "Designations", applicant.get(0));
        assertTrue("Applicant Eligibility - Designation Content is not present", applicant.get(1).length() > 10);
        assertTrue("Applicant Eligibility Content is not present", applicant.get(2).length() > 10);
        System.out.println("Applicant Eligibility Content and Designations are Present");
    }

    @Test
    public void beneficiaryEligibilityTest() {
        ArrayList<String> beneficiary = facobject.applicantEligibility();
        assertEquals("Beneficiary Eligibility - Designation Title is not present", "Designations",beneficiary.get(0) );
        assertTrue("Beneficiary Eligibility - Designation Content is not present", beneficiary.get(1).length() > 10);
        assertTrue("Beneficiary Eligibility Content is not present", beneficiary.get(2).length() > 10);
        System.out.println("Beneficiary Eligibility Content is Present");
    }

    @Test
    public void lengthAndTimePhasingOfAssistance() {
        assertTrue("Length and Time Phasing of Assistance Content is not present", facobject.lengthAndPhasing().length() > 10);
        System.out.println("Length and Time Phasing of Assistance Content is Present");
    }

    @Test
    public void useOfAssistanceTest() {
        ArrayList<String> assistance = facobject.useOfAssistance();
        assertEquals("Use of Assistance Eligibility - Designation Title is not present", "Designations", assistance.get(0));
        assertTrue("Use of Assistance Eligibility - Designation Content is not present", assistance.get(1).length() > 10);
        assertTrue("Use of Assistance Content is not present", assistance.get(2).length() > 10);
        System.out.println("Use of Assistance Content is Present");
    }

    @Test
    public void applyingForAssistanceTitle() {
        assertEquals("Applying for Assistance Section is not present", "Applying for Assistance", facobject.applyingAssistanceTitle());
        System.out.println("Applying for Assistance Section is Present");
    }

    @Test
    public void deadlinesTest() {
        assertTrue("Deadlines Content is not present", facobject.deadlines().length() > 10);
        System.out.println("Deadlines Content is Present");
    }

    @Test
    public void preapplicationCoordination() {
        assertTrue("Preapplication Coordination Content is not present", facobject.preapplication().length() > 10);
        System.out.println("Preapplication Coordination Content is Present");
    }

    @Test
    public void applicationProceduresTest() {
        assertTrue("Application Procedures Content is not present", facobject.applicationProcedures().length() > 10);
        System.out.println("Application Procedures Content is Present");
    }

    @Test
    public void criteriaForSelectingProposals() {
        assertTrue("Criteria for Selecting Proposals Content is not present", facobject.criteriaSelectingProposals().length() > 10);
        System.out.println("Criteria for Selecting Proposals Content is Present");
    }

    @Test
    public void awardProcedures() {
        assertTrue("Award Procedure Content is not present", facobject.awardProcedure().length() > 10);
        System.out.println("Award Procedure Content is Present");
    }

    @Test
    public void dateRangeForApprovalDisapproval() {
        assertTrue("Date Range for Approval/Disapproval Content is not present", facobject.daterange().length() > 10);
        System.out.println("Date Range for Approval/Disapproval Content is Present");
    }

    @Test
    public void renewalsTest() {
        assertTrue("Renewals Content is not present", facobject.renewals().length() > 1);
        System.out.println("Renewals Content is Present");
    }

    //@Test
    public void appealsTest() {
        assertTrue("Appeals Content is not present", facobject.appeals().length() > 1);
        System.out.println("Appeals Content is Present");
    }

    @Test
    public void complianceRequirementsTitle() {
        assertEquals("Compliance Requirements Section is not present", "Compliance Requirements", facobject.complianceTitle());
        System.out.println("Compliance Requirements Section is Present");
    }

    @Test
    public void reportsTest() {
        assertTrue("Reports Content is not present", facobject.reports().length() > 1);
        System.out.println("Reports Content is Present");
    }

    @Test
    public void auditsTest() {
        assertTrue("Audits Content is not present", facobject.audits().length() > 1);
        System.out.println("Audits Content is Present");
    }

    @Test
    public void recordsTest() {
        assertTrue("Records Content is not present", facobject.records().length() > 1);
        System.out.println("Records Content is Present");
    }

    @Test
    public void regulationsGuidelinesLiterature() {
        assertTrue("Regulations, Guidelines, and Literature Content is not present", facobject.regulations().length() > 1);
        System.out.println("Regulations, Guidelines, and Literature Content is Present");
    }

    @Test
    public void formulaAndMatchingRequirements() {
        assertTrue("Formula and Matching Requirements Content is not present", facobject.formulaAndMatching().length() > 1);
        System.out.println("Formula and Matching Requirements Content is Present");
    }

    @Test
    public void contactInformationTitle() {
        assertEquals("Contact Information Section is not present", "Contact Information", facobject.contactTitle());
        System.out.println("Contact Information Section is Present");
    }

    @Test
    public void regionalOrLocalOffice() {
        assertTrue("Regional or Local Office Content is not present", facobject.regionalOrLocal().length() > 1);
        System.out.println("Regional or Local Office Content is Present");
    }

   // @Test
    public void headquartersOfficeTest() {
        assertTrue("Headquarters Office Content is not present", facobject.headquarters().length() > 1);
        System.out.println("Headquarters Office Content is Present");
    }

    @Test
    public void historyTitleTest() {
        assertEquals("History Section is not present", "History", facobject.historyTitle());
        System.out.println("History Section is Present");
    }

    @Test
    public void historyTest() {
        assertTrue("History Content is not present", facobject.historyContent().length() > 1);
        System.out.println("History Content is Present");
    }


    @Test
    public void sideMenuItemsTest() {
        assertEquals("Overview is not found in Side menu","Overview",facobject.overview());
        assertEquals("Authorizations", facobject.authorizations());
        assertEquals("Financial Information", facobject.financial());
        assertEquals("Criteria for Applying", facobject.criteria());
        assertEquals("Applying for Assistance", facobject.applyingforassistance());
        assertEquals("Compliance Requirements", facobject.compliance());
        assertEquals("Contact Information", facobject.contact());
        assertEquals("History", facobject.history());
        System.out.println("Side Menu Items Match in the FAL Object View page");
    }

    @Test
    public void falObligationsGraph() throws Exception {
        FACObjectView.GraphObject graphObject = facobject.obligationsGraph();
        List<WebElement> xaxis = graphObject.getXaxis();
        assertEquals("FY 15", xaxis.get(0).getText());
        assertEquals("FY 16 (est.)", xaxis.get(1).getText());
        assertEquals("FY 17 (est.)", xaxis.get(2).getText());

        assertTrue(graphObject.getGraphsize() == 3);
        System.out.println("Obligations Graph is present and 3 bars are present");

    }

    @AfterClass
    public static void end(){
        facobject.closeOut();
    }
}
