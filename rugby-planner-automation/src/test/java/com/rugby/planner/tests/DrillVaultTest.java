package com.rugby.planner.tests;

import com.rugby.planner.base.BaseTest;
import com.rugby.planner.pages.DrillVaultPage;
import com.rugby.planner.pages.LoginPage;
import com.rugby.planner.config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DrillVaultTest extends BaseTest {

    @Test(priority = 1)
    public void addDrillAndVerify() {
        System.out.println("===== DRILL VAULT TEST STARTED =====");

        // 1️⃣ Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        System.out.println("✅ Logged in successfully");

        // 2️⃣ Navigate to Drill Vault
        DrillVaultPage drillPage = new DrillVaultPage(driver);
        drillPage.navigateToDrillVault();
        System.out.println("✅ Navigated to Drill Vault");

        // 3️⃣ Prepare test data
        String drillName = "Drill_" + System.currentTimeMillis();
        String description = "This is a sample drill uploaded via automation";
        String filePath = "/Users/inheritx/Desktop/sample-drill.pdf"; // ⚙️ update path

        // 4️⃣ Add a new drill
        drillPage.clickAddDrill();
        drillPage.enterDrillDetails(drillName, description, filePath);
        drillPage.clickSaveDrill();

        // 5️⃣ Verify success message
        String successMsg = drillPage.getSuccessMessage();
        Assert.assertTrue(successMsg.toLowerCase().contains("success") || successMsg.toLowerCase().contains("added"),
                "❌ Drill creation failed! Message: " + successMsg);
        System.out.println("✅ Drill creation success message verified");

        // 6️⃣ Verify drill appears in vault list
        boolean present = drillPage.isDrillPresentInList(drillName);
        Assert.assertTrue(present, "❌ Drill not found in vault list: " + drillName);
        System.out.println("✅ Drill found in vault list");

        System.out.println("===== DRILL VAULT TEST COMPLETED SUCCESSFULLY =====");
    }
}
