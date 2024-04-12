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

WebUI.openBrowser("https://demoqa.com/alerts", FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject("Alert/AlertContent"), 10, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject("Alert/butonClick"), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForAlert(10, FailureHandling.STOP_ON_FAILURE)
WebUI.getAlertText(FailureHandling.STOP_ON_FAILURE)
WebUI.verifyAlertPresent(2, FailureHandling.STOP_ON_FAILURE)
WebUI.acceptAlert(FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject("Alert/buttonClickAndWait"), FailureHandling.STOP_ON_FAILURE)
WebUI.waitForAlert(6, FailureHandling.STOP_ON_FAILURE)
WebUI.getAlertText(FailureHandling.STOP_ON_FAILURE)
WebUI.verifyAlertPresent(10, FailureHandling.STOP_ON_FAILURE)
WebUI.acceptAlert(FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject("Alert/buttonAlertConfirm"),FailureHandling.STOP_ON_FAILURE)
WebUI.waitForAlert(2, FailureHandling.STOP_ON_FAILURE)
WebUI.acceptAlert(FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject("Alert/promptButton"),FailureHandling.STOP_ON_FAILURE)
WebUI.waitForAlert(30, FailureHandling.STOP_ON_FAILURE)
WebUI.setAlertText("Le Thanh Hai", FailureHandling.STOP_ON_FAILURE)
WebUI.acceptAlert(FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()