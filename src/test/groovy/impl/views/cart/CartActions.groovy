package impl.views.cart

import groovy.json.internal.LazyMap
import impl.helpers.ActionsWrapper
import impl.helpers.Constants
import impl.helpers.TestDataManager
import io.cify.framework.actions.ActionsDesktopWeb
import io.cify.framework.actions.ActionsMobileAndroidApp
import io.cify.framework.actions.ActionsMobileIOSApp
import io.cify.framework.core.Device
import org.openqa.selenium.WebElement

/**
 * Created by Marko Konsa for Nordic Testing Day workshop
 * Mobile Test Automation Using Cify Open-Source Framework
 * https://nordictestingdays.eu/events/workshops/mobile-test-automation-using-cify-open-source-framework
 *
 * Cart Actions for all platforms
 */
class CartActions implements ActionsDesktopWeb, ActionsMobileIOSApp, ActionsMobileAndroidApp {

    Device device
    CartPage cartPage

    CartActions(Device device) {
        this.device = device
        this.cartPage = new CartPage(device)
    }

    /**
     * Verify that Cart page is visible
     * @return
     */
    boolean isCartPageVisible() {
        isDisplayed(cartPage.getContinueShoppingButton())
    }

    /**
     * Verifies cart content from TestDataManager
     * @return
     */
    boolean isCartFilledWithCorrectData() {

        // Gets Cart Data from TestDataManager
        LazyMap cartData = TestDataManager.getValue(Constants.CART_DATA) as LazyMap
        String title = cartData.get("title")
        String price = cartData.get("price")

        List<WebElement> cartItems = cartPage.getCartItems()
        WebElement cartItem = cartItems.first()

        boolean isSizeCorrect = cartItems.size() == 1
        boolean isTitleDisplayed = cartPage.getCartItemTitleElement(cartItem).getText() == title
        boolean isPriceDisplayed = cartPage.getCartItemPriceElement(cartItem).getText() == price

        return isSizeCorrect && isTitleDisplayed && isPriceDisplayed
    }

    /**
     * Clicks checkout button
     */
    void clickCheckout() {
        ActionsWrapper.waitForCondition(device, {
            if (!isDisplayed(cartPage.getCheckoutButton())) {
                ActionsWrapper.slowScrollDown(device)
                return false
            }
            return true
        }, 30)

        click(cartPage.getCheckoutButton())
    }

}
