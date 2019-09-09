package caspar_main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddPatient {

    private By addPatient = By.xpath("//button[contains(.,'Add Patient')]");
    //Method will return add patient button
    public WebElement getAddPatient(WebDriver driver)
    {
        return driver.findElement(addPatient);
    }
}
