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
import demoStore.Page_Action

// already exist: nhut123@gmail.com, nhut1234@gmail.com
//define Your Personal Details 
'Test data:'

TestData data = findTestData('Data Files/RegisDataForRegisSucAndAlrEma')

//String Gender = data.getValue("Gender", 1)
//
//String FirstName = data.getValue("FirstName", 1)
//
//String LastName = 'Nguyen'
//
//String DateOfBirthDay = '28'
//
//String DateOfBirthMonth = 'January'
//
//String DateOfBirthYear = '2000'
//
//String Email = 'nhut111111112345@gmail.com'
//
//String Password = 'Nhut123@'
//
WebUI.openBrowser('https://demo.nopcommerce.com/')
//
WebUI.maximizeWindow()
//
//WebUI.click(findTestObject('DemoStore/Register'))
//
//WebUI.click(findTestObject('DemoStore/Gender', [('Gender') : 'Male']))
//
//WebUI.setText(findTestObject('DemoStore/SetInformation', [('Info') : 'FirstName']), FirstName)
//
//WebUI.setText(findTestObject('DemoStore/SetInformation', [('Info') : 'LastName']), LastName)
//
//WebUI.selectOptionByValue(findTestObject('DemoStore/Date', [('Date') : 'DateOfBirthDay']), DateOfBirthDay, false)
//
//WebUI.selectOptionByLabel(findTestObject('DemoStore/Date', [('Date') : 'DateOfBirthMonth']), DateOfBirthMonth, false)
//
//WebUI.selectOptionByValue(findTestObject('DemoStore/Date', [('Date') : 'DateOfBirthYear']), DateOfBirthYear, false)
//
//WebUI.setText(findTestObject('DemoStore/SetInformation', [('Info') : 'Email']), Email)
//
//WebUI.setText(findTestObject('DemoStore/SetInformation', [('Info') : 'Password']), Password)
//
//WebUI.setText(findTestObject('DemoStore/SetInformation', [('Info') : 'ConfirmPassword']), Password)
//
//WebUI.click(findTestObject('DemoStore/SubmitRegister'))

CustomKeywords.'demoStore.Page_Action.Register_Action'(
	data.getValue("Gender", 1), 
	data.getValue("FirstName", 1),
	data.getValue("LastName", 1),
	data.getValue("DateOfBirthDay", 1),
	data.getValue("DateOfBirthMonth", 1),
	data.getValue("DateOfBirthYear", 1),
	data.getValue("Email", 1),
	data.getValue("Password", 1),
	data.getValue("ConfirmPassword", 1),
	)

CustomKeywords.'demoStore.Validation.ValidateRegisterSuccessfully'()

WebUI.closeBrowser()

