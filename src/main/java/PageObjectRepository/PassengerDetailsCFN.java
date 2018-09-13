package PageObjectRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import CommonUtilities.Constants;

public class PassengerDetailsCFN {

	@FindBy(xpath="//form[@id='jpBook']/table/tbody/tr[3]/td/table/tbody[1]/tr/td[2][@id='jpBook:bkdPsgnDetail:0:j_idt326']")
	public WebElement NameVerify;
	
	@FindBy(xpath="//form[@id='jpBook']/table/tbody/tr[3]/td/table/tbody[1]/tr/td[3]")
	public WebElement Age;
	
	@FindBy(xpath="//form[@id='jpBook']/table/tbody/tr[3]/td/table/tbody[1]/tr/td[4]")
	public WebElement Gender;
	
	public void Passenger_Details_Checking()//Failing,Dont know why 
	{
		
		{
			System.out.println("Checkinh Name Validation");
			if(NameVerify.equals(Constants.Name))
			{
				System.out.println("syso");
			}
			else {
				System.out.println("Syso4444");
			}
		}
		/*else if (Age.equals(Constants.Age)) {
			System.out.println("Age is Correct");
		}
		else if (Gender.equals(Gender)) {
			System.out.println("Genter is correct");
			
		}
		else {
			System.out.println("Enter the details again !!");
		}*/
		
		/*System.out.println("You Can procees");
		Reporter.log("All passenger Details are Checked and Instructed accordingly !!");*/
		/*{
			System.out.println("Correct the name!!");
		}*/
		
	}
	
}
