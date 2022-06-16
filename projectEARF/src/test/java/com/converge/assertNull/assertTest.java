package com.converge.assertNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.python.antlr.PythonParser.try_stmt_return;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.TessAPI;




public class assertTest {
	
	
	WebDriver driver;
	static final String HOST_URL = "http//localhost:4444/wd/hub";
	  
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\p.alakeem.abdulla\\Desktop\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	System.out.println("Open Chrome Browser");
	//driver.get("http://localhost:8080/"); // EARF project
	driver.get("https://mail.google.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	Thread.sleep(3000);
	}

	@Test
	public void assertNull() throws InterruptedException {
		
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Thread.sleep(1000);
	js.executeScript("window.scrollTo(0, 2800)");
	Thread.sleep(1000);
	driver.findElement(By.id("addTools")).click(); //Add Tools+
	driver.findElement(By.id("toolsInputElement")).sendKeys("1");
	String actualdataString = driver.findElement(By.id("toolsInputElement")).getAttribute("value");
	Thread.sleep(1000);
	AssertJUnit.assertEquals(actualdataString, "1");
	Thread.sleep(1000);
	System.out.println("verify null");
		
	}
	
	@Test
	public void assertColor() throws InterruptedException {
		
	Thread.sleep(1000);
	String colorString = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[3]")).getCssValue("color");
	String hexcolor = Color.fromString(colorString).asHex();
	System.out.println(hexcolor);
	AssertJUnit.assertEquals(hexcolor, "#ffffff");
	
	
		
	}
	
	@Test
	public void assertTextStyle() {
	
	
	try {
		String text = driver.findElement(By.id("identifiernext")).getText(); //ID = "identifierNext"
		AssertJUnit.assertEquals(text, "susunod"); //Expected = "Susunod"

		System.out.println(text);

		System.out.println("Test Passed");
	
	} catch (AssertionError e) {   // If this error occurs on the console
		System.out.println("Test Failed");  //this code will execute | extent report  = test.fail("Assertion expected = false")
		
	} catch (NoSuchElementException e) {    // If this error occurs on the console
		System.out.println("No Element Found"); // extent report  = test.fail("Element not found")
	
	} catch (Exception e) {   // If this error occurs on the console
		System.out.println("Something's Wrong"); // extent report  = test.fail("Unknown Error")
	}
	
	System.out.println("ace");
	}
	
	
	
	
	@AfterMethod
	public void teardown() {
		System.out.println("Close Browser");
	driver.close();
	}
}
