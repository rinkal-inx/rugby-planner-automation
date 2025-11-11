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
    private final By confirmLogoutButton = By.cssSelector("button.confirm-logout");
    private final By loginButton = By.xpath("//button[contains(text(),'Login')]"); // verify redirect to login

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    /** Click logout link (opens confirmation modal) */
    public void clickLogoutLink() {
        WaitUtils.waitForElementClickable(driver, logoutLink, 20);
        driver.findElement(logoutLink).click();
    }
    
    public void clickLogoutButton() {
        WaitUtils.waitForElementClickable(driver, logoutButton, 20);
        driver.findElement(logoutButton).click();
    }

    /** Check if logout confirmation modal is displayed */
    public boolean isConfirmationModalDisplayed() {
        WaitUtils.waitForElementVisible(driver, confirmationModal, 10);
        return driver.findElement(confirmationModal).isDisplayed();
    }

    /** Confirm logout */
    public void confirmLogout() {
        WaitUtils.waitForElementClickable(driver, confirmLogoutButton, 10);
        driver.findElement(confirmLogoutButton).click();
    }

    /** Verify if user is redirected to login page */
    public boolean isOnLoginPage() {
        WaitUtils.waitForElementVisible(driver, loginButton, 10);
        return driver.getCurrentUrl().contains("login");
    }
}
