/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author DarkB
 */
public class Empleado {
    
    protected long id;
    protected String nombre;
    protected String apellidos;
    protected String nif;
    protected String direccion;
    protected String telefono;
    protected Franquicia franquicia;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public Franquicia getFranquicia(){
        return franquicia;
    }
    
    public void setFranquicia(Franquicia franquicia){
        this.franquicia = franquicia;
    }
    
    public Empleado(){
        
    }
    
    public Empleado(long id, String nombre, String apellidos, String nif, String direccion, String telefono, Franquicia franquicia){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.franquicia = franquicia;
    }
    
    public Empleado(Empleado e){
        this.id = e.id;
        this.nombre = e.nombre;
        this.apellidos = e.apellidos;
        this.nif = e.nif;
        this.direccion = e.direccion;
        this.franquicia = e.franquicia;
    }

    public void comprobarId(long id){
        if (id <= 0) {
            System.out.println("La Id tiene que ser mayor estrictamente que 0");
        } else{
            if (id % 1 !=0) {
                System.out.println("La id tiene que ser un número entero");
            } else{
                for (Empleado Empleado : Utilidades.EMPLEADOS) {
                    if (id == Empleado.getId()) {
                        System.out.println("No se puede repetir la id");
                    } else{
                        return;
                    }
                }
            }
        }
    }
    
    public void comprobarNombre(String nombre){
        if (nombre.equals(" ")) {
            System.out.println("No puede estar vacio");
            return;
        } else{
            if (nombre.equals(null)) {
                System.out.println("No puede ser nulo");
                return;
            } else{
                //EN PROCESO NO FUNCIONA!
                if (nombre.contains(CharSequence.class.cast('1'))) {
                    System.out.println("No puede tener números");
                }
            }
        }
    }
    
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    
}
