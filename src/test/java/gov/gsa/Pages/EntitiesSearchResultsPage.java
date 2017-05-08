package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils.DataField;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import gov.gsa.Utilities.ObjectView;
import org.openqa.selenium.By;

/**
 * Created by RKumar on 2/1/2017.
 */
public class EntitiesSearchResultsPage extends Base{



    // Entities tag in Search results page
    public static String entitiesTag(){
        return Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > entities-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span")).getText();
    }

    // Entities Inactive tag in Search results page
    public static String entitiesInactiveTag(){
        System.out.println("tag : "+Base.driver.findElement(By.cssSelector("#search-results > div > entities-result > div > div > div.four.wide.column > ul > li:nth-child(1)")).getText());
        return Base.driver.findElement(By.cssSelector("#search-results > div > entities-result > div > div > div.four.wide.column > ul > li:nth-child(1)")).getText();
    }

    //DUNS
    public static DataField duns() {
        String data = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > entities-result > div > div > div.eight.wide.column > ul > li:nth-child(1)")).getText();
        String[] splitLabelAndData = CommonUtils.splitLabelAndDataNewLine(data);
        String duns = splitLabelAndData[0];
        String dunsdata = splitLabelAndData[1];
        System.out.println("Duns Label : "+duns+"\nData : "+dunsdata);
        return new DataField("DUNS",duns,dunsdata);
    }

    //NCAGE Code
    public static DataField ncageCode() {
        String data = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > entities-result > div > div > div.eight.wide.column > ul > li:nth-child(2)")).getText();
        String[] splitLabelAndData = CommonUtils.splitLabelAndDataNewLine(data);
        String ncage = splitLabelAndData[0];
        String ncagedata = splitLabelAndData[1];
        System.out.println("NCAGE Code Label : "+ncage+"\nData : "+ncagedata);
        return new DataField("NCAGE Code",ncage,ncagedata);
    }

    //Entity Address
    public static DataField entityAddress() {
        String data = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > entities-result > div > div > div.eight.wide.column > ul > li:nth-child(3)")).getText();
        String[] splitLabelAndData = CommonUtils.splitLabelAndDataNewLine(data);
        String address = splitLabelAndData[0];
        String addressdata = splitLabelAndData[1];
        System.out.println("Address : "+address+"\nData : "+addressdata);
        return new DataField("Address",address,addressdata);
    }

    //Expiration Date
    public static DataField expirationDate() {
        String data = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > entities-result > div > div > div.four.wide.column > ul > li:nth-child(2)")).getText();
        String[] splitLabelAndData = CommonUtils.splitLabelAndDataNewLine(data);
        String exp_date = splitLabelAndData[0];
        String exp_date_data = splitLabelAndData[1];
        System.out.println("Exp Date : "+exp_date+"\nData : "+exp_date_data);
        return new DataField("Expiration Date",exp_date,exp_date_data);
    }

    //Purpose of Registration
    public static DataField purposeOfRegistration() {
        String data = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > entities-result > div > div > div.four.wide.column > ul > li:nth-child(3)")).getText();
        String[] splitLabelAndData = CommonUtils.splitLabelAndDataNewLine(data);
        String purpose = splitLabelAndData[0];
        String purpose_data = splitLabelAndData[1];
        System.out.println("Purpose of Registration : "+purpose+"\nData : "+purpose_data);
        return new DataField("Purpose of Registration",purpose,purpose_data);
    }

    //Delinquent Federal Debt
    public static DataField delinquentFederalDebt() {
        String data = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > entities-result > div > div > div.four.wide.column > ul > li:nth-child(4)")).getText();
        String[] splitLabelAndData = CommonUtils.splitLabelAndDataNewLine(data);
        String federal_debt = splitLabelAndData[0];
        String federal_debt_data = splitLabelAndData[1];
        System.out.println("Delinquent Federal Debt : "+federal_debt+"\nData : "+federal_debt_data);
        return new DataField("Delinquent Federal Debt:",federal_debt,federal_debt_data);
    }

    // Entities Title
    public static String entitiesTitle(){
        return Base.driver.findElement(By.className("entity-title")).findElement(By.tagName("a")).getText();
    }

    // duns
    public static String dunsExactMatch(){
        String data = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > entities-result > div > div > div.eight.wide.column > ul > li:nth-child(1)")).getText();
        String[] splitLabelAndData = CommonUtils.splitLabelAndDataNewLine(data);
        String duns = splitLabelAndData[1];
        return duns;
    }


    /*TODO : Move it to common Search page
    //Search AutoComplete
    public static Boolean autocompleteExists(){
        return Base.driver.findElements(By.cssSelector(".usa-search-autocomplete")).size() > 0;
    }*/

    //Pagination count
    public static Integer resultsPageCount(){
        System.out.println("Results page count : "+ Base.driver.findElements(By.cssSelector(".page-button")).size());
        return Base.driver.findElements(By.cssSelector(".page-button")).size();
    }

    public static void clearAll() {
        Base.driver.findElement(By.xpath("//button[text()='Clear All']")).click();
        Base.driver.findElement(By.cssSelector("#search-div > form > div.relative.div-fill > div > sam-autocomplete > div > div > span > i")).click();

    }
}
