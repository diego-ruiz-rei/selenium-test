package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.ObjectView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    //Function to split Data and Label
    public static ArrayList<String> splitLabelAndData(String element) {
        String soldata = element.substring(element.lastIndexOf(':') + 1).trim();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(element);
        ar.add(soldata);
        return ar;
    }

    //Opportunity Header
    public static ArrayList<String> solicitation() {
        String solname = Base.driver.findElement(By.id("opportunity-header-solicitation-number")).getText();
        return splitLabelAndData(solname);
    }

    public static ArrayList<String> office() {
        String officename = Base.driver.findElement(By.id("opportunity-header-hierarchy-level")).getText();
        return splitLabelAndData(officename);
    }

    public static ArrayList<String> location() {
        String locationname = Base.driver.findElement(By.id("opportunity-header-location")).getText();
        return splitLabelAndData(locationname);
    }

    //General Information
    public static ArrayList<String> oppType() {
        String opportunitytype = Base.driver.findElement(By.id("opportunity-general-type")).getText();
        return splitLabelAndData(opportunitytype);
    }

    public static ArrayList<String> postedDate() {
        String posted = Base.driver.findElement(By.id("opportunity-general-posted-date")).getText();
        return splitLabelAndData(posted);
    }

    public static ArrayList<String> originalPosted() {
        String ori_posted = Base.driver.findElement(By.id("opportunity-general-original-posted-date")).getText();
        return splitLabelAndData(ori_posted);
    }

    public static ArrayList<String> resposnseDate() {
        String response = Base.driver.findElement(By.id("opportunity-general-response-date")).getText();
        return splitLabelAndData(response);
    }

    public static ArrayList<String> originalResponse() {
        String ori_response = Base.driver.findElement(By.id("opportunity-general-original-response-date")).getText();
        return splitLabelAndData(ori_response);
    }

    public static ArrayList<String> archivingPolicy() {
        String arch_policy = Base.driver.findElement(By.id("opportunity-general-archiving-policy")).getText();
        return splitLabelAndData(arch_policy);
    }

    //Classification Section
    public static ArrayList<String> originalSetAside() {
        String ori_set = Base.driver.findElement(By.id("opportunity-classification-original-set-aside")).getText();
        return splitLabelAndData(ori_set);
    }

    public static ArrayList<String> classificationCode() {
        String classi_code = Base.driver.findElement(By.id("opportunity-classification-classification-code")).getText();
        return splitLabelAndData(classi_code);
    }

    public static String naicscode() {
        WebElement naics = Base.driver.findElement(By.xpath("//*[@id=\"opportunity-classification-naics-code\"]/ul/li"));
        return naics.getText();

    }

    //TODO : Add for Address, city and state
    public static ArrayList<String> placeOfPerformance() {
        String pop = Base.driver.findElement(By.id("opportunity-classification-pop-location")).getText();
        String poplabel = Base.driver.findElement(By.id("opportunity-classification-pop")).getText();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(poplabel);
        ar.add(pop);
        return ar;

    }

    //Contact Information
    public static ArrayList<String> primaryPointOfContact() {
        String pocfullname = Base.driver.findElement(By.id("opportunity-contact-primary-poc-full-name")).getText();
        String popemail = Base.driver.findElement(By.xpath("//*[@id=\"opportunity-contact-primary-poc-email\"]/a")).getText();
        String popphone = Base.driver.findElement(By.id("opportunity-contact-primary-poc-phone")).getText();
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
        Thread.sleep(3000);
        //WebElement element = (WebElement) Base.wait.until(
        //        ExpectedConditions.textToBePresentInElementValue(By.cssSelector(".card-secure-content.usa-text-center > strong"),"No packages uploaded."));
        System.out.println("*** " + Base.driver.findElement(By.cssSelector(".card-secure-content.usa-text-center > strong")).getText());
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

    //Packages - Not Secured
    public static String notSecurePackage() throws InterruptedException {
        packagesExpand();
        Thread.sleep(1000);
        return Base.driver.findElement(By.xpath("//*[@class=\"card-extra-content\"]/div[2]/strong")).getText();
    }
}




