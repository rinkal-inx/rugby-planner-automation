package com.aident.tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AIWeb {

    public static void main(String[] args) {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        

        try {
            driver.get("https://dev.d22be1jj19bmim.amplifyapp.com/");
            driver.manage().window().maximize();

// Scenario 1 -- Create Account with valid credential  (BUG 10)
            /*WebElement createAcc = driver.findElement(By.xpath("(//button[normalize-space()='Create Account'])[1]"));
            createAcc.click();
            
            Thread.sleep(2000);

            WebElement emailField = driver.findElement(By.xpath("//input[@id='amplify-id-:r8:']"));
            emailField.sendKeys("und22@yopmail.com");

            WebElement passwordField = driver.findElement(By.xpath("//input[@id='amplify-id-:rb:']"));
            passwordField.sendKeys("Test@123");
            
            WebElement confirmpasswordField = driver.findElement(By.xpath("//input[@id='amplify-id-:re:']"));
            confirmpasswordField.sendKeys("Test@123");

            WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
            submitButton.click();
            
            Thread.sleep(8000);
            
            driver.get("https://yopmail.com/");
            
            WebElement inboxInput = driver.findElement(By.id("login"));
            inboxInput.sendKeys("und22", Keys.ENTER);
            
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifinbox"));

            WebElement firstEmail = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.m")));
            firstEmail.click();
            
            driver.switchTo().defaultContent();
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifmail"));
            
            Thread.sleep(20000);
            
            String mailBody = driver.findElement(By.tagName("body")).getText();
            
            String code = "";
            Matcher matcher = Pattern.compile("\\b\\d{6}\\b").matcher(mailBody);
            matcher.find();
            code = matcher.group();
            
            driver.switchTo().defaultContent();
            driver.navigate().back();
            driver.navigate().back();

            WebElement codeInput = driver.findElement(By.xpath("//input[@placeholder='Enter your code']"));
            codeInput.sendKeys(code);  

            WebElement confirmButton = driver.findElement(By.xpath("//button[normalize-space()='Confirm']"));
            confirmButton.click(); 
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Profile Completion')]")));

            if (driver.getPageSource().contains("Profile Completion")) {
                System.out.println("BUG#10_✅ Sign Up Test Passed: Successfully created account.");
            } else {
                System.out.println("BUG#10_❌ Sign Up Test Failed: Sign Up was not successful.");
            }*/
            
// Scenario 2 -- Sign In with dentist added by Admin
//Dental Panel            
          /*  WebElement emailField1 = driver.findElement(By.xpath("//input[@id='amplify-id-:r2:']"));
            emailField1.sendKeys("admindoctor@yopmail.com");
            
            WebElement passwordField1 = driver.findElement(By.xpath("//input[@id='amplify-id-:r5:']"));
            passwordField1.sendKeys("Test@123");
            
            WebElement signinButton1 = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
            signinButton1.click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Landing Page']")));
            
            WebElement dentistPanel = driver.findElement(By.xpath("//button[normalize-space()='Dentist Panel']"));
            dentistPanel.click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Patients']")));
            
            WebElement profileButton = driver.findElement(By.xpath("//span[contains(text(),'Profile')]"));
            profileButton.click();
            
            Thread.sleep(3000);
            
            Map<String, String> fields = new HashMap<>();
            fields.put("Registration Number", driver.findElement(By.xpath("//label[text()='Registration Number']/following-sibling::input")).getAttribute("value"));
            fields.put("First Name", driver.findElement(By.name("first_name")).getAttribute("value"));
            fields.put("Last Name", driver.findElement(By.name("last_name")).getAttribute("value"));
            fields.put("Email", driver.findElement(By.name("email")).getAttribute("value"));
            fields.put("Phone Number", driver.findElement(By.name("whatsapp_no")).getAttribute("value"));
            fields.put("City", driver.findElement(By.name("city")).getAttribute("value"));
            fields.put("Clinic Name", driver.findElement(By.name("clininc_name")).getAttribute("value"));

            System.out.println("===Admin-Dental===");
            
            for (Map.Entry<String, String> entry : fields.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println();
            
            WebElement logoutButton = driver.findElement(By.xpath("//span[contains(text(),'Logout')]"));
            logoutButton.click();
       
// X-Ray Panel            
            WebElement emailAddress = driver.findElement(By.xpath("//input[@id='amplify-id-:r2:']"));
            emailAddress.sendKeys("admindoctor@yopmail.com");
            
            WebElement password = driver.findElement(By.xpath("//input[@id='amplify-id-:r5:']"));
            password.sendKeys("Test@123");
            
            WebElement signIn = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
            signIn.click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Landing Page']")));
            
            WebElement xrayPanel = driver.findElement(By.xpath("//button[normalize-space()='X-Ray']"));
            xrayPanel.click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Select an X-ray image and submit to view and analy')]")));
            
            WebElement profileIcon = driver.findElement(By.xpath("//button[@aria-label='My account']"));
            profileIcon.click();
            
            WebElement myAcc = driver.findElement(By.xpath("//li[1]"));
            myAcc.click();
            
            Map<String, String> fieldsX = new HashMap<>();
            fieldsX.put("First Name", driver.findElement(By.xpath("//label[text()='First Name']/following-sibling::input")).getAttribute("value"));
            fieldsX.put("Last Name", driver.findElement(By.xpath("//label[text()='Last Name']/following-sibling::input")).getAttribute("value"));
            fieldsX.put("Clinic Name", driver.findElement(By.xpath("//label[text()='Clinic Name']/following-sibling::input")).getAttribute("value"));
            fieldsX.put("Phone Number", driver.findElement(By.xpath("//label[text()='Phone Number']/following-sibling::input")).getAttribute("value"));
            fieldsX.put("City", driver.findElement(By.xpath("//label[text()='City']/following-sibling::input")).getAttribute("value"));
            fieldsX.put("Address", driver.findElement(By.xpath("//label[text()='Address']/following-sibling::textarea")).getText());

            System.out.println("===Admin-X Ray===");
            
            for (Map.Entry<String, String> entry : fieldsX.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println();
            
            WebElement closeButton = driver.findElement(By.xpath("//button[normalize-space()='Close']"));
            closeButton.click();
            
            profileIcon.click();
            
            WebElement logout = driver.findElement(By.xpath("//span[normalize-space()='Logout']"));
            logout.click();
            
            WebElement modalLogout = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'modalContent_btn-container')]//span[normalize-space()='Logout']")));
            modalLogout.click();
            
            driver.quit();*/
          
//Scenario 3 -- Sign In with dentist added from Web Panel
            
            /*WebElement emailField2 = driver.findElement(By.xpath("//input[@id='amplify-id-:r2:']"));
            emailField2.sendKeys("webdoctor@yopmail.com");
            
            WebElement passwordField2 = driver.findElement(By.xpath("//input[@id='amplify-id-:r5:']"));
            passwordField2.sendKeys("Test@123");
            
            WebElement signinButton2 = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
            signinButton2.click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Landing Page']")));
            
            WebElement dentistPanel2 = driver.findElement(By.xpath("//button[normalize-space()='Dentist Panel']"));
            dentistPanel2.click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Patients']")));
            
            WebElement profileButton2 = driver.findElement(By.xpath("//span[contains(text(),'Profile')]"));
            profileButton2.click();
            
            Thread.sleep(3000);
            
            Map<String, String> fields2 = new HashMap<>();
            fields2.put("Registration Number", driver.findElement(By.xpath("//label[text()='Registration Number']/following-sibling::input")).getAttribute("value"));
            fields2.put("First Name", driver.findElement(By.name("first_name")).getAttribute("value"));
            fields2.put("Last Name", driver.findElement(By.name("last_name")).getAttribute("value"));
            fields2.put("Email", driver.findElement(By.name("email")).getAttribute("value"));
            fields2.put("Phone Number", driver.findElement(By.name("whatsapp_no")).getAttribute("value"));
            fields2.put("City", driver.findElement(By.name("city")).getAttribute("value"));
            fields2.put("Clinic Name", driver.findElement(By.name("clininc_name")).getAttribute("value"));

            System.out.println("===Web-Dentist===");
            
            for (Map.Entry<String, String> entry : fields2.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println();
            
            WebElement logoutButton2 = driver.findElement(By.xpath("//span[contains(text(),'Logout')]"));
            logoutButton2.click();
            
// X-Ray Panel            
            WebElement email = driver.findElement(By.xpath("//input[@id='amplify-id-:r2:']"));
            email.sendKeys("webdoctor@yopmail.com");
            
            WebElement password2 = driver.findElement(By.xpath("//input[@id='amplify-id-:r5:']"));
            password2.sendKeys("Test@123");
            
            WebElement signIn2 = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
            signIn2.click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Landing Page']")));
            
            WebElement xrayPanel2 = driver.findElement(By.xpath("//button[normalize-space()='X-Ray']"));
            xrayPanel2.click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Select an X-ray image and submit to view and analy')]")));
            
            WebElement profileIcon2 = driver.findElement(By.xpath("//button[@aria-label='My account']"));
            profileIcon2.click();
            
            WebElement myAcc2 = driver.findElement(By.xpath("//li[1]"));
            myAcc2.click();
            
            Map<String, String> fields22 = new HashMap<>();
            fields22.put("First Name", driver.findElement(By.xpath("//label[text()='First Name']/following-sibling::input")).getAttribute("value"));
            fields22.put("Last Name", driver.findElement(By.xpath("//label[text()='Last Name']/following-sibling::input")).getAttribute("value"));
            fields22.put("Clinic Name", driver.findElement(By.xpath("//label[text()='Clinic Name']/following-sibling::input")).getAttribute("value"));
            fields22.put("Phone Number", driver.findElement(By.xpath("//label[text()='Phone Number']/following-sibling::input")).getAttribute("value"));
            fields22.put("City", driver.findElement(By.xpath("//label[text()='City']/following-sibling::input")).getAttribute("value"));
            fields22.put("Address", driver.findElement(By.xpath("//label[text()='Address']/following-sibling::textarea")).getText());

            System.out.println("===Web-X Ray===");
            
            for (Map.Entry<String, String> entry : fields22.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println();
            
            WebElement closeButton2 = driver.findElement(By.xpath("//button[normalize-space()='Close']"));
            closeButton2.click();
            
            profileIcon.click();
            
            WebElement logout2 = driver.findElement(By.xpath("//span[normalize-space()='Logout']"));
            logout2.click();
            
            WebElement modalLogout2 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'modalContent_btn-container')]//span[normalize-space()='Logout']")));
            modalLogout2.click();            
            
            driver.quit();*/
            
// Scenario 4 -- Sign In with dentist added from mob app
            
           /* WebElement emailField3 = driver.findElement(By.xpath("//input[@id='amplify-id-:r2:']"));
            emailField3.sendKeys("mobdoctor@yopmail.com");
            
            WebElement passwordField3 = driver.findElement(By.xpath("//input[@id='amplify-id-:r5:']"));
            passwordField3.sendKeys("Test@123");
            
            WebElement signinButton3 = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
            signinButton3.click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Landing Page']")));
            
            WebElement dentistPanel3 = driver.findElement(By.xpath("//button[normalize-space()='Dentist Panel']"));
            dentistPanel3.click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Patients']")));
            
            WebElement profileButton3 = driver.findElement(By.xpath("//span[contains(text(),'Profile')]"));
            profileButton3.click();
            
            Thread.sleep(3000);
            
            Map<String, String> fields3 = new HashMap<>();
            fields3.put("Registration Number", driver.findElement(By.xpath("//label[text()='Registration Number']/following-sibling::input")).getAttribute("value"));
            fields3.put("First Name", driver.findElement(By.name("first_name")).getAttribute("value"));
            fields3.put("Last Name", driver.findElement(By.name("last_name")).getAttribute("value"));
            fields3.put("Email", driver.findElement(By.name("email")).getAttribute("value"));
            fields3.put("Phone Number", driver.findElement(By.name("whatsapp_no")).getAttribute("value"));
            fields3.put("City", driver.findElement(By.name("city")).getAttribute("value"));
            fields3.put("Clinic Name", driver.findElement(By.name("clininc_name")).getAttribute("value"));
            
            System.out.println("===Mobile-Dentist===");

            for (Map.Entry<String, String> entry : fields3.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            
            WebElement logoutButton3 = driver.findElement(By.xpath("//span[contains(text(),'Logout')]"));
            logoutButton3.click()
            
// X-Ray Panel            
            WebElement email3 = driver.findElement(By.xpath("//input[@id='amplify-id-:r2:']"));
            email3.sendKeys("mobdoctor@yopmail.com");
            
            WebElement password3 = driver.findElement(By.xpath("//input[@id='amplify-id-:r5:']"));
            password3.sendKeys("Test@123");
            
            WebElement signIn3 = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
            signIn3.click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Landing Page']")));
            
            WebElement xrayPanel3 = driver.findElement(By.xpath("//button[normalize-space()='X-Ray']"));
            xrayPanel3.click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Select an X-ray image and submit to view and analy')]")));
            
            WebElement profileIcon3 = driver.findElement(By.xpath("//button[@aria-label='My account']"));
            profileIcon3.click();
            
            WebElement myAcc3= driver.findElement(By.xpath("//li[1]"));
            myAcc3.click();
            
            Map<String, String> fields33 = new HashMap<>();
            fields33.put("First Name", driver.findElement(By.xpath("//label[text()='First Name']/following-sibling::input")).getAttribute("value"));
            fields33.put("Last Name", driver.findElement(By.xpath("//label[text()='Last Name']/following-sibling::input")).getAttribute("value"));
            fields33.put("Clinic Name", driver.findElement(By.xpath("//label[text()='Clinic Name']/following-sibling::input")).getAttribute("value"));
            fields33.put("Phone Number", driver.findElement(By.xpath("//label[text()='Phone Number']/following-sibling::input")).getAttribute("value"));
            fields33.put("City", driver.findElement(By.xpath("//label[text()='City']/following-sibling::input")).getAttribute("value"));
            fields33.put("Address", driver.findElement(By.xpath("//label[text()='Address']/following-sibling::textarea")).getText());

            System.out.println("===Mob-X Ray===");
            
            for (Map.Entry<String, String> entry : fields33.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println();
            
            WebElement closeButton3 = driver.findElement(By.xpath("//button[normalize-space()='Close']"));
            closeButton3.click();
            
            profileIcon.click();
            
            WebElement logout3 = driver.findElement(By.xpath("//span[normalize-space()='Logout']"));
            logout3.click();
            
            WebElement modalLogout3 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'modalContent_btn-container')]//span[normalize-space()='Logout']")));
            modalLogout3.click(); */
            
//Scenario 5 - Reset Password  (BUG 12)
            
           /* WebElement forgetPassword = driver.findElement(By.xpath("//button[normalize-space()='Forgot your password?']"));
            forgetPassword.click();
            
            WebElement emailField = driver.findElement(By.xpath("//input[@id='amplify-id-:r8:']"));
            emailField.sendKeys("webdoctor@yopmail.com");
            
            WebElement sendButton = driver.findElement(By.xpath("//button[normalize-space()='Send code']"));
            sendButton.click();
            
            Thread.sleep(8000);
            
            driver.get("https://yopmail.com/");
            
            WebElement inboxInput = driver.findElement(By.id("login"));
            inboxInput.sendKeys("webdoctor", Keys.ENTER);
            
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifinbox"));

            WebElement firstEmail = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.m")));
            firstEmail.click();
            
            driver.switchTo().defaultContent();
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ifmail"));
            
            Thread.sleep(20000);
            
            String mailBody = driver.findElement(By.tagName("body")).getText();
            
            String code1 = "";
            Matcher matcher = Pattern.compile("\\b\\d{6}\\b").matcher(mailBody);
            matcher.find();
            code1 = matcher.group();
            
            driver.switchTo().defaultContent();
            driver.navigate().back();
            driver.navigate().back();
            
            WebElement codeInput1 = driver.findElement(By.xpath("//input[@id='amplify-id-:rb:']"));
            codeInput1.sendKeys(code1); 
            
            WebElement newPassword = driver.findElement(By.xpath("//input[@id='amplify-id-:re:']"));
            newPassword.sendKeys("Test@123");
            
            WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='amplify-id-:rh:']"));
            confirmPassword.sendKeys("Test@123");
            
            WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
            submitButton.click();

            WebElement toast = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[contains(text(),'password has been reset successfully.')]")
                ));
            
                String toastMessage = toast.getText().toLowerCase().trim();

                if (toastMessage.contains("password has been reset successfully.")) {
                    System.out.println("BUG#12_✅ Sign Up Test Passed: Toast detected with text = " + toastMessage);
                } else {
                    System.out.println("BUG#12_❌ Sign Up Test Failed: Toast appeared, but text did not match expected. Actual = " + toastMessage);
                }*/
                
//Scenario 6 - 'Update profile' button  (BUG 33)
                
            /*WebElement email3 = driver.findElement(By.xpath("//input[@id='amplify-id-:r2:']"));
            email3.sendKeys("mobdoctor@yopmail.com");
            
            WebElement password3 = driver.findElement(By.xpath("//input[@id='amplify-id-:r5:']"));
            password3.sendKeys("Test@123");
            
            WebElement signIn3 = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
            signIn3.click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Landing Page']")));
            
            WebElement xrayPanel3 = driver.findElement(By.xpath("//button[normalize-space()='X-Ray']"));
            xrayPanel3.click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Select an X-ray image and submit to view and analy')]")));
            
            WebElement profileIcon3 = driver.findElement(By.xpath("//button[@aria-label='My account']"));
            profileIcon3.click();
            
            WebElement myAcc3= driver.findElement(By.xpath("//li[1]"));
            myAcc3.click();
                
            if (driver.getPageSource().contains("Update Profile")) {
                System.out.println("BUG#33_✅ Update Profile button is visible.");
            } else {
                System.out.println("BUG#33_❌ Update profile button is not visible.");
            }*/
            
//Scenario 7 - Non Registered User  (BUG 39)
            
            /*WebElement email4 = driver.findElement(By.xpath("//input[@id='amplify-id-:r2:']"));
            email4.sendKeys("abcde@yopmail.com");
            
            WebElement password4 = driver.findElement(By.xpath("//input[@id='amplify-id-:r5:']"));
            password4.sendKeys("Test@123");
            
            WebElement signIn4 = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
            signIn4.click(); 
            
            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='amplify-alert__body']")
                ));

                if (alert.getText().contains("500")) {
                    System.out.println("BUG#39_✅ Error Message Detected: " + alert.getText());
                } else {
                    System.out.println("BUG#39_⚠️ Alert found, but message does not match.");
                }*/
            
//Scenario 8 - WEB PAGE TITLE  (BUG 38)            
            
         /*   String actualTitle = driver.getTitle();
            System.out.println("Page Title:" + actualTitle);

            String expectedTitle = "Toothfit-Admin"; 
            if (actualTitle.equals(expectedTitle)) {
                System.out.println("BUG#38_✅ Page title is correct.");
            } else {
                System.out.println("BUG#38_⚠️ Page title mismatch. Found: " + actualTitle);
            }*/
            
            
            
        } catch (Exception e) {
            System.out.println("❌ Test Failed: " + e.getMessage());
        } 
    }
}
