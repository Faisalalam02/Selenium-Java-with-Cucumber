package caspar_main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PersonalInformation {

    // Storing web element path
     private By saveBtn = By.cssSelector(".divider-right");
     private By birthDay = By.xpath("//mat-select[@formcontrolname='day']");
     private By birthMonth = By.xpath("//mat-select[@formcontrolname='month']");
     private By birthYear = By.xpath("//mat-select[@formcontrolname='year']");
     private By country = By.xpath("//mat-select[@formcontrolname='country_id']");
     private By firstName = By.xpath("//input[@formcontrolname='first_name']");
     private By lastName = By.xpath("//input[@formcontrolname='last_name']");
     private By dropdown = By.cssSelector(".ng-trigger-transformPanel");

    // All theses methods will return respective Web element
    public WebElement getFirstName(WebDriver driver)
    {
        return driver.findElement(firstName);
    }

    public WebElement getLastName(WebDriver driver)
    {
        return  driver.findElement(lastName);
    }

    public WebElement clickBirthDay (WebDriver driver) {
        return driver.findElement(birthDay);
    }

    public List<WebElement> getBirthDay (WebDriver driver)
    {
        return driver.findElements(dropdown);
    }

    public WebElement clickBirthMonth (WebDriver driver) {
        return driver.findElement(birthMonth);
    }

    public List<WebElement> getBirthMonth (WebDriver driver) {
         return driver.findElements(dropdown);
    }

    public WebElement clickBirthYear (WebDriver driver) {
        return driver.findElement(birthYear);
    }

    public List<WebElement> getBirthYear (WebDriver driver)
    {
        return driver.findElements(dropdown);
    }

    public WebElement clickCountry (WebDriver driver) {
        return driver.findElement(country);
    }

    public List<WebElement> getCountry (WebDriver driver)
    {
        return driver.findElements(dropdown);
    }

    public WebElement getSaveBtn (WebDriver driver)
    {
        return  driver.findElement(saveBtn);
    }
}
