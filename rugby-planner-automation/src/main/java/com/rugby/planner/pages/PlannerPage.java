package com.rugby.planner.pages;

import com.rugby.planner.utils.WaitUtils;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PlannerPage {

    WebDriver driver;

    // --- LOCATORS ---
    private By menuPlanner = By.xpath("//span[normalize-space()='My Plans']");

    // --- Create Plan ---
    private By createPlanButton = By.xpath("//button[@id='plan_create_btn']");
    private By teamDropdown = By.xpath("//select[@name='team_id']");
    private By planNameField = By.xpath("//input[@placeholder='Enter plan name']");
    //private By coachNameField = By.xpath("//input[@placeholder='Enter coach name']");
    //private By ageGroupField = By.xpath("//input[@placeholder='Enter age group']");
    private By planLogoUpload = By.xpath("//input[@type='file']");
    private By createPlanSaveBtn = By.xpath("//button[normalize-space()='Create']");
    

    // --- Create Session ---
    private By createSessionButton = By.xpath("//button[@id='session_create_btn']");
    private By sessionNameField = By.xpath("//input[@placeholder='Enter session name']");
    private By sessionCreateBtn = By.xpath("//button[normalize-space()='Create']");


    // --- Add Drill to Session ---
    private By addDrillButton = By.xpath("//button[@id='drill_create_btn']");
    private By drillNameField = By.xpath("//input[@name='name' and @placeholder='Enter drill name']");
    private By drillVideoTypeDropdown = By.xpath("//select[@name='session_drill_type']");
    private By drillDatePicker = By.xpath("//input[@id='plan_session_drill_date']");
    private By drillDurationField = By.xpath("//input[@placeholder='Please enter duration (in minute)']");
    private By notesCheckbox = By.xpath("//input[@id='default-radio-1']");
    private By notesTextBox = By.xpath("//textarea[@placeholder='Write note here']");
    private By audioCheckbox = By.xpath("//input[@id='default-radio-2']");
    private By audioUpload = By.xpath("//input[@type='file']");
    private By createDrillBtn = By.xpath("//button[normalize-space()='Create']");

    private By successMessage = By.xpath("//div[contains(@id, 'toast-success')]");

    // --- Constructor ---
    public PlannerPage(WebDriver driver) {
        this.driver = driver;
    }

    // --- Actions ---
    public void navigateToPlanner() {
        WaitUtils.waitForElementVisible(driver, menuPlanner, 10);
        driver.findElement(menuPlanner).click();
    }

    public void createPlan(String planName, String logoPath) {
        driver.findElement(createPlanButton).click();
        new Select(driver.findElement(teamDropdown)).selectByVisibleText("Rookie’s Team");
        driver.findElement(planNameField).sendKeys(planName);
        //driver.findElement(coachNameField).sendKeys(coachName);
        //driver.findElement(ageGroupField).sendKeys(ageGroup);
        driver.findElement(planLogoUpload).sendKeys(logoPath);
        driver.findElement(createPlanSaveBtn).click();
    }
    public void openPlan(String planName) {
        By planCard = By.xpath("//h2[normalize-space()='" + planName + "']/ancestor::div[contains(@class,'relative')]");
        WaitUtils.waitForElementVisible(driver, planCard, 15);

        WebElement planLink = driver.findElement(planCard).findElement(By.xpath(".//a[contains(@class,'absolute')]"));
        WaitUtils.waitForElementClickable(driver, By.xpath(".//a[contains(@class,'absolute')]"), 10);
        planLink.click();

        System.out.println("✅ Clicked on plan: " + planName);
    }

    public void createSession(String sessionName) {
        WaitUtils.waitForElementClickable(driver, createSessionButton, 10);
        driver.findElement(createSessionButton).click();
        driver.findElement(sessionNameField).sendKeys(sessionName);
        driver.findElement(sessionCreateBtn).click();
    }
    
    public void openSession(String sessionName) {
        By sessionLink = By.xpath("//a[normalize-space()='" + sessionName + "']");
        WaitUtils.waitForElementClickable(driver, sessionLink, 15);

        driver.findElement(sessionLink).click();
        System.out.println("✅ Clicked on session: " + sessionName);
    }

    public void addDrill(String drillName, String videoType, String date, String duration, boolean addNotes, String notes, boolean addAudio, String audioPath) {
        driver.findElement(addDrillButton).click();
        WaitUtils.waitForElementVisible(driver, drillNameField,10);
    	driver.findElement(drillNameField).sendKeys(drillName);
        new Select(driver.findElement(drillVideoTypeDropdown)).selectByVisibleText(videoType);
        
     // --- Handle "Upload from my drill" popup ---
        try {
            // Wait until popup visible
            WaitUtils.waitForElementVisible(driver, By.xpath("//h3[normalize-space()='My Drills']"), 10);
            // Find the first drill title (not the video thumbnail)
            WebElement firstDrillTitle = driver.findElement(
                By.xpath("(//div[contains(@class,'vault_drill_select')])[1]//h3")
            );
            // Ensure element is visible and scrolled into view using Actions only
            Actions actions = new Actions(driver);
            actions.moveToElement(firstDrillTitle).pause(Duration.ofMillis(300)).click().perform();
            System.out.println("✅ Drill title clicked successfully in popup.");
            // Wait until popup disappears (optional, prevents interception in next step)

        } catch (Exception e) {
            System.out.println("⚠️ Drill popup selection failed: " + e.getMessage());
        }


        driver.findElement(drillDatePicker).sendKeys(date);
        driver.findElement(drillDurationField).sendKeys(duration);

        if (addNotes) {
            driver.findElement(notesCheckbox).click();
            driver.findElement(notesTextBox).sendKeys(notes);
        }

        if (addAudio) {
            driver.findElement(audioCheckbox).click();
            driver.findElement(audioUpload).sendKeys(audioPath);
        }

        driver.findElement(createDrillBtn).click();
    }

    public String getSuccessMessage() {
        return WaitUtils.waitForElementVisible(driver, successMessage, 10).getText().trim();
    }
}
