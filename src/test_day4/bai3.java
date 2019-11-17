package test_day4;

import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonProperty.Access;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.ChromeDriver;

public class bai3 {
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
	  //click chon
	  driver.findElement(By.xpath("//input[@id='under_18']")).click();
	  driver.findElement(By.xpath("//input[@id='development']")).click();
	  
	  //kiem tra clicked
	  Assert.assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
	  Assert.assertTrue(driver.findElement(By.xpath("//input[@id='development']")).isSelected());
	  
	  //bo chon va kiem tra
	  driver.findElement(By.xpath("//input[@id='development']")).click();
	  Assert.assertFalse(driver.findElement(By.xpath("//input[@id='development']")).isSelected());
  }

  @AfterMethod
  public void afterMethod() {
	//done
	  driver.quit();
  }

}
