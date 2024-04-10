import data.DataLoginPage
import data.DataShoppingPage
import data.DataCheckoutPage
import commonAction.ActionCommon
import page.ShoppingPage
import object.MyCartObject
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
import com.kms.katalon.core.util.KeywordUtil as log

'Open the web page'
WebUI.openBrowser('')

'Test login and verify'
CustomKeywords.'page.Login.loginAndVerify'(DataLoginPage.URL, DataLoginPage.USER_NAME_STANDAR, DataLoginPage.PASS_WORD, DataLoginPage.ATTEMPT, DataLoginPage.URL_LOGIN_SUCCESS)

'Add item to cart'
boolean itemAddedToCart = CustomKeywords.'page.ShoppingPage.addItemToCartAndVerify'(DataShoppingPage.ITEM_NAME)
if (itemAddedToCart != null) {
    if (itemAddedToCart) {
        log.markPassed( DataShoppingPage.ITEM_NAME + " added to cart successfully")
    } else {
        log.markFailed("Error when add: " + DataShoppingPage.ITEM_NAME + " to cart")
    }
} else {
    log.markFailed('Cannot detect status of : ' + DataShoppingPage.ITEM_NAME)
}

'Remove item from cart'
boolean itemRemovedToCart = CustomKeywords.'page.ShoppingPage.removeItemToCartAndVerify'(DataShoppingPage.ITEM_NAME)
if (itemRemovedToCart != null) {
    if (itemRemovedToCart) {
        log.markPassed('Removed: ' + DataShoppingPage.ITEM_NAME)
    } else {
        log.markFailed('Error removing ' + DataShoppingPage.ITEM_NAME)
    }
} else {
    log.markFailed('Cannot check status of item: ' + DataShoppingPage.ITEM_NAME)
}

'Checkout item after add to cart again'
boolean itemAddedToCart_2 = CustomKeywords.'page.ShoppingPage.addItemToCartAndVerify'(DataShoppingPage.ITEM_NAME)
if (itemAddedToCart_2 != null) {
	if (itemAddedToCart_2) {
		log.markPassed( DataShoppingPage.ITEM_NAME + " added to cart successfully")
	} else {
		log.markFailed("Error when add: " + DataShoppingPage.ITEM_NAME + " to cart")
	}
} else {
	log.markFailed('Cannot detect status of : ' + DataShoppingPage.ITEM_NAME)
}

'Fill in to form infomation to checkout'
CustomKeywords.'page.MyCartPage.fillInToForm'(DataCheckoutPage.first_Name, DataCheckoutPage.last_Name, DataCheckoutPage.postal_Code)

'Verify before checkout'
if(CustomKeywords.'page.MyCartPage.verifyCheckout'()) {
	log.markPassed("Checkout successfully")
}
else {
	log.markFailed("Checkout failed")
}

'Click finish button and take a screen shot'
ActionCommon.click(MyCartObject.FINISH_BUTTON)
WebUI.takeFullPageScreenshot()
log.markPassed("Finish checkout")

'Close browser'
WebUI.closeBrowser()

