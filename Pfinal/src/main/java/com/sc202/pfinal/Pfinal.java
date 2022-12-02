/*EN TERMINOS GENERALES EL POGRAMA ESTA PLANEADO PARA TENER TRES ARREGLOS, DOS DE ELLOS UNIDEMENSIONALES (MARCA Y CATEGORIA) Y OTRO 
BIDIMENSIONAL QUE CONTIENE PRODUCTO Y TODOS LOS ATRIBUTOS DE ESTE OBJETO*/
package com.sc202.pfinal;

import javax.swing.JOptionPane;

/**
 *
 * @author DanGG
 */
public class Pfinal {

    public static void main(String[] args) {
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
                                /**/
                                /*Registrar producto almcenará todos los datos del inventario */
                                JOptionPane.showMessageDialog(null, "Registrar nuevos productos");
                                break;
                            case 2:
                                //CREA EL ARRREGLO QUE ALMACENARÁ LOS DATOS DE MARCAS, este arreglo es idependiente de arreglo de productos
                                JOptionPane.showMessageDialog(null, "Registrar una marca");                               
                                break;
                            case 3:
                                //CREA EL ARRREGLO QUE ALMACENARÁ LOS DATOS DE CATEGORIAS, este arreglo es idependiente de arreglo de productos
                                JOptionPane.showMessageDialog(null, "Registrar una categoría");                               
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
    
    
}
