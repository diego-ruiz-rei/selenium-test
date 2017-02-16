package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils.DataField;
import gov.gsa.Utilities.ObjectView;
import org.openqa.selenium.By;

/**
 * Created by michael.kellogg on 1/30/17.
 */
public class ExclusionsSearchPage extends ObjectView {

    // finds the tag above result items
    public static String exTag() {
        return Base.driver.findElement(By.cssSelector(".search-page .usa-label")).getText();
    }

    // grab the inactive tag
    public static String exInactiveTag(){
        return Base.driver.findElement(By.cssSelector("wage-determination-result.usa-grid-full > p > span:nth-of-type(2)")).getText();
    }

    // finds pagination items on page
    public static Integer exResultPageCount() {
        return Base.driver.findElements(By.cssSelector(".page-button")).size();
    }

    // grab title
    public static String exTitle(){
        return Base.driver.findElement(By.cssSelector("h3.exclusion-title > a")).getText();
    }

    // grab duns field
    public static DataField exDuns(){
        String label = Base.driver.findElement(By.cssSelector("div.usa-width-two-thirds > ul.m_T-3x > li:nth-of-type(1) > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("div.usa-width-two-thirds > ul.m_T-3x > li:nth-of-type(1) > span")).getText();
        return new DataField("duns field", label, data);
    }

    // grab cage code field
    public static DataField exCageCode(){
        String label = Base.driver.findElement(By.cssSelector("div.usa-width-two-thirds > ul.m_T-3x > li:nth-of-type(2) > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("div.usa-width-two-thirds > ul.m_T-3x > li:nth-of-type(2) > span")).getText();
        return new DataField("cage code field", label, data);
    }

    // grab address field
    public static DataField exAddress(){
        String label = Base.driver.findElement(By.cssSelector("div.usa-width-two-thirds > ul.m_T-3x > li:nth-of-type(3) > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("div.usa-width-two-thirds > ul.m_T-3x > li:nth-of-type(3)  > span")).getText();
        return new DataField("revision number field", label, data);
    }

    // grab classification field
    public static DataField exClassification(){
        String label = Base.driver.findElement(By.cssSelector("div.usa-width-one-third > ul.m_B-0 > li:nth-of-type(1) > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("div.usa-width-one-third > ul.m_B-0 > li:nth-of-type(1) > ul > li > span")).getText();
        return new DataField("construction type field", label, data);
    }

    // grab activation date field
    public static DataField exActivationDate(){
        String label = Base.driver.findElement(By.cssSelector("div.usa-width-one-third > ul.m_B-0 > li:nth-of-type(2) > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("div.usa-width-one-third > ul.m_B-0 > li:nth-of-type(2) > ul > li > span")).getText();
        return new DataField("date field", label, data);
    }

    // grab termination date field
    public static DataField exTerminationDate(){
        String label = Base.driver.findElement(By.cssSelector("div.usa-width-one-third > ul.m_B-0 > li:nth-of-type(3) > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("div.usa-width-one-third > ul.m_B-0 > li:nth-of-type(3) > ul > li > span")).getText();
        return new DataField("date field", label, data);
    }

    // grab first item from autocomplete window
    public static String autoCompleteFirstItem(){
        return Base.driver.findElement(By.cssSelector("ul.usa-search-autocomplete > li")).getText();
    }



}
