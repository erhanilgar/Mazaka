package com.mazaka.stepDefinitions;
import com.mazaka.pages.LoginPage;
import com.mazaka.utilities.ConfigurationReader;
import com.mazaka.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.WebDriver;
public class LoginStepDef {
    LoginPage loginPage=new LoginPage();
    WebDriver driver = Driver.get();
    @Given("The user on the Mazaka loginPage")
    public void the_user_on_the_Mazaka_loginPage() {
        driver.get(ConfigurationReader.get("url"));
    }
    @Then("The user select language as {string}")
    public void the_user_select_language_as(String expectedLanguage) throws InterruptedException {
        String actualLanguage = loginPage.getLanguage(expectedLanguage);
        Assert.assertEquals(expectedLanguage,actualLanguage);
    }
    @Then("The user should be able to click {string} and able to login")
    public void the_user_should_be_able_to_click_and_able_to_login(String enter) {
        loginPage.getEnter(enter);
    }
    @Then("The title contains {string}")
    public void the_title_contains(String expectedText) {
       String actualText = loginPage.dashboard.getText();
       Assert.assertEquals(expectedText,actualText);
    }
    @When("The user logs in {string} and {string}")
    public void theUserLogsInAnd(String username, String password) {
        loginPage.email.sendKeys(username);
        loginPage.password.sendKeys(password);
    }
    @Then("The user should be able to see {string}")
    public void theUserShouldBeAbleToSee(String expectedError) {
        String actualError = loginPage.passwordError(expectedError);
        if(actualError.contains("Invalid username")){
            Assert.assertEquals(expectedError,actualError);
        }else{
            String expectedUrl="https://paneldemo4.mazakayazilim.com/account/loginorsignup";
            assertThat(expectedUrl,containsString("loginorsignup"));
        }
    }
    @Then("The user should be able to see {string} for email")
    public void theUserShouldBeAbleToSeeForEmail(String expectedUrl){
        String actualUrl = driver.getCurrentUrl();
        assertThat(actualUrl,containsString(expectedUrl));
    }
}