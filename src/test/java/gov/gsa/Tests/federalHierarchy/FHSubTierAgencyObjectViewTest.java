package gov.gsa.Tests.federalHierarchy;

import gov.gsa.Navigation.FederalHierarchyObjectViewNavigation;
import gov.gsa.Pages.FederalHierarchyObjectViewPage;
import gov.gsa.Tests.federalHierarchy.FHObjectViewHelper;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static gov.gsa.Utilities.CommonUtils.testLabelAndDataExists;
import static gov.gsa.Utilities.CommonUtils.testLabelContains;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FHSubTierAgencyObjectViewTest extends FHObjectViewHelper {

    public static String FH_Department = "health and human services, department of The Secretary of HHS";
    public static String org_id = "100004223";
    public static String FH_Agency = "U.s. Office of Consumer Affairs";



    @BeforeClass
    public static void start() throws InterruptedException {

        Base.setUp();

        try {
        //    FederalHierarchyObjectViewNavigation.gotoFHObjectViewByID(org_id);
            FederalHierarchyObjectViewNavigation.gotoFHObjectView(FH_Department);
            FederalHierarchyObjectViewPage.agencyDrillDown(FH_Agency);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void departmentLinkInAgencyObjectViewPageTest() throws InterruptedException{
        CommonUtils.DataField department = FederalHierarchyObjectViewPage.departmentLinkInAgencyObjectView();
        testLabelAndDataExists(department);
        testLabelContains(department, "DEPARTMENT");
    }

    @Test
    public void officesSectionTitleTest() throws InterruptedException{
        assertTrue("Offices Section Title is missing in FH Object View page",FederalHierarchyObjectViewPage.subTierAgencyOrOfficeSection().contains("Offices"));
        System.out.println("Offices Title is Present ");
    }

    @AfterClass
    public static void end(){
        Base.closeOut();
    }
}
