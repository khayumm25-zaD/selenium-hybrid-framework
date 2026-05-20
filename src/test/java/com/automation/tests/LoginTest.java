package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.listeners.TestListener;
import com.automation.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        String currentURL =
                driver.getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("inventory"),
                "Login Failed"
        );

        System.out.println(
                "Login Successful"
        );
    }

    @Test
    public void invalidLoginTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "wrong_user",
                "wrong_password"
        );

        String currentURL =
                driver.getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("inventory"),
                "Invalid Login Failed"
        );
    }
}