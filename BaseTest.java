package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {



        protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

        @BeforeMethod
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
            driver.set(new ChromeDriver(options));
        }

        public WebDriver getDriver() {
            return driver.get();
        }

        @AfterMethod
        public void tearDown() {
            if (driver.get() != null) {
                driver.get().quit();
            }
        }
    }
