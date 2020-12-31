/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class EmpleadoDeTeatro extends Empleado {
    
    protected char categoria;
    //Cada empleado de teatro tiene una nomina que es calculada por secretario y revisada por direccion
    private Nomina nomina;
   
    public EmpleadoDeTeatro(){
        super();
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public Nomina getNomina() {
        return nomina;
    }

    public void setNomina(Nomina nomina) {
        this.nomina = nomina;
    }

    public EmpleadoDeTeatro(long id, String nombre, String apellidos, String nif, String direccion, String telefono, char categoria, Nomina nomina){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.categoria = categoria;
        this.nomina = nomina;
    }
    public EmpleadoDeTeatro(Empleado e, char categoria, Nomina nomina){
        super(e);
        this.categoria = categoria;
        this.nomina = nomina;
    }
    
    public void comprobarCategoria(char categoria){
        if (categoria != 'A' && categoria !='B' && categoria !='C' && categoria !='D') {
            System.out.println("La categoria solo puede ser A, B, C o D");
        }
    }
    
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + ", categoria" + categoria +'}';
    }
}
