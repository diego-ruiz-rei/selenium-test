package gov.gsa.Tests.suites;

/**
 * Created by michael.kellogg on 12/6/16.
 */

import gov.gsa.Tests.assistanceListings.AssistanceListingObjectViewTest;
import gov.gsa.Tests.assistanceListings.AssistanceListingSearchTest;
import gov.gsa.Tests.entities.EntitiesSearchTest;
import gov.gsa.Tests.exclusions.ExclusionsSearchTest;
import gov.gsa.Tests.federalHierarchy.FHDepartmentObjectViewTest;
import gov.gsa.Tests.federalHierarchy.FHSubTierAgencyObjectViewTest;
import gov.gsa.Tests.federalHierarchy.FederalHierarchySearchTest;
import gov.gsa.Tests.home.HomepageTest;
import gov.gsa.Tests.opportunities.*;
import gov.gsa.Tests.wageDeterminations.WDDBAObjectViewTest;
import gov.gsa.Tests.wageDeterminations.WDDBASearchTest;
import gov.gsa.Tests.wageDeterminations.WDSCAObjectViewTest;
import gov.gsa.Tests.wageDeterminations.WDSCASearchTest;
import gov.gsa.Utilities.Base;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


//
// this class uses annotations to run all the test classes in one location
//
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AssistanceListingObjectViewTest.class,
        OpportunitiesObjectViewTest.class,
        OpportunitiesPackagesTest.class,
        OpportunitiesModificationCancelTest.class,
        OpportunitiesAwardsTabTest.class,
        FHDepartmentObjectViewTest.class,
        FHSubTierAgencyObjectViewTest.class,
        WDDBAObjectViewTest.class,
        WDSCAObjectViewTest.class,
        })
public class ObjectViewSmokeTests extends Base{
}
