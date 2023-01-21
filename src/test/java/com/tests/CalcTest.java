package com.tests;

import app.getxray.xray.testng.annotations.Requirement;
import app.getxray.xray.testng.annotations.XrayTest;
import org.example.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({app.getxray.xray.testng.listeners.XrayListener.class})
public class CalcTest {


    @DataProvider
    public Object[][] ValidDataProvider() {
        return new Object[][]{
                {1, 2, 3},
                {2, 3, 4},  // error or the data itself :)
                {-1, 1, 0}
        };
    }


    @Test(dataProvider = "ValidDataProvider")
    @XrayTest(summary = "Add numbers", description = "Add numbers from given data", labels = "Add Numbers")
    @Requirement(key = "SAM-1")
    public void CanAddNumbersFromGivenData(final int a, final int b, final int c) {
        Assert.assertEquals(Calculator.Add(a, b), c);
    }


    @Test
    @XrayTest(labels = "core addition", description = "Add two numbers", summary = "This is to add two numbers")
    @Requirement(key = "SAM-1")

    public void CanAddNumbers() {
        Assert.assertEquals(Calculator.Add(1, 1), 2);
        Assert.assertEquals(Calculator.Add(-1, 1), 0);
    }


    @Test
    @XrayTest(labels = "core")
    @Requirement(key = "SAM-1")
    public void CanSubtract() {
        Assert.assertEquals(Calculator.Subtract(1, 1), 0);
        Assert.assertEquals(Calculator.Subtract(-1, -1), 0);
        Assert.assertEquals(Calculator.Subtract(100, 5), 95);
    }


    @Test
    @XrayTest(labels = "core")
    @Requirement(key = "SAM-1")
    public void CanMultiplyX() {
        Assert.assertEquals(Calculator.Multiply(1, 1), 1);
        Assert.assertEquals(Calculator.Multiply(-1, -1), 1);
        Assert.assertEquals(Calculator.Multiply(100, 5), 500);
    }


    @Test
    @XrayTest(labels = "core")
    @Requirement(key = "SAM-1")
    public void CanDivide() {
        Assert.assertEquals(Calculator.Divide(1, 1), 1);
        Assert.assertEquals(Calculator.Divide(-1, -1), 1);
        Assert.assertEquals(Calculator.Divide(100, 5), 20);
    }


    @Test
    @XrayTest(labels = "core")
    public void CanDoStuff() {
        Assert.assertNotEquals(true, true);
    }
}
