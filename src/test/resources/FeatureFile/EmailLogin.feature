Feature: To test Login with Email.

  Background: User login with the Email
    Given User on MMT website for email login
    When User clicks on Login with Email

  @PositiveEmail
  Scenario: User sucessfully login with the Email on MMT
    And User enters the Email ID
      | kowiwax791@95ta.com |
    And Email ID is correct
    And User enters the email password
      | Sk@270898 |
    And Email password is correct
    And User enters Otp
    And Otp is valid
    Then User is logged in via email
    But User should not see login button

  @NegativeEmail
  Scenario: User tries to login with invalid Email on MMT
    And User enters the Email ID
      | sak@1. |
    And Email ID is invalid
    Then Error message is displayed for Email

  @BlankEmail
  Scenario: User tries to login with Email left blank on MMT
    And User leaves the Email ID blank
    Then button is disabled

  @NegativeEmailPassword
  Scenario: User tries to login with invalid Email password on MMT
    And User enters the Email ID
      | biliga4687@1heizi.com |
    And Email ID is correct
    And User enters the email password
      | Sk@27098 |
    And mail password is invalid
    Then Error message is displayed for Email

  @BlankEmailPassword
  Scenario: User tries to login with Email password left blank on MMT
    And User enters the Email ID
      | biliga4687@1heizi.com |
    And Email ID is correct
    And User leaves the email password blank
    Then button is disabled

  @NegativeEmailOtp
  Scenario: User tries to login with the invalid Email Otp on MMT
    And User enters the Email ID
      | biliga4687@1heizi.com |
    And Email ID is correct
    And User enters the email password
      | Sk@270898 |
    And Email password is correct
    And User enters Invalid Email Otp
    	| 1234 |
    Then Error message is displayed for Email

  @BlankEmailOtp
  Scenario: User tries to login with invalid Otp left blank on MMT
    And User enters the Email ID
      | biliga4687@1heizi.com |
    And Email ID is correct
    And User enters the email password
      | Sk@270898 |
    And Email password is correct
    And User leaves the Otp blank
    Then button is disabled
#kowiwax791@95ta.com --- positive
