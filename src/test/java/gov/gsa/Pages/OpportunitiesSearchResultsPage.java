package gov.gsa.Pages;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils.DataField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by prashant.pillai on 3/1/17.
 */
public class OpportunitiesSearchResultsPage {
    // Opportunities tag in Search results page
    public static String opportunitiesTag(){
        return Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > opportunities-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span")).getText();
    }

    // Opportunities Archived tag in Search results page
    public static String opportunitiesArchivedTag(){

        return Base.driver.findElement(By.cssSelector("#search-results > div:nth-child(1) > opportunities-result > div > div > div.four.wide.column > ul > li:nth-child(1) > span")).getText();
    }

    //Pagination count
    public static Integer resultsPageCount() throws InterruptedException {
        System.out.println("Results page count : "+ Base.driver.findElements(By.cssSelector(".page-button")).size());
        return Base.driver.findElements(By.cssSelector(".page-button")).size();
    }

    //Split label and data based on ":"
    private static DataField splitLabelAndData(String element) {
        String fieldLabel = element.substring(0, element.indexOf(':')).trim(); // get all up to but not including colon
        String fieldData = element.substring(element.indexOf(':') + 1).trim(); // get all after and not including colon
        // System.out.println("**Label "+fieldLabel+"**Data "+fieldData);

        return new DataField(null, fieldLabel, fieldData);
    }

    //returns type value for validation
    private static String getTypeFieldValue(){
        String typeFieldValue="";
        String typeValue="";
        List<WebElement> typeFieldValueElements = Base.driver.findElements(By.cssSelector("#search-results > div:nth-child(1) > opportunities-result > div > div > div.four.wide.column > ul > li:nth-child(4)"));
        if(typeFieldValueElements.size() > 0) {
            for (WebElement oppTypeElement : typeFieldValueElements) {
                typeFieldValue = oppTypeElement.getText();
            }
            String [] labelAndData=typeFieldValue.split("\\r?\\n");

            typeValue=labelAndData[1].trim();

        }

        return typeValue;
    }

    //Split label and data based on new line
    private static DataField splitLabelAndDataNewLine(String element) {
        String [] labelAndData=element.split("\\r?\\n");
        String fieldLabel=labelAndData[0].trim();
        String fieldData=labelAndData[1].trim();

        return new DataField(null, fieldLabel, fieldData);
    }

    //Check for department
    public static DataField department() {
        String deptName="";
        List<WebElement> deptTypeElements = Base.driver.findElements(By.cssSelector("#search-results > div > opportunities-result > div > div > div.eight.wide.column > ul > li:nth-child(1)"));
        if(deptTypeElements.size() > 0) {
            for (WebElement oppTypeElement : deptTypeElements) {
                deptName = oppTypeElement.getText();
                System.out.print(deptName);
            }
            return splitLabelAndDataNewLine(deptName).setName("Department/Ind. Agency");
        }
        else
        {
            return new DataField("Department/Ind. Agency",null,null);
        }
    }

    //Check for office name
    public static DataField officeName() {
        String officeName="";
        List<WebElement> officeTypeElements = Base.driver.findElements(By.cssSelector("#search-results > div > opportunities-result > div > div > div.eight.wide.column > ul > li:nth-child(2)"));
        if(officeTypeElements.size() > 0) {
            for (WebElement oppTypeElement : officeTypeElements) {
                officeName = oppTypeElement.getText();
            }
            return splitLabelAndDataNewLine(officeName).setName("Sub-tier");
        }
        else
        {
            return new DataField("Sub-tier",null,null);
        }
    }

    //Check for location name
    public static DataField locationName() {
        String locationName="";
        List<WebElement> locationTypeElements = Base.driver.findElements(By.cssSelector("#search-results > div > opportunities-result > div > div > div.eight.wide.column > ul > li:nth-child(3)"));

        if(locationTypeElements.size() > 0) {
            for (WebElement oppTypeElement : locationTypeElements) {
                locationName = oppTypeElement.getText();
            }

            return splitLabelAndDataNewLine(locationName).setName("Office");
        }
        else
        {
            return new DataField("Office",null,null);
        }
    }

    //Check for solicitation number
    public static DataField solicitation() {
        String solicitationNumber="";
        List<WebElement> solicitationTypeElements = Base.driver.findElements(By.cssSelector("#search-results > div > opportunities-result > div > div > div.four.wide.column > ul > li:nth-child(2)"));

        if(solicitationTypeElements.size() > 0) {
            for (WebElement oppTypeElement : solicitationTypeElements) {
                solicitationNumber = oppTypeElement.getText();
            }
            return splitLabelAndDataNewLine(solicitationNumber).setName("Solicitation Number");
        }
        else
        {
            return new DataField("Solicitation Number",null,null);
        }
    }

