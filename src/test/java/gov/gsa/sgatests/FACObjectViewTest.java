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

    @Test
    public void FACObjectView() throws Exception{
        facobject.appWait();
        facobject.gotoFACObjectView();
        facobject.logo();
        facobject.FACSideMenu();
        facobject.FACHeader();
        facobject.FACObjectViewSections();
        facobject.obligationsGraph();
        //facobject.obligationsTabularView();
    }

    @After
    public void end(){
        facobject.closeOut();
    }
}
