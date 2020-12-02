/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2teatro;

public class EmpleadoDeTeatro extends Empleado {
    
    protected char categoria;
   
    public EmpleadoDeTeatro(){
        super();
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public EmpleadoDeTeatro(long id, String nombre, String apellidos, String nif, String direccion, String telefono, char categoria){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.categoria = categoria;
    }
    public EmpleadoDeTeatro(Empleado e, char categoria){
        super(e);
        this.categoria = categoria;
    }
    
}
