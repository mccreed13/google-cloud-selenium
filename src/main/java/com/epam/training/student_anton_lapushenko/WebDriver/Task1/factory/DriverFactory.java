package com.epam.training.student_anton_lapushenko.WebDriver.Task1.factory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    public WebDriver createInstance(String browser) {
        return BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
    }
}
