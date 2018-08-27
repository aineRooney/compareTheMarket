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

public class YourGasPage extends AbstractElementHelper {
    /**
     * Standard PageObject constructor.
     *
     * @param driver WebDriver object passed on construction
     */
    public YourGasPage(WebDriver driver) {
        super(driver);
    }

    private final String tariffId = "gas-tariff-additional-info";
    private final String paymentId = "gas-payment-method-dropdown-link";
    private final String periodId = "type-of-Gas-bill-dropdown";
    private final String usageId = "gas-usage";
    private final String tariffQuest = "gas-tariff-question";
    private final String gasQuest = "gas-payment-method-question";
    private final String header = "page-header";

    public WebElement header() {
        return getVisibilityOfElement(By.id(header));
    }

    /*public WebElement header() {
         return getVisibilityOfElement(By.xpath("//section[@ng-show='ctrl.isElectricitySectionDisplayed']"));
     }
 */
    public WebElement tariffQuestion() {
        return getVisibilityOfElement(By.id(tariffQuest));
    }

    /**
     * @return The
     */
    public WebElement tariffDropdown() {
        return getVisibilityOfElement(By.id(tariffId));
    }

    public WebElement tariffOption(String option) {
        return getVisibilityOfElement(By.xpath("//option[@label='" + option + "']"));
    }

    public WebElement paymentQuestion() {
        return getVisibilityOfElement(By.id(gasQuest));
    }

    public WebElement heatingQuestion() {
        return getVisibilityOfElement(By.xpath("//fieldset[@id='gas-main-heating-source-question']"));
    }

    public WebElement usageQuestion() {
        return getVisibilityOfElement(By.xpath("//fieldset[@id='gas-type-of-bill-question']"));
    }

    public WebElement paymentDropdown() {
        return getVisibilityOfElement(By.id(paymentId));
    }

    public WebElement paymentOption(String option) {
        return getVisibilityOfElement(By.xpath("//*[@label='" + option + "']"));
    }

    public WebElement mainHeatingBtn(String answer) {
        return getVisibilityOfElement(By.xpath("//label[@for='gas-main-heating-" + answer + "']"));
    }

    public WebElement usageAnswerBtn(String answer) {
        return getVisibilityOfElement(By.xpath("//label[@for='" + answer + "SpendG']"));
    }

    public WebElement usageAmountField() {
        return getVisibilityOfElement(By.id(usageId));
    }

    public WebElement billPeriodDropdown() {
        return getVisibilityOfElement(By.id(periodId));
    }

    public WebElement billPeriodType(String option) {
        return getVisibilityOfElement(By.xpath("//label/*[@value='" + option + "']"));
    }

    public void billDateRemoved() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[@for='electricity-bill-day']")));
    }

    public WebElement prepayMeterQuestion() {
        return getVisibilityOfElement(By.xpath("//fieldset[@id='prepay-yes-no']"));
    }

    public WebElement prepayAnswerBtn(String answer) {
        return getVisibilityOfElement(By.xpath("//label[@for='prepayment-" + answer + "']"));
    }

    public WebElement dontKnowSpendBtn() {
        return getVisibilityOfElement(By.xpath("//label[@for='gas-dont-know']"));
    }

    public WebElement nextBtn() {
        return getPresenceOfElement(By.xpath("//button[@class='button-primary']"));
    }
}