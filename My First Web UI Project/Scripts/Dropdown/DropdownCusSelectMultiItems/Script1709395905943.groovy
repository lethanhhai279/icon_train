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
import internal.GlobalVariable

import org.openqa.selenium.By
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://mdbootstrap.com/docs/b4/jquery/forms/select/', FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Dropdown/DynamicSingleDropDown'), FailureHandling.STOP_ON_FAILURE)

List<String> selectItems = ['Option 1', 'Option 2', 'Option 3']

List<WebElement> listElement = WebUI.findWebElements(findTestObject('Dropdown/DynamicSingleDropDown'), 2, FailureHandling.STOP_ON_FAILURE)

for(WebElement item in listElement) {
	WebElement eleLabel = item.findElement(By.xpath("./span"))
	String label = eleLabel.getText().trim()
	
	WebElement eleInput = eleLabel.findElement(By.xpath("./input"))
	boolean state = eleInput.isSelected()
	
	if (selectedItems.contains(label) && !state){
		eleInput.click()
	}
}

WebUI.closeBrowser()