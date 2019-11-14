package test_day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTest {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  //khai bao duong dan test tren trinh duyet nao	  
	  System.setProperty("webdriver.chrome.driver","d:\\software\\chromedriver1.exe");
	  
	  //khai bao drive	  
	  driver = new ChromeDriver();
	  
	  //run
	  driver.get("https://github.com/AnhTaQA");
  }
  
  @Test
  public void f() {
	  System.out.println("Start test");
  }

  @AfterMethod
  public void afterMethod() {
	//done
	  driver.quit();
  }

}
