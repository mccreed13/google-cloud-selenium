package com.epam.training.student_anton_lapushenko.WebDriver.Task1.steps;

import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.GPUModels;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.LocalSSD;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.NumberOfGPUs;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.Regions;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.page.GoogleCloudCalculatorPage;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.page.GoogleCloudMainPage;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.page.GoogleCloudSearchPage;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.page.SummaryPage;
import org.openqa.selenium.WebDriver;

public class EstimateSteps {
    WebDriver driver;

    public EstimateSteps(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleCloudCalculatorPage addParametersToEstimate(int instanceNumber, GPUModels gpuModel, NumberOfGPUs numberOfGPUs, LocalSSD localSSD, Regions region) {
        GoogleCloudCalculatorPage calculatorPage = searchCalculator();
        calculatorPage.addComputerEngineToEstimate();
        calculatorPage.setInstances(instanceNumber);
        calculatorPage.setFreeOperatingSoftware();
        calculatorPage.setProvisioningModelRegular();
        calculatorPage.setMachineFamilyGeneralPurpose();
        calculatorPage.setSeriesN1();
        calculatorPage.setMachineTypeN1_8();
        calculatorPage.addGPUs(gpuModel, numberOfGPUs);
        calculatorPage.setNumberOfLocalSSDs(localSSD);
        calculatorPage.setRegion(region);
        return calculatorPage;
    }

    private GoogleCloudCalculatorPage searchCalculator(){
        GoogleCloudMainPage mainPage = new GoogleCloudMainPage(driver);
        GoogleCloudSearchPage searchPage = mainPage.searchCalculator();
        return searchPage.openCalculator();
    }

    public SummaryPage openEstimateSummary(){
        GoogleCloudCalculatorPage calculatorPage = new GoogleCloudCalculatorPage(driver);
        calculatorPage.clickShare();
        calculatorPage.clickOpenEstimateSummary();
        for (String window : driver.getWindowHandles()) {
            if(!window.equals(driver.getWindowHandle())){
                driver.switchTo().window(window);
                break;
            }
        }
        return new SummaryPage(driver);
    }
}
