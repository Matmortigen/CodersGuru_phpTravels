Feature: registrationCodersGuru

  Scenario Outline: New user registration on CodersGuru
    Given Go to the CodersGuru home page
    And On the main page click the create account button
    When Complete all user registration fields <email> <first_name> <last_name> <password_1> <password_2> <town> <code_postal> <street> <number>
    And Clicking the register button
    Then We log out the newly registered user
    And We log in again to the newly created user confirming correct registration
    And Close the browser window

    Examples:
      | email | first_name | last_name | password_1 | password_2 | town | code_postal | street | number |
      | @wp.pl | Leszek | Kownacki | qwerty123456 | qwerty123456 | Warszawa | 01-123  | Wyspianska | 45 |