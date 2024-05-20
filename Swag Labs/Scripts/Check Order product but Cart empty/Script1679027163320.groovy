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
String Fleece_Jacket = "Sauce Labs Fleece Jacket";
String T_Shirt_Red   = "Test.allTheThings() T-Shirt (Red)";

'login Product page'
CustomKeywords.'swagLabs.Page.setup_login'()

'click My Cart button'
WebUI.click(findTestObject('Object Repository/Cart'))

'verify go to Your Cart page'
CustomKeywords.'swagLabs.Page.GoToPage'("Your Cart")

'click Checkout button'
WebUI.click(findTestObject('Object Repository/CheckoutButton'))

'verify go to Checkout: Your Information page'
CustomKeywords.'swagLabs.Page.GoToPage'("Checkout: Your Information")

'Enter FistName LastName Zip'
WebUI.setText(findTestObject('Object Repository/Checkout/FisrtName'),"Luong")
WebUI.setText(findTestObject('Object Repository/Checkout/LastName'), "Gia Han")
WebUI.setText(findTestObject('Object Repository/Checkout/Zip'), "123")

'SreenShort after Enter  FistName LastName Zip'
WebUI.takeFullPageScreenshot()

'click Continue button'
WebUI.click(findTestObject('Object Repository/Checkout/CotinueButton'))

'verify go to Checkout: Overview page'
CustomKeywords.'swagLabs.Page.GoToPage'("Checkout: Overview")

'verify price'
CustomKeywords.'swagLabs.TotalPrice.verifyPrice'(0, 0)

'click finish button'
WebUI.click(findTestObject('Object Repository/Checkout/FinishButton'))

'verify can not go to Checkout: Complete! page '
CustomKeywords.'swagLabs.Page.CanNotGoToPage'("Checkout: Complete!")

'click Back to button'
WebUI.click(findTestObject('Object Repository/Back to Button'))

'reset page'
CustomKeywords.'swagLabs.ResetPage.resetPage'()

'verify go to Products page'
CustomKeywords.'swagLabs.Page.GoToPage'("Products")

'click add T_Shirt_Red'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct") : T_Shirt_Red]))

'verify text and color of Backpack button'
CustomKeywords.'swagLabs.verifyTextAndColorOfButton.TextandColor'(T_Shirt_Red, "Remove", Red)

'Verify the number of product in Cart'
CustomKeywords.'swagLabs.findTheNumber.theNumberOfProductInCart'(1)

'click add T_Shirt_Red'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct") : Fleece_Jacket]))

'verify text and color of Backpack button'
CustomKeywords.'swagLabs.verifyTextAndColorOfButton.TextandColor'(Fleece_Jacket, "Remove", Red)

'Verify the number of product in Cart'
CustomKeywords.'swagLabs.findTheNumber.theNumberOfProductInCart'(2)

'click Cart button'
WebUI.click(findTestObject('Object Repository/My Cart'))

'very go to Your Cart page'
CustomKeywords.'swagLabs.Page.GoToPage'("Your Cart")

'click Remove T_Shirt_Red'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct") : T_Shirt_Red]))

'click Remove T_Shirt_Red'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct") : Fleece_Jacket]))

'Verify Cart empty'
CustomKeywords.'swagLabs.findTheNumber.CartEmpty'()

'click Checkout button'
WebUI.click(findTestObject('Object Repository/CheckoutButton'))

'verify go to Checkout: Your Information page'
CustomKeywords.'swagLabs.Page.GoToPage'("Checkout: Your Information")

'Enter FistName LastName Zip'
WebUI.setText(findTestObject('Object Repository/Checkout/FisrtName'),"Luong")
WebUI.setText(findTestObject('Object Repository/Checkout/LastName'), "Gia Han")
WebUI.setText(findTestObject('Object Repository/Checkout/Zip'), "123")

'SreenShort after Enter  FistName LastName Zip'
WebUI.takeFullPageScreenshot()

'click Continue button'
WebUI.click(findTestObject('Object Repository/Checkout/CotinueButton'))

'verify go to Checkout: Overview page'
CustomKeywords.'swagLabs.Page.GoToPage'("Checkout: Overview")

'verify price'
CustomKeywords.'swagLabs.TotalPrice.verifyPrice'(0, 0)

'click finish button'
WebUI.click(findTestObject('Object Repository/Checkout/FinishButton'))

'verify can not go to Checkout: Complete! page '
CustomKeywords.'swagLabs.Page.CanNotGoToPage'("Checkout: Complete!")

WebUI.closeBrowser()