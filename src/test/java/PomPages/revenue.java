package PomPages;

import baseClasses.PomBaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class revenue extends PomBaseClass {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public revenue(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Revenue Calculator')]")
    WebElement revenueButton;

    @FindBy(css = ".MuiSlider-thumb.MuiSlider-thumbSizeMedium.MuiSlider-thumbColorPrimary.MuiSlider-thumb.MuiSlider-thumbSizeMedium.MuiSlider-thumbColorPrimary.css-1sfugkh")
    WebElement sliderBar;

    @FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']") WebElement valueInput;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]") WebElement CPT99091;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]") WebElement CPT99453;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]") WebElement CPT99454;

    @FindBy(xpath = "(//input[@type='checkbox'])[8]") WebElement CPT99474;

    @FindBy(xpath = "(//p[@class = 'MuiTypography-root MuiTypography-body1 inter css-1bl0tdj'])[4]") WebElement TotalRecurringReimbursementPatientsPerMonth;

    public void clickOnRevenueButton(){
        revenueButton.click();
    }

    public void sliderMovement(int n){
        WebElement visibleEl = driver.findElement(By.xpath("//h4[contains(text(),'Medicare Eligible Patients')]"));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Medicare Eligible Patients')]")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", visibleEl);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(sliderBar,n,0);
        WebElement slider = driver.findElement(By.cssSelector(
                "body > div.MuiBox-root.css-3f59le > div.MuiBox-root.css-rfiegf > div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-6.css-l0ykmo > div:nth-child(2) > div > div > span.MuiSlider-root.MuiSlider-colorPrimary.MuiSlider-sizeMedium.css-16i48op"));

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(
                "body > div.MuiBox-root.css-3f59le > div.MuiBox-root.css-rfiegf > div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-6.css-l0ykmo > div:nth-child(2) > div > div > span.MuiSlider-root.MuiSlider-colorPrimary.MuiSlider-sizeMedium.css-16i48op"))));

        actions.clickAndHold(slider).moveByOffset(-26, 0).release().perform();
        for (int i = 0; i < 2; i++) {
            actions.sendKeys(Keys.ARROW_LEFT).perform();
        }

    }

    public void enterTheValue(String value){
        WebElement values = driver.findElement(By.xpath("(//input[@value= '820'])[2]"));
        values.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        valueInput.sendKeys(Keys.DELETE);
        valueInput.sendKeys(value);
    }

    public void clickOnEveryCheckList(){
        valueInput.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        valueInput.sendKeys("820");
        CPT99091.click();
        CPT99453.click();
        CPT99454.click();
        CPT99474.click();
    }

    public void waitForUrl(String url ){

        wait.until(ExpectedConditions.urlToBe(url));
    }

    public void scrollDown(){
        js.executeScript("arguments[0].scrollIntoView(true);", sliderBar);
    }

    public String getValue(){
        return valueInput.getText();
    }

    public String getTotalValue(){
        return TotalRecurringReimbursementPatientsPerMonth.getText();
    }

}
