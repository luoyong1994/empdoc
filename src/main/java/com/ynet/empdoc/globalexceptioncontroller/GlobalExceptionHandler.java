package com.ynet.empdoc.globalexceptioncontroller;

import com.ynet.empdoc.util.ActionException;
import com.ynet.empdoc.util.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final int ERROR = 1;


    @ExceptionHandler(ActionException.class)
    @ResponseBody
    public JsonResult actionExceptionHandler(ActionException actionException) {
        return new JsonResult(ERROR, null, actionException.getErrorMessage());
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult unknowExceptionHandler(Exception exception) {
        return new JsonResult(ERROR,null,exception.getMessage());
    }
}
