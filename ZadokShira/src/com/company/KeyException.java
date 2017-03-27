package com.company;

/**
 * Created by hackeru on 3/27/2017.
 */
public class KeyException extends Exception{

    public KeyException(String message) {
        super("Your key is invalid"+message);
    }
}
