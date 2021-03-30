package com.revature.pirate.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewPiratePage {
	private WebDriver driver;
	private String url;
	private By pirateTableBody = By.id("pirate-table-data");
	
	public ViewPiratePage(WebDriver driver) {
		this.driver = driver;
		url = driver.getCurrentUrl();
	}
	
	public String getUrl() {
		return url;
	}
	
	public WebElement getPirateTableBody() {
		return driver.findElement(pirateTableBody);
	}

}
