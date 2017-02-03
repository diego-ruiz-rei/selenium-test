package gov.gsa.Tests;


import gov.gsa.Navigation.OpportunitiesObjectViewNavigation;
import gov.gsa.Pages.OpportunitiesObjectViewPage;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils.DataField;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static gov.gsa.Utilities.CommonUtils.testLabelAndDataExists;
import static gov.gsa.Utilities.CommonUtils.testLabelContains;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(value = Parameterized.class)
public class OpportunitiesObjectViewTest extends Base {


    @Parameterized.Parameter
    public String[] idAndType;

    //Single parameter, use Object[]
    @Parameterized.Parameters(name = "{index}: opportunityId - {0}")
    public static Collection <Object[]> data() {
        return  Arrays.asList(new Object[][]{
//                {new String[]{"F4FRQT3091A007","k"}},
//                {new String[]{"VA24816Q0997","k"}},
//                {new String[]{"N00253-16-T-0385","a"}}
                {new String[]{"AAA-AAA-11-1111","p"}},
                {new String[]{"AAA-AAA-11-1112","k"}},
                {new String[]{"AAA-AAA-11-1113","f"}},
                {new String[]{"AAA-AAA-11-1114","g"}},
                {new String[]{"AAA-AAA-11-1115","r"}},
                {new String[]{"AAA-AAA-11-1116","i"}},
                {new String[]{"AAA-AAA-11-1117","j"}},
                {new String[]{"AAA-AAA-11-1118","a"}},
                {new String[]{"AAA-AAA-11-1119","l"}},
                {new String[]{"AAA-AAA-11-1120","s"}},
        });
    }

