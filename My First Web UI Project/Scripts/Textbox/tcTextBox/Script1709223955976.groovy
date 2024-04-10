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

WebUI.openBrowser('https://demoqa.com/text-box')

WebUI.click(findTestObject('Submit/choseTest'))

WebUI.setText(findTestObject('Submit/fullName'), Username)

WebUI.setText(findTestObject('Submit/Email'), Password)

WebUI.setText(findTestObject('Submit/currentAddress'), 'Tien Giang')

WebUI.setText(findTestObject('Submit/permanentAddress'), 'Tien Giang')

WebUI.scrollToElement(findTestObject('Submit/button_submit'), 5)

WebUI.click(findTestObject('Submit/button_submit'))

WebUI.verifyElementText(findTestObject('Submit/nameSubmited'), 'Name:lthai2')

WebUI.verifyElementText(findTestObject('Submit/emailSubmitted'), 'Email:lethanhhai06122000.ltp@gmail.com')

WebUI.verifyElementText(findTestObject('Submit/addrSubmitted'), 'Current Address :Tien Giang')

WebUI.verifyElementText(findTestObject('Submit/perAddrSubmitted'), 'Permananet Address :Tien Giang')

WebUI.closeBrowser()

