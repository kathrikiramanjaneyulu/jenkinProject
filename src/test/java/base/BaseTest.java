package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected static WebDriver driver;
    protected static Properties prop;

    public static void initializeDriver() {
        if (prop == null) {
            try {
                prop = new Properties();
                FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
                prop.load(fis);
            } catch (IOException e) {
                throw new RuntimeException("❌ Could not load config.properties", e);
            }
        }

        if (driver == null) {
            String browser = prop.getProperty("browser", "chrome");
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Properties getProp() {
        return prop;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
