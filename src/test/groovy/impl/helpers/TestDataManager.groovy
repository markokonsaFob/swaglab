package impl.helpers

import groovy.json.JsonSlurper
import groovy.json.internal.LazyMap
/**
 * Created by Marko Konsa for Nordic Testing Day workshop
 * Mobile Test Automation Using Cify Open-Source Framework
 * https://nordictestingdays.eu/events/workshops/mobile-test-automation-using-cify-open-source-framework
 *
 * This class is responsible for TestData management.
 */
class TestDataManager {

    private static ThreadLocal<LazyMap> testData = new ThreadLocal<>([:])

    /**
     * Returns all test data from file
     * @return LazyMap of test data
     */
    static LazyMap getTestDataFileContent() {
        File dataFile = new File(Constants.DATA_FILE_NAME)
        if (!dataFile.exists()) throw new CifyTestException("Data file is missing from project root. Please add $Constants.DATA_FILE_NAME into project root")
        new JsonSlurper().parse(new File(Constants.DATA_FILE_NAME)) as LazyMap
    }

    /**
     * Saves a key-value pair to map for given device
     * @param key Key for the value
     * @param value value to be saved
     */
    static void setTestData(String key, Object value) {
        getTestData().put(key, value)
    }

    /**
     * Returns value from device specific map
     * @param key Key for the value
     * @return String value from map
     */
    static Object getValue(String key) {
        getTestData().get(key)
    }

    /**
     * Retuns Account json object from data file
     * @param accountType
     * @return
     */
    static LazyMap getAccount(Constants.accountType accountType) {
        (getTestData().get(Constants.ACCOUNTS) as LazyMap).get(accountType.toString()) as LazyMap
    }

    /**
     * Gets environment data from data file
     * @param name
     * @return
     */
    static String getEnvironmentData(String name) {
        (getTestData().get(Constants.ENVIRONMENT_VARIABLES) as LazyMap).get(name)
    }

    /**
     * Get test data
     * @return
     */
    private static LazyMap getTestData() {
        if (testData.get() == null) {
            testData.set(getTestDataFileContent())
        }
        testData.get() as LazyMap
    }

}
