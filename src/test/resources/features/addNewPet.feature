Feature: Add New Pet
  User story: User should able to add new pet to the store

  @api @wip
  Scenario: Add a new pet to the store
    Given the pet data to be added
    When user add a new pet is to the store
    Then the response should indicate a successful addition of the pet