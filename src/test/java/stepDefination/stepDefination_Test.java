package stepDefination;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjectRepositories.LandingPage;
import pageObjectRepositories.LoginPage;
import resources.Base;

public class stepDefination_Test extends Base {

	@Given("^Initialize the browser with chrome$")

	public void initialize_the_browser_with_chrome() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver = InitalizeDriver();

	}

	@Given("^Navigate to the \"([^\"]*)\" link$")
	public void navigate_to_the_link(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
		//log.info("Chrome driver is up and running");
		driver.manage().window().maximize();
	}

	@Given("^Click on Login Link in the home page to land on Secure sign in Page$")
	public void click_on_Login_Link_in_the_home_page_to_land_on_Secure_sign_in_Page() throws Throwable {
	
		LandingPage lp = new LandingPage(driver);
		if(lp.getPopUpSize().size()>0)
		{
			lp.getPopUp().click();
		}
		lp.getLogin();

	}
	  @When("^User enters (.+) and (.+) and logs in$")
	    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		  LoginPage lop=new LoginPage(driver);
			lop.getEmailDetails().sendKeys(username);
			//log.info("User Name Send Successfully");
			lop.getPasswordDetails().sendKeys(password);
			//log.info("Password Send Successfully");
			//System.out.println(text);
			lop.getSubmit().click();
	    }



@Then("^Verify that user is successfully logged in$")
public void verify_that_user_is_successfully_logged_in() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
 
}  
@And("^Close the browser$")
public void close_the_browser() throws Throwable {
   driver.quit();
}
}
