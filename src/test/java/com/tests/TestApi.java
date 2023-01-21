package com.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

import static utils.Constants.*;

public class TestApi {

    private File testExecutionReport = new File(TEST_EXECUTION_REPORT_PATH);
    private File xrayLogin = new File(XRAY_LOGIN_PATH);
    private static RequestSpecification requestSpec;

//    @Test
//    public void df()
//    {
//
//        requestSpec = new RequestSpecBuilder().
//                setBaseUri(BASE_URL).
//                build();
//
//        String xrayAuthToken = new TestBase().xrayUserLogin(requestSpec);
//        System.out.println("Token is : " + xrayAuthToken);
//
//        String xrayTestExecutionKey = new TestBase().xrayPostResults(requestSpec, xrayAuthToken, "SAM", "SAM-2");
//        System.out.println("Xray test execution key is: " + xrayTestExecutionKey);
//    }
}
