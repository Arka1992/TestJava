package CommonUtilities;

import java.awt.RenderingHints.Key;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

public class Extensions {

	/* To perform Implicit Wait Operation */

	public static void ImplicitWaitPageWait(int Time) {
		Browser.Driver.manage().timeouts().implicitlyWait(Time, TimeUnit.SECONDS);
	}
	/**/
	/*
	 * public static void ExplicitWait(int Time) { WebDriverWait Explicit=new
	 * WebDriverWait(Browser.Driver,Time);
	 * Explicit.until(ExpectedConditions.presenceOfElementLocated()); }
	 */

	/* Thread Wait */
	public static void ThreadWait(int Time) throws InterruptedException {
		Thread.sleep(Time);
	}

	public static void FluentWait(WebElement wb) {

	}

	/* To Maximize window for Firefox*/
	public static void MaximizeWindow() {
		Browser.Driver.manage().window().maximize();
	}
	
	/* Mouse overing Operation */

	public static void mouseHover(WebElement wb) {
		Actions act = new Actions(Browser.Driver);
		act.moveToElement(wb);
	}

	/* Right Click Operation */
	public static void rightClick(WebElement wb) {
		Actions act = new Actions(Browser.Driver);
		act.contextClick(wb).sendKeys("T").perform();
	}
	/* To perform Enter Operation */

	public static void pressEnter(WebElement wb) {
		Actions act = new Actions(Browser.Driver);
		act.sendKeys(Keys.ENTER).perform();
		
	}

	/* To Perform Escape Operation */

	public static void pressESC(WebElement wb) {
		Actions act = new Actions(Browser.Driver);
		act.sendKeys(Keys.ESCAPE).perform();
	}

	/* To Perform keyboard Enter Operation */
	public static void pressEnterKey() {
		Actions act = new Actions(Browser.Driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/* To Select DropDown */

	public void SelectDropdownByIndex(WebElement wb, int index) {
		Select sel = new Select(wb);
		sel.selectByIndex(index);
	}

	public void SelectDropdownByValue(WebElement wb, String Value) {
		Select sel = new Select(wb);
		sel.selectByValue(Value);
	}

	public static void SelectIndexByWebElement(WebElement wb, String text) {
		Select sel = new Select(wb);
		sel.selectByVisibleText(text);
	}

	public static WebElement GetFirstSelectedOption(WebElement wb) {
		Select selOpt = new Select(wb);
		WebElement web = selOpt.getFirstSelectedOption();
		return web;
	}

	public static void getWindowHandel() {
		Set<String> set = Browser.Driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		String parent = itr.next();
		String chield = itr.next();
		WebDriver str = Browser.Driver.switchTo().window(parent);
		WebDriver str2 = Browser.Driver.switchTo().window(chield);
	}

	public static void FrameHandelingbyIndex(int index) {
		Browser.Driver.switchTo().frame(index);

	}

	public static void FrameHandelingbyName(String name) {
		Browser.Driver.switchTo().frame(name);
	}

	public static void FrameHandelingbyWebElement(WebElement wb) {
		Browser.Driver.switchTo().frame(wb);
	}

	/* To Handle Alert */

	public static void AlertAccept() {
		Alert alt = Browser.Driver.switchTo().alert();
		alt.accept();
	}

	public static void AlertDissmis() {
		Alert alt = Browser.Driver.switchTo().alert();
		alt.dismiss();
	}

	public static void getAAlerttext() {
		Alert alt = Browser.Driver.switchTo().alert();
		// String text =alt.getText();
		System.out.println("The Alert text is = " + alt.getText());
	}

	/* To Close Browse */
	public static void CloseBrowser() {
		Browser.Driver.quit();
	}

}
