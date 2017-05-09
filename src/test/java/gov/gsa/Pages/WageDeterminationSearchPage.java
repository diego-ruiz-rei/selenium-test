package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils.DataField;
import gov.gsa.Utilities.ObjectView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by michael.kellogg on 1/30/17.
 */
public class WageDeterminationSearchPage extends ObjectView {
    private static DataField splitLabelAndData(String element) {
        String fieldLabel = element.substring(0, element.indexOf(':')).trim(); // get all up to but not including colon
        String fieldData = element.substring(element.indexOf(':') + 1).trim(); // get all after and not including colon
        // System.out.println("**Label "+fieldLabel+"**Data "+fieldData);

        return new DataField(null, fieldLabel, fieldData);
    }

    // finds the wd tag above result items
    public static String wdTag() {
        return Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > wage-determination-result > div > div > div.four.wide.column > ul > li:nth-child(2) > span")).getText();
    }

    // grab the inactive tag
    public static String wdInactiveTag(){
        return Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > wage-determination-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span")).getText();
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
        String stateField="";
        List<WebElement> stateElements = Base.driver.findElements(By.cssSelector(".m_B-2x:nth-of-type(1) > li:nth-child(1)"));

        if(stateElements.size() > 0) {
            for (WebElement stTypeElement : stateElements) {
                stateField = stTypeElement.getText();
            }
            return splitLabelAndData(stateField).setName("State");
        }
        else
        {
            return new DataField("State",null,null);
        }
    }

    // grab county field
    public static DataField wdCounty(){
        String countyField="";
        List<WebElement> countyElements = Base.driver.findElements(By.cssSelector(".m_B-2x:nth-of-type(1) > li:nth-child(2)"));

        if(countyElements.size() > 0) {
            for (WebElement cntTypeElement : countyElements) {
                countyField = cntTypeElement.getText();
            }
            return splitLabelAndData(countyField).setName("County/ies");
        }
        else
        {
            return new DataField("County/ies",null,null);
        }

    }

    // grab revision number field
    public static DataField wdRevisionNum(){
        String label = Base.driver.findElement(By.cssSelector(".wd-revision-number > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".wd-revision-number > span")).getText();
        return new DataField("revision number field", label, data);
    }

    // grab construction type field
    public static DataField wdConstructionType(){
        String label = Base.driver.findElement(By.cssSelector(".wd-construction-types > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".wd-construction-types > span")).getText();
        System.out.println("***label "+label+"***data "+data);
        return new DataField("Construction Type", label, data);
    }

    // grab SCA Service field
    public static DataField wdService(){
        String label = Base.driver.findElement(By.cssSelector(".wd-services > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".wd-services > span")).getText();
        return new DataField("Service", label, data);
    }

    // grab date field
    public static DataField wdDate(){
        String label = Base.driver.findElement(By.cssSelector(".wd-date > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".wd-date > span")).getText();
        return new DataField("date field", label, data);
    }

    //check for state name through filters
    public static String checkStateFilter() throws InterruptedException {
        String stateFieldValue="";
        Thread.sleep(2000);
        Base.driver.findElement(By.cssSelector("#state > option:nth-of-type(2)")).click();
        Thread.sleep(2000);
        DataField state = wdState();
        return String.valueOf(state.data);
    }

    //check for county name through filters
    public static String checkCountyFilter() throws InterruptedException {
        String countyFieldValue = "";
        Thread.sleep(2000);
        Base.driver.findElement(By.cssSelector("#state > option:nth-of-type(2)")).click();
        Thread.sleep(2000);
        Base.driver.findElement(By.cssSelector("#county > option:nth-of-type(2)")).click();
        Thread.sleep(2000);
        DataField county = wdCounty();
        return county.data;
    }

    //check for sca filter tag through filters
    public static String checkSCAFilterTag() throws InterruptedException {
        Base.driver.findElement(By.cssSelector("#radio-sca")).click();
        String data= Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > wage-determination-result > div > div > div.four.wide.column > ul > li:nth-child(2) > span")).getText();
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
        String data= Base.driver.findElement(By.cssSelector(".wd-services > span")).getText();
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


        String captureNumber= Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > wage-determination-result > div > div > div.eight.wide.column > h3 > a")).getText();
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


        String captureNumber= Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > wage-determination-result > div > div > div.eight.wide.column > h3 > a")).getText();
        return checkForEven(Integer.parseInt(String.valueOf(captureNumber.charAt(captureNumber.length()-1))));
    }

    //checks for displayed message
    public static String checkAssertedMessage() throws InterruptedException {
        Base.driver.findElement(By.cssSelector("#radio-sca")).click();
        Thread.sleep(2000);

        Base.driver.findElement(By.cssSelector("#prevYesLocality")).click();
        Thread.sleep(2000);

        Base.driver.findElement(By.cssSelector("#cbaYesBased")).click();
        Thread.sleep(2000);


        String data= Base.driver.findElement(By.cssSelector("#main-container > search > div > div > div.usa-width-one > p")).getText();
        System.out.println(data);
        return data;
    }

    public static void clearAll() {
        Base.driver.findElement(By.xpath("//button[text()='Clear All']")).click();
        Base.driver.findElement(By.cssSelector("#search-div > form > div.relative.div-fill > div > sam-autocomplete > div > div > span > i")).click();
    }
}
