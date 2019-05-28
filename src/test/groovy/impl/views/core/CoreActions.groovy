package impl.views.core

import impl.helpers.TestDataManager
import io.cify.framework.core.Device
import io.cify.framework.core.DeviceCategory
import io.cify.framework.core.DeviceManager

/**
 * Created by Marko Konsa for Nordic Testing Day workshop
 * Mobile Test Automation Using Cify Open-Source Framework
 * https://nordictestingdays.eu/events/workshops/mobile-test-automation-using-cify-open-source-framework
 *
 * Core Actions for all platforms
 */
class CoreActions {

    DeviceCategory category
    Device device

    CoreActions(DeviceCategory category) {
        this.category = category
        this.device = DeviceManager.getInstance().createDevice(category)
    }

    /**
     * Open application on given device
     * @param device
     */
    void openApplication() {

        if (category == DeviceCategory.BROWSER) {
            device.openBrowser(TestDataManager.getEnvironmentData("browserUrl"))
        } else {
            String appPath = device.getCapabilities().getCapability("app")
            if (appPath && appPath.startsWith("http")) {
                device.openApp()
            } else {
                device.openApp(new File(appPath).getAbsolutePath())
            }
        }
    }

}