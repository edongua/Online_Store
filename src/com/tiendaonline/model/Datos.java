package com.tiendaonline.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Datos {
    private final List<Articulo> articulos;
    private final List<Cliente> clientes;
    private final List<Pedido> pedidos;

    public Datos(){
        this.articulos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }
    public void addArticulo(String codigo, String descripcion, float precio_venta, float gastos_envio, int tiempo_preparacion){
        Articulo nuevo = new Articulo(codigo, descripcion, precio_venta, gastos_envio, tiempo_preparacion);
        articulos.add(nuevo);
    }
    public List<Articulo> mostrarArticulos(){
        return articulos;
    }
    public void addClienteEstandar(String nombre, String domicilio, String nif, String email){
        clientes.add(new Estandar(nombre, domicilio, nif, email));
    }
    public void addClientePremium(String nombre, String domicilio, String nif, String email, int cuota, double descuento) {
        clientes.add(new Premium(nombre, domicilio, nif, email, cuota, descuento));
    }
    public List<Cliente> mostrarClientesEstandar(){
        List<Cliente> lista = new ArrayList<>();
        for(Cliente cliente : clientes){
            if(cliente instanceof Estandar){
                lista.add(cliente);
            }
        }
        return lista;
    }
    public List<Cliente> mostrarClientesPremium(){
        List<Cliente> lista = new ArrayList<>();
        for (Cliente cliente : clientes){
            if(cliente instanceof Premium){
                lista.add(cliente);
            }
        }
        return lista;
    }
    public boolean buscarArticulo(String codigo_articulo){
        for (Articulo articulo : articulos){
            if (articulo.getCodigoArticulo().equals(codigo_articulo)){
                return true;
            }
        }
        return false;
    }
    public Articulo getArticulo(String codigo_articulo){
        for(Articulo articulo : articulos){
            if(articulo.getCodigoArticulo().equals(codigo_articulo)){
                return articulo;
            }
        }
        return null;
    }
    public boolean buscarCliente(String nif){
        for (Cliente cliente : clientes){
            if(cliente.getNifCliente().equals(nif)){
                return true;
            }
        }
        return false;
    }
    public Cliente getCliente(String nif){
        for (Cliente cliente : clientes){
            if(cliente.getNifCliente().equals(nif)){
                return cliente;
            }
        }
        return null;
    }
    public void addPedido(int numero_pedido, int cantidad_unidades, LocalDateTime fecha_pedido, Articulo articulo, Cliente cliente){
        Pedido nuevo = new Pedido(numero_pedido, cantidad_unidades, fecha_pedido, articulo, cliente);
        pedidos.add(nuevo);
    }
    public boolean buscarPedido(int numero_pedido){
        for(Pedido pedido : pedidos){
            if(pedido.getNumeroPedido() == numero_pedido){
                return true;
            }
        }
        return false;
    }
    public boolean pedidoEliminable(int numero_pedido){
        for(Pedido pedido : pedidos){
            if(pedido.getNumeroPedido() == numero_pedido){
                long diasTranscurridos = Duration.between(pedido.getFechaPedido(), LocalDateTime.now()).toDays();
                int tiempoPreparacion = pedido.getArticulo().getTiempoPreparacionArticulo();

                return diasTranscurridos <= tiempoPreparacion;
            }
        }
        return false;
    }
    public boolean eliminarPedido(int numero_pedido){
        for (Pedido pedido : pedidos){
            if (pedido.getNumeroPedido() == numero_pedido){
                pedidos.remove(pedido);
                return true;
            }
        }
        return false;
    }
    public List<Pedido> getPedidosPendientesCliente(String nif){
        List<Pedido> pendientes = new ArrayList<>();
        for (Pedido pedido : pedidos){
            long dias = Duration.between(pedido.getFechaPedido(), LocalDateTime.now()).toDays();
            int preparacion = pedido.getArticulo().getTiempoPreparacionArticulo();

            if(dias <= preparacion && pedido.getCliente().getNifCliente().equals(nif)){
                pendientes.add(pedido);
            }
        }
        return pendientes;
    }
    public List<Pedido> getPedidosPendientes(){
        List<Pedido> pendientes = new ArrayList<>();
        for (Pedido pedido : pedidos){
            long dias = Duration.between(pedido.getFechaPedido(), LocalDateTime.now()).toDays();
            int preparacion = pedido.getArticulo().getTiempoPreparacionArticulo();

            if(dias <= preparacion){
                pendientes.add(pedido);
            }
        }
        return pendientes;
    }
    public List<Pedido> getPedidosEnviadosCliente(String nif){
        List<Pedido> enviados = new ArrayList<>();
        for (Pedido pedido : pedidos){
            long dias = Duration.between(pedido.getFechaPedido(), LocalDateTime.now()).toDays();
            int preparacion = pedido.getArticulo().getTiempoPreparacionArticulo();

            if(dias > preparacion && pedido.getCliente().getNifCliente().equals(nif)){
                enviados.add(pedido);
            }
        }
        return enviados;
    }
    public List<Pedido> getPedidosEnviados(){
        List<Pedido> enviados = new ArrayList<>();
        for (Pedido pedido : pedidos){
            long dias = Duration.between(pedido.getFechaPedido(), LocalDateTime.now()).toDays();
            int preparacion = pedido.getArticulo().getTiempoPreparacionArticulo();

            if(dias > preparacion){
                enviados.add(pedido);
            }
        }
        return enviados;
    }
}
