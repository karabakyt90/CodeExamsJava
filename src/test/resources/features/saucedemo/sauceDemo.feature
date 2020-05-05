@sauceDemo
Feature: SauceDemo UI automation
  Scenario:Purchasing items on saucedemo.com
    Given User is on SauceDemo home page
    When User logs in to the site
    And User sorts the items
    And User adds two or more items to the shopping cart
    Then User visits the shopping cart
    And User verifies items that were added to the cart
    When User removes an item and then continues shopping
    And User adds another item
    Then User visits the shopping cart
    And User verifies that he is purchasing the correct items
    And User clicks on checkout button and enters first "firstName", last "lastName" and postal code "postalCode"
    Then User verifies the total price and finishes the checkout



