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
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver


WebUI.openBrowser("https://automationfc.github.io/multiple-fields/", FailureHandling.STOP_ON_FAILURE)

//WebUI.scrollToElement(findTestObject("checkBox/ListCheckBoxJotForm"), 2, FailureHandling.STOP_ON_FAILURE)

//'Find danh sách các checkbox control''Find danh sách các checkbox control'

List<WebElement> lstElementCheckbox = WebUI.findWebElements(findTestObject('checkBox/autoListCheckBox'), 2, FailureHandling.STOP_ON_FAILURE)

//Check all box
//for (item in lstElementCheckbox) {
//	Boolean isCheck = item.isSelected()
//	
//	if (!isCheck) {
//		item.click()
//	}
//}

//'Get all label dựa vào danh sách trên'
List<String> listLabel = []
for(item in lstElementCheckbox) {
	String itemText = item.getAttribute("value")
	listLabel.add(itemText)
}



List<String> randomListLabel = getRandomListString(listLabel, 10)
println(randomListLabel)
for(item in lstElementCheckbox) {
	String itemText = item.getAttribute("value")
	Boolean isCheck = item.isSelected()
	if(randomListLabel.contains(itemText)) {
		item.click()
	}
}
public static getRandomListString(List<String> lstData, int numberOfItems) {
	Random rand = new Random()
	List<String> getListRandom = []
	List<String> lstTemp  = []
	lstTemp.addAll(lstData)
	(1..numberOfItems).each{
		int index = rand.nextInt(lstTemp.size())
		getListRandom.add(lstTemp[index])
		lstTemp.remove(lstTemp[index])
	}
	return getListRandom
}


//WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)