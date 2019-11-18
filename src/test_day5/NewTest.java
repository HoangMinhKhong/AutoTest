package test_day5;

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

public class NewTest {
	WebDriver driver;
	WebDriver driverFirefox;
	String user = "mngr233436";
	String pass = "gerYdaz";
	String userEmail = "hoangkm"+random()+"@gmail.com";
	
	By userId = By.xpath("//input[@name='uid']");
	By passId = By.xpath("//input[@name='password']");
	By buttonLogin = By.xpath("//input[@name='btnLogin']");
	
	String nameNew = "hoangkm"+random();
	By newName = By.xpath("//input[@name='name']");
	By address = By.xpath("//textarea");
	By city = By.xpath("//input[@name='city']");
	By state = By.xpath("//input[@name='state']");
	By pin = By.xpath("//input[@name='pinno']");
	By mobile = By.xpath("//input[@name='telephoneno']");
	By mail = By.xpath("//input[@name='emailid']");
	By passNew = By.xpath("//input[@name='password']");
	By submit = By.xpath("//input[@type='submit']");
	
	@BeforeMethod
  public void beforeMethod() {
	  //khai bao duong dan test tren trinh duyet nao
	  System.setProperty("webdriver.gecko.driver","d:\\software\\geckodriver-firefox.exe");
	  
	  //khai bao drive
	  driverFirefox = new FirefoxDriver();
	  //run
	  
	  driverFirefox.get("http://demo.guru99.com/v4/");
	  
	  //thoi gian o lai trang
	  driverFirefox.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driverFirefox.manage().window().maximize();
  }
  
  @Test
  public void TC_01() {
	  System.out.print("start test tren firefox");
	  
	//tim den va click vao
	  driverFirefox.findElement(userId).sendKeys(user);
	  driverFirefox.findElement(passId).sendKeys(pass);
	  
	//login	  
	  driverFirefox.findElement(buttonLogin).click();
	  
	//new customer
	  driverFirefox.findElement(By.xpath("//a[text()='New Customer']")).click();
	 
	//enter data
	  driverFirefox.findElement(newName).sendKeys(nameNew);
	  driverFirefox.findElement(address).sendKeys("22 lang ha");
	  driverFirefox.findElement(city).sendKeys("ha noi");
	  driverFirefox.findElement(state).sendKeys("dong da");
	  driverFirefox.findElement(pin).sendKeys("123");
	  driverFirefox.findElement(mobile).sendKeys("456");
	  driverFirefox.findElement(mail).sendKeys(userEmail);
	  driverFirefox.findElement(passNew).sendKeys("abc123");
	  
	//submit
	  driverFirefox.findElement(submit).click();
  }
  
  @Test
  public void TC_02() {
	  System.out.print("start test tren firefox");
	  
	//tim den va click vao
	  driverFirefox.findElement(userId).sendKeys(user);
	  driverFirefox.findElement(passId).sendKeys(pass);
	  
	//login	  
	  driverFirefox.findElement(buttonLogin).click();
	  
	//new customer
	  driverFirefox.findElement(By.xpath("//a[text()='Edit Customer']")).click();
	  driverFirefox.findElement(By.xpath("//input[@name='cusid']")).sendKeys();
	  driverFirefox.findElement(submit).click();
	 
	//enter data
	  driverFirefox.findElement(newName).sendKeys(nameNew);
	  driverFirefox.findElement(address).sendKeys("22 lang ha");
	  driverFirefox.findElement(city).sendKeys("ha noi");
	  driverFirefox.findElement(state).sendKeys("dong da");
	  driverFirefox.findElement(pin).sendKeys("123");
	  driverFirefox.findElement(mobile).sendKeys("456");
	  driverFirefox.findElement(mail).sendKeys(userEmail);
	  driverFirefox.findElement(passNew).sendKeys("abc123");
	  
	//submit
	  driverFirefox.findElement(submit).click();
  }
  
  @AfterMethod
  public void afterMethod() {
	//done
	  driverFirefox.quit();
  }

  private int random() {
	  Random random = new Random();
	  int randomNumber = random.nextInt(9999);
	  return randomNumber;
  }
}
