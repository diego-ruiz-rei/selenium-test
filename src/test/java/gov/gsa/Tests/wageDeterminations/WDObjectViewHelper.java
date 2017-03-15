package gov.gsa.Tests.wageDeterminations;

import gov.gsa.Navigation.SearchNavigation;
import gov.gsa.Navigation.WDObjectViewNavigation;
import gov.gsa.Pages.WageDeterminationObjectViewPage;

import gov.gsa.Pages.WageDeterminationSearchPage;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import gov.gsa.Utilities.GraphObject;
import gov.gsa.Utilities.ObjectView;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Ascii.toUpperCase;
import static gov.gsa.Utilities.CommonUtils.*;
import static org.junit.Assert.*;

/**
 * Created by RKumar on 3/7/2017.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WDObjectViewHelper extends Base{
    //Test Data
    public static String dba_searchTerm = "";
    public static String sca_searchTerm = "";

    @Test
    public void wdTitleTest() throws InterruptedException{
        assertTrue("WD Title is not present",WageDeterminationObjectViewPage.wdTitle().length()>1);
        System.out.println("Title is Present in the WD Object View page");
    }

    @Test
    public void wdLogoTest() throws InterruptedException{
        assertTrue("WD Logo is not Present",ObjectView.logo());
        System.out.println("Logo is Present in the WD Object View page");
    }

    @Test
    public void wdSideMenuTest() throws InterruptedException {
        assertEquals("SCA Side Menu Element is not present", ObjectView.wdSideMenuItem(), "Wage Determination");
        System.out.println("SCA Side Menu is displayed");
    }

    @Test
    public void wdStateTest() throws InterruptedException{
        DataField state = WageDeterminationObjectViewPage.state();
        testLabelAndDataExists(state);
        testLabelContains(state,"State");
        System.out.println("State Field is Present in the WD Object View page");
    }

    @Test
    public void wdMultipleStateCountyCountTest() throws InterruptedException{
        assertTrue("Multiple State/Counties are not displayed",WageDeterminationObjectViewPage.multipleStateCountiesCount() > 1);
        System.out.println("Multiple States and Counties Fields are Present in the WD Object View page");
    }


    /*TODO create tests for Search and Object View Data Match
    @Test
    public void wdStateDataMatchTest() throws InterruptedException{
        DataField state = WageDeterminationObjectViewPage.state();

        SearchNavigation.gotoSearchResultsPage("Wage Determination",dba_searchTerm);
        DataField search_state = WageDeterminationSearchPage.wdState();

        System.out.println("State Data in Search : "+search_state.data+"\nState Data in Object View :"+state.data);
        assertEquals("State Field - Search result and Object View data does not match",search_state.data,state.data);

        System.out.println("State Field - Search result and Object View data matches");
    }
    */

    @Test
    public void wdCountiesTest() throws InterruptedException{
        DataField county = WageDeterminationObjectViewPage.counties();
        testLabelAndDataExists(county);
        testLabelContains(county,"Counties");
        System.out.println("Counties Field is Present in the WD Object View page");
    }

    @Test
    public void wdRevisionTest() throws InterruptedException{
        DataField revision = WageDeterminationObjectViewPage.revision();
        testLabelAndDataExists(revision);
        testLabelContains(revision,"Revision #");
        System.out.println("Revision Field is Present in the WD Object View page");
    }

    @Test
    public void wdDocumentTest() throws InterruptedException{
        assertTrue("WD Document is not present",WageDeterminationObjectViewPage.wdDocument().length()>1);
        System.out.println("Document is Present in the WD Object View page");
    }

    @Test
    public void wdPrinterFriendlyLinkTest() throws InterruptedException{
        assertTrue("Printer Friendly Link is not Present",WageDeterminationObjectViewPage.printerFriendlyLink().contains("Printer Friendly"));
        System.out.println("Printer Friendly Link is Present in the WD Object View page");
    }

    @Test
    public void printerFriendlyStatusCodeTest() {
        try {
            int code = WageDeterminationObjectViewPage.printerFriendlyStatusCode();
            assertTrue("Error code returned", code == 200);
            System.out.println("HTTP code 200 returned");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException " + e);
        } catch (IOException e) {
            System.out.println("IOException " + e);
        }
    }

}
