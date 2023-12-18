package com.codesisters.project.error;

import org.springframework.http.HttpStatus;

public class CustomErrorType extends RuntimeException {

    private HttpStatus httpStatus;

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }

    public CustomErrorType (String errorMessage, HttpStatus httpStatus){
        super(errorMessage);
        this.httpStatus = httpStatus;
    }

}
