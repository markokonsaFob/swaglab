package steps

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import impl.ActionsImpl
import impl.helpers.CifyTestException

/**
 * Created by Marko Konsa for Nordic Testing Day workshop
 * Mobile Test Automation Using Cify Open-Source Framework
 * https://nordictestingdays.eu/events/workshops/mobile-test-automation-using-cify-open-source-framework
 */

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)


Then(~/^checkout information page should be visible$/) { ->
    if (!ActionsImpl.getCheckoutActions().isCheckoutInfoPageVisible()) {
        throw new CifyTestException("Checkout information page should be visible!")
    }
}

When(~/^user enters "([^"]*)" into the first name field on checkout page$/) { String firstname ->
    ActionsImpl.getCheckoutActions().enterFirstName(firstname)
}

And(~/^user enters "([^"]*)" into the last name field on checkout page$/) { String lastname ->
    ActionsImpl.getCheckoutActions().enterLastName(lastname)
}

And(~/^user enters "([^"]*)" into the postal code field on checkout page$/) { String postalcode ->
    ActionsImpl.getCheckoutActions().enterPostalCode(postalcode)
}

And(~/^user clicks continue button on checkout page$/) { ->
    ActionsImpl.getCheckoutActions().clickContinue()
}

Then(~/^user should be on checkout overview page$/) { ->
    if (!ActionsImpl.getCheckoutActions().isCheckoutOverViewPageVisible()) {
        throw new CifyTestException("Checkout Overview page should be visible!")
    }
}

When(~/^user clicks finish on checkout overview page$/) { ->
    ActionsImpl.getCheckoutActions().clickFinish()
}

Then(~/^checkout complete page should be visible$/) { ->
    if (!ActionsImpl.getCheckoutActions().isCheckoutCompletePageVisible()) {
        throw new CifyTestException("Checkout Complete page should be visible!")
    }
}