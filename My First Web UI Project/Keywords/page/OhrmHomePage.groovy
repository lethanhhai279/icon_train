package page

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import commonAction.ActionCommon
import object.HRHomePageObject
public class OhrmHomePage {
	public static void fillEmployeeName(String firstName, String middleName, String lastName) {
		ActionCommon.click(HRHomePageObject.MY_INFO_BUTTON)
		WebUI.clearText(HRHomePageObject.FIRST_NAME)
		WebUI.clearText(HRHomePageObject.MIDDLE_NAME)
		WebUI.clearText(HRHomePageObject.LAST_NAME)
		WebUI.setText(HRHomePageObject.FIRST_NAME, firstName)
		WebUI.setText(HRHomePageObject.MIDDLE_NAME, middleName)
		WebUI.setText(HRHomePageObject.LAST_NAME, lastName)
	}
}
