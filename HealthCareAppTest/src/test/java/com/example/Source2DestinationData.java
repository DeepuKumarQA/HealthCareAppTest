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

	public class Source2DestinationData {
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
	  public void testSource2DestinationData() throws Exception {
	    driver.get(baseUrl + "chrome://newtab/");
	    driver.get("https://www.cleartrip.com/flights/results?adults=1&childs=0&infants=0&class=Economy&depart_date=24/05/2023&from=BLR&to=BOM&intl=n&origin=BLR%20-%20Bangalore,%20IN&destination=BOM%20-%20Mumbai,%20IN&sft=&sd=1684924951002&rnd_one=O");
	    driver.findElement(By.xpath("//div[@id='root']/div/main/div/div/div/button")).click();
	    driver.get("https://www.cleartrip.com/");
	    driver.findElement(By.xpath("//input[@value='BLR - Bangalore, IN']")).click();
	    driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div[2]/div/div/div/div[3]/div[3]/div/div/div/div[2]/ul[3]/li/div/div[2]/p")).click();
	    driver.findElement(By.xpath("//input[@value='BOM - Mumbai, IN']")).click();
	    driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div[2]/div/div/div/div[3]/div[3]/div/div/div[3]/div[2]/ul[4]/li/div/div[2]/p")).click();
	    driver.findElement(By.xpath("//div[@id='root']/div/div/div/div/div[2]/div/div/div/div[3]/div[4]/div/div[2]/span")).click();
	    driver.findElement(By.xpath("//div[@id='root']/div/main/div/div/div[2]/div[2]/div[9]/div/div[2]/div/div/div[2]/div[4]/div[2]/button")).click();
	    //ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
	    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/main/div[2]/div/div/div[7]/div[2]")).click();
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

