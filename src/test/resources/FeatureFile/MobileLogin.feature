Feature: To test Login with Phone Number.

  Background: User login with the Phone Number
    Given User on MMT website for Phone Number login
    When User clicks on Login with Phone Number

  @PositivePhone
  Scenario: User successfully login with the Phone number on MMT
    And User enters the phone number
      | 1 | United States | 2165846716 |
    And phone number is valid
    And User enters mobile Otp
    And Mobile Otp is valid
    Then User is logged in via Mobile
    But User should not see login button
  @NegativePhone
  Scenario: User tries to login with invalid phone on MMT
    And User enters the phone number
      | 1 | India | 11111 |
    And phone number is invalid
    Then Error message is displayed for phone

  #		Examples:
  #| EMAIL  |
  #| "sak@1." |
  @BlankPhone
  Scenario: User tries to login with phone no field left blank on MMT
    And User leaves the phone number blank
    Then button to continue with blank phone number is disabled

  @NegativePhoneOtp
  Scenario: User tries to login with invalid mobile otp on MMT
    And User enters the phone number
      | 1 | India | 9876567890 |
    And phone number is valid
    And User enters invalid mobile Otp
    	| 1234 |
    Then Error message is displayed for phone

  #		Examples:
  #| EMAIL  | PASSWORD |
  #| "test.mmt.test.test" | "Test@test" |
  @BlankPhoneOtp
  Scenario: User tries to login with mobile otp left blank on MMT
    And User enters the phone number
      | 1 | India | 9876567890 |
    And phone number is valid
    And User leaves mobile Otp blank
    Then button to continue with blank otp is disabled
