package com.jorge.InventarioYOrdenesAPI.servicio;

import com.jorge.InventarioYOrdenesAPI.excepciones.ElementoNoEncontradoException;
import com.jorge.InventarioYOrdenesAPI.excepciones.ListaVaciaException;
import com.jorge.InventarioYOrdenesAPI.modelo.PedidoProducto;
import com.jorge.InventarioYOrdenesAPI.repositorio.PedidoProductoRepositorio;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoProductoServicio implements IPedidoProductoServicio{

    private final PedidoProductoRepositorio repositorio;

    @Override
    public List<PedidoProducto> obtenerPedidoProducto() {
        List<PedidoProducto> lista=repositorio.findAll();
        if(lista.isEmpty()){
            throw new ListaVaciaException("No hay elementos en la lista");
        }
        return lista;
    }

    @Override
    public PedidoProducto obtenerPedidoProductoPorId(Long id) {
        return repositorio.findById(id).orElseThrow(()->new ElementoNoEncontradoException("No hay elementos con ese id"));
    }

    @Override
    public List<PedidoProducto> obtenerPorPedidoId(Long id) {
        List<PedidoProducto> lista=repositorio.findByPedidoId(id);
        if(lista.isEmpty()){
            throw new ListaVaciaException("No hay elementos en la lista");
        }
        return lista;
    }

    @Override
    public PedidoProducto crearPedidoProducto(PedidoProducto pedidoProducto) {
        return repositorio.save(pedidoProducto);
    }

    @Override
    public PedidoProducto actualizarPedidoProducto(Long id, PedidoProducto pedidoProducto) {
        PedidoProducto pp=repositorio.findById(id).orElseThrow(()->new ElementoNoEncontradoException("No hay elemento con ese id"));
        pp.setSubtotal(pedidoProducto.getSubtotal());
        return repositorio.save(pp);
    }

    @Override
    public void eliminarPedidoProducto(Long id) {
        PedidoProducto producto=repositorio.findById(id).orElseThrow(()->new ElementoNoEncontradoException("Elemento no encontrado"));
        repositorio.deleteById(id);

    }
}
