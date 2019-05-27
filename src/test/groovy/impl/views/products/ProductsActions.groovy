package impl.views.products

import io.cify.framework.actions.ActionsDesktopWeb
import io.cify.framework.actions.ActionsMobileAndroidApp
import io.cify.framework.actions.ActionsMobileIOSApp
import io.cify.framework.core.Device

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

}
