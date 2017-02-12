package com.nc.exception;

/**
 * Created by Гога on 15.04.2016.
 */
public class RoleDoesNotExistException extends Throwable {
    public RoleDoesNotExistException(String msg){
        super(msg);
    }
}
