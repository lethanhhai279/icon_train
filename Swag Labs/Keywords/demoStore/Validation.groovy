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
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class Validation {
	@Keyword
	public static ValidateRegisterSuccessfully () {

		String exceptedText = "Your registration completed"
		String exceptedColor = "rgba(76, 177, 124, 1)"

		'get actual text and color'
		String actualText = WebUI.getText(findTestObject('DemoStore/ValidateRegisterSuccessfully'))
		String actualColor = WebUI.getCSSValue(findTestObject('DemoStore/ValidateRegisterSuccessfully'), 'color')

		'verify text'
		boolean b_VerifyText = WebUI.verifyElementText(findTestObject('DemoStore/ValidateRegisterSuccessfully'), exceptedText, FailureHandling.CONTINUE_ON_FAILURE)

		'verify color'
		boolean b_VerifyColor = WebUI.verifyEqual(actualColor,exceptedColor,FailureHandling.CONTINUE_ON_FAILURE )
		if(b_VerifyColor == true && b_VerifyText == true) {
			KeywordUtil.markPassed("Register successfully")
		}
		else {
			KeywordUtil.markFailed("Register failed")
		}

		'Sreenshort'
		WebUI.takeElementScreenshot(findTestObject('DemoStore/ValidateRegisterSuccessfully'))
	}

	@Keyword
	public static ValidateInvalidMessage (String ErrorMessage, String ColorOfErrorMessage) {


		boolean b_verifyMessage =  WebUI.verifyElementVisible(findTestObject('DemoStore/ValidateErrorMessage', [('ErrorMessage') : ErrorMessage]), FailureHandling.CONTINUE_ON_FAILURE)
		if (b_verifyMessage == true) {
			KeywordUtil.markPassed("The message " + ErrorMessage + " is visible");
			WebUI.takeFullPageScreenshot()
		}
		else {
			KeywordUtil.markFailed("The message " + ErrorMessage + " is not visible")
		}

		'get actual text and color'
		String actualColor = WebUI.getCSSValue(findTestObject('DemoStore/ValidateErrorMessage', [('ErrorMessage') : ErrorMessage]), 'color')

		'verify color'
		boolean b_VerifyColor = WebUI.verifyEqual(actualColor,ColorOfErrorMessage,FailureHandling.CONTINUE_ON_FAILURE )
		if(b_VerifyColor == true) {
			KeywordUtil.markPassed("The color of message is correct")
		}
		else {
			KeywordUtil.markFailed("The color of message is not correct")
		}

		'Sreenshort'
		WebUI.takeElementScreenshot(findTestObject('DemoStore/ValidateErrorMessage', [('ErrorMessage') : ErrorMessage]))
	}
}
