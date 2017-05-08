package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils.DataField;
import gov.gsa.Utilities.ObjectView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael.kellogg on 1/30/17.
 */
public class FederalHierarchySearchPage extends ObjectView {

    // finds the federal hierarchy tag above result items
    public static String fhTag(){
        return Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > federal-hierarchy-result > div > div > div.four.wide.column > ul > li:nth-child(2) > span")).getText();
    }

    //Split label and data based on ":"
    private static DataField splitLabelAndData(String element) {
        String fieldLabel = element.substring(0, element.indexOf(':')).trim(); // get all up to but not including colon
        String fieldData = element.substring(element.indexOf(':') + 1).trim(); // get all after and not including colon

        return new DataField(null, fieldLabel, fieldData);
    }

    //Split label and data based on new line
    private static DataField splitLabelAndDataNewLine(String element) {
        String [] labelAndData=element.split("\\r?\\n");
        String fieldLabel=labelAndData[0].trim();
        String fieldData=labelAndData[1].trim();

        return new DataField(null, fieldLabel, fieldData);
    }

    // finds pagination items on fh page
    public static Integer fhResultPageCount(){
        return Base.driver.findElements(By.cssSelector(".page-button")).size();
    }

    // finds the title of featured result
    public static String featuredResultTitle(){
        return Base.driver.findElement(By.cssSelector("#main-container > search > div > div > div:nth-child(2) > fh-featured-result > div > div > div > div.sam-ui.attached.grid > div > div.ten.wide.column > h3 > a")).getText();
    }

    // finds autocomplete window
    public static Boolean autocompleteExists(){
        return Base.driver.findElements(By.cssSelector(".usa-search-autocomplete")).size() > 0;
    }

    // finds the first result title
    public static String firstResultTitle(){
        return Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > federal-hierarchy-result > div > div > div.eight.wide.column > h3 > a")).getText();
    }

    ///
    /// fields in search result
    ///

    // result title
    public static String resultTitle(){
        return Base.driver.findElement(By.className("federal-hierarchy-title")).findElement(By.tagName("a")).getText();
    }

    public static DataField title() {
        String duns = Base.driver.findElement(By.cssSelector(".m_B-2x > li:nth-child(1) > strong")).getText();
        String dunsdata = Base.driver.findElement(By.cssSelector(".m_B-2x > li:nth-child(1) > span")).getText();
        System.out.println("Duns Label : "+duns+"\nData : "+dunsdata);
        return new DataField("DUNS",duns,dunsdata);
    }


    // result description
    public static String resultDescription(){
        return Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(2) > federal-hierarchy-result > div > div > div.eight.wide.column > p > span")).getText();
    }

    // result department
    public static String resultDepartment(){
        return Base.driver.findElement(By.className("m_B-2x")).findElement(By.tagName("span")).getText();
    }

    // result sub-tier
    public static String resultSubTier(){
        return Base.driver.findElement(By.className("m_B-0")).findElement(By.tagName("span")).getText();
    }

    // result Also Known As
    public static String resultAlsoKnownAs(){
        return Base.driver.findElement(By.className("m_B-0")).findElement(By.className("usa-unstyled-list")).findElement(By.tagName("span")).getText();
    }

    // Checking organization id
    public static String organizationTypeCode(){
        return Base.driver.findElement(By.cssSelector(".card-secure-content > div > ul.usa-unstyled-list > li:nth-of-type(2)")).getText();
    }

    // Checking FPDS Code
//    public static String fpdsTypeCode(){
//        return Base.driver.findElement(By.cssSelector(".card-secure-content > div > ul.usa-unstyled-list > li:nth-of-type(2)")).getText();
//    }

// Check fpds org id
    public static DataField testFpdsOrg() {
        String fpdsText="";
        List<WebElement> fpdsTypeElements = Base.driver.findElements(By.cssSelector("#search-results > div:nth-child(1) > federal-hierarchy-result > div.usa-width-one-third > ul > li:nth-child(3)"));

        if(fpdsTypeElements.size() > 0) {
            for (WebElement oppTypeElement : fpdsTypeElements) {
                fpdsText = oppTypeElement.getText();
            }
            return splitLabelAndData(fpdsText).setName("FPDS Org ID");
        }
        else
        {
            return new DataField("FPDS Org ID",null,null);
        }
    }

    //Check fpds code
    public static DataField testFpdsCode() {
        String fpdsCodeText="";
        List<WebElement> fpdsCodeTypeElements = Base.driver.findElements(By.cssSelector("#search-results > div:nth-child(2) > federal-hierarchy-result > div.usa-width-one-third > ul > li:nth-child(2)"));

        if(fpdsCodeTypeElements.size() > 0) {
            for (WebElement oppTypeElement : fpdsCodeTypeElements) {
                fpdsCodeText = oppTypeElement.getText();
            }

            System.out.println(fpdsCodeText);
            return splitLabelAndData(fpdsCodeText).setName("FPDS Code");
        }
        else
        {
            return new DataField("FPDS Code",null,null);
        }
    }

