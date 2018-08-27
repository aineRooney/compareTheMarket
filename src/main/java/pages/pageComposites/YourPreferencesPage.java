package pages.pageComposites;

/**
 * Created by ainer on 21/08/2018.
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pageComposites.helpers.AbstractElementHelper;

public class YourPreferencesPage extends AbstractElementHelper {
    /**
     * Standard PageObject constructor.
     *
     * @param driver WebDriver object passed on construction
     */
    public YourPreferencesPage(WebDriver driver) {
        super(driver);
    }

    private final String tariffId = "tariff-type";
    private final String paymentId = "payment-type";
    private final String emailId = "Email";
    private final String termsId = "terms-label";
    private final String header = "page-header";

    public WebElement header() {
        return getVisibilityOfElement(By.id(header));
    }

    public WebElement tariffTypeQuestion() {
        return getVisibilityOfElement(By.id(tariffId));
    }

    public WebElement tariffTypeBtn(String type) {
        return getVisibilityOfElement(By.xpath("//label[@class='" + type + "-rate']"));
    }

    public WebElement paymentTypeQuestion() {
        return getVisibilityOfElement(By.id(paymentId));
    }

    public WebElement paymentOptionsBtn(String option) {
        return getVisibilityOfElement(By.xpath("//label[@for='pre-select-payment-" + option + "']"));
    }

    public WebElement emailField() {
        return getVisibilityOfElement(By.id(emailId));
    }

    public WebElement termsBtn() {
        return getVisibilityOfElement(By.id(termsId));
    }

    public WebElement nextBtn() {
        return getPresenceOfElement(By.xpath("//button[@class='button-primary']"));
    }
}