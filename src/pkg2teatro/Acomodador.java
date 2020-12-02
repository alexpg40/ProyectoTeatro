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
public class Acomodador extends EmpleadoDeTeatro{
    
    public Acomodador(){
        super();
    }
    
    public Acomodador(long id, String nombre, String apellidos, String nif, String direccion, String telefono, char categoria){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + ", categoria" + categoria +'}';
    }
}
