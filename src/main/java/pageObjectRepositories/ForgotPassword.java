package pageObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	public WebDriver driver;
	
	public void ForgotPassword(WebDriver driver)
	{
		this.driver =driver;
	}
	
	By Login = By.xpath("//a[@href=\"https://rahulshettyacademy.com/sign_in/\"]");
	By sendMeInstructions=By.cssSelector("[type='submit']");
	
	public WebElement getEmail()
	{
		return driver.findElement(Login);
	}
	public WebElement SendInstruction()
	{
		return driver.findElement(sendMeInstructions);
	}
	

}
