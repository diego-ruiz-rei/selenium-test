package gov.gsa.Tests;

/**
 * Created by michael.kellogg on 12/6/16.
 */

import gov.gsa.Utilities.Base;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


//
// this class uses annotations to run all the test classes in one location
//
@RunWith(Suite.class)
@Suite.SuiteClasses({HomepageTest.class,
        SearchTest.class,
        FederalHierarchySearchTest.class,
        EntitiesSearchTest.class,
        FACObjectViewTest.class,
        OpportunitiesObjectViewTest.class,
        OpportunitiesPackagesTest.class
        })
public class allSmokeTests extends Base{
}
