package com.jorge.InventarioYOrdenesAPI.excepciones;

public class ElementoNoEncontradoException extends RuntimeException {
    public ElementoNoEncontradoException(String message) {
        super(message);
    }
}
