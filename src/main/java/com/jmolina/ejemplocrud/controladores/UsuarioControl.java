/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmolina.ejemplocrud.controladores;

import com.jmolina.ejemplocrud.modelos.ModeloUsuario;
import com.jmolina.ejemplocrud.util.Persistencia;
import com.jmolina.ejemplocrud.vistas.DialogoCrearUsuario;
import com.jmolina.ejemplocrud.vistas.UsuarioLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class UsuarioControl {

    public UsuarioControl() {
        init();
    }

    private void init() {
        UsuarioLogin ul = new UsuarioLogin();

        ul.getOpCrearUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogoCrearUsuario dlgUsuario = new DialogoCrearUsuario(ul, true);
                dlgUsuario.setVisible(true);
            }
        });       

        ul.setVisible(true);
    }

    public static boolean crear(ModeloUsuario usuario) {
        boolean res = false;

        String sql = "INSERT INTO usuarios(email, nombre, clave)"
                + "VALUES ('" + usuario.getEmail() + "',"
                + "'" + usuario.getNombre() + "',"
                + "'" + usuario.getClave() + "')";

        res = Persistencia.getInstancia().modificar(sql);

        return res;
    }

    private ModeloUsuario consultarPorEmail(String email) {
        ModeloUsuario usuario = null;

        String sql = "select * from usuarios where email='" + email + "'";

        try ( ResultSet rs = Persistencia.getInstancia().consultar(sql)) {
            if (rs.next()) {
                usuario = new ModeloUsuario(rs.getInt("id"), rs.getString("email"), rs.getString("nombre"), rs.getString("clave"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

    private List<ModeloUsuario> consultarTodos() {
        List<ModeloUsuario> lista = new ArrayList<>();

        String sql = "select * from usuarios";

        try ( ResultSet rs = Persistencia.getInstancia().consultar(sql)) {
            while (rs.next()) {
                ModeloUsuario usuario = new ModeloUsuario(rs.getInt("id"), rs.getString("email"), rs.getString("nombre"), rs.getString("clave"));
                lista.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    private boolean modificar(ModeloUsuario usuario) {
        boolean res = false;

        String sql = "UPDATE public.usuarios SET email='" + usuario.getEmail() + "', "
                + "nombre='" + usuario.getNombre() + "', clave='" + usuario.getClave() + "'"
                + " WHERE id='" + usuario.getId() + "'";

        res = Persistencia.getInstancia().modificar(sql);

        return res;
    }

    private ModeloUsuario login(ModeloUsuario usuario) {

        String sql = "select * from usaurios where email='" + usuario.getEmail() + "' and clave='" + usuario.getClave() + "'";

        try ( ResultSet rs = Persistencia.getInstancia().consultar(sql)) {
            if (rs.next()) {
                usuario = new ModeloUsuario(rs.getInt("id"), rs.getString("email"), rs.getString("nombre"), rs.getString("clave"));
            } else {
                usuario = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

}
