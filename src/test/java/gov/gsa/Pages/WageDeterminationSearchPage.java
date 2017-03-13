package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import gov.gsa.Utilities.CommonUtils.DataField;
import gov.gsa.Utilities.ObjectView;
import org.openqa.selenium.By;

/**
 * Created by michael.kellogg on 1/30/17.
 */
public class WageDeterminationSearchPage extends ObjectView {

    // finds the wd tag above result items
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
        String label = Base.driver.findElement(By.cssSelector("#wd-state-0 > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("#wd-state-0 > span")).getText();
        return new DataField("state field", label, data);
    }

    // grab county field
    public static DataField wdCounty(){

        String county = Base.driver.findElement(By.id("wd-counties-0")).getText();
        return CommonUtils.splitLabelAndData(county).setName("county");
        /*
        String label = Base.driver.findElement(By.cssSelector("# > strong")).getText();
        String data_element = Base.driver.findElement(By.cssSelector("#wd-counties-0 > span")).getText();
        String data = data_element.substring(data_element.indexOf(':')+1).trim();
        return new DataField("county field", label, data);
        */
    }

    // grab revision number field
    public static DataField wdRevisionNum(){
        String label = Base.driver.findElement(By.cssSelector("#wd-revision-number > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("#wd-revision-number > span")).getText();
        return new DataField("revision number field", label, data);
    }

    // grab construction type field
    public static DataField wdConstructionType(){
        String label = Base.driver.findElement(By.cssSelector("#wd-construction-types > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("#wd-construction-types > span")).getText();
        System.out.println("***label "+label+"***data "+data);
        return new DataField("Construction Type", label, data);
    }

    // grab SCA Service field
    public static DataField wdService(){
        String label = Base.driver.findElement(By.cssSelector("#wd-services > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("#wd-services) > span")).getText();
        return new DataField("Service", label, data);
    }

    // grab date field
    public static DataField wdDate(){
        String label = Base.driver.findElement(By.cssSelector("#wd-date > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("#wd-date > span")).getText();
        return new DataField("date field", label, data);
    }





}
