package gov.gsa.Tests;


import gov.gsa.Navigation.OpportunitiesObjectViewNavigation;
import gov.gsa.Pages.OpportunitiesObjectViewPage;
import gov.gsa.Utilities.Base;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;

import static gov.gsa.Utilities.CommonUtils.testFieldExists;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

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
        testFieldExists("Solicitation Number", OpportunitiesObjectViewPage.solicitation());
    }

    @Test
    public void officeTest() {
        testFieldExists("Office", OpportunitiesObjectViewPage.office());
    }

    @Test
    public void opportunityTypeTest() {
        testFieldExists("Opportunity Type", OpportunitiesObjectViewPage.oppType());
    }

    @Test
    public void postedDateTest() {
        testFieldExists("Posted Date", OpportunitiesObjectViewPage.postedDate());
    }

    //@Test
    public void originialPostedDateTest() {
        testFieldExists("Original Posted Date", OpportunitiesObjectViewPage.originalPosted());
    }

    @Test
    public void ResponseDateTest() {
        testFieldExists("Response Date", OpportunitiesObjectViewPage.responseDate());
    }

    //@Test
    public void originalResponseDateTest() {
        testFieldExists("Original Response Date", OpportunitiesObjectViewPage.originalResponse());
    }

    @Test
    public void archivingPolicyTest() {
        testFieldExists("Archiving Policy", OpportunitiesObjectViewPage.archivingPolicy());
    }

    // @Test
    public void originalSetAsideTest() {
        testFieldExists("Original Set Aside", OpportunitiesObjectViewPage.originalSetAside());
    }

    @Test
    public void classificationCodeTest() {
        testFieldExists("Classification Code", OpportunitiesObjectViewPage.classificationCode());
    }

    @Test
    public void naicsCodeTest() {
        assertTrue("NAICS Code(s) Data is empty", OpportunitiesObjectViewPage.naicscode().length() > 1);
        System.out.println("NAICS Code(s)Data exists");
    }

    @Test
    public void placeOfPerformanceTest() {
        testFieldExists("Place of Performance", OpportunitiesObjectViewPage.placeOfPerformance());
    }

    @Test
    public void contractingOfficeTest() {
        ArrayList<String> contracting = OpportunitiesObjectViewPage.contractingOffice();
        for (String temp : contracting) {
            assertTrue(temp.length() > 1);
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
