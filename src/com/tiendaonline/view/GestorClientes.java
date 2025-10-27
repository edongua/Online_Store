package com.tiendaonline.view;

import java.util.List;
import java.util.Scanner;
import com.tiendaonline.controller.Controlador;
import com.tiendaonline.model.Cliente;
import com.tiendaonline.model.Estandar;
import com.tiendaonline.model.Premium;

public class GestorClientes {
    private final Scanner scanner;
    private final Controlador controlador;

    public GestorClientes(Scanner scanner, Controlador controlador){
        this.scanner = scanner;
        this.controlador = controlador;
    }

    public void mostrarMenuClientes(){
        int opcion;
        do{
            System.out.println("--Gestor de clientes--");
            System.out.println("1. Añadir un nuevo cliente");
            System.out.println("2. Mostrar todos los clientes");
            System.out.println("3. Mostrar clientes estándar");
            System.out.println("4. Mostrar clientes premium");
            System.out.println("0. Salir del gestor de clientes");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){
                case 1 -> addCliente();
                case 2 -> mostrarClientes();
                case 3 -> mostrarClientesEstandar();
                case 4 -> mostrarClientesPremium();
                case 0 -> System.out.println("Saliendo del gestor de clientes");
                default -> System.out.println("La opción seleccionada no es válida");
            }
        }while(opcion != 0);
    }
    private void addCliente(){
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Domicilio: ");
        String domicilio = scanner.nextLine();
        System.out.print("NIF: ");
        String NIF = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        int tipo;
        System.out.print("Tipo de cliente, 1. Estándar 2. Premium:  ");
        tipo = scanner.nextInt();
        if(tipo == 1){
            controlador.addClienteEstandar(nombre, domicilio, NIF, email);
        }else if(tipo == 2){
            controlador.addClientePremium(nombre, domicilio, NIF, email, 30, 0.2);
        }
        scanner.nextLine();
    }
    private void mostrarClientes(){
        List<Cliente> lista = controlador.mostrarClientes();
        if (lista.isEmpty()){
            System.out.println("No hay ningún cliente registrado");
        }else{
            for(Cliente cliente : lista){
                System.out.println(cliente);
            }
        }
    }
    private void mostrarClientesEstandar(){
        List<Cliente> lista = controlador.mostrarClientesEstandar();
        if (lista.isEmpty()){
            System.out.println("No hay ningún cliente estándar registrado");
        }else{
            for(Cliente cliente : lista){
                System.out.println(cliente);
            }
        }
    }
    private void mostrarClientesPremium(){
        List<Cliente> lista = controlador.mostrarClientesPremium();
        if (lista.isEmpty()){
            System.out.println("No hay ningún cliente premium registrado");
        }else{
            for(Cliente cliente : lista){
                System.out.println(cliente);
            }
        }
    }
}
