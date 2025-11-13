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
	  try { 
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
	    Thread.sleep(3000);
	    
	    LogoutPage logoutpage = new LogoutPage(driver);
	    
	    logoutpage.navigateToLogoutlink();
	    System.out.println("Navigated to Logout dropdown");
	    
	    logoutpage.clickLogoutButton();
	    System.out.println("Logout button clicked");
	    
	    logoutpage.displayconfirmationModal();
	    System.out.println("Logout pop up appears");
	    
	    logoutpage.clickConfirmbutton();
	    System.out.println("Logout confirmed");
	    
	    logoutpage.displaySigninPage();
	    System.out.println("Signin page appeared");
	  }catch(Exception e) {
		  System.out.println("Logout test failed" + e.getMessage());
		  captureScreenshot("verifyLogoutFunctionality");
		  Assert.fail("Exception during logout test"+e.getMessage());
	  }			 
   }
}
