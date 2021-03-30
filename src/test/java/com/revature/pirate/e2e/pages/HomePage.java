package com.revature.pirate.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;
	private By viewPiratesButton = By.xpath("//*[@id=\"showcase-content\"]/button/a");
	//we want to make the view pirates page a field of the class
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnPirateButton() {
		driver.findElement(viewPiratesButton).click();
	}
	
}
