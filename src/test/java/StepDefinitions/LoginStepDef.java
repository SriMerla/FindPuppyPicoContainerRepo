package StepDefinitions;



import static org.junit.Assert.assertEquals;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;

import com.PuppyFind.Pages.HomePage;
import com.PuppyFind.Pages.LoginPage;

import base.TextContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import managers.PageObjectManager;
import managers.WebDriverManager;
import util.CONSTANTS;

public class LoginStepDef {
	//WebDriver driver;
	//PageObjectManager pageObjectManager;
	//WebDriverManager webDriverManager;
	
	TextContext testContext;
	LoginPage loginPage;
	HomePage homePage;
	 public LoginStepDef(TextContext context) {
	 testContext = context;
	 loginPage = testContext.getPageObjectManager().getLoginPage();
	// homePage = testContext.getPageObjectManager().getHomePage();
	 }
	@Given("^user is on web page$")
	public void user_is_on_web_page() {
		
		//webDriverManager = new WebDriverManager();
		//driver = webDriverManager.getDriver();
		
	}


	@When("^user enters valid credentials$")
	public void user_enters_valid_credentials() throws InterruptedException {
       // pageObjectManager = new PageObjectManager(driver);
		//loginPage = pageObjectManager.getLoginPage();
		loginPage.useronloginpage();
		loginPage.loginIntoPage();
		System.out.println(loginPage.checkvalue="CheckValue--1");
	    
	}

	@And("^user selects the action from drop down and submit$")
	public void user_selects_the_action_from_drop_down_and_submit() throws InterruptedException {
		loginPage.userAction();
		Thread.sleep(CONSTANTS.STEP_DELAY);
	   
	}


	@Then("^user is on find a puppy page$")
	public void user_is_on_find_a_puppy_page() throws InterruptedException{
		loginPage.confirmationMessage();
		testContext.webDriverManager.driver.navigate().back();
		System.out.println(loginPage.checkvalue="CheckValue--2");
		//Thread.sleep(2000);
		testContext.webDriverManager.closeDriver();
		
	   
	}

	@Given("^user is on login page$")
	public void user_is_on_login_page() {
		//webDriverManager = new WebDriverManager();
		//driver = webDriverManager.getDriver();
		//pageObjectManager = new PageObjectManager(driver);
		//loginPage = pageObjectManager.getLoginPage();
		loginPage.useronloginpage();
		
	}

	@When("^user verifies all the links are enable$")
	public void user_verifies_all_the_links_are_enable() throws InterruptedException{
		 boolean buyPuppy = loginPage.registertoBuyPuppy.isEnabled();
		 Asserts.check(buyPuppy, "Register Link to buy puppy is not enables");
		  		 
		 boolean sellPuppy = loginPage.registertoSellPuppy.isEnabled();
		 Asserts.check(sellPuppy, "Register link to sell puppy is not enable");
		 
		 boolean forgotPass = loginPage.ForgetPwd.isEnabled();
		 Asserts.check(forgotPass, "Forget Password link is not enable");
		
		
	
	   
	}

	@Then("^user clicks the links to verify the pages responding to the links$")
	public void user_clicks_the_links_to_verify_the_pages_responding_to_the_links() throws InterruptedException {
		loginPage.registertoBuyPuppy.click();
		 String registerUrl = testContext.webDriverManager.driver.getCurrentUrl();
		// Assert.assertEquals("https://www.puppyfind.com/register/?back=", registerUrl);
		Thread.sleep(CONSTANTS.STEP_DELAY);
		testContext.webDriverManager.driver.navigate().back();
		
		 loginPage.registertoSellPuppy.click();
		 Thread.sleep(CONSTANTS.STEP_DELAY);
		 String sellUrl =testContext.webDriverManager.driver.getCurrentUrl();
		// Assert.assertEquals("https://www.puppyfind.com/list/", sellUrl);
		 Thread.sleep(CONSTANTS.STEP_DELAY);
		 testContext.webDriverManager.driver.navigate().to("https://www.puppyfind.com/login/");
		 
		 loginPage.ForgetPwd.click();
		 String forgetPwd = testContext.webDriverManager.driver.getCurrentUrl();
		 Thread.sleep(CONSTANTS.STEP_DELAY);
		// Assert.assertEquals("https://www.puppyfind.com/login_help/?back=", forgetPwd);
		 Thread.sleep(CONSTANTS.STEP_DELAY);
		 testContext.webDriverManager.driver.navigate().back();
		 
		 System.out.println("Links are responding to their respective pages");
	    testContext.webDriverManager.closeDriver();
	}

}
