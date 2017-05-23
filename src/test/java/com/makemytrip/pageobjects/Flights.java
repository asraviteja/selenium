package com.makemytrip.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.utils.CommonUtil;

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

	@FindBy(id = "searchBtn")
	WebElement searchBtn;
	
	
	public Flights(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Set user name in textbox

	public void selectFromLocation(String fromLocation) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(from));
		from.click();
		from.clear();
		from.sendKeys(fromLocation);

	}

	public void clicOneWay() {

		oneWay.click();

	}

	public void selctToLocation(String toLocation) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(to));
		
		CommonUtil.waitInSeconds(2);
		
		to.click();
		to.clear();
		to.sendKeys(toLocation);
	}

	public void selectDepart(String date, String month, String year) {

		depart.click();
		selectDate(date, month, year);

	}

	public void selctPassenegrs(String adults, String children, String infants) {

		pax.click();
		selectPax(adults, children, infants);
	}

	public void selecClassType(String type) {

		classType.click();
		selectClass(type);
	}
	
	
	public void selectDate(String date, String month, String year) {

		//driver.findElement(By.linkText("Prev")).click();

		List<WebElement> list = driver.findElements(By
				.xpath("//td[@data-month='" + month + "' and @data-year='"
						+ year + "']"));

		// For Each Loop in Java
		for (WebElement dateElement : list) {

			if (dateElement.getText().contains(date)) {

				dateElement.click();
				break;
			}

		}

	}

	public void selectPax(String adults, String children, String infants) {

		driver.findElement(By.id("js-adult_counter")).findElement(By.xpath("//li[contains(text(), '" + adults + "')]")).click();
		driver.findElement(By.xpath("//ul[@id='js-child_counter'] //li[contains(text(), '" + children + "')]")).click();
		driver.findElement(By.xpath("//ul[@id='js-infant_counter'] //li[contains(text(), '" + infants + "')]")).click();
		
		driver.findElement(By.xpath("//ul[@id='js-infant_counter']/following-sibling::span")).click();
		
		driver.findElement(By.linkText("Done")).click();
	}

	public void selectClass(String classType) {
		
		driver.findElement(By.xpath("//label[text()='" + classType + "']")).click();
		
		
		
	}
	
	public void clickSearchBtn() {
		
		searchBtn.click();
	}
	
}
