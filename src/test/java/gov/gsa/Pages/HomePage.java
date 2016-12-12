package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import org.openqa.selenium.By;

public class HomePage{

    public static String getPageTitle(){
        return Base.driver.getTitle();
    }

    public static String defaultOption(String optionVar) {
        return Base.getDriver().findElement(By.cssSelector(optionVar)).getText();
    }

    public static String specificOption(String optionVar) {
        return Base.getDriver().findElement(By.cssSelector("option[value=\""+optionVar+"\"]")).getText();
    }

    public static boolean filterDropdownExists() {
        return Base.driver.findElements(By.id("filter")).size() > 0;
    }

    public static boolean searchInputBarExists() {
        return Base.driver.findElements(By.cssSelector(".search-inputbar")).size() > 0;
    }

    public static boolean searchButtonExists() {
        return Base.driver.findElements(By.cssSelector(".usa-search-submit-text")).size() > 0;
    }


}
