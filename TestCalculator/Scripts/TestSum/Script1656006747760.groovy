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

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost:8080/CalculatorVersion2/')

WebUI.setText(findTestObject('Object Repository/Page_Calculator/input_First number_firstNumber'), '15')

firstNum = WebUI.getAttribute(findTestObject("Object Repository/Page_Calculator/input_First number_firstNumber"), "value") as double

WebUI.setText(findTestObject('Object Repository/Page_Calculator/input_Second number_secondNumber'), '15')

secondNum = WebUI.getAttribute(findTestObject("Object Repository/Page_Calculator/input_Second number_secondNumber"), "value")  as double

WebUI.click(findTestObject('Object Repository/Page_Calculator/btn_cong'))

actual = WebUI.getAttribute(findTestObject("Object Repository/Page_Calculator/input_Result_result"), "value")  as double

if(WebUI.verifyEqual(actual, firstNum + secondNum)) {
	println('success')
}

WebUI.delay(2)

WebUI.closeBrowser()

