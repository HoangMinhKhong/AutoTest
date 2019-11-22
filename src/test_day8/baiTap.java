package test_day8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class baiTap {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  //khai bao duong dan test tren trinh duyet nao	  
	  System.setProperty("webdriver.chrome.driver","d:\\software\\chromedriver1.exe");
	  System.setProperty("webdriver.gecko.driver","d:\\software\\geckodriver-firefox.exe");
	  
	  //khai bao drive
	  driver = new FirefoxDriver();
  }
  
  @Test
  public void TC_01() throws InterruptedException {
	  System.out.println("Start test 1");
	  driver.get("https://www.myntra.com/");
	  WebElement hover = driver.findElement(By.xpath("//div[@class='desktop-userIconsContainer']"));
	  Actions action = new Actions(driver);
	  action.moveToElement(hover).perform();
	  
	  //check logout
	  Thread.sleep(3000);
	  String getUrl = driver.getCurrentUrl();
	  Assert.assertEquals(getUrl, "https://www.myntra.com/");
	  
  }
  
  @Test
  public void TC_02() {
	  System.out.println("Start test 2");
	  driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
	  
	  List<WebElement> element = driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee']"));
	  Actions move = new Actions(driver);
	  move.clickAndHold(element.get(0));
	  
  }
  
 @Test
  public void TC_03() {
	  System.out.println("Start test 3");
	  driver.get("https://automationfc.github.io/basic-form/index.html");
	  
	  WebElement click = driver.findElement(By.xpath("//button[@ondblclick='doubleClickMe()']"));
	  Actions actions = new Actions(driver);
	  actions.doubleClick(click).perform();
	  
	  String text = driver.findElement(By.xpath("//p[@id='demo']"));
	  Assert.assertEquals(text, "Hello Automation Guys!");
	  
  }
  
  @Test
  public void TC_04() {
	  System.out.println("Start test 4");
	  driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
	  
	  WebElement click = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
	  Actions actions = new Actions(driver);
	  actions.contextClick(click).perform();
	  
	  //hover
	  WebElement hover = driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-quit context-menu-visible']"));
	  Actions action = new Actions(driver);
	  action.moveToElement(hover).perform();
	  
	  
  }
  
  @Test
  public void TC_05() throws InterruptedException {
	  System.out.println("Start test 4");
	  driver.get("https://demos.telerik.com/kendo-ui/dragdrop/angular");
	  
	  WebElement drop = driver.findElement(By.xpath("//div[@id='droptarget']"));
	  WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
	  
	  Actions actions = new Actions(driver);
	  actions.dragAndDrop(drag, drop);
	  
	  //check mesage
	  Thread.sleep(5000);
	  String getText = driver.findElement(By.xpath("//div[@id='droptarget']")).getText();
	  System.out.print("123"+getText);
	  Assert.assertEquals(getText, "You did great!");
  }
  
  @AfterMethod
  public void afterMethod() {
	  //done
	  driver.quit();
  }

}
