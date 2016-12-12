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

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OpportunitiesObjectViewTest extends Base{

    @BeforeClass
    public static void start() throws InterruptedException {

        setUp();

        try {
            OpportunitiesObjectViewNavigation.gotoOppObjectView();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void oppTitleTest(){
        assertTrue(OpportunitiesObjectViewPage.oppTitle());
        System.out.println("Title is Present in the Object View page");
    }

    @Test
    public void oppSideMenuItemsTest() {
        assertEquals("Overview is not found in Side menu","General Information", OpportunitiesObjectViewPage.generalInformation());
        assertEquals("Classification", OpportunitiesObjectViewPage.classification());
        assertEquals("Synopsis/Description", OpportunitiesObjectViewPage.synopsis());
        assertEquals("Packages", OpportunitiesObjectViewPage.packages());
        assertEquals("Contact Information", OpportunitiesObjectViewPage.contact());
        assertEquals("History", OpportunitiesObjectViewPage.history());
        System.out.println("Side Menu Items Match in the Opportunities Object View page");
    }

    @Test
    public void solicitationNumberTest() {
        ArrayList<String> sol = OpportunitiesObjectViewPage.solicitation();
        assertTrue("Solicitation Number is empty", sol.get(0).contains("Solicitation Number:"));
        assertTrue("Solicitation Number Data is empty", sol.get(1).length() > 1);
        System.out.println("Solicitation Number Label and Data exists");
    }

    @Test
    public void officeTest() {
        ArrayList<String> office = OpportunitiesObjectViewPage.office();
        assertTrue("Office Name is empty", office.get(0).contains("Office:"));
        assertTrue("Office Data is empty", office.get(1).length() > 1);
        System.out.println("Office Name Label and Data exists");
    }

    @Test
    public void opportunityTypeTest() {
        ArrayList<String> opp_type = OpportunitiesObjectViewPage.oppType();
        assertTrue("Opportunity Type Name is empty", opp_type.get(0).contains("Opportunity Type:"));
        assertTrue("Opportunity Type Data is empty", opp_type.get(1).length() > 1);
        System.out.println("Opportunity Type Label and Data exists");
    }

    @Test
    public void postedDateTest() {
        ArrayList<String> posted = OpportunitiesObjectViewPage.postedDate();
        assertTrue("Posted Date Name is empty", posted.get(0).contains("Posted Date:"));
        assertTrue("Posted Date Data is empty", posted.get(1).length() > 1);
        System.out.println("Posted Date Label and Data exists");
    }

    //@Test
    public void originialPostedDateTest() {
        ArrayList<String> originalposted = OpportunitiesObjectViewPage.originalPosted();
        assertTrue("Original Posted Date Label is empty", originalposted.get(0).contains("Original Posted Date:"));
        assertTrue("Original Posted Date Data is empty", originalposted.get(1).length() > 1);
        System.out.println("Original Posted Date Label and Data exists");
    }

    @Test
    public void ResponseDateTest() {
        ArrayList<String> response = OpportunitiesObjectViewPage.resposnseDate();
        assertTrue("Response Date Label is empty", response.get(0).contains("Response Date:"));
        assertTrue("Response Date Data is empty", response.get(1).length() > 1);
        System.out.println("Response Date Label and Data exists");
    }

    //@Test
    public void originalResponseDateTest() {
        ArrayList<String> originalresponse = OpportunitiesObjectViewPage.originalResponse();
        assertTrue("Original Response Date Label is empty", originalresponse.get(0).contains("Original Response Date:"));
        assertTrue("Original Response Date Data is empty", originalresponse.get(1).length() > 1);
        System.out.println("Original Response Date Label and Data exists");
    }

    @Test
    public void archivingPolicyTest() {
        ArrayList<String> archiving = OpportunitiesObjectViewPage.archivingPolicy();
        assertTrue("Archiving Policy is empty", archiving.get(0).contains("Archiving Policy:"));
        assertTrue("Archiving Policy Data is empty", archiving.get(1).length() > 1);
        System.out.println("Archiving Policy Label and Data exists");
    }

    // @Test
    public void originalSetAsideTest() {
        ArrayList<String> ori_setaside = OpportunitiesObjectViewPage.originalSetAside();
        assertTrue("Original Set Aside is empty", ori_setaside.get(0).contains("Original Set Aside:"));
        assertTrue("Original Set Aside Data is empty", ori_setaside.get(1).length() > 1);
        System.out.println("Original Set Aside Label and Data exists");
    }

    @Test
    public void classificationCodeTest() {
        ArrayList<String> classification = OpportunitiesObjectViewPage.classificationCode();
        assertTrue("Classification Code is empty", classification.get(0).contains("Classification Code:"));
        assertTrue("Classification Code Data is empty", classification.get(1).length() > 1);
        System.out.println("Classification Code Label and Data exists");
    }

    @Test
    public void naicsCodeTest() {
        assertTrue("NAICS Code(s) Data is empty", OpportunitiesObjectViewPage.naicscode().length() > 1);
        System.out.println("NAICS Code(s)Data exists");
    }

    @Test
    public void placeOfPerformanceTest() {
        ArrayList<String> place = OpportunitiesObjectViewPage.placeOfPerformance();
        assertTrue("Place of Performance is empty", place.get(0).contains("Place of Performance:"));
        assertTrue("Place of Performance Data is empty", place.get(1).length() > 1);
        System.out.println("Place of Performance Label and Data exists");
    }

    @Test
    public void contractingOfficeTest() {
        ArrayList<String> contracting = oppobject.contractingOffice();
        for (String temp : contracting)
        {
            assertTrue(temp.length() >1);
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
    public static void end(){
        closeOut();
    }
}
