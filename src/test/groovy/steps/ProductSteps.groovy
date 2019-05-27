package steps

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import impl.ActionsImpl
import impl.helpers.CifyTestException

/**
 * Created by FOB Solutions
 */

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)


Then(~/^products page should be visible$/) { ->
   if (ActionsImpl.getProductActions().isProductItineraryEmpty()) {
       throw new CifyTestException("Product itinerary should not be empty!")
   }
}