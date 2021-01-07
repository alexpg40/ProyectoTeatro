/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author DarkB
 */
public class Taquillero extends EmpleadoDeTeatro{
    
    //Los taquilleros generan unos beneficios de la venta de entrada
    private ArrayList<Beneficio> beneficio = new ArrayList<>();
    
   public Taquillero(){
       super();
   }
   
   public Taquillero(long id, String nombre, String apellidos, String nif, String direccion, String telefono, char categoria){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.categoria = categoria;
   }
   
   public Taquillero(Empleado e, char categoria, Nomina nomina){
       super(e, categoria, nomina);
   }
   
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + ", categoria" + categoria +'}';
    }

    public ArrayList<Beneficio> getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(ArrayList<Beneficio> beneficio) {
        this.beneficio = beneficio;
    } 
}
