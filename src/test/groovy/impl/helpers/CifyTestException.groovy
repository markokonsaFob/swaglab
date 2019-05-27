package impl.helpers

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
