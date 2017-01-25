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

//    public class IdAndType{
//         String id;
//         String type;
//
//        public IdAndType(String id, String type){
//            this.id = id;
//            this.type = type;
//            System.out.println("Constructor ID: " + this.id + " Type: " + this.type);
//        }
//    }

    @Parameterized.Parameter
    public String[] idAndType;

    //Single parameter, use Object[]
    @Parameterized.Parameters(name = "{index}: opportunityId - {0}")
    public static Collection <Object[]> data() {
        return  Arrays.asList(new Object[][]{
                {new String[]{"F4FRQT3091A007","k"}},
                {new String[]{"VA24816Q0997","k"}},
                {new String[]{"N00253-16-T-0385","a"}}
//                {"F4FRQT3091A007","k"},
//                {"VA24816Q0997","k"},
//                {"N00253-16-T-0385","a"}
//                new IdAndType("F4FRQT3091A007","k"),
//                new IdAndType("VA24816Q0997","k"),
//                new IdAndType("N00253-16-T-0385","a")
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
    public void originialPostedDateTest() {
        DataField originalPostedDate = OpportunitiesObjectViewPage.originalPosted();
        testLabelAndDataExists(originalPostedDate);
        testLabelContains(originalPostedDate, "Original Posted Date");
    }

    @Test
    public void responseDateTest() {
        DataField responseDate = OpportunitiesObjectViewPage.responseDate();
        testLabelAndDataExists(responseDate);
        testLabelContains(responseDate, "Response Date");
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
        DataField classificationCode = OpportunitiesObjectViewPage.classificationCode();
        testLabelAndDataExists(classificationCode);
        testLabelContains(classificationCode, "Classification Code");
    }

    @Test
    public void naicsCodeTest() {
        assertTrue("NAICS Code(s) Data is empty", !OpportunitiesObjectViewPage.naicsCode().isEmpty());
        System.out.println("NAICS Code(s)Data exists");
    }

    @Test
    public void placeOfPerformanceTest() {
        DataField pop = OpportunitiesObjectViewPage.placeOfPerformance();
        testLabelAndDataExists(pop);
        testLabelContains(pop, "Place of Performance");
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
        ArrayList<String> primarypoc = OpportunitiesObjectViewPage.primaryPointOfContact();
        assertTrue("Primary POC Name is empty", primarypoc.get(0).length() > 1);
        assertTrue("Primary POC Email is empty", primarypoc.get(1).length() > 1);
        assertTrue("Primary POC Phone Number is empty", primarypoc.get(2).length() > 1);
        System.out.println("Primary Point of Contact Data exists");
    }

    @Test
    public void contractAwardDollarAmountTest(){
        System.out.println("Type: " + idAndType[1]);
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
    public void contractAwardDate(){
        System.out.println("Type: " + idAndType[1]);
        if (idAndType[1].equals("a") || idAndType[1].equals("j") || idAndType[1].equals("l")) {
            DataField contractAwardDate = OpportunitiesObjectViewPage.contractAwardDollarAmount();
            testLabelAndDataExists(contractAwardDate);
            testLabelContains(contractAwardDate, "Contract Award Dollar Amount");
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
