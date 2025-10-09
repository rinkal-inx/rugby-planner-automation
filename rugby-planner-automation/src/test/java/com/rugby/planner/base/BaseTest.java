package com.rugby.planner.base;

import com.rugby.planner.config.ConfigReader;
import com.rugby.planner.config.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;  // available to child test classes

    @BeforeMethod
    public void setUp() {
        // 1. Load config file
        ConfigReader.loadConfig();

        // 2. Get browser name from config file
        String browser = ConfigReader.getProperty("browser");

        // 3. Launch the browser using DriverFactory
        driver = DriverFactory.initDriver(browser);

        // 4. Open the base URL from config file
        String url = ConfigReader.getProperty("base.url");
        driver.get(url);

        System.out.println("✅ Browser launched and URL opened: " + url);
    }

    @AfterMethod
    public void tearDown() {
        // 5. Close browser after each test
        DriverFactory.quitDriver();
        System.out.println("🧹 Browser closed successfully.");
    }
}
