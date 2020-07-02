package com.altmerik.flightReservation.util;

import com.altmerik.flightReservation.domain.Flights;
import com.altmerik.flightReservation.exception.BusinessException;
import com.altmerik.flightReservation.exception.ErrorCode;

import java.util.stream.Collectors;

public class ExceptionUtil {
    public static void handleException()
    {
        throw new BusinessException(ErrorCode.EMPTY_RECORD_EXECPTION,"Empty Records");
    }
}
