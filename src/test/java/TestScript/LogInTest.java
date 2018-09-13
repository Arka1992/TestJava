package TestScript;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.Normalizer.Form;

import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument.Import;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import CommonUtilities.Browser;
import CommonUtilities.Constants;
import CommonUtilities.Extensions;
import PageObjectRepository.LonPaageValidation;
import PageObjectRepository.PassengerDetailsCFN;
import PageObjectRepository.ReservastioFrom;
import PageObjectRepository.TrainDetailsSubmission;

@Listeners(CommonUtilities.Listener.class)
public class LogInTest {
	@Test
	public void f() throws Exception {
		Browser b = new Browser();
		Extensions ext = new Extensions();
		b.getBrowser();
		b.PassURL();
		LonPaageValidation l = PageFactory.initElements(Browser.Driver, LonPaageValidation.class);
		System.out.println(Browser.Driver.getTitle());
		l.Pagevalidation("IRCTC Next Generation eTicketing System");
		l.LogInToApplication();
		if (Browser.Driver.getTitle().equalsIgnoreCase("IRCTC Next Generation eTicketing System")) {

			System.out.println("In Else If Block");
			ext.getAAlerttext();
			ext.AlertAccept();
		} else if (Browser.Driver.getTitle().equalsIgnoreCase("IRCTC Next Generation eTicketing System")) {
			System.out.println("In If Case");
			ext.pressEnterKey();
		} else
			System.out.println("In If and last block");
		System.out.println("In Else Case");

		// -------------------------------------Station Details and Submit
		// button-----------------------------------------------------
		TrainDetailsSubmission Search = PageFactory.initElements(Browser.Driver, TrainDetailsSubmission.class);
		ReservastioFrom RSV = PageFactory.initElements(Browser.Driver, ReservastioFrom.class);
		Search.From_Station.sendKeys(Constants.From_Station);
		ext.pressEnterKey();
		Search.ToStationFrame.sendKeys(Constants.To_Station);
		ext.pressEnterKey();

		while (true) {
			try {
				System.out.println("In try Block");
				Search.Date.click();
				Search.SelectDate.click();
				break;
			} catch (Exception e) {
				System.out.println("In Catch block");
				Search.CalenderNextDate.click();
				Thread.sleep(2000);
			}
		}
		Search.Submit.click();// To Click Submit button
		System.out.println("CHecking @@@@@@@@@@@@@@@");

		try {
			if (Search.ServerCheck.isDisplayed()) {

				System.out.println("In if Caluse of Reservaltion");
				System.out.println(Search.ServerCheck.isDisplayed());
				System.out.println("Cant  not Book Reservation ,Sorry For the Inconviniance,Please try after Sometime");
				ext.CloseBrowser();
			}

		} catch (Exception e) {
			System.out.println("In else Caluse of Reservaltion");
			Search.IntercityTrain2S.click();// Click SL (Sleeper)

			/* Search and Click on Submit button */
			System.out.println(Browser.Driver.getTitle());
			// TODO: handle exception
		}
		/*---------------------------------------------Book Ticket----------------------------------------------*/
		Thread.sleep(2000);
		Search.BookTicket.click();
		/*
		 * There may be chances of getting alert if giving Destination station as HWH
		 * ,so writing risk Statement which may come or may not in Try Block and
		 */
		try {
			ext.AlertAccept();
			System.out.println("Alert accepted");

		} catch (Exception e) {
			System.out.println("Alert Not Found");
			// ext.ImplicitWaitPageWait(20);// Try it using Explicit Wait
		}
		
		

		RSV.Enter_Details();
		Reporter.log("Passing the  name ");
		System.out.println("Is Opt Berth Selected = " + RSV.Opt_Berth.isSelected());
		String str = ext.GetFirstSelectedOption(RSV.Nationality).getText();// To print the selected Nationality
		Reporter.log("Nationality is = " + str);// Will print in Report

		/* Click on Check Box ,Mobile Number And Click on Next */

		RSV.CheckBoxAutoUpgrade();
		RSV.MobileNumberCheck();

		/* Passenger Details Check */
		PassengerDetailsCFN chk = new PassengerDetailsCFN();
		chk.Passenger_Details_Checking();// Dont know why Failing
	
	}
}
