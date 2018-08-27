package steps;

import pages.EnergyPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static org.junit.Assert.assertTrue;

/**
 * Created by ainer on 21/08/2018.
 */
public class UISteps extends ScenarioSteps {

    public UISteps(Pages pages) {
        super(pages);
    }

    /**
     * Page Objects
     */
    private EnergyPage OnEnergyPage() {
        return getPages().currentPageAt(EnergyPage.class);
    }

    ///////////////////////////////////////////////////////////////
    //              SUPPLIER PAGE STEPS                          //
    ///////////////////////////////////////////////////////////////
    //check that the header is displayed
    @Step
    public void supplierHeaderIsDisplayed(){
        assertTrue(OnEnergyPage().getSupplierPage().header().isDisplayed());
    }

    //check the postcode field is displayed
    //clicks the field and enters text
    //click the find postcode button
    @Step
    public void enterPostCode(String postCode) {
        assertTrue(OnEnergyPage().getSupplierPage().postCodeField().isDisplayed());
        OnEnergyPage().getSupplierPage().postCodeField().click();
        OnEnergyPage().getSupplierPage().postCodeField().sendKeys(postCode);
        OnEnergyPage().getSupplierPage().findPostcodeBtn().click();
    }

    //check if the same supplier question is displayed
    @Step
    public void sameSupplierQuestionIsDisplayed() {
        assertTrue(OnEnergyPage().getSupplierPage().sameSupplierQuestion().isDisplayed());
    }

    //check if bill availble question is displayed
    //select yes have bill
    @Step
    public void selectYesHaveBillAvailable() {
        assertTrue(OnEnergyPage().getSupplierPage().isBillAvailableQuestion().isDisplayed());
        OnEnergyPage().getSupplierPage().haveBillBtn().click();
    }

    //check if bill availble question is displayed
    //select no don't have bill
    @Step
    public void selectNoBillIsNotAvailable() {
        assertTrue(OnEnergyPage().getSupplierPage().isBillAvailableQuestion().isDisplayed());
        OnEnergyPage().getSupplierPage().dontHaveBillBtn().click();
    }

    //check what the user wants to compare question is displayed
    //select compare both button
    @Step
    public void selectCompareBoth() {
        assertTrue(OnEnergyPage().getSupplierPage().whatToCompareQuestion().isDisplayed());
        OnEnergyPage().getSupplierPage().compareBothBtn().click();
    }

    //check what the user wants to compare question is displayed
    //select compare electricity button
    @Step
    public void selectCompareElectricity() {
        assertTrue(OnEnergyPage().getSupplierPage().whatToCompareQuestion().isDisplayed());
        OnEnergyPage().getSupplierPage().compareElectricityBtn().click();
    }

    //check what the user wants to compare question is displayed
    //select compare gas button
    @Step
    public void selectCompareGas() {
        assertTrue(OnEnergyPage().getSupplierPage().whatToCompareQuestion().isDisplayed());
        OnEnergyPage().getSupplierPage().compareGasBtn().click();
    }

    //select yes when have same supplier for gas and electricity
    @Step
    public void selectSameSupplierYes() {
        OnEnergyPage().getSupplierPage().sameSupplierYesBtn().click();
    }

    //select no when don't have same supplier for gas and electricity
    @Step
    public void selectSameSupplierNo() {
        OnEnergyPage().getSupplierPage().sameSupplierNoBtn().click();
    }

    //check if using same supplier for gas and electricity question is displayed
    @Step
    public void dualSupplierQuestionIsDisplayed() {
        assertTrue(OnEnergyPage().getSupplierPage().dualEnergyQuestion().isDisplayed());
    }

    //check if who is your electricity supplier is displayed
    @Step
    public void elecSupplierQuestionIsDisplayed() {
        assertTrue(OnEnergyPage().getSupplierPage().elecEnergyQuestion().isDisplayed());
    }

    //check if who is your gas supplier is displayed
    @Step
    public void gasSupplierQuestionIsDisplayed() {
        assertTrue(OnEnergyPage().getSupplierPage().gasEnergyQuestion().isDisplayed());
    }

    //select supplier name
    //parameters are gas/electircity and supplier name
    @Step
    public void selectSupplierName(String energyType, String supplier) {
        OnEnergyPage().getSupplierPage().selectSupplier(energyType, supplier).click();
    }

