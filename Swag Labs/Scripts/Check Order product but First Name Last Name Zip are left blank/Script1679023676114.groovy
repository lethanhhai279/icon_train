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
String Red   = "rgba(226, 35, 26, 1)";
String Black = "rgba(19, 35, 34, 1)";

'Difine name of product'
String Backpack      = "Sauce Labs Backpack";
String Fleece_Jacket = "Sauce Labs Fleece Jacket";

'login Product page'
CustomKeywords.'swagLabs.Page.setup_login'()

'click add of Backpack button'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct") : Backpack]))

'verify text and color of Backpack button'
CustomKeywords.'swagLabs.verifyTextAndColorOfButton.TextandColor'(Backpack, "Remove", Red)

'Verify the number of product in Cart'
CustomKeywords.'swagLabs.findTheNumber.theNumberOfProductInCart'(1)

'click title of Fleece_Jacket button'
WebUI.click(findTestObject('Object Repository/Title of Product',[("sTitleofProduct"):Fleece_Jacket]))

'click add of Fleece_Jacket button'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct") : Fleece_Jacket]))

'verify text and color of Fleece_Jacket button'
CustomKeywords.'swagLabs.verifyTextAndColorOfButton.TextandColor'(Fleece_Jacket, "Remove", Red)

'Verify the number of product in Cart'
CustomKeywords.'swagLabs.findTheNumber.theNumberOfProductInCart'(2)

'Click My Cart Button'
WebUI.click(findTestObject('Object Repository/My Cart'))

'verify go to Your Cart page'
CustomKeywords.'swagLabs.Page.GoToPage'("Your Cart")

'Click Check out button'
WebUI.click(findTestObject('Object Repository/CheckoutButton'))

'verify go to Checkout: Your Information page'
CustomKeywords.'swagLabs.Page.GoToPage'("Checkout: Your Information")

'Click Continue Button'
WebUI.click(findTestObject('Object Repository/Checkout/CotinueButton'))

'Verify error present and Can not go to Checkout: Overview page'
CustomKeywords.'swagLabs.Error.FindErrorAndGoToPage'()

'Enter FistName'
WebUI.setText(findTestObject('Object Repository/Checkout/FisrtName'),"Luong")

'Click Continue Button'
WebUI.click(findTestObject('Object Repository/Checkout/CotinueButton'))

'Verify error present and Can not go to Checkout: Overview page'
CustomKeywords.'swagLabs.Error.FindErrorAndGoToPage'()

'Enter LastName'
WebUI.setText(findTestObject('Object Repository/Checkout/LastName'), "Gia Han")

'Click Continue Button'
WebUI.click(findTestObject('Object Repository/Checkout/CotinueButton'))

'Verify error present and Can not go to Checkout: Overview page'
CustomKeywords.'swagLabs.Error.FindErrorAndGoToPage'()

'Enter Zip'
WebUI.setText(findTestObject('Object Repository/Checkout/Zip'), "123")

'Click Continue Button'
WebUI.click(findTestObject('Object Repository/Checkout/CotinueButton'))

'Verify go to Checkout: Overview page'
CustomKeywords.'swagLabs.Page.GoToPage'("Checkout: Overview")

'click Finish button'
WebUI.click(findTestObject('Object Repository/Checkout/FinishButton'))

'Verify go to Checkout: Complete! page'
CustomKeywords.'swagLabs.Page.GoToPage'("Checkout: Complete!")

WebUI.closeBrowser()