package TestScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtilities.Browser;
import PageObjectRepository.TrainDetailsSubmission;
@Listeners(CommonUtilities.Listener.class)
public class SearchDetails {
  @Test
  public void f() {
	  
	  TrainDetailsSubmission Search=PageFactory.initElements(Browser.Driver, TrainDetailsSubmission.class);
	  Search.From_Station.sendKeys("NHT");
	  
	  
  }
}
