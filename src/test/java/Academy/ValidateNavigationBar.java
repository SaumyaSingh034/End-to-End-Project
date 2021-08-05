package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectRepositories.LandingPage;
import resources.Base;



public class ValidateNavigationBar extends Base
{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	
	@BeforeTest
	public void Initalize() throws IOException
	{
		driver = InitalizeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Chrome driver is up and running");
		driver.manage().window().maximize();
	}
	
	@Test()
	public void ValidateNavigationBar() throws IOException, InterruptedException
	{
	
						//Page Object Repositories
		//Landing Page
		//PropertyConfigurator.configure("log4j.properties.txt");
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		log.info("Navigation Bar is Displayed successfully");
		
		
		//Another Page-- Login Page
	
		
		
	}
	@AfterTest
	public void Close() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	
	

}
