package gov.gsa.Pages;

import gov.gsa.Utilities.Base;
import gov.gsa.Utilities.CommonUtils;
import gov.gsa.Utilities.CommonUtils.DataField;
import gov.gsa.Utilities.ObjectView;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by RKumar on 4/24/2017.
 */


public class OpportunitiesAwardsTabObjectViewPage extends ObjectView{

    public static String awardsSummaryTitle() throws InterruptedException {
       return Base.driver.findElement(By.cssSelector("#opportunity-award-summary > h2")).getText();
    }

    public static DataField totalNumberOfAwards() throws InterruptedException {
        String css_selector = "#opportunity-award-summary > div.usa-grid-full > div.usa-width-three-fourths > div > div > div:nth-child(1) > div > div:nth-child(1)";
        String data_css_selector = "#opportunity-award-summary > div.usa-grid-full > div.usa-width-three-fourths > div > div > div:nth-child(1) > div > div:nth-child(2)";
        //*[@id="opportunity-award-summary"]/div[1]/div[1]/div/div/div[1]/div/div[1]

        String label = Base.driver.findElement(By.cssSelector(css_selector)).getText();
        String data = Base.driver.findElement(By.cssSelector(data_css_selector)).getText();
        return new DataField("Total Number of Awards",label,data);
    }

