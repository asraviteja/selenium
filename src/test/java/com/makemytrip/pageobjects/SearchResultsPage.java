package com.makemytrip.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.utils.CommonUtil;

public class SearchResultsPage {

	/**
	 * 
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;

	@FindBy(className = "fli-list")
	List<WebElement> searchResultDetails;

	public SearchResultsPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}
	
	
	public int getSearchResults() {
		
		CommonUtil.waitInSeconds(10);
		
		for (WebElement element: searchResultDetails) {
			
			System.out.println("*****FLIGHTS INFO******\n");
			System.out.println(element.getText());
		}
		
		return searchResultDetails.size();
	}
}
