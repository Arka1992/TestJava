package PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrainDetailsSubmission {

	@FindBy(id = "jpform:fromStation")
	public WebElement From_Station;

	@FindBy(id = "jpform:toStation")
	public WebElement ToStationFrame;

	@FindBy(xpath = "//tr[5]/td[2]/img[contains(@src,'resources/datepicker/calendarIcon.png')]")
	public WebElement Date;
	@FindBy(xpath = "//td[@data-year='2017' or @data-year='2018']/a[text()='14']")
	public WebElement SelectDate;

	@FindBy(xpath = "//a[@title='Next']")
	public WebElement CalenderNextDate;

	@FindBy(id = "jpform:jpsubmit")
	public WebElement Submit;

	@FindBy(linkText="Booked Ticket History")
	public WebElement BookedTicketHistory;
	
	@FindBy(xpath="//td[@id='txnHistory:bookedTicketHistoryDataTable:0:j_idt1326']/input[@name='select']")
	public WebElement CLickRadioButton;
	
	/*To verify that User can make reservation or Not*/
	@FindBy(xpath="//div[contains(text(),'Service Unavailable')]")
	public WebElement ServerCheck;
	
	@FindBy(xpath="//form[@id='avlAndFareForm']/div/following-sibling::div[1]/div/table[2]/tbody[1]/tr[3]/td[16]/a[text()='2S']")
	public WebElement IntercityTrain2S;
	
	@FindBy(xpath="//form[@id='avlAndFareForm']/div[2]/div/div[1]/div/div[1]/div[1]/following-sibling::div/table/tbody/tr[2]/td[2]/a[text()='Book Now']")
	public WebElement BookTicket;
	
	/*@FindBy(xpath="//form[@id='altavlfrm']/div/table[1]/tbody[1]/tr[1]/td[6]/table/tbody/tr[2]/td[1]/b/a[text()='Book Now']")
	public WebElement ClickonBookTicket;*/
	
	
}