    public static DataField totalAmountAwarded() throws InterruptedException {
        String label = Base.driver.findElement(By.cssSelector("#opportunity-award-summary > div.usa-grid-full.usa-text-center > div:nth-child(2) > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("#opportunity-award-summary > div.usa-grid-full.usa-text-center > div:nth-child(2) > p")).getText();
        return new DataField("Total Amount Awarded",label,data);
    }

    public static DataField totalNumberOfRecipients() throws InterruptedException {
        String label = Base.driver.findElement(By.cssSelector("#opportunity-award-summary > div.usa-grid-full.usa-text-center > div:nth-child(3) > strong")).getText();
        String data = Base.driver.findElement(By.cssSelector("#opportunity-award-summary > div.usa-grid-full.usa-text-center > div:nth-child(3) > p")).getText();
        return new DataField("Total Number of Recipients",label,data);
    }

    public static String numberOfResults() throws InterruptedException {
        return Base.driver.findElement(By.cssSelector("#opportunity-award-summary > p > strong:nth-child(3)")).getText();
    }

    public static Integer listOfRecords() throws InterruptedException {
        System.out.println("Number of results : "+Base.driver.findElements(By.cssSelector("#awards-list > .sam-ui")).size());
        return Base.driver.findElements(By.cssSelector("#awards-list > .sam-ui")).size();
    }

    public static Boolean sortByCompany() throws InterruptedException {

        List<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList= driver.findElements(By.cssSelector("#awards-list > .card-simple > h3"));
        for(WebElement we:elementList){
            obtainedList.add(we.getText());
        }
        Base.driver.findElement(By.cssSelector(".page-next")).click();
        Thread.sleep(2000);
        List<WebElement> elementList2= driver.findElements(By.cssSelector("#awards-list > .card-simple > h3"));
        for(WebElement we1:elementList2){
            obtainedList.add(we1.getText());
        }
        System.out.println("Get list"+obtainedList);

        Collections.sort(obtainedList);
        System.out.println("Sorted list"+obtainedList);

        new Select(Base.driver.findElement(By.id("awardDate"))).selectByVisibleText("Company (Awardee) Name");
        Thread.sleep(2000);

        //After Sort
        List<String> listAfterSort = new ArrayList<>();
        List<WebElement> elementList3= driver.findElements(By.cssSelector("#awards-list > .card-simple > h3"));
        for(WebElement we:elementList3){
            listAfterSort.add(we.getText());
        }
        Base.driver.findElement(By.cssSelector(".page-next")).click();
        Thread.sleep(2000);
        List<WebElement> elementList4= driver.findElements(By.cssSelector("#awards-list > .card-simple > h3"));
        for(WebElement we1:elementList4){
            listAfterSort.add(we1.getText());
        }
        System.out.println("List after Sort"+listAfterSort);
        return obtainedList.containsAll(listAfterSort);
    }

    public static Boolean sortByDollarAmount() throws InterruptedException {

        new Select(Base.driver.findElement(By.id("awardeeName"))).selectByVisibleText("Dollar Amount");
        Thread.sleep(2000);
        String first_amount = Base.driver.findElement(By.cssSelector("#awards-list > div:nth-child(1) > div > div:nth-child(2) > ul > li:nth-child(1)")).getText().replaceAll("\n"," ");
        String second_amount = Base.driver.findElement(By.cssSelector("#awards-list > div:nth-child(2) > div > div:nth-child(2) > ul > li:nth-child(1)")).getText().replaceAll("\n"," ");

        double first_dollar_amount = Double.parseDouble(first_amount.substring(first_amount.lastIndexOf(" ")+1));
        double second_dollar_amount = Double.parseDouble(second_amount.substring(second_amount.lastIndexOf(" ")+1));

        System.out.println("First Amount "+first_dollar_amount+"\nSecond Amount "+second_dollar_amount);

        return (first_dollar_amount > second_dollar_amount);
    }

    public static List<DataField> contractorAwardedDUNS() throws InterruptedException {
        List<DataField> duns_list = new ArrayList<DataField>();
        List<WebElement> elementList= driver.findElements(By.cssSelector("#awards-list > .card-simple > .card-simple-content > .usa-grid-full > div:nth-child(1)"));
        for(WebElement we:elementList){
            String label = we.findElement(By.cssSelector("ul > li:nth-child(1) > span:nth-child(1)")).getText();
            String data = we.findElement(By.cssSelector("ul > li:nth-child(1) > span:nth-child(2)")).getText();
        //    System.out.println("Label - " + label + " Data - " + data);
            duns_list.add(new DataField("Contractor Awarded DUNS", label, data));
        }
        return duns_list;
    }

    public static List<DataField> contractorAwardDollarAmount() throws InterruptedException {
        List<DataField> dollar_amount = new ArrayList<DataField>();
        List<WebElement> elementList= driver.findElements(By.cssSelector("#awards-list > .card-simple > .card-simple-content > .usa-grid-full > div:nth-child(2)"));
        for(WebElement we:elementList){
            String label = we.findElement(By.cssSelector("ul > li:nth-child(1) > span:nth-child(1)")).getText();
            String data = we.findElement(By.cssSelector("ul > li:nth-child(1) > span:nth-child(2)")).getText();
        //    System.out.println("Label - " + label + " Data - " + data);
            dollar_amount.add(new DataField("Contract Award Dollar Amount", label, data));
        }
        return dollar_amount;
    }

    public static List<DataField> contractorAwardedAddress() throws InterruptedException {
        List<DataField> address = new ArrayList<DataField>();
        List<WebElement> elementList= driver.findElements(By.cssSelector("#awards-list > .card-simple > .card-simple-content > .usa-grid-full > div:nth-child(1)"));
        for(WebElement we:elementList){
            String label = we.findElement(By.cssSelector("ul > li:nth-child(2) > span:nth-child(1)")).getText();
            String data = we.findElement(By.cssSelector("ul > li:nth-child(2) > span:nth-child(2)")).getText();
        //    System.out.println("Label - " + label + " Data - " + data);
            address.add(new DataField("Contractor Awarded Address", label, data));
        }
        return address;
    }

    public static List<DataField> contractAwardNumber() throws InterruptedException {
        List<DataField> number = new ArrayList<DataField>();
        List<WebElement> elementList= driver.findElements(By.cssSelector("#awards-list > .card-simple > .card-simple-content > .usa-grid-full > div:nth-child(2)"));
        for(WebElement we:elementList){
            String label = we.findElement(By.cssSelector("ul > li:nth-child(2) > span:nth-child(1)")).getText();
            String data = we.findElement(By.cssSelector("ul > li:nth-child(2) > span:nth-child(2)")).getText();
        //    System.out.println("Label - " + label + " Data - " + data);
            number.add(new DataField("Contract Award Number", label, data));
        }
        return number;
    }

    public static List<DataField> contractorAwardDate() throws InterruptedException {
        List<DataField> date = new ArrayList<DataField>();
        List<WebElement> elementList= driver.findElements(By.cssSelector("#awards-list > .card-simple > .card-simple-content > .usa-grid-full > div:nth-child(2)"));
        for(WebElement we:elementList){
            String label = we.findElement(By.cssSelector("ul > li:nth-child(3) > span:nth-child(1)")).getText();
            String data = we.findElement(By.cssSelector("ul > li:nth-child(3) > span:nth-child(2)")).getText();
          //  System.out.println("Label - " + label + " Data - " + data);
            date.add(new DataField("Contract Award Date", label, data));
        }
        return date;
    }


}
