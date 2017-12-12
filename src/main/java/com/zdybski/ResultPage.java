package com.zdybski;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


public class ResultPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"jobs_filters_title\"]/div/span[1]")
    private WebElement totalResultAmount;

    @FindBy(className = "job_link")
    private List<WebElement> jobOffers;

    public ResultPage(WebDriver driver) {
        super(driver);
        waitForElementVisibility(totalResultAmount);
    }

    public int getTotalResultAmount() {
        return new Integer(totalResultAmount.getText());
    }

    public int findAmountOfSpecifiedJobOffers(String phrase) {

        List<WebElement> specifiedJobOffers = jobOffers.stream()
                .filter(jobOffer -> jobOffer.getText()
                        .contains(phrase))
                .collect(Collectors.toList());

        return specifiedJobOffers.size();

    }

    public AdvertPage goToAdvertPage(String advert) {
        Optional<WebElement> specifiedJobOffer = jobOffers.stream()
                .filter(jobOffer -> jobOffer.getText()
                        .equals(advert)).findFirst();

        try {
            if (specifiedJobOffer.isPresent()) {
                specifiedJobOffer.get().click();
            } else {
                throw new NoSuchElementException("Page is missing advert: " + advert);
            }
        } catch (NoSuchElementException e) {
            throw e;
        }

        return new AdvertPage(driver);
    }

}
