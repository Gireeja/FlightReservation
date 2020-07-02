package com.altmerik.flightReservation;

import com.altmerik.flightReservation.exception.BusinessException;
import com.altmerik.flightReservation.exception.ErrorCode;
import com.altmerik.flightReservation.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponse> handleBusinessServiceException(final BusinessException exception) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(createErrorMessage(ErrorCode.EMPTY_RECORD_EXECPTION));
    }

    private ExceptionResponse createErrorMessage(ErrorCode errorCodeAndMsg) {
        return ExceptionResponse
                .builder()
                .errorCode(errorCodeAndMsg.getErrorCode())
                .errorMessage(errorCodeAndMsg.getErrorMessage())
                .build();
    }
}
