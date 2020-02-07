package ui.automation.libertymutual.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import ui.automation.libertymutual.CommonController;
import ui.automation.libertymutual.constants.XpathConstants;

public class HomePage {

    ChromeDriver driver;

    public HomePage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void clickProduct(String productType) throws Exception {
        switch (productType) {
            case "auto":
                CommonController.waitForElement(driver, XpathConstants.PRODUCT_AUTO_XPATH, 15);
                WebElement autoElement = driver.findElement(By.xpath(XpathConstants.PRODUCT_AUTO_XPATH));
                Assert.assertTrue(autoElement.isDisplayed(), "Auto element appears in the home page");
                autoElement.click();
        }

    }
}
