package com.rugby.planner.reports;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
    private static ExtentReports extent = ExtentManager.getExtentReports();
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();
    private static Map<Long, ExtentTest> tests = new HashMap<>();

    public static synchronized ExtentTest startTest1(String testName, String browser) {
        ExtentTest test = extent.createTest(testName + " [" + browser + "]");
        testThread.set(test);
        tests.put(Thread.currentThread().getId(), test);
        return test;
    }

    public static ExtentTest getTest() {
        return testThread.get();
    }

    public static synchronized void flush() {
        extent.flush();
    }

	public static void startTest(String methodName, String browser) {
		// TODO Auto-generated method stub
		
	}
}
