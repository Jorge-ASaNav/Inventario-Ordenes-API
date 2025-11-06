package com.jorge.InventarioYOrdenesAPI.repositorio;

import com.jorge.InventarioYOrdenesAPI.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto,Long> {
    List<Producto> findByNombreIgnoreCase(String nombre);
}
