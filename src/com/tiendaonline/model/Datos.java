package com.tiendaonline.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class Datos {
    ArrayList<Cliente> clientes;
    ArrayList<Articulo> articulos;
    ArrayList<Pedido> pedidos;
    Articulo articulo;
    public Datos(){
        this.clientes = new ArrayList<>();
        this.articulos = new ArrayList<>();
        this.pedidos = new ArrayList<>();

    }
    public void addArticulo(Articulo articulo){
        articulos.add(articulo);
    }
    public ArrayList<Articulo> mostrarArticulos(){
        return articulos;
    }
    public void addClienteEstandar(Estandar clienteEstandar){
        clientes.add(clienteEstandar);
    }
    public void addClientePremium(Premium clientePremium){
        clientes.add(clientePremium);
    }
    public ArrayList<Cliente> mostrarClientes(){
        return clientes;
    }
    public ArrayList<Estandar> mostrarClientesEstandar(){
        ArrayList<Estandar> listaEstandar = new ArrayList<>();
        for (Cliente cliente : clientes){
            if (cliente instanceof Estandar){
                listaEstandar.add((Estandar) cliente);
            }
        }
        return listaEstandar;
    }
    public ArrayList<Premium> mostrarClientesPremium(){
        ArrayList<Premium> listaPremium = new ArrayList<>();
        for (Cliente cliente : clientes){
            if(cliente instanceof Premium){
                listaPremium.add((Premium) cliente);
            }
        }
        return listaPremium;
    }
    public Articulo buscarArticulo(String codigo_articulo){
        for (Articulo articulo : articulos){
            if (codigo_articulo.equals(articulo.getCodigoArticulo())){
                return articulo;
            }
        }
        return null;
    }
    public Cliente buscarClientePorNif(String NIF){
        for (Cliente cliente : clientes){
            if (NIF.equals(cliente.getNifCliente())){
                return cliente;
            }
        }
        return null;
    }
    public boolean addPedido(int numero_pedido, int cantidad_unidades, LocalDateTime fecha_pedido, Cliente cliente, Articulo articulo){
        Pedido pedido = new Pedido(numero_pedido, cantidad_unidades, fecha_pedido, articulo, cliente);
        pedidos.add(pedido);
        return true;
    }
    public Pedido buscarPedido(int numero_pedido){
        for(Pedido pedido : pedidos){
            if(numero_pedido == pedido.getNumeroPedido()){
                return pedido;
            }
        }
        return null;
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
        if(pedidos.remove(pedidoEncontrado)){
            return true;
        }
        return false;
    }
    public List<Pedido> getPedidosPendientesCliente(String NIF){
        List<Pedido> lista = new ArrayList<>();
        LocalDateTime fecha = LocalDateTime.now();
        for(Pedido pedido : pedidos){
            if(NIF.equals(pedido.getCliente().getNifCliente())){
                int tiempoPreparacion = pedido.getArticulo().getTiempoPreparacionArticulo();
                if(fecha.isBefore(pedido.getFechaPedido().plusMinutes(tiempoPreparacion))){
                    lista.add(pedido);
                }
            }
        }
        return lista;
    }
    public List<Pedido> getTodosPedidosPendientes(){
        List<Pedido> lista = new ArrayList<>();
        LocalDateTime fecha = LocalDateTime.now();
        for(Pedido pedido : pedidos){
            int tiempoPreparacion = pedido.getArticulo().getTiempoPreparacionArticulo();
            if(fecha.isBefore(pedido.getFechaPedido().plusMinutes(tiempoPreparacion))){
                lista.add(pedido);
            }
        }
        return lista;
    }
    public List<Pedido> getTodosPedidosEnviadosCliente(String NIF){
        List<Pedido> lista = new ArrayList<>();
        LocalDateTime fecha = LocalDateTime.now();
        for(Pedido pedido : pedidos){
            if(NIF.equals(pedido.getCliente().getNifCliente())){
                int tiempoPreparacion = pedido.getArticulo().getTiempoPreparacionArticulo();
                if(fecha.isAfter(pedido.getFechaPedido().plusMinutes(tiempoPreparacion))){
                    lista.add(pedido);
                }
            }
        }
        return lista;
    }
    public List<Pedido> getTodosPedidosEnviados(){
        List<Pedido> lista = new ArrayList<>();
        LocalDateTime fecha = LocalDateTime.now();
        for(Pedido pedido : pedidos){
            int tiempoPreparacion = pedido.getArticulo().getTiempoPreparacionArticulo();
            if(fecha.isAfter(pedido.getFechaPedido().plusMinutes(tiempoPreparacion))){
                lista.add(pedido);
            }
        }
        return lista;
    }

}
