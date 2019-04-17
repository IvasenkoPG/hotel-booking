package com.ivasenko.hotel.server.hotelbooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception can be thrown in case when profile or profiles not found in database.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(final String message) {
        super(message);
    }
}
