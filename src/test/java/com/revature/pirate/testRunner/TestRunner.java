package com.revature.pirate.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = "src/test/resources/ViewPirates.feature",
			glue="com.revature.pirate.stepdefinition"
		)
public class TestRunner {

}
