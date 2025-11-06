package com.jorge.InventarioYOrdenesAPI.servicio;

import com.jorge.InventarioYOrdenesAPI.modelo.Producto;

import java.util.List;

public interface IProductoServicio {
    public List<Producto> obtenerProductos();
    public Producto obtenerProductoPorId(Long id);
    public Producto crearProducto(Producto producto);
    public Producto actualizarProducto(Long id,Producto producto);
    public void eliminarProductoPorId(Long id);
    public List<Producto> obtenerProductoPorNombre(String nombre);
}
