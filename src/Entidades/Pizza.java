/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author agust
 */
public class Pizza extends Producto implements IVendible{
    
    private TipoPizza sabor;
    private TamanoPizza tamano;

    public Pizza( String nombre, double precio, Fabricante fabricante, TipoPizza sabor, TamanoPizza tamano) {
        super(nombre, precio, fabricante);
        this.sabor = sabor;
        this.tamano = tamano;
    }

    @Override
    public double getPrecioTotal(){
        double total = this.precio;
        switch(this.tamano){
            case CHICA:
                total += 0.05;
                break;
            case MEDIANA:
                total += 0.20;
                break;
            case GRANDE:
                total += 0.10;
                break;
        }
        return total;
    }
  
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" - Pizza - ");
        sb.append(" sabor: ").append(this.sabor);
        sb.append(" - tamanio: ").append(this.tamano);
        sb.append(" - precio: ").append(this.getPrecioTotal());
        return sb.toString();
    }


    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pizza otro = (Pizza) obj;
        return this.tamano == otro.tamano && this.sabor == otro.sabor;
    }
    
    
}
