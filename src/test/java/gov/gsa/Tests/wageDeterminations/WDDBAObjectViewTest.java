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
public class WDDBAObjectViewTest extends WDObjectViewHelper{
    // Any variables needed here
    @BeforeClass
    public static void start() throws InterruptedException {
        WDObjectViewHelper.dba_searchTerm = "AZ20170007";
        setUp();
        WDObjectViewNavigation.gotoWDObjectView(dba_searchTerm);
    }

    @Test
    public void wdDBATitleTest() throws InterruptedException {
        assertEquals("WD DBA title is not Present",WageDeterminationObjectViewPage.wdTitle(), "DBA WD # "+dba_searchTerm);
        System.out.println("DBA Title exists and matches with Search term");
    }

    @Test
    public void wdDBATypeTest() throws InterruptedException {
        assertEquals("DBA Type is not present",WageDeterminationObjectViewPage.wdType(), "Davis-Bacon Act");
        System.out.println("DBA Type is displayed");
    }

    @Test
    public void wdDBASideMenuTest() throws InterruptedException {
        assertEquals("DBA Side Menu Element is not present", ObjectView.wdSideMenuItem(), "DBA WD # "+dba_searchTerm);
        System.out.println("DBA Side Menu is displayed");
    }

    @Test
    public void wdConstructionTest() throws InterruptedException{
        DataField construction = WageDeterminationObjectViewPage.constructionType();
        testLabelAndDataExists(construction);
        testLabelContains(construction,"Construction");
        System.out.println("Construction Field is Present in the WD Object View page");
    }

    @Test
    public void wdDBADateTest() throws InterruptedException{
        DataField revision = WageDeterminationObjectViewPage.revision();
        DataField date = WageDeterminationObjectViewPage.date();
        testLabelAndDataExists(date);
        if(new Integer(revision.data) == 0){
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
