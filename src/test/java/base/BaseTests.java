
package base;

import com.google.common.io.Files;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.CookieManager;
import utils.EventReporter;
import utils.WindowManager;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromeDrivers\\chromedriver120v\\chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        goHome();
        setCookie();

    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }



    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {
        if (ITestResult.FAILURE== result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot= camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot,new File("resources/screenshots/"+ result.getName()+".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
            System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
        }}

     @AfterMethod
     public void tearDown() {
        driver.quit();
     }
    private ChromeOptions getChromeOptions() {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true);
        return options;
    }

    private void setCookie(){
        Cookie cookie=new Cookie.Builder("tau","123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);

    }
  public WindowManager getWindowManager(){
        return new WindowManager(driver);
  }
  public CookieManager getCookieManager(){
        return new CookieManager(driver);
  }

}