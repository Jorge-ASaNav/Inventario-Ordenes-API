package com.jorge.InventarioYOrdenesAPI.servicio;

import com.jorge.InventarioYOrdenesAPI.excepciones.ElementoNoEncontradoException;
import com.jorge.InventarioYOrdenesAPI.excepciones.ListaVaciaException;
import com.jorge.InventarioYOrdenesAPI.modelo.Pedido;
import com.jorge.InventarioYOrdenesAPI.repositorio.PedidoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServicio implements IPedidoServicio{

    private final PedidoRepositorio repositorio;

    @Override
    public List<Pedido> listarPedidos() {
        List<Pedido> lista=repositorio.findAll();
        if(lista.isEmpty()){
            throw new ListaVaciaException("No hay elementos en la lista");
        }
        return lista;
    }

    @Override
    public List<Pedido> listarPorClienteId(Long clienteId) {
        List<Pedido> listado=repositorio.findByClienteId(clienteId);
        if(listado.isEmpty()){
            throw new ListaVaciaException("No hay pedidos con ese cliente");
        }
        return listado;
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        return repositorio.save(pedido);
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        return repositorio.findById(id).orElseThrow(()->new ElementoNoEncontradoException("No hay pedido con ese ID"));
    }

    @Override
    public void eliminarPedidoPorId(Long id) {
        Pedido existente=repositorio.findById(id).orElseThrow(()->new ElementoNoEncontradoException("No existe ese elemento"));
        repositorio.deleteById(id);
    }

    @Override
    public Pedido actualizarPerdido(Long id, Pedido pedido) {
        Pedido actual=repositorio.findById(id).orElseThrow(()->new ElementoNoEncontradoException("NO hay elementos con ese id"));
        actual.setTotal(pedido.getTotal());
        actual.setCreado(pedido.getCreado());
        actual.setCliente(pedido.getCliente());
        actual.setPedidoOrden(pedido.getPedidoOrden());
        return repositorio.save(actual);
    }
}
