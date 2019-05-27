package impl.helpers

/**
 * Created by Marko Konsa for Nordic Testing Day workshop
 * Mobile Test Automation Using Cify Open-Source Framework
 * https://nordictestingdays.eu/events/workshops/mobile-test-automation-using-cify-open-source-framework
 *
 * Default test exception class
 */
class CifyTestException extends Exception {
    /**
     * Blank Test exception with message
     *
     * @param message message to send
     * */
    CifyTestException(String message) {
        super(message)
    }

    /**
     * Blank Test exception with message and option to suppress stack trace
     *
     * @param message to send
     * @param suppressStacktrace if true, then stack trace is not added to the exception message
     */
    CifyTestException(String message, boolean suppressStackTrace) {
        super(message, null, suppressStackTrace, !suppressStackTrace)
    }
}