    @Test
    public void aaastart() throws InterruptedException {

        setUp();

        //TODO : need to pass search parameter
        try {
            System.out.println("Opportunity ID: " + idAndType[0]);
            OpportunitiesObjectViewNavigation.gotoOppObjectView(idAndType[0]);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void oppTitleTest() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("oppTitleTest Results: " + OpportunitiesObjectViewPage.oppTitle());
            assertTrue(OpportunitiesObjectViewPage.oppTitle());
            System.out.println("Title is Present in the Object View page");
    }

    @Test
    public void oppSideMenuItemsTest() {
        assertEquals("Overview is not found in Side menu", "General Information", OpportunitiesObjectViewPage.generalInformation());
        assertEquals("Classification", OpportunitiesObjectViewPage.classification());
        assertEquals("Synopsis/Description", OpportunitiesObjectViewPage.synopsis());
        assertEquals("Packages", OpportunitiesObjectViewPage.packages());
        assertEquals("Contact Information", OpportunitiesObjectViewPage.contact());
        //assertEquals("History", OpportunitiesObjectViewPage.history());
        System.out.println("Side Menu Items Match in the Opportunities Object View page");
    }

    @Test
    public void solicitationNumberTest() {
        DataField solicitation = OpportunitiesObjectViewPage.solicitation();
        testLabelAndDataExists(solicitation);
        testLabelContains(solicitation, "Solicitation Number");
    }

    @Test
    public void officeTest() {
        DataField office = OpportunitiesObjectViewPage.office();
        testLabelAndDataExists(office);
        testLabelContains(office, "Office");
    }

    @Test
    public void opportunityTypeTest() {
        DataField opportunityType = OpportunitiesObjectViewPage.oppType();
        testLabelAndDataExists(opportunityType);
        testLabelContains(opportunityType, "Opportunity Type");
    }

    @Test
    public void postedDateTest() {
        DataField postedDate = OpportunitiesObjectViewPage.postedDate();
        testLabelAndDataExists(postedDate);
        testLabelContains(postedDate, "Posted Date");
    }

    //@Test
    public void originalPostedDateTest() {
        DataField originalPostedDate = OpportunitiesObjectViewPage.originalPosted();
        testLabelAndDataExists(originalPostedDate);
        testLabelContains(originalPostedDate, "Original Posted Date");
    }

    @Test
    public void responseDateTest() {
        if (!idAndType[1].equals("a")) {
            DataField responseDate = OpportunitiesObjectViewPage.responseDate();
            testLabelAndDataExists(responseDate);
            testLabelContains(responseDate, "Response Date");
        }
        else {
            System.out.println("Irrelevant Type");
        }
    }

    //@Test
    public void originalResponseDateTest() {
        DataField originalResponseDate = OpportunitiesObjectViewPage.originalResponse();
        testLabelAndDataExists(originalResponseDate);
        testLabelContains(originalResponseDate, "Original Response Date");
    }

    @Test
    public void archivingPolicyTest() {
        DataField archivePolicy = OpportunitiesObjectViewPage.archivingPolicy();
        testLabelAndDataExists(archivePolicy);
        testLabelContains(archivePolicy, "Archiving Policy");
    }

    // @Test
    public void originalSetAsideTest() {
        DataField originalSetAside = OpportunitiesObjectViewPage.originalSetAside();
        testLabelAndDataExists(originalSetAside);
        testLabelContains(originalSetAside, "Original Set Aside");
    }

    @Test
    public void classificationCodeTest() {
        if (!idAndType[1].equals("a")) {
            DataField classificationCode = OpportunitiesObjectViewPage.classificationCode();
            testLabelAndDataExists(classificationCode);
            testLabelContains(classificationCode, "Classification Code");
        }
        else {
            System.out.println("Irrelevant Type");
        }
    }

    @Test
    public void naicsCodeTest() {
        if (!idAndType[1].equals("a")) {
            assertTrue("NAICS Code(s) Data is empty", !OpportunitiesObjectViewPage.naicsCode().isEmpty());
            System.out.println("NAICS Code(s)Data exists");
            }
        else {
            System.out.println("Irrelevant Type");
        }
    }

    @Test
    public void placeOfPerformanceTest() {
        if (!idAndType[1].equals("a")) {
            DataField pop = OpportunitiesObjectViewPage.placeOfPerformance();
            testLabelAndDataExists(pop);
            testLabelContains(pop, "Place of Performance");
        }
        else {
            System.out.println("Irrelevant Type");
        }
    }

    @Test
    public void contractingOfficeTest() {
        ArrayList<String> contracting = OpportunitiesObjectViewPage.contractingOffice();
        for (String temp : contracting) {
            assertFalse(temp.isEmpty());
        }

        System.out.println("Contracting Office Data exists");
    }

    @Test
    public void primaryPointOfContactTest() {
        if (!idAndType[1].equals("a")) {
        ArrayList<String> primarypoc = OpportunitiesObjectViewPage.primaryPointOfContact();
        assertTrue("Primary POC Name is empty", primarypoc.get(0).length() > 1);
        assertTrue("Primary POC Email is empty", primarypoc.get(1).length() > 1);
        assertTrue("Primary POC Phone Number is empty", primarypoc.get(2).length() > 1);
        System.out.println("Primary Point of Contact Data exists");
        }
        else {
            System.out.println("Irrelevant Type");
        }
    }


    @Test
    public void contractAwardDollarAmountTest(){
        if (idAndType[1].equals("a")) {
            DataField contractAwardDollarAmount = OpportunitiesObjectViewPage.contractAwardDollarAmount();
            testLabelAndDataExists(contractAwardDollarAmount);
            testLabelContains(contractAwardDollarAmount, "Contract Award Dollar Amount");
        }
        else {
            System.out.println("Irrelevant Type");
        }
    }
    @Test
    public void contractAwardDateTest(){
        if (idAndType[1].equals("a") || idAndType[1].equals("j") || idAndType[1].equals("l")) {
            DataField contractAwardDate = OpportunitiesObjectViewPage.contractAwardDate();
            testLabelAndDataExists(contractAwardDate);
            testLabelContains(contractAwardDate, "Contract Award Date");
        }
        else {
            System.out.println("Irrelevant Type");
        }
    }
    @Test
    public void contractAwardNumberTest(){
        if (idAndType[1].equals("a") || idAndType[1].equals("j") || idAndType[1].equals("l") || idAndType[1].equals("i")) {
            DataField contractAwardNumber = OpportunitiesObjectViewPage.contractAwardNumber();
            testLabelAndDataExists(contractAwardNumber);
            testLabelContains(contractAwardNumber, "Contract Award Number");
        }
        else {
            System.out.println("Irrelevant Type");
        }
    }
    @Test
    public void contractLineItemNumberTest(){
        if (idAndType[1].equals("a")) {
            DataField contractLineItemNumber = OpportunitiesObjectViewPage.contractLineItemNumber();
            testLabelAndDataExists(contractLineItemNumber);
            testLabelContains(contractLineItemNumber, "Contract Line Item Number");
        }
        else {
            System.out.println("Irrelevant Type");
        }
    }

    @Test
    public void contractorAwardedNameTest(){
        if (idAndType[1].equals("a")) {
            DataField contractorAwardedName = OpportunitiesObjectViewPage.contractorAwardedName();
            testLabelAndDataExists(contractorAwardedName);
            testLabelContains(contractorAwardedName, "Contractor Awarded Name");
        }
        else {
            System.out.println("Irrelevant Type");
        }
    }

    @Test
    public void contractorAwardedDUNSTest(){
        if (idAndType[1].equals("a")) {
            DataField contractorAwardedDUNS = OpportunitiesObjectViewPage.contractorAwardedDUNS();
            testLabelAndDataExists(contractorAwardedDUNS);
            testLabelContains(contractorAwardedDUNS, "Contractor Awarded DUNS");
        }
        else {
            System.out.println("Irrelevant Type");
        }
    }

    @Test
    public void contractorAwardedAddressTest(){
        if (idAndType[1].equals("a")) {
            DataField contractorAwardedAddress = OpportunitiesObjectViewPage.contractorAwardedAddress();
            testLabelAndDataExists(contractorAwardedAddress);
            testLabelContains(contractorAwardedAddress, "Contractor Awarded Address");
        }
        else {
            System.out.println("Irrelevant Type");
        }
    }

    @Test
    public void statutoryAuthorityTest(){
        if (idAndType[1].equals("j")) {
            DataField statutoryAuthority = OpportunitiesObjectViewPage.statutoryAuthority();
            testLabelAndDataExists(statutoryAuthority);
            testLabelContains(statutoryAuthority, "J&A Statutory Authority");
        }
        else {
            System.out.println("Irrelevant Type");
        }
    }

    @Test
    public void justificationAuthorityTest(){
        if (idAndType[1].equals("l")) {
            DataField justificationAuthority = OpportunitiesObjectViewPage.justificationAuthority();
            testLabelAndDataExists(justificationAuthority);
            testLabelContains(justificationAuthority, "Fair Opportunity / Limited Sources Justification Authority");
        }
        else {
            System.out.println("Irrelevant Type");
        }
    }

    @Test
    public void orderNumberTest(){
        if (idAndType[1].equals("i") || idAndType[1].equals("l")) {
            DataField orderNumber = OpportunitiesObjectViewPage.orderNumber();
            testLabelAndDataExists(orderNumber);
            testLabelContains(orderNumber, "Task/Delivery Order Number");
        }
        else {
            System.out.println("Irrelevant Type");
        }
    }

    @Test
    public void specialLegislationTest(){
        if (idAndType[1].equals("p") || idAndType[1].equals("k") || idAndType[1].equals("r") || idAndType[1].equals("j") || idAndType[1].equals("a") || idAndType[1].equals("l") || idAndType[1].equals("s")) {
            DataField specialLegislation = OpportunitiesObjectViewPage.specialLegislation();
            testLabelAndDataExists(specialLegislation);
            testLabelContains(specialLegislation, "Special Legislation");
        }
        else {
            System.out.println("Irrelevant Type");
        }
    }

    @Test
    public void zzzcloseOutTest(){
        closeOut();
    }


    @AfterClass
    public static void end() {
        closeOut();
    }
}
