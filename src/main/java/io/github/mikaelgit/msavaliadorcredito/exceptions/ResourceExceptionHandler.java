package io.github.mikaelgit.msavaliadorcredito.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;

@RestControllerAdvice
public class ResourceExceptionHandler {
    
    @ExceptionHandler(FeignException.NotFound.class)  
    public ResponseEntity<StandardError> handleDadosClienteNotFound(FeignException e, HttpServletResponse response) {
        StandardError error = new StandardError();
        error.setMensagem(e.getMessage());
        error.setStatus(e.status());
        error.setTimestamp(Instant.now());
        return ResponseEntity.status(error.getStatus()).body(error); 
    }

    @ExceptionHandler(FeignException.FeignServerException.class)  
    public ResponseEntity<StandardError> handleErroComunicacaoMicroservicos(FeignException e, HttpServletResponse response) {
        StandardError error = new StandardError();
        error.setMensagem(e.getMessage());
        error.setStatus(e.status());
        error.setTimestamp(Instant.now());
        return ResponseEntity.status(error.getStatus()).body(error); 
    }
}