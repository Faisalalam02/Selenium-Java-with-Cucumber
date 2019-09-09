package caspar_main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginInfo {

    private By patientForm = By.xpath("//*[contains(@id, 'mat-dialog-title')]");
    private By patientId = By.xpath("//app-new-user-dialog/div[2]/div[3]/div[3]/div[2]");
    private By patientPwd = By.xpath("//app-new-user-dialog/div[2]/div[3]/div[4]/div[2]");
    private By closeBtn = By.cssSelector(".mat-button");

    public WebElement getPatientForm (WebDriver driver)
    {
        return driver.findElement(patientForm);
    }

    public WebElement getPatientId(WebDriver driver)
    {
        return driver.findElement(patientId);
    }

    public WebElement getPatientPwd(WebDriver driver)
    {
        return driver.findElement(patientPwd);
    }

    public WebElement getCloseBtn(WebDriver driver)
    {
        return driver.findElement(closeBtn);
    }

}
