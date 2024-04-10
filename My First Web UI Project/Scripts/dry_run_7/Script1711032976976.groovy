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
//Read Excel file
WebUI.openBrowser("https://investor.iconplc.com/financials-filings/annual-reports")
List<WebElement> listElements = WebUI.findWebElements(findTestObject("Object Repository/dry_run_7/elementsNeed"), 5)
List<String> listElement = new ArrayList<>()
for(WebElement webElement : listElements) {
	listElement.add(webElement.getText())
}

List<String> listExcel = new ArrayList<>()
String filePath = "D:\\lthai2\\katlon\\Practices_V2\\Mar17\\Test.xlsx";
String valueExcel;
FileInputStream excelFile = new FileInputStream(filePath);
XSSFWorkbook workbook = new XSSFWorkbook(excelFile); 
XSSFSheet sheet = workbook.getSheet("Sheet2");
for(Row row : sheet) {
	for(Cell cell : row) {
		String cellValue = cell.getStringCellValue()
		String[] listExcels = cellValue.split(", ")
		for(int i = 0; i < listExcels.length; i++) {
			listExcel.add(listExcels[i])
		}
	}
}
println(listElement)
println(listExcel)
//boolean check = listElement.containsAll(listExcel); 
//if(check) {
//	println(check)
//}
//else {
//	println(check)
//}
public static void verifyList(ArrayList<String> listExcel ,ArrayList<String> listElement) {
	int count = 0;
	for(int a = 0; a < listExcel.size(); a++) {
		for(int b = 0; b < listElement.size(); b++) {
			if(listExcel[a].equals(listElement[b])) {
				count++;
				break;
			}
		}
	}
	println(count)
	if(count == listExcel.size()) {
		println("mang elemet chua excel");
	}
	else {
		println("mang elemet ko chua excel");
	}
}
verifyList(listExcel, listElement)

	
