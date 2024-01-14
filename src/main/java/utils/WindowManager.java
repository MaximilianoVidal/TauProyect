package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {

    public WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver){
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack() {
        navigate.back();
    }
    public void goForward() {navigate.forward();}
    public void refreshPage(){navigate.refresh();}
    public void goTo(String url){navigate.to(url);}

    public void switchToTab(String tabTittle){

        var windows = driver.getWindowHandles();
        System.out.println("number of tabs: " + windows.size());

        System.out.println("Window handle");
        windows.forEach(System.out::println);

        for (String window : windows){
            System.out.println("Switching to window: "+ window);

            System.out.println("Switching to window: "+ driver.getTitle());

            if (tabTittle.equals(driver.getTitle())){
                break;
            }
        }

    }

}
