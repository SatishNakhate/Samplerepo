package GuruDemo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NonFunctionalityCustomerdata {

	
		public static void main(String[] args) 
		{
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://demo.guru99.com/telecom/index.html");
			driver.findElement(By.partialLinkText("Add Customer")).click();
			driver.navigate().back();
			driver.navigate().forward();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
			Actions action = new Actions(driver);
			
			
			
			
			//Add Customer 
			try 
			{
				WebElement redio1 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/form/div/div[2]/label"));
				
				System.out.println("Selectecd Status : "+ redio1.isSelected() );
				redio1.click();
				System.out.println("Get Text  :  "  + redio1.getText());
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			try 
			{
				//Invalid Email Address
				driver.findElement(By.id("fname")).sendKeys("Satish");
				driver.findElement(By.id("lname")).sendKeys("Nakhate");
				//Wrong Email id
				driver.findElement(By.id("email")).sendKeys("satishNakhate");
				action.sendKeys(Keys.PAGE_DOWN).perform();
				driver.findElement(By.xpath("//*[@placeholder='Enter your address']")).sendKeys("Pune Maharastra");
				driver.findElement(By.id("telephoneno")).sendKeys("8329415298");
				driver.findElement(By.xpath("//input[@name= 'submit']")).click();
				driver.findElement(By.xpath("//input[@name= 'submit']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@type= 'reset']")).click();
				
				
				
				//Invalid Email Address
				Thread.sleep(1000);
				action.sendKeys(Keys.PAGE_UP).perform();
				driver.findElement(By.id("fname")).sendKeys("Satish");
				driver.findElement(By.id("lname")).sendKeys("Nakhate");
				
				driver.findElement(By.id("email")).sendKeys("sat@gmail.com");
				action.sendKeys(Keys.PAGE_DOWN).perform();
				driver.findElement(By.xpath("//*[@placeholder='Enter your address']")).sendKeys("Pune Maharastra");
				//Invalid Contact number
				driver.findElement(By.id("telephoneno")).sendKeys("satish");
				driver.findElement(By.xpath("//input[@name= 'submit']")).click();
				Alert all = driver.switchTo().alert();
				all.accept();
				System.out.println("User Will get the error message");
				
				
				//Two Digit Contact Number
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@type= 'reset']")).click();
				driver.findElement(By.id("fname")).sendKeys("Satish");
				driver.findElement(By.id("lname")).sendKeys("Nakhate");
				driver.findElement(By.id("email")).sendKeys("satishNakhate@gmail.com");
				action.sendKeys(Keys.PAGE_DOWN).perform();
				driver.findElement(By.xpath("//*[@placeholder='Enter your address']")).sendKeys("Pune Maharastra");
				driver.findElement(By.id("telephoneno")).sendKeys("83");
				driver.findElement(By.xpath("//input[@name= 'submit']")).click();
				Thread.sleep(2000);
				try 
				{
					WebElement cd = driver.findElement(By.xpath("//*[@id=\"header\"]/nav/a[2]"));
					String Ltext = cd.getText();
					System.out.println("Text   :"  + Ltext);
					if(Ltext.equalsIgnoreCase("Guru99 telecom"))
					{
						System.out.println("Test case has been fail");
					}
					else
					{
						System.out.println("Test case has been Pass ");
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}

				
				
				
				//Add New Traffic Plan
				Thread.sleep(2000);
				driver.navigate().to("https://demo.guru99.com/telecom/index.html");
				driver.manage().window().maximize();
				Thread.sleep(2000);
				driver.findElement(By.linkText("Add Tariff Plan")).click();
				driver.manage().window().maximize();
				driver.navigate().back();
				driver.navigate().forward();
				driver.findElement(By.id("rental1")).sendKeys("Satish");
				driver.findElement(By.id("local_minutes")).sendKeys("Satish");
				driver.findElement(By.id("inter_minutes")).sendKeys("Satish");
				driver.findElement(By.id("sms_pack")).sendKeys("Satish");
				driver.findElement(By.id("minutes_charges")).sendKeys("Satish");
				driver.findElement(By.id("inter_charges")).sendKeys("Satish");
				driver.findElement(By.id("sms_charges")).sendKeys("Satish");
				System.out.println("Data Has been Added");
				driver.findElement(By.xpath("//*[@type='submit']")).click();
				all.accept();
				Thread.sleep(15);
				System.out.println("User Unable to provide the Charcters");
			}
			catch(Exception e)
			{
				System.out.println("Error  :"  +e);
			}
			finally
			{
				
				driver.close();
			}

	}

}
