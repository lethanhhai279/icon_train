package data

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

public class DataLoginPage {
	public static String URL = "https://www.saucedemo.com/"
	public static String USER_NAME_STANDAR = "standard_user"
	public static String USER_NAME_LOCKED = "locked_out_user"
	public static String USER_NAME_PROBLEM = "problem_user"
	public static String USER_NAME_PERF_GLITCH = "performance_glitch_user"
	public static String USER_NAME_ERROR = "error_user"
	public static String USER_NAME_VISUAL = "visual_user"
	public static String PASS_WORD = "secret_sauce"
	public static int ATTEMPT = 3
	public static String URL_LOGIN_SUCCESS = "https://www.saucedemo.com/inventory.html"
}
