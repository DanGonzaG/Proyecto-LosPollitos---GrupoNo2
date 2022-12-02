/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sc202.pfinal;

import javax.swing.JOptionPane;

/**
 *
 * @author familia barquero alv
 */
public class Categoria {
    
    private String NomCategoria ;
    private int IdCategoria ;

    public Categoria() {
        this.IdCategoria = (int)(Math.random()* 200 + 299);
    }

    public String getNomCategoria() {
        return NomCategoria;
    }

    public void setNomCategoria(String NomCategoria) {
        this.NomCategoria = NomCategoria;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    } 
}