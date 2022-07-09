package com.fmacha.final_firebase;

public class usuarios {
    private int id;
    private String nombre;
    private String apllido;
    private String email;
    private String telefono;


    public usuarios(String nombre, String apllido, String email, String telefono) {

        this.nombre = nombre;
        this.apllido = apllido;
        this.email = email;
        this.telefono = telefono;
    }

    public usuarios(int id, String nombre, String apllido, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apllido = apllido;
        this.email = email;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApllido() {
        return apllido;
    }

    public void setApllido(String apllido) {
        this.apllido = apllido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}