    //click next button
    @Step
    public void clickNext() {
        assertTrue(OnEnergyPage().getSupplierPage().nextBtn().isDisplayed());
        OnEnergyPage().getSupplierPage().nextBtn().click();
    }

    //check change postcode button is displayed
    @Step
    public void changePostcodeIsDisplayed() {
        assertTrue(OnEnergyPage().getSupplierPage().changePostcodeBtn().isDisplayed());
    }

    //select don't know supplier button
    @Step
    public void selectDontKnowSupplier(String energy){
        OnEnergyPage().getSupplierPage().dontKnowBtn(energy).click();
    }

    ///////////////////////////////////////////////////////////////
    //              ELECTRICITY PAGE STEPS                       //
    ///////////////////////////////////////////////////////////////

    //check heading is displayed
    @Step
    public void electricityHeadingIsDisplayed() {
        assertTrue(OnEnergyPage().getElectricityPage().header().isDisplayed());
    }

    //click on the tariff dropdown and select an option
    @Step
    public void selectElecTariffOption(String option) {
        OnEnergyPage().getElectricityPage().tariffDropdown().click();
        OnEnergyPage().getElectricityPage().tariffOption(option).click();
    }

    //check if economy 7 meter question is displayed
    //select yes - day and night kwh questions now appear
    @Step
    public void yesHaveElecMeter(){
        assertTrue(OnEnergyPage().getElectricityPage().economyMeterQuestion().isDisplayed());
        OnEnergyPage().getElectricityPage().economyAnswerYes().click();
        assertTrue(OnEnergyPage().getElectricityPage().dayKWHQuestion().isDisplayed());
        assertTrue(OnEnergyPage().getElectricityPage().nightKWHQuestion().isDisplayed());
    }

    //check if economy 7 meter question is displayed
    //select no
    @Step
    public void noDontHaveElecMeter(){
        assertTrue(OnEnergyPage().getElectricityPage().economyMeterQuestion().isDisplayed());
        OnEnergyPage().getElectricityPage().economyAnswerNo().click();
    }

    //click on payment option dropdown and select option
    @Step
    public void selectElecPaymentOption(String payment){
        OnEnergyPage().getElectricityPage().paymentDropdown().click();
        OnEnergyPage().getElectricityPage().paymentOption(payment).click();
    }

    //check if main source of heating question is displayed
    //click on yes or no
    //string option is yes or no
    @Step
    public void answerElecMainHeatingQuestion(String answer){
        assertTrue(OnEnergyPage().getElectricityPage().heatingQuestion().isDisplayed());
        OnEnergyPage().getElectricityPage().mainHeatingBtn(answer).click();
    }

    //string option is kwh or pound
    @Step
    public void usageOptionElec(String answer){
        assertTrue(OnEnergyPage().getElectricityPage().usageQuestion().isDisplayed());
        OnEnergyPage().getElectricityPage().usageAnswerBtn(answer).click();
    }

    //checks that the elements are not visible
    @Step
    public void elecKwhQuestionsRemovedWhenPoundSelected(){
        OnEnergyPage().getElectricityPage().dayKwhQuestion();
        OnEnergyPage().getElectricityPage().nightKwhQuestion();
    }

    //user to enter the amount they spend and the bill option (monthly, annually)
    @Step
    public void spendAmountElec(String value, String option){
        OnEnergyPage().getElectricityPage().spendAmountField().click();
        OnEnergyPage().getElectricityPage().spendAmountField().sendKeys(value);
        OnEnergyPage().getElectricityPage().billPeriodDropdown().click();
        OnEnergyPage().getElectricityPage().billPeriodType(option).click();

    }

    //user to enter the amount they spend only, using spendAmountElecField as id is different to spendAmountField
    @Step
    public void spendAmountElecOnly(String value){
        OnEnergyPage().getElectricityPage().spendAmountElecField().click();
        OnEnergyPage().getElectricityPage().spendAmountElecField().sendKeys(value);
    }

    //check bill date is removed when annually is selected
    @Step
    public void elecBillDateIsRemovedWhenAnnuallySelected(){
        OnEnergyPage().getElectricityPage().billDateRemoved();
    }

