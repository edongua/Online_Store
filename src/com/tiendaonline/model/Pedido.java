package com.tiendaonline.model;

import java.time.LocalDateTime;
// Clase
public class Pedido {
    private int numero_pedido;
    private int cantidad_unidades;
    private LocalDateTime fecha;
    private Articulo articulo;
    private Cliente cliente;
    // Constructor
    public Pedido (int numero_pedido, int cantidad_unidades, LocalDateTime fecha, Articulo articulo, Cliente cliente){
        this.numero_pedido = numero_pedido;
        this.cantidad_unidades = cantidad_unidades;
        this.fecha = fecha;
        this.articulo = articulo;
        this.cliente = cliente;
    }
    //Getters
    public int getNumeroPedido(){
        return numero_pedido;
    }
    public int getCantidadUnidades(){
        return cantidad_unidades;
    }
    public LocalDateTime getFechaPedido(){
        return fecha;
    }
    public Articulo getArticulo(){
        return articulo;
    }
    public Cliente getCliente(){
        return cliente;
    }
    //Setters
    public void setNumeroPedido(int numero_pedido){
        this.numero_pedido = numero_pedido;
    }
    public void setCantidadUnidades(int cantidad_unidades){
        this.cantidad_unidades = cantidad_unidades;
    }
    public void setFechaPedido(LocalDateTime fecha){
        this.fecha = fecha;
    }
    @Override
    public String toString(){
        return "Pedido {número de pedido: " + numero_pedido + ", cantidad de unidades: " + cantidad_unidades
                + ", fecha: " + fecha + "}";
    }
}
