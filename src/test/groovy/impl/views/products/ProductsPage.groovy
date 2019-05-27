package impl.views.login

import io.cify.framework.PageObjects
import io.cify.framework.core.Device
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

/**
 * Created by markokonsa for Nordic Testing Day workshop
 * Mobile Test Automation Using Cify Open-Source Framework
 * https://nordictestingdays.eu/events/workshops/mobile-test-automation-using-cify-open-source-framework
 *
 * Login page objects for all platforms
 */
class LoginPage extends PageObjects {

    @FindBy(className = "login_logo")
    WebElement loginLogo

    @FindBy(id = "user-name")
    WebElement usernameField

    @FindBy(id = "password")
    WebElement passwordField

    @FindBy(className = "btn_action")
    WebElement loginButton

    Device device

    LoginPage(Device device) {
        super(device)
        this.device = device
    }
}
