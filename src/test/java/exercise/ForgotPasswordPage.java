package exercise;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordPage extends BaseTests {

    @Test
    public void testRetrievePassword(){
        var forgetPasswordPage= homePage.clickForgotPassword();
        var emailSentPage = forgetPasswordPage.retrievePassword("tau@example.com");
        assertEquals(emailSentPage.getMessage(),"Your e-mail's been sent!","Message is incorrect");

    }


}
