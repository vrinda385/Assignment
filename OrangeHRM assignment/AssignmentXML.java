package assignmentLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AssignmentXML {
	WebDriver d;
	
	
@Test
@Parameters({"name","password"})
public void Start(String usrName , String PassWord) {
	 d=new ChromeDriver();
	 d.get("https://opensource-demo.orangehrmlive.com/");
	 WebElement username =d.findElement(By.id("txtUsername"));
	 username.sendKeys(usrName);
	 WebElement password = d.findElement(By.id("txtPassword"));
	 password.sendKeys(PassWord);
	 WebElement Login = d.findElement(By.name("Submit"));
	 Login.click();
	 
	 d.close();
	 
}
}
