package impl

import impl.views.cart.CartActions
import impl.views.checkout.CheckoutActions
import impl.views.core.CoreActions
import impl.views.login.LoginActions
import impl.views.products.ProductsActions
import io.cify.framework.core.Device
import io.cify.framework.core.DeviceCategory
import io.cify.framework.core.DeviceManager

/**
 * Created by Marko Konsa for Nordic Testing Day workshop
 * Mobile Test Automation Using Cify Open-Source Framework
 * https://nordictestingdays.eu/events/workshops/mobile-test-automation-using-cify-open-source-framework
 *
 * This class is responsible for actions implementations management
 *
 * Gets right actions for current device
 */
class ActionsImpl {

    /**
     * Get Core actions for given device category
     *
     * Initializes device inside
     * @param category
     * @return
     */
    static CoreActions getCoreActions(DeviceCategory category) {
        return new CoreActions(category)
    }

    /**
     * Gets login actions for active device
     * @return
     */
    static LoginActions getLoginActions() {
        Device device = DeviceManager.getInstance().getActiveDevice()
        return new LoginActions(device)
    }

    /**
     * Gets login actions for active device
     * @return
     */
    static ProductsActions getProductActions() {
        Device device = DeviceManager.getInstance().getActiveDevice()
        return new ProductsActions(device)
    }

    /**
     * Gets Cart actions for active device
     * @return
     */
    static CartActions getCartActions() {
        Device device = DeviceManager.getInstance().getActiveDevice()
        return new CartActions(device)
    }

    /**
     * Gets Checkout actions for active device
     * @return
     */
    static CheckoutActions getCheckoutActions() {
        Device device = DeviceManager.getInstance().getActiveDevice()
        return new CheckoutActions(device)
    }


}