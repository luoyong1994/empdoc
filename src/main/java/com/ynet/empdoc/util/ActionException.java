package com.ynet.empdoc.util;

public class ActionException extends RuntimeException {
    private String errorMessage;

    public ActionException(String errorMessage){
       this.errorMessage=errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
