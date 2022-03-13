package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class LoginPage {
	
	WebDriver driver = BaseClass.driver;
	
	//creating object of the ExtentTest class
	ExtentTest test = BaseClass.test;
	
//============================== Web Elements =============================	
	
	@FindBy(linkText = "Log in")
	WebElement LoginLink;
	
	
	@FindBy(name = "user_login")
	WebElement UserName;

	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(name = "btn_login")
	WebElement LoginBtn;
	
	@FindBy(className = "rememberMe")
	WebElement RememberMe;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	

	
//============================== Functions =============================	
	
	public void LoginFunction(String UserNameVal, String PasswordVal) throws InterruptedException {
		
		Thread.sleep(5000);
		LoginLink.click();
		test.log(LogStatus.PASS, "Click on Login Link", "Login link clicked successfully");
		
		UserName.sendKeys(UserNameVal);
		test.log(LogStatus.PASS, "Enter UserName", "Name entered successfully");
		
		Password.sendKeys(PasswordVal);
		test.log(LogStatus.PASS, "Enter Password", "Password entered successfully");
		
		RememberMe.click();
		test.log(LogStatus.PASS, "Click on Remember Me", "Rememeber Me clicked successfully");
		
		LoginBtn.click();
		test.log(LogStatus.PASS, "Click on Login Button", "Login Button clicked successfully");
	}
	
	
	public void UICheck() {
		
		Assert.assertTrue(UserName.isDisplayed());
	}
}
