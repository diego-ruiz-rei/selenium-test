package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import gov.gsa.Utilities.CommonUtils.DataField;
import gov.gsa.Utilities.ObjectView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class OpportunitiesObjectViewPage extends ObjectView {

    public static Boolean oppTitle() {
        return Base.driver.findElements(By.tagName("h1")).size() > 0;
    }

    //Opportunity Header
    public static DataField solicitation() {

        String label = Base.driver.findElement(By.cssSelector("#opportunity-header-solicitation-number > div > div.header")).getText();
        String data = Base.driver.findElement(By.cssSelector("#opportunity-header-solicitation-number > div > div.description")).getText();
        System.out.println("Solicitation Number : "+label+"\nData : "+data);
        return new DataField("Solicitation Number",label,data);

    }

    public static DataField office() {
        String label = Base.driver.findElement(By.cssSelector("#opportunity-header-hierarchy-level > div > div.header")).getText();
        String data = Base.driver.findElement(By.cssSelector("#opportunity-header-hierarchy-level > div > div.description")).getText();
        System.out.println("Office : "+label+"\nData : "+data);
        return new DataField("Office",label,data);
    }

    public static DataField location() {
       /* String location = Base.driver.findElement(By.id("opportunity-header-location")).getText();
        return CommonUtils.splitLabelAndData(location).setName("Location");*/

        String label = Base.driver.findElement(By.cssSelector("#opportunity-header-location > div > div.header")).getText();
        String data = Base.driver.findElement(By.cssSelector("#opportunity-header-location > div > div.description")).getText();
        System.out.println("Location : "+label+"\nData : "+data);
        return new DataField("Location",label,data);

    }

    //General Information
    public static DataField oppType() {
        String opportunityType = Base.driver.findElement(By.id("opportunity-general-type")).getText();
        return CommonUtils.splitLabelAndData(opportunityType).setName("Opportunity Type");
    }

    public static DataField postedDate() {
        String postedDate = Base.driver.findElement(By.id("opportunity-general-posted-date")).getText();
        return CommonUtils.splitLabelAndData(postedDate).setName("Posted Date");
    }

    public static DataField originalPosted() {
        String originalPosted = Base.driver.findElement(By.id("opportunity-general-original-posted-date")).getText();
        return CommonUtils.splitLabelAndData(originalPosted).setName("Original Posted Date");
    }

    public static DataField updatedPostedDate(){
        String updatedPostedDate = Base.driver.findElement(By.id("opportunity-general-posted-date")).getText();
        return CommonUtils.splitLabelAndData(updatedPostedDate).setName("Update/Amendment Posted Date");
    }

    public static DataField originalResponse() {
        String originalResponse = Base.driver.findElement(By.id("opportunity-general-original-response-date")).getText();
        return CommonUtils.splitLabelAndData(originalResponse).setName("Original Response Date");
    }

    public static DataField updatedResponseDate(){
        String updatedResponseDate = Base.driver.findElement(By.id("opportunity-general-response-date")).getText();
        return CommonUtils.splitLabelAndData(updatedResponseDate).setName("Update/Amendment Response Date");
    }

    public static DataField archivingPolicy() {
        String archivingPolicy = Base.driver.findElement(By.id("opportunity-general-archiving-policy")).getText();
        return CommonUtils.splitLabelAndData(archivingPolicy).setName("Archiving Policy");
    }

    public static DataField updatedArchiveDate(){
        String updatedArchiveDate = Base.driver.findElement(By.id("opportunity-general-archive-date")).getText();
        return CommonUtils.splitLabelAndData(updatedArchiveDate).setName("Update/Amendment Archive Date");
    }

    //Classification Section
    public static DataField originalSetAside() {
        String originalSetAside = Base.driver.findElement(By.id("opportunity-classification-original-set-aside")).getText();
        return CommonUtils.splitLabelAndData(originalSetAside).setName("Original Set Aside");
    }

    public static DataField updatedSetAside() {
        String updatedSetAside = Base.driver.findElement(By.id("opportunity-classification-set-aside")).getText();
        return CommonUtils.splitLabelAndData(updatedSetAside).setName("Update/Amendment Set Aside");
    }

    public static DataField classificationCode() {
        String classificationCode = Base.driver.findElement(By.id("opportunity-classification-classification-code")).getText();
        return CommonUtils.splitLabelAndData(classificationCode).setName("Classification Code");
    }

    // todo change to DataField
    public static Boolean naicsCode() {
        WebElement naicsCodeElement = Base.driver.findElement(By.id("opportunity-classification-naics-code"));
        List<WebElement> naicsCode = naicsCodeElement.findElements(By.cssSelector("ul > li"));
        if(naicsCode.size()> 0){
            return true;
        }else{
            return false;
        }
    }


    //TODO : Add for Address, city and state
    public static DataField placeOfPerformance() {
        String pop = Base.driver.findElement(By.id("opportunity-classification-pop-location")).getText();
        String poplabel = Base.driver.findElement(By.id("opportunity-classification-pop")).getText();
        return new DataField("Place of Performance", poplabel, pop);
    }

    //Contact Information
    public static ArrayList<String> primaryPointOfContact() {
        String pocfullname = "";
        String popemail = "";
        String popphone = "";
        List <WebElement> pocfullnameConts = Base.driver.findElements(By.id("opportunity-contact-primary-poc-full-name"));
        if(pocfullnameConts.size() > 0) {
            for (WebElement pocfullnameCont : pocfullnameConts) {
                pocfullname = pocfullnameCont.getText();
            }
        }
        List<WebElement> popemailConts= Base.driver.findElements(By.id("opportunity-contact-primary-poc-email"));
        if(popemailConts.size() > 0) {
            for (WebElement popemailCont : popemailConts) {
                popemail = popemailCont.findElement(By.tagName("a")).getText();
            }
        }
        List<WebElement> popphoneConts = Base.driver.findElements(By.id("opportunity-contact-primary-poc-phone"));
        if(popemailConts.size() > 0) {
            for (WebElement popphoneCont : popphoneConts) {
                popphone = popphoneCont.getText();
            }
        }
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(pocfullname);
        ar.add(popemail);
        ar.add(popphone);
        return ar;

    }

    //Contracting Office
    public static ArrayList<String> contractingOffice() {
        ArrayList<String> ar = new ArrayList<String>();
        if (Base.driver.findElements(By.id("opportunity-contact-contracting-office-street")).size() > 0) {
            ar.add(Base.getDriver().findElement(By.id("opportunity-contact-contracting-office-street")).getText());
        } else if (Base.getDriver().findElements(By.id("opportunity-contact-contracting-office-city")).size() > 0) {
            ar.add(Base.getDriver().findElement(By.id("opportunity-contact-contracting-office-city")).getText());
        } else if (Base.getDriver().findElements(By.id("opportunity-contact-contracting-office-state")).size() > 0) {
            ar.add(Base.getDriver().findElement(By.id("opportunity-contact-contracting-office-state")).getText());
        } else if (Base.getDriver().findElements(By.id("opportunity-contact-contracting-office-country")).size() > 0) {
            ar.add(Base.getDriver().findElement(By.id("opportunity-contact-contracting-office-country")).getText());
        } else if (Base.getDriver().findElements(By.id("opportunity-contact-contracting-office-zip")).size() > 0) {
            ar.add(Base.getDriver().findElement(By.id("opportunity-contact-contracting-office-zip")).getText());
        }
        return ar;
    }

    //Updated/Amendment Opportunity
    //Check Opportunity Type
    public static DataField opportunityType() {
        String oppType = "";
        List<WebElement> oppTypeElements = Base.driver.findElements(By.id("opportunity-general-type"));
        if(oppTypeElements.size() > 0) {
            for (WebElement oppTypeElement : oppTypeElements) {
                oppType = oppTypeElement.getText();
            }
            return CommonUtils.splitLabelAndData(oppType).setName("Opportunity Type");
        }
        else
        {
            return new DataField("Opportunity Type",null,null);
        }
    }


    //OPPORTUNITY PACKAGES
    //Packages - Expand Link
    public static void packagesExpand() {
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-header")));
        element.click();
    }

    public static void downloadButtonIsLoaded(){
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-header")));
    }


    //Packages - Section Title
    public static String packagesTitle() throws InterruptedException {
        packagesExpand();
        Thread.sleep(1000);
        return Base.driver.findElement(By.cssSelector(".download-container-header > h2")).getText();
    }

    //Packages - Download All Button
    public static String downloadAllButton() throws InterruptedException {
        packagesExpand();
        Thread.sleep(1000);
        return Base.driver.findElement(By.cssSelector(".download-container-header .download-button .usa-button-small.usa-button-gray>span")).getText();
    }

    //Packages - Download  Button
    public static String downloadButton() throws InterruptedException {
        packagesExpand();
        Thread.sleep(1000);
        return Base.driver.findElement(By.cssSelector(".download-container .download-button .usa-button-small.usa-button-gray>span")).getText();
    }


    //Packages - External Link Check
    public static String externalLink() throws InterruptedException {
        packagesExpand();
        Thread.sleep(1000);
        return Base.driver.findElement(By.cssSelector(".download-info-link > a")).getText();
    }

    //Packages - Document Check
    public static ArrayList<String> document() throws InterruptedException {
        packagesExpand();
        Thread.sleep(1000);
        String doc = Base.driver.findElement(By.cssSelector(".download-info-link > a")).getText();
        String doctype = Base.driver.findElement(By.cssSelector(".download-info-type")).getText();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(doc);
        ar.add(doctype);
        return ar;
    }

    //Package - Document Icons
    public static String documentIcon() throws InterruptedException {
        packagesExpand();
        Thread.sleep(1000);
        return Base.driver.findElement(By.cssSelector(".download-info-icon > i")).getAttribute("class");
    }

    //Package - No Package Message
    public static String noPackage() throws InterruptedException {
        //packagesExpand();
        Thread.sleep(5000);
        //WebElement element = (WebElement) Base.wait.until(
        //        ExpectedConditions.textToBePresentInElementValue(By.cssSelector(".card-secure-content.usa-text-center > strong"),"No packages uploaded."));
        //System.out.println("No Package Message : " + Base.driver.findElement(By.cssSelector(".card-secure-content.usa-text-center > strong")).getText());
        return Base.driver.findElement(By.cssSelector(".card-secure-content.usa-text-center > strong")).getText();

    }


    //Packages - multiple packages Count
    public static int multiplePackagesCount() throws InterruptedException {
        packagesExpand();
        Thread.sleep(1000);
        return Base.driver.findElements(By.className("download-container")).size();
    }

    //Packages - Secure packages Count
    public static ArrayList<Integer> secureNotSecurePackagesCount() throws InterruptedException {
        packagesExpand();
        Thread.sleep(5000);
        int secureCount = Base.driver.findElements(By.cssSelector(".card-extra-content .fa.fa-lock")).size();
        int notSecuredCount = Base.driver.findElements(By.cssSelector("i.fa.fa-unlock")).size();
        System.out.println("Secured Count "+secureCount+"\nNot Secured Count "+notSecuredCount);
        ArrayList<Integer> ar = new ArrayList<Integer>();
        ar.add(secureCount);
        ar.add(notSecuredCount);
        return ar;
    }

    //Packages - Secure packages Content
    public static ArrayList<String> secureContent() throws InterruptedException {
        packagesExpand();
        Thread.sleep(1000);
        String secured = Base.driver.findElement(By.xpath("//*[@class=\"card-extra-content\"]/div[2]/strong")).getText();
        String securedMessage = Base.driver.findElement(By.cssSelector(".card-secure-content >p > em")).getText();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(secured);
        ar.add(securedMessage);
        return ar;
    }



    //Packages - Download All Packages
    public static int downloadAllPackages() throws InterruptedException, MalformedURLException,IOException {
        int code = 0;
        try {
            packagesExpand();
            downloadButtonIsLoaded();
            Thread.sleep(1000);
            String link = Base.driver.findElement(By.className("download-button")).findElement(By.tagName("a")).getAttribute("href");
            System.out.println("Link: " + link);
            URL url = new URL(link);
            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
            connection.setHostnameVerifier ((hostname, session) -> true);
            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);
            connection.connect();
            Thread.sleep(5000);
            code = connection.getResponseCode();
        } catch(InterruptedException e){
            System.out.println("InterruptedException");
            e.printStackTrace();
        } catch(MalformedURLException e){
            System.out.println("MalformedURLException");
            e.printStackTrace();
        } catch(IOException e){
            System.out.println("IOException");
            e.printStackTrace();
        }
        return code;
    }
