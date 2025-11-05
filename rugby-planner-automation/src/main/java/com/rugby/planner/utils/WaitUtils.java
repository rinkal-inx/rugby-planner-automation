package com.rugby.planner.utils;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class WaitUtils {
    public static WebElement waitForElementVisible(WebDriver driver, By planLink, int timeoutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(planLink));
    }

    public static void waitForElementClickable(WebDriver driver, By createSessionButton, int timeoutSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.elementToBeClickable(createSessionButton));
    }

	public static void waitForInvisibility(WebDriver driver, By xpath, int i) {
		// TODO Auto-generated method stub
		
	}
  
}
