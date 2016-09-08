package projects.personal.aditya.ODStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Hello world!
 *
 */
public class ODStatus {
	
	private String urlToAccess;

	private WebDriver createDriver() {
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	private String getUrlToAccess()
	{
		return this.urlToAccess;
	}
	
	/*
	 * Including Protocol
	 */
	private void setUrlToAccess(String url)
	{
		this.urlToAccess = url;
	}
	
	private void getODStatus()
	{
		WebDriver driver =createDriver();
		driver.get(getUrlToAccess());
		try {
			setSomeTimeOut(20*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement applyStatusRadioBtn = driver.findElement(By.id("r1"));
		applyStatusRadioBtn.click();
		Select certificateTypeDropDown = new Select(driver.findElement(By.id("cert_type")));
		certificateTypeDropDown.selectByVisibleText("Daily_wise Original Degree");
		WebElement hallTicketNo = driver.findElement(By.id("htno_val"));
		hallTicketNo.sendKeys("10131A1228");
		try{
			setSomeTimeOut(20*1000);
		}catch(InterruptedException e)
		{}
		WebElement submitElement = driver.findElement(By.name("status_app"));
		submitElement.click();
		try{
			setSomeTimeOut(20*1000);
		}catch(InterruptedException e)
		{}
		WebElement statusElement = driver.findElement(By.tagName("h3"));
		System.out.println(statusElement.getText());
		if(driver!=null)
		{
			driver.quit();
		}

	}
	
	private void setSomeTimeOut(long timeToSleep) throws InterruptedException
	{
		Thread.sleep(timeToSleep);
	}

	public static void main(String[] args) {
		ODStatus od = new ODStatus();
		od.setUrlToAccess("http://jntukexams.net/status1");
		od.getODStatus();
	}
}
