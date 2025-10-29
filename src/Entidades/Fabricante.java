/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author agust
 */
public class Fabricante {
    private String nombre;
    private String ciudad;
    private int antiguedad;

    public Fabricante(String nombre, String ciudad, int antiguedad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.antiguedad = antiguedad;
    }
    
    public static boolean sonIguales(Fabricante f1, Fabricante f2){
        if(f1.nombre == f2.nombre && f1.ciudad == f2.ciudad && f1.antiguedad == f2.antiguedad){
            return true;
        }
        return false;
    }
    
    private String getInfoFabricante(){
        return "Nombre: "+this.nombre+" - Ciudad: "+this.ciudad+" - Antiguedad: "+this.antiguedad;
    }

    @Override
    public String toString() {
        return "Fabricante - " + this.getInfoFabricante();
    }
    
    
}
