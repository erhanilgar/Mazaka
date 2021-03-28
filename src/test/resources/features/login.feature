Feature: Login

  @Login
  Scenario Outline: The user should be able to login valid credentials with different languages
    Given The user on the Mazaka loginPage
    When The user logs in "<username>" and "<password>"
    Then The user select language as "<Language>"
    Then The user should be able to click "<enter>" and able to login
    And The title contains "Dashboard"
    Examples:
      | username                | password     | Language                | enter      |
      | admin@mazakayazilim.com | 147852-Admin | Türkçe(Turkish) - tr    | Giriş      |
      | admin@mazakayazilim.com | 147852-Admin | Flemenkçe(Dutch) - nl   | page.enter |
      | admin@mazakayazilim.com | 147852-Admin | İngilizce(English) - en | Login      |

  Scenario Outline: User shouldn't be able to login invalid username
    Given The user on the Mazaka loginPage
    When The user logs in "<username>" and "<password>"
    Then The user select language as "<Language>"
    Then The user should be able to click "<enter>" and able to login
    Then The user should be able to see "<Error>"
    And The title contains "Dashboard"
    Examples:
      | username                | password     | Language                | enter      | Error                 |
      | admin                   | 147852-Admin | Türkçe(Turkish) - tr    | Giriş      | Please include an '@' |
#      | admin@.com              | 147852-Admin | Flemenkçe(Dutch) - nl   | page.enter | Please                |
#      | admin@mazakayazilim.com | 147852-Admin | İngilizce(English) - en | Login      | Please                |