package WebDriver.Task1;

import com.epam.training.student_anton_lapushenko.WebDriver.Task1.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

class BaseTest {
    protected WebDriver driver;
    Properties properties = new Properties();
    private final String CONFIG_FILE_PATH = "./src/test/resources/general.properties";

    @BeforeClass
    public void setUp() {
        String browser;
        try (Reader reader = new FileReader(CONFIG_FILE_PATH)) {
            properties.load(reader);
            browser = properties.getProperty("browser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver = new DriverFactory().createInstance(browser);
    }

    @AfterClass
    void quitDriver() {
        if(driver != null) {
            driver.quit();
        }
    }
}