    //check if prepay question is displayed and select an answer
    @Step
    public void answerElecPrepaymentQuestion(String answer){
        OnEnergyPage().getElectricityPage().prepayMeterQuestion().isDisplayed();
        OnEnergyPage().getElectricityPage().prepayAnswerBtn(answer).click();
    }

    //select don't know how much you spend button
    @Step
    public void selectElecDontKnowSpend(){
        OnEnergyPage().getElectricityPage().dontKnowSpendBtn().click();
    }

    //select next button
    @Step
    public void clickNextBtnOnElecPage(){
        OnEnergyPage().getElectricityPage().nextBtn().click();
    }
    ///////////////////////////////////////////////////////////////
    //              PREFERENCES PAGE STEPS                       //
    ///////////////////////////////////////////////////////////////
    //check preferences header is displayed
    @Step
    public void preferenceHeaderIsDisplayed(){
        assertTrue(OnEnergyPage().getPreferencesPage().header().isDisplayed());
    }

    // type can be fixed, variable or both
    @Step
    public void selectTariffRatePreference(String type){
        assertTrue(OnEnergyPage().getPreferencesPage().tariffTypeQuestion().isDisplayed());
        OnEnergyPage().getPreferencesPage().tariffTypeBtn(type).click();
    }

    //type can be monthly, quarterly, onbill or all
    @Step
    public void selectPaymentTypePreference(String type){
        assertTrue(OnEnergyPage().getPreferencesPage().paymentTypeQuestion().isDisplayed());
        OnEnergyPage().getPreferencesPage().paymentOptionsBtn(type).click();
    }

    //type email address
    @Step
    public void enterEmailAddress(String email){
        OnEnergyPage().getPreferencesPage().emailField().click();
        OnEnergyPage().getPreferencesPage().emailField().sendKeys(email);
    }

    //select terms btn
    @Step
    public void acceptTerms(){
        OnEnergyPage().getPreferencesPage().termsBtn().click();
    }

    //selet next on preferences page
    @Step
    public void selectNextOnPreferencesPage(){
        OnEnergyPage().getPreferencesPage().nextBtn().click();
    }
    ///////////////////////////////////////////////////////////////
    //                   GAS PAGE STEPS                          //
    ///////////////////////////////////////////////////////////////
    //check header is displayed
    @Step
    public void gasHeaderIsDisplayed(){
        assertTrue(OnEnergyPage().getGasPage().header().isDisplayed());
    }

    //click the tariff dropdown and select option
    @Step
    public void selectGasTariffRate(String rate){
        OnEnergyPage().getGasPage().tariffDropdown().click();
        OnEnergyPage().getGasPage().tariffOption(rate).click();
    }

    //check that the tariff question is displayed
    @Step
    public void assertTariffQuestionIsDisplayed(){
        assertTrue(OnEnergyPage().getGasPage().tariffQuestion().isDisplayed());
    }

    //check that the payment question is displayed
    @Step
    public void assertPaymentQuestionIsDisplayed(){
        assertTrue(OnEnergyPage().getGasPage().paymentQuestion().isDisplayed());
    }

    //select how payment is made
    @Step
    public void selectGasPaymentOption(String payment){
        OnEnergyPage().getGasPage().paymentDropdown().click();
        OnEnergyPage().getGasPage().paymentOption(payment).click();
    }

    //string option is kwh or pound
    @Step
    public void usageOptionGas(String answer){
        assertTrue(OnEnergyPage().getGasPage().usageQuestion().isDisplayed());
        OnEnergyPage().getGasPage().usageAnswerBtn(answer).click();
    }

    //string option is yes or no
    @Step
    public void answerGasMainHeatingQuestion(String answer){
        assertTrue(OnEnergyPage().getGasPage().heatingQuestion().isDisplayed());
        OnEnergyPage().getGasPage().mainHeatingBtn(answer).click();
    }

    //enter the amount of gs used
    @Step
    public void usageAmountGas(String value){
        OnEnergyPage().getGasPage().usageAmountField().click();
        OnEnergyPage().getGasPage().usageAmountField().sendKeys(value);
    }

