package gov.gsa.sga;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ObjectView extends Base{

    public Boolean logo(){
        return this.isElementPresent(By.cssSelector(".logo"));
    }

    public Boolean falSideMenuPresent() {
        return this.isElementPresent(By.cssSelector(".usa-width-three-fourths"));
    }

    public String overview(){
        return this.driver.findElement(By.linkText("Overview")).getText();
    }

    public String authorizations(){
        return this.driver.findElement(By.linkText("Authorizations")).getText();
    }

    public String financial(){
        return this.driver.findElement(By.linkText("Financial Information")).getText();
    }

    public String criteria(){
        return this.driver.findElement(By.linkText("Criteria for Applying")).getText();
    }

    public String applyingforassistance(){
        return this.driver.findElement(By.linkText("Applying for Assistance")).getText();
    }

    public String compliance(){
        return this.driver.findElement(By.linkText("Compliance Requirements")).getText();
    }

    public String contact(){
        return this.driver.findElement(By.linkText("Contact Information")).getText();
    }

    public String history(){
        return this.driver.findElement(By.linkText("History")).getText();
    }

}
