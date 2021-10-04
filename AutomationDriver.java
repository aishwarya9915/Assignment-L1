package Patil;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



		public class AutomationDriver {

			public static void main(String[] args) throws InterruptedException
			{
				System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
				WebDriver driver= new ChromeDriver();
				driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //hit the url
				driver.manage().window().maximize();
				AutomationDriver.exercise1(driver);
				AutomationDriver.exercise2(driver);
				AutomationDriver.exercise3(driver);
				AutomationDriver.exercise4(driver);
				AutomationDriver.exercise5(driver);
				AutomationDriver.exercise6(driver);
				AutomationDriver.exercise7(driver);
				AutomationDriver.exercise8(driver);
				AutomationDriver.exercise9(driver);
				
				
			}
			public static void exercise1(WebDriver driver) throws InterruptedException
			{
						driver.findElement(By.cssSelector("input[value='radio1']")).click(); 	// first radio button is clicked
				        System.out.println(driver.findElement(By.cssSelector("input[value='radio1']")).isSelected());
				        
				        Thread.sleep(2000);
				        driver.findElement(By.cssSelector("input[value='radio2']")).click(); //second radio button is clicked
				        System.out.println(driver.findElement(By.cssSelector("input[value='radio2']")).isSelected());
				        
				        Thread.sleep(2000);
				        driver.findElement(By.cssSelector("input[value='radio3']")).click(); //third radio button is clicked
				        System.out.println(driver.findElement(By.cssSelector("input[value='radio3']")).isSelected());
			}
		
			
		
		public static void exercise2(WebDriver driver) throws InterruptedException
		{
			driver.findElement(By.id("autocomplete")).sendKeys("United States");
			Thread.sleep(3000);
			List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));//css parent child realtionship it identify the all the options
		    
		      for(  WebElement option :options)//get me each option at a time //options means list of web options
		      {
		         if(option.getText().equalsIgnoreCase("United States Minor Outlying Islands"))//if its matches click the button
		         {
		        	 option.click();
		        	 break;
		         }
		      }
		}
		public static void exercise3(WebDriver driver) throws InterruptedException
		{
	        WebElement staticdropdown=driver.findElement(By.id("dropdown-class-example" ));// to address of the web element
			Select dropdown=new Select(staticdropdown);//object creation
			dropdown.selectByIndex(1); //for selecting index number 1
			System.out.println(dropdown.getFirstSelectedOption().getText());
			dropdown.selectByIndex(2);  //for selecting index number 2
			System.out.println(dropdown.getFirstSelectedOption().getText());
			dropdown.selectByIndex(3); //for selecting index number 3
			System.out.println(dropdown.getFirstSelectedOption().getText());

		}
		
		
		public static void exercise4(WebDriver driver) throws InterruptedException
		{
			driver.findElement(By.id("checkBoxOption1")).click();// to click the check box
			System.out.println(	driver.findElement(By.id("checkBoxOption1")).isSelected());//displays the  checkbox is checked
			driver.findElement(By.id("checkBoxOption1")).click();
			Thread.sleep(2000);
			System.out.println(	driver.findElement(By.id("checkBoxOption1")).isSelected());//displays the checkbox is unchecked
			
			Thread.sleep(2000);
			
			//second check box
			driver.findElement(By.id("checkBoxOption2")).click();//click the check box
			System.out.println(	driver.findElement(By.id("checkBoxOption2")).isSelected());//displays the  checkbox is checked
			driver.findElement(By.id("checkBoxOption2")).click();
			Thread.sleep(2000);
			System.out.println(	driver.findElement(By.id("checkBoxOption2")).isSelected());//displays the checkbox is unchecked

			
			Thread.sleep(2000);
			
			// third check box
			driver.findElement(By.id("checkBoxOption3")).click();//click the check box
			System.out.println(	driver.findElement(By.id("checkBoxOption3")).isSelected());//it display the  check box is checked
			driver.findElement(By.id("checkBoxOption3")).click();
			Thread.sleep(2000);
			System.out.println(	driver.findElement(By.id("checkBoxOption3")).isSelected());//it display the check box is unchecked
		}
		
		
		public static void exerciseFourPointOne(WebDriver driver) throws InterruptedException
		{
			List<WebElement>AllCheckboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
			int size=AllCheckboxes.size();
			System.out.println(size);
			int i;
			for( i=0;i<size;i++)
			{
				AllCheckboxes.get(i).click();
			    System.out.println(AllCheckboxes.get(i).isSelected());
			}
			
		}
		
		
		public static void exerciseFourPointTwo(WebDriver driver) throws InterruptedException
		{
		  Thread.sleep(2000);
		  List<WebElement>AllCheckboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
			int size=AllCheckboxes.size();
			System.out.println(size);
			int i;
			for( i=0;i<size;i++)
			{
				AllCheckboxes.get(i).click();
			    System.out.println(AllCheckboxes.get(i).isSelected());
			}
		}
		
		public static void exercise5(WebDriver driver) throws InterruptedException
		{
		   driver.findElement(By.id("openwindow")).click();//it is an child window form parent
		   Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId] it grab the id in the all window opened
           Iterator<String>it = windows.iterator();// access the ids
           String parentId = it.next();//to get the ids
           String childId = it.next();
           driver.switchTo().window(childId);//switch to child window
		   System.out.println(driver.getTitle());
		   driver.close(); //closes current browser
		   Thread.sleep(2000);
		   
			    driver.switchTo().window(parentId);//switch to child window
			    System.out.println(driver.getTitle());
		}
		
		public static void exercise6(WebDriver driver) throws InterruptedException
		{
			 driver.findElement(By.id("opentab")).click();//it is an child window form parent
			    Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId] it takes the ids in the all window opened
                Iterator<String>it = windows.iterator();// access the ids

			    String parentId = it.next();//to get the ids
                String childId = it.next();

			    driver.switchTo().window(childId);//switch to new 
			    System.out.println(driver.getTitle()); //validate if your page title is correct
			    Thread.sleep(2000);
			    driver.close();       //closes current browser
			    Thread.sleep(2000);
			    driver.switchTo().window(parentId);//switch to child window
			    System.out.println(driver.getTitle()); //validate if your page title is correct
		
		}
		public static void exercise7(WebDriver driver) throws InterruptedException
		{
			String text="Aishwarya Patil"; //shows the name with a pop up message
			driver.findElement(By.id("name")).sendKeys(text); //to get id by name
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("[id='alertbtn']")).click();
			System.out.println(driver.switchTo().alert().getText());
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			
		}
		public static void exercise8(WebDriver driver) throws InterruptedException
		{
			
			JavascriptExecutor js =(JavascriptExecutor)driver;//creating javascriptExecutor object to tell selenium to run java code
			js.executeScript("window.scrollBy(0,600)");//windows movement
			Thread.sleep(500);
			//Verify that  rows in the table 
			WebElement table=driver.findElement(By.id("product"));
			List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th"));
			System.out.println(secondrow.get(0).getText());
			System.out.println(secondrow.get(1).getText());
			System.out.println(secondrow.get(2).getText());
		}
		public static void exercise9(WebDriver driver) throws InterruptedException
		{
			 Thread.sleep(2000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
		    js.executeScript("window.scrollBy(0,500)");
		    Thread.sleep(3000);
			Actions a=new Actions(driver); // we have to create a class
			 Thread.sleep(3000);
			a.moveToElement(driver.findElement(By.xpath("//button[@id='mousehover']"))).click().build().perform(); //to get the link using xpath
			 Thread.sleep(3000);
			a.moveToElement(driver.findElement(By.tagName("a"))).click().build().perform();
			
	
			
			
		}
		
	}
		
		
		
		
		

	


