package pages.pageComposites;

/**
 * Created by ainer on 21/08/2018.
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yecht.Data;
import pages.pageComposites.helpers.AbstractElementHelper;

public class YourElectricityPage extends AbstractElementHelper {
    /**
     * Standard PageObject constructor.
     *
     * @param driver WebDriver object passed on construction
     */
    public YourElectricityPage(WebDriver driver) {
        super(driver);
    }

    private final String tariffId = "electricity-tariff-additional-info";
    private final String paymentId = "electricity-payment-method-dropdown-link";
    private final String periodId = "electricity-spend-dropdown";
    private final String spendId = "electricity-spend";
    private final String spendElecId = "electricity-current-spend";
    private final String header = "page-header";

    public WebElement header() {
        return getVisibilityOfElement(By.id(header));
    }

    /**
     * @return The tariff dropdown button
     */
    public WebElement tariffDropdown() {
        return getVisibilityOfElement(By.id(tariffId));
    }

    public WebElement tariffOption(String option) {
        return getVisibilityOfElement(By.xpath("//option[@label='" + option + "']"));
    }

    public WebElement economyMeterQuestion() {
        return getVisibilityOfElement(By.xpath("//*[@class='question'][contains(text(),'Economy 7')]"));
    }

    public WebElement paymentQuestion() {
        return getVisibilityOfElement(By.xpath("//span[@class='question'][contains(text(),'pay')]"));
    }

    public WebElement heatingQuestion() {
        return getVisibilityOfElement(By.xpath("//span[@class='question'][contains(text(),'heating')]"));
    }

    public WebElement usageQuestion() {
        return getVisibilityOfElement(By.xpath("//span[@class='question'][contains(text(),'usage')]"));
    }

    public WebElement dayKWHQuestion() {
        return getVisibilityOfElement(By.xpath("//label[@for='economy-7-day-usage']"));
    }

    public WebElement nightKWHQuestion() {
        return getVisibilityOfElement(By.xpath("//label[@for='economy-7-night-usage']"));
    }

    public WebElement economyAnswerYes() {
        return getVisibilityOfElement(By.xpath("//label[@for='economy-7-yes']"));
    }

    public WebElement economyAnswerNo() {
        return getVisibilityOfElement(By.xpath("//label[@for='economy-7-no']"));
    }

    public WebElement paymentDropdown() {
        return getVisibilityOfElement(By.id(paymentId));
    }

    public WebElement paymentOption(String option) {
        return getVisibilityOfElement(By.xpath("//option[@label='" + option + "']"));
    }

    public WebElement mainHeatingBtn(String answer) {
        return getVisibilityOfElement(By.xpath("//label[@for='electricity-main-heating-" + answer + "']"));
    }

    public WebElement usageAnswerBtn(String answer) {
        return getVisibilityOfElement(By.xpath("//label[@for='" + answer + "Spend']"));
    }

    public void dayKwhQuestion() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[@for='economy-7-day-usage]")));
    }

    public void nightKwhQuestion() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//label[@for='economy-7-night-usage']")));
    }

    public WebElement spendAmountField() {
        return getVisibilityOfElement(By.id(spendId));
    }

    public WebElement spendAmountElecField() {
        return getVisibilityOfElement(By.id(spendElecId));
    }

    public WebElement billPeriodDropdown() {
        return getVisibilityOfElement(By.id(periodId));
    }

    public WebElement billPeriodType(String option) {
        return getVisibilityOfElement(By.xpath("//option[@value='" + option + "']"));
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
        return getVisibilityOfElement(By.xpath("//label[@for='electricity-dont-know']"));
    }

    public WebElement nextBtn() {
        return getPresenceOfElement(By.xpath("//button[@class='button-primary']"));
    }
}