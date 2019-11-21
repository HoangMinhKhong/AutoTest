package test_day7;

import org.testng.annotations.Test;

import junit.framework.Assert;
import net.bytebuddy.asm.Advice.Argument;

import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.ChromeDriver;

public class bai3 {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  //khai bao duong dan test tren trinh duyet nao	  
	  System.setProperty("webdriver.chrome.driver","d:\\software\\chromedriver1.exe");
	  System.setProperty("webdriver.gecko.driver","d:\\software\\geckodriver-firefox.exe");
	  
	  //khai bao drive
	  driver = new FirefoxDriver();
	  //run
	  driver.get("https://demos.telerik.com/kendo-ui/styling/radios");
	  
  }
  
  @Test
  public void TC_01() throws InterruptedException {
	  System.out.println("Start test");
	  JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	  
	  //khai bao bien xpath
	  WebElement element = driver.findElement(By.xpath("//label[contains(text(),'147kW')]"));
	  
	  //tim den va click vao
	  if(element.isDisplayed() && !element.isSelected()) {
		  element.click();
	  } else if(!element.isDisplayed() && !element.isSelected()) {
		  jsExecutor.executeScript("arguments[0].click()", element);
	  }
	  
	  Thread.sleep(3000);
  }
  
  @AfterMethod
  public void afterMethod() {
	//done
	  driver.quit();
  }

}
