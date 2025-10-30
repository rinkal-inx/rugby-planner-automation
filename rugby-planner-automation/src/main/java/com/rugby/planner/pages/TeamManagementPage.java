package com.rugby.planner.pages;

import com.rugby.planner.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TeamManagementPage {

    WebDriver driver;

    // --- LOCATORS (replace with exact ones from your app if different) ---
    private By menuTeamManagement = By.xpath("(//span[@class='ml-3'][normalize-space()='My Teams'])[1]");
    private By addTeamButton = By.xpath("(//button[normalize-space()='Create Team'])[1]");
    private By teamNameField = By.xpath("(//input[@placeholder='Enter team name'])[1]");
    private By coachNameField = By.xpath("(//input[@placeholder='Enter coach Name'])[1]");
    private By uploadButton = By.xpath("(//label[contains(@for,'create_team_logo')])[1]");
    private By imageUploadInput = By.xpath("(//input[@type='file']");
    private By ageGroupField = By.xpath("//input[@placeholder='Enter age group (19-24)'][1]");
    private By saveButton = By.xpath("//button[normalize-space()='Create']");
    private By successMessage = By.xpath("//div[@id='toast-success']");
    private String teamRowByNameXpath = "//div[@class='px-0 relative']";

    // --- Constructor ---
    public TeamManagementPage(WebDriver driver) {
        this.driver = driver;
 
    }
    

    // --- Actions ---
    public void navigateToTeamManagement() {
         driver.findElement(menuTeamManagement).click();
    }

    public void clickAddTeam() {
        WaitUtils.waitForElementClickable(driver, addTeamButton, 10);
        driver.findElement(addTeamButton).click();
    }

    public void enterTeamName(String teamName) {
        WebElement el = WaitUtils.waitForElementVisible(driver, teamNameField, 10);
        el.clear();
        el.sendKeys(teamName);
    }

    public void enterCoachName(String coachName) {
        WebElement el = WaitUtils.waitForElementVisible(driver, coachNameField, 10);
        el.clear();
        el.sendKeys(coachName);
    }

    public void uploadTeamImage() {
    	
        WebElement upload = driver.findElement(By.xpath("//label[@for='create_team_logo']//following::input[@type='file']"));
        upload.sendKeys("/Users/inheritx/Downloads/banner image QC.png");  // absolute path, e.g. "C:\\Users\\...\\team.jpg"
    }

    public void enterAgeGroup(String ageGroup) {
        WebElement el = WaitUtils.waitForElementVisible(driver, ageGroupField, 10);
        el.clear();
        el.sendKeys(ageGroup);
    }

    public void clickSaveButton() {
        WaitUtils.waitForElementClickable(driver, saveButton, 10);
        driver.findElement(saveButton).click();
    }

    public String getSuccessMessage() {
        WebElement el = WaitUtils.waitForElementVisible(driver, successMessage, 10);
        return el.getText().trim();
    }

    public boolean isTeamPresentInList(String teamName) {
        By teamRow = By.xpath(String.format(teamRowByNameXpath, teamName));
        try {
            WaitUtils.waitForElementVisible(driver, teamRow, 10);
            return driver.findElement(teamRow).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
