package com.mazaka.stepDefinitions;

import com.mazaka.pages.LoginPage;
import com.mazaka.utilities.ConfigurationReader;
import com.mazaka.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
    public void the_title_contains(String string) {
        System.out.println("loginPage.dashboard.getText() = " + loginPage.dashboard.getText());
    }

    @When("The user logs in {string} and {string}")
    public void theUserLogsInAnd(String username, String password) {
        loginPage.email.sendKeys(username);
        loginPage.password.sendKeys(password);
    }

    @Then("The user should be able to see {string}")
    public void theUserShouldBeAbleToSee(String error) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("loginPage.email.getText() = " + loginPage.email.getText());
        Alert alert = driver.switchTo().alert();
        String alertMessage= driver.switchTo().alert().getText();
        System.out.println("alertMessage = " + alertMessage);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("alert");


    }
}
