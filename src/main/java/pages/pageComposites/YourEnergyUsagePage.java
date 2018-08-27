package pages.pageComposites;

/**
 * Created by ainer on 21/08/2018.
 */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.pageComposites.helpers.AbstractElementHelper;

public class YourEnergyUsagePage extends AbstractElementHelper {
    /**
     * Standard PageObject constructor.
     *
     * @param driver WebDriver object passed on construction
     */
    public YourEnergyUsagePage(WebDriver driver) {
        super(driver);
    }

    private final String tariffId = "tariff-type";
    private final String header = "page-header";

    public WebElement header() {
        return getVisibilityOfElement(By.id(header));
    }

    public WebElement tariffTypeQuestion() {
        return getVisibilityOfElement(By.id(tariffId));
    }


    public WebElement bedroomOptionBtn(String option) {
        return getPresenceOfElement(By.xpath("//label[@for='" + option + "-bedroom']"));
    }

    public WebElement occupantsOptionBtn(String option) {
        return getPresenceOfElement(By.xpath("//label[@for='" + option + "-occupants']"));
    }

    public WebElement heatingSourceBtn(String option) {
        return getPresenceOfElement(By.xpath("//label[@for='" + option + "-heat']"));
    }

    public WebElement tempOptionBtn(String option) {
        return getPresenceOfElement(By.xpath("//label[@for='" + option + "']"));
    }

    public WebElement insulationOptionBtn(String option) {
        return getPresenceOfElement(By.xpath("//label[@for='" + option + "']"));
    }

    public WebElement cookingOptionBtn(String option) {
        return getPresenceOfElement(By.xpath("//label[@for='" + option + "-cooking']"));
    }

    public WebElement oftenHomeOptionBtn(String option) {
        return getPresenceOfElement(By.xpath("//label[@for='" + option + "']"));
    }

    public WebElement nextBtn() {
        return getPresenceOfElement(By.xpath("//button[@class='button-primary']"));
    }
}