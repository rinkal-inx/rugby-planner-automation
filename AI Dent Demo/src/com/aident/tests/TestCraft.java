package com.aident.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCraft {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://php.inheritxdev.in/rugby_planner/qa");
		driver.manage().window().maximize();
		
		WebElement signin = driver.findElement(By.xpath("//a[normalize-space()='Sign in']"));
		signin.click();
		
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		email.sendKeys("roman.wise@yopmail.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("Test@123");
		
		WebElement login = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
		login.click();
		
		WebElement inviteCoach = driver.findElement(By.xpath("//span[contains(@class,'ml-3')][normalize-space()='Invite Coaches']"));
		inviteCoach.click();
		
		WebElement teamCardLink = driver.findElement(By.cssSelector("a.absolute"));
		teamCardLink.click();
		
		WebElement teamName = driver.findElement(By.cssSelector("h2.text-gray-900"));
		teamName.click();
		

	}

}
