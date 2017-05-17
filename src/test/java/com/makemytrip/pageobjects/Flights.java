package com.makemytrip.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flights {

	/**
	 * 
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;

	@FindBy(xpath = "//div[@class='switchBTN'] //label[contains(text(), 'one way')]")
	WebElement oneWay;

	@FindBy(id = "hp-widget__sfrom")
	WebElement from;

	// Bangalore, India

	@FindBy(id = "hp-widget__sTo")
	WebElement to;

	@FindBy(id = "hp-widget__depart")
	WebElement depart;

	@FindBy(id = "hp-widget__paxCounter")
	WebElement pax;

	@FindBy(id = "hp-widget__class")
	WebElement classType;

	public Flights(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Set user name in textbox

	public void selectFromLocation(String fromLocation) {

		from.click();
		from.clear();
		from.sendKeys(fromLocation);
	//	driver.findElements(By.xpath("//span[contains(.,'BLR')]")).get(0).click();
		
		

	}

	public void clicOneWay() {

		oneWay.click();

	}

	public void selctToLocation(String toLocation) {

		to.click();
		to.clear();
		to.sendKeys(toLocation);
	}

	public void selectDepart(String date) {

		depart.click();

	}

	public void selctPassenegrs(String passenger) {

		pax.click();

	}

	public void selecClassType(String type) {

		classType.click();

	}
}
