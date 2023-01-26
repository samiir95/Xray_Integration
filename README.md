# For getting your hands dirty faster to run this project:
1- Clone it to intellij. <br />
2- Add your xray API Key credentials under src/test/resources/TestDataFiles/xrayLogin.json <br />
3- At this class >> src/test/java/com/tests/PublishXrayResults , change x-ray project key and test plan key to be your jira matched keys for the "postExecutionReportBackToXray" test method. <br />
4- For the whole test methods inside CalcTest and SampleTest classes, change requirement_key attributes for the whole @Requirement annotation to be your jira requirement that you need to link this test method to. <br />
5- Install bat file plugin. <br />
6- Run the run.bat file by right click and run.
