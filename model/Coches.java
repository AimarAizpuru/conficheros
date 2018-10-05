/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author aitor
 */

public class Coches {
        
    private String marca;
    private String modelo;
    private String matricula;
    private String color;
    
    
    public Coches(String marca, String modelo, String matricula, String color) { //derrigortuta nago, ezta? public jartzera beste pakete batetik sortuko dudalako?
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.color = color;
        
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo=modelo;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula=matricula;
    }

    public void setColor(String color) {
        this.color=color;
    }
    
    public String getColor() {
        return color;
    }
    
   
}