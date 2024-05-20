package ticket1

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
import ticket1.Menu as Menu

import internal.GlobalVariable

public class Page {
	@Keyword
	def login() {
		WebUI.openBrowser('https://www.saucedemo.com/')
		WebUI.maximizeWindow()

		//Verify Login interface
		boolean b_verifyOpenBrowser = WebUI.verifyElementVisible(findTestObject('Ticket1/Main Page/Logo Swag Labs'), FailureHandling.CONTINUE_ON_FAILURE)
		if (b_verifyOpenBrowser == true) {
			KeywordUtil.markPassed("Access successfully Brower");
			WebUI.takeFullPageScreenshot()
		}
		else {
			KeywordUtil.markFailed("Cannot find Logo Swag Labs")
		}

		// Enter User/password and login
		WebUI.setText(findTestObject('Ticket1/Main Page/Username'), 'standard_user')

		WebUI.setText(findTestObject('Ticket1/Main Page/Password'), 'secret_sauce')

		WebUI.click(findTestObject('Ticket1/Main Page/Login'))

		//Verify that Login Successfully Products page
		verifyPage("Products")

		println("Login successfully")
	}

	@Keyword
	def goToPage(String s_pageName) {
		if (s_pageName == "Products") {
			WebUI.click(findTestObject('Ticket1/Main Page/Continue Shopping Button'))
		}
		else if (s_pageName == "Your Cart") {
			WebUI.click(findTestObject('Ticket1/Main Page/Your Cart'))
		}
		verifyPage(s_pageName)
	}

	def verifyPage(String s_pageName) {
		boolean b_verifyPage =  WebUI.verifyElementVisible(findTestObject('Ticket1/Main Page/Page Name',[('s_pageName') : s_pageName]),FailureHandling.CONTINUE_ON_FAILURE)
		if (b_verifyPage == true) {
			KeywordUtil.markPassed("Here is " + s_pageName + " page");
			WebUI.takeFullPageScreenshot()
		}
		else {
			KeywordUtil.markFailed("Cannot find Products page")
		}
	}

	@Keyword
	def goToDetailItem(String ItemName) {
		WebUI.click(findTestObject('Ticket1/Main Page/Name Item',[('ItemName') : ItemName]))
		vWebUI.takeFullPageScreenshot()
	}

	@Keyword
	def logout() {
		Menu.openMenu()
		WebUI.click(findTestObject('Ticket1/Main Page/Logout'))
		WebUI.verifyElementVisible(findTestObject('Ticket1/Main Page/Logo Swag Labs'))
		WebUI.verifyElementVisible(findTestObject('Ticket1/Main Page/Username'))
		WebUI.verifyElementVisible(findTestObject('Ticket1/Main Page/Password'))
	}
}
