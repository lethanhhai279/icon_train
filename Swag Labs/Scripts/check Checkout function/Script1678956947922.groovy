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

import groovy.ui.SystemOutputInterceptor
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
'Define color'
String Red   = "rgba(226, 35, 26, 1)";
String Black = "rgba(19, 35, 34, 1)";

'Difine name of product'
String Backpack      = "Sauce Labs Backpack";
String BikeLight     = "Sauce Labs Bike Light";
String BoltT_Shirt   = "Sauce Labs Bolt T-Shirt";
String Fleece_Jacket = "Sauce Labs Fleece Jacket";

'login Product page'
CustomKeywords.'swagLabs.Page.setup_login'()

'click add of Backpack button'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct") : Backpack]))

'click add of BikeLight button'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct") : BikeLight]))

'click add of BoltT_Shirt button'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct") : BoltT_Shirt]))

'verify the number of product in Cart'
int iNumber = CustomKeywords.'swagLabs.findTheNumber.theNumberOfProductInCart'(3)

'click Cart button'
WebUI.click(findTestObject('Object Repository/My Cart'))

'verify go to page'
CustomKeywords.'swagLabs.Page.GoToPage'("Your Cart")

'Create list contains product'
List<String> TotalProductCart = new ArrayList<String>();
TotalProductCart.add(Backpack)
TotalProductCart.add(BikeLight)
TotalProductCart.add(BoltT_Shirt)

'verify cart contains enough product'
CustomKeywords.'swagLabs.findTheNumber.ProductInCart'(iNumber, TotalProductCart)

'click remove of Backpack button'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct") : Backpack]))

'verify the number of product in Cart'
int inum = CustomKeywords.'swagLabs.findTheNumber.theNumberOfProductInCart'(2)

'Create list contains product when remove Backpack '
TotalProductCart.remove(0)

'verify cart contains enough product'
CustomKeywords.'swagLabs.findTheNumber.ProductInCart'(inum, TotalProductCart)

'click continue shopping button'
WebUI.click(findTestObject('Object Repository/ContinueShoppingButton'))

'verify back to Products page'
CustomKeywords.'swagLabs.Page.GoToPage'("Products")

'click add of Fleece_Jacket button '
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct") : Fleece_Jacket]))

'click Cart button'
WebUI.click(findTestObject('Object Repository/My Cart'))

'verify go to page'
CustomKeywords.'swagLabs.Page.GoToPage'("Your Cart")

'verify the number of product in Cart'
int inumber = CustomKeywords.'swagLabs.findTheNumber.theNumberOfProductInCart'(3)

'Create list contains product when add Fleece_Jacket '
TotalProductCart.add(Fleece_Jacket)

'verify cart contains enough product'
CustomKeywords.'swagLabs.findTheNumber.ProductInCart'(inumber, TotalProductCart)

'click check out button '
WebUI.click(findTestObject('Object Repository/CheckoutButton'))

'verify go to Checkout: Your Information page'
CustomKeywords.'swagLabs.Page.GoToPage'("Checkout: Your Information")

'Enter FistName LastName Zip'
WebUI.setText(findTestObject('Object Repository/Checkout/FisrtName'),"Luong")
WebUI.setText(findTestObject('Object Repository/Checkout/LastName'), "Gia Han")
WebUI.setText(findTestObject('Object Repository/Checkout/Zip'), "123")

'SreenShort after Enter  FistName LastName Zip'
WebUI.takeFullPageScreenshot()

'click Continue Button'
WebUI.click(findTestObject('Object Repository/Checkout/CotinueButton'))

'verify go to Checkout: Overview page'
CustomKeywords.'swagLabs.Page.GoToPage'("Checkout: Overview")

'verify total price of product '
float price = CustomKeywords.'swagLabs.TotalPrice.findPriceOfProduct'(iNumber)

'get tax in bill'
float tax = CustomKeywords.'swagLabs.TotalPrice.getTaxInBill'()

'verify total'
CustomKeywords.'swagLabs.TotalPrice.verifyPrice'(price,tax)

'Click Finish button '
WebUI.click(findTestObject('Object Repository/Checkout/FinishButton'))

'verify go to Checkout: Complete! page'
CustomKeywords.'swagLabs.Page.GoToPage'("Checkout: Complete!")


WebUI.closeBrowser()