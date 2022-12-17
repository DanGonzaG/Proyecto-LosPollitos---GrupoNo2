/*El programa trabaja por medio de tres arreglos en uno se almecenan los datos del objeto categoria, otro los datos de marca y el último los datos de producto.
Los arreglos de marca y categoria esta relacionados con el arreglo producto por lo que cualquien modificación del cualquiera de los anteriores tambien será cambiado en 
arreglo producto.
 */
package com.sc202.pfinal;

import javax.swing.JOptionPane;

/**
 *
 * @author DanGG
 */
public class Pfinal {

    public static void main(String[] args) {

        /*Se crean los tres arreglos de objetos*/
        Categoria[] ListaCategoria = new Categoria[2];
        Marca[] ListaMarca = new Marca[2];
        Producto[] Inventario = new Producto[2];

        /*Variables que se usan para almacenar temporamente cualquien dato se modifique en el arreglo categoria y marca*/
        String TempoActual;
        String TempoNuevo;

        /*Variables para validar que cuales métodos pueden ser llamados y cuales no*/
        boolean categoriaNueva = false;
        boolean marcaNueva = false;
        boolean nuevoProducto = false;

        /*Variable booleanas para evitar que el programa de error cuando se intruducen datos erroneos en el menú*/
        boolean menu0;

        int opc0 = 0; //menú principal
        int opc1 = 0; // menú de registro
        int categoria = 0;//menú categorias
        int marca = 0;//menú marcas
        int producto = 0; //menú productos

        while (opc0 != 5) {
            menu0 = false;
            while (menu0 == false) {
                try {
                    opc0 = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione una opcion del menú"
                            + "\n1 Módulo Registro / Modificación"
                            + "\n2 Módulo Ingresar Mercadería Nueva"
                            + "\n3 Módulo Editar Precio"
                            + "\n4 Módulo Ver Invetario"
                            + "\n5 Salir", "Menú Principal", -1));
                    menu0 = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros", "ERROR", 0);
                    menu0 = false;
                }
            }
            switch (opc0) {
                case 1:
                    opc1 = 0;
                    while (opc1 != 4) {
                        menu0 = false;
                        while (menu0 == false) {
                            try {
                                opc1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione una opción de menú"
                                        + "\n1 Categorias"
                                        + "\n2 Marcas"
                                        + "\n3 Productos"
                                        + "\n4 Regresar", "REGISTRO Y MODIFICACION", -1));
                                menu0 = true;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros", "ERROR", 0);
                                menu0 = false;
                            }
                        }

