/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.sc202.pfinal;

import javax.swing.JOptionPane;

/**
 *
 * @author DanGG
 */
public class Pfinal {

    public static void main(String[] args) {

        Categoria[]ListaCategoria = new Categoria[2];

        marca[] ListaMarca = new marca[2];

        int continuar = 0;
        int opc0 = 0; //menú principal
        int opc1 = 0; // menú de registro

        while (opc0 != 5) {
            opc0 = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opcion del menú"
                    + "\n1 Módulo Registro"
                    + "\n2 Módulo Ingresar Mercadería Nueva"
                    + "\n3 Módulo Editar Precio"
                    + "\n4 Módulo Ver Invetario"
                    + "\n5 Salir"));

            switch (opc0) {
                case 1:
                    opc1 = 0;
                    while (opc1 != 4) {
                        opc1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Módulo Registro"
                                + "\nSelecciones una opción de menú"
                                + "\n1 Registrar nuevos productos"
                                + "\n2 Registrar una marca"
                                + "\n3 Registrar una categoría"
                                + "\n4 Regresar"));
                        switch (opc1) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Registrar nuevos productos");
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Registrar una marca");
                                Llenar(ListaMarca);
                                mostrar(ListaMarca);
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Registrar una categoría");
                                llenarCategoria(ListaCategoria);
                                mostrarCategoria(ListaCategoria);
                                
                                break;
                            case 4:
                                opc1 = 4;
                                break;
                        }
                    }

                case 2:
                    JOptionPane.showConfirmDialog(null, "Módulo Ingresa Mercadería");
                    break;

                case 3:
                    JOptionPane.showConfirmDialog(null, "Módulo Editar precio");
                    break;

                case 4:
                    JOptionPane.showConfirmDialog(null, "Módulo Ver inventario completo");
                    break;

                case 5:
                    opc0 = 5;
                    //JOptionPane.showConfirmDialog(null, "Salir");
                    break;
            }
        }
        System.out.println("Hello World!");
    }

    
    public static Categoria[]llenarCategoria(Categoria lista[]) {
        
        boolean v1 = false;
        
        for (int i = 0; i< lista.length; i++){
            if(lista[i] == null) {
               lista[i] = new Categoria(); 
               lista[i].setNomCategoria(JOptionPane.showInputDialog(null, "Nombre categoria", "REGRISTRO CATEGORIA", 1));
               v1 = true;
               i = lista.length;
            }   
        }
        if (v1 == false){
            JOptionPane.showMessageDialog(null, "NO HAY MAS ESPACIO", "ERROR", 2);
            
        }
        else if (v1 ==false){
            JOptionPane.showMessageDialog(null, "YA NO HAY ESPACIO PARA REGISTRAR NUEVAS CATEGORIAS", "ERROR", 0);
        }
        return lista;
    }
    
    public static void mostrarCategoria(Categoria lista[]){
           String mensaje = "";
        
           for (int i = 0; i < lista.length; i++){
               if (lista[i] != null); {
               
               mensaje = mensaje + lista[i].getIdCategoria()+" "+lista[i].getNomCategoria()+ "\n";
           }
            
        }
        JOptionPane.showMessageDialog(null, mensaje, "GATEGORIA REGISTRADA", 1);
    }



    public static marca[] Llenar(marca lista[]) {
        boolean v2 = false;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                lista[i] = new marca();
                lista[i].setMarcaNombre(JOptionPane.showInputDialog(null, "Digite la nueva marca que desea registrar: ", "REGISTRO MARCA", 1));
                v2 = true;
                i = lista.length;
            }
        }
        if (v2 == true) {
            JOptionPane.showMessageDialog(null, "Marca registrada exitosamente", "REGISTRO MARCA", 1);
        } else if (v2 == false) {
            JOptionPane.showMessageDialog(null, "Ya no hay espacio para registrar mas marcas", "ERROR", 0);
        }
        return lista;
    }

    public static void mostrar(marca lista[]) {
        String mensaje = "";
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje = mensaje + lista[i].getIdMarca() + "  " + lista[i].getMarcaNombre() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, mensaje, "MARCA REGISTRADA", 1);
    }
}

