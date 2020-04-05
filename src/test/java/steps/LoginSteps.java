package steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {

	private WebDriver driver;

	@Given("I am at the login page")
	public void i_am_at_the_login_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Biswajit\\Documents\\lib\\drivers\\chromedriver.exe");	
		driver= new ChromeDriver();
		driver.get("https://parabank.parasoft.com");
		driver.manage().window().maximize();
	}

	@Given("I enter the username as {string}")
	public void i_enter_the_username_as(String uname) {
		driver.findElement(By.name("username")).sendKeys(uname);
	}

	@Given("I enter the password as {string}")
	public void i_enter_the_password_as(String pwd) {
		driver.findElement(By.name("password")).sendKeys(pwd);
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("I it opens my account page")
	public void i_it_opens_my_account_page() throws InterruptedException {
		String actText = driver.findElement(By.xpath("//h1[@class='title']")).getText();
		String expText="Accounts Overview";
		assertEquals(expText, actText);
		Thread.sleep(2000);
		driver.close();
	}

	@Then("It shows error on the page")
	public void it_shows_error_on_the_page() throws InterruptedException {
		String actText = driver.findElement(By.className("error")).getText();
		String expText="The username and password could not be verified.";
		assertEquals(expText, actText);
		Thread.sleep(2000);
		driver.close();
	}

}
