import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://demo.nopcommerce.com/register?returnUrl=%2F')

WebUI.getNumberOfTotalOption(findTestObject('Dropdown/dropDown'))

WebUI.verifyOptionsPresent(findTestObject('Dropdown/dropDown'), ['Day', '1','2','3','4'])

WebUI.verifyOptionPresentByLabel(findTestObject('Dropdown/dropDown'), '30', false, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyOptionPresentByValue(findTestObject('Dropdown/dropDown'), '0', false, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyOptionNotPresentByLabel(findTestObject('Dropdown/dropDown'), '100', false, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyOptionNotPresentByValue(findTestObject('Dropdown/dropDown'), '500', false, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByIndex(findTestObject('Dropdown/dropDown'), 1, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyOptionSelectedByIndex(findTestObject('Dropdown/dropDown'), 1, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Dropdown/dropDown'), '10', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyOptionSelectedByLabel(findTestObject('Dropdown/dropDown'), '10', false, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyOptionNotSelectedByLabel(findTestObject('Dropdown/dropDown'), '30', false, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Dropdown/dropDown'), '15', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyOptionSelectedByValue(findTestObject('Dropdown/dropDown'), '15', false, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyOptionNotSelectedByValue(findTestObject('Dropdown/dropDown'), '20', false, 30, FailureHandling.STOP_ON_FAILURE)


WebUI.closeBrowser()

