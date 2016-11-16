package gov.gsa.sgatests;

import gov.gsa.sga.*;
import gov.gsa.sga.Base;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static junit.framework.Assert.assertTrue;

public class FACObjectViewTest {

    FACObjectView facobject = new FACObjectView();
    //ObjectView object = new ObjectView();

    @Test
    public void FACObjectView() throws Exception{
        facobject.appWait();
        facobject.gotoFACObjectView();
        facobject.logo();
        facobject.FACSideMenu();
        facobject.FACHeader();
        //facobject.getFACObjectPage();
    }

    @After
    public void end(){
        facobject.closeOut();
    }
}
