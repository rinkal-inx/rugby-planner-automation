package com.rugby.planner.pages;

import com.rugby.planner.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DrillVaultPage {

    WebDriver driver;

    // --- LOCATORS ---
    private By menuDrillVault = By.xpath("//li[@class='relative active']//a[1]");
    private By addDrillButton = By.xpath("//button[normalize-space()='Add Drill']");
    private By drillNameField = By.xpath("//input[@placeholder='Enter drill name']");
    private By drillDescriptionField = By.xpath("//textarea[@placeholder='Enter drill description']");
    private By uploadDrillFile = By.xpath("//input[@type='file']");
    private By saveDrillButton = By.xpath("//button[normalize-space()='Save Drill']");
    private By successMessage = By.xpath("//div[contains(@class,'toast-success')]");
    private String drillRowByNameXpath = "//td[contains(text(),'%s')]";

    // --- Constructor ---
    public DrillVaultPage(WebDriver driver) {
        this.driver = driver;
    }

    // --- Actions ---
    public void navigateToDrillVault() {
        WaitUtils.waitForElementClickable(driver, menuDrillVault, 10);
        driver.findElement(menuDrillVault).click();
    }

    public void clickAddDrill() {
        WaitUtils.waitForElementClickable(driver, addDrillButton, 10);
        driver.findElement(addDrillButton).click();
    }

    public void enterDrillDetails(String name, String description, String filePath) {
        WebElement nameEl = WaitUtils.waitForElementVisible(driver, drillNameField, 10);
        nameEl.clear();
        nameEl.sendKeys(name);

        WebElement descEl = WaitUtils.waitForElementVisible(driver, drillDescriptionField, 10);
        descEl.clear();
        descEl.sendKeys(description);

        WebElement uploadEl = WaitUtils.waitForElementVisible(driver, uploadDrillFile, 10);
        uploadEl.sendKeys(filePath);
    }

    public void clickSaveDrill() {
        WaitUtils.waitForElementClickable(driver, saveDrillButton, 10);
        driver.findElement(saveDrillButton).click();
    }

    public String getSuccessMessage() {
        WebElement el = WaitUtils.waitForElementVisible(driver, successMessage, 10);
        return el.getText().trim();
    }

    public boolean isDrillPresentInList(String drillName) {
        By drillRow = By.xpath(String.format(drillRowByNameXpath, drillName));
        try {
            WaitUtils.waitForElementVisible(driver, drillRow, 10);
            return driver.findElement(drillRow).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
