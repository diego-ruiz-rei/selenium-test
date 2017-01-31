package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.ObjectView;
import org.openqa.selenium.By;

/**
 * Created by michael.kellogg on 1/30/17.
 */
public class FederalHierarchyObjectViewPage extends ObjectView {

    // finds the federal hierarchy tag above result items
    public static String fhTag(){
        return Base.driver.findElement(By.cssSelector(".search-page .usa-label")).getText();
    }

    // finds pagination items on fh page
    public static Integer fhResultPageCount(){
        return Base.driver.findElements(By.cssSelector(".page-button")).size();
    }

    // finds the title of featured result
    public static String featuredResultTitle(){
        return Base.driver.findElement(By.className("card-header-secure")).findElement(By.tagName("a")).getText();
    }

    // finds autocomplete window
    public static Boolean autocompleteExists(){
        return Base.driver.findElements(By.cssSelector(".usa-search-autocomplete")).size() > 0;
    }

    // finds the first result title
    public static String firstResultTitle(){
        return Base.driver.findElement(By.className("federal-hierarchy-title")).findElement(By.tagName("a")).getText();
    }

    ///
    /// fields in search result
    ///

    // result title
    public static String resultTitle(){
        return Base.driver.findElement(By.className("federal-hierarchy-title")).findElement(By.tagName("a")).getText();
    }

    // result description
    public static String resultDescription(){
        return Base.driver.findElement(By.className("m_T-2x")).findElement(By.tagName("span")).getText();
    }

    // result department
    public static String resultDepartment(){
        return Base.driver.findElement(By.className("m_B-2x")).findElement(By.tagName("span")).getText();
    }

    // result sub-tier
    public static String resultSubTier(){
        return Base.driver.findElement(By.className("m_B-0")).findElement(By.tagName("span")).getText();
    }

    // result Also Known As
    public static String resultAlsoKnownAs(){
        return Base.driver.findElement(By.className("m_B-0")).findElement(By.className("usa-unstyled-list")).findElement(By.tagName("span")).getText();
    }

    // Checking organization id
    public static String organizationTypeCode(){
        return Base.driver.findElement(By.cssSelector(".card-secure-content > div > ul.usa-unstyled-list > li:nth-of-type(2)")).getText();
    }

    // Checking FPDS Code
//    public static String fpdsTypeCode(){
//        return Base.driver.findElement(By.cssSelector(".card-secure-content > div > ul.usa-unstyled-list > li:nth-of-type(2)")).getText();
//    }





}
