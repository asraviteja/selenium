package com.makemytrip;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flights {

	/** * All WebElements are identified by @FindBy annotation */

	WebDriver driver;

	@FindBy(id = "header_tab_flights")
	WebElement flights;

	@FindBy(id = "switch__input_1")
	WebElement oneway;

	@FindBy(id = "switch__input_2")
	WebElement roundtrip;

	@FindBy(id = "switch__input_3")
	WebElement multicity;

	@FindBy(id = "hp-widget__sfrom")
	WebElement From;

	@FindBy(id = "hp-widget__sTo")
	WebElement To;

	@FindBy(id = "hp-widget__depart")
	WebElement Depart;

	// @FindBy(xpath=".//*[@id='dp1494617837756']/div/div[1]/table/tbody/tr[2]/td[6]")
	// WebElement 13;

	@FindBy(id = "hp-widget__return")
	WebElement Return;

	@FindBy(id = "hp-widget__paxCounter")
	WebElement Passengers;

	@FindBy(id = "js-paxCounter__title_0")
	WebElement ADULTS;

	@FindBy(id = "js-paxCounter__title_1")
	WebElement CHILDREN;

	@FindBy(id = "js-paxCounter__title_2")
	WebElement INFANTS;

	// @FindBy(id="o-i-cross-dark removePaxCounter")
	// WebElement 13;

	@FindBy(xpath = "html/body/div[1]/div[2]/div[3]/div/div[9]/div/p/a")
	WebElement Done;

	@FindBy(id = "hp-widget__class")
	WebElement Class;

	@FindBy(id = "classBTN__input_1")
	WebElement Economy;

	@FindBy(id = "classBTN__input_2")
	WebElement PremiumEconomy;

	@FindBy(id = "classBTN__input_3")
	WebElement Business;

	@FindBy(id = "searchBtn")
	WebElement Advanced;

	public void flights(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements
		// there are four types of initelements which we have to choose and how
		// to know which one is correct
		PageFactory.initElements(driver, this);
	}

	// Set user name in textbox

	public void Source(String sourceName) {

		From.sendKeys("BLR");
	}
	// Set password in password textbox

	public void Destination(String destinationName) {

		To.sendKeys("SFO");

	}

	public void departDate(String departDate) {

		To.sendKeys("SFO");

	}

}
