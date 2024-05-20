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
String BikeLight     = "Sauce Labs Bike Light";
String BoltT_Shirt   = "Sauce Labs Bolt T-Shirt";

'login Product page'
CustomKeywords.'swagLabs.Page.setup_login'()

'click title of BikeLight'
WebUI.click(findTestObject('Object Repository/Title of Product',[("sTitleofProduct") : BikeLight]))

'Sreenshort Details page'
WebUI.takeFullPageScreenshot()

'click add of BikeLight button'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct") : BikeLight]))

'verify text and color of BikeLight button'
CustomKeywords.'swagLabs.verifyTextAndColorOfButton.TextandColor'(BikeLight, "Remove", Red)
	
'verify the number of product in Cart '	
CustomKeywords.'swagLabs.findTheNumber.theNumberOfProductInCart'(1)

'click remove of BikeLight button'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct") : BikeLight]))

'verify text and color of BikeLight button'
CustomKeywords.'swagLabs.verifyTextAndColorOfButton.TextandColor'(BikeLight, "Add to cart", Black)
	
'verify the number of product in Cart '
CustomKeywords.'swagLabs.findTheNumber.CartEmpty'()

'click add of BikeLight button'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct") : BikeLight]))

'verify text and color of BikeLight button'
CustomKeywords.'swagLabs.verifyTextAndColorOfButton.TextandColor'(BikeLight, "Remove", Red)
	
'verify the number of product in Cart '
CustomKeywords.'swagLabs.findTheNumber.theNumberOfProductInCart'(1)

'Back to Products page'
WebUI.click(findTestObject('Object Repository/Back to Products_Button'))

'Sreenshort back to product page '
WebUI.takeScreenshot()

'click title of BikeLight'
WebUI.click(findTestObject('Object Repository/Title of Product',[("sTitleofProduct") : BoltT_Shirt]))

'Sreenshort Details page'
WebUI.takeFullPageScreenshot()

'click add of BikeLight button'
WebUI.click(findTestObject('Object Repository/product_button',[("sNameProduct") : BoltT_Shirt]))

'verify text and color of BikeLight button'
CustomKeywords.'swagLabs.verifyTextAndColorOfButton.TextandColor'(BoltT_Shirt, "Remove", Red)
	
'verify the number of product in Cart '
CustomKeywords.'swagLabs.findTheNumber.theNumberOfProductInCart'(2)


WebUI.closeBrowser()