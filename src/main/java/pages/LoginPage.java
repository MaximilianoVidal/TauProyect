package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //atributes for the login
    private WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");

    private By loginButton = By.cssSelector("#login Button");

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //methods for login
    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }


}
