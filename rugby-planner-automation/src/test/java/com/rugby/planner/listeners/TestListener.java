package com.rugby.planner.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.rugby.planner.base.BaseTest;
import com.rugby.planner.reports.ExtentTestManager;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        // nothing special
    }

    @Override
    public void onTestStart(ITestResult result) {
        String browser = System.getProperty("browser", "chrome");
        ExtentTestManager.startTest(result.getMethod().getMethodName(), browser);
        ExtentTestManager.getTest().log(Status.INFO, "Starting test on browser: " + browser);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
        // attach screenshot for pass if you want (user asked pass+fail steps)
        String screenshot = captureFromBaseTest(result, result.getMethod().getMethodName());
        if (screenshot != null) {
            ExtentTestManager.getTest().addScreenCaptureFromPath(screenshot);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());
        String screenshot = captureFromBaseTest(result, result.getMethod().getMethodName());
        if (screenshot != null) {
            try {
                ExtentTestManager.getTest().addScreenCaptureFromPath(screenshot);
            } catch (Exception e) {
                ExtentTestManager.getTest().log(Status.WARNING, "Failed to attach screenshot: " + e.getMessage());
            }
        }
    }

    @Override public void onTestSkipped(ITestResult result) { ExtentTestManager.getTest().log(Status.SKIP, "Skipped"); }
    @Override public void onFinish(ITestContext context) { ExtentTestManager.flush(); }

    // Helper to call BaseTest.captureScreenshot (we expect tests extend BaseTest)
    private String captureFromBaseTest(ITestResult result, String testName) {
        try {
            Object instance = result.getInstance();
            if (instance instanceof BaseTest) {
                BaseTest base = (BaseTest) instance;
                String screenshotPath = "screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
                base.captureScreenshot(screenshotPath); // we'll add this helper to BaseTest
                return screenshotPath;
            }
        } catch (Exception e) {
            // ignore
        }
        return null;
    }
}