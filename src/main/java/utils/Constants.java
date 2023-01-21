package utils;

import java.nio.file.Paths;

public class Constants {

    public static final String TEST_EXECUTION_REPORT_PATH = Paths.get(System.getProperty("user.dir"), "target/surefire-reports", "testng-results.xml").toString();
    public static final String XRAY_LOGIN_PATH = Paths.get(System.getProperty("user.dir"), "src/test/resources/TestDataFiles", "xrayLogin.json").toString();

    public static final String BASE_URL = "https://xray.cloud.getxray.app/api/";


}
