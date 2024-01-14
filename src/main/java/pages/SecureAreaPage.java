package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class SecureAreaPage {

    //atributes
    private WebDriver driver;
    private By statusAlert = By.id("flash");


    //constructor
    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    //method
    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }

}
