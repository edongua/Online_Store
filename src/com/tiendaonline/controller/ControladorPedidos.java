package com.tiendaonline.controller;

import com.tiendaonline.model.Articulo;
import com.tiendaonline.model.Cliente;
import com.tiendaonline.model.Datos;
import com.tiendaonline.model.Pedido;

import java.time.LocalDateTime;
import java.util.List;

public class ControladorPedidos {
    Datos datos;
    public ControladorPedidos(Datos datos){
        this.datos = datos;
    }
    public Articulo buscarArticulo(String codigo_articulo){
        return datos.buscarArticulo(codigo_articulo);
    }
    public Cliente buscarClientePorNif(String NIF){
        return datos.buscarClientePorNif(NIF);
    }
    public boolean addPedido(int numero_pedido, int cantidad_unidades, LocalDateTime fecha_pedido, Cliente cliente, Articulo articulo){
        return datos.addPedido(numero_pedido, cantidad_unidades, fecha_pedido, cliente, articulo);
    }
    public Pedido buscarPedido(int numero_pedido){
        return datos.buscarPedido(numero_pedido);
    }
    public boolean pedidoEliminable(Pedido pedidoEncontrado){
        return datos.pedidoEliminable(pedidoEncontrado);
    }
    public boolean eliminarPedido(Pedido pedidoEncontrado){
        return datos.eliminarPedido(pedidoEncontrado);
    }
    public List<Pedido> getPedidosPendientesCliente(String NIF){
        return datos.getPedidosPendientesCliente(NIF);

    }
    public List<Pedido> getTodosPedidosPendientes(){
        return datos.getTodosPedidosPendientes();
    }
    public List<Pedido> getTodosPedidosEnviadosCliente(String NIF){
        return datos.getTodosPedidosEnviadosCliente(NIF);
    }
    public List<Pedido> getTodosPedidosEnviados(){
        return datos.getTodosPedidosEnviados();
    }
}
