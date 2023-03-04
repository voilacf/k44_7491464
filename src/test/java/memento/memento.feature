Feature: memento

  Scenario: Test saving an account to memento
    Given An admin who has created two accounts
    When A clerk is doing a booking
    Then Before executing the booking, both accounts are being saved in a memento

  Scenario: Test restoring an account using memento
    Given Another booking
    When Clerk is using the undo command
    Then The booking is being canceled and the accounts are restored