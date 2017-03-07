package gov.gsa.Pages;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils.DataField;
import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import gov.gsa.Utilities.ObjectView;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

/**
 * Created by prashant.pillai on 3/1/17.
 */
public class OpportunitiesSearchResultsPage {
    // Opportunities tag in Search results page
    public static String opportunitiesTag(){
        return Base.driver.findElement(By.cssSelector(".search-page .usa-label")).getText();
    }

    // Opportunities Archived tag in Search results page
    public static String opportunitiesArchivedTag(){
        System.out.println("tag : "+Base.driver.findElement(By.cssSelector("opportunities-result > p > span:nth-child(2)")).getText());
        return Base.driver.findElement(By.cssSelector("opportunities-result > p > span:nth-child(2)")).getText();
    }

    //Pagination count
    public static Integer resultsPageCount() throws InterruptedException {
        Thread.sleep(10000);
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
        List<WebElement> typeFieldValueElements = Base.driver.findElements(By.cssSelector("opportunities-result > div.usa-width-one-third > ul > li:nth-child(3)"));
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
        List<WebElement> deptTypeElements = Base.driver.findElements(By.cssSelector(".m_B-2x > li:nth-child(1)"));
        if(deptTypeElements.size() > 0) {
            for (WebElement oppTypeElement : deptTypeElements) {
                deptName = oppTypeElement.getText();
            }
            return splitLabelAndData(deptName).setName("Department/Ind. Agency");
        }
        else
        {
            return new DataField("Department/Ind. Agency",null,null);
        }
    }

    //Check for office name
    public static DataField officeName() {
        String officeName="";
        List<WebElement> officeTypeElements = Base.driver.findElements(By.cssSelector(".m_B-2x > li:nth-child(2)"));
        if(officeTypeElements.size() > 0) {
            for (WebElement oppTypeElement : officeTypeElements) {
                officeName = oppTypeElement.getText();
            }
            return splitLabelAndData(officeName).setName("Office");
        }
        else
        {
            return new DataField("Office",null,null);
        }
    }

    //Check for location name
    public static DataField locationName() {
        String locationName="";
        List<WebElement> locationTypeElements = Base.driver.findElements(By.cssSelector(".m_B-2x > li:nth-child(3)"));

        if(locationTypeElements.size() > 0) {
            for (WebElement oppTypeElement : locationTypeElements) {
                locationName = oppTypeElement.getText();
            }

            return splitLabelAndData(locationName).setName("Location");
        }
        else
        {
            return new DataField("Location",null,null);
        }
    }

    //Check for solicitation number
    public static DataField solicitation() {
        String solicitationNumber="";
        List<WebElement> solicitationTypeElements = Base.driver.findElements(By.cssSelector("opportunities-result > div.usa-width-one-third > ul > li:nth-child(1)"));

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
        List<WebElement> postedDateTypeElements = Base.driver.findElements(By.cssSelector("opportunities-result > div.usa-width-one-third > ul > li:nth-child(2)"));

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
        List<WebElement> typeElements = Base.driver.findElements(By.cssSelector("opportunities-result > div.usa-width-one-third > ul > li:nth-child(3)"));

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
        String descriptionText=Base.driver.findElement(By.cssSelector("opportunities-result > div.usa-width-two-thirds > p > span")).getText();
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
        if(typeFieldValue.equalsIgnoreCase("Presolicitation")){
            return true;
        }
        else
            return false;
    }

    //validate combinedSynopsis type
    public static boolean combinedSynopsis(){
        String typeFieldValue=getTypeFieldValue();
        System.out.print(typeFieldValue);
        if(typeFieldValue.equalsIgnoreCase("Combined Synopsis/Solicitation")){
            return true;
        }
        else
            return false;
    }

    //validate saleOfSurplus type
    public static boolean saleOfSurplus(){
        String typeFieldValue=getTypeFieldValue();
        System.out.print(typeFieldValue);
        if(typeFieldValue.equalsIgnoreCase("Sale of Surplus Property")){
            return true;
        }
        else
            return false;
    }

    //validate sourcesSought type
    public static boolean sourcesSought(){
        String typeFieldValue=getTypeFieldValue();
        System.out.print(typeFieldValue);
        if(typeFieldValue.equalsIgnoreCase("Sources Sought")){
            return true;
        }
        else
            return false;
    }

    //validate justifyApprove type
    public static boolean justifyApprove(){
        String typeFieldValue=getTypeFieldValue();
        System.out.print(typeFieldValue);
        if(typeFieldValue.equalsIgnoreCase("Justification and Approval (J&A)")){
            return true;
        }
        else
            return false;
    }

    //validate awardNotice type
    public static boolean awardCheck(){
        String typeFieldValue=getTypeFieldValue();
        System.out.print(typeFieldValue);
        if(typeFieldValue.equalsIgnoreCase("Award Notice")){
            return true;
        }
        else
            return false;
    }

    //validate Fair Opportunity / Limited Sources Justification type
    public static boolean fairOpportunity(){
        String typeFieldValue=getTypeFieldValue();
        System.out.print(typeFieldValue);
        if(typeFieldValue.equalsIgnoreCase("Fair Opportunity / Limited Sources Justification")){
            return true;
        }
        else
            return false;
    }

    //validate Special Notice type
    public static boolean specialNotice(){
        String typeFieldValue=getTypeFieldValue();
        System.out.print(typeFieldValue);
        if(typeFieldValue.equalsIgnoreCase("Special Notice")){
            return true;
        }
        else
            return false;
    }

    //validate Modification/Amendment/Cancel type
    public static boolean modifyAmend(){
        String typeFieldValue=getTypeFieldValue();
        System.out.print(typeFieldValue);
        if(typeFieldValue.equalsIgnoreCase("Modification/Amendment/Cancel")){
            return true;
        }
        else
            return false;
    }




}
