package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PomBaseClass {
    public WebDriver driver;

    public PomBaseClass(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
