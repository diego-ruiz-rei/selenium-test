package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import gov.gsa.Utilities.CommonUtils.DataField;
import gov.gsa.Utilities.ObjectView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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
    public static Integer wdResultPageCount() throws InterruptedException {
        Thread.sleep(2000);
        int pageNumber= Base.driver.findElements(By.cssSelector(".page-button")).size();
        Thread.sleep(2000);
        return pageNumber;

    }

    // grab wage determination number field
    public static DataField wdNumber(){
        String label = Base.driver.findElement(By.cssSelector("h3.wage-determination-number > span")).getText();
        String data = Base.driver.findElement(By.cssSelector("h3.wage-determination-number > a")).getText();
        return new DataField("wage determination number field", label, data);
    }

    // grab state field
    public static DataField wdState(){
        String label = Base.driver.findElement(By.cssSelector("#search-results > div > .usa-grid-full > .usa-width-two-thirds .usa-unstyled-list > li:nth-child(1) > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("#search-results > div > .usa-grid-full > .usa-width-two-thirds .usa-unstyled-list > li:nth-child(1) > span")).getText();
        return new DataField("state field", label, data);
    }

    // grab county field
    public static DataField wdCounty(){

        String county = Base.driver.findElement(By.cssSelector("#search-results > div > .usa-grid-full > .usa-width-two-thirds .usa-unstyled-list > li:nth-child(2)")).getText();
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
        String data = Base.driver.findElement(By.cssSelector("#wd-services > span")).getText();
        return new DataField("Service", label, data);
    }

    // grab date field
    public static DataField wdDate(){
        String label = Base.driver.findElement(By.cssSelector("#wd-date > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("#wd-date > span")).getText();
        return new DataField("date field", label, data);
    }

    //check for state name through filters
    public static String checkStateFilter(){
        Base.driver.findElement(By.cssSelector("#state > option:nth-of-type(2)")).click();
        String data = Base.driver.findElement(By.cssSelector(".usa-width-two-thirds #search-results > div > .usa-grid-full > .usa-width-two-thirds .usa-unstyled-list > li > span")).getText();
        System.out.println(data);
        return data;
    }

    //check for county name through filters
    public static String checkCountyFilter() throws InterruptedException {

        String countyFieldValue = "";
        Thread.sleep(2000);
        Base.driver.findElement(By.cssSelector("#state > option:nth-of-type(2)")).click();

        Thread.sleep(2000);
        Base.driver.findElement(By.cssSelector("#county > option:nth-of-type(2)")).click();
        Thread.sleep(2000);

        List<WebElement> countyFieldValueElements = Base.driver.findElements(By.cssSelector("#search-results > div:nth-child(9) > wage-determination-result > div.usa-width-two-thirds > ul > li:nth-child(2)"));
        if (countyFieldValueElements.size() > 0) {
            for (WebElement countyTypeElement : countyFieldValueElements) {
                countyFieldValue = countyTypeElement.getText();
            }

        }
        String data = countyFieldValue.substring(countyFieldValue.indexOf(':')+1).trim();

        return data;
    }

    //check for sca filter tag through filters
    public static String checkSCAFilterTag() throws InterruptedException {
        Base.driver.findElement(By.cssSelector("#radio-sca")).click();
        String data= Base.driver.findElement(By.cssSelector(".search-page .usa-label")).getText();
        return data;
    }

    //check for elevator services through filter
    public static String checkElevatorServicesFilterTag() throws InterruptedException {
        Base.driver.findElement(By.cssSelector("#radio-sca")).click();
        Thread.sleep(2000);

        Base.driver.findElement(By.cssSelector("#prevYesLocality")).click();
        Thread.sleep(2000);

        Base.driver.findElement(By.cssSelector("#cbaNo")).click();
        Thread.sleep(2000);

        Base.driver.findElement(By.id("6")).click();
        Thread.sleep(2000);

        Base.driver.findElement(By.cssSelector("#constructionType > option:nth-of-type(9)")).click();
        Thread.sleep(2000);

        String data= Base.driver.findElement(By.cssSelector("#wd-services > span")).getText();
        return data;
    }

    //check for even number
    public static Boolean checkForEvenWdNumber() throws InterruptedException {
        Base.driver.findElement(By.cssSelector("#radio-sca")).click();
        Thread.sleep(2000);

        Base.driver.findElement(By.cssSelector("#prevYesDifferentLocality")).click();
        Thread.sleep(2000);

        Base.driver.findElement(By.id("noEven")).click();
        Thread.sleep(2000);


        String captureNumber= Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(9) > wage-determination-result > h3 > a")).getText();
        return checkForEven(Integer.parseInt(String.valueOf(captureNumber.charAt(captureNumber.length()-1))));
    }

    //function that checks for even number
    public static Boolean checkForEven(int numberToBeChecked){
        if(numberToBeChecked % 2==0){
            return true;
        }
        else{
            return false;
        }
    }

    //checks for odd number
    public static Boolean checkForOddWdNumber() throws InterruptedException {
        Base.driver.findElement(By.cssSelector("#radio-sca")).click();
        Thread.sleep(2000);

        Base.driver.findElement(By.cssSelector("#prevNo")).click();
        Thread.sleep(2000);

        Base.driver.findElement(By.id("noOdd")).click();
        Thread.sleep(2000);


        String captureNumber= Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(9) > wage-determination-result > h3 > a")).getText();
        return checkForEven(Integer.parseInt(String.valueOf(captureNumber.charAt(captureNumber.length()-1))));
    }

}
