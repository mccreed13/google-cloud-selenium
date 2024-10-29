package com.epam.training.student_anton_lapushenko.WebDriver.Task1.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum BrowserFactory {
    CHROME {
        @Override
        public WebDriver createDriver() {
            ChromeOptions options = new ChromeOptions();
            return new ChromeDriver(options);

        }
    },
    FIREFOX{
        @Override
        public WebDriver createDriver() {
            return new FirefoxDriver();
        }
    };

    public abstract WebDriver createDriver();

}
