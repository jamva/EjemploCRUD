/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmolina.ejemplocrud.modelos;

/**
 *
 * @author Usuario
 */
public class ModeloUsuario {
    private Integer id;
    private String email;
    private String nombre;
    private String clave;

    public ModeloUsuario(Integer id, String email, String nombre, String clave) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.clave = clave;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "ModeloUsuario{" + "id=" + id + ", email=" + email + ", nombre=" + nombre + ", clave=" + clave + '}';
    }

    
}
