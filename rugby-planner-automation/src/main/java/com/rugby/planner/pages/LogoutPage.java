package com.rugby.planner.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.rugby.planner.utils.WaitUtils;

public class LogoutPage {
    private WebDriver driver;

    // Locators
    private final By logoutLink = By.xpath("//div[@id='dropdownDefaultButton']");
    private final By logoutButton = By.xpath("//a[normalize-space()='Log Out']");
    private final By confirmationModal = By.id("popup-logout");
    private final By confirmLogoutButton = By.xpath("//a[@data-modal-hide='popup-logout']");
    private final By signinButton = By.xpath("//button[normalize-space()='Sign in']");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLogoutlink() {
    	WaitUtils.waitForElementClickable(driver, logoutLink, 10);
    	driver.findElement(logoutLink).click();
    }
    
    public void clickLogoutButton() {
    	WaitUtils.waitForElementClickable(driver, logoutButton, 10);
    	driver.findElement(logoutButton).click();
    }
    
    public void displayconfirmationModal() {
    	WaitUtils.waitForElementVisible(driver, confirmationModal, 10);
    	driver.findElement(confirmationModal);
    }
    
    public void clickConfirmbutton() {
    	WaitUtils.waitForElementClickable(driver, confirmLogoutButton, 10);
    	driver.findElement(logoutButton).click();
    }
    
    public void displaySigninPage() {
    	WaitUtils.waitForElementVisible(driver, signinButton, 10);
    	driver.findElement(signinButton);
    }
    
}
