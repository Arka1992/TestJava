package PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import CommonUtilities.Browser;
import CommonUtilities.Constants;
import CommonUtilities.ExcelLib;
import CommonUtilities.Extensions;

public class LonPaageValidation {
	@FindBy(xpath="//a[@id='loginText']")
	private WebElement Click_Login_Button;//To click Login Button
	@FindBy(id = "usernameId")
	private WebElement UserId;
	@FindBy(name = "j_password")
	private WebElement Password;
	@FindBy(id = "loginbutton")
	private WebElement LoginbButton;

	public void LogInToApplication() throws Exception {
		ExcelLib excel=new ExcelLib();
		//Extensions.MaximizeWindow();
		Thread.sleep(10000);
		Click_Login_Button.click();
		UserId.sendKeys(excel.getStringData(0, 1, 0));

		Password.sendKeys(excel.getStringData(0, 1, 1));
		Extensions.ThreadWait(20000);
		LoginbButton.click();
	}

	public boolean Pagevalidation(String Expected) {
		if (Browser.Driver.getTitle().equalsIgnoreCase(Expected)) {
			System.out.println("Correct  page");
			return true;
		} else {
			System.out.println("Wrong page");
			return false;
		}

	}

}
