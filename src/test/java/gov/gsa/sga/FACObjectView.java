package gov.gsa.sga;

import org.apache.xerces.impl.xs.identity.Selector;
import org.apache.xpath.operations.Or;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.seleniumemulation.IsTextPresent;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import java.util.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;


public class FACObjectView extends ObjectView{

    //Test Data
    //FAL Number - 20.218
    protected String FACSearchTerm = "20.218";
    //protected String FACSearchTerm = "Foreign-Trade Zones in the United States";

    //Search term , type
    protected String[] obligation_type = {"Motor Carrier Safety Assistance","Salary"};

    public FACObjectView(){
        super();
    }

    public void gotoFACObjectView() throws InterruptedException {
        System.out.println("Search results page");
        //this.getDriver().findElement(By.name("search")).clear();
        this.getDriver().findElement(By.name("search")).sendKeys(FACSearchTerm);
        this.getDriver().findElement(By.cssSelector(".search-btn")).click();
        Thread.sleep(2000);

        System.out.println(driver.findElement(By.cssSelector(".assistance-listing-title")).getText());
        driver.findElement(By.cssSelector(".assistance-listing-title > a")).click();
        //this.getDriver().findElement(By.linkText(FACSearchTerm)).click();
        Thread.sleep(2000);
        this.appWait();
    }

    public void FACHeader(){
        System.out.println("\n--FAC Header Test--");

        assertTrue("FAC Title is not found",isElementPresent(By.tagName("h1")));
        //assertEquals(FACSearchTerm,this.getDriver().findElement(By.tagName("h1")).getText());
        System.out.println("FAC Object View title match with Search Term "+driver.findElement(By.tagName("h1")).getText());

        //TODO : add case for FALs that don't have popular name
        String popularname = driver.findElement(By.id("program-alternative-names")).getText();
        assertTrue(popularname.contains("Popular Name:"));
        String popularnamedata = popularname.substring(popularname.lastIndexOf(':')+1).trim();
        assertTrue("Popular Name is empty",popularnamedata != "");
        //assertTrue(this.getDriver().getPageSource().contains(popularnamedata));
        System.out.println(popularname+"\nPopular Name Title and Data exists!!");

        String agencyname = driver.findElement(By.id("program-fh-information")).getText();
        assertTrue(agencyname.contains("AGENCY:"));
        String agencydata = agencyname.substring(agencyname.lastIndexOf(':')+1).trim();
        assertTrue(agencyname.contains(agencydata));
        assertTrue("Agency Name is empty",agencydata != "");
        System.out.println(agencyname+"\nAgency Name Title and Data exists!!");

        String fal = driver.findElement(By.id("program-number")).getText();
        assertTrue(fal.contains("FAL Number:"));
        String faldata = fal.substring(fal.lastIndexOf(':')+1).trim();
        assertTrue(fal.contains(faldata));
        assertTrue("FAL Number is empty",faldata != "");
        System.out.println(fal+"\nFAL Number Title and Data exists!!");

        /*TODO : Need to cover all scenarios with Related Assistance
        String relatedassistance = driver.findElement(By.id("")).getText();
        assertTrue(relatedassistance.contains("Related Federal Assistance:"));
        assertTrue(isElementPresent(By.id("program-related-na")));
        System.out.println(relatedassistance+"\nRelated Assistance Title and Data exists!!");
        */

    }

    public void FACObjectViewSections() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("All Other Object View Page Content Verification");

        //Overview Section
        assertEquals("Overview title is not present","Overview", driver.findElement(By.id("overview")).getText());
        System.out.println("\n--Overview Section is Present--");

        assertEquals("Objectives title is not present","Objectives:", driver.findElement(By.tagName("h3")).getText());
        assertTrue("Objectives Content is not present",driver.findElement(By.id("program-objective")).getText().length()>10);
        System.out.println("Objectives Label and content is Present");

