package impl.views.login

import groovy.json.internal.LazyMap
import impl.helpers.Constants
import impl.helpers.TestDataManager
import io.cify.framework.actions.ActionsDesktopWeb
import io.cify.framework.actions.ActionsMobileAndroidApp
import io.cify.framework.actions.ActionsMobileIOSApp
import io.cify.framework.core.Device

import static impl.helpers.ActionsWrapper.waitForCondition

/**
 * Created by Marko Konsa for Nordic Testing Day workshop
 * Mobile Test Automation Using Cify Open-Source Framework
 * https://nordictestingdays.eu/events/workshops/mobile-test-automation-using-cify-open-source-framework
 *
 * Login Actions for all platforms
 */
class LoginActions implements ActionsMobileAndroidApp, ActionsMobileIOSApp, ActionsDesktopWeb {

    Device device
    LoginPage loginPage

    LoginActions(Device device) {
        this.device = device
        this.loginPage = new LoginPage(device)
    }

    /**
     * Verify whether login page is visible
     * @return
     */
    boolean isLoginPageVisible() {
        waitForCondition(device, {
            isDisplayed(loginPage.usernameField) &&
                    isDisplayed(loginPage.passwordField) &&
                    isDisplayed(loginPage.loginButton)
        }, 30)
    }

    /**
     * Enter credentials by account type
     * @param type
     */
    void enterCredentials(Constants.accountType type) {
        loginPage.usernameField.clear()
        loginPage.passwordField.clear()

        LazyMap userData = TestDataManager.getAccount(type)

        sendKeys(loginPage.usernameField, userData.get("username") as String)
        sendKeys(loginPage.passwordField, userData.get("password") as String)
    }

    /**
     * Click login button
     */
    void clickLoginButton() {
        click(loginPage.loginButton)
    }

}
