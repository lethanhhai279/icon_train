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
import org.apache.poi.ss.usermodel.*
import java.io.FileInputStream
import org.apache.pdfbox.pdmodel.PDDocument as PDDocument
import org.apache.pdfbox.text.PDFTextStripper as PDFTextStripper
import java.io.*
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

//String filePath = "C:\\Users\\letha\\Downloads\\abc_3.xlsx"
//File excelFile = new File(filePath)
//FileInputStream file = new FileInputStream(excelFile)
//XSSFWorkbook workbook = new XSSFWorkbook()
//XSSFSheet sheet = workbook.getSheet()
//for(XSSFSheet row : sheet) {
//	for(XSSFCell cell : row) {
//		println(cell.toString())
//	}
//}

List<String> itemExcel = new ArrayList<>();
List<String> itemDropdown = new ArrayList<>();
String filePath = "D:\\lthai2\\katlon\\Practices_V2\\Mar17\\Test.xlsx"
FileInputStream fis = new FileInputStream(filePath)
XSSFWorkbook workbook = new XSSFWorkbook(fis)
XSSFSheet sheet = workbook.getSheet("Sheet1")



// Iterate through rows and cells
for (Row row : sheet) {
	for (Cell cell : row) {
		// Access cell value
		String cellValue = cell.getStringCellValue()
		itemExcel.add(cellValue)
	}
}
println(itemExcel)
WebUI.openBrowser("https://www.globalsqa.com/demo-site/select-dropdown-menu/")

List<WebElement> dropdownOptions = WebUI.findWebElements(findTestObject("Object Repository/ExcelvsElement/itemDropdown"), 10)
println(dropdownOptions)
List<String> dropdownOptionsText = new ArrayList<>();
for(WebElement element : dropdownOptions) {
	dropdownOptionsText.add(element.getText())
}
print(itemExcel)
print(dropdownOptionsText)

if(dropdownOptionsText.containsAll(itemExcel)){
	print("Dropdown is contain data of Excel")
}