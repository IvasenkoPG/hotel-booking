package com.ivasenko.hotel.server.hotelbooking.errors;

/**
 * Represents api error response.
 */

public class ApiErrorResponse {

    private String errorName;
    private String cause;
    private String errorMsg;

    public ApiErrorResponse() {
    }

    public ApiErrorResponse(String errorName, String cause, String errorMsg) {
        this.errorName = errorName;
        this.cause = cause;
        this.errorMsg = errorMsg;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
