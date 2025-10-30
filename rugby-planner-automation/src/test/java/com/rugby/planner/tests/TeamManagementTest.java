package com.rugby.planner.tests;

import com.rugby.planner.base.BaseTest;
import com.rugby.planner.pages.TeamManagementPage;
import com.rugby.planner.pages.LoginPage;
import com.rugby.planner.config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamManagementTest extends BaseTest {

    @Test(priority = 1)
    public void createTeamAndVerify() {
    	
    	System.out.println("===== TEAM CREATION TEST STARTED =====");

        // 1️⃣ Login first
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        // 2️⃣ Go to Team Management Page
        
        TeamManagementPage teamPage = new TeamManagementPage(driver);
        teamPage.navigateToTeamManagement();

        // 3️⃣ Prepare test data
        
        String teamName = "AutoTeam_" + System.currentTimeMillis();
        String coachName = "John Doe";
        String ageGroup = "10-20";

        // 4️⃣ Fill form and save
        teamPage.clickAddTeam();
        teamPage.enterTeamName(teamName);
        teamPage.enterCoachName(coachName);
        teamPage.uploadTeamImage();
        teamPage.enterAgeGroup(ageGroup);
        teamPage.clickSaveButton();

        // 5️⃣ Verify success message
        String successMsg = teamPage.getSuccessMessage();
        Assert.assertTrue(
            successMsg.toLowerCase().contains("success")
            || successMsg.toLowerCase().contains("created")
            || successMsg.toLowerCase().contains("team"),
            "Expected success message but got: " + successMsg
        );
        System.out.println("Team creation success message verified:"+successMsg);

        // 6️⃣ Verify team appears in list
        boolean present = teamPage.isTeamPresentInList(teamName);
        Assert.assertTrue(present, "Newly created team not found in list: " + teamName);
        System.out.println("Verified:Newly created team appears in the list");
        
        System.out.println("===== TEAM CREATION TEST COMPLETED SUCCESSFULLY =====");
    }
}
