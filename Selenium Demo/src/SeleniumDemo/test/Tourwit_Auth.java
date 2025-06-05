package SeleniumDemo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Tourwit_Auth {
    public static void main(String[] args) {
        // Setup ChromeDriver
    	WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            
            driver.get("https://tourwit-eu.inheritxdev.in/home");

            driver.manage().window().maximize();
            
//Scenario 1 -- Log In -- Log In with valid credentials
            
         /* WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space(text())='Login']"));
            loginButton.click();

            Thread.sleep(2000); 

            WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
            emailField.sendKeys("und4@yopmail.com");

            WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
            passwordField.sendKeys("Inx@!123");

            WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Login to your account']"));
            submitButton.click();

            Thread.sleep(5000);

            if (driver.getCurrentUrl().contains("home") || driver.getPageSource().contains("Logout")) {
                System.out.println("✅ Login Test Passed: Successfully logged in.");
            } else {
                System.out.println("❌ Login Test Failed: Login was not successful.");
            }*/
        
 //Scenario 2 -- Log In --- Log In with blank password followed by invalid password.

   /*   WebElement loginButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Login']")));
        loginButton1.click(); 

        Thread.sleep(2000); 

        WebElement emailField1 = driver.findElement(By.xpath("//input[@id='email']"));
        emailField1.sendKeys("und4@yopmail.com");

        WebElement passwordField1 = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField1.sendKeys("");

        WebElement submitButton1 = driver.findElement(By.xpath("//button[normalize-space()='Login to your account']"));
        submitButton1.click();    

        Thread.sleep(5000); 
        
        if (driver.getPageSource().contains("This field is required")) {
            System.out.println("✅ Login Test Passed: Blank password error visible.");
        } else {
            System.out.println("❌ Login Test Failed: No error for blank password.");
        }
  
        driver.navigate().refresh();

        WebElement loginButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Login']")));
        loginButton2.click();
        
        WebElement emailField2 = driver.findElement(By.xpath("//input[@id='email']"));
        emailField2.sendKeys("und4@yopmail.com");

        WebElement passwordField2 = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField2.sendKeys("123456");

        WebElement submitButton2 = driver.findElement(By.xpath("//button[normalize-space()='Login to your account']"));
        submitButton2.click();    
        
        Thread.sleep(3000);

        if (driver.getPageSource().contains("Password must be at least 8 characters long")) {
            System.out.println("✅ Login Test Passed: Incorrect Password error visible");
        } else {
            System.out.println("❌ Login Test Failed: Login was successful.");
        }
    }*/
            
//Scenario 3 -- Log In -- Forgot Password link clickable and respondable.  
            
     /*    WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
             By.xpath("//button[normalize-space(text())='Login']")));
           loginButton.click();

            WebElement forgotLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space()='Forgot your password?']")));

            forgotLink.click();
            
            Thread.sleep(4000);

            if (driver.getPageSource().contains("Forgot Password")) {
                System.out.println("✅ Test Passed: Forgot Password link is clickable and responded.");
            } else {
                System.out.println("❌ Test Failed: Forgot Password link clicked but no response.");
            }*/
            
//Scenario 3A -- apply manual xpath without using selectorshub            
            
                /*WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                  By.xpath("//button[text()='Login']")));
                  loginButton.click();

                   WebElement forgotLink = wait.until(ExpectedConditions.elementToBeClickable(
                       By.xpath("//a[text()='Forgot your password?']")));

                   forgotLink.click();
                   
                   Thread.sleep(4000);

                   if (driver.getPageSource().contains("Forgot Password")) {
                       System.out.println("✅ Test Passed: Forgot Password link is clickable and responded.");
                   } else {
                       System.out.println("❌ Test Failed: Forgot Password link clicked but no response.");
                   }*/
            
//Scenario 4 -- Log In -- Clicking on Sign Up, It should redirect to the Sign Up page.
            
       /*      WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[normalize-space(text())='Login']")));
                loginButton.click();

                WebElement signUp = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[normalize-space()='Sign up']")));

                signUp.click();
                
                Thread.sleep(4000);

                if (driver.getPageSource().contains("Create Account")) {
                    System.out.println("✅ Test Passed: Sign Up page opens up.");
                } else {
                    System.out.println("❌ Test Failed: No response");
                }*/      

//Scenario 5 -- Log In -- Logging In with non registered/incorrect email.
    /*      WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space(text())='Login']"));
            loginButton.click();

            Thread.sleep(2000); // wait for modal to open

            WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
            emailField.sendKeys("noemail@yopmail.com");

            WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
            passwordField.sendKeys("Inx@!123");

            WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Login to your account']"));
            submitButton.click();
            
            Thread.sleep(3000);

            if (driver.getPageSource().contains("Invalid email or password")) {
                System.out.println("✅ Login Test Passed: Successfully logged in.");
            } else {
                System.out.println("❌ Login Test Failed: Login was not successful.");
            }*/
            
            
//Scenario 6 -- Sign Up
            
         /* WebElement signUpButton = driver.findElement(By.xpath("//button[normalize-space(text())='Sign up']"));
            signUpButton.click();
            
            WebElement firstnameField = driver.findElement(By.xpath("//input[@id='firstName']"));
            firstnameField.sendKeys("Test");
            
            WebElement lastnameField = driver.findElement(By.xpath("//input[@id='lastName']"));
            lastnameField.sendKeys("Tourwit");
            
            WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
            emailField.sendKeys("und10@yopmail.com"); 
            
            WebElement instagramField = driver.findElement(By.xpath("//input[@id='instagramId']"));
            instagramField.sendKeys("testtourwit123");
            
            driver.findElement(By.xpath("//input[@id='react-select-lazy-country-input']")).sendKeys("India");
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'option') and text()='India']"))).click();
            
            WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
            passwordField.sendKeys("Inx@!123");
            
            WebElement confirmpasswordField = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
            confirmpasswordField.sendKeys("Inx@!123");
            
            WebElement termconditionCheckbox = driver.findElement(By.xpath("//input[@id='ToCAgreed']"));
            termconditionCheckbox.click();
            
            WebElement createaccButton = driver.findElement(By.xpath("//button[normalize-space()='Create account']"));
            createaccButton.click();
            
            if (driver.getPageSource().contains("Verification email")) {
            System.out.println("Account created successfully.");
            } else {
             System.out.println("Issue with Account creation.");}   
        }*/
            
//Scenario 6A Sign up using manual xpath without using selectorshub
            
         /* WebElement signUpButton = driver.findElement(By.xpath("//button[text()='Sign up']"));
            signUpButton.click();
            
            WebElement firstnameField = driver.findElement(By.xpath("//input[@id='firstName']"));
            firstnameField.sendKeys("Test");
            
            WebElement lastnameField = driver.findElement(By.xpath("//input[@id='lastName']"));
            lastnameField.sendKeys("Tourwit");
            
            WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
            emailField.sendKeys("und11@yopmail.com"); 
            
            WebElement instagramField = driver.findElement(By.xpath("//input[@id='instagramId']"));
            instagramField.sendKeys("testtourwit123");
            
            driver.findElement(By.xpath("//input[@id='react-select-lazy-country-input']")).sendKeys("India");
            
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[(text()='India')]"))).click();
            
            WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
            passwordField.sendKeys("Inx@!123");
             
            WebElement confirmpasswordField = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
            confirmpasswordField.sendKeys("Inx@!123");
            
            WebElement termconditionCheckbox = driver.findElement(By.xpath("//input[@id='ToCAgreed']"));
            termconditionCheckbox.click();
            
            WebElement createaccButton = driver.findElement(By.xpath("//button[text()='Create account']"));
            createaccButton.click();
            
            if (driver.getPageSource().contains("India")) {
            System.out.println("Account created successfully.");
            } else {
            	System.out.println("Issue with Account creation.");
            }*/
            
//Scenario 7  Enter data to the budget trip fields.      
 
          /*WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#selectCountry .css-kq2ovp-control")));
            countryDropdown.click();

            WebElement countryInput = driver.findElement(By.cssSelector("#selectCountry input[aria-autocomplete='list']"));
            countryInput.sendKeys("India");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'India')]"))).click();

            WebElement cityDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#selectCity .css-kq2ovp-control")));
            cityDropdown.click();

            WebElement cityInput = driver.findElement(By.cssSelector("#selectCity input[aria-autocomplete='list']"));
            cityInput.sendKeys("Abu");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Abu')]"))).click();

            WebElement daysInput = driver.findElement(By.cssSelector("input[placeholder='Types days']"));
            daysInput.sendKeys("5");
           
            WebElement selectTravellers = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("whereSelectCity")));
            selectTravellers.click();

            WebElement adultPlusButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class, 'flex') and contains(@class, 'cursor-pointer')]//svg")));

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", adultPlusButton);

                adultPlusButton.click(); // First increase
                adultPlusButton.click(); // Second increase

                WebElement doneButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(), 'Done')]")));

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", doneButton);

                doneButton.click();
                
                if (driver.getPageSource().contains("Estimated Cost for Your Trip")) {
                System.out.println("✅ Result shown successfully.");
            } else {
                System.out.println("⚠️ Issue with result data.");
            }*/
            
            
 // Scenario 8 : Search Budget result
       

           /* WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#selectCountry .css-kq2ovp-control")));
            countryDropdown.click();

            WebElement countryInput = driver.findElement(By.cssSelector("#selectCountry input[aria-autocomplete='list']"));
            countryInput.sendKeys("India");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'India')]"))).click();

            WebElement cityDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#selectCity .css-kq2ovp-control")));
            cityDropdown.click();

            WebElement cityInput = driver.findElement(By.cssSelector("#selectCity input[aria-autocomplete='list']"));
            cityInput.sendKeys("Abu");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Abu')]"))).click();
            
            WebElement daysInput = driver.findElement(By.xpath("//input[@placeholder='Types days']"));
            daysInput.sendKeys("2");

            WebElement travellerInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[text()='Travellers']/following::div[contains(text(),'Select Travellers')]")
            ));
            travellerInput.click();

            WebElement plusAdultBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(text(),'Adults')]/following-sibling::div//div[contains(@class,'cursor-pointer')][2]")
            ));
            plusAdultBtn.click();
            plusAdultBtn.click();

            WebElement doneBtn = driver.findElement(By.xpath("//button[contains(text(),'Done')]"));
            doneBtn.click();
            
            WebElement searchButton = driver.findElement(By.xpath("//div[@id='resultsToggleButton']"));
            searchButton.click();
            
            Thread.sleep(3000);
            
            if (driver.getPageSource().contains("Estimated Cost for Your Trip")) {
                System.out.println("✅ Result shown successfully.");
            } else {
                System.out.println("⚠️ Issue with result data.");
            } */
            
 // Scenario 9 Change currency

       /*   WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#selectCountry .css-kq2ovp-control")));
            countryDropdown.click();

            WebElement countryInput = driver.findElement(By.cssSelector("#selectCountry input[aria-autocomplete='list']"));
            countryInput.sendKeys("India");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'India')]"))).click();

            WebElement cityDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#selectCity .css-kq2ovp-control")));
            cityDropdown.click();

            WebElement cityInput = driver.findElement(By.cssSelector("#selectCity input[aria-autocomplete='list']"));
            cityInput.sendKeys("Abu");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Abu')]"))).click();

            WebElement daysInput = driver.findElement(By.xpath("//input[@placeholder='Types days']"));
            daysInput.sendKeys("2");

            WebElement travellerInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[text()='Travellers']/following::div[contains(text(),'Select Travellers')]")
            ));
            travellerInput.click();

            WebElement plusAdultBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(text(),'Adults')]/following-sibling::div//div[contains(@class,'cursor-pointer')][2]")
            ));
            plusAdultBtn.click();
            plusAdultBtn.click();

            WebElement doneBtn = driver.findElement(By.xpath("//button[contains(text(),'Done')]"));
            doneBtn.click();
            
            WebElement searchButton = driver.findElement(By.xpath("//div[@id='resultsToggleButton']"));
            searchButton.click();
            
            Thread.sleep(3000);
            
            WebElement currencyDropdownTrigger = wait.until(ExpectedConditions.elementToBeClickable(
            	    By.xpath("//div[contains(@class,'expense-card')]//p[contains(text(),'Average daily expense')]/following-sibling::button//span[contains(@class,'inline-flex')]")
            	));
            	currencyDropdownTrigger.click();
            
            Thread.sleep(3000);
 
            	WebElement newCurrencyOption = wait.until(ExpectedConditions.elementToBeClickable(
            	    By.xpath("//div[@class='expense-card relative text-center']//span[@class='font-work-sans'][normalize-space()='(£)']") 
            	));
            	
            	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", newCurrencyOption);
            	
            	newCurrencyOption.click();
            
            WebElement change = driver.findElement(By.xpath("//div[@class='expense-card relative text-center']//button[@class='rounded-lg bg-[#58B84D] px-2 py-2 text-sm text-white'][normalize-space()='Change']"));
            change.click();
            
            Thread.sleep(3000);
            
            if (driver.getPageSource().contains("£")) {
                System.out.println("✅ Result shown successfully.");
            } else {
                System.out.println("⚠️ Issue with result data.");
            }*/
            
//Scenario 10 Calculation of budget by selecting other options in Traveller pop up module.

             /*WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#selectCountry .css-kq2ovp-control")));
             countryDropdown.click();

             WebElement countryInput = driver.findElement(By.cssSelector("#selectCountry input[aria-autocomplete='list']"));
             countryInput.sendKeys("India");

             wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'India')]"))).click();

             WebElement cityDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#selectCity .css-kq2ovp-control")));
             cityDropdown.click();

             WebElement cityInput = driver.findElement(By.cssSelector("#selectCity input[aria-autocomplete='list']"));
             cityInput.sendKeys("Abu");

             wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Abu')]"))).click();
             
             WebElement daysInput = driver.findElement(By.xpath("//input[@placeholder='Types days']"));
             daysInput.sendKeys("2");

             WebElement travellerInput = wait.until(ExpectedConditions.elementToBeClickable(
                 By.xpath("//label[text()='Travellers']/following::div[contains(text(),'Select Travellers')]")
             ));
             travellerInput.click();

             WebElement travelerDropdown = wait.until(ExpectedConditions.elementToBeClickable(
            		    By.xpath("//div[contains(text(),'Select Travelers')]/following-sibling::div//select")
            		));
            		Select travelerSelect = new Select(travelerDropdown);
            		travelerSelect.selectByVisibleText("Family");

            		WebElement budgetDropdown = wait.until(ExpectedConditions.elementToBeClickable(
            		    By.xpath("//div[contains(text(),'Select Budget')]/following-sibling::div//select")
            		));
            		Select budgetSelect = new Select(budgetDropdown);
            		budgetSelect.selectByVisibleText("Luxury");
             
             WebElement plusParentsBtn = wait.until(ExpectedConditions.elementToBeClickable(
                 By.xpath("//div[contains(text(),'Parents')]/following-sibling::div//div[contains(@class,'cursor-pointer')][2]")
             ));
             plusParentsBtn.click();
             plusParentsBtn.click();
             
             WebElement plusChildrenBtn = wait.until(ExpectedConditions.elementToBeClickable(
                     By.xpath("//div[contains(text(),'Children')]/following-sibling::div//div[contains(@class,'cursor-pointer')][2]")
                 ));
                 plusChildrenBtn.click();
                 plusChildrenBtn.click();

             WebElement doneBtn = driver.findElement(By.xpath("//button[contains(text(),'Done')]"));
             doneBtn.click();
             
             WebElement searchButton = driver.findElement(By.xpath("//div[@id='resultsToggleButton']"));
             searchButton.click();
             
             Thread.sleep(3000);
             
             if (driver.getPageSource().contains("Estimated Cost for Your Trip")) {
                 System.out.println("✅ Result shown successfully.");
             } else {
                 System.out.println("⚠️ Issue with result data.");
             } */
            
            
 // Scenario 11     Add to cart product from home page
            
            /*WebElement loginButton = wait.until (ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Login']")));
            loginButton.click();

            WebElement emailField = wait.until (ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
            emailField.sendKeys("und4@yopmail.com");

            WebElement passwordField = wait.until (ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
            passwordField.sendKeys("Inx@!123");

            WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Login to your account']"));
            submitButton.click();

            Thread.sleep(5000);
            
            WebElement targetElement = driver.findElement(By.id("shop_slider")); // or By.xpath, By.cssSelector, etc.

            // Scroll to the element
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
            
            WebElement addtoCart = driver.findElement(By.xpath("//div[@class='slick-slide slick-active slick-current']//div//button[@type='button'][normalize-space()='Add to cart']"));
            addtoCart.click();

            if (driver.getPageSource().contains("1")) {
                System.out.println("✅ Result shown successfully.");
            } else {
                System.out.println("⚠️ Issue with result data.");
            } */
            
//Scenario 11   Add to cart product from product page.
            
            /*WebElement loginButton = wait.until (ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Login']")));
            loginButton.click();

            WebElement emailField = wait.until (ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
            emailField.sendKeys("und4@yopmail.com");

            WebElement passwordField = wait.until (ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
            passwordField.sendKeys("Inx@!123");

            WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Login to your account']"));
            submitButton.click();

            Thread.sleep(5000);
            
            WebElement targetElement = driver.findElement(By.id("shop_slider")); // or By.xpath, By.cssSelector, etc.

            // Scroll to the element
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
            
            WebElement productPage = driver.findElement(By.cssSelector("div.slick-slide[data-index='1']"));
            productPage.click();
            
            WebElement addtoCart1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add to Cart']")));
            addtoCart1.click();

            if (driver.getPageSource().contains("Cart updated successfully")) {
                System.out.println("✅ Result shown successfully.");
            } else {
                System.out.println("⚠️ Issue with result data.");
            } */
            
// Scenario 13 Update quantity in product page and add to the cart
            
            /*WebElement loginButton = wait.until (ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Login']")));
            loginButton.click();

            WebElement emailField = wait.until (ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
            emailField.sendKeys("und4@yopmail.com");

            WebElement passwordField = wait.until (ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
            passwordField.sendKeys("Inx@!123");

            WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Login to your account']"));
            submitButton.click();

            Thread.sleep(5000);
            
            WebElement targetElement = driver.findElement(By.id("shop_slider")); // or By.xpath, By.cssSelector, etc.

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
            
            WebElement productPage = driver.findElement(By.cssSelector("div.slick-slide[data-index='1']"));
            productPage.click();
            
            WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@class,'items-center')]/button[2]")));
                
                plusButton.click();
                plusButton.click();
            
            WebElement addtoCart1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add to Cart']")));
            addtoCart1.click();

            if (driver.getPageSource().contains("Cart updated successfully")) {
                System.out.println("✅ Result shown successfully.");
            } else {
                System.out.println("⚠️ Issue with result data.");
            } */
            
            
// Scenario 14 Go to 'Where Next' page
            
            /*WebElement loginButton = wait.until (ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Login']")));
            loginButton.click();

            WebElement emailField = wait.until (ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
            emailField.sendKeys("und4@yopmail.com");

            WebElement passwordField = wait.until (ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
            passwordField.sendKeys("Inx@!123");

            WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Login to your account']"));
            submitButton.click();

            Thread.sleep(5000);
            
            WebElement whereNextButton = driver.findElement(By.xpath("//div[@class='container relative z-20']"));

            // Scroll to the button using JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", whereNextButton);
            
            WebElement whereNext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='container relative z-20']//button[contains(text(),'Where Next')]")));
            whereNext.click();
            
            Thread.sleep(5000);

            if (driver.getPageSource().contains("Abu")) {
                System.out.println("✅ Result shown successfully.");
            } else {
                System.out.println("⚠️ Issue with result data.");
            }*/ 
            
// Scenario 15 Go to 'Where Next' page and search for a bucket list
            
           /* WebElement whereNextButton = driver.findElement(By.xpath("//div[@class='container relative z-20']"));

            // Scroll to the button using JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", whereNextButton);
            
            WebElement whereNext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='container relative z-20']//button[contains(text(),'Where Next')]")));
            whereNext.click();
            
            Thread.sleep(5000);
            
            WebElement bucketSection = driver.findElement(By.xpath("//div[@class='relative py-2']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bucketSection);
            
            WebElement selectCountry1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='selectCountry']//div[@class='css-kq2ovp-control']")));
            selectCountry1.click();
            
            WebElement countryInput1 = driver.findElement(By.cssSelector("#selectCountry input[aria-autocomplete='list']"));
            countryInput1.sendKeys("Argentina");
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Argentina')]"))).click();
            
            WebElement selectCity1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='whereSelectCity']//div[@class='css-kq2ovp-control']")));
            selectCity1.click();
            
            WebElement cityInput1 = driver.findElement(By.cssSelector("#whereSelectCity input[aria-autocomplete='list']"));
            cityInput1.sendKeys("Adalaj");
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Adalaj')]"))).click();
            
            WebElement search = driver.findElement(By.cssSelector("#resultsToggleButton"));
            search.click();
            
            Thread.sleep(5000);
            

            if (driver.getPageSource().contains("Adalaj")) {
                System.out.println("✅ Result shown successfully.");
            } else {
                System.out.println("⚠️ Issue with result data.");
            }*/
            
            
//Scenario 16 Product added to cart via Home Page > Country > City > Handicraft Product
            
            WebElement vibrantVistas = driver.findElement(By.xpath("//div[@class='relative overflow-hidden py-8 lg:py-24']"));

            // Scroll to the button using JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", vibrantVistas);
            
            WebElement selectVistas = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slick-slide slick-active slick-current']//div//img[@alt='Cultural Heritage Sites in Japan']")));
            selectVistas.click();
            
            WebElement selectTokyo = driver.findElement(By.xpath("//div[@class='relative overflow-hidden py-8 lg:py-24']"));
            
            Thread.sleep(5000);

            // Scroll to the button using JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectTokyo);
         
            
            WebElement selectTokyo1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Tokyo']")));
            selectTokyo1.click();
            
            Thread.sleep(5000);
            
            WebElement handicraftSection = driver.findElement(By.xpath("//div[@id='shop_slider']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", handicraftSection);
            
            Thread.sleep(5000);
            
            WebElement producttoCart = driver.findElement(By.xpath("//h5[text()='Test One two']/ancestor::div[contains(@class, 'item')]//button[contains(text(), 'Add to cart')]"));
            producttoCart.click();
            
            Thread.sleep(5000);
            
            if (driver.getPageSource().contains("Cart updated successfully")) {
                System.out.println("✅ Result shown successfully.");
            } else {
                System.out.println("⚠️ Issue with result data.");
            }
         
            
        } catch (Exception e) {
            System.out.println("❌ Test Failed: " + e.getMessage());
            
       }
        
    }
    
}
        
    
    


