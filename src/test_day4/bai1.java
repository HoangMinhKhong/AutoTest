package test_day4;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.ChromeDriver;

public class bai1 {
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
	  //kiem tra hien thi	  
	  Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Email:']")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Age:']")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Education:']")).isDisplayed());
	  
	  //nhap gia tri
	  driver.findElement(By.xpath("//input[@id='mail']")).sendKeys("hoangkm@vnpay.vn");
	  driver.findElement(By.xpath("//input[@id='mail']")).sendKeys("22");
	  driver.findElement(By.xpath("//input[@id='under_18']")).click();
  }

  @AfterMethod
  public void afterMethod() {
	//done
	  driver.quit();
  }

}
