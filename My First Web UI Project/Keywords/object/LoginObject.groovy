package object

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

public class LoginObject {
	public static TestObject USER_NAME = findTestObject("Object Repository/Ticket_1/usernameInput")
	public static TestObject PASS_WORD = findTestObject("Object Repository/Ticket_1/passwordInput")
	public static TestObject LOGIN_BUTTON = findTestObject("Object Repository/Ticket_1/loginButton")
	public static TestObject ERROR_MESSAGE = findTestObject("Object Repository/Ticket_1/errorMessage")
	public static TestObject USER_NAME_OHRM = findTestObject("Object Repository/Ticket_2/userName")
	public static TestObject PASSWORD_OHRM = findTestObject("Object Repository/Ticket_2/password")
	public static TestObject LOGIN_BUTTON_OHRM = findTestObject("Object Repository/Ticket_2/loginButton")
}
