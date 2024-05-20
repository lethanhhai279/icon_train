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
String BikeLight     = "Sauce Labs Bike Light";
String BoltT_Shirt   = "Sauce Labs Bolt T-Shirt";
String Onesie        = "Sauce Labs Onesie";

'login Product page'
CustomKeywords.'swagLabs.Page.setup_login'()

'Click add BikeLight'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct"): BikeLight]))

'verify text and color of BikeLight '
CustomKeywords.'swagLabs.verifyTextAndColorOfButton.TextandColor'(BikeLight, "Remove", Red)

'Click add Onesie'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct"): Onesie]))

'verify text and color of Onesie '
CustomKeywords.'swagLabs.verifyTextAndColorOfButton.TextandColor'(Onesie, "Remove", Red)

'Click add BoltT_Shirt'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct"): BoltT_Shirt]))

'verify text and color of BoltT_Shirt '
CustomKeywords.'swagLabs.verifyTextAndColorOfButton.TextandColor'(BoltT_Shirt, "Remove", Red)

'click  My Cart button'
WebUI.click(findTestObject('Object Repository/My Cart'))

'verify go to Your Cart page'
CustomKeywords.'swagLabs.Page.GoToPage'("Your Cart")

'Create list contains expected product'
List<String> ExpectListProduct = new ArrayList<String>();
ExpectListProduct.add(BikeLight);
ExpectListProduct.add(Onesie);
ExpectListProduct.add(BoltT_Shirt);

'Find and verify the number of product in Cart'
int iNum = CustomKeywords.'swagLabs.findTheNumber.theNumberOfProductInCart'(3)

'verify product contains in Cart'
CustomKeywords.'swagLabs.findTheNumber.ProductInCart'(iNum, ExpectListProduct)

'click Checkout button '
WebUI.click(findTestObject('Object Repository/CheckoutButton'))

'verify go to Checkout: Your Information page'
CustomKeywords.'swagLabs.Page.GoToPage'("Checkout: Your Information")

'Enter First Name, Last Name and Zip'
WebUI.setText(findTestObject('Object Repository/Checkout/FisrtName'),"Luong")
WebUI.setText(findTestObject('Object Repository/Checkout/LastName'), "Gia Han")
WebUI.setText(findTestObject('Object Repository/Checkout/Zip'), "123")

'Sreenshort after enter FirstName, LastName anf Zip '
WebUI.takeFullPageScreenshot()

'Click Continue button'
WebUI.click(findTestObject('Object Repository/Checkout/CotinueButton'))

'verify go to Checkout: Overview page'
CustomKeywords.'swagLabs.Page.GoToPage'("Checkout: Overview")	

'Click Finish Button'
WebUI.click(findTestObject('Object Repository/Checkout/FinishButton'))

'verify go to Checkout: Complete! page'
CustomKeywords.'swagLabs.Page.GoToPage'("Checkout: Complete!")

WebUI.closeBrowser()