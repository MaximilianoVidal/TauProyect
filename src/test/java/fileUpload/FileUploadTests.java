package fileUpload;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {
    @Test
    public void testFileUpload(){
        var uploadPage= homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\chromeDrivers\\chromedriver120v\\chromedriver.exe");
        assertEquals(uploadPage.getUploadFiles(),"chromedriver.exe","Uploaded files");

    }

}
