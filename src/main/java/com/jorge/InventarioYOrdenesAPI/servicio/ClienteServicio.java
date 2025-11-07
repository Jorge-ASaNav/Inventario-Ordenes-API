package com.jorge.InventarioYOrdenesAPI.servicio;

import com.jorge.InventarioYOrdenesAPI.excepciones.ElementoNoEncontradoException;
import com.jorge.InventarioYOrdenesAPI.excepciones.ListaVaciaException;
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
        List<Cliente> clientes=repositorio.findAll();
        if(clientes.isEmpty()){
            throw new ListaVaciaException("La lista no contiene elementos");
        }
        return clientes;
    }

    @Override
    public Cliente obtenerCLientePorId(Long id) {
        return repositorio.findById(id).orElseThrow(()->new ElementoNoEncontradoException("No hay Cliente con ese id:"+id));
    }

    @Override
    public Cliente obtenerClientePorCorreo(String correo) {
        return repositorio.findByEmail(correo);
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return repositorio.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente cliente) {
        Cliente actual=repositorio.findById(id).orElseThrow(()->new ElementoNoEncontradoException("No existe cliente con ese id:"+id));
        actual.setNombre(cliente.getNombre());
        actual.setEmail(cliente.getEmail());
        actual.setTelefono(cliente.getTelefono());
        actual.setPedidos(cliente.getPedidos());
        actual.setCreado(cliente.getCreado());
        return repositorio.save(actual);
    }

    @Override
    public void eliminarClientePorId(Long id) {
        Cliente existente=repositorio.findById(id).orElseThrow(()->new ElementoNoEncontradoException("No existe el elemento"));
        repositorio.deleteById(id);

    }
}
