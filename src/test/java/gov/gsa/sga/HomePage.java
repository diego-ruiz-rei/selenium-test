package gov.gsa.sga;

import org.openqa.selenium.By;

public class HomePage extends Base {
    public HomePage(){
        super();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void gotoHomePage() throws InterruptedException {
        driver.get(base_url);
    }

    public String defaultOption(String optionVar) {
        return this.getDriver().findElement(By.cssSelector(optionVar)).getText();
    }

    public String specificOption(String optionVar) {
        return this.getDriver().findElement(By.cssSelector("option[value=\""+optionVar+"\"]")).getText();
    }

    public boolean filterDropdown() {
        return this.isElementPresent(By.id("filter"));
    }

    public boolean searchInputBar() {
        return this.isElementPresent(By.cssSelector(".search-inputbar"));
    }

    public boolean searchButton() {
        return this.isElementPresent(By.cssSelector(".usa-search-submit-text"));
    }

    public boolean byCSSSelector(String x) {
        return this.isElementPresent(By.cssSelector(x));
    }

}
