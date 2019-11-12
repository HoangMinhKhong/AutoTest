package test_day1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class NewTest {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  //khai bao duong dan test tren trinh duyet nao	  
	  System.setProperty("webdriver.gecko.driver","d:\\software\\geckodriver-firefox.exe");
	  
	  //khai bao drive	  
	  driver = new FirefoxDriver();
	  
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
