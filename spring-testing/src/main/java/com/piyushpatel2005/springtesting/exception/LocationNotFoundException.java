package com.piyushpatel2005.springtesting.exception;

public class LocationNotFoundException extends RuntimeException {


    public LocationNotFoundException() {}
    public LocationNotFoundException(String message) {
        super(message);
    }

}
