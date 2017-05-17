package com.makemytrip.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MakeMyTripHeader {

	/**
	 * 
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;

	@FindBy(id = "header_tab_flights")
	WebElement flights;

	@FindBy(linkText = "hotels")
	WebElement hotels;

	@FindBy(css = "li#header_tab_homestay")
	WebElement homeStay;

	@FindBy(id = "header_tab_holidays")
	WebElement holidays;

	public MakeMyTripHeader(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Set user name in textbox

	public void clickFlights() {

		flights.click();

	}

	public void clickHotels() {

		hotels.click();

	}

	public void clickHomeStay() {

		homeStay.click();

	}

	public void clickHolidays() {

		holidays.click();

	}

}
