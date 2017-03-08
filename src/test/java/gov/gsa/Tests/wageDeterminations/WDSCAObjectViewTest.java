package gov.gsa.Tests.wageDeterminations;

import gov.gsa.Navigation.WDObjectViewNavigation;
import gov.gsa.Pages.WageDeterminationObjectViewPage;
import gov.gsa.Utilities.CommonUtils;
import gov.gsa.Utilities.ObjectView;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import gov.gsa.Utilities.CommonUtils.DataField;

import static gov.gsa.Utilities.CommonUtils.testLabelAndDataExists;
import static gov.gsa.Utilities.CommonUtils.testLabelContains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by RKumar on 3/7/2017.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WDSCAObjectViewTest extends WDObjectViewHelper{

    @BeforeClass
    public static void start() throws InterruptedException {
        WDObjectViewHelper.sca_searchTerm = "1967-0442";
        setUp();
        WDObjectViewNavigation.gotoWDObjectView(sca_searchTerm);

    }

    @Test
    public void wdSCATitleTest() throws InterruptedException {
        assertEquals("WD SCA Title is not present",WageDeterminationObjectViewPage.wdTitle(), "SCA WD # "+sca_searchTerm);
        System.out.println("SCA Title exists and matches with Search term");
    }

    @Test
    public void wdSCATypeTest() throws InterruptedException {
        assertEquals("SCA Type is not present",WageDeterminationObjectViewPage.wdType(), "Service Contract Act");
        System.out.println("SCA Type is displayed");
    }

    @Test
    public void wdSCASideMenuTest() throws InterruptedException {
        assertEquals("SCA Side Menu Element is not present", ObjectView.wdSideMenuItem(), "SCA WD # "+sca_searchTerm);
        System.out.println("SCA Side Menu is displayed");
    }

    @Test
    public void wdServicesTest() throws InterruptedException{
        DataField services = WageDeterminationObjectViewPage.services();
        testLabelAndDataExists(services);
        testLabelContains(services,"Service/Services");
        System.out.println("Services Field is Present in the WD Object View page");
    }

    //Test for Published or Last Revised Date
    @Test
    public void wdSCADateTest() throws InterruptedException{
        DataField revision = WageDeterminationObjectViewPage.revision();
        DataField date = WageDeterminationObjectViewPage.date();
        testLabelAndDataExists(date);
        if(new Integer(revision.data) == 1){
            testLabelContains(date,"Published Date");
            System.out.println("Published Date Field is Present in the WD Object View page");
        }
        else{
            testLabelContains(date,"Last Revised Date");
            System.out.println("Last Revised Date Field is Present in the WD Object View page");
        }
    }

    @AfterClass
    public static void end(){
        closeOut();
    }


}
