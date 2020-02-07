package com.validation.data;

import com.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.automation.libertymutual.CommonController;
import ui.automation.libertymutual.constants.XpathConstants;

public class AutoProduct extends BaseTest {


    @Test(priority = 1)
    public void enterInvalidZip() throws Exception {
        applicationObject().homePage.clickProduct(dataset.get("valid").get("productType").asText());
        applicationObject().selectProduct.enterZipCode(dataset.get("invalidZip").get("zipcode").asText());
        applicationObject().selectProduct.clickGetPriceButton();
        CommonController.waitForElement(driver, XpathConstants.ZIPCODE_VALIDATION_MESSAGE_XPATH, 15);
        WebElement zipCodeValidationMessage = driver.findElement(By.xpath(XpathConstants.ZIPCODE_VALIDATION_MESSAGE_XPATH));
        Assert.assertTrue(zipCodeValidationMessage.isDisplayed(), "Zip code validation message showed up as expected");
    }

    @Test(priority = 2)
    public void enterValidData() throws Exception {
        driver.navigate().to(driver.getCurrentUrl());
        applicationObject().homePage.clickProduct(dataset.get("valid").get("productType").asText());
        applicationObject().selectProduct.enterZipCode(dataset.get("valid").get("zipcode").asText());
        applicationObject().selectProduct.clickGetPriceButton();
        applicationObject().personalInformation.enterPersonalInformation(dataset.get("valid").get("address").asText(), dataset.get("valid").get("yearsAtResidence").asInt());
    }
}
