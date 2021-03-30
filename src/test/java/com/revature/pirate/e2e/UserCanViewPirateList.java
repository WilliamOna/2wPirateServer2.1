package com.revature.pirate.e2e;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pirate.e2e.pages.HomePage;
import com.revature.pirate.e2e.pages.ViewPiratePage;

public class UserCanViewPirateList {

	private WebDriver driver;

	@Before
	public void setup() {
		// Tell java that you want to use the chrome driver for selenium
		System.setProperty("webdriver.chrome.driver", "/Users/WilliamOna/Downloads/chromedriver.exe");
		// Create new instance of ChromeDriver (note that your other options are:
		// geckodriver for Firefox, edgedriver for Edge, Safari)
		driver = new ChromeDriver();
		// use the driver to open some website
		driver.get("http://localhost:8080/PirateServer/");

	}

	@After
	public void teardown() {
		// close the browser
		driver.quit();
	}

	@Test
	public void should_be_able_to_navigate_to_the_view_pirates_page() {
		HomePage homePage = new HomePage(driver);
		homePage.clickOnPirateButton();
		
		ViewPiratePage viewPiratePage = new ViewPiratePage(driver);
		assertEquals("http://localhost:8080/PirateServer/pirate-list", viewPiratePage.getUrl());
	}

	@Test
	public void should_populate_pirate_list() {
		HomePage homePage = new HomePage(driver);
		homePage.clickOnPirateButton();
		
		ViewPiratePage viewPiratePage = new ViewPiratePage(driver);
		assertNotNull(viewPiratePage.getPirateTableBody());
	}

}
