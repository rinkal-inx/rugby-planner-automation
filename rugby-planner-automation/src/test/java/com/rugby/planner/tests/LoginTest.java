package com.rugby.planner.tests;

import com.rugby.planner.base.BaseTest;
import com.rugby.planner.config.ConfigReader;
import com.rugby.planner.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void verifyValidLogin() {
        System.out.println("🚀 Starting Login Test...");

        
        LoginPage loginPage = new LoginPage(driver);
        String email = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        loginPage.login(email, password);
        
        String currentURL = driver.getCurrentUrl();
        System.out.println("✅ Login successful, current page URL: " + currentURL);
    }
        
    @Test(priority = 2)
    public void loginwithInvalidcredential() {
    	LoginPage loginPage = new LoginPage(driver);

        // Enter invalid credentials
        loginPage.login("wrong@example.com", "wrongpass");

        // Verify error message
        String errorMsg = loginPage.getLoginErrorMessage();
        Assert.assertEquals(errorMsg, "Email not registered with us");
    }
        
    @Test(priority = 3)
        public void loginWithEmptyFields() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickLogin();

            Assert.assertEquals(loginPage.getEmailValidationMessage(), "This field is required.");
            Assert.assertEquals(loginPage.getPasswordValidationMessage(), "This field is required.");
    }
}
