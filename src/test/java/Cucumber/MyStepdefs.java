package Cucumber;

import caspar_test.BaseTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs extends BaseTest {


    // Scenario 1: Perform user login with valid credentials.
    @Given("^User is on login page$")
    public void user_is_on_login_page(){
        BaseTest baseTest = new BaseTest();
        baseTest.applicationLaunch();
    }

    @When("^User perform login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_perform_login_with_and(String userName, String password){
            userLogin(userName, password);
    }

    @Then("^User login successfully$")
    public void user_login_successfully() throws InterruptedException {
        Thread.sleep(2000);
        loginVerification();
    }


    // Scenario 2: Add patient record with mandatory details.
    @Given("^User click on Add patient button$")
    public void user_click_on_Add_patient_button() throws InterruptedException {
        Thread.sleep(3000);
        addPatient();
    }

    @When("^User enter first name as \"([^\"]*)\"$")
    public void userEnterFirstNameAs(String firstName) throws InterruptedException {
        Thread.sleep(2000);
            addFirstName(firstName);
    }

    @And("^User enter last name as \"([^\"]*)\"$")
    public void userEnterLastNameAs(String lastName){
            addLastName(lastName);
    }

    @And("^User select DOB as \"([^\"]*)\" - \"([^\"]*)\" - \"([^\"]*)\"$")
    public void userSelectDOBAs(String day, String month, String year){
            selectMonth(month);
            selectDay(day);
            selectYear(year);
    }

    @And("^User select Country as \"([^\"]*)\"$")
    public void userSelectCountryAs(String county){
            selectCountry(county);
    }

    @And("^User click on save button$")
    public void userClickOnSaveButton(){
            savePatientDetails();
    }

    @Then("^Patient info start appearing$")
    public void patient_info_start_appearing() throws InterruptedException {
        Thread.sleep(2000);
        patientVerification();
    }


    // Scenario 3: Perform login with patient credentials.
    @Given("^User copied patient info$")
    public void user_copied_patient_info(){
            patientLoginInfo();
    }

    @When("^User perform logout$")
    public void user_perform_logout(){
            signOut();
    }

    @And("^User perform login with patient credentials$")
    public void user_perform_login_with_patient_credentials() throws InterruptedException {
        Thread.sleep(2000);
        patientLogin();
    }

    @Then("^User landed on T&C and release of medical page$")
    public void user_landed_on_T_C_and_release_of_medical_page() throws InterruptedException {
        Thread.sleep(2000);
            patientLoginVerification();
    }

}
