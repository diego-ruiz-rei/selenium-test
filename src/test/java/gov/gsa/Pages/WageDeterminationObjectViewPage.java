package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import gov.gsa.Utilities.CommonUtils.DataField;
import gov.gsa.Utilities.ObjectView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
        return Base.driver.findElement(By.cssSelector("#wd-type")).getText();
    }

    public static DataField state() throws InterruptedException {
        Thread.sleep(2000);
        String label = Base.driver.findElement(By.cssSelector("#wd-state-0 > .sam-ui.medium.header")).getText();
        String data = Base.driver.findElement(By.cssSelector("#wd-state-0 > div > div")).getText();
        System.out.println("State : "+label+"\nData : "+data);
        return new DataField("State",label,data);
    }

    public static DataField counties() {
        String label = Base.driver.findElement(By.cssSelector("#wd-counties-0 > div")).getText();
        String data = Base.driver.findElement(By.cssSelector("#wd-counties-0 > div > div")).getText();
        System.out.println("Counties : "+label+"\nData : "+data);
        return new DataField("Counties",label,data);
    }

    //TODO : Need to add unique classname/id for Multiple states
    public static Integer multipleStateCountiesCount() {
        System.out.println("Count of State and Counties : "+ Base.driver.findElements(By.cssSelector(".m_B-3x")).size());
        return Base.driver.findElements(By.cssSelector(".m_B-3x")).size();

    }

    public static DataField revision() {
        String label = Base.driver.findElement(By.cssSelector("#wd-revision-number > div > div.header")).getText();
        String data = Base.driver.findElement(By.cssSelector("#wd-revision-number > div > div.description")).getText();
        System.out.println("Revision : "+label+"\nData : "+data);
        return new DataField("Revision",label,data);
    }


    public static DataField date() {
        String label = Base.driver.findElement(By.cssSelector("#wd-date > div > div.header")).getText();
        String data = Base.driver.findElement(By.cssSelector("#wd-date > div > div.description")).getText();
        System.out.println("Date : "+label+"\nData : "+data);
        return new DataField("Date",label,data);
    }

    public static DataField constructionType() {
        String label = Base.driver.findElement(By.cssSelector("#wd-construction-types > div > div.header")).getText();
        String data = Base.driver.findElement(By.cssSelector("#wd-construction-types > div > div.description")).getText();
        System.out.println("Construction : "+label+"\nData : "+data);
        return new DataField("Construction",label,data);
    }

    public static DataField services() throws InterruptedException {
        Thread.sleep(2000);
        String label = Base.driver.findElement(By.cssSelector("#wd-services > div > div.header")).getText();
        String data = Base.driver.findElement(By.cssSelector("#wd-services > div > div.description")).getText();
        System.out.println("Services : "+label+"\nData : "+data);
        return new DataField("Services",label,data);
    }

    public static String wdDocument()
    {
        return Base.driver.findElement(By.id("wd-document")).getText();
    }

    public static String printerFriendlyLink()
    {
        System.out.println("Printer Link Text : "+Base.driver.findElement(By.cssSelector("#wd-print-link > div > a")).getText());
        return Base.driver.findElement(By.cssSelector("#wd-print-link > div > a")).getText();
    }

    public static int printerFriendlyStatusCode() throws InterruptedException, MalformedURLException,IOException {
        int code = 0;
        try {

            Thread.sleep(1000);
            String link = Base.driver.findElement(By.id("wd-print-link")).findElement(By.tagName("a")).getAttribute("href");
            System.out.println("Link: " + link);
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            //connection.setHostnameVerifier ((hostname, session) -> true);
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

    public static String getHistoryRevisionNumberFromHistory(){
        String latestRevision = Base.driver.findElement(By.cssSelector("#wd-history > sam-history > ul > li.current > span > a")).getText();
        return latestRevision.substring(latestRevision.lastIndexOf(" ")+1);
    }

    public static String getHistoryRevisionNumber(){
        return Base.driver.findElement(By.cssSelector("#wd-revision-number > div > div.description")).getText();
        //return latestRevision.substring(latestRevision.lastIndexOf(" ")+1);
    }

    public static String getHistoryRevisionDateFromHistory(){
        String latestRevision = Base.driver.findElement(By.cssSelector("#wd-history > sam-history > ul > li.current > span")).getText();
        String date = latestRevision.substring(0, latestRevision.indexOf("\n"));
        return latestRevision.substring(0, 3) + date.substring(date.indexOf(' '));
    }

    public static String getHistoryRevisionDate(){
        return Base.driver.findElement(By.cssSelector("#wd-date > div > div.description")).getText();
        //String s = latestRevision.substring(latestRevision.indexOf(":")+2);
        //return latestRevision.substring(latestRevision.indexOf(":")+2);

    }

    public static void getHistoryRevision(String revisionTitle){
        List<WebElement> revisions= Base.driver.findElements(By.cssSelector("#wd-history > sam-history > ul > li"));
        for (WebElement revision : revisions) {
            WebElement link = revision.findElement(By.cssSelector("span > a"));
            String currentRevision = link.getText();
            String requestedRevision = revisionTitle;
            if((link.getText()).contains(revisionTitle)){
                if(revision.getAttribute("class").contains("current"))
                    break;
                else {
                    link.click();
                    break;
                }
            }
        }
    }

    public static void showMoreHistory() throws InterruptedException{
        Base.driver.findElement(By.id("defaultBtnHistory")).click();
        Thread.sleep(2000);
    }

    public static int getTotalHistoryRevisions(){
        List<WebElement> revisions= Base.driver.findElements(By.cssSelector("#wd-history > sam-history > ul > li"));
        return revisions.size();
    }
}
