package com.rugby.planner.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.rugby.planner.base.BaseTest;
import com.rugby.planner.config.ConfigReader;
import com.rugby.planner.pages.LoginPage;
import com.rugby.planner.pages.LogoutPage;

public class LogoutTest extends BaseTest {
	
	 @Test(priority = 1)
	    public void verifyCoachSharingFlow() throws InterruptedException {
	       
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
	    Thread.sleep(3000);

    
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.clickLogoutLink();
        Assert.assertTrue(logoutPage.isConfirmationModalDisplayed(),
                "❌ Logout confirmation modal should be visible.");
        
        LogoutPage logoutPage2 = new LogoutPage(driver);
        logoutPage2.clickLogoutButton();
        Assert.assertTrue(logoutPage2.isConfirmationModalDisplayed(),
        		"❌ Logout button modal should be visible.");
   
        LogoutPage logoutPage1 = new LogoutPage(driver);
        logoutPage1.clickLogoutLink();
        Assert.assertTrue(logoutPage1.isConfirmationModalDisplayed(),
                "❌ Logout confirmation modal not displayed before confirming logout.");

        logoutPage1.confirmLogout();
        Assert.assertTrue(logoutPage1.isOnLoginPage(),
                "❌ User not redirected to login page after logout.");
	 }
    }
