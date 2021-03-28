@smoke
Feature: Login
  @positive
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
  @negativeUsernama
  Scenario Outline: User shouldn't be able to login invalid username
    Given The user on the Mazaka loginPage
    When The user logs in "<username>" and "<password>"
    Then The user select language as "<Language>"
    Then The user should be able to click "<enter>" and able to login
    Then The user should be able to see "<Url>" for email
    Examples:
      | username       | password     | Language                | enter      | Url           |
      | admin          | 147852-Admin | Türkçe(Turkish) - tr    | Giriş      | loginorsignup |
      | admin@com      | 147852-Admin | Flemenkçe(Dutch) - nl   | page.enter | loginorsignup |
      | aabc/gmail.com | 147852-Admin | Türkçe(Turkish) - tr    | Giriş      | loginorsignup |
      | @hotmail.com   | 147852-Admin | İngilizce(English) - en | Login      | loginorsignup |
      |                | 147852-Admin | Türkçe(Turkish) - tr    | Giriş      | loginorsignup |
  @negativePassword
  Scenario Outline: User shouldn't be able to login invalid password
    Given The user on the Mazaka loginPage
    When The user logs in "<username>" and "<password>"
    Then The user select language as "<Language>"
    Then The user should be able to click "<enter>" and able to login
    Then The user should be able to see "<Error>"
    Examples:
      | username                | password    | Language                | enter      | Error                                  |
      | admin@mazakayazilim.com | 147852-Adm  | Türkçe(Turkish) - tr    | Giriş      | Kullanıcı adı veya Şifre hatalı        |
      | admin@mazakayazilim.com | 14Admin     | Flemenkçe(Dutch) - nl   | page.enter | Ongeldige gebruikersnaam of wachtwoord |
      | admin@mazakayazilim.com | TestPasswor | İngilizce(English) - en | Login      | Invalid username or password           |
      | admin@mazakayazilim.com |             | İngilizce(English) - en | Login      | Invalid username or password           |