package com.tiendaonline.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import com.tiendaonline.controller.ControladorClientes;
import com.tiendaonline.model.Cliente;
import com.tiendaonline.model.Estandar;
import com.tiendaonline.model.Premium;

public class GestorClientes {
    Scanner sc;
    ControladorClientes cc;

    public GestorClientes(Scanner sc, ControladorClientes cc) {
        this.sc = sc;
        this.cc = cc;
    }

    public void mostrarMenuClientes() {
        int opcion;
        do {
            System.out.println("--Gestor de clientes--");
            System.out.println("1. Añadir un nuevo cliente");
            System.out.println("2. Mostrar todos los clientes");
            System.out.println("3. Mostrar clientes estándar");
            System.out.println("4. Mostrar clientes premium");
            System.out.println("0. Salir del gestor de clientes");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> addCliente();
                case 2 -> mostrarClientes();
                case 3 -> mostrarClientesEstandar();
                case 4 -> mostrarClientesPremium();
                case 0 -> System.out.println("Saliendo del gestor de clientes");
                default -> System.out.println("La opción seleccionada no es válida");
            }
        } while (opcion != 0);
    }

    private void addCliente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Domicilio: ");
        String domicilio = sc.nextLine();
        System.out.print("NIF: ");
        String NIF = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        int tipo;
        System.out.print("Tipo de cliente, 1. Estándar 2. Premium:  ");
        tipo = sc.nextInt();
        if (tipo == 1) {
            cc.addClienteEstandar(nombre, domicilio, NIF, email);
            System.out.println("Cliente Estándar fue añadido correctamente");
        } else if (tipo == 2) {
            int cuota = 30;
            double descuento = 0.2;
            cc.addClientePremium(nombre, domicilio, NIF, email, cuota, descuento);
            System.out.println("El cliente Premium fue añadido correctamente");
        }
        sc.nextLine();
    }

    private void mostrarClientes() {
        HashMap<String, Cliente> coleccion = cc.mostrarClientes();
        if (coleccion.isEmpty()) {
            System.out.println("No hay ningún cliente registrado");
        } else {
            coleccion.forEach((key, value) -> {
                System.out.println(key + " = " + value);
            });
        }
    }

    private void mostrarClientesEstandar() {
        HashMap<String, Estandar> coleccionEstandar = cc.mostrarClientesEstandar();
        coleccionEstandar.forEach((key, value)->{
            System.out.println(key + "=" + value);
        });
    }

    private void mostrarClientesPremium() {
       HashMap<String, Premium> coleccionPremium = cc.mostrarClientesPremium();
       coleccionPremium.forEach((key, value) ->{
           System.out.println(key + "=" + value);
       });
    }
}
