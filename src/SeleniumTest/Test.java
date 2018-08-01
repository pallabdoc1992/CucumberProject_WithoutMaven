package SeleniumTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {

	public static void main(String[] args) {
		
		WebDriver driver;
		
		// Scenario 1
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\PallabDocuments16\\Workspace\\Selenium Jars\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("disable-infobars");
	        
		    driver= new ChromeDriver(options);
		    driver.manage().window().maximize();
		    
		    driver.get("https://www.phptravels.net/login");
		

		   driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[1]/input")).sendKeys("user@phptravels.com");
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   
		   driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[2]/input")).sendKeys("demouser");
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   
		   driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/button")).click();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		
		  driver.findElement(By.xpath("//*[@id=\"body-section\"]/div/div[1]/div/div[1]/h3")).isDisplayed();
		
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
		
		
		// Scenario 2
		
			driver.findElement(By.xpath("//*[@id=\"collapse\"]/ul[1]/li[2]/a")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			
			driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]")).click();
			driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys("kolkata");
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
		
			Robot robot;
			try {
				
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
			    robot.keyRelease(KeyEvent.VK_ENTER);
			    
			} catch (AWTException e) {
				
				e.printStackTrace();
			}
		    
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
					
			driver.findElement(By.xpath("//*[@id='dpd1']/div/input")).sendKeys("20/09/2018");
			List<WebElement> myElements = driver.findElements(By.xpath("//div[@class='datepicker-days']//td[@class='day  active']"));
			myElements.get(0).click();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
			
			driver.findElement(By.xpath("//*[@id='dpd2']/div/input")).clear();
			driver.findElement(By.xpath("//*[@id='dpd2']/div/input")).sendKeys("22/09/2018");
			List<WebElement> myElements1 = driver.findElements(By.xpath("//div[@class='datepicker-days']//td[@class='day  active']"));
			myElements1.get(1).click();
			
			driver.findElement(By.xpath("//*[@id='body-section']/div[2]/div/form/div[5]/button")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
			driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[5]/div[1]/div[3]/div/div/h2")).isDisplayed();
			
			// Scenario 3
			
				driver.findElement(By.xpath("//*[@id=\"collapse\"]/ul[1]/li[3]/a")).click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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
				
				driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[4]/div/div[3]/div[1]/div")).isDisplayed();
				
			
		

	}

}
