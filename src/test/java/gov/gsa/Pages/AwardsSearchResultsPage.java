package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import org.openqa.selenium.By;

/**
 * Created by prashant.pillai on 4/10/17.
 */
public class AwardsSearchResultsPage {

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

    public static boolean extractTotalResults(){
        String resultText=Base.driver.findElement(By.cssSelector(".usa-width-three-fourths > .usa-width-one > strong")).getText();

        String[] splitMessage = resultText.split("\\s+");
        int totalCount = Integer.parseInt(splitMessage[5]);
        if(totalCount >= 1 && resultText.contains("Showing 1 - 1 of")){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean vendorName() {
        String nameVendor = Base.driver.findElement(By.cssSelector(".vendor-name")).getText();
        if (nameVendor != null && nameVendor.length() > 0) {
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean vendorAddress() {
        String addressVendor = Base.driver.findElement(By.cssSelector(".vendor-address")).getText();
        if (addressVendor != null && addressVendor.length() > 0) {
            return true;
        }
        else{
            return false;
        }
    }

    public static CommonUtils.DataField dunsNumber(){
        String labelTrim = Base.driver.findElement(By.cssSelector(".duns-number > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".duns-number > span")).getText();
        String label = labelTrim.substring(0, labelTrim.indexOf(':')).trim();

        return new CommonUtils.DataField("DUNS",label,data);
    }

    public static CommonUtils.DataField globalVendor(){
        String labelTrim = Base.driver.findElement(By.cssSelector(".global-vendor-name > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".global-vendor-name > span")).getText();
        String label = labelTrim.substring(0, labelTrim.indexOf(':')).trim();

        return new CommonUtils.DataField("Global Vendor",label,data);
    }

    public static CommonUtils.DataField globalDuns(){
        String labelTrim = Base.driver.findElement(By.cssSelector(".global-duns-number > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".global-duns-number> span")).getText();
        String label = labelTrim.substring(0, labelTrim.indexOf(':')).trim();

        return new CommonUtils.DataField("Global DUNS",label,data);
    }

    public static CommonUtils.DataField checkDepartment(){
        String labelTrim = Base.driver.findElement(By.cssSelector(".department-agency-name > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".department-agency-name > span")).getText();
        String label = labelTrim.substring(0, labelTrim.indexOf(':')).trim();

        return new CommonUtils.DataField("Department/Ind. Agency",label,data);
    }

    public static CommonUtils.DataField checkOffice(){
        String labelTrim = Base.driver.findElement(By.cssSelector(".office-name > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".office-name > span")).getText();
        String label = labelTrim.substring(0, labelTrim.indexOf(':')).trim();

        return new CommonUtils.DataField("Office",label,data);
    }

    public static CommonUtils.DataField checkActionObligation(){
        String label = Base.driver.findElement(By.cssSelector(".action-obligation > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".action-obligation > ul > li > span")).getText();

        return new CommonUtils.DataField("Action Obligation",label,data);
    }


    public static CommonUtils.DataField checkPscCode() {
        String label = Base.driver.findElement(By.cssSelector(".psc-code > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".psc-code > ul > li > span")).getText();

        return new CommonUtils.DataField("PSC Code",label,data);
    }

    public static CommonUtils.DataField checkNaicsCode() {
        String label = Base.driver.findElement(By.cssSelector(".naics-code > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".naics-code > ul > li > span")).getText();

        return new CommonUtils.DataField("NAICS Code",label,data);
    }

    public static CommonUtils.DataField checkDateSigned() {
        String label = Base.driver.findElement(By.cssSelector(".date-signed > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".date-signed > ul > li > span")).getText();

        return new CommonUtils.DataField("Date Signed",label,data);
    }

    public static CommonUtils.DataField checkReferencedIDV() {
        String label = Base.driver.findElement(By.cssSelector(".referenced-idv > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".referenced-idv > ul > li > span")).getText();
        return new CommonUtils.DataField("Referenced IDV",label,data);
    }

    public static CommonUtils.DataField checkAwardType() {
        String label = Base.driver.findElement(By.cssSelector(".award-or-idv-type > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector(".award-or-idv-type > ul > li > span")).getText();
        return new CommonUtils.DataField("Award Type",label,data);
    }
}
