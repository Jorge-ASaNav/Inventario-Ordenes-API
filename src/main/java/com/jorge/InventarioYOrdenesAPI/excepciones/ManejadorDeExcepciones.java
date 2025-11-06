package com.jorge.InventarioYOrdenesAPI.excepciones;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ManejadorDeExcepciones {

    @ExceptionHandler(ListaVaciaException.class)
    public ResponseEntity<Map<String,Object>> manejaListaVaciaException(ListaVaciaException e){
        Map<String,Object> respuesta=new HashMap<>();
        respuesta.put("timestamp", LocalDateTime.now());
        respuesta.put("error", HttpStatus.NO_CONTENT);
        respuesta.put("message",e.getMessage());
        return new ResponseEntity<>(respuesta,HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(ElementoNoEncontradoException.class)
    public ResponseEntity<Map<String,Object>> ElementoNoEncontradoException(ElementoNoEncontradoException e){
        Map<String,Object> respuesta=new HashMap<>();
        respuesta.put("timestamp", LocalDateTime.now());
        respuesta.put("error", HttpStatus.NOT_FOUND);
        respuesta.put("message",e.getMessage());
        return new ResponseEntity<>(respuesta,HttpStatus.NOT_FOUND);
    }


}
