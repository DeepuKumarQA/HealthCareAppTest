package com.example;
	import java.util.regex.Pattern;
	import java.util.concurrent.TimeUnit;
	import org.testng.annotations.*;
	import static org.testng.Assert.*;
	import org.openqa.selenium.*;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import java.io.File;
	import org.apache.commons.io.FileUtils;

	public class ResourceModuleTest {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private JavascriptExecutor js;

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    System.setProperty("webdriver.chrome.driver", "");
	    driver = new ChromeDriver();
	    baseUrl = "https://www.google.com/";
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    js = (JavascriptExecutor) driver;
	  }

	  @Test
	  public void testResourceModule() throws Exception {
	    driver.get(baseUrl + "chrome://newtab/");
	    driver.get("https://procurementpartners.com/");
	    driver.findElement(By.linkText("Resources")).click();
	    driver.findElement(By.xpath("//ul[@id='primary-menu']/li[4]/ul/li[2]/a/span/span")).click();
	    driver.findElement(By.xpath("//ul[@id='primary-menu']/li[4]/a/span/span")).click();
	    driver.findElement(By.xpath("//ul[@id='primary-menu']/li[4]/ul/li[4]/a/span/span")).click();
	  }

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}

}
