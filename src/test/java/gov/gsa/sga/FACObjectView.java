package gov.gsa.sga;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;


public class FACObjectView extends ObjectView{
    //Test Data
    //FAL Number - 20.218, 14.248
    protected String FACSearchTerm = "93.155";

    public FACObjectView(){
        super();
    }

    public void gotoFACObjectView() throws InterruptedException {
        //driver.get(base_url + "programs/610e64ea171eeff29c952688eaf3c7e4/view");
        System.out.println("Search results page");
        Thread.sleep(1000);
        this.getDriver().findElement(By.name("search")).sendKeys(FACSearchTerm);
        this.getDriver().findElement(By.cssSelector(".search-btn")).click();
        Thread.sleep(1000);
        this.getDriver().findElement(By.cssSelector(".assistance-listing-title > a")).click();
        Thread.sleep(1000);
        this.appWait();
    }

    public Boolean falTitle() {
        return this.isElementPresent(By.tagName("h1"));
    }

    public ArrayList<String> popularname(){
        ArrayList<String> ar = new ArrayList<String>();
        if (this.getDriver().findElements(By.id("program-alternative-names")).size() > 0 ){
            String popularname = this.getDriver().findElement(By.id("program-alternative-names")).getText();
            String popularnamedata = popularname.substring(popularname.lastIndexOf(':') + 1).trim();
            ar.add(popularname);
            ar.add(popularnamedata);
            return ar;
        }
        else{
            ar.add("Popular Name not available");
            return ar;
        }

    }

    public ArrayList<String> agencyname(){
        String agencyname = this.getDriver().findElement(By.id("program-fh-information")).getText();
        String agencydata = agencyname.substring(agencyname.lastIndexOf(':')+1).trim();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(agencyname);
        ar.add(agencydata);
        return ar;
    }

    public ArrayList<String> falNumber(){
        String fal = this.getDriver().findElement(By.id("program-number")).getText();
        String faldata = fal.substring(fal.lastIndexOf(':')+1).trim();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(fal);
        ar.add(faldata);
        return ar;
    }

    //TODO : Need to add id for Related Assistance   - Not applicable
    public String relatedAssistance(){
        if(this.getDriver().findElements(By.id("program-related-0")).size() > 0){
            return this.getDriver().findElement(By.id("program-related-0")).getText();
        }
        else
            return "Not Applicable";
    }

    //Overview Section
    public String overviewTitle() {
        return this.getDriver().findElement(By.id("overview")).getText();
    }

    public String objectives() {
        return this.getDriver().findElement(By.id("program-objective")).getText();
    }

    public String examplesOfFunded() {
        if (this.getDriver().findElements(By.id("program-project-example-na")).size()>0)
            return this.getDriver().findElement(By.id("program-project-example-na")).getText();
        else
            return this.getDriver().findElement(By.id("program-project-example-0")).getText();
    }

    //Authorizations Section
    public String authorizationTitle() {
        return this.getDriver().findElement(By.id("authorizations")).getText();
    }

    public String authorization() {
        return this.getDriver().findElement(By.id("program-authorization-0")).getText();
    }

    public String financialTitle() {
        return this.getDriver().findElement(By.id("financial-information")).getText();
    }

    public String rangeAndAverage() {
        return this.getDriver().findElement(By.id("program-financial-additional-info")).getText();
    }

    public String accomplishments() {
        if(this.getDriver().findElements(By.cssSelector(".content-block > p")).size() > 0)
            return this.getDriver().findElement(By.cssSelector(".content-block > p")).getText();
        else
            return this.getDriver().findElement(By.id("program-accomplishments-actual-0")).getText();
            /*TODO : getdata for 2015, 2016 and 2017 if exists
            assertThat(true,
                    either(driver.findElement(By.id("program-accomplishments-actual-0")).getText().length()>10 ||
                    driver.findElement(By.id("program-accomplighments-projected-1")).getText().length()>10) ||
                    driver.findElement(By.id("program-accomplighments-projected-2")).getText().length()>10))
            );
            System.out.println("Accomplishments Content is present");*/
    }

    public String accountIdentification() {
        return this.getDriver().findElement(By.id("program-account-identification-0")).getText();
    }

    //Criteria for Applying
    public String criteriaTitle() {
        return this.getDriver().findElement(By.id("criteria-for-applying")).getText();
    }

    public String typesOfAssistance() {
        return this.getDriver().findElement(By.id("program-assistance-type-0")).getText();
    }

    public String crendentialsDocumentation() {
        return this.getDriver().findElement(By.id("program-elegibility-documentation")).getText();
    }

    public ArrayList<String> applicantEligibility(){
        String designations = this.getDriver().findElement(By.cssSelector(".designation > h4")).getText();
        String designationsContent = this.getDriver().findElement(By.id("program-applicant-designation-0")).getText();
        String appEli = this.getDriver().findElement(By.id("program-applicant-eligibility")).getText();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(designations);
        ar.add(designationsContent);
        ar.add(appEli);
        return ar;
    }

