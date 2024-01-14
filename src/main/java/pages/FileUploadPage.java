package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;

    private By inputField= By.id("file-upload");
    private By uploadButton= By.id("file-submit");
    private By uploadedFile= By.id("uploaded-file");

    public FileUploadPage(WebDriver driver){
        this.driver= driver;
    }
    public void clickUploadButton(){driver.findElement(uploadButton).click();}

    /**
     * provides path of file to the form the clicks upload button
     * @param absolutePathOfFile the complete path of the file to upload
     */

    public void uploadFile( String absolutePathOfFile ){
        driver.findElement(inputField).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }
    public String getUploadFiles(){return driver.findElement(uploadedFile).getText();}
}

