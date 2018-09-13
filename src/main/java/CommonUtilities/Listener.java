package CommonUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	public void onFinish(ITestContext Result) {
		// TODO Auto-generated method stub
		// String File=Result.getMethod().getMethodName();

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		/*
		 * String File = arg0.getMethod().getMethodName(); EventFiringWebDriver efw =
		 * new EventFiringWebDriver(Browser.Driver); File SRC =
		 * efw.getScreenshotAs(OutputType.FILE); File DESC = new
		 * File("D:\\check\\IRctc\\PassedScreenshot" + File + ".jpg"); try {
		 * FileUtils.copyDirectory(SRC, DESC); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */ }

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String fileName = result.getMethod().getMethodName();
		EventFiringWebDriver efw = new EventFiringWebDriver(Browser.Driver);
		File SRC = efw.getScreenshotAs(OutputType.FILE);
		File DES = new File("D:\\check\\IRctc\\FailedScreenShot" + fileName + ".png");
		try {
			FileUtils.copyFile(SRC, DES);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}

	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		String File = arg0.getMethod().getMethodName();
		EventFiringWebDriver efw = new EventFiringWebDriver(Browser.Driver);
		File SRC = efw.getScreenshotAs(OutputType.FILE);
		File DES = new File("D:\\check\\IRctc\\PassedScreenshot" + File + ".jpg");

		try {
			FileUtils.copyFile(SRC, DES);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult Result1) {
		/*
		 * String File = Result1.getMethod().getMethodName(); EventFiringWebDriver efw =
		 * new EventFiringWebDriver(Browser.Driver); File SRC =
		 * efw.getScreenshotAs(OutputType.FILE); File DES = new
		 * File("D:\\check\\IRctc\\PassedScreenshot" + File + ".jpg");
		 * 
		 * try { FileUtils.copyFile(SRC, DES); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}
}
