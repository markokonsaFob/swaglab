package impl.helpers

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileDriver
import io.appium.java_client.TouchAction
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import io.cify.framework.core.Device
import io.cify.framework.core.DeviceManager
import org.openqa.selenium.Dimension
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait

import java.time.Duration

class ActionsWrapper {

    private static final double screenSizeMultiplier05 = 0.5
    private static final double screenSizeMultiplier08 = 0.8
    private static final double screenSizeMultiplier02 = 0.2

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
     * Scrolls from element to element
     * @param device
     * @param from
     * @param to
     */
    static void scrollTo(Device device, WebElement from, WebElement to) {
        scrollTo(device, from, to, Duration.ofSeconds(1))
    }

    /**
     * Scrolls from element to element
     * @param device
     * @param from
     * @param to
     * @param duration
     */
    static void scrollTo(Device device, WebElement from, WebElement to, Duration duration) {
        scrollTo(device, from.getLocation().getX(), from.getLocation().getY(), to.getLocation().getX(), to.getLocation().getY(), duration)
    }

    /**
     * Scroll from locations
     * @param device
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @param duration
     */
    static void scrollTo(Device device, int fromX, int fromY, int toX, int toY, Duration duration) {
        TouchAction touchAction = new TouchAction(device.getDriver() as AppiumDriver)
        touchAction.press(PointOption.point(fromX, fromY)).
                waitAction(WaitOptions.waitOptions(duration)).
                moveTo(PointOption.point(toX, toY)).
                release().
                perform()
    }

    /**
     * Scroll given webview element to center
     * @param element
     */
    static void scrollToCenter(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) DeviceManager.getInstance().getActiveDevice().getDriver()
        int height = jse.executeScript("return window.innerHeight") as int
        def elementY = jse.executeScript("return arguments[0].getBoundingClientRect().top;", element)
        int center = elementY - height + height / 2
        jse.executeScript("window.scrollBy(0," + center + ")", "")
    }

    /**
     * Scrolls down in list view
     * @param device
     */
    static void scrollDown(Device device) {
        TouchAction action = new TouchAction(device.getDriver() as MobileDriver)
        Dimension dimension = device.getDriver().manage().window().getSize()
        int scrollWidth = (int) (dimension.getWidth() * screenSizeMultiplier05)
        int scrollStart = (int) (dimension.getHeight() * screenSizeMultiplier08)
        int scrollEnd = (int) (dimension.getHeight() * screenSizeMultiplier02)
        action.longPress(PointOption.point(scrollWidth, scrollStart)).moveTo(PointOption.point(scrollWidth, scrollEnd)).release().perform()
    }

    /**
     * Slowly scroll down on screen
     * @param device
     */
    static void slowScrollDown(Device device) {
        TouchAction action = new TouchAction(device.getDriver() as AppiumDriver)
        Dimension dimension = device.getDriver().manage().window().getSize()
        action.press(PointOption.point((dimension.getWidth() / 4).toInteger(), (dimension.getHeight() * 0.75).toInteger())).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point((dimension.getWidth() / 4).toInteger(), (dimension.getHeight() * 0.25).toInteger())).release().perform()
    }

    /**
     * Slowly scroll up on screen
     * @param device
     */
    static void slowScrollUp(Device device) {
        TouchAction action = new TouchAction(device.getDriver() as AppiumDriver)
        Dimension dimension = device.getDriver().manage().window().getSize()
        action.press(PointOption.point(dimension.getWidth(), (dimension.getHeight() * 0.25).toInteger())).moveTo(PointOption.point((dimension.getWidth() / 2).toInteger(), (dimension.getHeight() * 0.75).toInteger())).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).release().perform()
    }


    static void swipeLeft(Device device, WebElement webElement) {
        int elementX = webElement.getLocation().getX()
        int elementY = webElement.getLocation().getY()
        int elementWidth = webElement.getSize().getWidth()
        int elementHeight = webElement.getSize().getHeight()

        TouchAction action = new TouchAction(device.getDriver() as AppiumDriver)
        action.press(PointOption.point((elementX + elementWidth) as int, (elementY + elementHeight / 2) as int)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(elementX, (elementY + elementHeight / 2) as int)).release().perform()
    }
}
