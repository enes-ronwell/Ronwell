@LoginPage
Feature: Login Page testleri

  @YanlisMail
  Scenario Outline: Yanlış Email ile giriş yapma
    Given user is on the Login Page
    When user senkeys Email: "<mail>" on Login Page
    When user taps to Login Button on Login Page
    Then user should see Failed Mail Message: "Geçerli bir e-posta adresi girmelisiniz." on Login Page
    Examples:
      | mail        |
      | eneserdogan |

  @DogruMail
  Scenario Outline: Doğru Email ile giriş yapma
    Given user is on the Login Page
    When user senkeys Email: "<mail>" on Login Page
    When user taps to Login Button on Login Page
    Then user should see the Landing Page
    Examples:
      | mail        |
      | eneserdogan |
