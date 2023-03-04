Feature: command

  Scenario: Test login command
    Given A proxy and a user
    When The user is an Admin
    Then The user can create a new account
    When The user is either a Clerk or a Viewer
    Then The user cannot create a new account

  Scenario: Test create command
    Given A proxy and a user
    When The user is an Admin
    Then The user can create a new account
    When The user is either a Clerk or a Viewer
    Then The user cannot create a new account

  Scenario: Test view command
    Given A proxy, a user and an account
    When The user is an Admin
    Then The user cannot view the account
    When The user is either a Clerk or a Viewer
    Then The user can view the account

  Scenario: Test book command
    Given A proxy, a user and two accounts
    When The user is either an Admin or a Viewer
    Then The user cannot do a booking
    When The user is a Clerk
    Then The user can do a booking

  Scenario: Test undo command
    Given A proxy and a user
    When The user is either an Admin or a Viewer
    Then The user cannot undo the last action
    When The user is a Clerk
    Then The user can undo the last action

  Scenario: Test view change-log command
    Given A proxy and a user
    When The user is either a Clerk or a Viewer
    Then The user cannot view the change-log
    When The user is an Admin
    Then The user can view the change-log

