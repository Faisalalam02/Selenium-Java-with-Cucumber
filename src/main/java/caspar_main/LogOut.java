package caspar_main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOut {

    // Storing web elements path
    private By userIcon  = By.cssSelector(".initials");
    private By signOut = By.xpath("//button[contains(text(),'Sign out')]");

    // All theses methods will return respective Web element
    public WebElement getUserIcon(WebDriver driver)
    {
        return driver.findElement(userIcon);
    }

    public WebElement getSignOutBtn(WebDriver driver)
    {
        return driver.findElement(signOut);
    }

}
