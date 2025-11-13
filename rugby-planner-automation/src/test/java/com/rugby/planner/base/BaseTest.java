package com.rugby.planner.base;

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

public class BaseTest {

    protected WebDriver driver;  // available to child test classes

    @BeforeMethod
    public void setUp() {
      try {	
    
        ConfigReader.loadConfig();

        String browser = ConfigReader.getProperty("browser");

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
    
    protected void captureScreenshot(String testName) {
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
}
