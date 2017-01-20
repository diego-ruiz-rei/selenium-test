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
import java.util.List;
import java.util.function.Consumer;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OpportunitiesObjectViewTest extends Base{

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

    /**
     * Process a {@code List} containing information about a field.
     * The field's label and data are split up and processing delegates to the appropriate {@code Consumer}.
     *
     * Precondition: {@code List} contains field's label in first element and field's data in second element
     * Postcondition: {@code labelConsumer} is passed field's label and {@code dataConsumer} is passed field's data
     */
    public static void processField(List<String> fieldParse, Consumer<String> labelConsumer, Consumer<String> dataConsumer) {
        labelConsumer.accept(fieldParse.get(0));
        dataConsumer.accept(fieldParse.get(1));
    }

    /** Convenience method to test that a field exists; see overloaded method for details **/
    public static void testFieldExists(String fieldLabel, ArrayList<String> fieldParse) {
        testFieldExists(fieldLabel, fieldParse, true);
    }

    /**
     * Verifies either that a field that should exist does and has some data,
     * or that a field that shouldn't exist does not and has no data, based on the value of {@code shouldExist} param
     *
     * @param fieldLabel The label that the field is expected to have (this should also be the field's name)
     * @param fieldParse {@code List} containing information about a field
     * @param shouldExist {@code true} if the field is expected to exist, else {@code false}
     *
     * Precondition: {@code List} contains field's label in first element and field's data in second element
     */
    public static void testFieldExists(String fieldLabel, List<String> fieldParse, boolean shouldExist) {
        String labelErrorMessage = fieldLabel + (shouldExist ? " label does not exist" : " label exists");
        String dataErrorMessage = fieldLabel + (shouldExist ? " data is empty" : " data is not empty");

        processField(
            fieldParse,
            label -> assertEquals(labelErrorMessage, label.contains(fieldLabel), shouldExist), // check label
            data -> assertEquals(dataErrorMessage, !data.isEmpty(), shouldExist) // check data
        );

        System.out.println(fieldLabel + (shouldExist ? " Label and Data exist" : " Label and Data do not exist"));
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
