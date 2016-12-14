package gov.gsa.Tests;

/**
 * Created by michael.kellogg on 12/6/16.
 */

import gov.gsa.Utilities.Base;
import gov.gsa.Tests.FACObjectViewTest;
import gov.gsa.Tests.HomepageTest;
import gov.gsa.Tests.OpportunitiesObjectViewTest;
import gov.gsa.Tests.SearchTest;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


//
// this class uses annotations to run all the test classes in one location
//
@RunWith(Suite.class)
@Suite.SuiteClasses({HomepageTest.class, FACObjectViewTest.class, OpportunitiesObjectViewTest.class, SearchTest.class})
public class allSmokeTests extends Base{

}
