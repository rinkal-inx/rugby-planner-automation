package com.rugby.planner.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    
    private By signinButton = By.xpath("//a[normalize-space()='Sign in']");
    private By emailField = By.xpath("//input[@type='email']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By loginButton = By.xpath("//button[normalize-space()='Sign in']");
    private By loginError = By.xpath("//div[contains(text(),'Email not registered') or contains(text(),'Invalid credentials')]");
    private By emailError = By.id("email-error");   
    private By passwordError = By.id("password-error");
    


    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
        public void login(String email, String password) {
        	driver.findElement(signinButton).click();
            driver.findElement(emailField).sendKeys(email);
            driver.findElement(passwordField).sendKeys(password);
            driver.findElement(loginButton).click();
        }
        
        public void clickLogin() {
        	driver.findElement(signinButton).click();
        	driver.findElement(loginButton).click();
        }
        
        public String getLoginErrorMessage() {
            return driver.findElement(loginError).getText();
        }

        public String getEmailValidationMessage() {
            return driver.findElement(emailError).getText();
        }

        public String getPasswordValidationMessage() {
            return driver.findElement(passwordError).getText();
        }
}