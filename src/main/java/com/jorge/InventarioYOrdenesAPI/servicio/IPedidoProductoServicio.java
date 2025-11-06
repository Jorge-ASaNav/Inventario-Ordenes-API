package com.jorge.InventarioYOrdenesAPI.servicio;

import com.jorge.InventarioYOrdenesAPI.modelo.PedidoProducto;

import java.util.List;

public interface IPedidoProductoServicio {
    public List<PedidoProducto> obtenerPedidoProducto();
    public PedidoProducto obtenerPedidoProductoPorId(Long id);
    public PedidoProducto crearPedidoProducto(PedidoProducto pedidoProducto);
    public PedidoProducto actualizarPedidoProducto(Long id,PedidoProducto pedidoProducto);
    public void eliminarPedidoProducto(Long id);
    public List<PedidoProducto> obtenerPorPedidoId(Long id);
}
