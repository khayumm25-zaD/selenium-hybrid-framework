package com.automation.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        String timestamp =
                new SimpleDateFormat(
                        "yyyyMMdd_HHmmss"
                ).format(new Date());

        String screenshotPath =
                System.getProperty("user.dir")
                        + "/screenshots/"
                        + testName
                        + "_"
                        + timestamp
                        + ".png";

        TakesScreenshot ts =
                (TakesScreenshot) driver;

        File source =
                ts.getScreenshotAs(
                        OutputType.FILE
                );

        File destination =
                new File(screenshotPath);

        try {

            FileUtils.copyFile(
                    source,
                    destination
            );

            System.out.println(
                    "Screenshot Saved At: "
                            + screenshotPath
            );

        } catch (IOException e) {

            e.printStackTrace();
        }

        return screenshotPath;
    }
}