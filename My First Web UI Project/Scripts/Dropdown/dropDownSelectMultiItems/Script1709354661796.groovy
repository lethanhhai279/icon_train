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

WebUI.openBrowser('https://getbootstrap.com/docs/5.0/forms/select/', FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Dropdown/Multiple_Dropdown_Default'), 30, FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Dropdown/Multiple_Dropdown_Default'), 'Open this select menu', false, FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Dropdown/Multiple_Dropdown_Default'), 'One', false, FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Dropdown/Multiple_Dropdown_Default'), 'Two', false, FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Dropdown/Multiple_Dropdown_Default'), 'Three', false, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyOptionSelectedByLabel(findTestObject('Dropdown/Multiple_Dropdown_Default'), 'Open this select menu', false, 30, FailureHandling.STOP_ON_FAILURE)

WebUI.getNumberOfSelectedOption(findTestObject('Dropdown/Multiple_Dropdown_Default'), FailureHandling.STOP_ON_FAILURE)

WebUI.deselectOptionByLabel(findTestObject('Dropdown/Multiple_Dropdown_Default'), 'Open this select menu', false, FailureHandling.STOP_ON_FAILURE)

WebUI.getNumberOfSelectedOption(findTestObject('Dropdown/Multiple_Dropdown_Default'), FailureHandling.STOP_ON_FAILURE)

WebUI.deselectAllOption(findTestObject('Dropdown/Multiple_Dropdown_Default'), FailureHandling.STOP_ON_FAILURE)

WebUI.getNumberOfSelectedOption(findTestObject('Dropdown/Multiple_Dropdown_Default'), FailureHandling.STOP_ON_FAILURE)

WebUI.selectAllOption(findTestObject('Dropdown/Multiple_Dropdown_Default'), FailureHandling.STOP_ON_FAILURE)

WebUI.deselectOptionByIndex(findTestObject('Dropdown/Multiple_Dropdown_Default'), "0,3", FailureHandling.STOP_ON_FAILURE)

WebUI.deselectOptionByLabel(findTestObject('Dropdown/Multiple_Dropdown_Default'), 'Two', false, FailureHandling.STOP_ON_FAILURE)

WebUI.deselectOptionByValue(findTestObject('Dropdown/Multiple_Dropdown_Default'), '1', false, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()