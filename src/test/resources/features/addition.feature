Feature: Sign up
  In order to become a member I need to make an account and have to sign up

  @mytag
  Scenario Outline:
    Given on "https://login.mailchimp.com/signup/"
    And has username <"username">
    And has email <"email">
    And has password <"password">
    Then has submitted request
    And has <"result">

    Examples:
      | "test" | "username"        | "email"               | "password"   | "result"                                                                            |
      | "Tf1"  | "NormalUserName"  | "gibberish@email.com" | "Qwerty123!" | "Check your email"                                                                                 |
      | "Tf2"  | "LongUserName"    | "gibberish@email.com" | "Qwerty123!" | "Enter a value less than 100 characters long"                                       |
      | "Tf3"  | "NormalUserName1" | "                   " | "Qwerty123!" | "Please enter a value"                                                              |
      | "Tf4"  | "DoubleName"      | "gibberish@email.com" | "Qwerty123!" | "Another user with this username already exists. Maybe it's your evil twin. Spooky."|