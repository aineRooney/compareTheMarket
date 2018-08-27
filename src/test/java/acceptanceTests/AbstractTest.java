package acceptanceTests;

/**
 * Created by ainer on 21/08/2018.
 */


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.UISteps;

import static org.junit.Assert.fail;

/**
 * Abstract base class for UI integration tests
 *
 * @author ainer
 */
@RunWith(SerenityRunner.class)
public abstract class AbstractTest {

    protected final static Log LOGGER = LogFactory.getLog(AbstractTest.class);


    /**
     * Managed WebDriver for browser control.
     * The browser type is controlled by the webdriver.driver system property.
     */
    @Managed
    public WebDriver webdriver;

    /**
     * Pages to use for navigation.
     */
    @ManagedPages
    public Pages pages;

    /**
     * End-user steps.
     */
    @Steps
    public UISteps endUser;


    //go to the url and check header is displayed
    @Before
    public void setUp() {
        webdriver.manage().window().maximize();
        webdriver.get("https://energy.comparethemarket.com/energy/v2/?AFFCLIE-TSTT");
        endUser.supplierHeaderIsDisplayed();
    }

    @After
    public void cleanUp() {
        webdriver.quit();
    }

}
