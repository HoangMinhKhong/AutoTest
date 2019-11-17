package test_day4;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.ChromeDriver;

public class bai2 {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  //khai bao duong dan test tren trinh duyet nao	  
	  System.setProperty("webdriver.chrome.driver","d:\\software\\chromedriver1.exe");
	  
	  //khai bao drive	  
	  driver = new ChromeDriver();
	  
	  //run
	  driver.get("https://automationfc.github.io/basic-form/index.html");
  }
  
  @Test
  public void TC_01() {
	  //kiem tra enabled	  
	  Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Email:']")).isEnabled());
	  Assert.assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isEnabled());
	  Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Education:']")).isEnabled());
	  Assert.assertTrue(driver.findElement(By.xpath("//select[@id='job1']")).isEnabled());
	  Assert.assertTrue(driver.findElement(By.xpath("//input[@id='development']")).isEnabled());
	  Assert.assertTrue(driver.findElement(By.xpath("//input[@id='slider-1']")).isEnabled());
	  
	  //kiem tra disabled
	  Assert.assertTrue(driver.findElement(By.xpath("//input[@id='password']")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.xpath("//input[@id='radio-disabled']")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.xpath("//textarea[@id='bio']")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.xpath("//select[@id='job2']")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.xpath("//input[@id='check-disbaled']")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.xpath("//input[@id='slider-2']")).isDisplayed());
  }

  @AfterMethod
  public void afterMethod() {
	//done
	  driver.quit();
  }

}
