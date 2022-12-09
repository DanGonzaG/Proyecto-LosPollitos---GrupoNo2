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

        Categoria[] ListaCategoria = new Categoria[2];
        Marca[] ListaMarca = new Marca[2];
        Producto[] Inventario = new Producto[2];

        String TempoActual;
        String TempoNuevo;
        
        boolean categoriaNueva = false;

        int continuar = 0;
        int opc0 = 0; //menú principal
        int opc1 = 0; // menú de registro
        int categoria = 0;//menú categorias

        while (opc0 != 5) {            
            opc0 = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opcion del menú"
                    + "\n1 Módulo Registro o Modificación"
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
                                + "\n1 Categorias"
                                + "\n2 Marcas"
                                + "\n3 Productos"
                                + "\n4 Regresar"));
                        switch (opc1) {
                            case 1:
                                categoria = 0;
                                while (categoria != 4) {                                    
                                    categoria = Integer.parseInt(JOptionPane.showInputDialog(null, "Categorias"
                                            + "\nSelecciones una opción de menú"
                                            + "\n1 Registrar categorias"
                                            + "\n2 Modificar una categoría"
                                            + "\n3 Mostrar Categorias registradas"
                                            + "\n4 Regresar"));
                                    switch (categoria) {
                                        case 1:
                                            JOptionPane.showMessageDialog(null, "Registrar una categoría");
                                            llenarCategoria(ListaCategoria);
                                            categoriaNueva = true;
                                            break;
                                        case 2:
                                            if (categoriaNueva == true){
                                            JOptionPane.showMessageDialog(null, "Modificación de categorias existentes");
                                            TempoActual = modificarCategoria1(ListaCategoria);
                                            TempoNuevo = modificarCategoria2(ListaCategoria, TempoActual);
                                            modificarCategoria3(TempoActual, TempoNuevo, ListaCategoria);
                                            modificarCategoria4(TempoActual, TempoNuevo, Inventario);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Primero debe de crear categorias", "ERROR", 0);
                                            }
                                            break;
                                        case 3:
                                            if (categoriaNueva == true){
                                            mostrarCategoria(ListaCategoria);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Primero debe de crear categorias", "ERROR", 0);
                                            }
                                            break;
                                        case 4:
                                            categoria = 4;
                                            break;
                                        default:
                                            
                                            JOptionPane.showMessageDialog(null, "Opción incorrecta", "ERROR", 0);                                           
                                    }
                                }
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Registrar una marca");
                                LlenarMarca(ListaMarca);
                                mostrarMarca(ListaMarca);
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Para registrar un producto:\nPrimero asigne la categoria\nSegundo asigne la marca\n"
                                        + "Ternero asigne el producto", "Registro de productos", 2);//Explica al usuario los pasos para crear un producto nuevo 
                                CrearProductos(CrearProductoCategoria(ListaCategoria), CrearProductoMarca(ListaMarca), Inventario);
                                break;
                            case 4:
                                opc1 = 4;
                                break;
                            default:
                                
                                JOptionPane.showMessageDialog(null, "Opción incorrecta", "ERROR", 0);
                        }
                    }
                    break;
                    
                case 2:
                    JOptionPane.showConfirmDialog(null, "Módulo Ingresa Mercadería");
                    ingresaMercaderia(Inventario);
                    break;
                    
                case 3:
                    JOptionPane.showConfirmDialog(null, "Módulo Editar precio");
                    editarPrecio(Inventario);
                    break;

                case 4:
                    JOptionPane.showConfirmDialog(null, "Módulo Ver inventario completo");
                    mostrarInventario(Inventario);
                    break;

                case 5:
                    opc0 = 5;                    
                    break;
                default:                    
                    JOptionPane.showMessageDialog(null, "Opción incorrecta", "ERROR", 0);
            }
        }

    }

    public static Categoria[] llenarCategoria(Categoria lista[]) {

        boolean v1 = false;

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                lista[i] = new Categoria();
                lista[i].setNomCategoria(JOptionPane.showInputDialog(null, "Nombre categoria", "REGRISTRO CATEGORIA", 1));
                v1 = true;
                i = lista.length;
            }
        }
        if (v1 == false) {
            JOptionPane.showMessageDialog(null, "NO HAY MAS ESPACIO", "ERROR", 0);

        } else if (v1 == false) {
            JOptionPane.showMessageDialog(null, "YA NO HAY ESPACIO PARA REGISTRAR NUEVAS CATEGORIAS", "ERROR", 0);
        }
        return lista;
    }

    public static String modificarCategoria1(Categoria lista[]) {//retorna la categoria actual        
        String tempoViejo = null;
        int codCate = 0;
        String mensaje = "";

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje = mensaje + lista[i].getIdCategoria() + " " + lista[i].getNomCategoria() + "\n";
            }
        }

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                JOptionPane.showMessageDialog(null, "La lista de categorias está vácia, primero debe de crear categorias", "ERROR", 0);
            } else {
                codCate = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione el código de la categoria a módificar\n" + mensaje, "Modificación de Categoria", -1));
            }

            for (int j = 0; j < lista.length; j++) {
                if (codCate == lista[j].getIdCategoria()) {
                    tempoViejo = lista[j].getNomCategoria();
                    break;
                }
            }
        }
        return tempoViejo;
    }

    public static String modificarCategoria2(Categoria lista[], String texto) { //retorna la categoria nueva
        String tempoNuevo = null;
        for (int j = 0; j < lista.length; j++) {
            if (texto.equalsIgnoreCase(lista[j].getNomCategoria())) {
                lista[j].setNomCategoria(JOptionPane.showInputDialog(null, lista[j].getNomCategoria() + " es el nombre actual de la categoria con el código "
                        + lista[j].getIdCategoria() + "\n¿Cual es el nombre a asignar?", "Modificación de Categoria", 3));
                tempoNuevo = lista[j].getNomCategoria();
                break;
            }
        }
        return tempoNuevo;
    }

    public static Categoria[] modificarCategoria3(String tempoActual, String tempoNuevo, Categoria lista[]) { //modifica el arreglo categoria
        for (int i = 0; i < lista.length; i++) {
            if (tempoActual.equalsIgnoreCase(lista[i].getNomCategoria())) {
                lista[i].setNomCategoria(tempoNuevo);
            }

        }
        return lista;
    }
    
    public static Producto [] modificarCategoria4 (String tempoActual, String tempoNuevo, Producto lista[]){
        for (int i = 0; i < lista.length; i++) {
            if (tempoActual.equals(lista[i].getNombreCategoria())){
                lista[i].setNombreCategoria(tempoNuevo);
            }
            
        }
    return lista;}

    public static void mostrarCategoria(Categoria lista[]) {
        String mensaje = "";

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje = mensaje + lista[i].getIdCategoria() + " " + lista[i].getNomCategoria() + "\n";
            }

        }
        JOptionPane.showMessageDialog(null, mensaje, "CATEGORIA REGISTRADA", 1);
    }

    public static Marca[] LlenarMarca(Marca lista[]) {
        boolean v2 = false;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                lista[i] = new Marca();
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

    public static void mostrarMarca(Marca lista[]) {
        String mensaje = "";
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje = mensaje + lista[i].getIdMarca() + "  " + lista[i].getMarcaNombre() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, mensaje, "MARCA REGISTRADA", 1);
    }

    //Se usa para asignar las categorias en el arreglo Producto
    public static String CrearProductoCategoria(Categoria lista[]) {
        String Tempo = "";

        boolean v1 = false;//se usa para el ciclo que comprueba si el codigo es correto
        int codCate = 0;
        String mensaje = "";
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje = mensaje + lista[i].getIdCategoria() + " " + lista[i].getNomCategoria() + "\n";
            }
        }

        while (v1 == false) {
            codCate = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione el código de la categoria\n" + mensaje, "Asignación de Categoria", -1));

            for (int i = 0; i < lista.length; i++) {
                if (codCate == lista[i].getIdCategoria()) {
                    v1 = true;
                    Tempo = lista[i].getNomCategoria();
                    break;
                }
            }
            if (v1 == false) {
                JOptionPane.showMessageDialog(null, "Código no coincide", "Error", 0);
            }
        }
        return Tempo;
    }

    public static String CrearProductoMarca(Marca lista[]) {
        String Tempo = "";

        boolean v1 = false;//se usa para el ciclo que comprueba si el codigo es correto
        int codMarca = 0;
        String mensaje = "";
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje = mensaje + lista[i].getIdMarca() + " " + lista[i].getMarcaNombre() + "\n";
            }
        }

        while (v1 == false) {
            codMarca = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione el código de la marca\n" + mensaje, "Asignación de Marca", -1));

            for (int i = 0; i < lista.length; i++) {
                if (codMarca == lista[i].getIdMarca()) {
                    v1 = true;
                    Tempo = lista[i].getMarcaNombre();
                    break;
                }
            }
            if (v1 == false) {
                JOptionPane.showMessageDialog(null, "Código no coincide", "Error", 0);
            }
        }
        return Tempo;
    }

    public static Producto[] CrearProductos(String categoria, String marca, Producto lista[]) {
        boolean v1 = false;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                lista[i] = new Producto();
                lista[i].setNombreCategoria(categoria);
                lista[i].setNombreMarca(marca);
                lista[i].setNombreProducto(JOptionPane.showInputDialog(null, "¿Cual es el nombre del producto a registrar?", "Nuevo Producto", 3));
                v1 = true;
                i = lista.length;
            }
        }
        if (v1 == true) {
            JOptionPane.showMessageDialog(null, "Producto agregado con exito", "Satisfactorio", 1);
        } else if (v1 == false) {
            JOptionPane.showMessageDialog(null, "Todos los registros se encuentran llenos", "Error", 0);
        }
        return lista;
    }

    //Métoo para mostar el inventario completo
    public static void mostrarInventario(Producto lista[]) {
        String mensaje = "INVENTARIO\n";
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje = mensaje + lista[i].getIdProducto() + "    " + lista[i].getNombreProducto() + "  " + lista[i].getNombreCategoria() + "  "
                        + lista[i].getNombreMarca() + "   " + lista[i].getCantProducto() + "   " + lista[i].getPrecioProducto() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, mensaje, "INVENTARIO", 1);
    }

    public static Producto[] editarPrecio(Producto lista[]) {
        boolean pr = false;
        String mensaje = "";
        int id = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje = mensaje + lista[i].getIdProducto() + " " + lista[i].getNombreProducto() + "\n";
            }
        }
        while (pr == false) {
            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digete el codigo del producto que desea cambiar\n" + mensaje, "EDITAR PRECIO", 3));
            for (int i = 0; i < lista.length; i++) {
                if (id == lista[i].getIdProducto()) {
                    pr = true;
                    lista[i].setPrecioProducto(Integer.parseInt(JOptionPane.showInputDialog(null, "Cual es el nuevo precio del producto", "EDITAR PRECIO", 3)));
                    JOptionPane.showMessageDialog(null, "Precio agregado con exito", "EDITAR PRECIO", 1);
                    break;
                }
            }
            if (pr == false) {
                JOptionPane.showMessageDialog(null, "El codigo no coincide", "ERROR", 0);
            }
        }
        return lista;
    }

    public static Producto[] ingresaMercaderia(Producto lista[]) {
        boolean mr = false;
        String mensaje = "";
        int id = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje = mensaje + lista[i].getIdProducto() + " " + lista[i].getNombreProducto() + "\n";
            }
        }
        while (mr == false) {
            id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digete el codigo del producto que desea cambiar\n" + mensaje, "INGRESAR MERCADERIA", 3));
            for (int i = 0; i < lista.length; i++) {
                if (id == lista[i].getIdProducto()) {
                    mr = true;
                    lista[i].setCantProducto(Integer.parseInt(JOptionPane.showInputDialog(null, "Cuanta mercaderia desea agregar", "INGRESAR MERCADERIA", 3)));
                    JOptionPane.showMessageDialog(null, "Mercaderia agregada con exito", "INGRESAR MERCADERIA", 1);
                    break;
                }
            }
            if (mr == false) {
                JOptionPane.showMessageDialog(null, "El codigo no coincide", "ERROR", 0);
            }
        }
        return lista;
    }
}
