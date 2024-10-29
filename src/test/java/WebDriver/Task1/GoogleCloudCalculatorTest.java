package WebDriver.Task1;

import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.GPUModels;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.LocalSSD;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.NumberOfGPUs;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.enums.Regions;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.page.GoogleCloudCalculatorPage;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.page.SummaryPage;
import com.epam.training.student_anton_lapushenko.WebDriver.Task1.steps.EstimateSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class GoogleCloudCalculatorTest extends BaseTest {
    private final String operationSystems = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
    private final String provisionModel = "Regular";
    private final String machineType = "n1-standard-8";
    private final int instanceNumber = 4;
    private final GPUModels gpuModel = GPUModels.TESLA_V100;
    private final NumberOfGPUs numberOfGPUs = NumberOfGPUs.ONE;
    private final LocalSSD localSSD = LocalSSD.TWOx375GB;
    private final Regions region = Regions.Netherlands;

    @BeforeClass
    public void navigate() {
        driver.get("https://cloud.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testGoogleCloudCalculator() {
        EstimateSteps estimateSteps = new EstimateSteps(driver);
        GoogleCloudCalculatorPage calculatorPage = estimateSteps.addParametersToEstimate(instanceNumber, gpuModel,
                numberOfGPUs, localSSD, region);
        String totalEstimatedCostFromCalculator = calculatorPage.getTotalEstimatedCost();
        SummaryPage summaryPage = estimateSteps.openEstimateSummary();
        assertSummaryPageIsCorrect(summaryPage, totalEstimatedCostFromCalculator);
    }

    private void assertSummaryPageIsCorrect(SummaryPage summaryPage, String totalEstimatedCostFromCalculator){
        assertEquals(summaryPage.getInstanceNumber(), instanceNumber);
        assertEquals(summaryPage.getGPUType(), gpuModel);
        assertEquals(summaryPage.getNumberOfGPU(), numberOfGPUs);
        assertEquals(summaryPage.getLocalSSD(), localSSD);
        assertEquals(summaryPage.getLocation(), region);
        assertEquals(summaryPage.getOperatingSystem(), operationSystems);
        assertEquals(summaryPage.getProvisioningModel(), provisionModel);
        assertEquals(summaryPage.getMachineType(), machineType);
        assertEquals(summaryPage.getTotalEstimatedCost(), totalEstimatedCostFromCalculator);
    }
}
