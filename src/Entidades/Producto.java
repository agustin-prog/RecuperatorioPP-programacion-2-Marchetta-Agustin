/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author agust
 */
public abstract class Producto {
    
    protected String nombre;
    protected double precio;
    protected Fabricante fabricante;
    protected int calorias;
    protected int tiempoPreparacion;
    protected static Random generadorAleatorio;

    public Producto(String nombre, double precio, Fabricante fabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = fabricante;
        this.calorias = 0;
        this.tiempoPreparacion = 0;
    }
    
    public Producto(String nombre, double precio, String nombreFabricante, String ciudadFabricante, int antiguedadFabricante) {
        this(nombre, precio, new Fabricante(nombreFabricante, ciudadFabricante, antiguedadFabricante));
    }
    
    static{
        Producto.generadorAleatorio = new Random();
    }
    
    public int  getCalorias(){
        if(this.calorias == 0){
            this.calorias = Producto.generadorAleatorio.nextInt(200, 800 + 1);
        }
        return this.calorias;
    }
    
    public int getTiempoPreparacion(){
        if(this.tiempoPreparacion == 0){
            this.tiempoPreparacion = Producto.generadorAleatorio.nextInt(5, 20 + 1);
        }
        return this.tiempoPreparacion;
    }
    
    
     public static String mostrar(Producto p) {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto: ").append(p.nombre);
        sb.append(" - Precio base: ").append(p.precio);
        sb.append(" - Calorías: ").append(p.getCalorias());
        sb.append(" - Tiempo preparación: ").append(p.getTiempoPreparacion());
        sb.append(" - Fabricante: ").append(p.fabricante.toString());
        return sb.toString();
    }
    
    private static boolean sonIguales(Producto p1, Producto p2){
        return Objects.equals(p1.nombre, p2.nombre) && Fabricante.sonIguales(p1.fabricante, p2.fabricante);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Producto otro = (Producto) obj;
        return Producto.sonIguales(this, otro);
    }

    @Override
    public String toString() {
        return Producto.mostrar(this);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

