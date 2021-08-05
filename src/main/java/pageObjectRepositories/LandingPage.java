package pageObjectRepositories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public WebDriver driver;
	
	
	By Login = By.xpath("//a[@href=\"https://rahulshettyacademy.com/sign_in/\"]");
	@FindBy(css = ".text-center>h2")
	WebElement link;
	@FindBy(css=".navbar.navbar-default.navbar-static-top")
	WebElement navBar;
	By popUp = By.xpath("//button[text()='NO THANKS']");
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage getLogin()
	{
		 driver.findElement(Login).click();
		return new LoginPage(driver);
	}
	public WebElement getLink()
	{
		return link;
	}
	public List<WebElement> getPopUpSize()
	{
		return driver.findElements(popUp);
	}
	public WebElement getPopUp()
	{
		return driver.findElement(popUp);
	}
	public WebElement getNavBar()
	{
		return navBar;
	}

}
