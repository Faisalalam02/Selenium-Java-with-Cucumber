package caspar_main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private By userName = By.name("login");
    private By password = By.name("password");
    private By loginBtn = By.cssSelector(".login");
    private By patientLogin = By.cssSelector(".tos-large");

    public WebElement getEmail (WebDriver driver)
    {
        return driver.findElement(userName);
    }
    public WebElement getPassword(WebDriver driver)
    {
        return driver.findElement(password);
    }
    public WebElement getLoginBtn(WebDriver driver)
    {
        return driver.findElement(loginBtn);
    }
    public WebElement patientLoginSuccess(WebDriver driver)
    {
        return driver.findElement(patientLogin);
    }
}
