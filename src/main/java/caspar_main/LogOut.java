package caspar_main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOut {


    private By userIcon  = By.cssSelector(".initials");
    private By signOut = By.xpath("//button[contains(text(),'Sign out')]");

    public WebElement getUserIcon(WebDriver driver)
    {
        return driver.findElement(userIcon);
    }

    public WebElement getSignOutBtn(WebDriver driver)
    {
        return driver.findElement(signOut);
    }

}
