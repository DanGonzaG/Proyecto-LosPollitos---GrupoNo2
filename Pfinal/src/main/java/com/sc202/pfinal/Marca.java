/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sc202.pfinal;

import javax.swing.JOptionPane;

/**
 *
 * @author XPC
 */
class marca {

    private String nMarca[];

    public String[] Llenar() {
        int salir = 2;
        int cont = 0;
        String nMarca[] = new String[10];

        while (salir == 2) {
            nMarca[cont] = JOptionPane.showInputDialog(null, "Digite la nueva marca que desea registrar: ");
            cont += 1;
            salir = Integer.parseInt(JOptionPane.showInputDialog(null, "Para salir digite 1 para continuar registrando digite 2"));
        }
        return nMarca;
    }

    public void mostrar(String nMarca[]) {
        for (int i = 0; i < 10; i++) {
            System.out.print(nMarca[i]);
        }
    }

    public String[] getnMarca() {
        return nMarca;
    }

    public void setnMarca(String[] nMarca) {
        this.nMarca = nMarca;
    }
}
