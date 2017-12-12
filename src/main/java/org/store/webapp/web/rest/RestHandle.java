package org.store.webapp.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.store.webapp.util.InfoError;
import org.store.webapp.util.NotFoundException;

import javax.servlet.http.HttpServletRequest;

public abstract class RestHandle {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    InfoError handleException(HttpServletRequest request, Exception exception) {
        return new InfoError(request.getRequestURL().toString(), exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    InfoError handleExceptionOther(HttpServletRequest request, Exception exception) {
        return new InfoError(request.getRequestURL().toString(), exception.getMessage());
    }
}
