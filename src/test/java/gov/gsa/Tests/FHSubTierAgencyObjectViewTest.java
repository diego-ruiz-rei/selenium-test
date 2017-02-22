package gov.gsa.Tests;

import gov.gsa.Navigation.FederalHierarchyObjectViewNavigation;
import gov.gsa.Pages.FederalHierarchyObjectViewPage;
import gov.gsa.Utilities.Base;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FHSubTierAgencyObjectViewTest extends FHObjectViewHelper {

    public static String FH_Department = "health and human services, department of";
    public static String FH_Agency = "Social Security Administration";



    @BeforeClass
    public static void start() throws InterruptedException {

        Base.setUp();

        try {
            FederalHierarchyObjectViewNavigation.gotoFHObjectView(FH_Department);
            FederalHierarchyObjectViewPage.agencyDrillDown(FH_Agency);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterClass
    public static void end(){
        Base.closeOut();
    }
}
