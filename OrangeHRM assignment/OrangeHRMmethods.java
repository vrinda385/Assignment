package assignmentLogin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHRMmethods {
		WebDriver drv ;
	String baseURL=("https://opensource-demo.orangehrmlive.com/");
	
	@BeforeTest
 public void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium2\\chromedriver_win32\\chromedriver.exe");
	    drv= new ChromeDriver();
		drv.get(baseURL);
		drv.manage().window().maximize();
		
	}
	@AfterTest
	 public void Shutdown() {
		 drv.close();
	 } 
	
	@Test
	//@Parameters(String n , String p)
		 	 public void accountStart() throws InterruptedException {
		
		        drv.findElement(By.id("txtUsername")).sendKeys("Admin");
		        drv.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		        drv.findElement(By.name("Submit")).click();
		   	    drv.findElement(By.partialLinkText("Admin")).click();
		   	    String x = drv.findElement(By.partialLinkText("Admin")).getAttribute("href");
		   		System.out.println("The Admin Link= " +x);
		   	    Thread.sleep(1000);
		   		drv.findElement(By.partialLinkText("Leave")).click();
		   	   String y = drv.findElement(By.partialLinkText("Leave")).getAttribute("href");
		   		
		   		System.out.println("LINK FOR Leave = "+y);
		   	    Thread.sleep(1000);

		   		drv.findElement(By.partialLinkText("Recruitment")).click();
		   	   String z = drv.findElement(By.partialLinkText("Recruitment")).getAttribute("href");
		   		
		   		//Thread.sleep(1000);

		   		System.out.println("LINK for Recruitement = "+z);
		   		
		   		List<WebElement> alltags = drv.findElements(By.tagName("a"));
		   		System.out.println("Total tags are :"+alltags.size());
		   		for(int i=0 ; i< alltags.size();i++) {
		   			System.out.println("Links on page are" +alltags.get(i).getAttribute("href"));
		   		}

		   		
		   		
		   		
	     		Thread.sleep(3000);
}}
