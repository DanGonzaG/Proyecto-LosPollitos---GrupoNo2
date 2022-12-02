/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sc202.pfinal;

/**
 *
 * @author DanGG
 */
public class Producto {
    private int idProducto;
    private String NombreProducto;
    private String NombreCategoria;
    private String NombreMarca;
    private int cantProducto;
    private int PrecioProducto;
    private Categoria categoria;
    
    public Producto (){
        idProducto = (int) (Math.random()*300+399);
    }
    

    /*public  llenar() {
        int salir = 2;
        int fila = 0;
        int col = 0;
        String lista[][] = new String[5][5];
        while (salir == 2) {
            lista[fila][col] = JOptionPane.showInputDialog("Digite el nombre del producto");
            salir = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para salir o 2 para continuar"));
            fila++;
        }
        return lista;
    }*/

    /*public Producto(String categoria[]) {
        String listaCategoria = "LISTA DE CATEGORIAS";
        for (int i = 0; i < categoria.length; i++) {
            listaCategoria = listaCategoria + categoria[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, listaCategoria);
    }*/

    /*public String [][] llenar2 (){
        String lista[][] = new String[2][2];
        for(int x = 0; x < 2; x++){
            for(int y = 0; y < 2; y++){
                lista[x][y] = JOptionPane.showInputDialog("Digite el nombre del producto");
            }
        }
    return lista;
    }*/

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }    

    public int getCantProducto() {
        return cantProducto;
    }

    public void setCantProducto(int cantProducto) {
        this.cantProducto = cantProducto;
    }

    public int getPrecioProducto() {
        return PrecioProducto;
    }

    public void setPrecioProducto(int PrecioProducto) {
        this.PrecioProducto = PrecioProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }

    public String getNombreMarca() {
        return NombreMarca;
    }

    public void setNombreMarca(String NombreMarca) {
        this.NombreMarca = NombreMarca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
