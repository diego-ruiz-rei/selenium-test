package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils.DataField;
import gov.gsa.Utilities.ObjectView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class OpportunitiesObjectViewPage extends ObjectView {


//    // I don't think this is required here..have to look into why this is being called
//    public OpportunitiesObjectViewPage(){
//        super();
//    }

    public static Boolean oppTitle() {
        return Base.driver.findElements(By.tagName("h1")).size() > 0;
    }

    private static DataField splitLabelAndData(String element) {
        String fieldLabel = element.substring(0, element.indexOf(':')).trim(); // get all up to but not including colon
        String fieldData = element.substring(element.indexOf(':') + 1).trim(); // get all after and not including colon

        return new DataField(null, fieldLabel, fieldData);
    }

    //Opportunity Header
    public static DataField solicitation() {
        String solname = Base.driver.findElement(By.id("opportunity-header-solicitation-number")).getText();
        return splitLabelAndData(solname).setName("Solicitation Number");
    }

    public static DataField office() {
        String office = Base.driver.findElement(By.id("opportunity-header-hierarchy-level")).getText();
        return splitLabelAndData(office).setName("Office");
    }

    public static DataField location() {
        String location = Base.driver.findElement(By.id("opportunity-header-location")).getText();
        return splitLabelAndData(location).setName("Location");
    }

    //General Information
    public static DataField oppType() {
        String opportunityType = Base.driver.findElement(By.id("opportunity-general-type")).getText();
        return splitLabelAndData(opportunityType).setName("Opportunity Type");
    }

    public static DataField postedDate() {
        String postedDate = Base.driver.findElement(By.id("opportunity-general-posted-date")).getText();
        return splitLabelAndData(postedDate).setName("Posted Date");
    }

    public static DataField originalPosted() {
        String originalPosted = Base.driver.findElement(By.id("opportunity-general-original-posted-date")).getText();
        return splitLabelAndData(originalPosted).setName("Original Posted Date");
    }

    public static DataField responseDate() {
        String responseDate = Base.driver.findElement(By.id("opportunity-general-response-date")).getText();
        return splitLabelAndData(responseDate).setName("Response Date");
    }

    public static DataField originalResponse() {
        String originalResponse = Base.driver.findElement(By.id("opportunity-general-original-response-date")).getText();
        return splitLabelAndData(originalResponse).setName("Original Response Date");
    }

    public static DataField archivingPolicy() {
        String archivingPolicy = Base.driver.findElement(By.id("opportunity-general-archiving-policy")).getText();
        return splitLabelAndData(archivingPolicy).setName("Archiving Policy");
    }

    //Classification Section
    public static DataField originalSetAside() {
        String originalSetAside = Base.driver.findElement(By.id("opportunity-classification-original-set-aside")).getText();
        return splitLabelAndData(originalSetAside).setName("Original Set Aside");
    }

    public static DataField classificationCode() {
        String classificationCode = Base.driver.findElement(By.id("opportunity-classification-classification-code")).getText();
        return splitLabelAndData(classificationCode).setName("Classification Code");
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
        Thread.sleep(1000);
        int secureCount = Base.driver.findElements(By.cssSelector(".card-extra-content .fa.fa-lock")).size();
        int notSecuredCount = Base.driver.findElements(By.cssSelector("i.fa.fa-unlock")).size();
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
        return splitLabelAndData(contractAwardDollarAmount).setName("Contract Award Dollar Amount");
    }

    public static DataField contractAwardDate() {
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("opportunity-award")));
        String contractAwardDate = Base.driver.findElement(By.id("opportunity-award-date")).getText();
        return splitLabelAndData(contractAwardDate).setName("Contract Award Date");
    }

    public static DataField contractAwardNumber() {
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("opportunity-award")));
        String contractAwardNumber = Base.driver.findElement(By.id("opportunity-award-number")).getText();
        return splitLabelAndData(contractAwardNumber).setName("Contract Award Number");
    }

    public static DataField contractLineItemNumber() {
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("opportunity-award")));
        String contractLineItemNumber = Base.driver.findElement(By.id("opportunity-award-line-item-number")).getText();
        return splitLabelAndData(contractLineItemNumber).setName("Contract Line Item Number");
    }

    public static DataField contractorAwardedName() {
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("opportunity-award")));
        String contractorAwardedName = Base.driver.findElement(By.id("opportunity-awarded-name")).getText();
        return splitLabelAndData(contractorAwardedName).setName("Contractor Awarded Name");
    }

    public static DataField contractorAwardedDUNS() {
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("opportunity-award")));
        String contractorAwardedDUNS = Base.driver.findElement(By.id("opportunity-awarded-duns")).getText();
        return splitLabelAndData(contractorAwardedDUNS).setName("Contractor Awarded DUNS");
    }

    public static DataField contractorAwardedAddress() {
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("opportunity-award")));
        String contractorAwardedAddress = Base.driver.findElement(By.id("opportunity-awarded-address")).getText();
        return splitLabelAndData(contractorAwardedAddress).setName("Contractor Awarded Address");
    }

    public static DataField statutoryAuthority() {
        String statutoryAuthority = Base.driver.findElement(By.id("opportunity-general-statutory-authority")).getText();
        return splitLabelAndData(statutoryAuthority).setName("J&A Statutory Authority");
    }

    public static DataField justificationAuthority() {
        String justificationAuthority = Base.driver.findElement(By.id("opportunity-general-justification-authority")).getText();
        return splitLabelAndData(justificationAuthority).setName("Fair Opportunity / Limited Sources Justification Authority");
    }

    public static DataField orderNumber() {
        String orderNumber = Base.driver.findElement(By.id("opportunity-order-number")).getText();
        return splitLabelAndData(orderNumber).setName("Task/Delivery Order Number");
    }

    public static DataField specialLegislation() {
        String specialLegislation = Base.driver.findElement(By.id("opportunity-general-special-legislation")).getText();
        return splitLabelAndData(specialLegislation).setName("Special Legislation");
    }
}




