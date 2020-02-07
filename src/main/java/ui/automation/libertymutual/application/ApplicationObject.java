package ui.automation.libertymutual.application;

import org.openqa.selenium.chrome.ChromeDriver;
import ui.automation.libertymutual.pages.HomePage;
import ui.automation.libertymutual.pages.PersonalInformation;
import ui.automation.libertymutual.pages.SelectProduct;

public class ApplicationObject {
    public PersonalInformation personalInformation;
    public SelectProduct selectProduct;
    public HomePage homePage;


    public ApplicationObject(ChromeDriver driver) throws Exception {
        personalInformation = new PersonalInformation(driver);
        selectProduct = new SelectProduct(driver);
        homePage = new HomePage(driver);
    }
}
