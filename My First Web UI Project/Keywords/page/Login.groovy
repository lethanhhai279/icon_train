package page
import commonAction.ActionCommon
import object.LoginObject
import data.DataLoginPage
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.logging.KeywordLogger as Log
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
import internal.GlobalVariable
import com.kms.katalon.core.util.KeywordUtil as log
public class Login {

	public void login(String url, String username, String password) {
		WebUI.navigateToUrl(url)
		WebUI.maximizeWindow()
		WebUI.setText(LoginObject.USER_NAME, username)
		WebUI.setText(LoginObject.PASS_WORD, password)
		WebUI.click(LoginObject.LOGIN_BUTTON)
		WebUI.takeFullPageScreenshot()
	}
	public void loginOHRM(String url, String username, String password) {
		WebUI.navigateToUrl(url)
		WebUI.maximizeWindow()
		WebUI.setText(LoginObject.USER_NAME_OHRM, username)
		WebUI.setText(LoginObject.PASSWORD_OHRM, password)
		WebUI.click(LoginObject.LOGIN_BUTTON_OHRM)
		WebUI.takeFullPageScreenshot()
	}

	public boolean verifyLogin(String url) {
		boolean isLoggedIn = WebUI.verifyEqual(WebUI.getUrl(), url)
		return isLoggedIn
	}
	public boolean checkErrMess() {
		if(ActionCommon.verifyElementPresent(LoginObject.ERROR_MESSAGE)) {
			String messageErr = WebUI.getText(LoginObject.ERROR_MESSAGE)
			log.markFailed("$messageErr")
			return false
		}
		else {
			log.markPassed("Login successfully")
			return false
		}
	}
	public void loginAndVerify(String urlLogin, String username, String password, int maxAttempts, String urlLoginSuccess) {
		int attempt = 0
		boolean isLoggedIn = false
		while (attempt < maxAttempts && !isLoggedIn) {
			login(urlLogin, username, password)
			isLoggedIn = verifyLogin(urlLoginSuccess)

			if (!isLoggedIn) {
				log.markWarning("Cannot login. Try again ${attempt + 1} times")
				attempt++
			}
		}
		if (isLoggedIn) {
			log.markPassed("Log in successfully")
		} else {
			log.markFailed("Cannot login after $maxAttempts trials")
		}
	}
}