        //assertEquals("Examples of Funded Project title is not present","Examples of Funded Project:", driver.findElement(By.tagName("h3")).getText());
        assertTrue("Examples of Funded Project Content is not present",driver.findElement(By.id("program-project-example-0")).getText().length()>10);
        System.out.println("Examples of Funded Project Label and content is Present");


        //Authorization Section
        assertEquals("Authorization title is not present","Authorizations", driver.findElement(By.id("authorizations")).getText());
        System.out.println("\n--Authorization Section is Present--");

        assertTrue("Authorizations Content is not present",driver.findElement(By.id("program-authorization-0")).getText().length()>10);
        System.out.println("Authorizations Content is Present");


        //Financial Information Section
        assertEquals("Financial Information title is not present","Financial Information", driver.findElement(By.id("financial-information")).getText());
        System.out.println("\n--Financial Information Section is Present--");

        assertTrue("Range and Average of Financial Assistance Content is not present",driver.findElement(By.id("program-financial-additional-info")).getText().length()>10);
        System.out.println("Range and Average of Financial Assistance Content is Present");

        /*TODO : Logic for Accomplishments
        if(isElementPresent(By.cssSelector(".content-block > p"))){
            assertEquals("Accomplishments Content is not present","Not Applicable.",driver.findElement(By.cssSelector(".content-block > p")).getText());
            System.out.println("Accomplishments Content is \"Not Applicable\"");
        }
        else if(isElementPresent(By.cssSelector(".content-block > span"))){
          /*  assertThat(true,
                    either(driver.findElement(By.id("program-accomplishments-actual-0")).getText().length()>10 ||
                    driver.findElement(By.id("program-accomplighments-projected-1")).getText().length()>10) ||
                    driver.findElement(By.id("program-accomplighments-projected-2")).getText().length()>10))
            );
            System.out.println("Accomplishments Content is present");

        }
        */


        assertTrue("Account Identification Content is not present",driver.findElement(By.id("program-account-identification-0")).getText().length()>10);
        System.out.println("Account Identification Content is Present");

        //Criteria for Applying
        assertEquals("Criteria for Applying is not present","Criteria for Applying", driver.findElement(By.id("criteria-for-applying")).getText());
        System.out.println("\n--Criteria for Applying Section is Present--");

        assertTrue("Type of Assistance Content is not present",driver.findElement(By.id("program-assistance-type-0")).getText().length()>10);
        System.out.println("Type of Assistance Content is Present");

        assertTrue("Credentials and Documentation Content is not present",driver.findElement(By.id("program-elegibility-documentation")).getText().length()>10);
        System.out.println("Credentials and Documentation Content is Present");

        assertEquals("Applicant Eligibility - Designation Title is not present","Designations",driver.findElement(By.cssSelector(".designation > h4")).getText());
        assertTrue("Applicant Eligibility - Designation Content is not present",driver.findElement(By.id("program-applicant-designation-0")).getText().length()>10);
        assertTrue("Applicant Eligibility Content is not present",driver.findElement(By.id("program-applicant-eligibility")).getText().length()>10);
        System.out.println("Applicant Eligibility Content is Present");

        assertEquals("Beneficiary Eligibility - Designation Title is not present","Designations",driver.findElement(By.cssSelector(".designation > h4")).getText());
        assertTrue("Beneficiary Eligibility - Designation Content is not present",driver.findElement(By.id("program-beneficiary-designation-0")).getText().length()>10);
        assertTrue("Beneficiary Eligibility Content is not present",driver.findElement(By.id("program-beneficiary-eligibility")).getText().length()>10);
        System.out.println("Beneficiary Eligibility Content is Present");

        assertTrue("Length and Time Phasing of Assistance Content is not present",driver.findElement(By.id("program-assistance-lengthtime")).getText().length()>10);
        System.out.println("Length and Time Phasing of Assistance Content is Present");

