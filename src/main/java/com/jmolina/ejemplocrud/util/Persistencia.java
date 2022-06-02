/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmolina.ejemplocrud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Persistencia {

    private static Persistencia instancia;

    private Connection connection;

    public static Persistencia getInstancia() {
        if (instancia == null) {
            instancia = new Persistencia();
        }
        return instancia;
    }

    public Persistencia() {
        Conectar();
    }

    private void Conectar() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/prueba", "postgres", "postgres");
            System.out.println("Connected to PostgreSQL database!");
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet consultar(String sql) {
        try ( Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean modificar(String sql) {
        boolean res = false;

        try ( Statement st = connection.createStatement()) {
            int resInt = st.executeUpdate(sql);
            if (resInt > 0) {
                res = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    public void cerrar() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
