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

public class Multi_login {

    public static void main(String[] args) {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        List<Map<String, String>> credentialsList = new ArrayList<>();

        
        credentialsList.add(Map.of("admindoctor@yopmail.com", "Test@123"));
        credentialsList.add(Map.of("webdoctor@yopmail.com", "Test@123"));
        credentialsList.add(Map.of("mobdoctor@yopmail.com", "Test@123"));
        
        for (Map<String, String> creds : credentialsList) {
        try {
            driver.get("https://dev.d22be1jj19bmim.amplifyapp.com/");
            driver.manage().window().maximize();
            
            driver.findElement(By.name("email")).sendKeys(creds.get("username"));
            driver.findElement(By.name("password")).sendKeys(creds.get("password"));
            driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		
        } catch (Exception e) {
            System.out.println("❌ Test Failed: " + e.getMessage());
        } 
    }
  }
}
