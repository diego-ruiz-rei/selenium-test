package gov.gsa.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ObjectView extends Base{

    public static Boolean logo() {
        return Base.driver.findElements(By.cssSelector(".sidenav-logo")).size() > 0;
    }

    //FAL Side Menu
    public static Boolean falSideMenuPresent() {
        return Base.driver.findElements(By.cssSelector(".usa-width-three-fourths")).size() > 0;
    }

    public static String overview() {
        return Base.driver.findElement(By.linkText("Overview")).getText();
    }

    public static String authorizations() {
        return Base.driver.findElement(By.linkText("Authorizations")).getText();
    }

    public static String financial() {
        return Base.driver.findElement(By.linkText("Financial Information")).getText();
    }

    public static String criteria() {
        return Base.driver.findElement(By.linkText("Criteria for Applying")).getText();
    }

    public static String applyingforassistance() {
        return Base.driver.findElement(By.linkText("Applying for Assistance")).getText();
    }

    public static String compliance() {
        return Base.driver.findElement(By.linkText("Compliance Requirements")).getText();
    }

    public static String contact() {
        return Base.driver.findElement(By.linkText("Contact Information")).getText();
    }

    public static String history() {
        return Base.driver.findElement(By.linkText("History")).getText();
    }

    //Opportunities Side Menu
    public Boolean oppSideMenuPresent() {
        return Base.driver.findElements(By.cssSelector(".usa-width-one-fourth")).size() > 0;
    }

    public static String generalInformation() {
        return Base.driver.findElement(By.linkText("General Information")).getText();
    }

    public static String classification() {
        return Base.driver.findElement(By.linkText("Classification")).getText();
    }

    public static String synopsis() {
        return Base.driver.findElement(By.linkText("Synopsis/Description")).getText();
    }

    public static String packages() {
        return Base.driver.findElement(By.linkText("Packages")).getText();
    }

    //WD Side Menu
    public static ArrayList<String> wdSideMenuItems() {
        List<WebElement> tabs = Base.driver.findElements(By.cssSelector("sammenuitem > ul > li"));
        ArrayList<String> title = new ArrayList<String>();
        for (WebElement tab: tabs) {
            title.add(tab.findElement(By.cssSelector("a")).getText());
        }
        System.out.println("Side Menu Items : "+title);

        return title;
    }


}
