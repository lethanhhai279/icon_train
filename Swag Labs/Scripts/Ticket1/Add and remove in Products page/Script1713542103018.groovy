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

//define Items
String item1 = 'Sauce Labs Backpack'

//define color
String Red = 'rgba(226, 35, 26, 1)'

String Black = 'rgba(19, 35, 34, 1)'

'Login'
CustomKeywords.'ticket1.Page.login'()

'Verify information of all items'
CustomKeywords.'ticket1.ItemsData.verifyAllItemInformation'()

'Click button to add item'
WebUI.click(findTestObject('Ticket1/Items/Items Button', [('ItemName') : 'Sauce Labs Backpack']))

'Verify the text and color of the button to make sure the button is changed from Add to cart  to Remove status'
CustomKeywords.'ticket1.ItemsData.verifyTextAndColorOfButton'('Sauce Labs Backpack', 'Remove', Red)

'Click button to remove item'
WebUI.click(findTestObject('Ticket1/Items/Items Button', [('ItemName') : 'Sauce Labs Backpack']))

'Verify the text and color of the button to make sure the button is changed from Remove to Add tocart status'
CustomKeywords.'ticket1.ItemsData.verifyTextAndColorOfButton'('Sauce Labs Backpack', 'Add to cart', Black)

'Click all buttons to add all items and verify them in products page'
CustomKeywords.'ticket1.ItemsData.addClickAndVerifyAllItemsFromProductsPgage'('Remove', Red)

'Verify button and information of all items after Adding to cart'
CustomKeywords.'ticket1.ItemsData.verifyAllItemsInDetailItemPgage'('Remove', Red)

'Click all buttons to remove all items and verify them in products page'
CustomKeywords.'ticket1.ItemsData.addClickAndVerifyAllItemsFromProductsPgage'('Add to cart', Black)


'Verify button and information of all items after removing to cart'
CustomKeywords.'ticket1.ItemsData.verifyAllItemsInDetailItemPgage'('Add to cart', Black)

'Close Browser'
WebUI.closeBrowser()
