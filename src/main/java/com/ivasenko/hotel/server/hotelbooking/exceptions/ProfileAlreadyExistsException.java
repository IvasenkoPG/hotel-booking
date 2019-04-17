package com.ivasenko.hotel.server.hotelbooking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception can be throw in case the profile try to register with info, that already present in database.
 */

@ResponseStatus(HttpStatus.CONFLICT)
public class ProfileAlreadyExistsException extends RuntimeException{
    public ProfileAlreadyExistsException(final String message){super(message);}
}
