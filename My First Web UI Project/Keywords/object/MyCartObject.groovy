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

public class MyCartObject {
	public static TestObject ICON_CART = findTestObject("Object Repository/Ticket_1/CartIcon")
	public static TestObject CHECKOUT_BUTTON = findTestObject("Object Repository/Ticket_1/checkoutButton")
	public static TestObject FIRST_NAME_CHECKOUT = findTestObject("Object Repository/Ticket_1/formCheckout",[('field'):'First Name'])
	public static TestObject LAST_NAME_CHECKOUT = findTestObject("Object Repository/Ticket_1/formCheckout",[('field'):'Last Name'])
	public static TestObject POSTAL_CODE_CHECKOUT = findTestObject("Object Repository/Ticket_1/formCheckout",[('field'):'Zip/Postal Code'])
	public static TestObject CONTINUE_BUTTON = findTestObject("Object Repository/Ticket_1/continueButton")
	public static TestObject FINISH_BUTTON = findTestObject("Object Repository/Ticket_1/finishButton")
	public static TestObject ERROR_MESSAGE = findTestObject("Object Repository/Ticket_1/errorMessageCheckout")
}
