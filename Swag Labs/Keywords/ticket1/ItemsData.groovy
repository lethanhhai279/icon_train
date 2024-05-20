package ticket1

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.util.HashMap;

public class ItemsData {
	public static getData() {
		// *** Description: Funct dùng để lấy items data trong excel file ***
		// *** Return: HashMap<String, HashMap<String, String>>
		// 		VD: {Sauce Labs Backpack={Description=ABC, Price=29.99, Picture=ABC.jpg}}

		// khởi tạo HashMap in HashMap
		HashMap<String, HashMap<String, String>> items = new HashMap<String, HashMap<String, String>>();

		FileInputStream file = new FileInputStream("D:/Docs/Katalon/Swag Labs/items.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		// tạo HashMap chứa thông tin của item
		HashMap<String, String>[] ListhHashMap = new HashMap[sheet.getLastRowNum()];
		// Add data into HashMap
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			//bỏ dòng tiêu đề
			Row row = sheet.getRow(i+1)
			// Khai báo HashMap thứ i
			ListhHashMap[i] = new HashMap<String, String>();
			for (int j = 1; j < row.getLastCellNum(); j++) {
				String key = sheet.getRow(0).getCell(j)
				ListhHashMap[i].put(key, String.valueOf(row.getCell(j)));
			}
		}
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			String key = sheet.getRow(i+1).getCell(0)
			items.put(key, ListhHashMap[i])
		}
		return items
	}

	@Keyword
	public static verifyItemInformation(String s_itemName) {
		// xpath: //div[*/div[text()="Sauce Labs Bike Light"] and div[text()="A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."]]//following-sibling::div[div[text()="9.99"]]
		HashMap<String, HashMap<String, String>> iteamsData = getData()
		HashMap<String, String> iteamData = iteamsData.get(s_itemName)
		boolean b_verifyItem =  WebUI.verifyElementVisible(findTestObject("Ticket1/Items/Picture Items",[('Picture'):iteamData.get("Picture"),('ItemName'):s_itemName,('Description'):iteamData.get("Description"), ('Price'):iteamData.get("Price")]), FailureHandling.CONTINUE_ON_FAILURE)
		if (b_verifyItem == true) {
			KeywordUtil.markPassed("Item Information of " + s_itemName + " is correct");
			WebUI.takeFullPageScreenshot()
		}
		else {
			KeywordUtil.markFailed("Item Information of " + s_itemName + " is not correct")
		}
	}

	@Keyword
	public static verifyAllItemInformation() {
		// xpath: //div[*/div[text()="Sauce Labs Bike Light"] and div[text()="A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."]]//following-sibling::div[div[text()="9.99"]]
		HashMap<String, HashMap<String, String>> iteamsData = getData()

		for (String s_itemName : iteamsData.keySet()) {
			HashMap<String, String> iteamData = iteamsData.get(s_itemName)
			boolean b_verifyItem =  WebUI.verifyElementVisible(findTestObject("Ticket1/Items/Picture Items",[('Picture'):iteamData.get("Picture"),('ItemName'):s_itemName,('Description'):iteamData.get("Description"), ('Price'):iteamData.get("Price")]), FailureHandling.CONTINUE_ON_FAILURE)
			if (b_verifyItem == true) {
				KeywordUtil.markPassed("Item Information of " + s_itemName + " is correct");
				WebUI.takeFullPageScreenshot()
			}
			else {
				KeywordUtil.markFailed("Item Information of " + s_itemName + " is not correct")
			}
		}
	}

	@Keyword
	public static verifyTextAndColorOfButton (String itemName, String exceptedText, String exceptedColor) {

		'get actual text and color'
		String actualText = WebUI.getText(findTestObject('Ticket1/Items/Items Button',[("ItemName"): itemName]))
		String actualColor = WebUI.getCSSValue(findTestObject('Ticket1/Items/Items Button',[("ItemName"): itemName]), 'color')

		'verify text'
		boolean b_VerifyTextOfButton = WebUI.verifyElementText(findTestObject('Ticket1/Items/Items Button',[("ItemName"): itemName]), exceptedText, FailureHandling.CONTINUE_ON_FAILURE)
		if(b_VerifyTextOfButton == true) {
			KeywordUtil.markPassed("Text of button: "+ actualText )
		}
		else {
			KeywordUtil.markFailed("Excepted Text:" + "Actual Text:" + actualText)
		}

		'verify color'
		boolean b_VerifyColorOfButton = WebUI.verifyEqual(actualColor,exceptedColor,FailureHandling.CONTINUE_ON_FAILURE )
		if(b_VerifyColorOfButton == true) {
			KeywordUtil.markPassed("Color of button is corrcet")
		}
		else {
			KeywordUtil.markFailed(" Excepted color of button: " + exceptedColor + "and Actual color:" + actualColor)
		}

		'Sreenshort Element Backpack button '
		WebUI.takeElementScreenshot(findTestObject('Ticket1/Items/Items Button',[("ItemName"): itemName]))
	}

	@Keyword
	public static addClickAndVerifyAllItemsFromProductsPgage (String exceptedText, String exceptedColor) {
		HashMap<String, HashMap<String, String>> iteamsData = getData()
		int numberOfCart
		if (exceptedText == "Remove") {
			numberOfCart = 1
		}
		else {
			numberOfCart = 5
		}
		for (String s_itemName : iteamsData.keySet()) {
			HashMap<String, String> iteamData = iteamsData.get(s_itemName)
			WebUI.click(findTestObject('Ticket1/Items/Items Button', [('ItemName') : s_itemName]))
			//verify button
			verifyTextAndColorOfButton(s_itemName, exceptedText, exceptedColor)
			//Verify number of cart
			if (exceptedText == "Remove") {
				verifyNumberOfProductInCart(numberOfCart)
				//Verify information in your cart page
				WebUI.click(findTestObject('Ticket1/Main Page/Your Cart'))
				boolean b_verifyItem =  WebUI.verifyElementVisible(findTestObject("Ticket1/Items/Items In Your Cart",[('ItemName'):s_itemName,('Description'):iteamData.get("Description"), ('Price'):iteamData.get("Price")]), FailureHandling.CONTINUE_ON_FAILURE)
				if (b_verifyItem == true) {
					KeywordUtil.markPassed("In Your cart page, Item Information of " + s_itemName + " is correct");
					WebUI.takeFullPageScreenshot()
				}
				else {
					KeywordUtil.markFailed("In Your cart page, Item Information of " + s_itemName + " is not correct")
				}
				WebUI.click(findTestObject('Ticket1/Main Page/Continue Shopping Button'))

				numberOfCart += 1
			}
			else {
				verifyNumberOfProductInCart(numberOfCart)
				//Verify information in your cart page
				WebUI.click(findTestObject('Ticket1/Main Page/Your Cart'))
				boolean b_verifyItem =  WebUI.verifyElementNotPresent(findTestObject("Ticket1/Items/Items In Your Cart",[('ItemName'):s_itemName,('Description'):iteamData.get("Description"), ('Price'):iteamData.get("Price")]), 10, FailureHandling.CONTINUE_ON_FAILURE)
				if (b_verifyItem == true) {
					KeywordUtil.markPassed("In Your cart page, Item Information of " + s_itemName + " is removed");
					WebUI.takeFullPageScreenshot()
				}
				else {
					KeywordUtil.markFailed("In Your cart page, Item Information of " + s_itemName + " is not removed")
				}
				WebUI.click(findTestObject('Ticket1/Main Page/Continue Shopping Button'))

				numberOfCart -= 1
			}
		}
	}

	@Keyword
	public static addClickAndVerifyAllItemsFromDetailPgage (String exceptedText, String exceptedColor) {
		HashMap<String, HashMap<String, String>> iteamsData = getData()
		int numberOfCart
		if (exceptedText == "Remove") {
			numberOfCart = 1
		}
		else {
			numberOfCart = 5
		}
		for (String s_itemName : iteamsData.keySet()) {
			//Go to detail products gape
			WebUI.click(findTestObject('Ticket1/Items/ItemName', [('ItemName') : s_itemName]))
			//click button
			WebUI.click(findTestObject('Ticket1/Items/Items Button', [('ItemName') : s_itemName]))
			//verify button in detail page
			verifyTextAndColorOfButton(s_itemName, exceptedText, exceptedColor)
			//Verify number of cart
			if (exceptedText == "Remove") {
				verifyNumberOfProductInCart(numberOfCart)
				numberOfCart += 1
			}
			else {
				verifyNumberOfProductInCart(numberOfCart)
				numberOfCart -= 1
			}
			WebUI.click(findTestObject('Ticket1/Items/Back to products button'))

			//verify button in product page
			verifyTextAndColorOfButton(s_itemName, exceptedText, exceptedColor)
		}
	}

	@Keyword
	public static verifyAllItemsInDetailItemPgage (String exceptedText, String exceptedColor) {
		HashMap<String, HashMap<String, String>> iteamsData = getData()
		for (String s_itemName : iteamsData.keySet()) {
			HashMap<String, String> iteamData = iteamsData.get(s_itemName)
			WebUI.click(findTestObject('Ticket1/Items/ItemName', [('ItemName') : s_itemName]))
			//verify button
			verifyTextAndColorOfButton(s_itemName, exceptedText, exceptedColor)
			//Verify information
			boolean b_verifyItem =  WebUI.verifyElementVisible(findTestObject("Ticket1/Items/Detail Items",[('Picture'):iteamData.get("Picture"),('ItemName'):s_itemName,('Description'):iteamData.get("Description"), ('Price'):iteamData.get("Price")]), FailureHandling.CONTINUE_ON_FAILURE)
			if (b_verifyItem == true) {
				KeywordUtil.markPassed("Item Information of " + s_itemName + " is correct");
				WebUI.takeFullPageScreenshot()
			}
			else {
				KeywordUtil.markFailed("Item Information of " + s_itemName + " is not correct")
			}

			WebUI.click(findTestObject('Ticket1/Items/Back to products button'))
		}
	}


	@Keyword
	public static verifyNumberOfProductInCart(int expectedNumber) {
		if (expectedNumber == 0) {
			CartEmpty ()
			return
		}
		'Get the number of product'
		String s_numberofProduct = WebUI.getText(findTestObject('Ticket1/Items/Cart icon'))
		int i_numberofProduct = Integer.parseInt(s_numberofProduct);

		boolean b_verifyTheNumber = WebUI.verifyEqual(i_numberofProduct,expectedNumber, FailureHandling.CONTINUE_ON_FAILURE )

		if(b_verifyTheNumber == true ) {
			KeywordUtil.markPassed("The number of product in Cart:  " + expectedNumber )
		}
		else {
			KeywordUtil.markFailed("The expected number of product in Cart: " + expectedNumber + "But Actual: "  + i_numberofProduct)
		}

		'Sreenshort Element Cart'
		WebUI.takeElementScreenshot(findTestObject('Ticket1/Items/Cart icon'))
	}

	@Keyword
	public static CartEmpty () {
		boolean bEmpty = WebUI.verifyElementNotPresent(findTestObject('Ticket1/Items/Cart icon'), 10, FailureHandling.CONTINUE_ON_FAILURE )
		if(bEmpty == true) {
			KeywordUtil.markPassed("Cart empty")
		}
		else {
			KeywordUtil.markFailed("Cart has product")
		}
		'Sreenshort Element Cart'
		WebUI.takeElementScreenshot(findTestObject('Ticket1/Main Page/Your Cart'))

		return bEmpty
	}
}