    //Check for posted date
    public static DataField postedDate() {
        String postedDateField="";
        List<WebElement> postedDateTypeElements = Base.driver.findElements(By.cssSelector("#search-results > div > opportunities-result > div > div > div.four.wide.column > ul > li:nth-child(3)"));

        if(postedDateTypeElements.size() > 0) {
            for (WebElement oppTypeElement : postedDateTypeElements) {
                postedDateField = oppTypeElement.getText();
            }
            return splitLabelAndDataNewLine(postedDateField).setName("Posted Date");
        }
        else
        {
            return new DataField("Posted Date",null,null);
        }
    }

    //check for type
    public static DataField type() {
        String typeField="";
        List<WebElement> typeElements = Base.driver.findElements(By.cssSelector("#search-results > div > opportunities-result > div > div > div.four.wide.column > ul > li:nth-child(4)"));

        if(typeElements.size() > 0) {
            for (WebElement oppTypeElement : typeElements) {
                typeField = oppTypeElement.getText();
            }
            return splitLabelAndDataNewLine(typeField).setName("Type");
        }
        else
        {
            return new DataField("Type",null,null);
        }
    }

    // grab title
    public static boolean exTitle(){
        String titleText=Base.driver.findElement(By.cssSelector("h3.opportunity-title > a")).getText();
        if(titleText.length()!=0 && titleText!=null){
            return true;
        }
        else
            return false;
    }

    // grab description
    public static boolean exDescription(){
        String descriptionText=Base.driver.findElement(By.cssSelector("#search-results > div > opportunities-result > div > div > div.eight.wide.column > p > span")).getText();
        if(descriptionText.length()!=0 && descriptionText!=null){
            return true;
        }
        else
            return false;
    }

    //validate presolicitation type
    public static boolean presolicitation(){
        String typeFieldValue=getTypeFieldValue();
        System.out.print(typeFieldValue);
        if(typeFieldValue.equalsIgnoreCase("Original Presolicitation")){
            return true;
        }
        else
            return false;
    }

    //validate combinedSynopsis type
    public static boolean combinedSynopsis(){
        String typeFieldValue=getTypeFieldValue();
        System.out.print(typeFieldValue);
        if(typeFieldValue.equalsIgnoreCase("Original Combined Synopsis/Solicitation")){
            return true;
        }
        else
            return false;
    }

    //validate saleOfSurplus type
    public static boolean saleOfSurplus(){
        String typeFieldValue=getTypeFieldValue();
        System.out.print(typeFieldValue);
        if(typeFieldValue.equalsIgnoreCase("Original Sale of Surplus Property")){
            return true;
        }
        else
            return false;
    }

    //validate sourcesSought type
    public static boolean sourcesSought(){
        String typeFieldValue=getTypeFieldValue();
        System.out.print(typeFieldValue);
        if(typeFieldValue.equalsIgnoreCase("Original Sources Sought")){
            return true;
        }
        else
            return false;
    }

    //validate justifyApprove type
    public static boolean justifyApprove(){
        String typeFieldValue=getTypeFieldValue();
        System.out.print(typeFieldValue);
        if(typeFieldValue.equalsIgnoreCase("Original Justification and Approval (J&A)")){
            return true;
        }
        else
            return false;
    }

    //validate awardNotice type
    public static boolean awardCheck(){
        String typeFieldValue=getTypeFieldValue();
        System.out.print(typeFieldValue);
        if(typeFieldValue.equalsIgnoreCase("Original Award Notice")){
            return true;
        }
        else
            return false;
    }

    //validate Fair Opportunity / Limited Sources Justification type
    public static boolean fairOpportunity(){
        String typeFieldValue=getTypeFieldValue();
        System.out.print(typeFieldValue);
        if(typeFieldValue.equalsIgnoreCase("Original Fair Opportunity / Limited Sources Justification")){
            return true;
        }
        else
            return false;
    }

    //validate Special Notice type
    public static boolean specialNotice(){
        String typeFieldValue=getTypeFieldValue();
        System.out.print(typeFieldValue);
        if(typeFieldValue.equalsIgnoreCase("Original Special Notice")){
            return true;
        }
        else
            return false;
    }

    //validate Modification/Amendment/Cancel type
    public static boolean modifyAmend(){
        String typeFieldValue=getTypeFieldValue();
        System.out.print(typeFieldValue);
        if(typeFieldValue.contains("Combined Synopsis/Solicitation")){
            return true;
        }
        else
            return false;
    }


    public static void clearAll() {
        Base.driver.findElement(By.xpath("//button[text()='Clear All']")).click();
    }
}
