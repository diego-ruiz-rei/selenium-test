package gov.gsa.Tests.wageDeterminations;

import gov.gsa.Navigation.WDObjectViewNavigation;
import gov.gsa.Pages.WageDeterminationObjectViewPage;
import gov.gsa.Utilities.CommonUtils;
import gov.gsa.Utilities.ObjectView;
import org.junit.*;
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
    public static String history_searchTerm = "AK20170001";
    public static String showmore_history_searchTerm = "IL20170008";
    public static String revisionName = "Revision 3";

    @BeforeClass
    public static void start() throws InterruptedException {
        WDObjectViewHelper.dba_searchTerm = "AL20170102";
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

    @Test
    public void zzwdDBAHistoryRevisionTest() throws InterruptedException{
        Thread.sleep(2000);
        WDObjectViewNavigation.gotoWDObjectView(history_searchTerm);
        Thread.sleep(3000);
        if(!revisionName.isEmpty()) {
            WageDeterminationObjectViewPage.getHistoryRevision(revisionName);
            Thread.sleep(3000);
        }
        assertTrue("WD Latest History Revision number donot match", WageDeterminationObjectViewPage.getHistoryRevisionNumberFromHistory().equals(WageDeterminationObjectViewPage.getHistoryRevisionNumber()));
        assertTrue("WD Latest History Revision Date donot match", WageDeterminationObjectViewPage.getHistoryRevisionDateFromHistory().equals(WageDeterminationObjectViewPage.getHistoryRevisionDate()));

    }

    @Test
    public void zzwdDBAMoreRevisionsTest() throws InterruptedException{
        WDObjectViewNavigation.gotoWDObjectView(showmore_history_searchTerm);
        Thread.sleep(3000);
        WageDeterminationObjectViewPage.showMoreHistory();
        assertTrue("WD More revisions not loaded", WageDeterminationObjectViewPage.getTotalHistoryRevisions() > 5);
    }

    @AfterClass
    public static void end(){
        closeOut();
    }


}
