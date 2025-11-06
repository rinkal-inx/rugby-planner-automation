package com.rugby.planner.tests;

import com.rugby.planner.base.BaseTest;
import com.rugby.planner.pages.LoginPage;
import com.rugby.planner.pages.ShareCoach;
import com.rugby.planner.config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShareCoachTest extends BaseTest {

    @Test(priority = 1)
    public void verifyCoachSharingFlow() throws InterruptedException {
        // 1️⃣ Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        // 2️⃣ Navigate to Share Planner / Invite Coach
       ShareCoach sharePage = new ShareCoach(driver);
       sharePage.navigateToCoach();

        // 3️⃣ Invite a coach
        String name = "Jish Mark";
        String email = "jish@yopmail.com";

        sharePage.fillInviteForm(name, email);
        Thread.sleep(3000);
     
        boolean isVisible = sharePage.isCoachVisible(name);

        Assert.assertTrue(sharePage.isCoachVisible(name), "❌ Invited coach not found in list!");
        System.out.println("✅ Coach successfully shared and visible in planner!");
    }
}
