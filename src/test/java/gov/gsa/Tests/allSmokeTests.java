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
//@Suite.SuiteClasses({HomepageTest.class, FACObjectViewTest.class, OpportunitiesObjectViewTest.class, SearchTest.class,
//OpportunitiesPackagesTest.class, FederalHierarchyObjectViewTest.class})
@Suite.SuiteClasses({HomepageTest.class, FederalHierarchyObjectViewTest.class})
public class allSmokeTests extends Base{
}
