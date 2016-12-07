package gov.gsa.sga;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpportunitiesObjectView extends ObjectView{

    protected String opp_SearchTerm = "F4FRQT3091A007";


    public OpportunitiesObjectView(){
        super();
    }

    public void gotoOppObjectView() throws InterruptedException {
        //System.out.println("Search results page");
        Thread.sleep(1000);
        this.getDriver().findElement(By.name("search")).sendKeys(opp_SearchTerm);
        new Select(driver.findElement(By.id("filter"))).selectByVisibleText("Opportunities");
        this.getDriver().findElement(By.cssSelector(".search-btn")).click();
        Thread.sleep(1000);
        this.getDriver().findElement(By.cssSelector(".opportunity-title > a")).click();
        Thread.sleep(1000);
       // this.appWait();
    }

    public Boolean oppTitle() {
        return this.isElementPresent(By.tagName("h1"));
    }


    //Function to split Data and Label
    public ArrayList<String> splitLabelAndData(String element){
        String soldata = element.substring(element.lastIndexOf(':')+1).trim();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(element);
        ar.add(soldata);
        return ar;
    }

    //Opportunity Header
    public ArrayList<String> solicitation(){
        String solname = getDriver().findElement(By.id("opportunity-header-solicitation-number")).getText();
        return splitLabelAndData(solname);
    }

    public ArrayList<String> office(){
        String officename = this.getDriver().findElement(By.id("opportunity-header-hierarchy-level")).getText();
        return splitLabelAndData(officename);
    }

    public ArrayList<String> location(){
        String locationname = this.getDriver().findElement(By.id("opportunity-header-location")).getText();
        return splitLabelAndData(locationname);
    }

    //General Information
    public ArrayList<String> oppType(){
        String opportunitytype = this.getDriver().findElement(By.id("opportunity-general-type")).getText();
        return splitLabelAndData(opportunitytype);
    }

    public ArrayList<String> postedDate(){
        String posted = this.getDriver().findElement(By.id("opportunity-general-posted-date")).getText();
        return splitLabelAndData(posted);
    }

    //TODO : Not all notices have this date. It is Conditional, need to modify script
    public ArrayList<String> originalPosted(){
        String ori_posted = this.getDriver().findElement(By.id("opportunity-general-original-posted-date")).getText();
        return splitLabelAndData(ori_posted);
    }

    public ArrayList<String> responseDate(){
        String response = this.getDriver().findElement(By.id("opportunity-general-response-date")).getText();
        return splitLabelAndData(response);
    }

    //TODO : Not all notices have this date. It is Conditional, need to modify script
    public ArrayList<String> originalResponse(){
        String ori_response = this.getDriver().findElement(By.id("opportunity-general-original-response-date")).getText();
        return splitLabelAndData(ori_response);
    }

    public ArrayList<String> archivingPolicy(){
        String arch_policy = this.getDriver().findElement(By.id("opportunity-general-archiving-policy")).getText();
        return splitLabelAndData(arch_policy);
    }

    //Classification Section
    //TODO : Not all notices have this date. It is Conditional, need to modify script
    public ArrayList<String> originalSetAside(){
        String ori_set = this.getDriver().findElement(By.id("opportunity-classification-original-set-aside")).getText();
        return splitLabelAndData(ori_set);
    }

    public ArrayList<String> classificationCode(){
        String classi_code = this.getDriver().findElement(By.id("opportunity-classification-classification-code")).getText();
        return splitLabelAndData(classi_code);
    }

    public String naicscode(){
        WebElement naics = this.getDriver().findElement(By.xpath("//*[@id=\"opportunity-classification-naics-code\"]/ul/li"));
        return naics.getText();

    }

    //TODO : Add for Address, city and state
    public ArrayList<String> placeOfPerformance(){
        String pop= this.getDriver().findElement(By.id("opportunity-classification-pop-location")).getText();
        String poplabel = this.getDriver().findElement(By.id("opportunity-classification-pop")).getText();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(poplabel);
        ar.add(pop);
        return ar;

    }

    //Contracting Office
    public ArrayList<String> contractingOffice(){
        ArrayList<String> ar = new ArrayList<String>();
        if (this.getDriver().findElements(By.id("opportunity-contact-contracting-office-street")).size() > 0 )
            ar.add(this.getDriver().findElement(By.id("opportunity-contact-contracting-office-street")).getText());
        else if (this.getDriver().findElements(By.id("opportunity-contact-contracting-office-city")).size() > 0)
            ar.add(this.getDriver().findElement(By.id("opportunity-contact-contracting-office-city")).getText());
        else if (this.getDriver().findElements(By.id("opportunity-contact-contracting-office-state")).size() > 0)
            ar.add(this.getDriver().findElement(By.id("opportunity-contact-contracting-office-state")).getText());
        else if (this.getDriver().findElements(By.id("opportunity-contact-contracting-office-country")).size() > 0)
            ar.add(this.getDriver().findElement(By.id("opportunity-contact-contracting-office-country")).getText());
        else if (this.getDriver().findElements(By.id("opportunity-contact-contracting-office-zip")).size() > 0)
            ar.add(this.getDriver().findElement(By.id("opportunity-contact-contracting-office-zip")).getText());

        return ar;

    }

    //Contact Information
    public ArrayList<String> primaryPointOfContact(){
        String pocfullname= this.getDriver().findElement(By.id("opportunity-contact-primary-poc-full-name")).getText();
        String popemail = this.getDriver().findElement(By.xpath("//*[@id=\"opportunity-contact-primary-poc-email\"]/a")).getText();
        String popphone = this.getDriver().findElement(By.id("opportunity-contact-primary-poc-phone")).getText();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(pocfullname);
        ar.add(popemail);
        ar.add(popphone);
        return ar;

    }


}
