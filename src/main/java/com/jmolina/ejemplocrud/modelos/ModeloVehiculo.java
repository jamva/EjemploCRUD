/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmolina.ejemplocrud.modelos;

import java.awt.Color;

/**
 *
 * @author Usuario
 */
public class ModeloVehiculo {
    private Integer id;
    private String placa;
    private Integer modelo;
    private String color; 
    private String marca;

    public ModeloVehiculo(Integer id, String placa, Integer modelo, String color, String marca) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.color = color;
        this.marca = marca;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "ModeloVehiculo{" + "id=" + id + ", placa=" + placa + ", modelo=" + modelo + ", color=" + color + ", marca=" + marca + '}';
    }

    
}
