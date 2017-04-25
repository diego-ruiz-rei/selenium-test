package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import org.openqa.selenium.By;

import java.text.ParseException;

/**
 * Created by prashant.pillai on 4/10/17.
 */
public class AwardsSearchResultsPage {

    private static int multipleItemsNumber = 4;

    //check for awards tag
    public static String awardsTag(){
        return Base.driver.findElement(By.cssSelector(".search-page .usa-label")).getText();
    }

    //check for pagination
    public static Integer resultsPageCount() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("Results page count : "+ Base.driver.findElements(By.cssSelector(".page-button")).size());
        return Base.driver.findElements(By.cssSelector(".page-button")).size();
    }

    // grab title
    public static boolean exTitle(){
        String titleText = Base.driver.findElement(By.cssSelector("h3.award-title > a")).getText();
        if(titleText.length()!=0 && titleText!=null){
            return true;
        }
        else
            return false;
    }



    //check for vendor name
    public static boolean vendorName() {
        String nameVendor = Base.driver.findElement(By.cssSelector(".vendor-name")).getText();
        if (nameVendor != null && nameVendor.length() > 0) {
            return true;
        }
        else{
            return false;
        }
    }

    //check for vendor address
    public static boolean vendorAddress() {
        String addressVendor = Base.driver.findElement(By.cssSelector(".vendor-address")).getText();
        if (addressVendor != null && addressVendor.length() > 0) {
            return true;
        }
        else{
            return false;
        }
    }

    //check for duns number
    public static CommonUtils.DataField dunsNumber(){
        String labelTrim = Base.driver.findElement(By.cssSelector(".duns-number > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".duns-number > span")).getText();
        String label = labelTrim.substring(0, labelTrim.indexOf(':')).trim();

        return new CommonUtils.DataField("DUNS",label,data);
    }

    //check for global vendor
    public static CommonUtils.DataField globalVendor(){
        String labelTrim = Base.driver.findElement(By.cssSelector(".global-vendor-name > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".global-vendor-name > span")).getText();
        String label = labelTrim.substring(0, labelTrim.indexOf(':')).trim();

        return new CommonUtils.DataField("Global Vendor",label,data);
    }

    //check for global duns
    public static CommonUtils.DataField globalDuns(){
        String labelTrim = Base.driver.findElement(By.cssSelector(".global-duns-number > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".global-duns-number> span")).getText();
        String label = labelTrim.substring(0, labelTrim.indexOf(':')).trim();

        return new CommonUtils.DataField("Global DUNS",label,data);
    }

    //check for department
    public static CommonUtils.DataField checkDepartment(){
        String labelTrim = Base.driver.findElement(By.cssSelector(".department-agency-name > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".department-agency-name > span")).getText();
        String label = labelTrim.substring(0, labelTrim.indexOf(':')).trim();

        return new CommonUtils.DataField("Department/Ind. Agency",label,data);
    }

    //check for office
    public static CommonUtils.DataField checkOffice(){
        String labelTrim = Base.driver.findElement(By.cssSelector(".office-name > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".office-name > span")).getText();
        String label = labelTrim.substring(0, labelTrim.indexOf(':')).trim();

        return new CommonUtils.DataField("Office",label,data);
    }

    //check for action-obligation
    public static CommonUtils.DataField checkActionObligation(){
        String label = Base.driver.findElement(By.cssSelector(".action-obligation > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".action-obligation > ul > li > span")).getText();

        return new CommonUtils.DataField("Action Obligation",label,data);
    }

    //check for psc code
    public static CommonUtils.DataField checkPscCode() {
        String label = Base.driver.findElement(By.cssSelector(".psc-code > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".psc-code > ul > li > span")).getText();

        return new CommonUtils.DataField("PSC Code",label,data);
    }

    //check for naics code
    public static CommonUtils.DataField checkNaicsCode() {
        String label = Base.driver.findElement(By.cssSelector(".naics-code > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".naics-code > ul > li > span")).getText();

        return new CommonUtils.DataField("NAICS Code",label,data);
    }

    //check for date signed
    public static CommonUtils.DataField checkDateSigned() {
        String label = Base.driver.findElement(By.cssSelector(".date-signed > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".date-signed > ul > li > span")).getText();

        return new CommonUtils.DataField("Date Signed",label,data);
    }

    //check for referenceidv
    public static CommonUtils.DataField checkReferencedIDV() {
        String label = Base.driver.findElement(By.cssSelector(".referenced-idv > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".referenced-idv > ul > li > span")).getText();
        return new CommonUtils.DataField("Referenced IDV",label,data);
    }

    //check for award or idv type
    public static CommonUtils.DataField checkAwardType() {
        String label = Base.driver.findElement(By.cssSelector(".award-or-idv-type > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".award-or-idv-type > ul > li > span")).getText();
        return new CommonUtils.DataField("Award Type",label,data);
    }

    public static boolean checkContractTypeFilter() throws InterruptedException {
        Base.driver.findElement(By.id("Contract")).click();
        Thread.sleep(2000);
        String label = Base.driver.findElement(By.cssSelector(".award-or-idv-type > strong")).getText();

        if(label.equalsIgnoreCase("Award Type")){
            return true;
        }
        else {
            return false;
        }

    }

    public static boolean checkICDTypeFilter() throws InterruptedException {
        Base.driver.findElement(By.id("ICD")).click();
        Thread.sleep(2000);
        String label = Base.driver.findElement(By.cssSelector(".award-or-idv-type > strong")).getText();

        if(label.equalsIgnoreCase("IDV Type")){
            return true;
        }
        else {
            return false;
        }

    }

    public static boolean checkAwardDropdownICD() throws InterruptedException {
        Base.driver.findElement(By.id("ICD")).click();
        Thread.sleep(2000);
        Base.driver.findElement(By.cssSelector(".award-type-dropdown-list input")).click();
        Thread.sleep(2000);
        String autoCompleteText = Base.driver.findElement(By.cssSelector(".award-type-dropdown-list #sam-autocomplete-results > li:nth-child(1)")).getText();
        System.out.print(autoCompleteText);
        Base.driver.findElement(By.cssSelector(".award-type-dropdown-list #sam-autocomplete-results > li:nth-child(1)")).click();
        Thread.sleep(2000);

        String typesSelected = Base.driver.findElement(By.cssSelector(".award-type-dropdown-list button.usa-button-link")).getText();
        System.out.print(typesSelected);
        String label = Base.driver.findElement(By.cssSelector(".award-or-idv-type > strong")).getText();
        String data =  Base.driver.findElement(By.cssSelector(".award-or-idv-type > ul > li > span")).getText();

        if(typesSelected.equalsIgnoreCase(autoCompleteText) && label.equalsIgnoreCase("IDV Type") && data.equalsIgnoreCase("BOA")) {
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean checkAwardDropdownContract() throws InterruptedException{
        Base.driver.findElement(By.id("Contract")).click();
        Thread.sleep(2000);
        Base.driver.findElement(By.cssSelector(".award-type-dropdown-list input")).click();
        Thread.sleep(2000);
        String autoCompleteText = Base.driver.findElement(By.cssSelector(".award-type-dropdown-list #sam-autocomplete-results > li:nth-child(2)")).getText();
        System.out.print(autoCompleteText);

        Base.driver.findElement(By.cssSelector(".award-type-dropdown-list #sam-autocomplete-results > li:nth-child(2)")).click();
        Thread.sleep(2000);

        String typesSelected = Base.driver.findElement(By.cssSelector(".award-type-dropdown-list button.usa-button-link")).getText();
        System.out.print(typesSelected);
        String label = Base.driver.findElement(By.cssSelector(".award-or-idv-type > strong")).getText();
        String data =  Base.driver.findElement(By.cssSelector(".award-or-idv-type > ul > li > span")).getText();

        if(typesSelected.equalsIgnoreCase(autoCompleteText) && label.equalsIgnoreCase("Award Type") && data.equalsIgnoreCase("BPA CALL")) {
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean checkMultipleContractTypeFilter() throws InterruptedException, ParseException {

        for(int i=1 ; i< multipleItemsNumber ;i++) {
            Base.driver.findElement(By.cssSelector(".contract-type-dropdown-list input")).click();
            Thread.sleep(2000);

            Base.driver.findElement(By.cssSelector(".contract-type-dropdown-list #sam-autocomplete-results > li:nth-child("+i+")")).click();
            Thread.sleep(2000);
        }
        String[] typesSelected = Base.driver.findElement(By.cssSelector(".contract-type-dropdown-list ul.usa-unstyled-list")).getText().split("\\r?\\n");

        if(typesSelected.length > 1 && CommonUtils.extractTotalResults() > 1) {
            return true;
        }
        else{
            return false;
        }


    }

    public static boolean checkMultipleAwardTypeFilter() throws InterruptedException, ParseException {
        for(int i=1 ; i< multipleItemsNumber ;i++) {
            Base.driver.findElement(By.cssSelector(".award-type-dropdown-list input")).click();
            Thread.sleep(2000);

            Base.driver.findElement(By.cssSelector(".award-type-dropdown-list #sam-autocomplete-results > li:nth-child("+i+")")).click();
            Thread.sleep(2000);
        }
        String[] typesSelected = Base.driver.findElement(By.cssSelector(".award-type-dropdown-list ul.usa-unstyled-list")).getText().split("\\r?\\n");

        if(typesSelected.length > 1 && CommonUtils.extractTotalResults() > 1) {
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean checkContractDropdownTypeFilter() throws InterruptedException, ParseException {
        Base.driver.findElement(By.cssSelector(".contract-type-dropdown-list input")).click();
        Thread.sleep(2000);
        String autoCompleteText = Base.driver.findElement(By.cssSelector(".contract-type-dropdown-list #sam-autocomplete-results > li:nth-child(1)")).getText();
        System.out.print(autoCompleteText);
        Base.driver.findElement(By.cssSelector(".contract-type-dropdown-list #sam-autocomplete-results > li:nth-child(1)")).click();
        Thread.sleep(2000);
        String typesSelected = Base.driver.findElement(By.cssSelector(".contract-type-dropdown-list button.usa-button-link")).getText();
        System.out.println(typesSelected);

        if(typesSelected.equalsIgnoreCase(autoCompleteText) && CommonUtils.extractTotalResults() > 1) {
            return true;
        }
        else{
            return false;
        }
    }

    public static void clearAll() {
        Base.driver.findElement(By.xpath("//button[text()='Clear All']")).click();
    }
}
