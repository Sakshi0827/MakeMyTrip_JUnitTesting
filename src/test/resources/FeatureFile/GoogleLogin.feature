Feature: To test Login with Google.

  #Background: User on MMT website
  #	Given User has access to Browser
  #	When User enters Url of MMT
  #	Then User on MMT Home page
  #	Gmail account is registered on MMT.
  #@Positive
  #Scenario: User login with the Gmail account on MMT
  #Given User on MMT website
  #When User clicks on Login with Google
  #		And User enters the Gmail account ID
  #		And Gmail account ID is correct
  #		And User enters the password
  #		And Gmail password is correct
  #		Then User is logged in
  @PositiveGoogleID
  Scenario Outline: User login with the Gmail account on MMT
    Given User on MMT website
    When User clicks on Login with Google
    And User enters the Gmail account ID <EMAIL>
    And Gmail account ID is correct
    Then User is redirected to password page

    Examples: 
      | EMAIL                |
      | "test.mmt.test.test" |

  @PositiveGooglePass @ScenarioOutline
  Scenario Outline: User login with the Gmail account on MMT
    Given User on MMT website
    When User clicks on Login with Google
    And User enters the Gmail account ID <EMAIL>
    And Gmail account ID is correct
    And User enters the password <PASSWORD>
    And Gmail password is correct
    Then User is logged in
    But User should not see login button

    Examples: 
      | EMAIL                | PASSWORD         |
      | "test.mmt.test.test" | "Test@test.test" |

  @NegativeName
  Scenario: User tries to login with invalid Gmail ID on MMT
    Given User on MMT website
    When User clicks on Login with Google
    And User enters the Gmail account ID from POI
    And Gmail ID is invalid
    Then Error message is displayed

  @BlankName
  Scenario: User tries to login with Gmail ID left blank on MMT
    Given User on MMT website
    When User clicks on Login with Google
    And User leaves the Gmail account ID blank
    Then Error message is displayed

  @NegativePassword
  Scenario Outline: User tries to login with invalid gmail password on MMT
    Given User on MMT website
    When User clicks on Login with Google
    And User enters the Gmail account ID <EMAIL>
    And Gmail account ID is correct
    And User enters the password <PASSWORD>
    And password is invalid
    Then Error message is displayed

    Examples: 
      | EMAIL                | PASSWORD    |
      | "test.mmt.test.test" | "Test@test" |

  @BlankGmailPassword
  Scenario Outline: User tries to login with gmail password left blank on MMT
    Given User on MMT website
    When User clicks on Login with Google
    And User enters the Gmail account ID <EMAIL>
    And Gmail account ID is correct
    And User leaves the password blank
    Then Error message is displayed

    Examples: 
      | EMAIL                 |
      | "sapna2661@gmail.com" |
