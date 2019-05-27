package impl

import impl.views.core.CoreActions
import io.cify.framework.core.DeviceCategory

/**
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


}