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

WebUI.openBrowser("https://www.iconplc.com/insights/digital-disruption/ai-and-clinical-trials/using-ai-for-site-id-and-selection")
WebUI.maximizeWindow()
WebUI.scrollToElement(findTestObject("Object Repository/dry_run_6/downloadButton"), 5)
WebUI.click(findTestObject("Object Repository/dry_run_6/downloadButton"))
WebUI.switchToFrame(findTestObject("Object Repository/dry_run_6/iFrame"), 5)
public static void inputField(String fieldName, String inputValue) {
	WebUI.setText(findTestObject("Object Repository/dry_run_6/input",[('field'):fieldName]), inputValue)
	}
inputField("email","lethanhhai")