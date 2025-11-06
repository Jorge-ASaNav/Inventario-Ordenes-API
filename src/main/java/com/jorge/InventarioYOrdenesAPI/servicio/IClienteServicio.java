package com.jorge.InventarioYOrdenesAPI.servicio;

import com.jorge.InventarioYOrdenesAPI.modelo.Cliente;

import java.util.List;

public interface IClienteServicio {
    public List<Cliente> listarClientes();
    public Cliente obtenerCLientePorId(Long id);
    public Cliente guardarCliente(Cliente cliente);
    public Cliente actualizarCliente(Long id,Cliente cliente);
    public void eliminarClientePorId(Long id);
    public Cliente obtenerClientePorCorreo(String correo);
}
