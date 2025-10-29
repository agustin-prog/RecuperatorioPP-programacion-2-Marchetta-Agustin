/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author agust
 */
public class Pizzeria implements Iterable<Producto> {
    
    private String nombre;
    private int capacidad;
    private Collection<Producto> productos;

    public Pizzeria(String nombre) {
        this.nombre = nombre;
        this.capacidad = 3;
        this.productos = new ArrayList<>();
    }

    public Pizzeria(String nombre, int capacidad) {
        this(nombre);
        this.capacidad = capacidad;
    }
    
    
    private boolean sonIguales(Producto producto){
        for(Producto pr : this.productos){
            if(pr.equals(producto)){
                return true;
            }
        }
        return false;
    }
    
    public void agregar(Producto p){
        if(this.capacidad == this.productos.size()){
            System.out.println("La capacidad ya esta al maximo");
            return;
        }
        if(this.sonIguales(p)){
             System.out.println("El producto: "+ p.nombre+" ya existe en la heladeria");
            return;
        }
        this.productos.add(p);
         System.out.println("El producto: "+ p.nombre+" fue agregado correctamente");
    }
    
    
     private double getPrecioProductos(TipoProducto t){
        double total = 0;
        for(Producto p : this.productos){
            switch(t){
                case PIZZAS:
                    if(p instanceof Pizza h){
                        total += h.getPrecioTotal();
                    }
                    break;
                case POSTRES:
                    if(p instanceof Postre po){
                        total += po.getPrecioTotal();
                    }
                    break;
                case TODOS:
                    total += ((IVendible) p).getPrecioTotal();
                    break;
            }
        }
        return total;
    }
    
    private double getPrecioDePizzas(){
        return this.getPrecioProductos(TipoProducto.PIZZAS);
    }
    
    private double getPrecioDePostres(){
        return this.getPrecioProductos(TipoProducto.POSTRES);
    }
    
    private double getPrecioTotal(){
        return this.getPrecioProductos(TipoProducto.TODOS);
    }
    
    @Override
    public Iterator<Producto> iterator() {
        return productos.iterator();
    }
    
       @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" - Pizzeria ").append(this.nombre);
        sb.append(" - capacidad de productos: ").append(this.capacidad);
        sb.append(" - cantidad de productos almacenados: ").append(this.productos.size());
        for(Producto producto : this.productos){
        sb.append(" - producto: ").append(producto.toString());
        }
        sb.append(" - Precio Total Pizzas: ").append(this.getPrecioDePizzas());
        sb.append(" - Precio Total Postres: ").append(this.getPrecioDePostres());
        sb.append(" - Precio Total: ").append(this.getPrecioTotal());
        return sb.toString();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
