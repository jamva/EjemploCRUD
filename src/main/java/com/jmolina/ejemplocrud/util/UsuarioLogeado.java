/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmolina.ejemplocrud.util;

import com.jmolina.ejemplocrud.modelos.ModeloUsuario;

/**
 *
 * @author Usuario
 */
public class UsuarioLogeado {

    private static ModeloUsuario usuario;

    public static ModeloUsuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(ModeloUsuario usuario) {
        UsuarioLogeado.usuario = usuario;
    }
    
    
}
