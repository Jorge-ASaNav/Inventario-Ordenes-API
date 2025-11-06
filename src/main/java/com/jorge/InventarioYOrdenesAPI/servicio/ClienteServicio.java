package com.jorge.InventarioYOrdenesAPI.servicio;

import com.jorge.InventarioYOrdenesAPI.modelo.Cliente;
import com.jorge.InventarioYOrdenesAPI.repositorio.ClienteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServicio implements IClienteServicio{

    private final ClienteRepositorio repositorio;

    @Override
    public List<Cliente> listarClientes() {
        return List.of();
    }

    @Override
    public Cliente obtenerCLientePorId(Long id) {
        return null;
    }

    @Override
    public Cliente obtenerClientePorCorreo(String correo) {
        return null;
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente cliente) {
        return null;
    }

    @Override
    public void eliminarClientePorId(Long id) {

    }
}
