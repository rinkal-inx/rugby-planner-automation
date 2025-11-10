package com.rugby.planner.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.rugby.planner.utils.WaitUtils;

public class ShareCoach {
	
	static WebDriver driver;
	
	private final By sharePlannerButton = By.xpath("//span[@class='ml-3'][normalize-space()='Invite Coaches']");
	private final By inviteCoach = By.xpath("//button[@id='invite_coach_create_btn']");
	private final By teamDropdown = By.xpath("//select[@id='team_id']");
    private final By nameField = By.xpath("//input[@placeholder='Name']");
    private final By emailField = By.xpath("//input[@placeholder='Email']");
    private final By accessDropdown = By.xpath("(//select[@name='invited_coaches[0][role]'])[1]");
    private final By sendInviteButton = By.xpath("//button[normalize-space()='Invite']");
    private final By successMessage = By.xpath("//div[contains(.,'User has been invited successfully.') or contains(.,'shared successfully')]");
    private final By teamCards = By.xpath("//div[contains(@class,'scrollableArea')]//h2");
    private final By teamCardWrapper = By.xpath("//div[contains(@class,'scrollableArea')]//div[contains(@class,'bg-primary-100')]");
    private final By coachTableRows = By.xpath("//table[contains(@class,'min-w-full')]//tbody/tr");
    private By teamNameLocator = By.cssSelector("h2.text-gray-900");
    private static By tableRows = By.cssSelector("tbody tr");
    private static By nameColumn = By.cssSelector("td:nth-child(1)");
    private static By emailColumn = By.cssSelector("td:nth-child(2)");
    private static By inviteDateColumn = By.cssSelector("td:nth-child(3)");
    private static By teamNameColumn = By.cssSelector("td:nth-child(4)");
    private static By roleColumn = By.cssSelector("td:nth-child(5)");
    private static By statusColumn = By.cssSelector("td:nth-child(6)");
    private static By actionColumn = By.cssSelector("td:nth-child(7)");


    public ShareCoach (WebDriver driver) {
        this.driver = driver;
    }

    // --- Actions ---
    public void navigateToCoach() {
        WaitUtils.waitForElementVisible(driver, sharePlannerButton, 10);
        driver.findElement(sharePlannerButton).click();
    }

    public void fillInviteForm(String name, String email) throws InterruptedException {
    	driver.findElement(inviteCoach).click();
    	Thread.sleep(2000);
        new Select(driver.findElement(teamDropdown)).selectByVisibleText("Roman's Team");
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        System.out.println("DATA SELECTED");
        
        Select accessSelect = new Select(driver.findElement(accessDropdown));
        accessSelect.selectByVisibleText("Full Access");
        System.out.println("ACCESS SELECTED");
        Thread.sleep(3000);
        driver.findElement(sendInviteButton).click();
   
        WaitUtils.waitForElementVisible(driver, successMessage, 15);
        System.out.println("User has been invited successfully.");
    }
    
    public void clickOnTeamName(String teamName) {
    	WebElement teamElement = driver.findElement(By.xpath("//h2[contains(text(), \"" + teamName + "\")]/ancestor::div[contains(@class,'bg-primary-100')]//a"));
        teamElement.click();
    }
    
    public static  List<WebElement> getTableRows() {
        return driver.findElements(tableRows);
    }

    public static String getName(WebElement row) {
        return row.findElement(nameColumn).getText().trim();
    }

    public static String getEmail(WebElement row) {
        return row.findElement(emailColumn).getText().trim();
    }

    public static String getInviteDate(WebElement row) {
        return row.findElement(inviteDateColumn).getText().trim();
    }

    public static String getTeamName(WebElement row) {
        return row.findElement(teamNameColumn).getText().trim();
    }

    public static String getRole(WebElement row) {
        return row.findElement(roleColumn).getText().trim();
    }

    public static String getStatus(WebElement row) {
        return row.findElement(statusColumn).getText().trim();
    }

    public static String getAction(WebElement row) {
        return row.findElement(actionColumn).getText().trim();
    }
    
 // Verify if coach appears in the list
  /*  public boolean isCoachVisible(String name) {
        List<WebElement> coaches = driver.findElements(teamCards);
        for (WebElement coach : coaches) {
            if (coach.getText().trim().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }*/	
}