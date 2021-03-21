Feature: To test Login with FB.

  @PositiveFB @ScenarioOutline
  Scenario Outline: User successfully login with the Facebook account on MMT
    Given User on MMT website for FB Login
    When User clicks on Login with Facebook
    And User enters the FB ID <EMAIL> and FB password <PASSWORD>
    And Both are correct
    Then User is logged in via FB
    But User should not see login button
    Examples: 
      | EMAIL                          | PASSWORD    |
      | "test.mmt.test.test@gmail.com" | "Sk@270898" |

  @NegativeFBid
  Scenario Outline: User tries to login with invalid Facebook ID on MMT
    Given User on MMT website for FB Login
    When User clicks on Login with Facebook
    And User enters the FB ID <EMAIL> and FB password <PASSWORD>
    And FB Email ID is incorrect
    Then Error message is displayed for FB

    Examples: 
      | EMAIL          | PASSWORD    |
      | "test.mmt.tes" | "Sk@270898" |
      | "test.t.tes"   | "Sk@"       |

  @BlankFBid
  Scenario: User tries to login with Facebook ID left blank on MMT
    Given User on MMT website for FB Login
    When User clicks on Login with Facebook
    And User leaves the FB ID blank and enter FB password
    Then Error message is displayed for FB

  @NegativeFBPassword
  Scenario Outline: User tries to login with invalid FB password on MMT
    Given User on MMT website for FB Login
    When User clicks on Login with Facebook
    And User enters the FB ID <EMAIL> and FB password <PASSWORD>
    And FB password is incorrect
    Then Error message is displayed for FB

    Examples: 
      | EMAIL                          | PASSWORD   |
      | "test.mmt.test.test@gmail.com" | "Sk@27098" |

  @BlankFBPassword
  Scenario: User tries to login with FB password left blank on MMT
    Given User on MMT website for FB Login
    When User clicks on Login with Facebook
    And User enters the FB ID and FB password left blank
    Then Error message is displayed for FB
