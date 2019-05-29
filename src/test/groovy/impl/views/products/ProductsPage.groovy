package impl.views.products

import io.appium.java_client.MobileBy
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import io.cify.framework.PageObjects
import io.cify.framework.core.Device
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

/**
 * Created by Marko Konsa for Nordic Testing Day workshop
 * Mobile Test Automation Using Cify Open-Source Framework
 * https://nordictestingdays.eu/events/workshops/mobile-test-automation-using-cify-open-source-framework
 *
 * Products page objects for all platforms
 */
class ProductsPage extends PageObjects {

    @FindBy(className = "inventory_item")
    @AndroidFindBy(accessibility = "test-Item")
    @iOSXCUITFindBy(accessibility = "test-Item")
    List<WebElement> inventoryItems

    @FindBy(className = "shopping_cart_link")
    @AndroidFindBy(accessibility = "test-Cart")
    @iOSXCUITFindBy(accessibility = "test-Cart")
    WebElement cartButton

    // Test item inner elements
    By addToCartLocator = MobileBy.AccessibilityId("test-ADD TO CART")
    By priceLocator = MobileBy.AccessibilityId("test-Price")
    By titleLocator = MobileBy.AccessibilityId("test-Item title")

    Device device

    ProductsPage(Device device) {
        super(device)
        this.device = device
    }
}
