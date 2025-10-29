/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author agust
 */
public class Postre extends Producto implements IVendible{
    
    private TipoPostre tipoPostre;

    public Postre( String nombre, double precio, Fabricante fabricante, TipoPostre tipoPostre) {
        super(nombre, precio, fabricante);
        this.tipoPostre = tipoPostre;
    }
    
    @Override
    public double getPrecioTotal(){
        double total = this.precio;
        switch(this.tipoPostre){
            case TIRAMISU:
                total += 0.20;
                break;
            case HELADO:
                total += 0.15;
                break;
            case FLAN:
                total += 0.10;
                break;
        }
        return total;
    }
  
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" - Postre - ");
        sb.append(" tipo de postre: ").append(this.tipoPostre);
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
        Postre otro = (Postre) obj;
        return this.tipoPostre == otro.tipoPostre;
    }
    
    
}
