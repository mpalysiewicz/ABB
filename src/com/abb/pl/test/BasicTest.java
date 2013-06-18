package com.abb.pl.test;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class BasicTest {
	WebDriver driver;
	
  @Test
  public void checkIfRedLogoIsDisplayed() {
	  driver.get("http://www.abb.com");
	  WebElement logo = driver.findElement(By.cssSelector("div#logo a"));
	  assertTrue(logo.isDisplayed());
	  
  }
  
  @Test
  public void checkIfHeaderIsCorrect() {
	  String searchedHeader = "Witamy w Centrum Informacji";
	  driver.get("http://www.abb.pl");
	  driver.findElement(By.partialLinkText("Centrum informacji")).click();
	  String headerText = driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div[2]/div/div/div[2]/div[2]/div/h1")).getText();
//	  assertTrue("Text does not match", headerText.equals(searchedHeader));
	  assertEquals(headerText, searchedHeader);
	  
  }
  
  @BeforeClass
  public void setUp() {
	  driver = new FirefoxDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
