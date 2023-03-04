Feature: proxy

  Scenario: Test create command permission
    Given A proxy
    When An Admin logs in
    Then The user can create a new account
    When A Clerk logs in
    Then The user cannot create a new account
    When A Viewer logs in
    Then The user cannot create a new account

  Scenario: Test view command permission
    Given A proxy and an account
    When An Admin logs in
    Then The user cannot view the account
    When A Clerk logs in
    Then The user can view the account
    When A Viewer logs in
    Then The user can view the account

  Scenario: Test book command permission
    Given A proxy, a user and two accounts
    When An Admin logs in
    Then The user cannot do a booking
    When A Viewer logs in
    Then The user cannot do a booking
    When A Clerk logs in
    Then The user can do a booking

  Scenario: Test undo command permission
    Given A booking
    When An Admin logs in
    Then The user cannot undo the last action
    When A Viewer logs in
    Then The user cannot undo the last action
    When A Clerk logs in
    Then The user can undo the last action

  Scenario: Test view change-log command permission
    Given A booking
    When A Clerk logs in
    Then The user cannot view the change-log
    When A Viewer logs in
    Then The user cannot view the change-log
    When An Admin logs in
    Then The user can view the change-log

