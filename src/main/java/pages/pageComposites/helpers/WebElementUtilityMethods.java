package pages.pageComposites.helpers;

/**
 * Created by ainer on 22/08/2018.
 */
import net.thucydides.core.webdriver.exceptions.ElementNotFoundAfterTimeoutError;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementUtilityMethods {

    private static final int DEFAULT_SLEEP_IN_MILLIS = 5000;
    private static final int DEFAULT_TIMEOUT = 30;

    WebDriver driver;

    /**
     * Standard PageObject constructor.
     *
     * @param newDriver the incoming WebDriver object to use
     */
    public WebElementUtilityMethods(WebDriver newDriver)
    {
        this.driver = newDriver;
    }

    /**
     * Wait for a given WebElement to be displayed using default timeoutInSeconds.
     *
     * @param webelement * The WebElement to wait for.
     * @return return
     */
    public WebElement waitForDisplay(final WebElement webelement)
    {
        return waitForDisplay(webelement, DEFAULT_TIMEOUT);
    }

    /**
     * Wait for a given WebElement to be displayed.
     *
     * @param webElement       * The WebElement to wait for *
     * @param timeoutInSeconds * timeout in seconds *
     * @return return
     */
    public WebElement waitForDisplay(final WebElement webElement, int timeoutInSeconds)
    {
        WebDriverWait myWait = new WebDriverWait(driver, timeoutInSeconds, DEFAULT_SLEEP_IN_MILLIS);
        return  myWait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Wait for a given WebElement opacity using default timeoutInSeconds.
     *
     * @param webElement * The WebElement to wait for *
     * @param opacity    * expected or target opacity *
     */
    public void waitForOpacity(final WebElement webElement, int opacity)
    {
        waitForOpacity(webElement, DEFAULT_TIMEOUT, opacity);
    }

    /**
     * Wait for a given WebElement opacity.
     *
     * @param by               * element locator *
     * @param timeoutInSeconds * timeout in seconds *
     * @param opacity          * expected or target opacity *
     */
    public void waitForOpacity(final By by, int timeoutInSeconds, final int opacity)
    {
        WebDriverWait myWait = new WebDriverWait(driver, timeoutInSeconds, DEFAULT_SLEEP_IN_MILLIS);
        ExpectedCondition<Boolean> conditionToCheck = new ExpectedCondition<Boolean>()
        {
            public Boolean apply(final WebDriver input)
            {
                return driver.findElement(by).getAttribute("style").
                        contains("opacity: " + Integer.toString(opacity));
            }
        };
        myWait.ignoring(StaleElementReferenceException.class).until(conditionToCheck);
    }

    /**
     * Wait for a given WebElement found using By location opacity using default timeoutInSeconds.
     *
     * @param by      * element locator *
     * @param opacity * expected or target opacity *
     */
    public void waitForOpacity(final By by, final int opacity)
    {
        waitForOpacity(by, DEFAULT_TIMEOUT, opacity);
    }

    /**
     * Wait for a given WebElement target opacity.
     *
     * @param webElement       * The WebElement to wait for. *
     * @param timeoutInSeconds * timeout in seconds *
     * @param opacity          * expected or target opacity *
     */
    public void waitForOpacity(final WebElement webElement, int timeoutInSeconds, final int opacity)
    {
        WebDriverWait myWait = new WebDriverWait(driver, timeoutInSeconds, DEFAULT_SLEEP_IN_MILLIS);
        ExpectedCondition<Boolean> conditionToCheck = new ExpectedCondition<Boolean>()
        {
            public Boolean apply(final WebDriver input)
            {
                return webElement.getAttribute("style").
                        contains("opacity: " + Integer.toString(opacity));
            }
        };
        myWait.ignoring(StaleElementReferenceException.class).until(conditionToCheck);
    }

    /**
     * Wait for element found using locations not to be displayed.
     *
     * @param by               * element locator *
     * @param timeoutInSeconds * timeout in seconds *
     */
    public void waitForNotDisplayed(final By by, int timeoutInSeconds)
    {
        System.out.println("Wait for not displayed of " + by);
        WebDriverWait myWait = new WebDriverWait(driver, timeoutInSeconds, DEFAULT_SLEEP_IN_MILLIS);
        ExpectedCondition<Boolean> conditionToCheck = new ExpectedCondition<Boolean>()
        {
            public Boolean apply(final WebDriver input)
            {
                try
                {
                    return !(driver.findElement(by).isDisplayed());
                }
                catch (ElementNotFoundAfterTimeoutError ex)
                {
                    return true;
                }
            }
        };
        myWait.ignoring(StaleElementReferenceException.class).until(conditionToCheck);
    }

    /**
     * Wait for element by locator to be displayed using default timeoutInSeconds.
     * waits for a specific WebElement to be displayed.
     *
     * @param by path to element.
     */
    public void waitForNotDisplayed(final By by)
    {
        waitForNotDisplayed(by, DEFAULT_TIMEOUT);
    }

    /**
     * Wait for element by locator to be displayed using default timeout.
     *
     * @param by * element locator *
     * @return return
     */
    public WebElement waitForDisplay(final By by)
    {
        return waitForDisplay(by, DEFAULT_TIMEOUT);
    }

    /**
     * Wait for element by locator to be displayed.
     *
     * @param by               * element locator *
     * @param timeoutInSeconds * timeout in seconds *
     * @return return
     */
    public WebElement waitForDisplay(final By by, int timeoutInSeconds)
    {
        System.out.println("Wait for display of " + by);
        return new WebDriverWait(driver, timeoutInSeconds, DEFAULT_SLEEP_IN_MILLIS)
                .ignoring(StaleElementReferenceException.class).
                        until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     *
     * @param by
     * @param timeoutInSeconds
     * @return
     */
    public WebElement waitForPresence(final By by, int timeoutInSeconds)
    {
        System.out.println("Wait for presence of " + by);
        return new WebDriverWait(driver, timeoutInSeconds, DEFAULT_SLEEP_IN_MILLIS)
                .ignoring(StaleElementReferenceException.class).
                        until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     *
     * @param by
     * @param timeoutInSeconds
     */
    public void waitForInvisibility(final By by, int timeoutInSeconds)
    {
        System.out.println("Wait for invisbility of " + by);
        new WebDriverWait(driver, timeoutInSeconds, DEFAULT_SLEEP_IN_MILLIS)
                .ignoring(StaleElementReferenceException.class).
                until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    /**
     * Waits for a page element to have a specific attribute.
     *
     * @param by            path to object.
     * @param attributeText attribute details
     * @param attribute     the attribute to find
     */
    public void waitForAttributeDisplay(final By by, final String attribute,
                                        final String attributeText)
    {
        waitForAttributeDisplay(by, attribute, attributeText, DEFAULT_TIMEOUT);
    }

    /**
     * Waits for an specific attribute of an element to be displayed.
     *
     * @param element       webElement
     * @param attribute     the attribute to find
     * @param attributeText attribute details
     */
    public void waitForAttributeDisplay(final WebElement element, final String attribute,
                                        final String attributeText) {
        waitForAttributeDisplay(element, attribute, attributeText, DEFAULT_TIMEOUT);
    }

    /**
     * Waits for a page element to have a specific attribute.
     *
     * @param by               path to object.
     * @param attributeText    attribute details
     * @param attribute        the attribute to find
     * @param timeoutInSeconds the time to wait in seconds.
     */
    public void waitForAttributeDisplay(final By by, final String attribute,
                                        final String attributeText, int timeoutInSeconds)
    {
        WebDriverWait myWait = new WebDriverWait(driver, timeoutInSeconds, DEFAULT_SLEEP_IN_MILLIS);

        ExpectedCondition<Boolean> conditionToCheck = new ExpectedCondition<Boolean>()
        {
            public Boolean apply(final WebDriver input)
            {
                return driver.findElement(by).getAttribute(attribute).contains(attributeText);
            }
        };
        myWait.ignoring(StaleElementReferenceException.class).until(conditionToCheck);
    }

    /**
     * Waits for a page element to have a specific attribute.
     *
     * @param element          Object to use.
     * @param attributeText    attribute details
     * @param attribute        the attribute to find
     * @param timeoutInSeconds the time to wait in seconds.
     */
    public void waitForAttributeDisplay(final WebElement element, final String attribute,
                                        final String attributeText, int timeoutInSeconds)
    {
        WebDriverWait myWait = new WebDriverWait(driver, timeoutInSeconds, DEFAULT_SLEEP_IN_MILLIS);

        ExpectedCondition<Boolean> conditionToCheck = new ExpectedCondition<Boolean>()
        {
            public Boolean apply(final WebDriver input)
            {
                return element.getAttribute(attribute).contains(attributeText);
            }
        };
        myWait.ignoring(StaleElementReferenceException.class).until(conditionToCheck);
    }

    /**
     *
     * @param by
     * @return
     */
    public WebElement waitForPresence(final By by)
    {
        return waitForPresence(by, DEFAULT_TIMEOUT);
    }

    /**
     *
     * @param by
     * @return
     */
    public void waitForInvisibility(final By by)
    {
        waitForInvisibility(by, DEFAULT_TIMEOUT);
    }

    /**
     * Wait for element text by locator to be displayed.
     *
     * @param by               * element locator *
     * @param timeoutInSeconds * timeout in seconds *
     */
    public void waitForText(final By by, int timeoutInSeconds)
    {
        WebDriverWait myWait = new WebDriverWait(driver, timeoutInSeconds, DEFAULT_SLEEP_IN_MILLIS);
        ExpectedCondition<Boolean> conditionToCheck = new ExpectedCondition<Boolean>()
        {
            public Boolean apply(final WebDriver input)
            {
                return !(driver.findElement(by).getText().equals(""));
            }
        };
        myWait.ignoring(StaleElementReferenceException.class).until(conditionToCheck);
    }

    /**
     * Click element when ready for clicking.
     *
     * @param by               * element locator *
     * @param timeoutInSeconds * timeout in seconds *
     */
    public void clickWhenReady(final By by, int timeoutInSeconds)
    {
        WebDriverWait myWait = new WebDriverWait(driver, timeoutInSeconds, DEFAULT_SLEEP_IN_MILLIS);
        ExpectedCondition<Boolean> conditionToCheck = new ExpectedCondition<Boolean>()
        {
            public Boolean apply(final WebDriver input)
            {
                try
                {
                    driver.findElement(by).click();
                    return true;
                }
                catch (ElementNotFoundAfterTimeoutError e)
                {
                    return false;
                }
            }
        };
        myWait.ignoring(StaleElementReferenceException.class).until(conditionToCheck);
    }

    /**
     * Click element when ready for clicking using default timeoutInSeconds.
     *
     * @param by * element locator *
     */
    public void clickWhenReady(final By by) {
        clickWhenReady(by, DEFAULT_TIMEOUT);
    }

    /**
     * Wait for element text passed by parameter to be displayed.
     *
     * @param by   * element locator *
     * @param text * text to be located*
     * @return return
     */
    public void waitForTextDisplay(final By by, final String text)
    {
        WebDriverWait myWait = new WebDriverWait(driver, DEFAULT_TIMEOUT, DEFAULT_SLEEP_IN_MILLIS);

        ExpectedCondition<Boolean> conditionToCheck = new ExpectedCondition<Boolean>()
        {
            public Boolean apply(final WebDriver input)
            {
                return driver.findElement(by).getText().equalsIgnoreCase(text);
            }
        };
        myWait.ignoring(StaleElementReferenceException.class).until(conditionToCheck);
    }

    /**
     * Waits for the element to be disabled.
     * @param webElement webElement.
     */
    public void waitForElementDisabled(final WebElement webElement)
    {
        // waits for the save to be registered before performing next action.
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT, DEFAULT_SLEEP_IN_MILLIS);
        ExpectedCondition<Boolean> conditionToCheck = new ExpectedCondition<Boolean>()
        {
            public Boolean apply(final WebDriver input)
            {
                return !webElement.isEnabled();
            }
        };
        wait.ignoring(StaleElementReferenceException.class).until(conditionToCheck);
    }

    /**
     * Waits for the element to be clickable.
     * @param webElement webElement.
     * @return return
     */
    public WebElement waitForElementToBeClickable(final WebElement webElement)
    {
        // waits for the save to be registered before performing next action.
        System.out.println("Wait for clickable " + webElement);
        return new WebDriverWait(driver,
                DEFAULT_TIMEOUT, DEFAULT_SLEEP_IN_MILLIS).ignoring(
                WebDriverException.class).ignoring(StaleElementReferenceException.class).
                until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Waits for the element to reattach to DOM
     * @return return
     */
    public void waitForElementToReattachToDOM(final By bySelector)
    {
        // waits for the save to be registered before performing next action.
        System.out.println("Wait for element to not be stale " + bySelector);
        new WebDriverWait(driver, DEFAULT_TIMEOUT, DEFAULT_SLEEP_IN_MILLIS).
                until(ExpectedConditions.not(ExpectedConditions.stalenessOf(waitForDisplay(bySelector))));
    }

    /**
     * Waits for a page element to have a specific attribute.
     *
     * @param element       path to element.
     * @param attribute     attribute
     * @param attributeText the attribute text to find
     */
    public void waitForAttributeDisplayUsingWebElement(final WebElement element,
                                                       final String attribute, final String attributeText)
    {
        WebDriverWait myWait = new WebDriverWait(driver, DEFAULT_TIMEOUT, DEFAULT_SLEEP_IN_MILLIS);

        ExpectedCondition<Boolean> conditionToCheck = new ExpectedCondition<Boolean>()
        {
            public Boolean apply(final WebDriver input)
            {
                return element.getAttribute(attribute).contains(attributeText);
            }
        };
        myWait.ignoring(StaleElementReferenceException.class).until(conditionToCheck);
    }

    /**
     * Wait for a frame to be available and switch to it.
     * @param frameName frame to switch
     */
    public void waitForFrameToBeReadyAndSwitchToIt(String frameName)
    {
        new WebDriverWait(driver, DEFAULT_TIMEOUT, DEFAULT_SLEEP_IN_MILLIS)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
    }

    /**
     * Wait for a page to be loaded.
     * @param driver driver
     */
    public void waitForPageToLoad(WebDriver driver)
    {
        ExpectedCondition < Boolean > pageLoad = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver)
                    {
                        return ((JavascriptExecutor) driver)
                                .executeScript("return document.readyState").equals("complete");
                    }
                };
        Wait< WebDriver > wait = new WebDriverWait(driver, 60, DEFAULT_SLEEP_IN_MILLIS);
        try
        {
            wait.until(pageLoad);
        }
        catch (TimeoutException pageLoadWaitError)
        {
            System.out.println("Timeout during page load:" + pageLoadWaitError.toString());
        }
    }

    /**
     * Return if the String passed by parameter is an Integer or not.
     * @param s parameter will be used in a comparison to check if is a Int or not.
     * @return a boolean value true or false (where true is a valid integer).
     */
    public static boolean isValidInt(String s)
    {
        for (int i = 0; i < s.length(); i++)
        {
            if (!Character.isDigit(s.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Waits for an alert be present.
     */
    public void waitForAlertDisplay()
    {
        new WebDriverWait(driver,
                DEFAULT_TIMEOUT, 5000).ignoring(StaleElementReferenceException.class).ignoring(
                WebDriverException.class).
                until(ExpectedConditions.alertIsPresent());
    }

}