    ///////////////////////////////////////////////////////////////
    //                   ENERGY USAGE PAGE STEPS                 //
    ///////////////////////////////////////////////////////////////
    //check header is displayed
    @Step
    public void usagePageHeaderIsDisplayed(){
        assertTrue(OnEnergyPage().getUsagePage().header().isDisplayed());
    }

    //select number of bedrooms
    @Step
    public void selectNoOfBedrooms(String bedrooms){
        OnEnergyPage().getUsagePage().bedroomOptionBtn(bedrooms).click();
    }

    //select number of occupants
    @Step
    public void selectNoOfOccupants(String occupants){
        OnEnergyPage().getUsagePage().occupantsOptionBtn(occupants).click();
    }

    //select heating source
    @Step
    public void selectHeatingSource(String heating){
        OnEnergyPage().getUsagePage().heatingSourceBtn(heating).click();
    }

    //select temperature
    //arctic, temperate, tropical
    @Step
    public void selectTemperatureOption(String heating){
        OnEnergyPage().getUsagePage().tempOptionBtn(heating).click();
    }

    // select insulation
    //wafer-thin, well-wrapped, airtight
    @Step
    public void selectInsulationOption(String insulation){
        OnEnergyPage().getUsagePage().insulationOptionBtn(insulation).click();
    }

    // select cooking
    //gas, electricity, other
    @Step
    public void selectCookingOption(String cooking){
        OnEnergyPage().getUsagePage().cookingOptionBtn(cooking).click();
    }

    //hardly ever, evenings and weekends, most of the time
    @Step
    public void selectHowOftenSomeoneIsHome(String option){
        OnEnergyPage().getUsagePage().oftenHomeOptionBtn(option).click();
    }

    //click Next button
    @Step
    public void selectNextBtnOnUsagePage(){
        OnEnergyPage().getUsagePage().nextBtn().click();
    }

    ///////////////////////////////////////////////////////////////
    //                  RESULTS PAGE STEPS                       //
    ///////////////////////////////////////////////////////////////

    //check results header is displayed
    @Step
    public void resultsHeaderIsDisplayed()
    {
        assertTrue(OnEnergyPage().getResultsPage().header().isDisplayed());
    }

    //check results details are displayed
    @Step
    public void resultsDetailsIsDisplayed(){
        assertTrue(OnEnergyPage().getResultsPage().detailsSection().isDisplayed());
    }

    //check results usage are displayed
    @Step
    public void resultsUsageIsDisplayed(){
        assertTrue(OnEnergyPage().getResultsPage().usageSection().isDisplayed());
    }

    //wait for the meerkats image to be removed
    @Step
    public void waitForSearchingIconToBeRemoved(){
        OnEnergyPage().getResultsPage().meerkatImage();
    }

    //checks that the postcode entered as supplier page is same that is displayed at results page
    @Step
    public void assertCorrectPostcodeIsDisplayed(String postcode){
        assertTrue(OnEnergyPage().getResultsPage().postCode(postcode));
    }

    //checks that the electricity entered as supplier page is same that is displayed at results page
    @Step
    public void assertCorrectElectSupplierIsDisplayed(String elect){
        assertTrue(OnEnergyPage().getResultsPage().electSupplier(elect));
    }

    //checks that the gas entered as supplier page is same that is displayed at results page
    @Step
    public void assertCorrectGasSupplierIsDisplayed(String gas){
        assertTrue(OnEnergyPage().getResultsPage().gasSupplier(gas));
    }

    //check recommendations btn is displayed
    @Step
    public void recommendationBtnIsDisplayed(){
        assertTrue(OnEnergyPage().getResultsPage().recommendationsBtn().isDisplayed());
    }

    //check more tariffs btn is displayed
    @Step
    public void moreTariffsBtnIsDisplayed(){
        assertTrue(OnEnergyPage().getResultsPage().moreTariffsBtn().isDisplayed());
    }

    //check that the correct payement option is selected
    @Step
    public void checkPaymentOption(String payment){
        assertTrue(OnEnergyPage().getResultsPage().paymentOption(payment).isDisplayed());
    }

    //check that the correct tariff option is selected
    @Step
    public void checkTariffOption(String tariff){
        assertTrue(OnEnergyPage().getResultsPage().tariffOption(tariff).isDisplayed());
    }

}

