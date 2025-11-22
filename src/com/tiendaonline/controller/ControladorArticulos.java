package com.tiendaonline.controller;

import com.tiendaonline.model.Articulo;
import com.tiendaonline.model.Datos;

import java.util.ArrayList;
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
    public List<Articulo> mostrarArticulos(){
        List<Articulo> lista;
        lista = datos.mostrarArticulos();
        return lista;
    }
}
