package com.tiendaonline.controller;
import com.tiendaonline.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private final Datos datos;

    public Controlador() {
        this.datos = new Datos();
    }
    public void addArticulo(String codigo, String descripcion, float precio_venta, float gastos_envio, int tiempo_preparacion){
        datos.addArticulo(codigo, descripcion, precio_venta, gastos_envio, tiempo_preparacion);
    }
    public List<Articulo> mostrarArticulos(){
        return datos.mostrarArticulos();
    }
    public boolean buscarArticulo(String codigo_articulo){
        return datos.buscarArticulo(codigo_articulo);
    }
    public Articulo getArticulo(String codigo_articulo){
        return datos.getArticulo(codigo_articulo);
    }
    public void addClienteEstandar(String nombre, String domicilio, String nif, String email){
        datos.addClienteEstandar(nombre, domicilio, nif, email);
    }
    public void addClientePremium(String nombre, String domicilio, String nif, String email, int cuota, double descuento){
        datos.addClientePremium(nombre, domicilio, nif, email, cuota, descuento);
    }
    public List<Cliente> mostrarClientes(){
        List<Cliente> clientes = new ArrayList<>();
        clientes.addAll(datos.mostrarClientesEstandar());
        clientes.addAll(datos.mostrarClientesPremium());
        return clientes;
    }
    public List<Cliente> mostrarClientesEstandar(){
        return datos.mostrarClientesEstandar();
    }
    public List<Cliente> mostrarClientesPremium(){
        return datos.mostrarClientesPremium();
    }
    public boolean buscarCliente(String nif){
        return datos.buscarCliente(nif);
    }
    public Cliente getCliente(String nif){
        return datos.getCliente(nif);
    }
    public void addPedido(int numero_pedido, int cantidad_unidades, LocalDateTime fecha_pedido, Articulo articulo, Cliente cliente){
        datos.addPedido(numero_pedido, cantidad_unidades, fecha_pedido, articulo, cliente);
    }
    public boolean buscarPedido(int numero_pedido){
        return datos.buscarPedido(numero_pedido);
    }
    public boolean pedidoEliminable(int numero_pedido) {
        return datos.pedidoEliminable(numero_pedido);
    }
    public boolean eliminarPedido(int numero_pedido){
        return datos.eliminarPedido(numero_pedido);
    }
    public List<Pedido> getPedidosPendientesCliente(String nif){
        return datos.getPedidosPendientesCliente(nif);
    }
    public List<Pedido> getPedidosPendientes(){
        return datos.getPedidosPendientes();
    }
    public List<Pedido> getPedidosEnviadosCliente(String nif){
        return datos.getPedidosEnviadosCliente(nif);
    }
    public List<Pedido> getPedidosEnviados(){
        return datos.getPedidosEnviados();
    }
}
