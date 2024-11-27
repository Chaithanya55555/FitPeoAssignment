package baseClasses;

import PomPages.revenue;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class baseClass {
    public WebDriver driver;
    public revenue rev;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.fitpeo.com");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        rev = new revenue(driver);
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }

    }
}
