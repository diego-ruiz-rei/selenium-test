package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils.DataField;
import gov.gsa.Utilities.ObjectView;
import org.openqa.selenium.By;

/**
 * Created by michael.kellogg on 1/30/17.
 */
public class WageDeterminationSearchPage extends ObjectView {

    // finds the federal hierarchy tag above result items
    public static String wdTag() {
        return Base.driver.findElement(By.cssSelector(".search-page .usa-label")).getText();
    }

    // grab the inactive tag
    public static String wdInactiveTag(){
        return Base.driver.findElement(By.cssSelector("wage-determination-result.usa-grid-full > p > span:nth-of-type(2)")).getText();
    }

    // finds pagination items on fh page
    public static Integer wdResultPageCount() {
        return Base.driver.findElements(By.cssSelector(".page-button")).size();
    }

    // grab wage determination number field
    public static DataField wdNumber(){
        String label = Base.driver.findElement(By.cssSelector("h3.wage-determination-number > span")).getText();
        String data = Base.driver.findElement(By.cssSelector("h3.wage-determination-number > a")).getText();
        return new DataField("wage determination number field", label, data);
    }

    // grab state field
    public static DataField wdState(){
        String label = Base.driver.findElement(By.cssSelector("div.usa-width-two-thirds > ul.m_T-3x > li:nth-of-type(1) > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("div.usa-width-two-thirds > ul.m_T-3x > li:nth-of-type(1) > span")).getText();
        return new DataField("state field", label, data);
    }

    // grab county field
    public static DataField wdCounty(){
        String label = Base.driver.findElement(By.cssSelector("div.usa-width-two-thirds > ul.m_T-3x > li:nth-of-type(2) > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("div.usa-width-two-thirds > ul.m_T-3x > li:nth-of-type(2) > span")).getText();
        return new DataField("county field", label, data);
    }

    // grab revision number field
    public static DataField wdRevisionNum(){
        String label = Base.driver.findElement(By.cssSelector("div.usa-width-one-third > ul.m_B-0 > li:nth-of-type(1) > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("div.usa-width-one-third > ul.m_B-0 > li:nth-of-type(1) > ul > span")).getText();
        return new DataField("revision number field", label, data);
    }

    // grab construction type field
    public static DataField wdConstructionType(){
        String label = Base.driver.findElement(By.cssSelector("div.usa-width-one-third > ul.m_B-0 > li:nth-of-type(2) > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("div.usa-width-one-third > ul.m_B-0 > li:nth-of-type(2) > ul > span")).getText();
        return new DataField("construction type field", label, data);
    }

    // grab date field
    public static DataField wdDate(){
        String label = Base.driver.findElement(By.cssSelector("div.usa-width-one-third > ul.m_B-0 > li:nth-of-type(3) > span > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("div.usa-width-one-third > ul.m_B-0 > li:nth-of-type(3) > ul > span")).getText();
        return new DataField("date field", label, data);
    }

    // grab first item from autocomplete window
    public static String autoCompleteFirstItem(){
        return Base.driver.findElement(By.cssSelector("ul.usa-search-autocomplete > li")).getText();
    }



}
