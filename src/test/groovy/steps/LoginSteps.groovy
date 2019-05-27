package steps

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import impl.ActionsImpl
import impl.helpers.CifyTestException
import impl.helpers.Constants

/**
 * Created by FOB Solutions
 */

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)

Then(~/^login page should be visible$/) { ->
    if (!ActionsImpl.getLoginActions().isLoginPageVisible()) {
        throw new CifyTestException("Login page should be visible!")
    }
}
When(~/^user enters (.+) credentials into login form$/) { Constants.accountType type ->
    ActionsImpl.getLoginActions().enterCredentials(type)
}
And(~/^user clicks login button$/) { ->
    ActionsImpl.getLoginActions().clickLoginButton()
}