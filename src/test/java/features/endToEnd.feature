@EndToEnd
Feature: End To End Test Cases

  @Sepet
  Scenario: Selenium Web Otomasyon
    Given User is on Home Page
    When User is type Sort in SearchBox on Home Page
    When User is clear in SearchBox on Home Page
    When User is type Shirt in SearchBox on Home Page
    When User is tap Search on Home Page
    When User is tap Random Product on Product List Page
    When User is add Information to txt file on Product Page
    When User is add to Basket on Product Page
    Then User is should see same Information on Product Page and on Basket Page
    When User is increase the quantity on Basket Page
    Then User is should see Product Quantity: "2" on Basket Page
    When User is delete Basket Product on Basket Page
    Then User is should see Empty Basket on Basket Page