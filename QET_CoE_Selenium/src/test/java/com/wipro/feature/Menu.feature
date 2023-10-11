Feature: Validate Menu and Count links

  Scenario: Check Login with login credentials
    Given User is in the Home Page
    And Click on the login link
    When User enters the Email and Password
      | Email    |aghosh@gmail.com|
      | Password |abhi123    |

    And Click on the login button
    Then User should navigate to home page after login

  Scenario: Check Menu links are working successfully
    Given User is in home page after login
    And Click on each link one after other
    And Click on logout button
    Then User navigate to home page