package com.rugby.planner.tests;

import com.rugby.planner.base.BaseTest;
import com.rugby.planner.pages.LoginPage;
import com.rugby.planner.pages.ShareCoach;
import com.rugby.planner.config.ConfigReader;

import java.util.List;

import org.openqa.selenium.WebElement;
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
        String name = "Kenny John";
        String email = "kenny@yopmail.com";

        sharePage.fillInviteForm(name, email);
        Thread.sleep(3000);

        // Click on Team Element
        ShareCoach teamPage = new ShareCoach(driver);
        teamPage.clickOnTeamName("Roman's Team");
  
        ShareCoach listingpage = new ShareCoach(driver);
        List<WebElement> rows = ShareCoach.getTableRows();

        Assert.assertFalse(rows.isEmpty());

        for (WebElement row : rows) {
            String name3 = ShareCoach.getName(row);
            String email3 = ShareCoach.getEmail(row);
            String inviteDate = ShareCoach.getInviteDate(row);
            String teamName = ShareCoach.getTeamName(row);
            String role = ShareCoach.getRole(row);
            String status = ShareCoach.getStatus(row);
            String action = ShareCoach.getAction(row);

            Assert.assertNotNull("Name should not be null", name3);
            Assert.assertNotNull("Email should not be null", email3);
            Assert.assertNotNull("Invite date should not be null", inviteDate);
            Assert.assertNotNull("Team name should not be null", teamName);
            Assert.assertNotNull("Role should not be null", role);
            Assert.assertNotNull("Status should not be null", status);
            Assert.assertNotNull("Action should not be null", action);
        }
    }
}
