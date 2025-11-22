package com.tiendaonline.view;



import com.tiendaonline.controller.ControladorArticulos;
import com.tiendaonline.controller.ControladorClientes;
import com.tiendaonline.model.Articulo;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GestorArticulos {
    Scanner sc;
    ControladorArticulos ca;
    public GestorArticulos(Scanner sc, ControladorArticulos ca){
        this.sc = sc;
        this.ca = ca;
    }
    public void mostrarMenuArticulos () {
        int opcion;
        do {
            System.out.println("--Gestor de artículos--");
            System.out.println("1. Añadir nuevo artículo");
            System.out.println("2. Mostrar todos los artíclos");
            System.out.println("0. Salir del gestor de artíclos");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> addArticulo();
                case 2 -> mostrarArticulos();
                case 0 -> System.out.println("Saliendo del gestor de artículos...");
                default -> System.out.println("La opción no es válida");
            }
        } while (opcion != 0);
    }
    private void addArticulo () {
        System.out.print("Código: ");
        String codigo = sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Precio: ");
        float precio = sc.nextFloat();
        System.out.print("Gastos de envío: ");
        float gastosEnvio = sc.nextFloat();
        System.out.print("Tiempo preparación (min): ");
        int tiempoPrep = sc.nextInt();
        sc.nextLine();

        ca.addArticulo(codigo, descripcion, precio, gastosEnvio, tiempoPrep);
    }
    private void mostrarArticulos () {
        HashMap<String, Articulo> coleccion = ca.mostrarArticulos();
        if (coleccion.isEmpty()){
            System.out.println("No hay artículos registrados");
        }
        else{
            coleccion.forEach((key, value) -> {
                System.out.println(key + " = " + value);
            });
        }
    }


}
