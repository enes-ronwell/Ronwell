@HomePage
Feature: Home Page testleri

  @Login @Test1
  Scenario: Anasayfadan Login sayfasına gittiğinin kontrolü
    Given user is on the Home Page
    When user taps to Login Button on Home Page
    Then user should see the Login Page