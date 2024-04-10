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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement

WebUI.openBrowser("https://katalon-test.s3.amazonaws.com/aut/html/iframe.html", FailureHandling.STOP_ON_FAILURE)
WebUI.maximizeWindow(FailureHandling.STOP_ON_FAILURE)

//Get test object iframe nested
TestObject iframe_nested = findTestObject("iFrame/nested_iframe")

//Get test object first name
TestObject inputInsideFrame = findTestObject("iFrame/txt_FirstName")

//Switch to Frame
WebUI.switchToFrame(findTestObject("iFrame/SwithIframe"), 2, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(inputInsideFrame, "Le Thanh", FailureHandling.STOP_ON_FAILURE)

//Get size of element txt_Firstname
//Because we are in iframe, size of element txt_Firstname = 1
List<WebElement> foundElements = WebUiCommonHelper.findWebElements(inputInsideFrame, 2)
WebUI.verifyEqual(foundElements.size(), 1, FailureHandling.STOP_ON_FAILURE)

//Clear and send new String
foundElements[1].setText("Thanh Hai")

WebUI.switchToDefaultContent()

//Get size of element txt_Firstname again
foundElements = WebUiCommonHelper.findWebElements(inputInsideFrame, 2)
// Verify that the input element inside iframe cannot be found because we have switched to default content'
// Now, we are not in iframe. So, size of element txt_Firstname = 0'
WebUI.verifyEqual(foundElements.size(),0)

WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)