package test_day7;

import org.testng.annotations.Test;

import junit.framework.Assert;
import net.bytebuddy.asm.Advice.Argument;

import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.ChromeDriver;

public class bai4_5_6 {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  //khai bao duong dan test tren trinh duyet nao	  
	  System.setProperty("webdriver.chrome.driver","d:\\software\\chromedriver1.exe");
	  System.setProperty("webdriver.gecko.driver","d:\\software\\geckodriver-firefox.exe");
	  
	  //khai bao drive
	  driver = new FirefoxDriver();
	  //run
	  driver.get("https://automationfc.github.io/basic-form/index.html");
	  
  }
  
  @Test
  public void TC_04() throws InterruptedException {
	  System.out.println("Start test");
	  
	  //khai bao bien xpath
	  WebElement element = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
	  
	  //tim den va click vao
	  element.click();
	  
	  Alert alert = driver.switchTo().alert();
	  
	  Assert.assertEquals(alert.getText(), "I am a JS Alert");
	  
	  alert.accept();
	  
	  String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
	  Assert.assertEquals(result, "You clicked an alert successfully");
	  
	  Thread.sleep(3000);
  }
  
  @Test
  public void TC_05() throws InterruptedException {
	  System.out.println("Start test");
	  
	  //khai bao bien xpath
	  WebElement element = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
	  
	  //tim den va click vao
	  element.click();
	  
	  Alert alert = driver.switchTo().alert();
	  
	  Assert.assertEquals(alert.getText(), "I am a JS Confirm");
	  
	  alert.accept();
	  
	  String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
	  Assert.assertEquals(result, "You clicked: Ok");
	  
	  Thread.sleep(3000);
  }
  
  @Test
  public void TC_06() throws InterruptedException {
	  System.out.println("Start test");
	  
	  //khai bao bien xpath
	  WebElement element = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
	  
	  //tim den va click vao
	  element.click();
	  
	  Alert alert = driver.switchTo().alert();
	  
	  Assert.assertEquals(alert.getText(), "I am a JS prompt");
	  
	  //sendkey
	  
	  alert.sendKeys("khongminhhoang");
	  
	  alert.accept();
	  
	  String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
	  Assert.assertEquals(result, "You entered: khongminhhoang");
	  
	  Thread.sleep(3000);
  }
  
  @AfterMethod
  public void afterMethod() {
	//done
	  driver.quit();
  }

}
