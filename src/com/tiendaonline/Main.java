package com.tiendaonline;


import com.tiendaonline.controller.ControladorArticulos;
import com.tiendaonline.controller.ControladorClientes;
import com.tiendaonline.controller.ControladorPedidos;
import com.tiendaonline.model.Datos;
import com.tiendaonline.view.GestorArticulos;
import com.tiendaonline.view.GestorClientes;
import com.tiendaonline.view.GestorPedidos;
import com.tiendaonline.view.MenuPrincipal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Datos datos = new Datos();
        Scanner sc = new Scanner(System.in);

        ControladorArticulos ca = new ControladorArticulos(datos);
        ControladorClientes cc = new ControladorClientes(datos);
        ControladorPedidos cp = new ControladorPedidos(datos);
        GestorArticulos ga = new GestorArticulos(sc, ca);
        GestorClientes gc = new GestorClientes(sc, cc);
        GestorPedidos gp = new GestorPedidos(sc, cp, cc);


        MenuPrincipal menu = new MenuPrincipal(sc, ga, gc, gp);

        menu.mostrarMenuPrincipal();
    }
}
