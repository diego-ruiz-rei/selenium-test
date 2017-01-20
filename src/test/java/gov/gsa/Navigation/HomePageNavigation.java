package gov.gsa.Navigation;

import gov.gsa.Utilities.Base;
/**
 * Created by michael.kellogg on 12/6/16.
 */

public class HomePageNavigation{

    public HomePageNavigation(){
        Base.setUp();
        System.out.println("The super class call is happening");

    }

    public static void gotoHomePage() throws InterruptedException {
        Base.driver.get(Base.full_url);
        //Base.driver.get("http://gsaiae-sga-ui-dev02.reisys.com");
    }



}
