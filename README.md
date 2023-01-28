## 🏃 For getting your hands dirty faster to run this project:
- Clone it to Intellij or your favorite IDE. <br />
- Add your xray API Key credentials under ```src/test/resources/TestDataFiles/xrayLogin.json``` <br />
- At this class ```src/test/java/com/tests/PublishXrayResults``` , change x-ray ```project_key``` and ```test_plan_key``` to be your Jira matched keys for the ```postExecutionReportBackToXray``` test method. <br />
- For the whole test methods inside ```CalcTest``` and ```SampleTest``` classes, change ```requirement_key``` attributes for the whole ```@Requirement``` annotation to be your Jira requirement that you need it to be linked to test method. <br />
- Run the ```run.bat``` file by right click and run or navigate to the ```.bat``` file location and double click it.
- If you have linux os then navigate to the ```run.sh``` file, open terminal then type ```bash run.sh``` and hit enter.

## For getting the "testng.xml" file which can be uploaded to Jira Xray:
> Navigate to the ```target``` folder, expand it, and under ```surefire-reports``` you'll find the ```testng.xml``` file.
