package com.tests;

import com.google.common.base.CharMatcher;
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

    private final File testExecutionReport = new File(TEST_EXECUTION_REPORT_PATH);
    private final File xrayLogin = new File(XRAY_LOGIN_PATH);
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
        String xrayTestExecutionKey = xrayPostResults(xrayAuthToken);
        System.out.println("Xray test execution key is: " + xrayTestExecutionKey);

    }


    private String xrayUserLogin() {
        // Login to xray to get token
        return given()
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
    }

    private String xrayPostResults(String token) {
        // Publish reports to specific jira xray (project and test plan)
        return given()
                .log().all()
                .spec(requestSpec)
                .header("Content-Type", "text/xml")
                .header("Authorization", "Bearer ".concat(CharMatcher.is('\"').trimFrom(token)))
                .queryParam("projectKey", "SAM")
                .queryParam("testPlanKey", "SAM-2")
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
    }
}
