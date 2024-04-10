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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//WebUI.openBrowser("https://demoqa.com/browser-windows", FailureHandling.STOP_ON_FAILURE)
WebUI.openBrowser("https://www.selenium.dev/documentation/webdriver/elements/locators/", FailureHandling.STOP_ON_FAILURE)


//WebUI.scrollToElement(findTestObject("Window_Tab/browserWindow"), 2, FailureHandling.STOP_ON_FAILURE)
//
//WebUI.getWindowIndex(FailureHandling.STOP_ON_FAILURE)
//
//WebUI.click(findTestObject("Window_Tab/newTabButton"), FailureHandling.STOP_ON_FAILURE)
//
//WebUI.switchToWindowIndex(1, FailureHandling.STOP_ON_FAILURE)
//
//WebUI.getWindowIndex(FailureHandling.STOP_ON_FAILURE)
//
////WebUI.closeWindowIndex("1", FailureHandling.STOP_ON_FAILURE)
////WebUI.switchToWindowIndex("0", FailureHandling.STOP_ON_FAILURE)
//
//
//
//WebUI.getWindowTitle(FailureHandling.STOP_ON_FAILURE)
//WebUI.switchToWindowTitle("DEMOQA", FailureHandling.STOP_ON_FAILURE)
//WebUI.getWindowTitle(FailureHandling.STOP_ON_FAILURE)
//
//WebUI.getUrl(FailureHandling.STOP_ON_FAILURE)
//
//WebUI.switchToWindowUrl("https://demoqa.com/sample", FailureHandling.STOP_ON_FAILURE)
//WebUI.getWindowIndex(FailureHandling.STOP_ON_FAILURE)
//
//WebUI.closeWindowTitle("DEMOQA", FailureHandling.STOP_ON_FAILURE)
//WebUI.closeWindowUrl("https://demoqa.com/sample",FailureHandling.STOP_ON_FAILURE)

//WebUI.getAllLinksOnCurrentPage(false, null)
println(WebUI.getAllLinksOnCurrentPage(false, null))

WebUI.sendKeys(findTestObject, null)

WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)