//    //Packages - Download Single Package
   public static int downloadSinglePackage() throws InterruptedException, MalformedURLException,IOException {
int code = 0;
    try {
        packagesExpand();
        downloadButtonIsLoaded();
        Thread.sleep(1000);
        String link = Base.driver.findElement(By.className("download-container")).findElement(By.tagName("a")).getAttribute("href");
        System.out.println("Link: " + link);
        URL url = new URL(link);
        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
        connection.setHostnameVerifier ((hostname, session) -> true);
        connection.setRequestMethod("GET");
        connection.setReadTimeout(10000);
        connection.connect();
        Thread.sleep(5000);
        code = connection.getResponseCode();
    } catch(InterruptedException e){
        System.out.println("InterruptedException");
        e.printStackTrace();
    } catch(MalformedURLException e){
        System.out.println("MalformedURLException");
        e.printStackTrace();
    } catch(IOException e){
        System.out.println("IOException");
        e.printStackTrace();
    }
        return code;
    }
    //Packages - Not Secured
    public static String notSecurePackage() throws InterruptedException {
        packagesExpand();
        Thread.sleep(1000);
        return Base.driver.findElement(By.xpath("//*[@class=\"card-extra-content\"]/div[2]/strong")).getText();
    }

    public static DataField contractAwardDollarAmount() {
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("opportunity-award")));
        String contractAwardDollarAmount = Base.driver.findElement(By.id("opportunity-award-amount")).getText();
        return CommonUtils.splitLabelAndData(contractAwardDollarAmount).setName("Contract Award Dollar Amount");
    }

    public static DataField contractAwardDate() {
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("opportunity-award")));
        String contractAwardDate = Base.driver.findElement(By.id("opportunity-award-date")).getText();
        return CommonUtils.splitLabelAndData(contractAwardDate).setName("Contract Award Date");
    }

    public static DataField contractAwardNumber() {
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("opportunity-award")));
        String contractAwardNumber = Base.driver.findElement(By.id("opportunity-award-number")).getText();
        return CommonUtils.splitLabelAndData(contractAwardNumber).setName("Contract Award Number");
    }

    public static DataField contractLineItemNumber() {
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("opportunity-award")));
        String contractLineItemNumber = Base.driver.findElement(By.id("opportunity-award-line-item-number")).getText();
        return CommonUtils.splitLabelAndData(contractLineItemNumber).setName("Contract Line Item Number");
    }

    public static DataField contractorAwardedName() {
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("opportunity-award")));
        String contractorAwardedName = Base.driver.findElement(By.id("opportunity-awarded-name")).getText();
        return CommonUtils.splitLabelAndData(contractorAwardedName).setName("Contractor Awarded Name");
    }

    public static DataField contractorAwardedDUNS() {
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("opportunity-award")));
        String contractorAwardedDUNS = Base.driver.findElement(By.id("opportunity-awarded-duns")).getText();
        return CommonUtils.splitLabelAndData(contractorAwardedDUNS).setName("Contractor Awarded DUNS");
    }

    public static DataField contractorAwardedAddress() {
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("opportunity-award")));
        String contractorAwardedAddress = Base.driver.findElement(By.id("opportunity-awarded-address")).getText();
        return CommonUtils.splitLabelAndData(contractorAwardedAddress).setName("Contractor Awarded Address");
    }

    public static DataField statutoryAuthority() {
        String statutoryAuthority = Base.driver.findElement(By.id("opportunity-general-statutory-authority")).getText();
        return CommonUtils.splitLabelAndData(statutoryAuthority).setName("J&A Statutory Authority");
    }

    public static DataField justificationAuthority() {
        String justificationAuthority = Base.driver.findElement(By.id("opportunity-general-justification-authority")).getText();
        return CommonUtils.splitLabelAndData(justificationAuthority).setName("Fair Opportunity / Limited Sources Justification Authority");
    }

    public static DataField orderNumber() {
        String orderNumber = Base.driver.findElement(By.id("opportunity-order-number")).getText();
        return CommonUtils.splitLabelAndData(orderNumber).setName("Task/Delivery Order Number");
    }

    public static DataField specialLegislation() {
        String specialLegislation = Base.driver.findElement(By.id("opportunity-general-special-legislation")).getText();
        return CommonUtils.splitLabelAndData(specialLegislation).setName("Special Legislation");
    }

    //View/Hide Changes
    public static String viewHideChangesButton(String sectionId) throws InterruptedException {
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Hide Changes']")));
        return Base.driver.findElement(By.id(sectionId)).getText();
    }

    public static String synopsisViewHideChangesButton() throws InterruptedException {
        Thread.sleep(2000);
        Base.driver.findElement(By.id("defaultBtnSynopsis")).click();
        return viewHideChangesButton("defaultBtnSynopsis");
    }

    public static String generalInformationViewHideChangesButton() throws InterruptedException {
        Thread.sleep(2000);
        Base.driver.findElement(By.id("defaultBtnGeneral")).click();
        return viewHideChangesButton("defaultBtnGeneral");
    }

    public static String classificationViewHideChangesButton() throws InterruptedException {
        Thread.sleep(2000);
        Base.driver.findElement(By.id("defaultBtnClassification")).click();
        return viewHideChangesButton("defaultBtnClassification");
    }

    //changes from date
    public static String changesFrom(String sectionId) throws InterruptedException, ParseException {
        //Base.driver.findElement(By.id("defaultBtnSynopsis")).click();
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Hide Changes']")));

        String changesFromText = Base.driver.findElement(By.cssSelector("#"+sectionId+" > h2 > span")).getText();
        String Date = changesFromText.substring(changesFromText.indexOf("from")+5).trim();
        System.out.println("Date "+Date);
        return Date;
    }

    public static String synopsisChangesFrom() throws InterruptedException, ParseException {
        Base.driver.findElement(By.id("defaultBtnSynopsis")).click();
        return changesFrom("opportunity-synopsis");
    }

    public static String generalInformationChangesFrom() throws InterruptedException, ParseException {
        Thread.sleep(2000);
        Base.driver.findElement(By.id("defaultBtnGeneral")).click();
        return changesFrom("opportunity-general");
    }

    public static String classificationChangesFrom() throws InterruptedException, ParseException {
        Thread.sleep(2000);
        Base.driver.findElement(By.id("defaultBtnClassification")).click();
        return changesFrom("opportunity-classification");
    }

    public static Boolean ViewChangesButtonExist(String section) {
        switch (section){
            case "Contact Information":  section = "Contact Information";
                return (Base.driver.findElement(By.id("defaultBtnContactInformation")).getText().equals("View Changes"));
            case "Award Details":
                return (Base.driver.findElement(By.id("defaultBtnAwardDetails")).getText().equals("View Changes"));
            default:
                return false;
        }
    }

    public static String ViewChangesChangesFromExist(String section) throws InterruptedException, ParseException{
        switch (section){
            case "Contact Information":  section = "Contact Information";
                Base.driver.findElement(By.id("defaultBtnContactInformation")).click();
                return changesFrom("opportunity-contact");
            case "Award Details":
                Base.driver.findElement(By.id("defaultBtnAwardDetails")).click();
                return changesFrom("opportunity-award");
            default:
                return "";
        }
    }

    public static String ViewChangesFieldUpdated(String section, String field) throws InterruptedException, ParseException{
        switch (section){
            case "Contact Information":  section = "Contact Information";
                Base.driver.findElement(By.id("defaultBtnContactInformation")).click();
                if(field.equals("Contracting Office Address"))
                    return tagExists("opportunity-contact-contracting-office","#opportunity-contact-contracting-office");
                else if(field.equals("Primary Point Of Contact Name"))
                    return tagExists("opportunity-contact-primary-poc-full-name", "#opportunity-contact-primary-poc-full-name");
                else if(field.equals("Primary Point Of Contact Email"))
                    return tagExists("opportunity-contact-primary-poc-email", "#opportunity-contact-primary-poc-email");
                else if(field.equals("Primary Point Of Contact Phone"))
                    return tagExists("opportunity-contact-primary-poc-phone", "#opportunity-contact-primary-poc-phone");
                else if(field.equals("Primary Point Of Contact Title"))
                    return tagExists("opportunity-contact-primary-poc-title", "#opportunity-contact-primary-poc-title");
                else if(field.equals("Secondary Point Of Contact Name"))
                    return tagExists("opportunity-contact-secondary-poc-full-name", "#opportunity-contact-secondary-poc-full-name");
                else if(field.equals("Secondary Point Of Contact Title"))
                    return tagExists("opportunity-contact-secondary-poc-title", "#opportunity-contact-secondary-poc-title");
                else if(field.equals("Secondary Point Of Contact Email"))
                    return tagExists("opportunity-contact-secondary-poc-email", "#opportunity-contact-secondary-poc-email");
                else return "";

            case "Award Details":
                Base.driver.findElement(By.id("defaultBtnAwardDetails")).click();
                if(field.equals("Contract Award Date"))
                    return tagExists("opportunity-award-date","#opportunity-award-date");
                else if(field.equals("Contract Award Number"))
                    return tagExists("opportunity-award-number", "#opportunity-award-number");
                else if(field.equals("Contractor Awarded DUNS"))
                    return tagExists("opportunity-awarded-duns", "#opportunity-awarded-duns");
                else if(field.equals("Contractor Awarded Name"))
                    return tagExists("opportunity-awarded-name", "#opportunity-awarded-name");
                else if(field.equals("Contractor Awarded Address"))
                    return tagExists("opportunity-awarded-address", "#opportunity-awarded-address");
                else if(field.equals("Contract Award Dollar Amount"))
                    return tagExists("opportunity-award-amount", "#opportunity-award-amount");
                else if(field.equals("Contract Line Item Number"))
                    return tagExists("opportunity-award-line-item-number", "#opportunity-award-line-item-number");
                else return "";
            default:
                return "";
        }
    }


    public static String tagExists(String sectionID,String cssSelectorText) throws InterruptedException, ParseException {
        //Base.driver.findElement(By.id("defaultBtnSynopsis")).click();
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Hide Changes']")));

        WebElement field_content= Base.driver.findElement(By.cssSelector(cssSelectorText));
        String updated_data = null;
        if (field_content.findElements(By.tagName("strike")).size()>0)
            updated_data = field_content.findElement(By.tagName("strike")).getText();
        else if (field_content.findElements(By.tagName("u")).size()>0)
            updated_data = field_content.findElement(By.tagName("u")).getText();
        else if (field_content.findElements(By.cssSelector("#"+sectionID+" > div > span > font > i")).size()>0)
            updated_data = field_content.findElement(By.cssSelector("#"+sectionID+" > div > span > font > i")).getText();
        else if (field_content.findElements(By.cssSelector("#"+sectionID+" > span > font > i")).size()>0)
            updated_data = field_content.findElement(By.cssSelector("#"+sectionID+" > span > font > i")).getText();
        else if (field_content.findElements(By.cssSelector("#"+sectionID+" > ul > span > font > i")).size()>0)
            updated_data = field_content.findElement(By.cssSelector("#"+sectionID+" > ul > span > font > i")).getText();
        else
            updated_data = "";
        System.out.println("Updated Data : "+updated_data);
        return updated_data;
    }

    public static String generalInformationUpdateResponseDateTagExists() throws InterruptedException, ParseException {
        Base.driver.findElement(By.id("defaultBtnGeneral")).click();
        return tagExists("opportunity-general-response-date","#opportunity-general-response-date > span ");
    }

    public static String generalInformationArchivingPolicyTagExists() throws InterruptedException, ParseException {
        Thread.sleep(2000);
        Base.driver.findElement(By.id("defaultBtnGeneral")).click();
        return tagExists("opportunity-general-response-date","#opportunity-general-archiving-policy > span");
    }

    public static String generalInformationUpdateArchiveDateTagExists() throws InterruptedException, ParseException {
        Base.driver.findElement(By.id("defaultBtnGeneral")).click();
        return tagExists("opportunity-general-archive-date","#opportunity-general-archive-date > span ");
    }

    public static String generalInformationSpecialLegislationTagExists() throws InterruptedException, ParseException {
        Base.driver.findElement(By.id("defaultBtnGeneral")).click();
        return tagExists("opportunity-general-special-legislation","#opportunity-general-special-legislation > span");
    }

    public static String synopsisTagExists() throws InterruptedException, ParseException {
        Thread.sleep(2000);
        Base.driver.findElement(By.id("defaultBtnSynopsis")).click();
        return tagExists("opportunity-synopsis","#opportunity-synopsis > .usa-changes");
    }

    public static String classificationUpdateSetAsideTagExists() throws InterruptedException, ParseException {
        Thread.sleep(2000);
        Base.driver.findElement(By.id("defaultBtnClassification")).click();
        return tagExists("opportunity-classification-set-aside","#opportunity-classification-set-aside > span");
    }

    public static String classificationCodeTagExists() throws InterruptedException, ParseException {
        Base.driver.findElement(By.id("defaultBtnClassification")).click();
        return tagExists("opportunity-classification-classification-code","#opportunity-classification-classification-code > span");
    }

    public static String classificationNAICSTagExists() throws InterruptedException, ParseException {
        Base.driver.findElement(By.id("defaultBtnClassification")).click();
        return tagExists("opportunity-classification-set-aside","#opportunity-classification-naics-code > pre");
    }

    public static String classificationPlaceOfPerformanceTagExists() throws InterruptedException, ParseException {
        Thread.sleep(2000);
        Base.driver.findElement(By.id("defaultBtnClassification")).click();
        return tagExists("opportunity-classification","#opportunity-classification > ul > span ");
    }

    //Finds current element and then index of previous element in History Section
    public static Integer getHistorySectionIndex() throws InterruptedException,ParseException {
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("opportunity-history")));
        List<WebElement> history_section = Base.driver.findElements(By.cssSelector("#opportunity-history > sam-history > ul > li"));
        Integer index = null;
        if(history_section.size() > 0) {
            for (WebElement history : history_section) {
                String className = history.getAttribute("class");
                if(history.getAttribute("class").contains("current")){
                    index = history_section.indexOf(history);
                }
            }
            System.out.println("Index : "+index);
        }
        return index;
    }

    public static String historySectionDate() throws InterruptedException,ParseException {
        Integer index = getHistorySectionIndex();
        return Base.driver.findElement(By.cssSelector("#opportunity-history > sam-history > ul > li:nth-child("+index+") > span > strong")).getText();
    }


    //History Section
    public static String historySectionTitle() throws InterruptedException, ParseException {
        return Base.driver.findElement(By.cssSelector("#opportunity-history > h2")).getText();
    }

    //Check number of elements in History section
    public static Integer historySectionCount() throws InterruptedException, ParseException {
        System.out.println("Number of Elements in History Section : "+Base.driver.findElements(By.cssSelector("#opportunity-history > sam-history > ul > li")).size());
        return Base.driver.findElements(By.cssSelector("#opportunity-history > sam-history > ul > li")).size();
    }

    //Check Original is displayed in first element in History section
    public static String originalNoticeText() throws InterruptedException, ParseException {
        System.out.println("First element Text History Section : "+Base.driver.findElement(By.cssSelector("#opportunity-history > sam-history > ul > li:nth-child(1) > span > a")).getText());
        return Base.driver.findElement(By.cssSelector("#opportunity-history > sam-history > ul > li:nth-child(1) > span > a")).getText();
    }

    //Click on previous section on History section
    public static String previousVersionNoticePage() throws InterruptedException, ParseException {
        Integer index = getHistorySectionIndex();
        Base.driver.findElement(By.cssSelector("#opportunity-history > sam-history > ul > li:nth-child("+index+") > span > a")).click();
        Thread.sleep(5000);
        System.out.println("Updated Posted Date : "+updatedPostedDate().data);
        return updatedPostedDate().data;

    }

    //capture message from previous version
    public static String updatedNoticeMessage() throws InterruptedException,ParseException {
        Integer index = getHistorySectionIndex();
        Base.driver.findElement(By.cssSelector("#opportunity-history > sam-history > ul > li:nth-child("+index+") > span > a")).click();
        Thread.sleep(2000);

        return Base.driver.findElement(By.cssSelector("#main-container > ng-component > div > div > sam-alert > div > div > p")).getText();
    }

    public static String updatedNoticeLink() throws InterruptedException, ParseException {
        Integer index = getHistorySectionIndex();
        Base.driver.findElement(By.cssSelector("#opportunity-history > sam-history > ul > li:nth-child("+index+") > span > a")).click();
        Thread.sleep(5000);
        Base.driver.findElement(By.cssSelector("#main-container > ng-component > div > div > sam-alert > div > div > p > a")).click();
        Thread.sleep(5000);
        Integer current_index = index+1;
        System.out.println("Class Name : "+Base.driver.findElement(By.cssSelector("#opportunity-history > sam-history > ul > li:nth-child("+current_index+")")).getAttribute("class"));
        return Base.driver.findElement(By.cssSelector("#opportunity-history > sam-history > ul > li:nth-child("+current_index+")")).getAttribute("class");
    }

}




