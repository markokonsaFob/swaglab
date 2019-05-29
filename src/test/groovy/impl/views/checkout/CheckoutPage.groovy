package impl.views.checkout

import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import io.cify.framework.PageObjects
import io.cify.framework.core.Device
import org.openqa.selenium.WebElement

/**
 * Created by Marko Konsa for Nordic Testing Day workshop
 * Mobile Test Automation Using Cify Open-Source Framework
 * https://nordictestingdays.eu/events/workshops/mobile-test-automation-using-cify-open-source-framework
 *
 * Checkout Page Object
 */
class CheckoutPage extends PageObjects {

    @AndroidFindBy(accessibility = "test-First Name")
    @iOSXCUITFindBy(accessibility = "test-First Name")
    WebElement firstNameField

    @AndroidFindBy(accessibility = "test-Last Name")
    @iOSXCUITFindBy(accessibility = "test-Last Name")
    WebElement lastnameField

    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    @iOSXCUITFindBy(accessibility = "test-Zip/Postal Code")
    WebElement postalCodeField

    @AndroidFindBy(accessibility = "test-CONTINUE")
    @iOSXCUITFindBy(accessibility = "test-CONTINUE")
    WebElement continueButton

    @AndroidFindBy(accessibility = "test-FINISH")
    @iOSXCUITFindBy(accessibility = "test-FINISH")
    WebElement finishButton

    @AndroidFindBy(accessibility = "test-CHECKOUT: COMPLETE!")
    @iOSXCUITFindBy(accessibility = "test-CHECKOUT: COMPLETE!")
    WebElement checkoutCompleteContainer

    Device device

    CheckoutPage(Device device) {
        super(device)
        this.device = device
    }
}