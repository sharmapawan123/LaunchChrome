package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class LaunchChrome {
	public WebDriver driver =null;
	@Test(priority =1)
	public void launchB() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//input[@id='onward_cal'])[1]")).click();		
		
		String year = "2023";
		String mon ="Nov";
		String day ="3";
		
		while(true)
		{
			String monthYear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			//System.out.print(monthYear);
			
			String array[]=monthYear.split(" ");
			String month = array[0];
			String yr = array[1];
			//System.out.print(month+"ooooooo"+yr);
			
			if(month.equalsIgnoreCase(mon) && yr.equals(year))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
			}
				
		}
		//select Date
		
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td"));
		
		for(WebElement ele:allDates)
		{
			
			String element = ele.getText();
			System.out.println("DAy is "+day);
			if(element.equals(day))
			{
				ele.click();
				break;
			}
			
		}
		
		
	}
	@Test(priority =2)
	public void quitB()
	{
		driver.quit();
	}

}
