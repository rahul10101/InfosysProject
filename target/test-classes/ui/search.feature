
Feature: Search Functionality 
  

  @ui
  Scenario: Validate Search Functionality
Given I have browser opened
When I Search "Infosys" and Validate Search Result and click on Infosys url
Then I move on next page and click on hamburger icon and select service link via mouse hover and click on Testing