                        switch (opc1) {
                            case 1:
                                categoria = 0;
                                while (categoria != 4) {
                                    menu0 = false;
                                    while (menu0 == false) {
                                        try {
                                            categoria = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecciones una opción de menú"
                                                    + "\n1 Registrar categorias"
                                                    + "\n2 Modificar una categoría"
                                                    + "\n3 Mostrar Categorias registradas"
                                                    + "\n4 Regresar", "CATEGORIAS", -1));
                                            menu0 = true;
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros", "ERROR", 0);
                                            menu0 = false;
                                        }
                                    }
                                    switch (categoria) {
                                        case 1:
                                            llenarCategoria(ListaCategoria);
                                            categoriaNueva = true;
                                            break;
                                        case 2:
                                            if (categoriaNueva == true) {
                                                TempoActual = modificarCategoria1(ListaCategoria);
                                                if (TempoActual != null) {
                                                    TempoNuevo = modificarCategoria2(ListaCategoria, TempoActual);
                                                    modificarCategoria3(TempoActual, TempoNuevo, ListaCategoria);
                                                    if (nuevoProducto == true) {
                                                        modificarCategoria4(TempoActual, TempoNuevo, Inventario);
                                                    }
                                                }

                                            } else {
                                                JOptionPane.showMessageDialog(null, "Primero debe de crear categorias", "ERROR", 0);
                                            }
                                            break;
                                        case 3:
                                            if (categoriaNueva == true) {
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
                                marca = 0;
                                while (marca != 4) {
                                    menu0 = false;
                                    while (menu0 == false) {
                                        try {
                                            marca = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecciones una opción de menú"
                                                    + "\n1 Registrar Marcas"
                                                    + "\n2 Modificar una Marca"
                                                    + "\n3 Mostrar Marcas Registradas"
                                                    + "\n4 Regresar", "MARCAS", -1));
                                            menu0 = true;
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros", "ERROR", 0);
                                            menu0 = false;
                                        }
                                    }
                                    switch (marca) {
                                        case 1:
                                            LlenarMarca(ListaMarca);
                                            marcaNueva = true;
                                            break;
                                        case 2:
                                            if (marcaNueva == true) {
                                                TempoActual = modificarMarca1(ListaMarca);
                                                if (TempoActual != null) {
                                                    TempoNuevo = modificarMarca2(ListaMarca, TempoActual);
                                                    modificarMarca3(TempoActual, TempoNuevo, ListaMarca);
                                                    if (nuevoProducto == true) {
                                                        modificarMarca4(TempoActual, TempoNuevo, Inventario);
                                                    }
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Primero debe de crear marcas", "ERROR", 0);
                                            }
                                            break;
                                        case 3:
                                            if (marcaNueva == true) {
                                                mostrarMarca(ListaMarca);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Primero debe de crear marcas", "ERROR", 0);
                                            }
                                            break;
                                        case 4:
                                            marca = 4;
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Opción incorrecta", "ERROR", 0);
                                    }
                                }
                                break;
                            case 3:

                                producto = 0;
                                while (producto != 4) {
                                    menu0 = false;
                                    while (menu0 == false) {
                                        try {
                                            producto = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecciones una opción de menú"
                                                    + "\n1 Registrar Productos"
                                                    + "\n2 Modificar un Producto"
                                                    + "\n3 Mostrar Productos Registrados"
                                                    + "\n4 Regresar", "PRODUCTOS", -1));
                                            menu0 = true;
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros", "ERROR", 0);
                                            menu0 = false;
                                        }
                                    }
                                    switch (producto) {
                                        case 1:
                                            if (categoriaNueva == false && marcaNueva == false) {
                                                JOptionPane.showMessageDialog(null, "Antes de agregar un producto debe crear categorias y marcas", "INFORMACION FALTANTE", 2);
                                            } else if (categoriaNueva == false && marcaNueva == true) {
                                                JOptionPane.showMessageDialog(null, "Falta crear Categorias", "INFORMACION FALTANTE", 2);
                                            } else if (categoriaNueva == true && marcaNueva == false) {
                                                JOptionPane.showMessageDialog(null, "Falta crear Marcas", "INFORMACION FALTANTE", 2);
                                            } else if (categoriaNueva == true && marcaNueva == true) {
                                                JOptionPane.showMessageDialog(null, "Para registrar un producto:\nPrimero asigne la categoria\nSegundo asigne la marca\n"
                                                        + "Tercero asigne el producto", "Registro de productos", 2);//Explica al usuario los pasos para crear un producto nuevo 
                                                CrearProductos(CrearProductoCategoria(ListaCategoria), CrearProductoMarca(ListaMarca), Inventario);
                                                nuevoProducto = true;
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Opción incorrecta", "ERROR", 0);
                                            }
                                            break;
                                        case 2:
                                            if (nuevoProducto == true) {
                                                modificarProductos(Inventario);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Falta crear Productos", "INFORMACION FALTANTE", 2);
                                            }
                                            break;
                                        case 3:
                                            if (nuevoProducto == true) {
                                                mostarProductos(Inventario);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Falta crear Productos", "INFORMACION FALTANTE", 2);
                                            }
                                            break;
                                        case 4:
                                            producto = 4;
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Opción incorrecta", "ERROR", 0);
                                    }
                                }
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
                    if (nuevoProducto == true) {
                        ingresaMercaderia(Inventario);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de Registrar Productos", "INFORMACION FALTANTE", 2);
                    }
                    break;
                case 3:
                    if (nuevoProducto == true) {
                        editarPrecio(Inventario);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de Registrar Productos", "INFORMACION FALTANTE", 2);
                    }
                    break;
                case 4:
                    if (nuevoProducto == true) {
                        mostrarInventario(Inventario);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de Registrar Productos", "INFORMACION FALTANTE", 2);
                    }
                    break;
                case 5:
                    opc0 = 5;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción incorrecta", "ERROR", 0);
            }
        }

    }

    /*---------------------------------------------------------METODOS PARA CATEGORIA-----------------------------------------------------------------------------------------------*/
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

    /*Este método muestra los datos de arreglo categoria, socilita el código y despues retorna para ser alcenado en la variable tempoActual en el main*/
    public static String modificarCategoria1(Categoria lista[]) {//retorna la categoria actual 
        boolean menu0 = false;
        boolean v1 = false;
        int cont = 0;
        String tempoViejo = null;
        int codCate = 0;
        String mensaje = "";

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje = mensaje + lista[i].getIdCategoria() + " " + lista[i].getNomCategoria() + "\n";
            }
        }

        while (menu0 == false) {
            try {
                codCate = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione el código de la categoria a módificar\n" + mensaje, "Modificación de Categoria", -1));
                menu0 = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros", "ERROR", 0);
                menu0 = false;
            }
        }
        for (int j = 0; j < lista.length; j++) {
            if (lista[j] != null) {
                if (codCate == lista[j].getIdCategoria()) {
                    tempoViejo = lista[j].getNomCategoria();
                    v1 = true;
                    break;
                } else {
                    v1 = false;

                }
            }
        }
        if (v1 == false) {
            JOptionPane.showMessageDialog(null, "Ingreso un código erroneo", "ERROR", 0);
        }
        return tempoViejo;
    }

    /*Utiliza como parametro la variable tempoActual para buscar en el arreglo categoria el nombre, una ves encontrado se le solicita al usuario modificarlo
    y retorna como valor el nuevo nombre que se almacena en la variable tempoNuevo*/
    public static String modificarCategoria2(Categoria lista[], String texto) {
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

    /*Utiliza como parametros las variables tempoActual, tempoNuevo y arreglo Categoria con estos se validad que lel nombre actual se encuentre el arrelo y despues 
    ya ubicado se modifica con los datos de tempoNuevo*/
    public static Categoria[] modificarCategoria3(String tempoActual, String tempoNuevo, Categoria lista[]) { //modifica el arreglo categoria
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                if (tempoActual.equalsIgnoreCase(lista[i].getNomCategoria())) {
                    lista[i].setNomCategoria(tempoNuevo);
                }
            }

        }
        return lista;
    }

    //Método que módifica el arreglo producto de manera simultanea
    public static Producto[] modificarCategoria4(String tempoActual, String tempoNuevo, Producto lista[]) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                if (tempoActual.equals(lista[i].getNombreCategoria())) {
                    lista[i].setNombreCategoria(tempoNuevo);
                }
            }

        }
        return lista;
    }

    public static void mostrarCategoria(Categoria lista[]) {
        String mensaje = "";

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje = mensaje + lista[i].getIdCategoria() + " " + lista[i].getNomCategoria() + "\n";
            }

        }
        JOptionPane.showMessageDialog(null, mensaje, "CATEGORIA REGISTRADA", 1);
    }

    /*---------------------------------------------------------METODOS PARA MARCA-----------------------------------------------------------------------------------------------*/
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

    /*Muestra el arreglo y solicita al usuario que el digite el codigo identificador, una vez ingresado si recorre el arrelo y se almacena el nombre de 
    la marca en la variable tempoViejo y esta se retorna a main*/
    public static String modificarMarca1(Marca lista[]) {//retorna la marca actual que esta en el arreglo 
        boolean v1 = false;
        int cont = 0;
        String tempoViejo = null;
        int codMarca = 0;
        String mensaje = "";

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje = mensaje + lista[i].getIdMarca() + " " + lista[i].getMarcaNombre() + "\n";
            }
        }

        boolean menu0 = false;
        while (menu0 == false) {
            try {
                codMarca = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione el código de la marca a módificar\n" + mensaje, "Modificación de Marcas", -1));
                menu0 = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros", "ERROR", 0);
                menu0 = false;
            }
        }
        for (int j = 0; j < lista.length; j++) {
            if (lista[j] != null) {
                if (codMarca == lista[j].getIdMarca()) {
                    tempoViejo = lista[j].getMarcaNombre();
                    v1 = true;
                    break;
                } else {
                    v1 = false;
                }
            }
        }
        if (v1 == false) {
            JOptionPane.showMessageDialog(null, "Ingreso un código erroneo", "ERROR", 0);
        }

        return tempoViejo;
    }

    /*Utiliza como parametro la variable tempoActual para buscar en el arreglo Marca el nombre, una ves encontrado se le solicita al usuario modificarlo
    y retorna como valor el nuevo nombre que se almacena en la variable tempoNuevo*/
    public static String modificarMarca2(Marca lista[], String texto) { //retorna la marca nueva a variable en main
        String tempoNuevo = null;
        for (int j = 0; j < lista.length; j++) {
            if (texto.equalsIgnoreCase(lista[j].getMarcaNombre())) {
                lista[j].setMarcaNombre(JOptionPane.showInputDialog(null, lista[j].getMarcaNombre() + " es el nombre actual de la categoria con el código "
                        + lista[j].getIdMarca() + "\n¿Cual es el nombre a asignar?", "Modificación de Categoria", 3));
                tempoNuevo = lista[j].getMarcaNombre();
                break;
            }
        }
        return tempoNuevo;
    }

    /*Utiliza como parametros las variables tempoActual, tempoNuevo y arreglo Marcar con estos se validad que lel nombre actual se encuentre el arrelo y despues 
    ya ubicado se modifica con los datos de tempoNuevo*/
    public static Marca[] modificarMarca3(String tempoActual, String tempoNuevo, Marca lista[]) { //modifica el arreglo categoria
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                if (tempoActual.equalsIgnoreCase(lista[i].getMarcaNombre())) {
                    lista[i].setMarcaNombre(tempoNuevo);
                }
            }

        }
        return lista;
    }

    //Método que módifica el arreglo producto de manera simultanea
    public static Producto[] modificarMarca4(String tempoActual, String tempoNuevo, Producto lista[]) {//modifica todas las marcas en el arreglo producto
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                if (tempoActual.equals(lista[i].getNombreMarca())) {
                    lista[i].setNombreMarca(tempoNuevo);
                }
            }

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

    /*---------------------------------------------------------METODOS PARA PRODUCTOS-----------------------------------------------------------------------------------------------*/
    //Se usa para asignar las categorias en el arreglo Producto
    public static String CrearProductoCategoria(Categoria lista[]) {
        String Tempo = "";
        boolean menu0;

        boolean v1 = false;//se usa para el ciclo que comprueba si el codigo es correto
        int codCate = 0;
        String mensaje = "";
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje = mensaje + lista[i].getIdCategoria() + " " + lista[i].getNomCategoria() + "\n";
            }
        }

        while (v1 == false) {
            menu0 = false;
            while (menu0 == false) {
                try {
                    codCate = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione el código de la categoria\n" + mensaje, "Asignación de Categoria", -1));
                    menu0 = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros", "ERROR", 0);
                    menu0 = false;
                }
            }
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

    //Se usa para asignar la marca en el arreglo Producto
    public static String CrearProductoMarca(Marca lista[]) {
        String Tempo = "";
        boolean menu0;
        boolean v1 = false;//se usa para el ciclo que comprueba si el codigo es correto
        int codMarca = 0;
        String mensaje = "";
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje = mensaje + lista[i].getIdMarca() + " " + lista[i].getMarcaNombre() + "\n";
            }
        }

        while (v1 == false) {
            menu0 = false;
            while (menu0 == false) {
                try {
                    codMarca = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione el código de la marca\n" + mensaje, "Asignación de Marca", -1));
                    menu0 = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros", "ERROR", 0);
                    menu0 = false;
                }
            }
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

    /*Utiliza como parametros los datos retornados de los métodos CrearProductoCategoria y CrearProductoMarca, además del arreglo Producto con todos estos datos solicita
    el nombre del nuevo producto y lo agrega al arreglo junto con los otros datos*/
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

    /*Muestra solamente el nombre y id de arreglo producto*/
    public static void mostarProductos(Producto lista[]) {
        String mensaje = "";
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje = mensaje + lista[i].toString()+"\n";
            }

        }
        JOptionPane.showMessageDialog(null, mensaje, "PRODUCTOS REGISTRADOS", 1);
    }

    public static Producto[] modificarProductos(Producto lista[]) {
        boolean menu0 = false;
        boolean v1 = false;
        int codProducto = 0;
        String mensaje = "";
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje = mensaje + lista[i].toString()+"\n";
            }
        }
        while (menu0 == false) {
            try {
                codProducto = Integer.parseInt(JOptionPane.showInputDialog(null, "Seleccione el código del producto a módificar\n" + mensaje, "Modificación de Producto", -1));
                menu0 = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros", "ERROR", 0);
                menu0 = false;
            }
        }
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].getIdProducto() == codProducto) {
                lista[i].setNombreProducto(JOptionPane.showInputDialog(null, "El nombre actual del producto es" + lista[i].getNombreProducto()
                        + ", ¿Por cual desea cambiarlo?", "MODIFICAR PRODUCTO", 3));
                v1 = true;
                break;

            }
        }
        if (v1 == true) {
            JOptionPane.showMessageDialog(null, "Producto modificado con éxito", "MODIFICACIÓN DE PRODUCTOS", 1);
        } else {
            JOptionPane.showMessageDialog(null, "No se modifico el producto", "ERROR", 0);
        }

        return lista;
    }

    /*---------------------------------------------------------METODO MOSTRAR INVENTARIO COMPLETO-----------------------------------------------------------------------------------------------*/
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

    /*---------------------------------------------------------METODOS PARA EDITAR PRECIO-----------------------------------------------------------------------------------------------*/
    public static Producto[] editarPrecio(Producto lista[]) {
        boolean menu0;
        boolean pr = false;
        String mensaje = "";
        int id = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje = mensaje + lista[i].getIdProducto() + " " + lista[i].getNombreProducto() + "\n";
            }
        }
        while (pr == false) {
            menu0 = false;
            while (menu0 == false) {
                try {
                    id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digete el codigo del producto que desea cambiar\n" + mensaje, "EDITAR PRECIO", 3));
                    menu0 = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros", "ERROR", 0);
                    menu0 = false;
                }
            }
            for (int i = 0; i < lista.length; i++) {
                if (id == lista[i].getIdProducto()) {
                    pr = true;
                    lista[i].setPrecioProducto(Integer.parseInt(JOptionPane.showInputDialog(null, "Cual es el nuevo precio del producto 5" 
                            + lista[i].getNombreProducto(), "EDITAR PRECIO", 3)));
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

    /*---------------------------------------------------------METODOS PARA INGRESAR MERCADERIA----------------------------------------------------------------------------------------------*/
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
            boolean menu0 = false;
            while (menu0 == false) {
                try {
                    id = Integer.parseInt(JOptionPane.showInputDialog(null, "Digete el codigo del producto\n" + mensaje, "INGRESAR MERCADERIA", 3));
                    menu0 = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros", "ERROR", 0);
                    menu0 = false;
                }
            }

            for (int i = 0; i < lista.length; i++) {
                if (id == lista[i].getIdProducto()) {
                    mr = true;
                    lista[i].setCantProducto(Integer.parseInt(JOptionPane.showInputDialog(null, "Cuanta mercaderia desea agregar para el producto " + lista[i].getNombreProducto(),
                            "INGRESAR MERCADERIA", 3)));
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
