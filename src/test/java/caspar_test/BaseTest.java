package caspar_test;

import caspar_main.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    private static WebDriver driver;
    private static String patientId;
    private static String patientPwd;

    private PersonalInformation personalInfo = new PersonalInformation();
    private WebDriverWait wait = new WebDriverWait(driver, 10);

        public static void browserLaunch() {
            System.setProperty("webdriver.chrome.driver",
                "D://FaisalData//QATools//Selenium//drivers//chromedriver_win32//chromedriver.exe");
            driver = new ChromeDriver();
        }

        public static void browserClose()
        {
            driver.quit();
        }

        public void applicationLaunch()
        {
            driver.get("https://beta.caspar-health.com/en/#/user/sign_in");
        }

        protected void userLogin (String userName, String password) {
            try {
                LoginPage loginPage = new LoginPage();
                loginPage.getEmail(driver).sendKeys(userName);
                loginPage.getPassword(driver).sendKeys(password);
                loginPage.getLoginBtn(driver).click();
            }
            catch (NoSuchElementException e)
            {
                System.out.println("Unable to login. Any field is missing.");
                e.printStackTrace();
            }
        }

        protected void loginVerification() {
            try {
                AddPatient addPatient = new AddPatient();
                Assert.assertTrue(addPatient.getAddPatient(driver).isDisplayed());
                System.out.println("User logged In successfully.");
            }
            catch (NoSuchElementException e)
            {
                System.out.println("Login attempt was un-successful.");
                e.printStackTrace();
            }
        }

        protected void addPatient() {
            try {
                AddPatient addPatient = new AddPatient();
                addPatient.getAddPatient(driver).click();
            }
            catch (NoSuchElementException e)
            {
                System.out.println("Add patient button is not available on web page.");
                e.printStackTrace();
            }
        }

        protected void addFirstName(String firstName) {
            try {
                personalInfo.getFirstName(driver).sendKeys(firstName);
            }
            catch (NoSuchElementException e)
            {
                System.out.println("First Name field not available.");
                e.printStackTrace();
            }
        }

        protected void addLastName(String lastName) {
            try {
                personalInfo.getLastName(driver).sendKeys(lastName);
                }
            catch (NoSuchElementException e)
            {
                System.out.println("Last Name field not available.");
                e.printStackTrace();
            }
        }

        protected void selectDay(String day) {
            try{
            personalInfo.clickBirthDay(driver).click();
            for (WebElement opt : personalInfo.getBirthDay(driver))
                if (opt.getText().contains(day)) {
                    opt.click();
                    }
            else {
                    throw new NoSuchElementException("Invalid day. Please enter values from 1 to 31");
                 }
                }
                catch (NoSuchElementException e) {
                System.out.println("Day field is not available.");
                e.printStackTrace();
            }
        }

        protected void selectMonth(String month) {
            try{
            personalInfo.clickBirthMonth(driver).click();
            for (WebElement opt : personalInfo.getBirthMonth(driver))
                if (opt.getText().contains(month)) {
                    opt.click();
                } else {
                    throw new NoSuchElementException("Invalid month. Please enter correct month name.");
                }
        }
                catch (NoSuchElementException e) {
                System.out.println("Month field is not available.");
                e.printStackTrace();
            }
            }

        protected void selectYear(String year) {
            try {
                personalInfo.clickBirthYear(driver).click();
                for (WebElement opt : personalInfo.getBirthYear(driver))
                    if (opt.getText().contains(year)) {
                        opt.click();
                    } else {
                        throw new NoSuchElementException("Invalid year. Please enter correct year in format xxxx.");
                    }
            }
                catch (NoSuchElementException e) {
                System.out.println("Year field is not available.");
                e.printStackTrace();
            }
        }

        protected void selectCountry(String country) {
            try {
                JavascriptExecutor js = ((JavascriptExecutor) driver);
                js.executeScript("arguments[0].scrollIntoView();", personalInfo.clickCountry(driver));
                personalInfo.clickCountry(driver).click();
                for (WebElement opt : personalInfo.getCountry(driver))
                    if (opt.getText().contains(country)) {
                        opt.click();
                    } else {
                        throw new NoSuchElementException("Invalid country. Please enter correct correct country name.");
                    }
            }
                catch (NoSuchElementException e)
            {
                System.out.println("Country field is not available.");
                e.printStackTrace();
            }
        }

        protected void savePatientDetails() {
            try {
                personalInfo.getSaveBtn(driver).click();
            }
            catch (NoSuchElementException e)
            {
                System.out.println("Save button not available");
                e.printStackTrace();
            }
        }

        protected void patientVerification() {
            try {
                LoginInfo loginInfo = new LoginInfo();
                Assert.assertTrue(loginInfo.getPatientForm(driver).isDisplayed());
                System.out.println("Patient record successfully added.");
            }
              catch (NoSuchElementException e)
            {
                System.out.println("Patient didn't registered successfully. Info not available");
                e.printStackTrace();
            }
          }

        protected void patientLoginInfo() {
         try{
             LoginInfo loginInfo = new LoginInfo();
             patientId = loginInfo.getPatientId(driver).getText();
             patientPwd = loginInfo.getPatientPwd(driver).getText();
             loginInfo.getCloseBtn(driver).click();
            }
        catch (NoSuchElementException e)
            {
                System.out.println("Element not available on webpage");
                e.printStackTrace();
            }
    }

        protected void signOut() {
            try {
                LogOut logOut = new LogOut();
                logOut.getUserIcon(driver).click();
                logOut.getSignOutBtn(driver).click();
                System.out.println("User sign out successfully.");
            }
            catch (NoSuchElementException e)
            {
                System.out.println("Sign out button not available on web page.");
                e.printStackTrace();
            }
        }

        protected void patientLogin() {
            try {
                LoginPage loginPage = new LoginPage();
                loginPage.getEmail(driver).sendKeys(patientId);
                loginPage.getPassword(driver).sendKeys(patientPwd);
                loginPage.getLoginBtn(driver).click();
            }
            catch (NoSuchElementException e)
            {
                System.out.println("Email or password field is not available web page.");
                e.printStackTrace();
            }
        }

        protected void patientLoginVerification() {
            try {
                LoginPage loginPage = new LoginPage();
                Assert.assertTrue(loginPage.patientLoginSuccess(driver).isDisplayed());
                System.out.println("Patient logged in successfully: \nTEST CASE PASSED: " +
                        "T&C and release medical page is appearing.");
            }
            catch(NoSuchElementException e)
            {
                System.out.println("Patient logged in successfully: \nTEST CASE FAILED: " +
                        "T&C and release medical page not appeared.");
                e.printStackTrace();
            }
        }

}
