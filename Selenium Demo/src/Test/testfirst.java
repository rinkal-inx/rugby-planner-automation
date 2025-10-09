package Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class testfirst {

    WebDriver driver;
    WebDriverWait wait;
    
    @BeforeMethod
    public void startBrowser() {
        try {
        	WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://dev.d22be1jj19bmim.amplifyapp.com/");
        } catch (Exception e) {
            System.out.println("🚨 Browser setup failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "getUserData")
    public void runTest(User user) {
        if (wait == null || driver == null) {
            System.out.println("🚫 Driver or wait not initialized. Skipping test.");
            return;
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amplify-id-:r2:"))).sendKeys(user.email);
            driver.findElement(By.id("amplify-id-:r5:")).sendKeys(user.password);
            driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h1[normalize-space()='Landing Page']")));

            if (user.panel.equalsIgnoreCase("Dentist")) {
                driver.findElement(By.xpath("//button[normalize-space()='Dentist Panel']")).click();
            } else if (user.panel.equalsIgnoreCase("X-Ray")) {
                driver.findElement(By.xpath("//button[normalize-space()='X-Ray']")).click();
            }

            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).click();

        } catch (Exception e) {
            System.out.println("❌ Test failed: " + e.getMessage());
        }
    }

    @DataProvider
    public Object[][] getUserData() {
        return new Object[][] {
                { new User("admindoctor@yopmail.com", "Test@123", "Admin") },
                { new User("webdoctor@yopmail.com", "Test@123", "Web") }
        };
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
