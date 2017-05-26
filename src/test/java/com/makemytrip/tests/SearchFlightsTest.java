package com.makemytrip.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.makemytrip.pageobjects.Flights;
import com.makemytrip.pageobjects.MakeMyTripHeader;
import com.makemytrip.pageobjects.SearchResultsPage;

public class SearchFlightsTest extends BaseTest {

	@Parameters({"from", "to"})
	@Test
	public void searchFlights( String from, String to) {

		/**
		 * WAITS: 1) Iplicit WAit 2) Explicit Wait -WebDriver Wait -Fluent Wait
		 */

		MakeMyTripHeader header = new MakeMyTripHeader(driver);
		header.clickFlights();

		Flights flights = new Flights(driver);
		flights.clicOneWay();
		flights.selectFromLocation(from);
		flights.selctToLocation(to);
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
