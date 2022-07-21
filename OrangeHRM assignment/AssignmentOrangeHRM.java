package assignmentLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;

public class AssignmentOrangeHRM {
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
 
	@Test(dataProvider="DP")
	public void accountCreation(String usrName, String PassWord) throws InterruptedException {
		
			    WebElement Username = drv.findElement(By.id("txtUsername"));
				Username.sendKeys(usrName);
				WebElement Pd = drv.findElement(By.name("txtPassword"));
			    Pd.sendKeys(PassWord);
			    WebElement Login = drv.findElement(By.name("Submit"));
	            Login.click();
			    
       	         String actualurl=drv.getCurrentUrl();
		   		//System.out.println(actualurl);
		   		String expectedurl="https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials";
		   		if(actualurl.equalsIgnoreCase(expectedurl)) {
		   			  System.out.println("The login is Failed");
		   		}
		   		else {
		   			System.out.println("The Login is Successfull");
		   		}
		   		
		   		
		   		drv.findElement(By.partialLinkText("Welcome")).click();
		   		Thread.sleep(1000);
			    drv.findElement(By.linkText("Logout")).click();
			    Thread.sleep(1000);
	   		  

	}   		
	
	@DataProvider(name="DP")
	public Object[][] dataObject(){
		
		return new Object[][] {
			{"vanshika","341"},{"Vrinda","vrinda@1"},{"Admin","admin123"}
		};
	}	

}	


