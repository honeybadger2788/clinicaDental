package com.example.clinicaDental.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import org.apache.log4j.*;

// al poner la anotación @ControllerAdvice, no es necesario poner el throw en cada metodo
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    // para que maneje todas las excepciones del tipo excepcion (bien general).
    // Si queremos que maneje algo en particular, debemos crear otro
    @ExceptionHandler(Exception.class)
    public ResponseEntity allError(Exception ex, WebRequest req) {
        logger.error(ex.getMessage());
        return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity notFoundError(ResourceNotFoundException ex){
        logger.error(ex.getMessage());
        return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity badRequest(BadRequestException ex){
        logger.error(ex.getMessage());
        return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }

}
