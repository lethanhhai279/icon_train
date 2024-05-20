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

import internal.GlobalVariable

public class RegisterObject {
	
	public static TestObject REGISTER_OBJ = findTestObject('DemoStore/Register')
	public static TestObject CHOOSE_GENDER(String gender) {
		TestObject choose_Gender = findTestObject('DemoStore/Gender', [('Gender') : gender])
		return choose_Gender
	}
	
	public static TestObject SET_FIRST_NAME = findTestObject('DemoStore/SetInformation', [('Info') : 'FirstName'])
	public static TestObject SET_LAST_NAME = findTestObject('DemoStore/SetInformation', [('Info') : 'LastName'])
	
	public static TestObject DATE_OF_BIRTHDAY = findTestObject('DemoStore/Date', [('Date') : 'DateOfBirthDay'])
	public static TestObject DATE_OF_BIRTHMONTH = findTestObject('DemoStore/Date', [('Date') : 'DateOfBirthMonth'])
	public static TestObject DATE_OF_BIRTHYEAR = findTestObject('DemoStore/Date', [('Date') : 'DateOfBirthYear'])
	
	public static TestObject EMAIL_OBJ = findTestObject('DemoStore/SetInformation', [('Info') : 'Email'])
	public static TestObject PASSWORD_OBJ = findTestObject('DemoStore/SetInformation', [('Info') : 'Password'])
	public static TestObject PASSWORD_CONFIRM_OBJ = findTestObject('DemoStore/SetInformation', [('Info') : 'ConfirmPassword'])
	
	public static TestObject SUBMIT_REGISTER_OBJ = findTestObject('DemoStore/SubmitRegister')
}
