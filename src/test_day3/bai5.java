package test_day3;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.ChromeDriver;

public class bai5 {
	WebDriver driver;
	WebDriver driverFirefox;
  @BeforeMethod
  public void beforeMethod() {
	  //khai bao duong dan test tren trinh duyet nao	  
	  System.setProperty("webdriver.chrome.driver","d:\\software\\chromedriver1.exe");
	  System.setProperty("webdriver.gecko.driver","d:\\software\\geckodriver-firefox.exe");
	  
	  //khai bao drive	  
	  driver = new ChromeDriver();
	  driverFirefox = new FirefoxDriver();
	  //run
	  driver.get("http://live.demoguru99.com/");
	  
	  driverFirefox.get("http://live.demoguru99.com/");
	  
	  //thoi gian o lai trang
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driverFirefox.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
  }
  
//  @Test
//  //test case tren chrome
//  public void test_day1() {
//	  System.out.println("Start test chrome");
//	  
//	  //tim den va click vao
//	  driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
//	  
//	  //dien thong tin
//	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
//	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123123");
//	  
//	  //tim va click login
//	  driver.findElement(By.xpath("//button[@id=\"send2\"]")).click();
//	  
//	  String errorMesagePass = driver.findElement(By.xpath("//div[@class='box-content']//p[contains(text(),'Automation Testing')]")).getText().trim();
//	  System.out.println("Error pass: " + errorMesagePass);
//	  
//	  //so sanh ket qua
//	  assertEquals("Automation Testing\n" + 
//	"automation@gmail.com\n" + 
//	"Change Password", errorMesagePass);
//	  
//  }
  
  @Test
  //test case tren firefox
  public void test_day1_firefox() {
	  System.out.println("start test tren firefox");
	  
	  //tim den va click vao My Account
	  driverFirefox.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	  
	  //dien thong tin
	  driverFirefox.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
	  driverFirefox.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123");
	    
	  //tim den va click button login
	  driverFirefox.findElement(By.xpath("//button[@id='send2']")).click();
	  
	  String errorMesagePassFire = driverFirefox.findElement(By.xpath("//div[@class='box-content']//p[contains(text(),'Automation Testing')]")).getText().trim();
	  System.out.print(errorMesagePassFire);
	  //so sanh ket qua
	  assertEquals("Automation Testing\n" + 
	  		"automation@gmail.com\n" + 
	  		"Change Password", errorMesagePassFire);
  }
  

  @AfterMethod
  public void afterMethod() {
	//done
	  driver.quit();
	  driverFirefox.quit();
  }

}
