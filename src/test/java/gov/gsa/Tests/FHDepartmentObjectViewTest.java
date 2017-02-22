package gov.gsa.Tests;

import gov.gsa.Navigation.FederalHierarchyObjectViewNavigation;
import gov.gsa.Utilities.Base;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FHDepartmentObjectViewTest extends FHObjectViewHelper {

    public static String FH_SearchTerm = "health and human services, department of";

    @BeforeClass
    public static void start() throws InterruptedException {

        Base.setUp();

        try {
            FederalHierarchyObjectViewNavigation.gotoFHObjectView(FH_SearchTerm);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /*@Test
    public void officeDrillDownTest() throws InterruptedException{
        String office = toUpperCase(FederalHierarchyObjectViewPage.officeDrillDown());
        assertEquals(office,FH_Office);
        System.out.println("***");
    }*/


    @AfterClass
    public static void end(){
        Base.closeOut();
    }
}
