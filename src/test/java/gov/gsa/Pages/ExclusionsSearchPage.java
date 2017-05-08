package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import gov.gsa.Utilities.CommonUtils.DataField;
import gov.gsa.Utilities.ObjectView;
import org.openqa.selenium.By;

/**
 * Created by michael.kellogg on 1/30/17.
 */
public class ExclusionsSearchPage extends ObjectView {

    // finds the tag above result items
    public static String exTag() {
        return Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > exclusions-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span")).getText();
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
        String dataField = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > exclusions-result > div > div > div.eight.wide.column > ul > li:nth-child(1)")).getText();
        String[] splitLabelAndData = CommonUtils.splitLabelAndDataNewLine(dataField);
        String label = splitLabelAndData[0];
        String data = splitLabelAndData[1];
        return new DataField("duns field", label, data);
    }

    // grab cage code field
    public static DataField exCageCode(){
        String dataField = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > exclusions-result > div > div > div.eight.wide.column > ul > li:nth-child(2)")).getText();
        String[] splitLabelAndData = CommonUtils.splitLabelAndDataNewLine(dataField);
        String label = splitLabelAndData[0];
        String data = splitLabelAndData[1];
        return new DataField("cage code field", label, data);
    }

    // grab address field
    public static DataField exAddress(){
        String dataField = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > exclusions-result > div > div > div.eight.wide.column > ul > li:nth-child(3)")).getText();
        String[] splitLabelAndData = CommonUtils.splitLabelAndDataNewLine(dataField);
        String label = splitLabelAndData[0];
        String data = splitLabelAndData[1];
        return new DataField("address field", label, data);
    }

    // grab classification field
    public static DataField exClassification(){
        String dataField = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > exclusions-result > div > div > div.four.wide.column > ul > li:nth-child(2)")).getText();
        String[] splitLabelAndData = CommonUtils.splitLabelAndDataNewLine(dataField);
        String label = splitLabelAndData[0];
        String data = splitLabelAndData[1];
        return new DataField("classification field", label, data);
    }

    // grab activation date field
    public static DataField exActivationDate(){
        String dataField = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > exclusions-result > div > div > div.four.wide.column > ul > li:nth-child(3)")).getText();
        String[] splitLabelAndData = CommonUtils.splitLabelAndDataNewLine(dataField);
        String label = splitLabelAndData[0];
        String data = splitLabelAndData[1];
        return new DataField("activation date field", label, data);
    }

    // grab termination date field
    public static DataField exTerminationDate(){
        String dataField = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > exclusions-result > div > div > div.four.wide.column > ul > li:nth-child(4)")).getText();
        String[] splitLabelAndData = CommonUtils.splitLabelAndDataNewLine(dataField);
        String label = splitLabelAndData[0];
        String data = splitLabelAndData[1];
        return new DataField("termination date field", label, data);
    }

    // grab first item from autocomplete window
    public static String autoCompleteFirstItem(){
        return Base.driver.findElement(By.cssSelector("ul.usa-search-autocomplete > li")).getText();
    }

    public static void clearAll() {
        Base.driver.findElement(By.xpath("//button[text()='Clear All']")).click();
        Base.driver.findElement(By.cssSelector("#search-div > form > div.relative.div-fill > div > sam-autocomplete > div > div > span > i")).click();

    }



}
