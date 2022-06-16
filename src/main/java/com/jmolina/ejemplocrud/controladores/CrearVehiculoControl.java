/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmolina.ejemplocrud.controladores;

import com.jmolina.ejemplocrud.modelos.ModeloVehiculo;
import com.jmolina.ejemplocrud.util.Persistencia;
import com.jmolina.ejemplocrud.vistas.CrearVehiculoVista;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class CrearVehiculoControl {

    private CrearVehiculoVista vista;

    public CrearVehiculoControl() {
        init();
    }

    private void init() {
        vista = new CrearVehiculoVista();
          vista.getBtnCrear().addActionListener(action -> {///cuando crea un evento haga la accion
            try {
                if (crear(getVehiculo())) {
                    JOptionPane.showMessageDialog(vista, "Se creó vehiculo con exito", "Crear", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    throw new SQLException(".");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(vista, "Error al crar el vehiculo\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        vista.getBtnModificar().addActionListener(action ->{
            try {
                if(modificar(getVehiculo())){
                    JOptionPane.showMessageDialog(vista, "Se modifico el auto correctamente", "modificar",JOptionPane.INFORMATION_MESSAGE);
                    
                }else{
                    throw new SQLException(".");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(vista, "ERROR AL MODIFICAR VEHICULO\n" + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE );
            }
            
        });
                
      
        
        vista.getBtnEliminar().addActionListener(action ->{
            try {
                if(eliminar(getVehiculo())){
                    JOptionPane.showMessageDialog(vista,"Se Elimino vehiculo con exito", "Eliminar", JOptionPane.INFORMATION_MESSAGE );
                }else{
                     throw new SQLException(".");
                }
            } catch (Exception e) {
                     JOptionPane.showMessageDialog(vista, "Error al Eliminar el vehiculo\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        
        });
        vista.setVisible(true);
    }

    public CrearVehiculoVista getVista() {
        return vista;
    }
    
    

    private ModeloVehiculo getVehiculo() {
        ModeloVehiculo vehiculo;
        String xid = vista.getTxId().getText();
        Integer id = (xid == null || xid.isEmpty()) ? null : Integer.valueOf(xid);
        String placa = vista.getTxPlaca().getText();
        Integer modelo = Integer.valueOf(vista.getTxModelo().getText());
        String color = (String) vista.getCbColor().getSelectedItem();
        String marca = vista.getTxMarca().getText();
        vehiculo = new ModeloVehiculo(id, placa, modelo, color, marca);
        return vehiculo;
    }

    private boolean crear(ModeloVehiculo vehiculo) throws SQLException {
        boolean res = false;

        String sql = "INSERT INTO vehiculos(placa, modelo, color, marca)"
                + "VALUES ('" + vehiculo.getPlaca() + "',"
                + "'" + vehiculo.getModelo() + "',"
                + "'" + vehiculo.getColor() + "',"
                + "'" + vehiculo.getMarca() + "')";

        res = Persistencia.getInstancia().modificar(sql);

        return res;
    }
    
    public static boolean modificar(ModeloVehiculo vehiculo) throws SQLException{
      boolean res=false;
      
      String sql="UPDATE public.vehiculo SET placa='"+vehiculo.getPlaca()+"',"
              +"modelo='"+vehiculo.getModelo()+"',color='"+vehiculo.getColor()+"',"
              +"marca='"+vehiculo.getMarca()+"'"+"WHERE id='"+vehiculo.getId()+"'";
      res=Persistencia.getInstancia().modificar(sql);
      return res;
    }
    
    public static boolean eliminar(Integer id) throws SQLException{
      boolean res =false;
      
      String sql="DELETE from vehiculos where id="+id;
      res=Persistencia.getInstancia().modificar(sql);
      return res;
    }

}
