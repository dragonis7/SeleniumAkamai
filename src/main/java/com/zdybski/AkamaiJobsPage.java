package com.zdybski;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AkamaiJobsPage extends AbstractPage {

    private String urlAdress;

    @FindBy(name = "keyword")
    private WebElement searchForm;

    @FindBy(className = "jLocPlaceholder")
    private WebElement searchLocationForm;

    @FindBy(xpath = "//*[@id=\"location_facet_chzn\"]/ul/li/input")
    private WebElement searchLocationPlaceholder;

    @FindBy(xpath = "//*[@id=\"jSearchSubmit\"]/span[2]")
    private WebElement searchButton;

    @FindBy(id = "location_facet_chzn_o_15")
    private WebElement krakowLocation;

    public AkamaiJobsPage(WebDriver driver, String urlAdress) {
        super(driver);
        this.urlAdress = urlAdress;
    }

    public AkamaiJobsPage goToPage() {
        driver.get(urlAdress);
        return this;
    }

    public ResultPage searchForJobs(String searchPhrase) {

        searchForm.clear();
        searchForm.sendKeys(searchPhrase);
        searchLocationForm.click();
        krakowLocation.click();
        searchButton.click();
        return new ResultPage(driver);
    }


}
