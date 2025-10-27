package com.tiendaonline.model;
//Clase
public class Articulo {
    private String codigo;
    private String descripcion;
    private float precio_venta;
    private float gastos_envio;
    private int tiempo_preparacion;
    //Constructor
    public Articulo(String codigo, String descripcion, float precio_venta, float gastos_envio, int tiempo_preparacion){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio_venta = precio_venta;
        this.gastos_envio = gastos_envio;
        this.tiempo_preparacion = tiempo_preparacion;
    }
    //Getters
    public String getCodigoArticulo(){
        return codigo;
    }
    public String getDescripcionArticulo(){
        return descripcion;
    }
    public float getPrecioArticulo(){
        return precio_venta;
    }
    public float getGastosEnvioArticulo(){
        return gastos_envio;
    }
    public int getTiempoPreparacionArticulo(){
        return tiempo_preparacion;
    }
    //Setters
    public void setCodigoArticulo(String codigo){
        this.codigo = codigo;
    }
    public void setDescripcionArticulo(String descripcion){
        this.descripcion = descripcion;
    }
    public void setPrecioArticulo(float precio_venta){
        this.precio_venta = precio_venta;
    }
    public void setGastosEnvioArticulo(float gastos_envio){
        this.gastos_envio = gastos_envio;
    }
    public void setTiempoPreparacionArticulo (int tiempo_preparacion){
        this.tiempo_preparacion = tiempo_preparacion;
    }
    @Override
    public String toString(){
        return "Artículo {código: " + codigo + ", descripción: " + descripcion
                + ", precio de venta: " + precio_venta + ", gastos de envío: " + gastos_envio
                + ", tiempo de preparación: " + tiempo_preparacion + "}\n";
    }
}
