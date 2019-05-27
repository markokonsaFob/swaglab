package steps

import cucumber.api.Scenario
import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import impl.ActionsImpl
import impl.helpers.TestDataManager
import io.cify.framework.core.DeviceCategory
import io.cify.framework.core.DeviceManager

/**
 * Created by Marko Konsa for Nordic Testing Day workshop
 * Mobile Test Automation Using Cify Open-Source Framework
 * https://nordictestingdays.eu/events/workshops/mobile-test-automation-using-cify-open-source-framework
 */

this.metaClass.mixin(Hooks)
this.metaClass.mixin(EN)


Before { Scenario scenario ->
    TestDataManager.setTestData("Scenario", scenario)

    DeviceCategory.values().each {
        DeviceManager.getInstance().getCapabilities().addToDesiredCapabilities(it, "testobject_test_name", scenario.name)
    }
}

Given(~/^user opens application on (.+) device$/) { DeviceCategory category ->
    ActionsImpl.getCoreActions(category).openApplication()
}

After {
    DeviceManager.getInstance().quitAllDevices()
}