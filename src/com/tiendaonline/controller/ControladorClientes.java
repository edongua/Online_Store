package com.tiendaonline.controller;

import com.tiendaonline.model.Cliente;
import com.tiendaonline.model.Datos;
import com.tiendaonline.model.Estandar;
import com.tiendaonline.model.Premium;

import java.util.ArrayList;
import java.util.HashMap;

public class ControladorClientes {
    Datos datos;
    public ControladorClientes(Datos datos){
        this.datos = datos;
    }
    public void addClienteEstandar(String nombre, String domicilio, String nif, String email){
        Estandar nuevo = new Estandar(nombre, domicilio, nif, email);
        datos.addClienteEstandar(nuevo);
    }
    public void addClientePremium(String nombre, String domicilio, String nif, String email, int cuota, double descuento){
        Premium nuevo = new Premium(nombre, domicilio, nif, email, cuota, descuento);
        datos.addClientePremium(nuevo);
    }
    public HashMap<String, Cliente> mostrarClientes(){
        HashMap<String, Cliente> coleccion;
        coleccion = datos.mostrarClientes();
        return coleccion;
    }
    public HashMap<String, Estandar> mostrarClientesEstandar(){
        return datos.mostrarClientesEstandar();
    }
    public HashMap<String, Premium> mostrarClientesPremium(){
        return datos.mostrarClientesPremium();
    }
}
