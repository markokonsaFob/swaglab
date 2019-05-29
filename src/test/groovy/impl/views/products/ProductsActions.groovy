package impl.views.products

import groovy.json.internal.LazyMap
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
 * Login Actions for all platforms
 */
class ProductsActions implements ActionsDesktopWeb, ActionsMobileIOSApp, ActionsMobileAndroidApp {

    Device device
    ProductsPage productsPage

    ProductsActions(Device device) {
        this.device = device
        this.productsPage = new ProductsPage(device)
    }

    /**
     * Gets product itinerary items
     * @return
     */
    boolean isProductItineraryEmpty() {
        productsPage.getInventoryItems().isEmpty()
    }
/**
 * Get all product elements
 * @return
 */
    List<WebElement> getProducts() {
        productsPage.getInventoryItems()
    }

    /**
     * Add given product to cart
     * @param product
     */
    void addProductToCart(WebElement product) {
        click(product.findElement(productsPage.getAddToCartLocator()))
        saveProductInfoToTestData(product)
    }

    /**
     * Clicks on cart icon on navigation bar
     */
    void clickOnCartIcon() {
        click(productsPage.getCartButton())
    }

    /**
     * Saves product information to test data
     * @param product
     * @return
     */
    private saveProductInfoToTestData(WebElement product) {

        // Get information about the given product
        String itemTitle = product.findElement(productsPage.getTitleLocator()).getText()
        String price = product.findElement(productsPage.getPriceLocator()).getText()

        // Save to TestDataManager
        LazyMap productData = [:]
        productData.put("title", itemTitle)
        productData.put("price", price)
        TestDataManager.setTestData(Constants.CART_DATA, productData)

    }
}
