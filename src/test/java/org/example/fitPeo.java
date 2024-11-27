package org.example;

import baseClasses.baseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class fitPeo extends baseClass {
    @Test(priority = 1)
    public void featureOnRevenuePage(){
        rev.clickOnRevenueButton();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.fitpeo.com/";
        rev.waitForUrl(expectedUrl);
        Assert.assertEquals(currentUrl,expectedUrl);

        rev.scrollDown();
        rev.sliderMovement(94);

        rev.enterTheValue("560");
        String inputValue = rev.getValue();
        System.out.println(inputValue);


        rev.clickOnEveryCheckList();
        Assert.assertEquals(rev.getTotalValue(),"$110700");

    }

}
