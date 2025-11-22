package com.tiendaonline.view;


import com.tiendaonline.controller.ControladorClientes;
import com.tiendaonline.controller.ControladorPedidos;
import com.tiendaonline.model.Articulo;
import com.tiendaonline.model.Cliente;
import com.tiendaonline.model.Pedido;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class GestorPedidos {
    Scanner sc;
    ControladorPedidos cp;
    ControladorClientes cc;
    public GestorPedidos(Scanner sc, ControladorPedidos cp, ControladorClientes cc){
        this.sc = sc;
        this.cp = cp;
        this.cc = cc;
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
            opcion = sc.nextInt();
            sc.nextLine();

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
        int numero_pedido = sc.nextInt();
        sc.nextLine();
        System.out.print("Cantidad de unidades: ");
        int cantidad_unidades = sc.nextInt();
        sc.nextLine();
        System.out.print("Fecha de la creación del pedido (dd/MM/yyyy HH:mm): ");
        String fecha = sc.nextLine();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime fecha_pedido = LocalDateTime.parse(fecha, formato);
        System.out.print("Código del artículo: ");
        String codigo_articulo = sc.nextLine();
        Articulo articulo;
        articulo = cp.buscarArticulo(codigo_articulo);
        if(articulo == null){
            System.out.println("Artículo no encontrado, pruebe otra vez con otro código");
            return;
        }
        System.out.print("NIF del cliente: ");
        String NIF = sc.nextLine();
        Cliente cliente;
        cliente = cp.buscarClientePorNif(NIF);
        if(cliente == null){
            System.out.println("El cliente no existe, añada el cliente a la BBDD");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Dimicilio: ");
            String domicilio = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.println("Tipo de cliente, 1. Estándar 2. Premium:  ");
            int tipo = sc.nextInt();
            if(tipo == 1){
                cc.addClienteEstandar(nombre, domicilio, NIF, email);
                System.out.println("Cliente Estandar fue añadido correctamente");
            }else if(tipo == 2){
                int cuota = 30;
                double descuento = 0.2;
                cc.addClientePremium(nombre, domicilio, NIF, email, cuota, descuento);
                System.out.println("Cliente Premium fue añadido correctamente");
            }
        }
        cliente = cp.buscarClientePorNif(NIF);
        if(cp.addPedido(numero_pedido, cantidad_unidades, fecha_pedido, cliente, articulo)){
            System.out.println("El pedido " + numero_pedido + " ha sido añadido correctamente: ");
        }
    }
    private void eliminarPedido(){
        System.out.print("Numero del pedido a eliminar: ");
        int numero_pedido = sc.nextInt();
        Pedido pedidoEncontrado = cp.buscarPedido(numero_pedido);
        if(pedidoEncontrado != null){
            System.out.println("El pedido se encontró...");
            if(cp.pedidoEliminable(pedidoEncontrado)){
                if(cp.eliminarPedido(pedidoEncontrado)){
                    System.out.println("El pedido ha sido eliminado correctamente");
                }
            }else{
                System.out.println("El pedido ha sido enviado y no se puede eliminar");
            }
        }else{
            System.out.println("El pedido no se encontró");
        }
    }
    private void mostrarPedidosPendientes(){
        System.out.print("¿Cómo desea mostrar los pedidos pendientes de envío? 1-Filtrar Por cliente, 2-Mostrar todos: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        if(opcion == 1){
            System.out.print("Indique el NIF del cliente: ");
            String NIF = sc.nextLine();
            List<Pedido> lista = cp.getPedidosPendientesCliente(NIF);
            if(lista.isEmpty()){
                System.out.println("El cliente con el nif " + NIF + "no tiene pedidos pendientes" );
            }
            else {
                for (Pedido pedido : lista){
                    System.out.println(pedido);
                }
            }
        }else if(opcion == 2){
            List<Pedido> lista = cp.getTodosPedidosPendientes();
            if(lista.isEmpty()){
                System.out.println("No hay pedidos pendientes de envío");
            }
            else{
                for (Pedido pedido : lista){
                    System.out.println(pedido);
                }
            }
        }
    }
    private void mostrarPedidosEnviados(){
        System.out.print("¿Cómo desea mostrar los pedidos enviados? 1-Filtrar Por cliente, 2-Mostrar todos: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        if(opcion == 1){
            System.out.print("Indique el NIF del cliente: ");
            String NIF = sc.nextLine();
            List<Pedido> lista = cp.getTodosPedidosEnviadosCliente(NIF);
            if(lista.isEmpty()){
                System.out.print("El cliente con el nif " + NIF + " no tiene pedidos enviados");
            }
            else{
                for (Pedido pedido : lista){
                    System.out.println(pedido);
                }
            }
        }else if(opcion == 2){
            List<Pedido> lista = cp.getTodosPedidosEnviados();
            if(lista.isEmpty()){
                System.out.println("No hay pedidos enviados");
            }
            else{
                for (Pedido pedido : lista){
                    System.out.println(pedido);
                }
            }
        }
    }
}
