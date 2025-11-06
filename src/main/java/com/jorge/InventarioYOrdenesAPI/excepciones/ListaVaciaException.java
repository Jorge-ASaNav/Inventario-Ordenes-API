package com.jorge.InventarioYOrdenesAPI.excepciones;

public class ListaVaciaException extends RuntimeException {
    public ListaVaciaException(String message) {
        super(message);
    }
}
