package com.example.tratamentoerros.exception;

import java.net.http.HttpHeaders;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> erros = new ArrayList<>();
        for(FieldError fe :ex.getFieldErrors()) {
            erros.add(fe.getField() + ": " + fe.getDefaultMessage());
        }
        ErroResposta erroResposta = new ErroResposta(status.value(), "Erros", LocalDateTime.now(), erros);
        return super.handleExceptionInternal(ex, erroResposta,headers, status, request);
    }
}
