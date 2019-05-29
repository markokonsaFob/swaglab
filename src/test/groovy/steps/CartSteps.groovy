package steps

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import impl.ActionsImpl
import impl.helpers.CifyTestException
import impl.helpers.Constants
import impl.helpers.TestDataManager

/**
 * Created by Marko Konsa for Nordic Testing Day workshop
 * Mobile Test Automation Using Cify Open-Source Framework
 * https://nordictestingdays.eu/events/workshops/mobile-test-automation-using-cify-open-source-framework
 */

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)


Then(~/^cart view should be visible$/) { ->
    if (!ActionsImpl.getCartActions().isCartPageVisible()) {
        throw new CifyTestException("Cart page should be visible!")
    }
}
And(~/^cart should be filled with entered data$/) { ->
    if (!ActionsImpl.getCartActions().isCartFilledWithCorrectData()) {
        throw new CifyTestException("Cart should be filled with correct Data! Saved data is: " + TestDataManager.getValue(Constants.CART_DATA).toString())
    }
}
When(~/^user clicks on checkout button on cart view$/) { ->
    ActionsImpl.getCartActions().clickCheckout()
}