    public ArrayList<String> beneficiaryEligibility(){
        String designations = this.getDriver().findElement(By.cssSelector(".designation > h4")).getText();
        String designationsContent = this.getDriver().findElement(By.id("program-beneficiary-designation-0")).getText();
        String beneEli = this.getDriver().findElement(By.id("program-beneficiary-eligibility")).getText();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(designations);
        ar.add(designationsContent);
        ar.add(beneEli);
        return ar;
    }

    public String lengthAndPhasing() {
        return this.getDriver().findElement(By.id("program-assistance-lengthtime")).getText();
    }

    public ArrayList<String> useOfAssistance(){
        String designations = this.getDriver().findElement(By.cssSelector(".designation > h4")).getText();
        String designationsContent = this.getDriver().findElement(By.id("program-usage-designation-0")).getText();
        String assisEli = this.getDriver().findElement(By.id("program-usage-rules")).getText();
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(designations);
        ar.add(designationsContent);
        ar.add(assisEli);
        return ar;
    }

    //Applying for Assistance Section
    public String applyingAssistanceTitle() {
        return this.getDriver().findElement(By.id("applying-for-assistance")).getText();
    }

    public String deadlines() {
        if (this.getDriver().findElements(By.id("program-deadline-dates-0")).size() > 0)
            return this.getDriver().findElement(By.id("program-deadline-dates-0")).getText();
        else if (this.getDriver().findElements(By.id("program-deadline-na")).size() > 0)
            return this.getDriver().findElement(By.id("program-deadline-na")).getText();
        else
            return this.getDriver().findElement(By.id("program-deadline-contact")).getText();
    }

    public String preapplication() {
        if (this.getDriver().findElements(By.id("program-preapplication-coordination-executive-order")).size()>0)
             return this.getDriver().findElement(By.id("program-preapplication-coordination-executive-order")).getText();
        else
            return this.getDriver().findElement(By.id("program-preapplication-coordination")).getText();

    }

    public String applicationProcedures() {
        return this.getDriver().findElement(By.id("program-application-procedures-a102")).getText();
    }

    public String criteriaSelectingProposals() {
        return this.getDriver().findElement(By.id("program-selection-criteria")).getText();
    }

    public String awardProcedure() {
        return this.getDriver().findElement(By.id("program-award-procedure")).getText();
    }

    public String daterange() {
        return this.getDriver().findElement(By.id("program-application-approval")).getText();
    }

    public String renewals() {
        return this.getDriver().findElement(By.id("program-application-renewal")).getText();
    }

    public String appeals() {
        return this.getDriver().findElement(By.xpath("//*[@id=\"program-application-appeal-interval\"]/em")).getText();
    }


    //Compliance Requirements Section
    public String complianceTitle() {
        return this.getDriver().findElement(By.id("compliance-requirements")).getText();
    }

    public String reports() {
        return this.getDriver().findElement(By.id("program-postaward-reports-program")).getText();
    }

    public String audits() {
        return this.getDriver().findElement(By.id("program-postaward-audit-a133")).getText();
    }

    public String records() {
        return this.getDriver().findElement(By.id("program-postaward-records")).getText();
    }

    public String regulations() {
        return this.getDriver().findElement(By.id("program-postaward-documents")).getText();
    }

    public String formulaAndMatching() {
        return this.getDriver().findElement(By.id("program-assistance-formula")).getText();
    }

    //Contact Information Section
    public String contactTitle() {
        return this.getDriver().findElement(By.id("contact-information")).getText();
    }

    public String regionalOrLocal() {
        return this.getDriver().findElement(By.id("program-contacts-local")).getText();
    }

    public String headquarters() {

        return this.getDriver().findElement(By.cssSelector(".sam-address")).getText();
    }

    //History Section
    public String historyTitle() {
        return this.getDriver().findElement(By.id("history")).getText();
    }

    public String historyContent() {
        return this.getDriver().findElement(By.id("program-historical-details-0")).getText();
    }


    public GraphObject obligationsGraph() throws InterruptedException{

        List<WebElement> xaxis = driver.findElements(By.cssSelector(".axis--x .tick"));
        GraphObject gp = new GraphObject();
        gp.setXaxis(xaxis);
        gp.setGraphsize(this.driver.findElements(By.cssSelector(".axis--x .tick")).size());

        return gp;
    }

    public class GraphObject{
        int graphsize;
        List<WebElement> xaxis;

        public List<WebElement> getXaxis() {
            return xaxis;
        }

        public int getGraphsize() {
            return graphsize;
        }

        public void setXaxis(List<WebElement> xaxis) {
            this.xaxis = xaxis;
        }

        public void setGraphsize(int graphsize) {
            this.graphsize = graphsize;
        }

    }


    public List<WebElement> obligationsTabularView() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> obligationTotal = this.getDriver().findElements(By.cssSelector(".totals"));
        return obligationTotal;
    }
}
