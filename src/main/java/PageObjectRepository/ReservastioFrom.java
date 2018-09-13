package PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.thoughtworks.selenium.Wait;

import CommonUtilities.Browser;
import CommonUtilities.Constants;
import CommonUtilities.Extensions;

public class ReservastioFrom {

	@FindBy(xpath = "//table[@id='addPassengerForm:psdetail']/tbody[1]/tr[1]/td[2]/input")
	public WebElement Name;

	@FindBy(xpath = "//table[@id='addPassengerForm:psdetail']/tbody[1]/tr[1]/td[3]/input")
	public WebElement Age;

	@FindBy(xpath = "//table[@id='addPassengerForm:psdetail']/tbody[1]/tr[1]/td[4]/select")
	public WebElement Gender;

	@FindBy(xpath = "//table[@id='addPassengerForm:psdetail']/tbody[1]/tr[1]/td[5]/select")
	public WebElement Berth_Preference;

	@FindBy(xpath = "//table[@id='addPassengerForm:psdetail']/tbody[1]/tr[1]/td[6]/select")
	public WebElement Option_Senior_Citizen_Concession;

	@FindBy(xpath = "//table[@id='addPassengerForm:psdetail']/tbody[1]/tr[1]/td[7]/input")
	public WebElement Opt_Berth;

	@FindBy(xpath = "//table[@id='addPassengerForm:psdetail']/tbody[1]/tr[1]/td[8]/select")
	public WebElement Nationality;
	
	@FindBy(xpath="//div[@id='addPassengerForm:j_idt696_body']/table/tbody/tr/td/input[@id='addPassengerForm:autoUpgrade']")
	public WebElement  Consider_Auto_Upgradation;

	@FindBy(xpath="//div[@id=\"addPassengerForm:j_idt819_body\"]/input[@id='addPassengerForm:mobileNo']")
	public WebElement MobileNumber;
	
	@FindBy(xpath="//input[@id='validate']")
	public WebElement NextButton;

	Extensions extR = new Extensions();

	public void Enter_Details() {
		Name.sendKeys(Constants.Name);
		Age.sendKeys(Constants.Age);
		extR.SelectDropdownByIndex(Gender, 1);
		extR.SelectDropdownByIndex(Berth_Preference, 1);
		if (Option_Senior_Citizen_Concession.isEnabled()) {
			extR.SelectDropdownByIndex(Option_Senior_Citizen_Concession, 1);
		} else {
			System.out.println("No need of Selection SeniorCityzen");
		}

	}

	public void CheckBoxAutoUpgrade() {
		if (Name != null) {
			Consider_Auto_Upgradation.click();
			
		}
		else {
			System.out.println("Kindly,Enter the Name");}
	}
	public void MobileNumberCheck() throws Exception
	{
		extR.ThreadWait(20000);
		if(MobileNumber.isDisplayed())
		{
			
		NextButton.click();
		}
		else {
			System.out.println("Enter Mobile Number");
		}
				
	}
}
