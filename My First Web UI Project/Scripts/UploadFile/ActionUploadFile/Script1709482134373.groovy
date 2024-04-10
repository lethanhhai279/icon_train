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
import internal.GlobalVariable
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.By
import org.openqa.selenium.Keys as Keys

//WebUI.openBrowser("https://demoqa.com/upload-download", FailureHandling.STOP_ON_FAILURE)
WebUI.openBrowser("https://www.iconplc.com/", FailureHandling.STOP_ON_FAILURE)

////'Prepare file to upload'
//String filePath = "D:\\lthai2\\katlon\\"
//
////WebUI.uploadFile(findTestObject("UploadFile/uploadFileObj"), filePath, FailureHandling.STOP_ON_FAILURE)
////WebUI.click(findTestObject("UploadFile/downLoad"))
//
////WebUI.getNumberOfTotalOption(findTestObject)
//WebUI.sendKeys(findTestObject("UploadFile/uploadFileObj"), filePath)
//
//
////WebUI.closeBrowser()
//WebDriver driver = DriverFactory.getW
//JavascriptExecutor js = (JavascriptExecutor)driver
//WebUI.click(findTestObject)
//WebUI.switchToFrame(findTestObject, 0)
//WebUI.switchToWindowIndex(findTestCase)
//WebUI.switchToFrame(findTestObject, 0)
WebUI.getCSSValue(findTestObject('css'), 'font-style')

WebDriver driver = new ChromeDriver();
// Mở trang web
driver.get("https://example.com");

// Định danh textbox bằng ID, Name, hoặc XPath
WebElement textBox = driver.findElement(By.id("yourTextBoxId"));

// Nhập liệu vào textbox
textBox.sendKeys("Hello, Selenium!");

// Đóng trình duyệt
driver.quit();


