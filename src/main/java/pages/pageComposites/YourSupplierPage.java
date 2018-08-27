package pages.pageComposites;

/**
 * Created by ainer on 21/08/2018.
 */


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pageComposites.helpers.AbstractElementHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourSupplierPage extends AbstractElementHelper {
    /**
     * Standard PageObject constructor.
     *
     * @param driver WebDriver object passed on construction
     */
    public YourSupplierPage(WebDriver driver) {
        super(driver);
    }

    private final String postCodeField = "your-postcode";
    private final String postCodeBtn = "find-postcode";
    private final String haveBillBtn = "have-bill-label";
    private final String haveNoBillBtn = "no-bill-label";
    private final String dualEnergy = "dual-energy-suppliers-question";
    private final String elecEnergy = "elec-energy-suppliers-question";
    private final String gasEnergy = "gas-energy-suppliers-question";
    private final String changePostcode = "change-postcode";
    private final String header = "page-header";

    public WebElement header() {
        return getVisibilityOfElement(By.id(header));
    }

    /**
     * @return The 'Find Postcode' button.
     */
    public WebElement findPostcodeBtn() {
        return getVisibilityOfElement(By.id(postCodeBtn));
    }

    /**
     * @return The 'Change Postcode' button.
     */
    public WebElement changePostcodeBtn() {
        return getVisibilityOfElement(By.id(changePostcode));
    }

    /**
     * @return The 'Post Code' text field.
     */
    public WebElement postCodeField() {
        return getVisibilityOfElement(By.id(postCodeField));
    }

    public WebElement isBillAvailableQuestion() {
        return getVisibilityOfElement(By.xpath("//span[@class='question'][contains(text(),'bill')]"));
    }

    public WebElement haveBillBtn() {
        return getVisibilityOfElement(By.id(haveBillBtn));
    }

    public WebElement dontHaveBillBtn() {
        return getVisibilityOfElement(By.id(haveNoBillBtn));
    }

    public WebElement whatToCompareQuestion() {
        return getVisibilityOfElement(By.xpath("//span[@class='question'][contains(text(),'compare')]"));
    }

    public WebElement compareBothBtn() {
        return getVisibilityOfElement(By.xpath("//label[@for='compare-what-both']"));
    }

    public WebElement compareElectricityBtn() {
        return getVisibilityOfElement(By.xpath("//label[@for='compare-what-electricity']"));
    }

    public WebElement compareGasBtn() {
        return getVisibilityOfElement(By.xpath("//label[@for='compare-what-gas']"));
    }

    public WebElement sameSupplierQuestion() {
        return getVisibilityOfElement(By.xpath("//span[@class='question'][contains(text(),'same supplier')]"));
    }

    public WebElement sameSupplierYesBtn() {
        return getVisibilityOfElement(By.xpath("//label[@for='same-supplier-yes']"));
    }

    public WebElement sameSupplierNoBtn() {
        return getVisibilityOfElement(By.xpath("//label[@for='same-supplier-no']"));
    }

    public WebElement dualEnergyQuestion() {
        return getVisibilityOfElement(By.id(dualEnergy));
    }

    public WebElement elecEnergyQuestion() {
        return getVisibilityOfElement(By.id(elecEnergy));
    }

    public WebElement gasEnergyQuestion() {
        return getVisibilityOfElement(By.id(gasEnergy));
    }

    public WebElement selectSupplier(String energyType, String supplier) {

        return getVisibilityOfElement(By.xpath("//div[@ng-style='ctrl.Get" + energyType + "SupplierStyle()']//label[@class='" + supplier + " top-six']"));
    }

    public WebElement nextBtn() {
        return getPresenceOfElement(By.xpath("//*[@id='goto-your-supplier-details']"));
    }

    public WebElement dontKnowBtn(String energy) {
        return getVisibilityOfElement(By.xpath("//label[@for='" + energy + "-supplier-dont-know']"));
    }
}