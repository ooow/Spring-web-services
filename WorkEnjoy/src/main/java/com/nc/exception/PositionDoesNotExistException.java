package com.nc.exception;

/**
 * Created by Гога on 15.04.2016.
 */
public class PositionDoesNotExistException extends Throwable{
    public PositionDoesNotExistException(String msg){
        super(msg);
    }
}
