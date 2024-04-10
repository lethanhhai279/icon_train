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
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.chrome.ChromeOptions

WebUI.openBrowser('')

// Lấy đối tượng WebDriver
WebDriver driver = DriverFactory.getWebDriver()

// Sử dụng JavaScript để điều hướng đến trang cài đặt Chrome
JavascriptExecutor js = (JavascriptExecutor)driver
driver.navigate().to('chrome://settings/appearance')

def element = js.executeScript("""
return document.querySelector('settings-ui').shadowRoot.querySelector('div#container').querySelector('settings-main#main').shadowRoot.querySelector('settings-basic-page.cr-centered-card-container').shadowRoot.querySelector('settings-section[page-title="Appearance"]').querySelector('settings-appearance-page').shadowRoot.querySelector('settings-animated-pages#pages').querySelector('div.iron-selected').querySelector('settings-toggle-button[label="Show home button"]').shadowRoot.querySelector('div#outerRow').querySelector('cr-toggle#control').shadowRoot.querySelector('span#knob')
""") // def được sử dụng để khai báo biến mà không cần chỉ định kiểu dữ liệu cụ thể.
((org.openqa.selenium.WebElement)element).click()