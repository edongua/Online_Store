package com.tiendaonline.view;


import com.tiendaonline.controller.ControladorArticulos;
import com.tiendaonline.model.Articulo;
import com.tiendaonline.model.Cliente;
import com.tiendaonline.model.Pedido;

import java.util.Scanner;

//Clase
public class MenuPrincipal {
    Scanner sc;
    GestorArticulos ga;
    GestorClientes gc;
    GestorPedidos gp;
    public MenuPrincipal(Scanner sc, GestorArticulos ga, GestorClientes gc, GestorPedidos gp) {
        this.sc = sc;
        this.ga = ga;
        this.gc = gc;
        this.gp = gp;
    }
        public void mostrarMenuPrincipal() {
            int opcion;
            do {
                System.out.println("<===Menú Principal===>");
                System.out.println("1. Seleccionar gestor de artículos");
                System.out.println("2. Seleccionar gestor de clientes");
                System.out.println("3. Seleccionar gestor de pedidos");
                System.out.println("0. Salir del menú");
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1 -> ga.mostrarMenuArticulos();
                    case 2 -> gc.mostrarMenuClientes();
                    case 3 -> gp.mostrarMenuPedidos();
                    case 0 -> System.out.print("Saliendo del menú...");
                    default -> System.out.print("La opción no es válida");
                }
            } while (opcion != 0);
        }

}
