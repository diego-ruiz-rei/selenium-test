package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.ObjectView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class OpportunitiesObjectViewPage extends ObjectView {


//    // I don't think this is required here..have to look into why this is being called
//    public OpportunitiesObjectViewPage(){
//        super();
//    }

    public static Boolean oppTitle() {
        return Base.driver.findElements(By.tagName("h1")).size() > 0;
    }

    //Function to split Data and Label
    public static ArrayList<String> splitLabelAndData(String element){
        String soldata = element.substring(element.lastIndexOf(':')+1).trim();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(element);
        ar.add(soldata);
        return ar;
    }

    //Opportunity Header
    public static ArrayList<String> solicitation(){
        String solname = Base.driver.findElement(By.id("opportunity-header-solicitation-number")).getText();
        return splitLabelAndData(solname);
    }

    public static ArrayList<String> office(){
        String officename = Base.driver.findElement(By.id("opportunity-header-hierarchy-level")).getText();
        return splitLabelAndData(officename);
    }

    public static ArrayList<String> location(){
        String locationname = Base.driver.findElement(By.id("opportunity-header-location")).getText();
        return splitLabelAndData(locationname);
    }

    //General Information
    public static ArrayList<String> oppType(){
        String opportunitytype = Base.driver.findElement(By.id("opportunity-general-type")).getText();
        return splitLabelAndData(opportunitytype);
    }

    public static ArrayList<String> postedDate(){
        String posted = Base.driver.findElement(By.id("opportunity-general-posted-date")).getText();
        return splitLabelAndData(posted);
    }

    public static ArrayList<String> originalPosted(){
        String ori_posted = Base.driver.findElement(By.id("opportunity-general-original-posted-date")).getText();
        return splitLabelAndData(ori_posted);
    }

    public static ArrayList<String> resposnseDate(){
        String response = Base.driver.findElement(By.id("opportunity-general-response-date")).getText();
        return splitLabelAndData(response);
    }

    public static ArrayList<String> originalResponse(){
        String ori_response = Base.driver.findElement(By.id("opportunity-general-original-response-date")).getText();
        return splitLabelAndData(ori_response);
    }

    public static ArrayList<String> archivingPolicy(){
        String arch_policy = Base.driver.findElement(By.id("opportunity-general-archiving-policy")).getText();
        return splitLabelAndData(arch_policy);
    }

    //Classification Section
    public static ArrayList<String> originalSetAside(){
        String ori_set = Base.driver.findElement(By.id("opportunity-classification-original-set-aside")).getText();
        return splitLabelAndData(ori_set);
    }

    public static ArrayList<String> classificationCode(){
        String classi_code = Base.driver.findElement(By.id("opportunity-classification-classification-code")).getText();
        return splitLabelAndData(classi_code);
    }

    public static String naicscode(){
        WebElement naics = Base.driver.findElement(By.xpath("//*[@id=\"opportunity-classification-naics-code\"]/ul/li"));
        return naics.getText();

    }

    //TODO : Add for Address, city and state
    public static ArrayList<String> placeOfPerformance(){
        String pop= Base.driver.findElement(By.id("opportunity-classification-pop-location")).getText();
        String poplabel = Base.driver.findElement(By.id("opportunity-classification-pop")).getText();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(poplabel);
        ar.add(pop);
        return ar;

    }

    //Contact Information
    public static ArrayList<String> primaryPointOfContact(){
        String pocfullname= Base.driver.findElement(By.id("opportunity-contact-primary-poc-full-name")).getText();
        String popemail = Base.driver.findElement(By.xpath("//*[@id=\"opportunity-contact-primary-poc-email\"]/a")).getText();
        String popphone = Base.driver.findElement(By.id("opportunity-contact-primary-poc-phone")).getText();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(pocfullname);
        ar.add(popemail);
        ar.add(popphone);
        return ar;

    }


}
