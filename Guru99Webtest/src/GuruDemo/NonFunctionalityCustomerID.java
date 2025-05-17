package GuruDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NonFunctionalityCustomerID {

	  public static void main(String[] args) {
	        
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demo.guru99.com/telecom/index.html");
			driver.findElement(By.linkText("Add Tariff Plan to Customer")).click();
			driver.navigate().back();
			driver.navigate().forward();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			
	        try {
	            
	        	//Add Traffic plan to Invalid Customer ID
			
				WebElement costomerr = driver.findElement(By.id("customer_id"));
				costomerr.click();
				costomerr.sendKeys("45346");
				driver.findElement(By.xpath("//input[@class='fit']")).click();
				System.out.println("Please Provide the correct Customer ID");
				
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        try 
	        {
	        	
	        	//In Pay Billing Provide the invalid ID
	        	Thread.sleep(2000);
				driver.navigate().to("https://demo.guru99.com/telecom/index.html");
				
				driver.findElement(By.linkText("Pay Billing")).click();
				Thread.sleep(200);
				WebElement cdata = driver.findElement(By.xpath("//input[@name= 'customer_id']"));
				cdata.click();
				cdata.sendKeys("32453");
				driver.findElement(By.xpath("//input[@name= 'submit']")).click();
				System.out.println("Please Provide the correct Customer ID");
				driver.close();
	        }
	        catch(Exception m)
	        {
	        	System.out.println("Error   :" +m);
	        }
	  }
}