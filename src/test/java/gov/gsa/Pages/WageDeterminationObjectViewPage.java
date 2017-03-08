package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import gov.gsa.Utilities.CommonUtils.DataField;
import gov.gsa.Utilities.ObjectView;
import gov.gsa.Utilities.CommonUtils.*;
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
 * Created by RKumar on 3/7/2017.
 */
public class WageDeterminationObjectViewPage extends ObjectView{

    public static String wdTitle()
    {
        return Base.driver.findElement(By.tagName("h1")).getText();
    }

    public static String wdType()
    {
        return Base.driver.findElement(By.cssSelector("#wage-determination > p")).getText();
    }

    public static DataField state() {
        String state = Base.driver.findElement(By.id("wd-state-0")).getText();
        return CommonUtils.splitLabelAndData(state).setName("State");
    }

    public static DataField counties() {
        String county = Base.driver.findElement(By.id("wd-counties-0")).getText();
        return CommonUtils.splitLabelAndData(county).setName("Counties");
    }

    public static DataField revision() {
        String revision = Base.driver.findElement(By.id("wd-revision-number")).getText();
        return CommonUtils.splitLabelAndData(revision).setName("Revision");
    }


    public static DataField date() {
        String date = Base.driver.findElement(By.id("wd-date")).getText();
        return CommonUtils.splitLabelAndData(date).setName("Date");
    }

    public static DataField constructionType() {
        String construction = Base.driver.findElement(By.id("wd-construction-types")).getText();
        return CommonUtils.splitLabelAndData(construction).setName("Construction");
    }

    public static DataField services() {
        String service = Base.driver.findElement(By.id("wd-services")).getText();
        return CommonUtils.splitLabelAndData(service).setName("Service");
    }

    public static String wdDocument()
    {
        return Base.driver.findElement(By.id("wd-document")).getText();
    }

    public static String printerFriendlyLink()
    {
        System.out.println("Printer Link Text : "+Base.driver.findElement(By.cssSelector("#wd-print-link > a")).getText());
        return Base.driver.findElement(By.cssSelector("#wd-print-link > a")).getText();
    }
}
