package com.tiendaonline.model;
// Clase hija
public class Premium extends Cliente {
    private float cuota;
    private double descuento;
    //Constructor
    public Premium (String nombre, String domicilio, String nif, String email, int cuota, double descuento){
        super(nombre, domicilio, nif, email);
        this.cuota = cuota;
        this.descuento = descuento;
    }
    //Getters
    public float getCuota(){
        return cuota;
    }
    public double getDescuento(){
        return descuento;
    }
    //Setters
    public void setCuota(float cuota){
        this.cuota = cuota;
    }
    public void setDescuento(float descuento){
        this.descuento = descuento;
    }
    @Override
    public String toString(){
        return super.toString() + ", cuota; " + cuota + ", descuento: " + descuento + "}\n";
    }
}
