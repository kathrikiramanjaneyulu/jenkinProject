Feature: Facebook Login Functionality

  Scenario Outline: Login with multiple user credentials
    Given I open Facebook login page
    When I enter username "<username>" and password "<password>"
    And I click on login button
    

    Examples:
      | username             | password   |
      | testuser1@gmail.com  | test1234   |
      | testuser2@gmail.com  | pass5678   |
      | testuser3@gmail.com  | wrong123   |
     # | testuser4@gmail.com  | 12345678   |
     # | invalid@mail.com     | invalidpw  |
     # | admin@test.com       | admin123   |
      #| demo@test.com        | demo123    |
      #| user@example.com     | welcome1   |
      #| john@gmail.com       | johnpass   |
      #| fakeuser@test.com    | 123fake    |
