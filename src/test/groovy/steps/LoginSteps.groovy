package steps

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import impl.ActionsImpl
import io.cify.framework.core.DeviceCategory
import io.cify.framework.core.DeviceManager

/**
 * Created by FOB Solutions
 */

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)


Given(~/^user opens application on (.+) device$/) { DeviceCategory category ->
    ActionsImpl.getCoreActions(category).openApplication()
}

After {
    DeviceManager.getInstance().quitAllDevices()
}