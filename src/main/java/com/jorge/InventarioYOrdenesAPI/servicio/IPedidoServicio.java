package com.jorge.InventarioYOrdenesAPI.servicio;

import com.jorge.InventarioYOrdenesAPI.modelo.Pedido;

import java.util.List;

public interface IPedidoServicio {
    public List<Pedido> listarPedidos();
    public Pedido buscarPedidoPorId(Long id);
    public Pedido crearPedido(Pedido pedido);
    public Pedido actualizarPerdido(Long id, Pedido pedido);
    public void eliminarPedidoPorId(Long id);
    public List<Pedido> listarPorClienteId(Long clienteId);
}
