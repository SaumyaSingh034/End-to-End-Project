
package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectRepositories.ForgotPassword;
import pageObjectRepositories.LandingPage;
import pageObjectRepositories.LoginPage;
import resources.Base;

public class HomePage extends Base
{
	public WebDriver driver;
	 public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initalize() throws IOException
	{
		driver = InitalizeDriver();
	}
	
	@Test(dataProvider ="getData")
	public void HomePage(String Username, String Password) throws IOException, InterruptedException
	{
		
		driver.get(prop.getProperty("url"));
		log.info("Chrome driver is up and running");
		driver.manage().window().maximize();
						//Page Object Repositories
		//Landing Page
		LandingPage lp = new LandingPage(driver);
	
		LoginPage lop=lp.getLogin();
		//Another Page-- Login Page
		
		lop.getEmailDetails().sendKeys(Username);
		log.info("User Name Send Successfully");
		lop.getPasswordDetails().sendKeys(Password);
		log.info("Password Send Successfully");
		//System.out.println(text);
		lop.getSubmit().click();
		/*ForgotPassword fp = new ForgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.SendInstruction().click();
		*/
	
	}
	@AfterTest
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		data[0][0] = "saumyait034@gmail.com";
		data[0][1] = "12345678";
		//data[0][2] = "Saumya";
		data[1][0] = "saumyasinghps21@gmail.com";
		data[1][1] = "123456789";
		//data[1][2] = "Hi I am Harsha";
		return data;
	}
	

}
