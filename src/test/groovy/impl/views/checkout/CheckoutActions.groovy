package impl.views.checkout

import impl.helpers.ActionsWrapper
import io.cify.framework.actions.ActionsDesktopWeb
import io.cify.framework.actions.ActionsMobileAndroidApp
import io.cify.framework.actions.ActionsMobileIOSApp
import io.cify.framework.core.Device

/**
 * Created by Marko Konsa for Nordic Testing Day workshop
 * Mobile Test Automation Using Cify Open-Source Framework
 * https://nordictestingdays.eu/events/workshops/mobile-test-automation-using-cify-open-source-framework
 *
 * Checkout Actions for all platforms
 */
class CheckoutActions implements ActionsDesktopWeb, ActionsMobileIOSApp, ActionsMobileAndroidApp {

    Device device
    CheckoutPage checkoutPage

    CheckoutActions(Device device) {
        this.device = device
        this.checkoutPage = new CheckoutPage(device)
    }

    /**
     * Verify that Checkout information page is visible
     * @return
     */
    boolean isCheckoutInfoPageVisible() {
        isDisplayed(checkoutPage.getFirstNameField()) &&
                isDisplayed(checkoutPage.getLastnameField()) &&
                isDisplayed(checkoutPage.getPostalCodeField())
    }

    /**
     * Verify that Checkout overview page is visible
     * @return
     */
    boolean isCheckoutOverViewPageVisible() {
        try {
            ActionsWrapper.waitForCondition(device, {
                if (!isDisplayed(checkoutPage.getFinishButton())) {
                    ActionsWrapper.slowScrollDown(device)
                    return false
                }
                return true
            }, 30)
        } catch (ignored) {
            false
        }
    }

    /**
     * Enter firstname
     * @param firstname
     */
    void enterFirstName(String firstname) {
        checkoutPage.getFirstNameField().clear()
        sendKeys(checkoutPage.getFirstNameField(), firstname)
    }

    /**
     * Enter lastname
     * @param lastName
     */
    void enterLastName(String lastName) {
        checkoutPage.getLastnameField().clear()
        sendKeys(checkoutPage.getLastnameField(), lastName)
    }

    /**
     * Enter postal Code
     * @param postalCode
     */
    void enterPostalCode(String postalCode) {
        checkoutPage.getPostalCodeField().clear()
        sendKeys(checkoutPage.getPostalCodeField(), postalCode)
    }

    /**
     * Clicks continue button
     */
    void clickContinue() {
        if (!isDisplayed(checkoutPage.getContinueButton())) {
            ActionsWrapper.hideKeyboard(device)
        }
        click(checkoutPage.getContinueButton())
    }

    /**
     * Clicks finish button
     */
    void clickFinish() {
        if (!isDisplayed(checkoutPage.getFinishButton())) {
            ActionsWrapper.slowScrollDown(device)
        }
        click(checkoutPage.getFinishButton())
    }

    /**
     * Verifies that checkout complete page is visible
     * @return
     */
    boolean isCheckoutCompletePageVisible() {
        isDisplayed(checkoutPage.getCheckoutCompleteContainer())
    }

}