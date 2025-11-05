package com.rugby.planner.tests;

import com.rugby.planner.base.BaseTest;
import com.rugby.planner.pages.LoginPage;
import com.rugby.planner.pages.PlannerPage;
import com.rugby.planner.config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlannerTest extends BaseTest {

    @Test(priority = 1)
    public void verifyPlannerFlow() throws InterruptedException {
        // 1️⃣ Login first
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        // 2️⃣ Navigate to Planner
        PlannerPage plannerPage = new PlannerPage(driver);
        plannerPage.navigateToPlanner();

        // 3️⃣ Create Plan
        String planName = "AutomationPlan";
        String planLogoPath = "/Users/inheritx/Downloads/banner image QC.png";
        plannerPage.createPlan(planName, planLogoPath);
        Thread.sleep(2000);
        plannerPage.openPlan(planName);
       
        // 4️⃣ Create Session
        String sessionName = "Morning Session";
        plannerPage.createSession(sessionName);
        
        Thread.sleep(2000);
        plannerPage.openSession(sessionName);

        // 5️⃣ Add Drill
        Thread.sleep(3000);
        plannerPage.addDrill(
            "Passing Drill", 
            "Upload from my drill", 
            "2025-10-29", 
            "30", 
            true, "Focus on quick passes", 
            false, ""
        );

        // 6️⃣ Verify
        String msg = plannerPage.getSuccessMessage();
        Assert.assertTrue(msg.toLowerCase().contains("success") || msg.toLowerCase().contains("created"), 
            "Expected success message but got: " + msg);

        System.out.println("✅ Drill successfully added to planner session!");
    }
}