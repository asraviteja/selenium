package com.makemytrip.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.makemytrip.pageobjects.Flights;
import com.makemytrip.pageobjects.MakeMyTripHeader;
import com.makemytrip.pageobjects.SearchResultsPage;

public class Test1 {

	@Test
	public void searchFlights() {

		System.setProperty("webdriver.gecko.driver",
				"/Users/itc/Desktop/Madhu/Softwares/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://makemytrip.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/**
		 * WAITS:
		 * 1) Iplicit WAit
		 * 2) Explicit Wait
		 * 		-WebDriver Wait
		 * 		-Fluent Wait
		 */
		
		MakeMyTripHeader header = new MakeMyTripHeader(driver);
		header.clickFlights();

		Flights flights = new Flights(driver);
		flights.clicOneWay();
		flights.selectFromLocation("BLR");
		flights.selctToLocation("SFO");
		flights.selectDepart("27", "4", "2017");
		flights.selctPassenegrs("2", "1", "1");
		flights.selecClassType("Business");
		flights.clickSearchBtn();

		SearchResultsPage searchPage = new SearchResultsPage(driver);
		int size = searchPage.getSearchResults();

		Assert.assertTrue((size != 0), "Search Results NOT found!!!");
		System.out.println("Search Reuslts retrieved successfully!! " + size);
	}

}
