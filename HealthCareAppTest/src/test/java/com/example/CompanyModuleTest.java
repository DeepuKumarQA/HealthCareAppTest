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

public class CompanyModuleTest {
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
  public void testCompanyModule() throws Exception {
    driver.get("https://procurementpartners.com/suppliers/");
    driver.findElement(By.xpath("//ul[@id='primary-menu']/li[5]/a/span/span")).click();
    driver.get("https://procurementpartners.com/about/");
    driver.findElement(By.xpath("//ul[@id='primary-menu']/li[5]/a/span/span")).click();
    driver.findElement(By.linkText("Careers")).click();
    driver.get("https://recruiting.paylocity.com/recruiting/jobs/All/04e5d40e-458c-4c51-a887-c4a37095c3cd/Procurement-Partners-LLC");
    driver.findElement(By.xpath("//div[@id='onetrust-close-btn-container']/button")).click();
    driver.findElement(By.xpath("//div[@id='departmentsDropdownList']/span/span")).click();
    driver.findElement(By.id("departmentsDropdownList__listbox__option__1")).click();
    driver.findElement(By.xpath("//div[@id='locationsDropdownList']/div")).click();
    driver.findElement(By.id("locationsDropdownList__listbox__option__1")).click();
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
