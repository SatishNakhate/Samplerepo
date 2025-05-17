package GuruDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Functionalitycustomerdata {

	public static void main(String[] args) 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/telecom/index.html");
		
		try 
		{
			WebElement logo = driver.findElement(By.xpath("//*[@id=\"site-name\"]/a"));
			String Ltext = logo.getText();
			System.out.println("Text   :"  + Ltext);
			if(Ltext.equalsIgnoreCase("Demo Site"))
			{
				System.out.println("User on Correct page");
			}
			else
			{
				System.out.println("User not on Correct page");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		
		driver.findElement(By.partialLinkText("Add Customer")).click();
		driver.navigate().back();
		driver.navigate().forward();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		Actions action = new Actions(driver);
			
		
		//Add Customer 
		try 
		{
			WebElement redio = driver.findElement(By.xpath("//*[@id=\"main\"]/div/form/div/div[2]/label"));
			
			System.out.println("Selectecd Status : "+ redio.isSelected() );
			redio.click();
			System.out.println("Get Text  :  "  + redio.getText());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		try 
		{
			driver.findElement(By.id("fname")).sendKeys("Satish");
			driver.findElement(By.id("lname")).sendKeys("Nakhate");
			driver.findElement(By.id("email")).sendKeys("satishNakhate@gmail.com");
			action.sendKeys(Keys.PAGE_DOWN).perform();
			driver.findElement(By.xpath("//*[@placeholder='Enter your address']")).sendKeys("Pune Maharastra");
			driver.findElement(By.id("telephoneno")).sendKeys("8329415298");
			driver.findElement(By.xpath("//input[@name= 'submit']")).click();
			WebElement Cid= driver.findElement(By.xpath("//*[@align= 'center']/h3"));
			String atr= Cid.getText();
			System.out.println(atr);
			
			//Add Traffic plan
			Thread.sleep(2000);
			driver.navigate().to("https://demo.guru99.com/telecom/index.html");
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Add Tariff Plan")).click();
			driver.manage().window().maximize();
			driver.navigate().back();
			driver.navigate().forward();
			driver.findElement(By.id("rental1")).sendKeys("20000");
			driver.findElement(By.id("local_minutes")).sendKeys("10000");
			driver.findElement(By.id("inter_minutes")).sendKeys("20000");
			driver.findElement(By.id("sms_pack")).sendKeys("19999");
			driver.findElement(By.id("minutes_charges")).sendKeys("2000");
			driver.findElement(By.id("inter_charges")).sendKeys("1000");
			driver.findElement(By.id("sms_charges")).sendKeys("3000");
			System.out.println("Data Has been Added");
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			
			Thread.sleep(10);
			driver.findElement(By.className("button")).click();
			
			//Add Traffic plan to Customer
			driver.findElement(By.linkText("Add Tariff Plan to Customer")).click();
			WebElement costomerr = driver.findElement(By.id("customer_id"));
			costomerr.click();
			costomerr.sendKeys(atr);
			driver.findElement(By.xpath("//input[@class='fit']"));
			Thread.sleep(2000);
			driver.navigate().to("https://demo.guru99.com/telecom/index.html");
			
			//Pay Billing
			driver.findElement(By.linkText("Pay Billing")).click();
			Thread.sleep(200);
			WebElement cdata = driver.findElement(By.xpath("//input[@name= 'customer_id']"));
			cdata.click();
			cdata.sendKeys(atr);
			driver.findElement(By.xpath("//input[@name= 'submit']")).click();
			action.sendKeys(Keys.PAGE_DOWN).perform();
			Thread.sleep(2000);
			System.out.println("Billing Done.............");
			driver.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Error  :"  +e);
		}
		
		
			
		
	}

}
