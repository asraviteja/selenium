package com.makemytrip.tests;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {

	public WebDriver driver;

	/**
	 * TestNG: http://testng.org/doc/documentation-main.html#testng-xml
	 */

	@BeforeSuite(alwaysRun = true)
	public void setup() {

		System.out.println("Before Suite!!");
	}

	@Parameters({ "browser", "url" })
	@BeforeMethod(alwaysRun = true)
	public void inttialize(String browser, String url, Method method) {

		System.out.println("Starting Test Case:" + method.getName());

		DesiredCapabilities capabilities;

		if (browser.equalsIgnoreCase("FF")) {

			capabilities = DesiredCapabilities.firefox();
			System.setProperty("webdriver.gecko.driver",
					"src/test/resources/Drivers/geckodriver");

			driver = new FirefoxDriver(capabilities);

		} else if (browser.equalsIgnoreCase("Chrome")) {

			capabilities = DesiredCapabilities.chrome();
			System.setProperty("webdriver.gecko.driver",
					"/Users/itc/Desktop/Madhu/Softwares/chromedriver");

			driver = new ChromeDriver(capabilities);
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(Method method) {

		System.out.println("Ending Test Case:" + method.getName());
		driver.quit();

		System.out.println("After MEthod!!");
	}

	@AfterSuite(alwaysRun = true)
	public void exit() {

		System.out.println("After Suite!!");
	}

}