        assertEquals("Use of Assistance Eligibility - Designation Title is not present","Designations",driver.findElement(By.cssSelector(".designation > h4")).getText());
        assertTrue("Use of Assistance Eligibility - Designation Content is not present",driver.findElement(By.id("program-usage-designation-0")).getText().length()>10);
        assertTrue("Use of Assistance Content is not present",driver.findElement(By.id("program-usage-rules")).getText().length()>10);
        System.out.println("Use of Assistance Content is Present");


        //Applying for Assistance Section
        assertEquals("Applying for Assistance Section is not present","Applying for Assistance", driver.findElement(By.id("applying-for-assistance")).getText());
        System.out.println("\n--Applying for Assistance Section is Present--");

        assertTrue("Deadlines Content is not present",driver.findElement(By.id("program-deadline-dates-0")).getText().length()>10);
        System.out.println("Deadlines Content is Present");

        assertTrue("Preapplication Procedures Content is not present",driver.findElement(By.id("program-preapplication-coordination")).getText().length()>10);
        System.out.println("Preapplication Procedures Content is Present");

        assertTrue("Application Procedures Content is not present",driver.findElement(By.id("program-application-procedures-a102")).getText().length()>10);
        System.out.println("Application Procedures Content is Present");

        assertTrue("Criteria for Selecting Proposals Content is not present",driver.findElement(By.id("program-selection-criteria")).getText().length()>10);
        System.out.println("Criteria for Selecting Proposals Content is Present");

        assertTrue("Award Procedure Content is not present",driver.findElement(By.id("program-award-procedure")).getText().length()>10);
        System.out.println("Award Procedure Content is Present");

        assertTrue("Date Range for Approval/Disapproval Content is not present",driver.findElement(By.id("program-application-approval")).getText().length()>10);
        System.out.println("Date Range for Approval/Disapproval Content is Present");

        assertTrue("Renewals Content is not present",driver.findElement(By.id("program-application-renewal")).getText().length()>10);
        System.out.println("Renewals Content is Present");

        assertTrue("Appeals Content is not present",driver.findElement(By.id("program-application-appeal")).getText().length()>10);
        System.out.println("Appeals Content is Present");







      // assertEquals("Designations", driver.findElement(By.cssSelector("h4")).getText());
      // assertTrue(isElementPresent(By.cssSelector("#historyItem > p")));
    }

    public void obligationsGraph() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("\n--Obligations Graph--");
        //System.out.println("****"+driver.findElement(By.cssSelector("rect")).getText());
        assertEquals("", driver.findElement(By.cssSelector("rect")).getText());
        //System.out.println(driver.findElements(By.cssSelector(".axis--x .tick")).size());
        assertTrue(driver.findElements(By.cssSelector(".axis--x .tick")).size() == 3);

        List<WebElement> xaxis = driver.findElements(By.cssSelector(".axis--x .tick"));
        Iterator<WebElement> itr = xaxis.iterator();
        while (itr.hasNext())
        {
            String xaxis_value = itr.next().getText();
            if (xaxis_value.equals("FY 15"))
                System.out.println("FY 15 Present");
            else if (xaxis_value.equals("FY 16 (est.)"))
                System.out.println("FY 16 Present");
            else if (xaxis_value.equals("FY 17 (est.)"))
                System.out.println("FY 17 Present");
            else
                System.out.println("No x-axis is present");
        }
    }




    public void obligationsTabularView() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("--Obligations Tabular View--");
        if (obligation_type[1]== "Salary") {
            System.out.println("****"+driver.findElement(By.id("chart-table")).getText() );
            assertTrue(driver.findElement(By.id("chart-table")).getText().contains("Salary or Expense"));
            //System.out.println(driver.findElements(By.cssSelector(".axis--x .tick")).size());
            //assertTrue(driver.findElements(By.cssSelector(".axis--x .tick")).size() == 3);
        }

    }

}
