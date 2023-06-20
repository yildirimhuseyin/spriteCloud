Feature: Available Pets

  User Story: As a user, I should able to retrieve all pets which are available in the store.

  @api
  Scenario: Verify the availability status of all pets
    Given User retrieves the list of all pets in the store
    Then all pets in the response should have the status "available"