package com.sc202.pfinal;

import javax.swing.JOptionPane;

/**
 *
 * @author DanGG
 */
public class Pfinal {

    public static void main(String[] args) {
        categoria[]ListaCategoria = new categoria[2];
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
    
    public static categoria[]llenarCategoria(categoria lista[]) {
        
        boolean v1 = false;
        
        for (int i = 0; i< lista.length; i++){
            if(lista[i] == null) {
               lista[i] = new categoria(); 
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
    
    public static void mostrarCategoria(categoria lista[]){
           String mensaje = "";
        
           for (int i = 0; i < lista.length; i++){
               if (lista[i] != null); {
               
               mensaje = mensaje + lista[i].getIdCategoria()+" "+lista[i].getNomCategoria()+ "\n";
           }
            
        }
        JOptionPane.showMessageDialog(null, mensaje, "GATEGORIA REGISTRADA", 1);
    }
}