    //Check fpds code(old)
    public static DataField testFpdsCodeOld() {
        String fpdsCodeOldText="";
        List<WebElement> fpdsCodeOldTypeElements = Base.driver.findElements(By.cssSelector("#search-results > div:nth-child(1) > federal-hierarchy-result > div.usa-width-one-third > ul > li:nth-child(3)"));

        if(fpdsCodeOldTypeElements.size() > 0) {
            for (WebElement oppTypeElement : fpdsCodeOldTypeElements) {
                fpdsCodeOldText = oppTypeElement.getText();
            }

            System.out.println(fpdsCodeOldText);
            return splitLabelAndData(fpdsCodeOldText).setName("FPDS Code (Old)");
        }
        else
        {
            return new DataField("FPDS Code (Old)",null,null);
        }
    }

    // grab title
    public static boolean extractTitle(){
        String titleText=Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > federal-hierarchy-result > div > div > div.eight.wide.column > h3 > a")).getText();

        if(titleText.length()!=0 && titleText!=null){
            return true;
        }
        else
            return false;
    }

    // grab description
    public static boolean extractDescription(){
        String descriptionText=Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > federal-hierarchy-result > div > div > div.eight.wide.column > p > span")).getText();

        if(descriptionText.length()!=0 && descriptionText!=null){
            return true;
        }
        else
            return false;
    }

    //check for department
    public static DataField departmentCheck() {
        String departmentText="";
        List<WebElement> departmentTextTypeElements = Base.driver.findElements(By.cssSelector("#search-results > div:nth-child(1) > federal-hierarchy-result > div > div > div.eight.wide.column > ul > li"));

        if(departmentTextTypeElements.size() > 0) {
            for (WebElement deptTypeElement : departmentTextTypeElements) {
                departmentText = deptTypeElement.getText();
            }

            System.out.println(departmentText);
            return splitLabelAndDataNewLine(departmentText).setName("Department");
        }
        else
        {
            return new DataField("Department",null,null);
        }
    }

    //check for sub-tier label
    public static String subTierCheck(){
        String subTierText="";
        List<WebElement> subTierTextTypeElements = Base.driver.findElements(By.cssSelector("#search-results > div:nth-child(1) > federal-hierarchy-result > div > div > div.four.wide.column > ul > li:nth-child(3)"));
        if(subTierTextTypeElements.size() > 0) {
            for (WebElement deptTypeElement : subTierTextTypeElements) {
                subTierText = deptTypeElement.getText();
            }

        }
        return subTierText;
    }

    //Check for also known as label and data
    public static DataField aliasNameCheck() {
        String aliasNameText="";
        List<WebElement> aliasNameTextTypeElements = Base.driver.findElements(By.cssSelector("#search-results > div:nth-child(1) > federal-hierarchy-result > div > div > div.four.wide.column > ul > li:nth-child(4)"));

        if(aliasNameTextTypeElements.size() > 0) {
            for (WebElement deptTypeElement : aliasNameTextTypeElements) {
                aliasNameText = deptTypeElement.getText();
            }

            System.out.println(aliasNameText);
            return splitLabelAndDataNewLine(aliasNameText).setName("Also Known As");
        }
        else
        {
            return new DataField("Also Known As",null,null);
        }
    }

    //cgac field check
    public static DataField checkCgacCodeFeaturedResult() {
        String extractField= Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(3) > federal-hierarchy-result > div > div > div.four.wide.column > ul > li:nth-child(4)")).getText();
        return splitLabelAndDataNewLine(extractField).setName("CGAC");
    }

    //cgac code for dept
    public static DataField checkCgacCodeDepartment() {
        String departmentField = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(4) > federal-hierarchy-result > div > div > div.four.wide.column > ul > li:nth-child(3) > strong")).getText();
        if(departmentField.equalsIgnoreCase("Department")){
            String extractField = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(4) > federal-hierarchy-result > div > div > div.four.wide.column > ul > li:nth-child(5)")).getText();
            return splitLabelAndData(extractField).setName("CGAC");
        }
        return new DataField("CGAC",null,null);
    }

    //cgac code for sub tier
    public static DataField checkCgacCodeSubTier() {
        String subTierField = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(3) > federal-hierarchy-result > div > div > div.four.wide.column > ul > li:nth-child(3)")).getText();
        if(subTierField.equalsIgnoreCase("Sub-Tier")){
            String extractField = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(3) > federal-hierarchy-result > div > div > div.four.wide.column > ul > li:nth-child(4)")).getText();
            return splitLabelAndData(extractField).setName("CGAC");
        }
        return new DataField("CGAC",null,null);
    }

    //awards link check from FH featured result
    public static String checkFhAwardsLink() throws InterruptedException {
        String extractField = "";
        Thread.sleep(1000);
        Base.driver.findElement(By.cssSelector("#main-container > search > div > div > div:nth-child(2) > fh-featured-result > div > div > div > div.sam-ui.attached.grid > div > div.ten.wide.column > p > a")).click();
        Thread.sleep(2000);
        String oldTab = driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String> (driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));
        Thread.sleep(2000);
       String awardTitle = Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > awards-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span")).getText();
        if("Award".equals(awardTitle)) {
             extractField = Base.driver.findElement(By.cssSelector("agencypicker > div > div.usa-agency-picker-readonly-area > ul > li")).getText();

        }
        return extractField;
    }

    public static void clearAll() {
        Base.driver.findElement(By.xpath("//button[text()='Clear All']")).click();
        Base.driver.findElement(By.cssSelector("#search-div > form > div.relative.div-fill > div > sam-autocomplete > div > div > span > i")).click();
    }

}


