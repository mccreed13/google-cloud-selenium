package com.epam.training.student_anton_lapushenko.WebDriver.Task1.page;

import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.GPUModels;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.LocalSSD;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.NumberOfGPUs;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.Regions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SummaryPage {
    WebDriver driver;

    private final By instanceNumbersBy = By.xpath("//*[preceding-sibling::span[contains(text(), 'Number of Instances')]]");
    private final By operationSystemBy = By.xpath("//span[preceding-sibling::span[contains(text(), 'Operating System')]]");
    private final By provisioningModelBy = By.xpath("//span[preceding-sibling::span[contains(text(), 'Provisioning Model')]]");
    private final By machineTypeBy = By.xpath("//span[preceding-sibling::span[contains(text(), 'Machine type')]]");
    private final By GPUTypeBy = By.xpath("//span[preceding-sibling::span[contains(text(), 'GPU Model')]]");
    private final By NumberOfGPUBy = By.xpath("//span[preceding-sibling::span[contains(text(), 'Number of GPUs')]]");
    private final By localSSDBy = By.xpath("//span[preceding-sibling::span[contains(text(), 'Local SSD')]]");
    private final By locationBy = By.xpath("//span[preceding-sibling::span[contains(text(), 'Region')]]");
    private final By commitedUsageBy = By.xpath("//span[preceding-sibling::span[contains(text(), 'Committed use discount options')]]");
    private final By totalEstimatedCostBy = By.xpath("//span[text()='Compute']/following-sibling::span");

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getInstanceNumber() {
        WebElement instanceNumber = driver.findElement(instanceNumbersBy);
        return Integer.parseInt(instanceNumber.getText());
    }

    public String getOperatingSystem() {
        WebElement operationSystem = driver.findElement(operationSystemBy);
        return operationSystem.getText();
    }

    public String getProvisioningModel() {
        WebElement provisioningModel = driver.findElement(provisioningModelBy);
        return provisioningModel.getText();
    }

    public String getMachineType() {
        WebElement machineType = driver.findElement(machineTypeBy);
        return machineType.getText().split(",")[0];
    }

    public GPUModels getGPUType() {
        WebElement GPUType = driver.findElement(GPUTypeBy);
        return GPUModels.get(GPUType.getText());
    }

    public NumberOfGPUs getNumberOfGPU() {
        WebElement numberOfGPU = driver.findElement(NumberOfGPUBy);
        return NumberOfGPUs.get(Integer.parseInt(numberOfGPU.getText()));
    }

    public LocalSSD getLocalSSD() {
        WebElement localSSD = driver.findElement(localSSDBy);
        return LocalSSD.get(localSSD.getText());
    }

    public Regions getLocation() {
        WebElement location = driver.findElement(locationBy);
        return Regions.valueOf(location.getText().split(" ")[0]);
    }

    public String getCommitedUsage() {
        WebElement commitedUsage = driver.findElement(commitedUsageBy);
        return commitedUsage.getText();
    }

    public String getTotalEstimatedCost() {
        WebElement totalEstimatedCost = driver.findElement(totalEstimatedCostBy);
        return totalEstimatedCost.getText();
    }
}
