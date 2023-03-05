Feature: command

  Scenario: Test login command
    Given An Admin
    Then The user enters wrong login data and cannot log in
    Given An Admin
    Then The admin enters the correct login data and can log in
    Given A Clerk
    Then The admin enters the correct login data and can log in
    Given A Clerk
    Then The user enters wrong login data and cannot log in
    Given A Viewer
    Then The user enters wrong login data and cannot log in
    Given A Viewer
    Then The admin enters the correct login data and can log in

  Scenario: Test create command
    Given An Admin logs in to proxy
    When Admin creates new account
    Then A new account has been created with the initial data given by the admin

    #wird schon in proxy getestet
  #Scenario: Test view command

  Scenario: Test book command
    Given Eight accounts
    When Clerk logs in and is doing four bookings
    Then The accounts have changed correctly
      #soll an haben

    #wird schon in memento getestet
  #Scenario: Test undo command

    #wird schon in proxy getestet
  #Scenario: Test view change-log command

