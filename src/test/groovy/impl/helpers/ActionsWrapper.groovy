package impl.helpers

import io.cify.framework.core.Device
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait

/**
 * Created by Marko Konsa for Nordic Testing Day workshop
 * Mobile Test Automation Using Cify Open-Source Framework
 * https://nordictestingdays.eu/events/workshops/mobile-test-automation-using-cify-open-source-framework
 *
 * This class holds actions that can be used for test creation and are not implemented in the framework
 */
class ActionsWrapper {

    /**
     * Waits for condition
     * @param condition closure that returns true, false
     * @param timeOut in ms
     * @return True if condition is met
     */
    static boolean waitForCondition(Device device, Closure condition, long timeOut) {
        try {
            WebDriverWait w = new WebDriverWait(device.getDriver(), timeOut)
            w.until(new ExpectedCondition<Boolean>() {
                Boolean apply(WebDriver d) {
                    try {
                        return condition()
                    } catch (ignore) {
                        false
                    }
                }
            })
        } catch (all) {
            throw new CifyTestException("Waiting for condition failed! " + "CONDITION: " + condition + " cause " + all.message)
        }
    }
}
