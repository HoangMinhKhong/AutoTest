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

public class bai6 {
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
//	  System.out.println("Start test");
//	  
//	  //tim den va click vao
//	  driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
//	  
//	  //dien thong tin
//	  driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("hoangkm");
//    driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys("hoangkm");
//    driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("hoangkm");
//    driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("hoangkm"+randomNumber()+"@gmail.com");
//    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("hoangkm123");
//    driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("hoangkm123");
//	  
//	  //tim va click login
//	  driver.findElement(By.xpath("//button[@class='button']")).click();
//	  
//	  String errorMesagePass = driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText();
//	  System.out.println("Error pass: " + errorMesagePass);
//	  
//	  //so sanh ket qua
//	  assertEquals("Thank you for registering with Main Website Store.", errorMesagePass);
  
//    //logout
//    driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//a")).click();
//    driver.findElement(By.xpath("//button[@class='button']")).click();
//    driver.findElement(By.xpath("//div[@id='header-account']//a[text()='Log Out']")).click();
//	  
//  }
  
  @Test
  //test case tren firefox
  public void test_day1_firefox() {
	  System.out.println("start test tren firefox");
	  
	  //tim den va click vao My Account
	  driverFirefox.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	  
	  //tim va click vao create account
	  driverFirefox.findElement(By.xpath("//div[@class='buttons-set']/a")).click();
	  
	  //dien thong tin
	  driverFirefox.findElement(By.xpath("//input[@id='firstname']")).sendKeys("hoangkm");
	  driverFirefox.findElement(By.xpath("//input[@id='middlename']")).sendKeys("hoangkm");
	  driverFirefox.findElement(By.xpath("//input[@id='lastname']")).sendKeys("hoangkm");
	  driverFirefox.findElement(By.xpath("//input[@id='email_address']")).sendKeys("hoangkm"+randomNumber()+"@gmail.com");
	  driverFirefox.findElement(By.xpath("//input[@id='password']")).sendKeys("hoangkm123");
	  driverFirefox.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("hoangkm123");
	
	  
	  //tim den va click button login
	  driverFirefox.findElement(By.xpath("//button[@class='button']")).click();
	  
	  String errorMesagePassFire = driverFirefox.findElement(By.xpath("//li[@class='success-msg']//span")).getText();
	  System.out.println("Error pass: " + errorMesagePassFire);
	  
	  //so sanh ket qua
	  assertEquals("Thank you for registering with Main Website Store.", errorMesagePassFire);
	  
	  
	  //logout
	  driverFirefox.findElement(By.xpath("//div[@class='account-cart-wrapper']//a")).click();
	  driverFirefox.findElement(By.xpath("//button[@class='button']")).click();
	  driverFirefox.findElement(By.xpath("//div[@id='header-account']//a[text()='Log Out']")).click();
	  
	  //check redirect page home
	  String checkPageHome = driverFirefox.findElement(By.xpath("//div[@class='page-title']/h2[contains(text(),'This is demo site for')]")).getText().trim();
	  assertEquals("THIS IS DEMO SITE FOR", checkPageHome);
  }
  
  public static int randomNumber() {
	  Random random = new Random();
	  int randomNumber = random.nextInt(99999);
	  return randomNumber;
  }
  

  @AfterMethod
  public void afterMethod() {
	//done
	  driver.quit();
  }

}
