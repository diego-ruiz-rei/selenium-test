package gov.gsa.sgatests;

import gov.gsa.sga.Base;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static junit.framework.Assert.assertEquals;

public class HomepageTest {
    Base home = new Base();

   @Test
    public void homePageElements() throws Exception{
        //Home Page test
        home.appWait();
        assertEquals("SAM Client Starter", home.getPageTitle());
        System.out.println("\n--Home Page Elements--");
        System.out.println("Page Title : "+home.getPageTitle());

        //Search By Index Dropdown test
        Assert.assertTrue((home.isElementPresent(By.id("filter"))));
        assertEquals("All", home.getDriver().findElement(By.cssSelector("option")).getText());
        assertEquals("Opportunities", home.getDriver().findElement(By.cssSelector("option[value=\"fbo\"]")).getText());
        assertEquals("Assistance Listings", home.getDriver().findElement(By.cssSelector("option[value=\"cfda\"]")).getText());
        System.out.println("Index Dropdown Present : "+home.getDriver().findElement(By.id("filter")).getText());

        //Search Box Present
        Assert.assertTrue(home.isElementPresent(By.cssSelector(".search-inputbar")));
        System.out.println("Search Bar present");

        //Search Button Present
        Assert.assertTrue(home.isElementPresent(By.cssSelector(".usa-search-submit-text")));
        System.out.println("Search Button present");
    }

    @After
    public void end(){
        home.closeOut();
    }
}
