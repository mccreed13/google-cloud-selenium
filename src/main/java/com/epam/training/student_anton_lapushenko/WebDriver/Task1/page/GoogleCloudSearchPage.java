package com.epam.training.student_anton_lapushenko.WebDriver.Task1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class GoogleCloudSearchPage {
    WebDriver driver;

    private final By searchCalculatorResultBy = By.xpath("//a[@track-type='search-result']");

    public GoogleCloudSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleCloudCalculatorPage openCalculator() {
        List<WebElement> elements = driver.findElements(searchCalculatorResultBy);
        elements.get(0).click();
        return new GoogleCloudCalculatorPage(driver);
    }
}
