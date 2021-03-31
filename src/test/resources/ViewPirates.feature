Feature: List of Pirates can be viewed on View Pirates Page


  Scenario: Verify List of pirates is populated
  	Given Chrome is open at the homepage
  	When the View Pirates button is clicked on the nav bar
  	Then we have the appropriate url
  	And the body of the table is rendering
