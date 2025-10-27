package com.tiendaonline.model;
//Clase
public class Estandar extends Cliente{
    //Constructor
    public Estandar(String nombre, String domicilio, String nif, String email){
        super(nombre, domicilio, nif, email);
    }
    @Override
    public String toString(){
        return super.toString() + "\n";
    }
}
