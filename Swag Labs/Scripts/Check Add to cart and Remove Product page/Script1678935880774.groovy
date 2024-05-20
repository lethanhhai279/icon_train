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

'Define name of product'
String Backpack      = "Sauce Labs Backpack";
String BikeLight     = "Sauce Labs Bike Light";
String BoltT_Shirt   = "Sauce Labs Bolt T-Shirt";
String Fleece_Jacket = "Sauce Labs Fleece Jacket";
String Onesie        = "Sauce Labs Onesie";
String T_Shirt_Red   = "Test.allTheThings() T-Shirt (Red)";

'login Product page'
CustomKeywords.'swagLabs.Page.setup_login'()

'list product on page'
List<String> lProduct = new ArrayList<String>();
lProduct = CustomKeywords.'swagLabs.ProductsPage.ListProductPresentOnPage'(6)

'verify image and title of product clickable'
for(String i: lProduct) {
CustomKeywords.'swagLabs.ProductsPage.ImageAndTitleClickable'(i)
}

'click add Backpack'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct"): Backpack]))

'verify text and color of Backpack button'
CustomKeywords.'swagLabs.verifyTextAndColorOfButton.TextandColor'(Backpack, "Remove", Red)

'verify the number in Cart '
CustomKeywords.'swagLabs.findTheNumber.theNumberOfProductInCart'(1)

'click add Onesie'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct"): Onesie]))

'verify text and color of Onesie button '
CustomKeywords.'swagLabs.verifyTextAndColorOfButton.TextandColor'(Onesie,"Remove", Red)

'verify the number in Cart'
CustomKeywords.'swagLabs.findTheNumber.theNumberOfProductInCart'(2)

'Click remove Backpack'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct"): Backpack]))

'verify text and color of Backpack button'
CustomKeywords.'swagLabs.verifyTextAndColorOfButton.TextandColor'(Backpack, "Add to cart", Black)

'verify the number in Cart '
CustomKeywords.'swagLabs.findTheNumber.theNumberOfProductInCart'(1)

'click add Backpack'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct"): Backpack]))

'verify text and color of Backpack button'
CustomKeywords.'swagLabs.verifyTextAndColorOfButton.TextandColor'(Backpack, "Remove", Red)

'verify the number in Cart '
CustomKeywords.'swagLabs.findTheNumber.theNumberOfProductInCart'(2)

'Reset  page'
CustomKeywords.'swagLabs.ResetPage.resetPage'()

WebUI.closeBrowser()