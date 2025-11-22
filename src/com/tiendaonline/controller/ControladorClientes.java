package com.tiendaonline.controller;

import com.tiendaonline.model.Cliente;
import com.tiendaonline.model.Datos;
import com.tiendaonline.model.Estandar;
import com.tiendaonline.model.Premium;

import java.util.ArrayList;

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
    public ArrayList<Cliente> mostrarClientes(){
        ArrayList<Cliente> lista;
        lista = datos.mostrarClientes();
        return lista;
    }
    public ArrayList<Estandar> mostrarClientesEstandar(){
        ArrayList<Estandar> listaEstandar;
        listaEstandar = datos.mostrarClientesEstandar();
        return listaEstandar;
    }
    public ArrayList<Premium> mostrarClientesPremium(){
        ArrayList<Premium> listaPremium;
        listaPremium = datos.mostrarClientesPremium();
        return listaPremium;
    }

}
