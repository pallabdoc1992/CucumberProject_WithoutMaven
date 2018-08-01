package StepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_1 {
	
	public static WebDriver driver;
	public static Robot robot;
	
	//------------------------------------------------------Scenario 1------------------------------------------------------
	
	@Given("^Open browser and start \"([^\"]*)\"$")
	public void Open_browser_and_start(String url) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PallabDocuments16\\Workspace\\Selenium Jars\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        
	    driver= new ChromeDriver(options);
	    driver.manage().window().maximize();
	    
	    driver.get(url);
		
	}

	@When("^I give valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void I_give_valid_and(String username, String password) 
	{
	   driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[1]/input")).sendKeys(username);
	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   
	   driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[2]/input")).sendKeys(password);
	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   
	   driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/button")).click();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
		
	}

	@Then("^User should be able to log in$")
	public void User_should_be_able_to_log_in()  
	{
	  driver.findElement(By.xpath("//*[@id=\"body-section\"]/div/div[1]/div/div[1]/h3")).isDisplayed();
	
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
		
	}
	
	
	//------------------------------------------------------Scenario 2------------------------------------------------------
	
	@Given("^User is on search hotels page$")
	public void User_is_on_search_hotels_page()
	{
		System.out.println("driver ="+driver); // to check if driver has been initialized since it was giving null pointer exception
		
		driver.findElement(By.xpath("//*[@id=\"collapse\"]/ul[1]/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("^I enter \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and hit on Search button$")
	public void I_enter_and_hit_on_Search_button(String city, String checkin, String checkout)
	{
		driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]")).click();
		driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys(city);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
	
		
		try {
			
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
	    
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
				
		driver.findElement(By.xpath("//*[@id='dpd1']/div/input")).sendKeys(checkin);
		List<WebElement> myElements = driver.findElements(By.xpath("//div[@class='datepicker-days']//td[@class='day  active']"));
		myElements.get(0).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id='dpd2']/div/input")).clear();
		driver.findElement(By.xpath("//*[@id='dpd2']/div/input")).sendKeys(checkout);
		List<WebElement> myElements1 = driver.findElements(By.xpath("//div[@class='datepicker-days']//td[@class='day  active']"));
		myElements1.get(1).click();
		
		driver.findElement(By.xpath("//*[@id='body-section']/div[2]/div/form/div[5]/button")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Then("^Hotel Search result should be displayed$")
	public void Hotel_Search_result_should_be_displayed()
	{
		driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[5]/div[1]/div[3]/div/div/h2")).isDisplayed();
		
	}
	
	
	//------------------------------------------------------Scenario 3------------------------------------------------------
	
	@Given("^User is on search flights page$")
	public void User_is_on_search_flights_page()
	{
		
		driver.findElement(By.xpath("//*[@id=\"collapse\"]/ul[1]/li[3]/a")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	}

	@When("^I enter \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and hit on Search button to search flights$")
	public void I_enter_and_hit_on_Search_button_to_search_flights(String arg1, String arg2, String arg3) 
	{
		//driver.findElement(By.xpath("//*[@id=\"oneway\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"s2id_location_from\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("New York");
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
	
		try {
			
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id=\"s2id_location_to\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("Sydney");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
	
		try {
			
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
	    
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
				
		driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[2]/div/form/div[3]/div/input")).sendKeys("2018-09-20");
		List<WebElement> myElements2 = driver.findElements(By.xpath("//div[@class='datepicker-days']//td[@class='day  active']"));
		myElements2.get(0).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[2]/div/form/div[6]/button")).click();

		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
	}

	@Then("^Flight Search result should be displayed$")
	public void Flight_Search_result_should_be_displayed()
	{
	    
		driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[4]/div/div[3]/div[1]/div")).isDisplayed();
		driver.close();
	}


}
