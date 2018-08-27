package pages.pageComposites.helpers;

/**
 * Created by ainer on 22/08/2018.
 */
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractElementHelper {
    /**
     * Local webDriver instance.
     */
    protected final WebDriver driver;

    /**
     * Utility library.
     */
    protected final WebElementUtilityMethods webElementUtilityMethods;

    protected static final int MAX_TRIES = 3;
    protected static final int QUANTITY_OF_TRIES = 5;
    protected static final int WAIT_TIME = 20;
    protected static final int DOUBLE_WAIT_TIME = 40;
    protected static final long DEFAULT_WAIT_TIME = 1000;

    /**
     * Constructor for the Abstract element helper.
     *
     * @param newDriver the incoming WebDriver object to use
     */
    public AbstractElementHelper(WebDriver newDriver)
    {
        driver = newDriver;
        webElementUtilityMethods = new WebElementUtilityMethods(driver);
    }

    /**
     * Wait for an element to be displayed and returns it.
     *
     * @param bySelector * locator *
     * @return WebElement
     */
    public WebElement getVisibilityOfElement(By bySelector)
    {
        WebElement element;
        try
        {
            element = webElementUtilityMethods.waitForDisplay(bySelector);
        }
        catch(StaleElementReferenceException e)
        {
            // re-fetch the element
            element = webElementUtilityMethods.waitForDisplay(bySelector);
        }
        return element;
    }

    /**
     *
     * @param bySelector
     * @return
     */
    public WebElement getPresenceOfElement(By bySelector)
    {
        WebElement element;
        try
        {
            element = webElementUtilityMethods.waitForPresence(bySelector);
        }
        catch(StaleElementReferenceException e)
        {
            // re-fetch the element
            element = webElementUtilityMethods.waitForPresence(bySelector);
        }
        return element;
    }

    public void getInvisibilityOfElement(By bySelector)
    {
        try
        {
            webElementUtilityMethods.waitForInvisibility(bySelector);
        }
        catch(StaleElementReferenceException e)
        {
            // re-fetch the element
            webElementUtilityMethods.waitForInvisibility(bySelector);
        }
    }


    /**
     * Wait for an element to be displayed and returns it.
     *
     * @param bySelector * locator *
     * @return boolean
     */
    public boolean isDisplayed(By bySelector)
    {
        return driver.findElement(bySelector).isDisplayed();
    }

    /**
     * Wait for an element to be diplayed and returns it.
     *
     * @param bySelector * locator *
     * @return List < WebElement >
     */
    public List<WebElement> getElements(By bySelector)
    {
        webElementUtilityMethods.waitForDisplay(bySelector);
        return driver.findElements(bySelector);
    }

    /**
     *
     * @param element
     * @return WebElement
     */
    public WebElement scrollElementIntoView(WebElement element)
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return  element;
    }

    /**
     * Wait for an element to be displayed and returns it and wait for Ajax element not to be
     * displayed.
     *
     * @param bySelector * locator *
     * @return WebElement
     */
    public WebElement getElementAndWaitAjax(By bySelector)
    {
        webElementUtilityMethods.waitForDisplay(bySelector);
        waitAjaxElement();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(bySelector));
        return driver.findElement(bySelector);
    }

    /**
     * Method responsible to fill a WebElement (using the locator By.id) with the value passed by
     * parameter.
     *
     * @param webElementLocatorID * webElementLocatorID *
     * @param stringToFill        * stringToFill *
     */
    public void fillTextElementByID(String webElementLocatorID, String stringToFill)
    {
        int i = 0;
        WebElement element = getElementAndWaitAjax(By.id(webElementLocatorID));
        while (!element.getAttribute("value").contains(stringToFill) && i < 5)
        {
            //Line added to move the focus to the field and to resolve the problem
            // that the field doesn't was filled (the problem occurred just in IE).
            element.click();
            element.clear();
            element.sendKeys(stringToFill);
            element.sendKeys(Keys.TAB); //To enable the `Save` button
            i++;
        }
        if (i > 5)
        {
            System.out.println("Selenium was unable to fill the text box.");
        }
    }

    /**
     * Method responsible to select a value in a WebElement (using the locator By.id) with
     * the value passed by parameter.
     *
     * @param webElementLocatorID * webElementLocatorID *
     * @param stringToSelect      * stringToSelect *
     */
    public void selectValueListByID(String webElementLocatorID, String stringToSelect)
    {
        WebElement element = getElementAndWaitAjax(By.id(webElementLocatorID));
        Select list = new Select(element);
        list.selectByVisibleText(stringToSelect);
    }

    /**
     * Method responsible to wait for Ajax element not to be displayed.
     */
    public void waitAjaxElement()
    {
        webElementUtilityMethods.waitForNotDisplayed(By.xpath("//iframe[@id='ajaxBlockerIframe']"));
    }

    /**
     * Method responsible to wait for Ajax element not to be displayed (if it is present).
     */
    public void waitForBlockerToDisappearIfPresent()
    {
        if (!driver.findElements(By.xpath("//*[@class='blocker']")).isEmpty())
        {
            webElementUtilityMethods.waitForNotDisplayed(By.xpath("//*[@class='blocker']"));
        }
    }

    public void waitForMessageToDisappearIfPresent()
    {
        if (!driver.findElements(By.xpath("//*[@aria-hidden='true']")).isEmpty())
        {
            webElementUtilityMethods.waitForNotDisplayed(By.xpath("//*[@aria-hidden='true']"));
        }
    }

    /**
     * Method used to click in an element.
     * @param element element
     */
    public void clickElement(WebElement element)
    {
        element.click();
    }

    /**
     * Method used to check if the alert is open or not (passing the waitTime by parameter).
     * @return boolean
     */
    public boolean isAlertOpen()
    {
        return isAlertOpen(2);
    }

    /**
     * Method used to check if the alert is open or not.
     * @param waitTime waitTime
     * @return boolean
     */
    public boolean isAlertOpen(int waitTime)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        }
        catch (WebDriverException e)
        {
            return false;
        }
    }

    /**
     * Method used to check if element exists.
     * @param locator locator
     * @return boolean
     */
    public boolean elementExists(By locator)
    {
        return !driver.findElements(locator).isEmpty();
    }
}