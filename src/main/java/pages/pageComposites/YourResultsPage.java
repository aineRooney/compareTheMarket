package pages.pageComposites;

/**
 * Created by ainer on 21/08/2018.
 */


import com.gargoylesoftware.htmlunit.javascript.host.canvas.ext.WEBGL_compressed_texture_s3tc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.pageComposites.helpers.AbstractElementHelper;

public class YourResultsPage extends AbstractElementHelper {
    /**
     * Standard PageObject constructor.
     *
     * @param driver WebDriver object passed on construction
     */
    public YourResultsPage(WebDriver driver) {
        super(driver);
    }

    private final String header = "page-header";

    public WebElement header() {
        return getVisibilityOfElement(By.id(header));
    }


    public WebElement detailsSection() {
        return getPresenceOfElement(By.xpath("//section[@ng-controller='YourDetailsController as ctrl']"));
    }

    public WebElement usageSection() {
        return getPresenceOfElement(By.xpath("//section[@ng-controller='YourUsageController as ctrl']"));
    }

    public void meerkatImage(){
        getInvisibilityOfElement(By.xpath("//div[@class='progress-bar']"));
    }

    public boolean postCode(String postcode) {
        return getVisibilityOfElement(By.xpath("//p//b[@class='ng-binding']")).getText().contains(postcode);
    }

    public boolean electSupplier(String elect) {
        return getVisibilityOfElement(By.xpath("//p[@ng-if='ctrl.showElectricityInfo()']//b[@class='ng-binding']")).getText().contains(elect);
    }

    public boolean gasSupplier(String gas) {
        return getVisibilityOfElement(By.xpath("//p[@ng-if='ctrl.showGasInfo()']//b[@class='ng-binding']")).getText().contains(gas);
    }

    //recommendations btn
    public WebElement recommendationsBtn(){
        return getVisibilityOfElement(By.id("filters-recommendations-view"));
    }

    public WebElement moreTariffsBtn(){
        return getVisibilityOfElement(By.id("filters-more-tariffs-view"));
    }

    public WebElement paymentOption(String payment) {
        return getVisibilityOfElement(By.xpath("//label[@id='filters-payment-type-"+payment+"'][contains(@class,'checked')]"));
    }

    public WebElement tariffOption(String tariff) {
        return getVisibilityOfElement(By.xpath("//label[@id='filters-tariff-type-"+tariff+"'][contains(@class,'checked')]"));
    }

}