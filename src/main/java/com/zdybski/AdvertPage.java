package com.zdybski;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdvertPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"description_box\"]/div[1]/div[1]/dl[2]/dd/span[1]")
    WebElement advertCreationDate;

    public AdvertPage(WebDriver driver) {
        super(driver);
        waitForElementVisibility(advertCreationDate);
    }

    public String getCreationDate() {
        return advertCreationDate.getText();
    }
}
