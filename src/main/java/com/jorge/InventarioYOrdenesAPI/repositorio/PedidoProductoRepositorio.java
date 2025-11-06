package com.jorge.InventarioYOrdenesAPI.repositorio;

import com.jorge.InventarioYOrdenesAPI.modelo.PedidoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoProductoRepositorio extends JpaRepository<PedidoProducto,Long> {
    List<PedidoProducto> findByPedidoId(Long pedidoId);
}
