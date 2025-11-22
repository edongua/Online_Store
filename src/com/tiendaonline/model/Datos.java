package com.tiendaonline.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Datos {
    HashMap<String, Cliente> clientes;
    HashMap<String, Articulo> articulos;

    HashMap<Integer, Pedido> pedidos;

    public Datos(){
        this.clientes = new HashMap<>();
        this.articulos = new HashMap<>();
        this.pedidos = new HashMap<>();

    }
    public void addArticulo(Articulo articulo){
        articulos.put(articulo.getCodigoArticulo(), articulo);
    }
    public HashMap<String, Articulo> mostrarArticulos(){
        return articulos;
    }
    public void addClienteEstandar(Estandar clienteEstandar){
        clientes.put(clienteEstandar.getNifCliente(), clienteEstandar);
    }
    public void addClientePremium(Premium clientePremium){
        clientes.put(clientePremium.getNifCliente(), clientePremium);
    }
    public HashMap<String, Cliente> mostrarClientes(){
        return clientes;
    }
    public HashMap<String, Estandar> mostrarClientesEstandar(){
        HashMap<String, Estandar> coleccionEstandar = new HashMap<>();
        clientes.values().forEach(cliente ->{
            if(cliente instanceof Estandar){
                coleccionEstandar.put(cliente.getNifCliente(), (Estandar) cliente);
            }
        });
        return coleccionEstandar;
    }
    public HashMap<String, Premium> mostrarClientesPremium(){
        HashMap<String, Premium> coleccionPremium = new HashMap<>();
        clientes.values().forEach(cliente -> {
            if(cliente instanceof Premium){
                coleccionPremium.put(cliente.getNifCliente(), (Premium) cliente);
            }
        });
        return coleccionPremium;
    }
    public Articulo buscarArticulo(String codigo_articulo){
        return articulos.get(codigo_articulo);
    }

    public Cliente buscarClientePorNif(String NIF){
        return clientes.get(NIF);
    }
    public boolean addPedido(int numero_pedido, int cantidad_unidades, LocalDateTime fecha_pedido, Cliente cliente, Articulo articulo){
        Pedido pedido = new Pedido(numero_pedido, cantidad_unidades, fecha_pedido, articulo, cliente);
        if(pedidos.putIfAbsent(pedido.getNumeroPedido(), pedido) == null){
            return true;
        }
        return false;
    }
    public Pedido buscarPedido(int numero_pedido){
        return pedidos.get(numero_pedido);
    }
    public boolean pedidoEliminable(Pedido pedidoEncontrado){
        LocalDateTime fecha = LocalDateTime.now();
        int tiempoPreparacion = pedidoEncontrado.getArticulo().getTiempoPreparacionArticulo();
        if(fecha.isAfter(pedidoEncontrado.getFechaPedido().plusMinutes(tiempoPreparacion))){
            return false;
        }
        return true;
    }
    public boolean eliminarPedido(Pedido pedidoEncontrado){
        Pedido eliminado = pedidos.remove(pedidoEncontrado.getNumeroPedido());
        if(eliminado == null){
            return true;
        }
        return false;
    }
    public List<Pedido> getPedidosPendientesCliente(String NIF){
        List<Pedido> lista = new ArrayList<>();
        LocalDateTime fecha = LocalDateTime.now();
        pedidos.values().forEach((pedido)->{
            if(NIF.equals(pedido.getCliente().getNifCliente())){
                int tiempoPreparacion = pedido.getArticulo().getTiempoPreparacionArticulo();
                if(fecha.isBefore(pedido.getFechaPedido().plusMinutes(tiempoPreparacion))){
                    lista.add(pedido);
                }
            }
        });
        return lista;
    }
    public List<Pedido> getTodosPedidosPendientes(){
        List<Pedido> lista = new ArrayList<>();
        LocalDateTime fecha = LocalDateTime.now();
        pedidos.values().forEach((pedido)->{
            int tiempoPreparacion = pedido.getArticulo().getTiempoPreparacionArticulo();
            if(fecha.isBefore(pedido.getFechaPedido().plusMinutes(tiempoPreparacion))){
                lista.add(pedido);
            }
        });
        return lista;
    }
    public List<Pedido> getTodosPedidosEnviadosCliente(String NIF){
        List<Pedido> lista = new ArrayList<>();
        LocalDateTime fecha = LocalDateTime.now();
        pedidos.values().forEach((pedido)->{
            if(NIF.equals(pedido.getCliente().getNifCliente())){
                int tiempoPreparacion = pedido.getArticulo().getTiempoPreparacionArticulo();
                if(fecha.isAfter(pedido.getFechaPedido().plusMinutes(tiempoPreparacion))){
                    lista.add(pedido);
                }
            }
        });
        return lista;
    }
    public List<Pedido> getTodosPedidosEnviados(){
        List<Pedido> lista = new ArrayList<>();
        LocalDateTime fecha = LocalDateTime.now();
        pedidos.values().forEach((pedido)->{
            int tiempoPreparacion = pedido.getArticulo().getTiempoPreparacionArticulo();
            if(fecha.isAfter(pedido.getFechaPedido().plusMinutes(tiempoPreparacion))){
                lista.add(pedido);
            }
        });
        return lista;
    }

}
