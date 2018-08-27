package acceptanceTests;

import net.thucydides.core.annotations.Title;
import org.junit.Test;

/**
 * Created by ainer on 21/08/2018.
 */
public class compareTheMarketTest extends AbstractTest {
protected String postcode="PE2 6YS";
protected String email = "test@domain.com";

    @Test
    @Title("User gets quote for dual fuel, user knows their suppliers, knows how much they spend and want a variable month quote")
    public void getQuoteForDualEnergyOption() {
        String paymentPreferences = "monthly";
        String tariffPreferences = "variable";
        //supplier and energy options
        endUser.enterPostCode(postcode);
        endUser.changePostcodeIsDisplayed();
        endUser.sameSupplierQuestionIsDisplayed();
        endUser.selectYesHaveBillAvailable();
        endUser.selectCompareBoth();
        endUser.selectSameSupplierNo();
        endUser.elecSupplierQuestionIsDisplayed();
        endUser.selectSupplierName("Electricity", "british-gas");
        endUser.gasSupplierQuestionIsDisplayed();
        endUser.selectSupplierName("Gas", "eon");
        endUser.clickNext();
        //electricity options
        endUser.electricityHeadingIsDisplayed();
        endUser.electricityHeadingIsDisplayed();
        endUser.selectElecTariffOption("Fixed Price March 2018");
        endUser.yesHaveElecMeter();
        endUser.selectElecPaymentOption("Pay On Receipt Of Bill");
        endUser.answerElecMainHeatingQuestion("yes");
        endUser.usageOptionElec("pound");
        endUser.elecKwhQuestionsRemovedWhenPoundSelected();
        endUser.spendAmountElec("200", "Annually");
        endUser.elecBillDateIsRemovedWhenAnnuallySelected();
        endUser.clickNextBtnOnElecPage();

        //gas page
        endUser.gasHeaderIsDisplayed();
        endUser.answerGasMainHeatingQuestion("yes");
        endUser.usageOptionGas("kwh");
        endUser.usageAmountGas("200");
        endUser.selectNextBtnOnUsagePage();

        // Preferences Page
        endUser.preferenceHeaderIsDisplayed();
        endUser.selectTariffRatePreference(tariffPreferences);
        endUser.selectPaymentTypePreference(paymentPreferences);
        endUser.enterEmailAddress(email);
        endUser.acceptTerms();
        endUser.selectNextOnPreferencesPage();

        //results page
        endUser.waitForSearchingIconToBeRemoved();
        endUser.resultsHeaderIsDisplayed();
        endUser.resultsDetailsIsDisplayed();
        endUser.resultsUsageIsDisplayed();

        endUser.assertCorrectPostcodeIsDisplayed(postcode);
        endUser.assertCorrectElectSupplierIsDisplayed("British Gas");
        endUser.assertCorrectGasSupplierIsDisplayed("E.ON");
        endUser.recommendationBtnIsDisplayed();
        endUser.moreTariffsBtnIsDisplayed();
        endUser.checkPaymentOption(paymentPreferences);
        endUser.checkTariffOption(tariffPreferences);
    }

    @Test
    @Title("Get quote for electricity, when user does not have a bill, does not know who their supplier is, and does not know how much they spend")
    public void getQuoteForElectricityNotKnowingSpend() {
        String paymentPreferences = "monthly";
        String tariffPreferences = "variable";
        //supplier and energy options
        endUser.enterPostCode(postcode);
        endUser.changePostcodeIsDisplayed();
        endUser.sameSupplierQuestionIsDisplayed();
        endUser.selectNoBillIsNotAvailable();
        endUser.selectCompareElectricity();
        endUser.elecSupplierQuestionIsDisplayed();
        endUser.selectDontKnowSupplier("electricity");
        endUser.clickNext();

        //electricity options
        endUser.electricityHeadingIsDisplayed();
        endUser.answerElecPrepaymentQuestion("no");
        endUser.noDontHaveElecMeter();
        endUser.selectElecDontKnowSpend();
        endUser.clickNextBtnOnElecPage();

        //usage page
        endUser.usagePageHeaderIsDisplayed();
        endUser.selectNoOfBedrooms("one-two");
        endUser.selectNoOfOccupants("one-two");
        endUser.selectHeatingSource("gas");
        endUser.selectTemperatureOption("arctic");
        endUser.selectInsulationOption("wafer-thin");
        endUser.selectCookingOption("gas");
        endUser.selectHowOftenSomeoneIsHome("hardly-ever");
        endUser.selectNextBtnOnUsagePage();

        // Preferences Page
        endUser.preferenceHeaderIsDisplayed();
        endUser.selectTariffRatePreference(tariffPreferences);
        endUser.selectPaymentTypePreference(paymentPreferences);
        endUser.enterEmailAddress(email);
        endUser.acceptTerms();
        endUser.selectNextOnPreferencesPage();

        //results page
        endUser.waitForSearchingIconToBeRemoved();
        endUser.resultsHeaderIsDisplayed();
        endUser.resultsDetailsIsDisplayed();
        endUser.resultsUsageIsDisplayed();
        endUser.assertCorrectPostcodeIsDisplayed(postcode);
        endUser.assertCorrectElectSupplierIsDisplayed("");
        endUser.recommendationBtnIsDisplayed();
        endUser.moreTariffsBtnIsDisplayed();
        endUser.checkPaymentOption(paymentPreferences);
        endUser.checkTariffOption(tariffPreferences);
    }

    @Test
    @Title("Get quote for electricity, when user does not have a bill, they are prepay and knows how much they spend")
    public void getQuoteForElectricityKnowingHowMuchSpent() {

        String tariffPreferences = "fixed";

        //supplier and energy options
        endUser.enterPostCode(postcode);
        endUser.changePostcodeIsDisplayed();
        endUser.sameSupplierQuestionIsDisplayed();
        endUser.selectNoBillIsNotAvailable();
        endUser.selectCompareElectricity();
        endUser.elecSupplierQuestionIsDisplayed();
        endUser.selectDontKnowSupplier("electricity");
        endUser.clickNext();

        //electricity options
        endUser.electricityHeadingIsDisplayed();
        endUser.answerElecPrepaymentQuestion("yes");
        endUser.noDontHaveElecMeter();
        endUser.spendAmountElecOnly("70");
        endUser.clickNextBtnOnElecPage();

        //your preferences page
        endUser.preferenceHeaderIsDisplayed();
        endUser.selectTariffRatePreference(tariffPreferences);
        endUser.enterEmailAddress(email);
        endUser.acceptTerms();
        endUser.selectNextOnPreferencesPage();

        //results page
        endUser.waitForSearchingIconToBeRemoved();
        endUser.resultsHeaderIsDisplayed();
        endUser.resultsDetailsIsDisplayed();
        endUser.resultsUsageIsDisplayed();
        endUser.assertCorrectPostcodeIsDisplayed(postcode);
        endUser.assertCorrectElectSupplierIsDisplayed("");
        endUser.recommendationBtnIsDisplayed();
        endUser.moreTariffsBtnIsDisplayed();
        endUser.checkTariffOption(tariffPreferences);
    }

}

