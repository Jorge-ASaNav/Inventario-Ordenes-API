package com.jorge.InventarioYOrdenesAPI.repositorio;

import com.jorge.InventarioYOrdenesAPI.modelo.Cliente;
import com.jorge.InventarioYOrdenesAPI.modelo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido,Long> {
    List<Pedido> findByClienteId(Long clienteId);
}
