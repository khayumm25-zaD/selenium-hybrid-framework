package com.automation.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports getReportObject() {

        String reportPath =
                System.getProperty("user.dir")
                        + "/reports/index.html";

        File reportDir = new File(
                System.getProperty("user.dir")
                        + "/reports"
        );

        if (!reportDir.exists()) {

            reportDir.mkdirs();
        }

        ExtentSparkReporter reporter =
                new ExtentSparkReporter(reportPath);

        reporter.config().setReportName(
                "Automation Test Results"
        );

        reporter.config().setDocumentTitle(
                "Selenium Framework Report"
        );

        extent = new ExtentReports();

        extent.attachReporter(reporter);

        extent.setSystemInfo(
                "Tester",
                "Khayum"
        );

        return extent;
    }
}