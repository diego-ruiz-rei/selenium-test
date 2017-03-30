package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.GraphObject;
import gov.gsa.Utilities.ObjectView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FACObjectViewPage extends ObjectView {

//    // I'm not sure if this statement is required here
//    public FACObjectViewPage(){
//        super();
//    }

    private  String FACSearchTerm = "93.1";

    public void gotoFACObjectView() throws InterruptedException {
        //driver.get(base_url + "programs/610e64ea171eeff29c952688eaf3c7e4/view");
        System.out.println("Search results page");
        Thread.sleep(1000);
        Base.driver.findElement(By.cssSelector(".search-inputbar")).sendKeys(FACSearchTerm);
        System.out.println("After Search results page");
        //By.name("search"))
        Base.driver.findElement(By.cssSelector(".search-btn")).click();
        Thread.sleep(1000);
        Base.driver.findElement(By.cssSelector(".assistance-listing-title > a")).click();
        Thread.sleep(1000);
        //this.appWait();
    }

    public static Boolean falTitleExists() {
        return Base.driver.findElements(By.tagName("h1")).size() > 0;
    }

    public static ArrayList<String> popularname(){
        ArrayList<String> ar = new ArrayList<String>();
        if (Base.driver.findElements(By.id("program-alternative-names")).size() > 0 ){
            String popularname = Base.driver.findElement(By.id("program-alternative-names")).getText();
            String popularnamedata = popularname.substring(popularname.lastIndexOf(':') + 1).trim();
            ar.add(popularname);
            ar.add(popularnamedata);
            System.out.println();
            return ar;
        }
        else{
            ar.add("Popular Name not available");
            return ar;
        }

    }

    public static ArrayList<String> agencyname(){
        String agencyname = Base.driver.findElement(By.id("program-fh-information")).getText();
        String agencydata = agencyname.substring(agencyname.lastIndexOf(':')+1).trim();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(agencyname);
        ar.add(agencydata);
        return ar;
    }

    public static ArrayList<String> cfdaNumber(){
        String fal = Base.driver.findElement(By.id("program-number")).getText();
        String faldata = fal.substring(fal.lastIndexOf(':')+1).trim();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(fal);
        ar.add(faldata);
        return ar;
    }

    //TODO : Need to add id for Related Assistance   - Not applicable
    public static String relatedAssistance(){
        if(Base.driver.findElements(By.id("program-related-0")).size() > 0){
            return Base.driver.findElement(By.id("program-related-0")).getText();
        }
        else
            return "Not Applicable";
    }

    //Overview Section
    public static String overviewTitle() {
        return Base.driver.findElement(By.id("overview")).getText();
    }

    public static String objectives() {
        return Base.driver.findElement(By.id("program-objective")).getText();
    }

    public static String examplesOfFunded() {
        if (Base.driver.findElements(By.id("program-project-example-na")).size()>0)
            return Base.driver.findElement(By.id("program-project-example-na")).getText();
        else
            return Base.driver.findElement(By.id("program-project-example-0")).getText();
    }

    //Authorizations Section
    public static String authorizationTitle() {
        return Base.driver.findElement(By.id("authorizations")).getText();
    }

    public static String authorization() {
        return Base.driver.findElement(By.id("program-authorization-0")).getText();
    }

    public static String financialTitle() {
        return Base.driver.findElement(By.id("financial-information")).getText();
    }

    public static String rangeAndAverage() {
        return Base.driver.findElement(By.id("program-financial-additional-info")).getText();
    }

    public static String accomplishments() {
        if(Base.driver.findElements(By.cssSelector(".content-block > p")).size() > 0){
            System.out.println(Base.driver.findElement(By.cssSelector(".content-block > p")).getText());
            return Base.driver.findElement(By.cssSelector(".content-block > p")).getText();
        }

        else {
            System.out.println(Base.driver.findElement(By.id("program-accomplishments-actual-0")).getText());
            return Base.driver.findElement(By.id("program-accomplishments-actual-0")).getText();
            /*TODO : getdata for 2015, 2016 and 2017 if exists
            assertThat(true,
                    either(driver.findElement(By.id("program-accomplishments-actual-0")).getText().length()>10 ||
                    driver.findElement(By.id("program-accomplighments-projected-1")).getText().length()>10) ||
                    driver.findElement(By.id("program-accomplighments-projected-2")).getText().length()>10))
            );
            System.out.println("Accomplishments Content is present");*/
        }
    }

    public static String accountIdentification() {
        return Base.driver.findElement(By.id("program-account-identification-0")).getText();
    }

    //Criteria for Applying
    public static String criteriaTitle() {
        return Base.driver.findElement(By.id("criteria-for-applying")).getText();
    }

    public static String typesOfAssistance() {
        return Base.driver.findElement(By.id("program-assistance-type-0")).getText();
    }

    public static String crendentialsDocumentation() {
        return Base.driver.findElement(By.id("program-elegibility-documentation")).getText();
    }

    public static ArrayList<String> applicantEligibility(){
        String designations = Base.driver.findElement(By.cssSelector(".designation > h4")).getText();
        String designationsContent = Base.driver.findElement(By.id("program-applicant-designation-0")).getText();
        String appEli = Base.driver.findElement(By.id("program-applicant-eligibility")).getText();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(designations);
        ar.add(designationsContent);
        ar.add(appEli);
        return ar;
    }

    public static ArrayList<String> beneficiaryEligibility(){
        String designations = Base.driver.findElement(By.cssSelector(".designation > h4")).getText();
        String designationsContent = Base.driver.findElement(By.id("program-beneficiary-designation-0")).getText();
        String beneEli = Base.driver.findElement(By.id("program-beneficiary-eligibility")).getText();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(designations);
        ar.add(designationsContent);
        ar.add(beneEli);
        return ar;
    }

    public static String lengthAndPhasing() {
        return Base.driver.findElement(By.id("program-assistance-lengthtime")).getText();
    }

    public static ArrayList<String> useOfAssistance(){
        String designations = Base.driver.findElement(By.cssSelector(".designation > h4")).getText();
        String designationsContent = Base.driver.findElement(By.id("program-usage-designation-0")).getText();
        String assisEli = Base.driver.findElement(By.id("program-usage-rules")).getText();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(designations);
        ar.add(designationsContent);
        ar.add(assisEli);
        return ar;
    }

    //Applying for Assistance Section
    public static String applyingAssistanceTitle() {
        return Base.driver.findElement(By.id("applying-for-assistance")).getText();
    }

    public static String deadlines() {
        if (Base.driver.findElements(By.id("program-deadline-dates-0")).size() > 0)
            return Base.driver.findElement(By.id("program-deadline-dates-0")).getText();
        else if (Base.driver.findElements(By.id("program-deadline-na")).size() > 0)
            return Base.driver.findElement(By.id("program-deadline-na")).getText();
        else
            return Base.driver.findElement(By.id("program-deadline-contact")).getText();
    }

    public static String preapplication() {
        if (Base.driver.findElements(By.id("program-preapplication-coordination-executive-order")).size()>0)
             return Base.driver.findElement(By.id("program-preapplication-coordination-executive-order")).getText();
        else
            return Base.driver.findElement(By.id("program-preapplication-coordination")).getText();

    }

    public static String applicationProcedures() {
        return Base.driver.findElement(By.id("program-application-procedures-a102")).getText();
    }

    public static String criteriaSelectingProposals() {
        return Base.driver.findElement(By.id("program-selection-criteria")).getText();
    }

    public static String awardProcedure() {
        return Base.driver.findElement(By.id("program-award-procedure")).getText();
    }

    public static String daterange() {
        return Base.driver.findElement(By.id("program-application-approval")).getText();
    }

    public static String renewals() {
        return Base.driver.findElement(By.id("program-application-renewal")).getText();
    }

    public static String appeals() {
        return Base.driver.findElement(By.xpath("//*[@id=\"program-application-appeal-interval\"]/em")).getText();
    }


    //Compliance Requirements Section
    public static String complianceTitle() {
        return Base.driver.findElement(By.id("compliance-requirements")).getText();
    }

    public static String reports() {
        return Base.driver.findElement(By.id("program-postaward-reports-program")).getText();
    }

    public static String audits() {
        return Base.driver.findElement(By.id("program-postaward-audit-a133")).getText();
    }

    public static String records() {
        return Base.driver.findElement(By.id("program-postaward-records")).getText();
    }

    public static String regulations() {
        return Base.driver.findElement(By.id("program-postaward-documents")).getText();
    }

    public static String formulaAndMatching() {
        return Base.driver.findElement(By.id("program-assistance-formula")).getText();
    }

    //Contact Information Section
    public static String contactTitle() {
        return Base.driver.findElement(By.id("contact-information")).getText();
    }

    public static String regionalOrLocal() {
        return Base.driver.findElement(By.id("program-contacts-local")).getText();
    }

    public static String headquarters() {

        return Base.driver.findElement(By.cssSelector(".sam-poc")).getText();
    }

    //History Section
    public static String historyTitle() {
        return Base.driver.findElement(By.id("history")).getText();
    }

    public static String historyContent() {
        return Base.driver.findElement(By.cssSelector(".history-item-0 > span")).getText();
    }


    public static GraphObject obligationsGraph() throws InterruptedException{

        List<WebElement> xaxis = Base.driver.findElements(By.cssSelector(".axis--x .tick"));
        GraphObject gp = new GraphObject();
        gp.setXaxis(xaxis);
        gp.setGraphsize(Base.driver.findElements(By.cssSelector(".axis--x .tick")).size());

        return gp;
    }




    public static List<WebElement> obligationsTabularView() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> obligationTotal = Base.driver.findElements(By.cssSelector(".totals"));
        return obligationTotal;
    }
}
