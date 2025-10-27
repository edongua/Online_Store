package com.tiendaonline.view;

import com.tiendaonline.controller.Controlador;
import com.tiendaonline.model.Articulo;
import com.tiendaonline.model.Cliente;
import com.tiendaonline.model.Pedido;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class GestorPedidos {
    private final Scanner scanner;
    private final Controlador controlador;


    public GestorPedidos(Scanner scanner, Controlador controlador){
        this.scanner = scanner;
        this.controlador = controlador;
    }
    public void mostrarMenuPedidos(){
        int opcion;
        do{
            System.out.println("--Gestor de pedidos--");
            System.out.println("1. Añadir pedidos");
            System.out.println("2. Eliminar pedido");
            System.out.println("3. Mostrar pedidos pendientes de envío");
            System.out.println("4. Mostrar pedidos enviados");
            System.out.println("0. Salir del gestor de pedidos");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){
                case 1 -> addPedido();
                case 2 -> eliminarPedido();
                case 3 -> mostrarPedidosPendientes();
                case 4 -> mostrarPedidosEnviados();
                case 0 -> System.out.println("Saliendo del gestor de pedidos...");
                default -> System.out.println("La opción no es válida");
            }
        }while(opcion != 0);
    }
    private void addPedido(){
        System.out.print("Número del pedido: ");
        int numero_pedido = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Cantidad de unidades: ");
        int cantidad_unidades = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Fecha de la creación del pedido (yyyy-MM-dd): ");
        String fecha_texto = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha = LocalDate.parse(fecha_texto, formatter);
        LocalDateTime fecha_pedido = fecha.atStartOfDay();

        String codigo_articulo;
        while (true){
            System.out.print("Artículo, código: ");
            codigo_articulo = scanner.nextLine();

            if (controlador.buscarArticulo(codigo_articulo)) {
                break;
            }
            System.out.println("El artículo no existe, introduzca otro código o pulse 0 para terminar: ");
            String opcion = scanner.nextLine();
            if (opcion.equals("0")){
                return;
            }
            if (controlador.buscarArticulo(opcion)){
                codigo_articulo = opcion;
                break;
            }
        }
        Articulo articulo = controlador.getArticulo(codigo_articulo);

        System.out.print("Cliente, nif: ");
        String nif = scanner.nextLine().trim();
        System.out.println("DEBUG NIF leído = [" + nif + "]");
        Cliente cliente;
        if(controlador.buscarCliente(nif)){
            cliente = controlador.getCliente(nif);
        }else{
            System.out.println("El cliente no existe. Se debe crear un cliente antes de continuar: ");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Domicilio: ");
            String domicilio = scanner.nextLine();
            System.out.print("NIF: ");
            nif = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            int tipo_cliente;
            do{
                System.out.println("Indique el tipo de cliente: 1-Estandar, 2-Premium");
                tipo_cliente = scanner.nextInt();
                scanner.nextLine();
                if(tipo_cliente == 1){
                    controlador.addClienteEstandar(nombre, domicilio, nif, email);
                }else if(tipo_cliente == 2){
                    controlador.addClientePremium(nombre, domicilio, nif, email, 30, 0.2);
                }
            }while (tipo_cliente != 1 && tipo_cliente != 2);
            cliente = controlador.getCliente(nif);
        }
        controlador.addPedido(numero_pedido, cantidad_unidades, fecha_pedido, articulo, cliente);
        System.out.println("Pedido añadido correctamente");
    }
    private void eliminarPedido(){
        System.out.print("Numero del pedido a eliminar: ");
        int numero_pedido = scanner.nextInt();
        if(controlador.buscarPedido(numero_pedido)){
            System.out.println("El pedido se encontró...");
            if(controlador.pedidoEliminable(numero_pedido)){
                if(controlador.eliminarPedido(numero_pedido)){
                    System.out.println("El pedido ha sido eliminado correctamente");
                }
            }else{
                System.out.println("El pedido fue enviado y no se puede eliminar");
            }
        }else{
            System.out.println("El pedido no se encontró");
        }
    }
    private void mostrarPedidosPendientes(){
        System.out.print("¿Cómo desea mostrar los pedidos pendientes de envío? 1-Filtrar Por cliente, 2-Mostrar todos: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if(opcion == 1){
            System.out.print("Indique el NIF del cliente: ");
            String nif = scanner.nextLine();
            List<Pedido> lista = controlador.getPedidosPendientesCliente(nif);
            for (Pedido pedido : lista){
                System.out.println(pedido);
            }
        }else if(opcion == 2){
            List<Pedido> lista = controlador.getPedidosPendientes();
            for (Pedido pedido : lista){
                System.out.println(pedido);
            }
        }
    }
    private void mostrarPedidosEnviados(){
        System.out.print("¿Cómo desea mostrar los pedidos enviados? 1-Filtrar Por cliente, 2-Mostrar todos: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if(opcion == 1){
            System.out.print("Indique el NIF del cliente: ");
            String nif = scanner.nextLine();
            List<Pedido> lista = controlador.getPedidosEnviadosCliente(nif);
            for (Pedido pedido : lista){
                System.out.println(pedido);
            }
        }else if(opcion == 2){
            List<Pedido> lista = controlador.getPedidosEnviados();
            for (Pedido pedido : lista){
                System.out.println(pedido);
            }
        }
    }
}
