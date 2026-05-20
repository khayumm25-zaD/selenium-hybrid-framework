package com.automation.listeners;

import com.automation.base.BaseTest;
import com.automation.reports.ExtentManager;
import com.automation.utilities.ScreenshotUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    ExtentReports extent =
            ExtentManager.getReportObject();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(
                result.getMethod().getMethodName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        String screenshotPath =
                ScreenshotUtils.captureScreenshot(
                        BaseTest.getDriver(),
                        result.getMethod().getMethodName()
                );

        try {

            test.addScreenCaptureFromPath(
                    screenshotPath
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}