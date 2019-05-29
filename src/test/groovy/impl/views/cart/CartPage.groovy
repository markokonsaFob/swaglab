package impl.views.cart

import io.appium.java_client.MobileBy
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import io.cify.framework.PageObjects
import io.cify.framework.core.Device
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

/**
 * Created by Marko Konsa for Nordic Testing Day workshop
 * Mobile Test Automation Using Cify Open-Source Framework
 * https://nordictestingdays.eu/events/workshops/mobile-test-automation-using-cify-open-source-framework
 *
 * Cart Page Object
 */
class CartPage extends PageObjects {

    @AndroidFindBy(accessibility = "test-Item")
    @iOSXCUITFindBy(accessibility = "test-Item")
    List<WebElement> cartItems

    @AndroidFindBy(accessibility = "test-CONTINUE SHOPPING")
    @iOSXCUITFindBy(accessibility = "test-CONTINUE SHOPPING")
    WebElement continueShoppingButton

    @AndroidFindBy(accessibility = "test-CHECKOUT")
    @iOSXCUITFindBy(accessibility = "test-CHECKOUT")
    WebElement checkoutButton

    By androidTextViewLocator = MobileBy.className("android.widget.TextView")
    By iOSTextViewLocator = MobileBy.className("XCUIElementTypeStaticText")

    // Test item inner elements
    By testDescriptionLocator = MobileBy.AccessibilityId("test-Description")
    By testPriceLocator = MobileBy.AccessibilityId("test-Price")

    Device device

    CartPage(Device device) {
        super(device)
        this.device = device
    }

    /**
     * Gets Cart Item Title element for given item
     *
     * Android and IOS text view classes are different, thats why we need to have if else clause
     *
     * @param item
     * @return
     */
    WebElement getCartItemTitleElement(WebElement item) {
        WebElement description = item.findElement(testDescriptionLocator)

        if (device.getDriver() instanceof AndroidDriver) {
            description.findElement(androidTextViewLocator)
        } else {
            description.findElement(iOSTextViewLocator)
        }
    }

    /**
     * Gets Cart item price element for given item
     *
     * Android and IOS text view classes are different, thats why we need to have if else clause
     *
     * @param item
     * @return
     */
    WebElement getCartItemPriceElement(WebElement item) {
        WebElement description = item.findElement(testPriceLocator)

        if (device.getDriver() instanceof AndroidDriver) {
            description.findElement(androidTextViewLocator)
        } else {
            description.findElement(iOSTextViewLocator)
        }
    }
}
