package ui.automation.libertymutual.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import ui.automation.libertymutual.CommonController;
import ui.automation.libertymutual.constants.XpathConstants;

public class SelectProduct {

    ChromeDriver driver;

    public SelectProduct(ChromeDriver driver) {
        this.driver = driver;
    }

    public void selectProductDetails(String zipCode) {
        CommonController.waitForElement(driver, XpathConstants.INPUT_NAME_ZIPCODE, 15);
        WebElement zipCodeElement = driver.findElement(By.xpath(XpathConstants.INPUT_NAME_ZIPCODE));
        zipCodeElement.sendKeys(zipCode);

        CommonController.waitForElement(driver, XpathConstants.SUBMIT_XPATH, 15);
        WebElement submitElement = driver.findElement(By.xpath(XpathConstants.SUBMIT_XPATH));
        submitElement.click();
    }

    public void enterZipCode(String zipCode) {
        CommonController.waitForElement(driver, XpathConstants.INPUT_NAME_ZIPCODE, 15);
        WebElement zipCodeElement = driver.findElement(By.xpath(XpathConstants.INPUT_NAME_ZIPCODE));
        Assert.assertTrue(zipCodeElement.isDisplayed(), "Zip code appears");
        zipCodeElement.sendKeys(zipCode);
    }

    public void clickGetPriceButton() {
        CommonController.waitForElement(driver, XpathConstants.SUBMIT_XPATH, 15);
        WebElement submitElement = driver.findElement(By.xpath(XpathConstants.SUBMIT_XPATH));
        Assert.assertTrue(submitElement.isDisplayed(), "Submit button appears");
        submitElement.click();
    }
}
