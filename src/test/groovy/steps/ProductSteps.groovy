package steps

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import impl.ActionsImpl
import impl.helpers.CifyTestException
import org.openqa.selenium.WebElement

/**
 * Created by Marko Konsa for Nordic Testing Day workshop
 * Mobile Test Automation Using Cify Open-Source Framework
 * https://nordictestingdays.eu/events/workshops/mobile-test-automation-using-cify-open-source-framework
 */

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)


Then(~/^products page should be visible$/) { ->
   if (ActionsImpl.getProductActions().isProductItineraryEmpty()) {
       throw new CifyTestException("Product itinerary should not be empty!")
   }
}

When(~/^user adds first element to cart$/) { ->
    WebElement product = ActionsImpl.getProductActions().getProducts().first()
    ActionsImpl.getProductActions().addProductToCart(product)
}

And(~/^user navigates to cart view$/) { ->
    ActionsImpl.getProductActions().clickOnCartIcon()
}