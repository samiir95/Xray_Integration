package com.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static utils.Constants.*;

public class PublishXrayResults {

    private File testExecutionReport = new File(TEST_EXECUTION_REPORT_PATH);
    private File xrayLogin = new File(XRAY_LOGIN_PATH);
    private static RequestSpecification requestSpec;

    @BeforeSuite
    public void beforeSuite() {

        requestSpec = new RequestSpecBuilder().
                setBaseUri(BASE_URL).
                build();

    }

    @Test
    public void postExecutionReportBackToXray() throws FileNotFoundException {

        String xrayAuthToken = xrayUserLogin();
        String xrayTestExecutionKey = xrayPostResults(xrayAuthToken, "SAM", "SAM-2");
        System.out.println("Xray test execution key is: " + xrayTestExecutionKey);

    }


    private String xrayUserLogin() throws FileNotFoundException {
        // Login to xray to get token
        String authToken =
                given()
                        .spec(requestSpec)
                        .contentType(ContentType.JSON)
                        .body(xrayLogin)
                        .log().body()
                        .when()
                        .post("v1/authenticate")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .body(notNullValue())
                        .extract().
                        response().asPrettyString();

        return authToken;
    }

    private String xrayPostResults(String token, String projectKey, String testPlanKey) throws FileNotFoundException {
        // Publish reports to specific jira xray (project and test plan)
        String testExecutionKey =
                given()
                        .log().all()
                        .spec(requestSpec)
                        .header("Content-Type", "text/xml")
                        .header("Authorization", "Bearer " + token.substring(1, token.length() - 1))
                        .queryParam("projectKey", projectKey)
                        .queryParam("testPlanKey", testPlanKey)
                        .body(testExecutionReport)
                        .log().body()
                        .when()
                        .post("v2/import/execution/testng")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .body(notNullValue())
                        .extract().
                        path("key");
        return testExecutionKey;
    }

}
