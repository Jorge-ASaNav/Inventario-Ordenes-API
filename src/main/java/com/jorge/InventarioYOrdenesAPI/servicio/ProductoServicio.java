package com.jorge.InventarioYOrdenesAPI.servicio;

import com.jorge.InventarioYOrdenesAPI.excepciones.ElementoNoEncontradoException;
import com.jorge.InventarioYOrdenesAPI.excepciones.ListaVaciaException;
import com.jorge.InventarioYOrdenesAPI.modelo.Producto;
import com.jorge.InventarioYOrdenesAPI.repositorio.ProductoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServicio implements IProductoServicio{

    private final ProductoRepositorio repositorio;

    @Override
    public List<Producto> obtenerProductos() {
        List<Producto> lista=repositorio.findAll();
        if(lista.isEmpty()){
            throw new ListaVaciaException("No hay elementos en la lista");
        }
        return lista;
    }

    @Override
    public List<Producto> obtenerProductoPorNombre(String nombre) {
        List<Producto> producto=repositorio.findByNombreIgnoreCase(nombre);
        if(producto.isEmpty()){
            throw new ElementoNoEncontradoException("No hay productos con ese nombre");
        }
        return producto;
    }

    @Override
    public Producto obtenerProductoPorId(Long id) {
        return repositorio.findById(id).orElseThrow(()->new ElementoNoEncontradoException("No hay producto con dicho Id"));
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return repositorio.save(producto);
    }

    @Override
    public Producto actualizarProducto(Long id, Producto producto) {
        Producto actual=repositorio.findById(id).orElseThrow(()->new ElementoNoEncontradoException("No existe el producto"));
        actual.setNombre(producto.getNombre());
        actual.setPrecio(producto.getPrecio());
        actual.setDescripcion(producto.getDescripcion());
        actual.setStock(producto.getStock());
        actual.setCreado(producto.getCreado());
        return repositorio.save(actual);
    }

    @Override
    public void eliminarProductoPorId(Long id) {
        Producto producto=repositorio.findById(id).orElseThrow(()->new ElementoNoEncontradoException("No existe producto con ese id"));
        repositorio.deleteById(id);
    }

}
