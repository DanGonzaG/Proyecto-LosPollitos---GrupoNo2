/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sc202.pfinal;

//import javax.swing.JOptionPane;
/**
 *
 * @author XPC
 */
class Marca {

    private String MarcaNombre;
    private int IdMarca;

    public Marca() {
        IdMarca = (int) (Math.random() * 300) + 200;
    }
    
    public int getIdMarca() {
        return IdMarca;
    }

    public String getMarcaNombre() {
        return MarcaNombre;
    }

    public void setMarcaNombre(String MarcaNombre) {
        this.MarcaNombre = MarcaNombre;
    }

}
