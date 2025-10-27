package com.tiendaonline.model;
// Clase
public abstract class Cliente {
    private String nombre;
    private String domicilio;
    private String nif;
    private String email;
    //Constructor
    public Cliente (String nombre, String domicilio, String nif, String email){
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.email = email;
    }
    //Getters
    public String getNombreClinete(){
        return nombre;
    }
    public String getDomicilioCliente(){
        return domicilio;
    }
    public String getNifCliente(){
        return nif;
    }
    public String getEmailCliente(){
        return email;
    }
    //Setters
    public void setNombreCliente(String nombre){
        this.nombre = nombre;
    }
    public void setDomicilioCliente(String domicilio){
        this.domicilio = domicilio;
    }
    public void setNifCliente(String nif){
        this.nif = nif;
    }
    public void setEmailCliente(String email){
        this.email = email;
    }
    @Override

    public String toString(){
        return "Cliente: {nombre: " + nombre + ", domicilio:  " + domicilio + ", nif: " + nif + ", email: " + email;
    }
}
