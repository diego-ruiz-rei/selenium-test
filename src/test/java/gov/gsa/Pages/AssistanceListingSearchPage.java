package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils.DataField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by RKumar on 2/28/2017.
 */
public class AssistanceListingSearchPage extends Base{

    // Assistance tag in Search results page
    public static String assistanceTag(){
        return Base.driver.findElement(By.cssSelector(".search-page .usa-label")).getText();
    }

    // Assistance Historical tag in Search results page
    public static String historicalTag(){
        System.out.println("tag : "+Base.driver.findElement(By.cssSelector("assistance-listing-result > p > span:nth-child(2)")).getText());
        return Base.driver.findElement(By.cssSelector("assistance-listing-result > p > span:nth-child(2)")).getText();
    }

    //Pagination count
    public static Integer resultsPageCount(){
        System.out.println("Results page count : "+ Base.driver.findElements(By.cssSelector(".page-button")).size());
        return Base.driver.findElements(By.cssSelector(".page-button")).size();
    }

    // Title
    public static String title() throws InterruptedException {
        Thread.sleep(2000);
        return Base.driver.findElement(By.cssSelector("h3.assistance-listing-title > a")).getText();
    }

    // Description
    public static String description() throws InterruptedException {
        return Base.driver.findElement(By.cssSelector(".m_T-2x")).getText();
    }

    // CFDA Number
    public static DataField cfdaNumber() {
        String cfdaLabel = "";
        String cfdaNumber = "";
        List<WebElement> cfdaElements = Base.driver.findElements(By.cssSelector("assistance-listing-result > ul > li > strong"));
        if(cfdaElements.size() > 0) {
            for (WebElement cfdaElement : cfdaElements) {
                cfdaLabel = cfdaElement.getText();
                cfdaNumber = Base.driver.findElement(By.cssSelector(".fal-program-number")).getText();
            }
            return new DataField("CFDA Number",cfdaLabel,cfdaNumber);
        }
        else
        {
            return new DataField("CFDA Number",null,null);
        }
    }

    //Department
    public static DataField department() {
        String deptLabel = "";
        String deptNumber = "";
        List<WebElement> deptElements = Base.driver.findElements(By.cssSelector("assistance-listing-result > div.usa-width-two-thirds > ul > li:nth-child(1)"));
        if(deptElements.size() > 0) {
            for (WebElement deptElement : deptElements) {
                deptLabel = deptElement.findElement(By.tagName("strong")).getText();
                deptNumber = deptElement.findElement(By.tagName("a")).getText();
            }
            System.out.println("Label : "+deptLabel+"\nData :"+deptNumber);
            return new DataField("Department",deptLabel,deptNumber);
        }
        else
        {
            return new DataField("Department",null,null);
        }
    }

    //Office
    public static DataField office() {
        String label = "";
        String data = "";
        List<WebElement> elements = Base.driver.findElements(By.cssSelector("assistance-listing-result > div.usa-width-two-thirds > ul > li:nth-child(2)"));
        if(elements.size() > 0) {
            for (WebElement element : elements) {
                label = element.findElement(By.tagName("strong")).getText();
                data = element.findElement(By.tagName("span")).getText();
            }
            return new DataField("Office",label,data);
        }
        else
        {
            return new DataField("Office",null,null);
        }
    }

    //Funded
    public static DataField funded() {
        String label = "";
        String data = "";
        List<WebElement> elements = Base.driver.findElements(By.cssSelector("assistance-listing-result > div.usa-width-one-third > ul > li:nth-child(1)"));
        if(elements.size() > 0) {
            for (WebElement element : elements) {
                label = element.findElement(By.tagName("strong")).getText();
                data = element.getText();
                data = data.substring(data.indexOf(':')+1).trim();
            }
            System.out.println("label "+label+"Data "+data);
            return new DataField("Funded",label,data);
        }
        else
        {
            return new DataField("Funded",null,null);
        }
    }

    //Last Date Modified
    public static DataField lastDateModified() {
        String label = "";
        String data = "";
        List<WebElement> elements = Base.driver.findElements(By.cssSelector("assistance-listing-result > div.usa-width-one-third > ul > li:nth-child(2)"));
        if(elements.size() > 0) {
            for (WebElement element : elements) {
                label = element.findElement(By.tagName("strong")).getText();
                data = element.getText();
            }
            return new DataField("Last Date Modified",label,data);
        }
        else
        {
            return new DataField("Last Date Modified",null,null);
        }
    }

    //Type of Assistance
    public static DataField typeOfAssistance() {
        String label = "";
        String data = "";
        List<WebElement> elements = Base.driver.findElements(By.cssSelector("assistance-listing-result > div.usa-width-one-third > ul > li:nth-child(3)"));
        if(elements.size() > 0) {
            for (WebElement element : elements) {
                label = element.findElement(By.tagName("strong")).getText();
                data = element.getText();
                //data = data.substring(data.indexOf(label.length())+1);
            }
            System.out.println("label "+label+"Data "+data);
            return new DataField("Type of Assistance",label,data);
        }
        else
        {
            return new DataField("Type of Assistance",null,null);
        }
    }

    //History Section
    public static Integer historySectionResults() throws InterruptedException {
        Base.driver.findElement(By.cssSelector(".history")).click();
        Thread.sleep(2000);
        System.out.println("Number of elements in History Section :"+Base.driver.findElements(By.cssSelector("#search-results > div:nth-child(1) > assistance-listing-result > div.usa-width-two-thirds > div > div > sam-history > ul > li")).size());
        return Base.driver.findElements(By.cssSelector("sam-history > ul > li")).size();
    }



    public static void clearAll() {
        Base.driver.findElement(By.cssSelector("#search-div > form > div.relative.div-fill > div > sam-autocomplete > div > div > input")).clear();
        Base.driver.findElement(By.cssSelector(".usa-button-primary.usa-search-submit.search-btn")).click();
        Base.driver.findElement(By.xpath("//button[text()='Clear All']")).click();
    }

}
