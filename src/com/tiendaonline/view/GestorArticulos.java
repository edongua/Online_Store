package com.tiendaonline.view;


import com.tiendaonline.controller.Controlador;
import com.tiendaonline.model.Articulo;

import java.util.List;
import java.util.Scanner;

public class GestorArticulos {
    private final Scanner scanner;
    private final Controlador controlador;


    public GestorArticulos(Scanner scanner, Controlador controlador){
        this.scanner = scanner;
        this.controlador = controlador;
    }
    public void mostrarMenuArticulos(){
        int opcion;
        do{
            System.out.println("--Gestor de artículos--");
            System.out.println("1. Añadir nuevo artículo");
            System.out.println("2. Mostrar todos los artíclos");
            System.out.println("0. Salir del gestor de artíclos");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){
                case 1 -> addArticulo();
                case 2 -> mostrarArticulos();
                case 0 -> System.out.println("Saliendo del gestor de artículos...");
                default -> System.out.println("La opción no es válida");
            }
        }while(opcion != 0);
    }
    private void addArticulo(){
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Precio: ");
        float precio = scanner.nextFloat();
        System.out.print("Gastos de envío: ");
        float gastos = scanner.nextFloat();
        System.out.print("Tiempo preparación: ");
        int tiempo = scanner.nextInt();
        scanner.nextLine();

        controlador.addArticulo(codigo, descripcion, precio, gastos, tiempo);
    }
    private void mostrarArticulos(){
        List<Articulo> lista = controlador.mostrarArticulos();
        if (lista.isEmpty()){
            System.out.println("No hay artículos registrados");
        }else{
            for (Articulo art : lista){
                System.out.print(art);
            }
        }
    }
}
