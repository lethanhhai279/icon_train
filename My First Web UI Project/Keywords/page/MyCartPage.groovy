package page
import commonAction.ActionCommon
import object.MyCartObject
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
import com.kms.katalon.core.util.KeywordUtil as log

public class MyCartPage {
	public static void fillInToForm(String firstName, String lastName, String postalCode) {
		ActionCommon.click(MyCartObject.ICON_CART)
		ActionCommon.click(MyCartObject.CHECKOUT_BUTTON)
		WebUI.scrollToElement(MyCartObject.FIRST_NAME_CHECKOUT, 10)
		WebUI.setText(MyCartObject.FIRST_NAME_CHECKOUT, firstName)
		WebUI.setText(MyCartObject.LAST_NAME_CHECKOUT, lastName)
		WebUI.setText(MyCartObject.POSTAL_CODE_CHECKOUT, postalCode)
		WebUI.takeFullPageScreenshot()
	}
	public static boolean verifyCheckout(){
		ActionCommon.click(MyCartObject.CONTINUE_BUTTON)
		WebUI.takeFullPageScreenshot()
		if (ActionCommon.verifyElement(MyCartObject.ERROR_MESSAGE)) {
			return true
		}
		else {
			return false
		}
	}
}