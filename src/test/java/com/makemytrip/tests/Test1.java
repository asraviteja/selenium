package com.makemytrip.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.makemytrip.pageobjects.Flights;
import com.makemytrip.pageobjects.MakeMyTripHeader;

public class Test1 {

	@Test
	public void searchFlights() {

		System.setProperty("webdriver.gecko.driver",
				"/Users/itc/Desktop/Madhu/Softwares/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://makemytrip.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		MakeMyTripHeader header = new MakeMyTripHeader(driver);
		header.clickFlights();

		Flights flights = new Flights(driver);
		flights.clicOneWay();
		flights.selectFromLocation("BLR");
		flights.selctToLocation("SFO");
		flights.selectDepart("27", "4", "2017");
		flights.selctPassenegrs("");
		flights.selecClassType("");

	}

}
