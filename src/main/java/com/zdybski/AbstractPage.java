package com.zdybski;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractPage {
    WebDriver driver;
    WebDriverWait webDriverWait;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, 50);
    }

    void waitForElementVisibility(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));

    }

}