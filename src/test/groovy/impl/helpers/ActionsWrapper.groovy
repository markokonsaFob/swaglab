package impl.helpers

import io.appium.java_client.AppiumDriver
import io.appium.java_client.TouchAction
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import io.cify.framework.core.Device
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait

import java.time.Duration

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

    /**
     * Slowly scroll down on screen
     * @param device
     */
    static void slowScrollDown(Device device) {
        TouchAction action = new TouchAction(device.getDriver() as AppiumDriver)
        Dimension dimension = device.getDriver().manage().window().getSize()
        action.press(
                PointOption.point(
                        (dimension.getWidth() / 4).toInteger(),
                        (dimension.getHeight() * 0.75).toInteger()
                )
        ).waitAction(
                WaitOptions.waitOptions(
                        Duration.ofMillis(2000)
                )
        ).moveTo(
                PointOption.point(
                        (dimension.getWidth() / 4).toInteger(),
                        (dimension.getHeight() * 0.25).toInteger()
                )
        ).release().perform()
    }

    /**
     * Hides mobile keyboard
     * @param device
     */
    static void hideKeyboard(Device device) {
        try {
            (device.getDriver() as AppiumDriver).hideKeyboard()
        } catch (ignored) {

        }
    }
}
