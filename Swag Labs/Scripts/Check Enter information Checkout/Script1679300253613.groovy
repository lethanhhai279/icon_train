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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

'Define color'
String Red = 'rgba(226, 35, 26, 1)'
String Black = 'rgba(19, 35, 34, 1)'

'Define name of product'
String BikeLight     = "Sauce Labs Bike Light";

'login Product page'
CustomKeywords.'swagLabs.Page.setup_login'()

'Click add BikeLight'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct"): BikeLight]))

'click  My Cart button'
WebUI.click(findTestObject('Object Repository/My Cart'))

'click Checkout button '
WebUI.click(findTestObject('Object Repository/CheckoutButton'))

'verify First Name and Last Name character only'
boolean bverifyFirstName = CustomKeywords.'swagLabs.CheckData.OnlyCharacter'(firstName)
boolean bverifyLastName = CustomKeywords.'swagLabs.CheckData.OnlyCharacter'(lastName)


if((bverifyFirstName == true) && (bverifyLastName == true)) {
	'Enter First Name, Last Name and Zip'
	WebUI.setText(findTestObject('Object Repository/Checkout/FisrtName'),firstName)
	WebUI.setText(findTestObject('Object Repository/Checkout/LastName'), lastName)
	WebUI.setText(findTestObject('Object Repository/Checkout/Zip'), Zip)
	
	KeywordUtil.markPassed("Login successful")
	WebUI.takeFullPageScreenshot()
}
else {
	KeywordUtil.markFailed("Login not successful")
}

WebUI.closeBrowser()

