/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2teatro;

/**
 *
 * @author DarkB
 */
public class Taquillero extends EmpleadoDeTeatro{
    
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
    
}