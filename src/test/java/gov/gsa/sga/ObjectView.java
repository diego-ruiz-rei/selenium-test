package gov.gsa.sga;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ObjectView extends Base{

   /* public ObjectView(){
        super();
    }*/

    public void logo(){
        assertTrue(isElementPresent(By.cssSelector(".logo")));
        System.out.println("Logo is Present in the Object View page");
    }

    public void FACSideMenu(){
        System.out.println("Inside Object View..");
        assertTrue(isElementPresent(By.cssSelector(".usa-width-three-fourths")));
        //System.out.println("Object View title---"+driver.findElement(By.cssSelector(".usa-width-three-fourths")).getText());

        //Check Side Menu
        System.out.println(driver.findElements(By.cssSelector(".usa-sidenav-list")).size());
        System.out.println(driver.findElement(By.cssSelector(".usa-sidenav-list")).getText());
        assertTrue(isElementPresent(By.cssSelector(".usa-sidenav-list")));
        assertEquals("Overview", driver.findElement(By.linkText("Overview")).getText());
        assertEquals("Authorizations", driver.findElement(By.linkText("Authorizations")).getText());
        assertEquals("Financial Information", driver.findElement(By.linkText("Financial Information")).getText());
        assertEquals("Criteria for Applying", driver.findElement(By.linkText("Criteria for Applying")).getText());
        assertEquals("Applying for Assistance", driver.findElement(By.linkText("Applying for Assistance")).getText());
        assertEquals("Compliance Requirements", driver.findElement(By.linkText("Compliance Requirements")).getText());
        assertEquals("Contact Information", driver.findElement(By.linkText("Contact Information")).getText());
        assertEquals("History", driver.findElement(By.linkText("History")).getText());

    }
}
