package com.tiendaonline.controller;

import com.tiendaonline.model.Articulo;
import com.tiendaonline.model.Datos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ControladorArticulos {
    Datos datos;
    public ControladorArticulos(Datos datos){
        this.datos = datos;
    }
    public void addArticulo(String codigo, String descripcion, float precio, float gastosEnvio, int tiempoPrep){
        Articulo nuevo = new Articulo(codigo, descripcion, precio, gastosEnvio, tiempoPrep);
        datos.addArticulo(nuevo);
    }
    public HashMap<String, Articulo> mostrarArticulos(){
        HashMap<String, Articulo> coleccion;
        coleccion = datos.mostrarArticulos();
        return coleccion;
    }
}
