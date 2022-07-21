package com.cybertek.step_definitions;

import com.cybertek.pages.LandingPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    LandingPage landingPage = new LandingPage();
    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));

    }

    @When("User logs in as a librarian")
    public void user_logs_in_as_a_librarian() {
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("lib_22user"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("lib_22pass"));
        loginPage.loginBtn.click();
    }

    @Then("User should be on the dashboard page")
    public void user_should_be_on_the_dashboard_page() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains("dashboard"));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
        Driver.closeDriver();
    }

    @When("User logs in as a student")
    public void userLogsInAsAStudent() {
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("stud_22user"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("stud_22pass"));
        loginPage.loginBtn.click();
    }

    @Then("User should be on the books page")
    public void userShouldBeOnTheBooksPage() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains("books"));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("books"));
        Driver.closeDriver();
    }

    @When("User enters {string} username")
    public void user_enters_username(String username) {

        loginPage.usernameInput.sendKeys(username);


    }
    @When("User enters {string} password")
    public void user_enters_password(String password) {

        loginPage.passwordInput.sendKeys(password);
    }
    @When("User clicks sign in button")
    public void user_clicks_sign_in_button() {

        loginPage.loginBtn.click();

    }
    @Then("there should be {int} users")
    public void there_should_be_users(Integer numOfUsers) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(landingPage.userCount));

        Assert.assertEquals(String.valueOf(numOfUsers),landingPage.userCount.getText());

    }

    @When("User enters {string} username and {string} password")
    public void userEntersUsernameAndPassword(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();
    }

}
