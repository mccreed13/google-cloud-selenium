package com.epam.training.student_anton_lapushenko.WebDriver.Task1.page;

import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.GPUModels;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.LocalSSD;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.NumberOfGPUs;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.Regions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleCloudCalculatorPage {
    WebDriver driver;

    private final By addToEstimateButtonBy = By.xpath("//span[contains(text(), 'Add to estimate')]");
    private final By computerEngineBy = By.xpath("//div[@class='VobRQb' and contains(.,'Compute Engine')]");
    private final By countInstancesBy = By.id("c22");
    private final By operatingSoftwareOpenListBy = By.xpath("//div[@class='qUa9tb' and contains(.,'Operating System / Software')]//div[@class='VfPpkd-aPP78e']");
    private final By freeOperatingSoftwareBy = By.xpath("//li[contains(.,'Free: Debian')]");
    private final By provisioningModelRegularBy = By.xpath("//*[@class='zT2df' and text()='Regular']");
    private final By machineFamilyListBy = By.xpath("//div[@class='O1htCb-H9tDt PPUDSe t8xIwc' and contains(.,'Machine Family')]//div[@class='VfPpkd-aPP78e']");
    private final By machineFamilyGeneralPurposeBy = By.xpath("//li[contains(.,'General Purpose')]");
    private final By seriasListBy = By.xpath("//div[@class='O1htCb-H9tDt PPUDSe t8xIwc' and contains(.,'Series')]//div[@class='VfPpkd-aPP78e']");
    private final By seriasN1By = By.xpath("//li[contains(.,'N1')]");
    private final By machineTypeListBy = By.xpath("//div[@class='O1htCb-H9tDt PPUDSe t8xIwc' and contains(.,'Machine type')]//div[@class='VfPpkd-aPP78e']");
    private final By machineTypeN1_8By = By.xpath("//li[contains(.,'n1-standard-8')]");
    private final By checkboxAddGPUsBy = By.xpath("//button[@aria-label='Add GPUs']");
    private final By GPUModelListBy = By.xpath("//div[@class='qUa9tb' and contains(.,'GPU Model')]//div[@class='VfPpkd-aPP78e']");
    private final By optionalsGPUModelsBy = By.xpath("//ul[@aria-label='GPU Model']/li");
    private final By listNumberOfGPUs = By.xpath("//div[@class='qUa9tb' and contains(.,'Number of GPUs')]//div[@class='VfPpkd-aPP78e']");
    private final By optionalsNumberOfGPUs = By.xpath("//ul[@aria-label='Number of GPUs']/li");
    private final By listNumberOfLocalSSDsBy = By.xpath("//div[@class='qUa9tb' and contains(.,'Local SSD')]//div[@class='VfPpkd-aPP78e']");
    private final By optionalsNumberOfLocalSSDsBy = By.xpath("//ul[@aria-label='Local SSD']/li");
    private final By listRegionsBy = By.xpath("//div[@class='qUa9tb' and contains(.,'Region')]//div[@class='VfPpkd-aPP78e']");
    private final By optionalsRegionBy = By.xpath("//ul[@aria-label='Region']/li");
    private final By committedUsageOneYearBy = By.xpath("//*[@class='zT2df' and @for='1-year']");
    private final By totalEstimatedCostBy = By.xpath("//div[@class='KDVqKe']//label");
    private final By costBy = By.xpath("//div[@class='Z7Qi9d HY0Uh']");
    private final By shareButtonBy = By.xpath("//button[@aria-label='Open Share Estimate dialog']");
    private final By openEstimateSummaryBy = By.xpath("//a[@track-name='open estimate summary']");

    public GoogleCloudCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addComputerEngineToEstimate() {
        WebElement estimateButton = driver.findElement(addToEstimateButtonBy);
        estimateButton.click();
        WebElement computerEngineButton = driver.findElement(computerEngineBy);
        computerEngineButton.click();
    }

    public void setInstances(int instances) {
        WebElement countInstances = driver.findElement(countInstancesBy);
        countInstances.clear();
        countInstances.sendKeys(String.valueOf(instances));
    }

    public void setFreeOperatingSoftware() {
        WebElement operatingSoftwareList = driver.findElement(operatingSoftwareOpenListBy);
        operatingSoftwareList.click();
        WebElement freeOperatingSoftware = driver.findElement(freeOperatingSoftwareBy);
        freeOperatingSoftware.click();
    }

    public void setProvisioningModelRegular() {
        WebElement provisioningModelRegular = driver.findElement(provisioningModelRegularBy);
        provisioningModelRegular.click();
    }

    public void setMachineFamilyGeneralPurpose() {
        WebElement machineFamilyList = driver.findElement(machineFamilyListBy);
        machineFamilyList.click();
        WebElement machineFamilyGeneralPurpose = driver.findElement(machineFamilyGeneralPurposeBy);
        machineFamilyGeneralPurpose.click();
    }

    public void setSeriesN1() {
        WebElement seriesList = driver.findElement(seriasListBy);
        seriesList.click();
        WebElement seriesN1 = driver.findElement(seriasN1By);
        seriesN1.click();
    }

    public void setMachineTypeN1_8() {
        WebElement machineTypeList = driver.findElement(machineTypeListBy);
        machineTypeList.click();
        WebElement machineTypeN1 = driver.findElement(machineTypeN1_8By);
        machineTypeN1.click();
    }

    public void addGPUs(GPUModels gpuModel, NumberOfGPUs numberOfGPUs) {
        turnOnAddGPUs();
        setGPUModel(gpuModel);
        setNumberOfGPUs(numberOfGPUs);
    }

    private void turnOnAddGPUs() {
        WebElement addGPUsButton = driver.findElement(checkboxAddGPUsBy);
        addGPUsButton.click();
    }

    private void setGPUModel(GPUModels gpuModel) {
        WebElement gpuModelList = driver.findElement(GPUModelListBy);
        gpuModelList.click();
        List<WebElement> options = driver.findElements(optionalsGPUModelsBy);
        options.stream()
                .filter(o -> o.getText().equals(gpuModel.value))
                .findAny()
                .ifPresent(WebElement::click);
    }

    private void setNumberOfGPUs(NumberOfGPUs numberOfGPUs) {
        WebElement numberOfGPUsList = driver.findElement(listNumberOfGPUs);
        numberOfGPUsList.click();
        List<WebElement> options = driver.findElements(optionalsNumberOfGPUs);
        options.stream()
                .filter(o -> o.getText().contains(String.valueOf(numberOfGPUs.value)))
                .findAny()
                .ifPresent(WebElement::click);
    }

    public void setNumberOfLocalSSDs(LocalSSD localSSDs) {
        WebElement listNumberOfLocalSSDs = driver.findElement(listNumberOfLocalSSDsBy);
        listNumberOfLocalSSDs.click();
        List<WebElement> options = driver.findElements(optionalsNumberOfLocalSSDsBy);
        options.stream()
                .filter(o -> o.getText().contains(localSSDs.value))
                .findAny()
                .ifPresent(WebElement::click);
    }

    public void setRegion(Regions region) {
        WebElement listRegion = driver.findElement(listRegionsBy);
        listRegion.click();
        List<WebElement> options = driver.findElements(optionalsRegionBy);
        options.stream()
                .filter(o -> o.getText().contains(region.toString()))
                .findAny()
                .ifPresent(WebElement::click);
    }

    public void setCommittedUsageOneYear() {
        WebElement committedUsageOneYear = driver.findElement(committedUsageOneYearBy);
        committedUsageOneYear.click();
    }

    public String getTotalEstimatedCost() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOfElementLocated(costBy));
        WebElement totalEstimatedCost = driver.findElement(totalEstimatedCostBy);
        return totalEstimatedCost.getText();
    }

    public void clickShare() {
        WebElement shareButton = driver.findElement(shareButtonBy);
        shareButton.click();
    }

    public void clickOpenEstimateSummary() {
        WebElement shareButton = driver.findElement(openEstimateSummaryBy);
        shareButton.click();
    }

}

