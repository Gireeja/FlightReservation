package com.altmerik.flightReservation.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {


    EMPTY_RECORD_EXECPTION("500", "Empty Records",HttpStatus.EXPECTATION_FAILED);

    private final String errorCode;
    private final String errorMessage;
    private final HttpStatus status;

    ErrorCode(String id, String msg,HttpStatus status) {
        this.errorCode = id;
        this.errorMessage = msg;
        this.status = status;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}

