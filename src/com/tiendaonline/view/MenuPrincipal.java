package com.tiendaonline.view;

import com.tiendaonline.controller.Controlador;

import java.util.Scanner;
//Clase
public class MenuPrincipal {
    private final Controlador controlador;
    private final Scanner scanner;
    private final GestorArticulos gestorArticulos;
    private final GestorClientes gestorClientes;
    private final GestorPedidos gestorPedidos;

    //Constructor
    public MenuPrincipal(){
        this.controlador = new Controlador();
        this.scanner = new Scanner(System.in);
        this.gestorArticulos = new GestorArticulos(scanner, controlador);
        this.gestorClientes = new GestorClientes(scanner, controlador);
        this.gestorPedidos = new GestorPedidos(scanner, controlador);
    }
    public void mostrarMenuPrincipal(){
        int opcion;
        do{
            System.out.println("<===Menú Principal===>");
            System.out.println("1. Seleccionar gestor de artículos");
            System.out.println("2. Seleccionar gestor de clientes");
            System.out.println("3. Seleccionar gestor de pedidos");
            System.out.println("0. Salir del menú");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch(opcion){
                case 1 -> gestorArticulos.mostrarMenuArticulos();
                case 2 -> gestorClientes.mostrarMenuClientes();
                case 3 -> gestorPedidos.mostrarMenuPedidos();
                case 0 -> System.out.print("Saliendo del menú...");
                default -> System.out.print("La opción no es válida");
            }
        }while(opcion != 0);
    }
}
