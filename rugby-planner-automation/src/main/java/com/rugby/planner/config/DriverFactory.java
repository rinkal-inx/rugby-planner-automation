package com.rugby.planner.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static WebDriver driver;

    // Initialize WebDriver
    public static WebDriver initDriver(String browser) {
        if(driver!=null) {
        	return driver;
        }
          switch(browser.toLowerCase()) {
          
        	case "chrome":
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.setAcceptInsecureCerts(true);
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            break;
            
        	case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.setAcceptInsecureCerts(true);
                driver = new EdgeDriver(edgeOptions);
                driver.manage().window().maximize();
                break;
                
                default:
                	throw new RuntimeException("Invalid browser:"+browser+"(use chrome|edge");
        }
        return driver;
    }

    // Return current driver
    public static WebDriver getDriver() {
        return driver;
    }

    // Quit driver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
