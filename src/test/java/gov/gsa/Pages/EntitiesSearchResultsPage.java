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
        return Base.driver.findElement(By.cssSelector(".search-page .usa-label")).getText();
    }

    // Entities Inactive tag in Search results page
    public static String entitiesInactiveTag(){
        System.out.println("tag : "+Base.driver.findElement(By.cssSelector("entities-result > p > span:nth-child(2)")).getText());
        return Base.driver.findElement(By.cssSelector("entities-result > p > span:nth-child(2)")).getText();
    }

    //DUNS
    public static DataField duns() {
        String duns = Base.driver.findElement(By.cssSelector(".m_B-2x > li:nth-child(1) > strong")).getText();
        String dunsdata = Base.driver.findElement(By.cssSelector(".m_B-2x > li:nth-child(1) > span")).getText();
        System.out.println("Duns Label : "+duns+"\nData : "+dunsdata);
        return new DataField("DUNS",duns,dunsdata);
    }

    //NCAGE Code
    public static DataField ncageCode() {
        String ncage = Base.driver.findElement(By.cssSelector(".usa-unstyled-list.usa-text-small.m_T-3x.m_B-2x > li:nth-child(2) > strong")).getText();
        String ncagedata = Base.driver.findElement(By.cssSelector(".usa-unstyled-list.usa-text-small.m_T-3x.m_B-2x > li:nth-child(2) > span")).getText();
        System.out.println("NCAGE Code Label : "+ncage+"\nData : "+ncagedata);
        return new DataField("NCAGE Code",ncage,ncagedata);
    }

    //Entity Address
    public static DataField entityAddress() {
        String address = Base.driver.findElement(By.cssSelector(".usa-unstyled-list.usa-text-small.m_T-3x.m_B-2x > li:nth-child(3) > strong")).getText();
        String addressdata = Base.driver.findElement(By.cssSelector(".usa-unstyled-list.usa-text-small.m_T-3x.m_B-2x > li:nth-child(3) > span")).getText();
        System.out.println("Address : "+address+"\nData : "+addressdata);
        return new DataField("Address",address,addressdata);
    }

    //Expiration Date
    public static DataField expirationDate() {
        String exp_date = Base.driver.findElement(By.className("m_B-0")).findElement(By.tagName("strong")).getText();
        String exp_date_data = Base.driver.findElement(By.cssSelector("entities-result > div.usa-width-one-third > ul > li:nth-child(1) > ul > li > span")).getText();
        System.out.println("Exp Date : "+exp_date+"\nData : "+exp_date_data);
        return new DataField("Expiration Date",exp_date,exp_date_data);
    }

    //Purpose of Registration
    public static DataField purposeOfRegistration() {
        String purpose = Base.driver.findElement(By.cssSelector("entities-result > div.usa-width-one-third > ul > li:nth-child(2) > strong")).getText();
        String purpose_data = Base.driver.findElement(By.cssSelector("entities-result > div.usa-width-one-third > ul > li:nth-child(2) > ul > li > span")).getText();
        System.out.println("Purpose of Registration : "+purpose+"\nData : "+purpose_data);
        return new DataField("Purpose of Registration",purpose,purpose_data);
    }

    //Delinquent Federal Debt
    public static DataField delinquentFederalDebt() {
        String federal_debt = Base.driver.findElement(By.cssSelector("entities-result > div.usa-width-one-third > ul > li:nth-child(3) > strong")).getText();
        String federal_debt_data = Base.driver.findElement(By.cssSelector("entities-result > div.usa-width-one-third > ul > li:nth-child(3) > ul > li > span")).getText();
        System.out.println("Delinquent Federal Debt : "+federal_debt+"\nData : "+federal_debt_data);
        return new DataField("Delinquent Federal Debt",federal_debt,federal_debt_data);
    }

    // Entities Title
    public static String entitiesTitle(){
        return Base.driver.findElement(By.className("entity-title")).findElement(By.tagName("a")).getText();
    }

    // duns
    public static String dunsExactMatch(){
        return Base.driver.findElement(By.className("m_B-2x")).findElement(By.tagName("span")).getText();
    }


    //TODO : Move it to common Search page
    //Search AutoComplete
    public static Boolean autocompleteExists(){
        return Base.driver.findElements(By.cssSelector(".usa-search-autocomplete")).size() > 0;
    }

    //Pagination count
    public static Integer resultsPageCount(){
        System.out.println("Results page count : "+ Base.driver.findElements(By.cssSelector(".page-button")).size());
        return Base.driver.findElements(By.cssSelector(".page-button")).size();
    }

}
