package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;

import static gov.gsa.Utilities.Base.driver;

/**
 * Created by prashant.pillai on 4/10/17.
 */
public class AwardsSearchResultsPage {

    private static int multipleItemsNumber = 4;

    static WebDriverWait wait = new WebDriverWait(driver, 10);

    //check for awards tag
    public static String awardsTag(){
        return driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span")).getText();
    }

    //check for pagination
    public static Integer resultsPageCount() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("Results page count : "+ driver.findElements(By.cssSelector(".page-button")).size());
        return driver.findElements(By.cssSelector(".page-button")).size();
    }

    // grab title
    public static boolean exTitle(){
        String titleText = driver.findElement(By.cssSelector("h3.award-title > a")).getText();
        if(titleText.length()!=0 && titleText!=null){
            return true;
        }
        else
            return false;
    }



    //check for vendor name
    public static boolean vendorName() {
        String nameVendor = driver.findElement(By.cssSelector(".vendor-name")).getText();
        if (nameVendor != null && nameVendor.length() > 0) {
            return true;
        }
        else{
            return false;
        }
    }

    //check for vendor address
    public static boolean vendorAddress() {
        String addressVendor = driver.findElement(By.cssSelector(".vendor-address")).getText();
        if (addressVendor != null && addressVendor.length() > 0) {
            return true;
        }
        else{
            return false;
        }
    }

    //check for duns number
    public static CommonUtils.DataField dunsNumber(){
        String label = driver.findElement(By.cssSelector(".duns-number > strong")).getText();
        String data = driver.findElement(By.cssSelector(".duns-number > span")).getText();

        return new CommonUtils.DataField("DUNS",label,data);
    }

    //check for global vendor
    public static CommonUtils.DataField globalVendor(){
        String label = driver.findElement(By.cssSelector(".global-vendor-name > strong")).getText();
        String data = driver.findElement(By.cssSelector(".global-vendor-name > span")).getText();


        return new CommonUtils.DataField("Global Vendor",label,data);
    }

    //check for global duns
    public static CommonUtils.DataField globalDuns(){
        String label = driver.findElement(By.cssSelector(".global-duns-number > strong")).getText();
        String data = driver.findElement(By.cssSelector(".global-duns-number > span")).getText();


        return new CommonUtils.DataField("Global DUNS",label,data);
    }

    //check for department
    public static CommonUtils.DataField checkDepartment(){
        String label = driver.findElement(By.cssSelector(".department-agency-name > strong")).getText();
        String data = driver.findElement(By.cssSelector(".department-agency-name > span")).getText();


        return new CommonUtils.DataField("Department/Ind. Agency",label,data);
    }

    //check for office
    public static CommonUtils.DataField checkOffice(){
        String label = driver.findElement(By.cssSelector(".office-name > strong")).getText();
        String data = driver.findElement(By.cssSelector(".office-name > span")).getText();


        return new CommonUtils.DataField("Office",label,data);
    }

    //check for action-obligation
    public static CommonUtils.DataField checkActionObligation(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".action-obligation")));

        String label = driver.findElement(By.cssSelector(".action-obligation")).getText();
        //String data = driver.findElement(By.cssSelector(".action-obligation > ul > li > span")).getText();

        return new CommonUtils.DataField("Action Obligation",label,"");
    }

    //check for psc code
    public static CommonUtils.DataField checkPscCode() {
        String label = driver.findElement(By.cssSelector(".psc-code > strong")).getText();
        String data = driver.findElement(By.cssSelector(".psc-code > span")).getText();

        return new CommonUtils.DataField("PSC Code",label,data);
    }

    //check for naics code
    public static CommonUtils.DataField checkNaicsCode() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".naics-code >  span")));
        String label = driver.findElement(By.cssSelector(".naics-code > strong")).getText();
        String data = driver.findElement(By.cssSelector(".naics-code >  span")).getText();

        return new CommonUtils.DataField("NAICS Code",label,data);
    }

    //check for date signed
    public static CommonUtils.DataField checkDateSigned() {
        String label = driver.findElement(By.cssSelector(".date-signed > strong")).getText();
        String data = driver.findElement(By.cssSelector(".date-signed > span")).getText();

        return new CommonUtils.DataField("Date Signed",label,data);
    }

    //check for referenceidv
    public static CommonUtils.DataField checkReferencedIDV() {
        String label = driver.findElement(By.cssSelector(".referenced-idv > strong")).getText();
        String data = driver.findElement(By.cssSelector(".referenced-idv >  span")).getText();
        return new CommonUtils.DataField("Referenced IDV",label,data);
    }

    //check for award or idv type
    public static CommonUtils.DataField checkAwardType() {
        String label = driver.findElement(By.cssSelector(".award-or-idv-type > strong")).getText();
        String data = driver.findElement(By.cssSelector(".award-or-idv-type >  span")).getText();
        return new CommonUtils.DataField("Award Type",label,data);
    }

    //icd type
    public static boolean checkContractTypeFilter() throws InterruptedException {
        driver.findElement(By.id("Contract")).click();
        Thread.sleep(2000);
        String label = driver.findElement(By.cssSelector(".award-or-idv-type > strong")).getText();

        if(label.equalsIgnoreCase("Award Type")){
            return true;
        }
        else {
            return false;
        }

    }

    //contract type
    public static boolean checkICDTypeFilter() throws InterruptedException {
        driver.findElement(By.id("ICD")).click();
        Thread.sleep(2000);
        String label = driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li.award-or-idv-type > strong")).getText();
        System.out.print(label);
        if(label.equals("IDV Type")){
            return true;
        }
        else {
            return false;
        }

    }

    //AWARD ICD TYPE
    public static boolean checkAwardDropdownICD() throws InterruptedException {
        driver.findElement(By.id("ICD")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".award-type-dropdown-list input")).click();
        Thread.sleep(2000);
        String autoCompleteText = driver.findElement(By.cssSelector(".award-type-dropdown-list #sam-autocomplete-results > li:nth-child(1)")).getText();
        System.out.print(autoCompleteText);
        driver.findElement(By.cssSelector(".award-type-dropdown-list #sam-autocomplete-results > li:nth-child(1)")).click();
        Thread.sleep(2000);

        String typesSelected = driver.findElement(By.cssSelector(".award-type-dropdown-list button.usa-button-link")).getText();
        System.out.print(typesSelected);
        String label = driver.findElement(By.cssSelector(".award-or-idv-type > strong")).getText();
        String data =  driver.findElement(By.cssSelector(".award-or-idv-type >  span")).getText();

        if(typesSelected.equalsIgnoreCase(autoCompleteText) && label.equalsIgnoreCase("IDV Type") && data.equalsIgnoreCase("BOA")) {
            return true;
        }
        else{
            return false;
        }
    }

    //award contract type
    public static boolean checkAwardDropdownContract() throws InterruptedException{
        driver.findElement(By.id("Contract")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".award-type-dropdown-list input")).click();
        Thread.sleep(2000);
        String autoCompleteText = driver.findElement(By.cssSelector(".award-type-dropdown-list #sam-autocomplete-results > li:nth-child(3)")).getText();
        System.out.print(autoCompleteText);

        driver.findElement(By.cssSelector(".award-type-dropdown-list #sam-autocomplete-results > li:nth-child(3)")).click();
        Thread.sleep(2000);

        String typesSelected = driver.findElement(By.cssSelector(".award-type-dropdown-list button.usa-button-link")).getText();
        System.out.print(typesSelected);
        String label = driver.findElement(By.cssSelector(".award-or-idv-type > strong")).getText();
        String data =  driver.findElement(By.cssSelector(".award-or-idv-type >  span")).getText();

        if(typesSelected.equalsIgnoreCase(autoCompleteText) && label.equalsIgnoreCase("Award Type") && data.equalsIgnoreCase("BPA CALL")) {
            return true;
        }
        else{
            return false;
        }
    }

    //multiple contract
    public static boolean checkMultipleContractTypeFilter() throws InterruptedException, ParseException {

        for(int i=1 ; i< multipleItemsNumber ;i++) {
            driver.findElement(By.cssSelector(".contract-type-dropdown-list input")).click();
            Thread.sleep(2000);

            driver.findElement(By.cssSelector(".contract-type-dropdown-list #sam-autocomplete-results > li:nth-child("+i+")")).click();
            Thread.sleep(2000);
        }
        String[] typesSelected = driver.findElement(By.cssSelector(".contract-type-dropdown-list ul.usa-unstyled-list")).getText().split("\\r?\\n");

        if(typesSelected.length > 1 && CommonUtils.extractTotalResults() > 1) {
            return true;
        }
        else{
            return false;
        }


    }

    //multiple award
    public static boolean checkMultipleAwardTypeFilter() throws InterruptedException, ParseException {
        for(int i=1 ; i< multipleItemsNumber ;i++) {
            driver.findElement(By.cssSelector(".award-type-dropdown-list input")).click();
            Thread.sleep(2000);

            driver.findElement(By.cssSelector(".award-type-dropdown-list #sam-autocomplete-results > li:nth-child("+i+")")).click();
            Thread.sleep(2000);
        }
        String[] typesSelected = driver.findElement(By.cssSelector(".award-type-dropdown-list ul.usa-unstyled-list")).getText().split("\\r?\\n");

        if(typesSelected.length > 1 && CommonUtils.extractTotalResults() > 1) {
            return true;
        }
        else{
            return false;
        }
    }

    //contract
    public static boolean checkContractDropdownTypeFilter() throws InterruptedException, ParseException {
        driver.findElement(By.cssSelector(".contract-type-dropdown-list input")).click();
        Thread.sleep(2000);
        String autoCompleteText = driver.findElement(By.cssSelector(".contract-type-dropdown-list #sam-autocomplete-results > li:nth-child(1)")).getText();
        System.out.print(autoCompleteText);
        driver.findElement(By.cssSelector(".contract-type-dropdown-list #sam-autocomplete-results > li:nth-child(1)")).click();
        Thread.sleep(2000);
        String typesSelected = driver.findElement(By.cssSelector(".contract-type-dropdown-list button.usa-button-link")).getText();
        System.out.println(typesSelected);

        if(typesSelected.equalsIgnoreCase(autoCompleteText) && CommonUtils.extractTotalResults() > 1) {
            return true;
        }
        else{
            return false;
        }
    }

    //naics single
    public static boolean checkNaicsFilter(String filterData, String naicsFieldData) throws InterruptedException {
        driver.findElement(By.cssSelector(".naics-psc-dropdown-list sam-type-ahead:nth-child(1) input")).sendKeys(filterData);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".naics-psc-dropdown-list #sam-autocomplete-results > li")).click();
        Thread.sleep(2000);
        String displayData = driver.findElement(By.cssSelector("#naics-psc-display button.usa-button-link")).getText();
        String data = driver.findElement(By.cssSelector(".naics-code > span")).getText();

        if(displayData.contains(filterData) && data.equals(naicsFieldData)){
            return true;
        }else{
            return false;
        }
    }

    //naics multiple
    public static boolean checkNaicsMultipleFilter(String filterData1, String filterData2) throws InterruptedException, ParseException {
        driver.findElement(By.cssSelector(".naics-psc-dropdown-list sam-type-ahead:nth-child(1) input")).sendKeys(filterData1);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".naics-psc-dropdown-list #sam-autocomplete-results > li")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".naics-psc-dropdown-list sam-type-ahead:nth-child(1) input")).sendKeys(filterData2);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".naics-psc-dropdown-list #sam-autocomplete-results > li")).click();
        Thread.sleep(2000);

        String[] typesSelected = driver.findElement(By.cssSelector("#naics-psc-display ul.usa-unstyled-list")).getText().split("\\r?\\n");
        System.out.println(typesSelected[0]+" "+typesSelected[1]);
        if(typesSelected.length > 1 && CommonUtils.extractTotalResults() > 1) {
            return true;
        }
        else{
            return false;
        }
    }

    public static void beforeTest(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span")));
    }

    public static void clearAll() {
        Base.driver.findElement(By.cssSelector("#search-div > form > div.relative.div-fill > div > sam-autocomplete > div > div > span > i")).click();
        Base.driver.findElement(By.cssSelector(".usa-button-primary.usa-search-submit.search-btn")).click();
        driver.findElement(By.xpath("//button[text()='Clear All']")).click();
    }

}
