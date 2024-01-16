package com.me.angular.training.api.controllers;

import com.me.angular.training.api.configuration.ExceptionHandle;
import com.me.angular.training.api.dto.res.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ExceptionHandle.class)
    public ResponseEntity<ExceptionResponse> exResponse(HttpServletRequest request, ExceptionHandle exceptionHandle) {
        return new ResponseEntity<>(ExceptionResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(exceptionHandle.getMessage())
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .path(request.getServletPath())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
