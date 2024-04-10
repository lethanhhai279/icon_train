package commonAction

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

public class ActionCommon {
	public static void click(TestObject objectToTest) {
		WebUI.waitForElementVisible(objectToTest, 10)
		WebUI.scrollToElement(objectToTest, 10)
		WebUI.click(objectToTest)
	}
	public static boolean verifyElementNotPresent(TestObject objectToTest) {
		boolean element = WebUI.verifyElementNotPresent(objectToTest, 20)
		return element
	}
	public static boolean verifyElementPresent(TestObject objectToTest) {
		boolean element = WebUI.verifyElementPresent(objectToTest, 20)
		return element
	}
	public static void waitAndScroll(TestObject objectToTest) {
		WebUI.waitForElementVisible(objectToTest, 20)
		WebUI.scrollToElement(objectToTest, 20)
	}
}
