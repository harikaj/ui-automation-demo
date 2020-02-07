package ui.automation.libertymutual.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ui.automation.libertymutual.CommonController;
import ui.automation.libertymutual.constants.XpathConstants;

public class PersonalInformation {
    ChromeDriver driver;

    public PersonalInformation(ChromeDriver driver) {
        this.driver = driver;
    }

    public void enterPersonalInformation(String inputAddress, int inputYearsAtResidence) {
        CommonController.waitForElement(driver, XpathConstants.ADDRESS_XPATH, 25);

        WebElement address = driver.findElement(By.xpath(XpathConstants.ADDRESS_XPATH));
        Assert.assertTrue(address.isDisplayed(), "Address element appears in the personal info page");
        address.sendKeys(inputAddress);

        Select yearsAtResidence = new Select(driver.findElement(By.xpath(XpathConstants.YEARS_AT_RESIDENCE_XPATH)));
        Assert.assertNotEquals(yearsAtResidence, null, "Years at residence element appears in the personal info page");
        yearsAtResidence.selectByIndex(inputYearsAtResidence);

        WebElement nextButtonElement = driver.findElement(By.xpath(XpathConstants.NEXT_BUTTON_XPATH));
        Assert.assertTrue(nextButtonElement.isDisplayed(), "Next button element appears in the personal info page");
        nextButtonElement.click();
    }
}
