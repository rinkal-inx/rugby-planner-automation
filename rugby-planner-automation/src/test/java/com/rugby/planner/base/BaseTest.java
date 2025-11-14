package com.rugby.planner.base;

import com.rugby.planner.config.ConfigReader;
import com.rugby.planner.config.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browserParameter) {
        try {
            ConfigReader.loadConfig();

            System.out.println("🔧 Starting test on browser: " + browserParameter);

            // Use parameter from XML (highest priority)
            driver = DriverFactory.initDriver(browserParameter);

            String url = ConfigReader.getProperty("base.url");
            driver.get(url);

            System.out.println("✅ Browser launched and URL opened: " + url);
        }
        catch (Exception e) {
            System.out.println("❌ Error during setup: " + e.getMessage());
            e.printStackTrace();
        }
    }



    @AfterMethod
    public void tearDown() {
        try {
            DriverFactory.quitDriver();
            System.out.println("🧹 Browser closed successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error while closing: " + e.getMessage());
        }
    }

    public void captureScreenshot(String testName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String dest = "screenshots/" + testName + "_" + timestamp + ".png";

            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(src.toPath(), Paths.get(dest));

            System.out.println("📸 Screenshot saved: " + dest);
        } catch (IOException e) {
            System.out.println("❌ Screenshot failed: " + e.getMessage());
        }
    }
}




/*package com.rugby.planner.base;

import com.rugby.planner.config.ConfigReader;
import com.rugby.planner.config.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;  // available to child test classes
    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional String browser) {
      try {	
    
        ConfigReader.loadConfig();

        //String browser = ConfigReader.getProperty("browser");

        driver = DriverFactory.initDriver(browser);

        String url = ConfigReader.getProperty("base.url");
        driver.get(url);
        System.out.println("✅ Browser launched and URL opened: " + url);
    } 
      catch (Exception E) {
    	System.out.println(" Error during setup:"+ E.getMessage());
    	E.printStackTrace();
      }
}


    @AfterMethod
    public void tearDown() {
    	try {
        // 5. Close browser after each test
        DriverFactory.quitDriver();
        System.out.println("🧹 Browser closed successfully.");
    } 
    catch(Exception e) {
	 System.out.println("Error while closing browser:"+e.getMessage());
	 }
 }
    
    public void captureScreenshot(String testName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String dest = "screenshots/" + testName + "_" + timestamp + ".png";
            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(source.toPath(), Paths.get(dest));
            System.out.println("📸 Screenshot captured: " + dest);
        } catch (IOException e) {
            System.err.println("❌ Failed to capture screenshot: " + e.getMessage());
        }
    }
}*/
