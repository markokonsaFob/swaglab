package impl.views.core

import io.cify.framework.core.Device
import io.cify.framework.core.DeviceCategory
import io.cify.framework.core.DeviceManager

/**
 * Created by markokonsa for Nordic Testing Day workshop
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
        String app = device.getCapabilities().getCapability("app")

        if (app) {
            app.startsWith("http://") || app.startsWith("https://") ?
                    device.openApp() :
                    device.openApp(new File(app).getAbsolutePath())
        } else {
            device.openApp()
        }
    }

    /**
     * Open browser on given URL
     * @param url
     */
    static void openBrowser(String url) {
        Device browserDevice = DeviceManager.getInstance().createDevice(DeviceCategory.BROWSER)
        browserDevice.openBrowser(url)
    }

}