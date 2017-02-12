package com.nc.exception;

/**
 * Created by Гога on 11.06.2016.
 */
public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
