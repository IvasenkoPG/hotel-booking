package com.ivasenko.hotel.server.hotelbooking.controller;

import com.ivasenko.hotel.server.hotelbooking.errors.ApiErrorResponse;
import com.ivasenko.hotel.server.hotelbooking.exceptions.ProfileAlreadyExistsException;
import com.ivasenko.hotel.server.hotelbooking.exceptions.ProfileNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Method handle ProfileAlreadyExistsException.
     *
     * @param ex ProfileAlreadyExistsException
     * @return ApiErrorResponse
     */
    @ExceptionHandler(ProfileAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ApiErrorResponse handleProfileAlreadyExistsException(final ProfileAlreadyExistsException ex) {
        return getApiErrorResponse(ex.getCause(),ex.getClass().getSimpleName(), ex.getMessage());
    }

    /**
     * Method handle ProfileNotFoundException.
     *
     * @param ex ProfileNotFoundException
     * @return ApiErrorResponse
     */
    @ExceptionHandler(ProfileNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiErrorResponse handleProfileNotFoundException(final ProfileNotFoundException ex) {
        return getApiErrorResponse(ex.getCause(), ex.getClass().getSimpleName(), ex.getMessage());
    }

    /**
     * Method performs exception handling.
     *
     * @param throwable thrown exception
     * @param simpleName exception name
     * @param message exception message
     * @return ApiErrorResponse
     */
    private ApiErrorResponse getApiErrorResponse(
            final Throwable throwable,
            final String simpleName,
            final String message) {
        final String cause = String.valueOf(throwable);
        LOG.error(cause);
        return new ApiErrorResponse(simpleName, cause, message);
    }

}
