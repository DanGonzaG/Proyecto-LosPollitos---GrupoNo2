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

    private String nCategoria[];
    private String categoria;

    public String[] llenar() {
        int salir = 2;
        int cont = 0;
        String nCategoria[] = new String[10];

        while (salir == 2) {
            nCategoria[cont] = JOptionPane.showInputDialog(null, "DIGITE LA NUEVA CATEGORIA: ");
            cont += 1;
            salir = Integer.parseInt(JOptionPane.showInputDialog(null, "PARA SALIR DIGITE 1 PARA CONTINUAR DIGITE 2: "));
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(nCategoria[i]);
        }
        return nCategoria;
    }

    public String[] getnCategoria() {
        return nCategoria;
    }

    public void setnCategoria(String[] nCategoria) {
        this.nCategoria = nCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    

}
