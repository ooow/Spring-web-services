package com.nc.exception;

/**
 * Created by Гога on 15.04.2016.
 */
public class UsernameIsAlreadyTakenException extends Throwable {
    public UsernameIsAlreadyTakenException(String msg) {
        super(msg);
    }
}
