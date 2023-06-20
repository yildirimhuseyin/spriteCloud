Feature: Mouse over functionality
  User Story: User should able to click on "click me" text, and see correct click number on the screen

  Background: For the scenarios in the feature file, user is expected to be on mouse over page
    Given user on the mouse over page

  @ui
  Scenario: click me text validations
    When user hover over on click me text
    Then user user click on the click me text
    And user see correct click count on the screen

