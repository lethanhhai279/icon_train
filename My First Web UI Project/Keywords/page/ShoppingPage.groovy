package page
import commonAction.ActionCommon
import object.ShoppingPageObject

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
import com.kms.katalon.core.util.KeywordUtil as log
import internal.GlobalVariable

public class ShoppingPage {
	public static String handleRawItemName(String itemName) {
		String nameItemToLocate = itemName.replaceAll(" ", "-").toLowerCase()
		return nameItemToLocate
	}

	public static boolean addItemToCartAndVerify(String itemName) {
		ActionCommon.click(ShoppingPageObject.ADD_TO_CART_BUTTON(handleRawItemName(itemName)))
		WebUI.takeFullPageScreenshot()
		boolean itemAddedToCart = ActionCommon.verifyElementNotPresent(ShoppingPageObject.ADD_TO_CART_BUTTON(handleRawItemName(itemName)))
		return itemAddedToCart
	}
	public static boolean removeItemToCartAndVerify(String itemName) {
		ActionCommon.click(ShoppingPageObject.REMOVE_TO_CART_BUTTON(handleRawItemName(itemName)))
		WebUI.takeFullPageScreenshot()
		boolean itemRemovedToCart = ActionCommon.verifyElementNotPresent(ShoppingPageObject.REMOVE_TO_CART_BUTTON(handleRawItemName(itemName)))
		return itemRemovedToCart
	}
}
