package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import pages.pageComposites.*;

/**
 * Created by ainer on 22/08/2018.
 */
public class EnergyPage extends PageObject {
    /**
     * WebDriver element for controlling page access.
     */
    private final WebDriver driver;

    private YourElectricityPage electricityPage;
    private YourSupplierPage supplierPage;
    private YourPreferencesPage preferencesPage;
    private YourGasPage gasPage;
    private YourEnergyUsagePage usagePage;
    private YourResultsPage resultsPage;

    /**
     * Standard PageObject constructor.
     *
     * @param newDriver incoming WebDriver object to use.
     */
    public EnergyPage(WebDriver newDriver) {
        super(newDriver);
        this.driver = newDriver;
        supplierPage = new YourSupplierPage(driver);
        electricityPage = new YourElectricityPage(driver);
        preferencesPage = new YourPreferencesPage(driver);
        gasPage = new YourGasPage(driver);
        usagePage = new YourEnergyUsagePage(driver);
        resultsPage = new YourResultsPage(driver);
    }

    /**
     * Returns the supplier page object.
     */
    public YourSupplierPage getSupplierPage() {
        return supplierPage;
    }

    /**
     * Returns the electricity page object.
     */
    public YourElectricityPage getElectricityPage() {
        return electricityPage;
    }

    /**
     * Returns the preferences page object.
     */
    public YourPreferencesPage getPreferencesPage() {
        return preferencesPage;
    }

    /**
     * Returns the gas page object.
     */
    public YourGasPage getGasPage() {
        return gasPage;
    }

    /**
     * Returns the energy usage page object.
     */
    public YourEnergyUsagePage getUsagePage() {
        return usagePage;
    }

    /**
     * Returns the results page object.
     */
    public YourResultsPage getResultsPage() {
        return resultsPage;
    }
}
