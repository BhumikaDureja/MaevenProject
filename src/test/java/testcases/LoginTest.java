package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseClass{
	
	
	@Test
	public void LoginFailiureTest() throws InterruptedException {
		// starting adding values to test report
//		test = report.startTest("LoginFailiureTest");
		
		LoginPage login = new LoginPage();
		login.LoginFunction("xyz@abc.com","Abc@12345");
		
		WebElement ErrorMsg = driver.findElement(By.id("msg_box")); 
		
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActualMsg, ExpMsg);
		
//		report.endTest(test);
		// must end the report otherwise next test cannot be started
	}
	
	@Test
	public void LoginSuccessTest() throws InterruptedException {
	
	//	test = report.startTest("LoginSuccessTest");
		
		LoginPage login = new LoginPage();
		login.LoginFunction("xyz@abc.com","Abc@12345");
		
	//	report.endTest(test);
		// must end the report otherwise next test cannot be started
	}
	
// parameterized will not run with all other test so please comment it before running from LoginTest class. Always run Parameterized test  from Testng.xml
	@Test
	@Parameters({"Param1","Param2"})
	public void ParameterizedTest(String UserNameVal, String PasswordVal) throws InterruptedException {
//		test = report.startTest("ParameterizedTest");
		
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal,PasswordVal);		
		
//		report.endTest(test);
		// must end the report otherwise next test cannot be started
	} 


	@Test
	public void ExternalDataTest() throws InterruptedException {
//		test = report.startTest("ExternalDataTest");	
		
			String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
			String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
			
			LoginPage login = new LoginPage();
			login.LoginFunction(UserNameVal,PasswordVal);	
			
	//		report.endTest(test);
			// must end the report otherwise next test cannot be started
		}



}
