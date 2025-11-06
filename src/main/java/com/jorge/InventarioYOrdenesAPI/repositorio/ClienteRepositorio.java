package com.jorge.InventarioYOrdenesAPI.repositorio;

import com.jorge.InventarioYOrdenesAPI.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente,Long> {
    Cliente findByEmail(String email);
}
