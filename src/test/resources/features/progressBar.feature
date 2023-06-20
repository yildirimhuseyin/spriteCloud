Feature: Progress bar functionality

  User Story: user should able to start and stop the progress when it is reached desired percentage

  Background: For the scenarios in the feature file, user is expected to be on progress bar page
    Given user on the progress bar page


 @ui
  Scenario: progress bar validation
    When user click on the start button
    Then user click on the stop button when percentage reached to "90%"
    And user sees progress bar stopped exactly where user wants








