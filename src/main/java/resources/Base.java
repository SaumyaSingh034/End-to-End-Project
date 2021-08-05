package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;

public class Base {
	
	//data Driven - Global Environment Variable
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver InitalizeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Selenium\\Projects\\E2EProject\\src\\main\\java\\resources\\browser.properties");
		prop.load(fis);
		String broswerName = prop.getProperty("browser");
		if(broswerName.equals("chrome"))
		{
			//Chrome Driver Initalization
			
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chrome\\chromedriver.exe");
			 driver = new ChromeDriver();
			
		}
		else if(broswerName.equals("firefox"))
		{
			//Firefox Driver Initalization
		}
		
		else if(broswerName.equals("IE"))
		{
			//IE Driver Initalization
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
		
		
	}

	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		// TODO Auto-generated method stub
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		String destinationSource = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(Source, new File(destinationSource));
		return destinationSource;
		
	}
	
	
	
	

}
