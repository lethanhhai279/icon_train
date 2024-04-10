import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.nio.file.WatchService

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.ResponseObject
import internal.GlobalVariable
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

// Set up the API request
RequestObject request = new RequestObject()
request.setRestRequestMethod("GET")
request.setRestUrl("https://jsonplaceholder.typicode.com/users/1")
// Send the API request
ResponseObject response = WS.sendRequest(request)
// Verify the response status code
assert response.getStatusCode() == 200 : "Expected status code 200, but got ${response.getStatusCode()}. ${response.getResponseBodyContent()}"
// Parse the response content
def jsonResponse = new groovy.json.JsonSlurper().parseText(response.getResponseText())

// Define variables based on the JSON structure
def expectedId = 1
def expectedName = 'Leanne Graham'

// Verify the response content
assert jsonResponse.expectedId == 1 : "Expected user ID 1, but got ${jsonResponse.id}"
assert jsonResponse.expectedName == 'Leanne Graham' : "Expected user name 'Leanne Graham', but got ${jsonResponse.name}"
// Add more verification steps as needed

