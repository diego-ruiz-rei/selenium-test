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

/**
 * Created by RKumar on 2/21/2017.
 */
public class FederalHierarchyObjectViewPage extends ObjectView{

    public static Boolean fhTitle() {
        System.out.println( Base.driver.findElement(By.tagName("h1")).getText());
        return Base.driver.findElements(By.tagName("h1")).size() > 0;
    }

    public static DataField fpdsOrgID() {
        String fpdsorgid = Base.driver.findElement(By.cssSelector(".intro-section >  section:nth-child(2)")).getText();
        String fpdsorgid_label = fpdsorgid.substring(0,fpdsorgid.indexOf(':')).trim();
        String fpdsorgid_data = fpdsorgid.substring(fpdsorgid.indexOf(':') + 1 ,fpdsorgid.indexOf('|')).trim();
        System.out.println("FPDS Org ID Label : "+fpdsorgid_label+"\nData : "+fpdsorgid_data);
        return new DataField("FPDS Org ID",fpdsorgid_label,fpdsorgid_data);
    }

    public static DataField status() {
        String fpdsorgid = Base.driver.findElement(By.cssSelector(".intro-section >  section:nth-child(2)")).getText();
        String status = fpdsorgid.substring(fpdsorgid.indexOf('|') + 1).trim();
        System.out.println("Status : "+status);
        return new DataField("FPDS Org ID",status,null);
    }

    public static Boolean description() {
    //    System.out.println( Base.driver.findElement(By.id("orgDescription")).getText());
        return Base.driver.findElements(By.id("orgDescription")).size() > 0;
    }

    public static String subTierAgencyOrOfficeSection() {
        System.out.println( Base.driver.findElement(By.tagName("h2")).getText());
        return Base.driver.findElement(By.tagName("h2")).getText();
    }

    public static String noOfResults() {
        System.out.println(Base.driver.findElement(By.cssSelector(".m_T-2x > Strong")).getText().trim());
        return Base.driver.findElement(By.cssSelector(".m_T-2x > Strong")).getText();
    }

    public static boolean listOfSubTier() {
        System.out.println( Base.driver.findElements(By.cssSelector(".usa-zebra-list > li")).size());
        return Base.driver.findElements(By.cssSelector(".usa-zebra-list > li")).size()>1;
    }

    public static boolean pagination() {
        System.out.println( Base.driver.findElements(By.cssSelector(".page-button")).size());
        return Base.driver.findElements(By.cssSelector(".page-button")).size()>1;
    }

    public static void agencyDrillDown(String agency) throws InterruptedException {
        System.out.println(Base.driver.findElement(By.cssSelector("sampagination > nav > ul > li:nth-child(6) > a")).getText());
        Base.driver.findElement(By.cssSelector("sampagination > nav > ul > li:nth-child(6) > a")).click();
        WebElement element = (WebElement) Base.wait.until(
                ExpectedConditions.elementToBeClickable(By.linkText(agency)));
        Base.driver.findElement(By.linkText(agency)).click();
        Thread.sleep(2000);
    //    WebElement agencypageelement = (WebElement) Base.wait.until(
    //            ExpectedConditions.textToBePresentInElement(By.cssSelector(".intro-section >  section:nth-child(3)"),"DEPARTMENT"));

        System.out.println(Base.driver.findElement(By.tagName("h1")).getText());
    }

    public static DataField departmentLinkInAgencyObjectView() {
        String department = Base.driver.findElement(By.cssSelector(".intro-section >  section:nth-child(3)")).getText();
        String department_label = department.substring(0,department.indexOf(':')).trim();
        String department_data = department.substring(department.indexOf(':') + 1 ).trim();
        System.out.println("Department label "+department_label+"\nData : "+department_data);
        return new DataField("DEPARTMENT",department_label,department_data);
    }

}
