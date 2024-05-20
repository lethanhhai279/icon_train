package demoStore

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
import demoStore.RegisterObject
import internal.GlobalVariable

public class Page_Action {
	public static void Register_Action(String Gender,String FirstName,String LastName,String DateOfBirthDay,String DateOfBirthMonth,String DateOfBirthYear,String Email,String Password, String ConfirmPassword) {
		WebUI.click(RegisterObject.REGISTER_OBJ)

		WebUI.click(RegisterObject.CHOOSE_GENDER(Gender))

		WebUI.setText(RegisterObject.SET_FIRST_NAME, FirstName)

		WebUI.setText(RegisterObject.SET_LAST_NAME, LastName)

		WebUI.selectOptionByValue(RegisterObject.DATE_OF_BIRTHDAY, DateOfBirthDay, false)

		WebUI.selectOptionByLabel(RegisterObject.DATE_OF_BIRTHMONTH, DateOfBirthMonth, false)

		WebUI.selectOptionByValue(RegisterObject.DATE_OF_BIRTHYEAR, DateOfBirthYear, false)

		WebUI.setText(RegisterObject.EMAIL_OBJ, Email)

		WebUI.setText(RegisterObject.PASSWORD_OBJ, Password)

		WebUI.setText(RegisterObject.PASSWORD_CONFIRM_OBJ, ConfirmPassword)

		WebUI.click(RegisterObject.SUBMIT_REGISTER_OBJ)
	}
}
