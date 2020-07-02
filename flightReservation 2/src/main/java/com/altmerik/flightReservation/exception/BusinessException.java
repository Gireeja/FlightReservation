package com.altmerik.flightReservation.exception;

public class BusinessException extends RuntimeException {

    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;

    }
}
