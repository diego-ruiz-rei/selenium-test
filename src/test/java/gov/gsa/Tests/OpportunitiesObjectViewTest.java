package gov.gsa.Tests;


import gov.gsa.Navigation.OpportunitiesObjectViewNavigation;
import gov.gsa.Pages.OpportunitiesObjectViewPage;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils.DataField;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.ArrayList;

import static gov.gsa.Utilities.CommonUtils.testLabelAndDataExists;
import static gov.gsa.Utilities.CommonUtils.testLabelContains;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OpportunitiesObjectViewTest extends Base {

    @BeforeClass
    public static void start() throws InterruptedException {

        setUp();

        //TODO : need to pass search parameter
        try {
            OpportunitiesObjectViewNavigation.gotoOppObjectView("F4FRQT3091A007");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void oppTitleTest() {
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
    public void ResponseDateTest() {
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


    @AfterClass
    public static void end() {
        closeOut();
    }
}
