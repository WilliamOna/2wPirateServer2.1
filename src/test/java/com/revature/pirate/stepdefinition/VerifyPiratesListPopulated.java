package com.revature.pirate.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pirate.e2e.pages.HomePage;
import com.revature.pirate.e2e.pages.ViewPiratePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyPiratesListPopulated {
	
	private WebDriver driver;
	@Given("Chrome is open at the homepage")
	public void chrome_is_open_at_the_homepage() {
		System.setProperty("webdriver.chrome.driver", "/Users/WilliamOna/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/PirateServer/");
	}

	@When("the View Pirates button is clicked on the nav bar")
	public void the_view_pirates_button_is_clicked_on_the_nav_bar() {
		HomePage homePage = new HomePage(driver);
		homePage.clickOnPirateButton();
		
	}

	@Then("we have the appropriate url")
	public void we_have_the_appropriate_url() {
		ViewPiratePage viewPiratePage = new ViewPiratePage(driver);
		System.out.println(viewPiratePage.getUrl());
	}

	@Then("the body of the table is rendering")
	public void the_body_of_the_table_is_rendering() {
		ViewPiratePage viewPiratePage = new ViewPiratePage(driver);
		System.out.println(viewPiratePage.getPirateTableBody());
	}
}
