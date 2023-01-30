# Xray integration Step-By-Step
<p align="center">
  <img src="./source/images/xray.png"/>
</p>

![Views](https://visitor-badge.glitch.me/badge?page_id=Xray_Integration.visitor-badge)
![Stars](https://img.shields.io/github/stars/samiir95/Xray_Integration.svg?color=green)
![Watchers](https://img.shields.io/github/watchers/samiir95/Xray_Integration.svg?color=ff69b4)
![Open Pull Requests](https://img.shields.io/github/issues-pr-raw/samiir95/Xray_Integration?color=brightgreen)
![Closed Pull Requests](https://img.shields.io/github/issues-pr-closed-raw/samiir95/Xray_Integration?color=lightgrey)
![Commit Activity](https://img.shields.io/github/commit-activity/m/samiir95/Xray_Integration)
![Open Issues](https://img.shields.io/github/issues-raw/samiir95/Xray_Integration.svg?color=critical)
![Closed Issues](https://img.shields.io/github/issues-closed-raw/samiir95/Xray_Integration.svg?color=yellowgreen)
![Forks](https://img.shields.io/github/forks/samiir95/Xray_Integration.svg?color=blueviolet)
![Contributors](https://img.shields.io/github/contributors/samiir95/Xray_Integration.svg?color=orange)

## 🏃 For getting your hands dirty faster to run this project:
- Clone it to Intellij or your favorite IDE. <br />
- Add your xray API Key credentials under ```src/test/resources/TestDataFiles/xrayLogin.json``` <br />
- At this class ```src/test/java/com/tests/PublishXrayResults``` , change x-ray ```project_key``` and ```test_plan_key``` to be your Jira matched keys for the ```postExecutionReportBackToXray``` test method. <br />
- For the whole test methods inside ```CalcTest``` and ```SampleTest``` classes, change ```requirement_key``` attributes for the whole ```@Requirement``` annotation to be your Jira requirement that you need it to be linked to test method. <br />
- Run the ```run.bat``` file by right click and run or navigate to the ```.bat``` file location and double click it.
- If you have linux os then navigate to the ```run.sh``` file, open terminal then type ```bash run.sh``` and hit enter.

## For getting the "testng.xml" file which can be uploaded to Jira Xray:
> Navigate to the ```target``` folder, expand it, and under ```surefire-reports``` you'll find the ```testng.xml``` file. <br />

## For deleting the "target" folder after execution:
> Append this command ```rd /s /Q target``` to the run.bat file. <br />
> Append this command ```rm -rf target``` to the run.sh file.
