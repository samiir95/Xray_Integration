package com.tests;

import app.getxray.xray.testng.annotations.Requirement;
import app.getxray.xray.testng.annotations.XrayTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({app.getxray.xray.testng.listeners.XrayListener.class})

public class SampleTest {

    private static final String baseUrl = "http://www.google.com";
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("launching Chrome browser");
        driver = new ChromeDriver();
    }

    @Test
    @XrayTest(description = "this is a simple selenium java test", summary = "simple navigation with assertion", labels = "mohamed samir")
    @Requirement(key = "SAM-1")
    public void verifyHomepageTitle() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();

    }
}
