Feature:As user I want to login under different roles

  @storemanager
  Scenario: Login as a store manager
    Given user is on the landing page
    Then user logs in as a store manager
    And user verifies that "Dashboard" page name is displayed
#    Then user quits

  @negative
  Scenario: Verify warning message for invalid credentials
    Given user is on the landing page
    Then user logs in with "wrong" username and "wrong" password
    And user verifies that "Invalid user name or password." warning message is displayed
#    Then user quits

  @driver
  Scenario: Login as a driver
    Given user is on the landing page
    Then  user logs in as a driver
    And user verifies that "Quick Launchpad" page name is displayed
