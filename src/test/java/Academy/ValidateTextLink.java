package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectRepositories.LandingPage;
import pageObjectRepositories.LoginPage;
import resources.Base;

public class ValidateTextLink extends Base
{	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initalize() throws IOException
	{
		driver = InitalizeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Chrome driver is up and running");
		driver.manage().window().maximize();	
	}
	
	@Test()
	public void ValidateTextLink() throws IOException, InterruptedException
	{
	
						//Page Object Repositories
		//Landing Page
		LandingPage lp = new LandingPage(driver);
		
		//Another Page-- Login Page
		Assert.assertEquals(lp.getLink().getText(), "FEATURED COURSES");
		log.debug("Actual Link matches the expected Link");
		
		
		
	}
	@AfterTest
	public void Close() throws InterruptedException

	{
		Thread.sleep(3000);
		driver.close();
	}
	

}
