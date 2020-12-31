/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Scanner;

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

    public Franquicia getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }

    public Empleado() {

    }

    public Empleado(long id, String nombre, String apellidos, String nif, String direccion, String telefono, Franquicia franquicia) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.franquicia = franquicia;
    }

    public Empleado(Empleado e) {
        this.id = e.id;
        this.nombre = e.nombre;
        this.apellidos = e.apellidos;
        this.nif = e.nif;
        this.direccion = e.direccion;
        this.franquicia = e.franquicia;
    }

    public void comprobarId(long id) {
        if (id <= 0) {
            System.out.println("La Id tiene que ser mayor estrictamente que 0");
            return;
        } else if (id % 1 != 0) {
            System.out.println("La id tiene que ser un número entero");
            return;
        } else {
            for (Empleado Empleado : Utilidades.EMPLEADOS) {
                if (id == Empleado.getId()) {
                    System.out.println("No se puede repetir la id");
                    return;
                } else {
                    return;
                }
            }
        }
    }

    public void comprobarNombre(String nombre) {
        if (nombre.isEmpty()) {
            System.out.println("No puede estar vacio");
        } else {
            for (int i = 0; i < nombre.length(); i++) {
                if ((nombre.charAt(i) >= 'a' && nombre.charAt(i) <= 'z') || (nombre.charAt(i) >= 'A' && nombre.charAt(i) <= 'Z')) {
                } else {
                    System.out.println("Solo se permiten letras");
                    return;
                }
            }
        }
    }
    
    public void comprobarApellidos(String apellidos){
        if (apellidos.isEmpty()) {
            System.out.println("No puede estar vacio");
        } else {
            for (int i = 0; i < apellidos.length(); i++) {
                if ((apellidos.charAt(i) >= 'a' && apellidos.charAt(i) <= 'z') || (apellidos.charAt(i) >= 'A' && apellidos.charAt(i) <= 'Z')) {
                } else {
                    System.out.println("Solo se permiten letras");
                    return; 
                }
            }
        }
    }
    
    public void comprobarNif(String nif){
        if (nif.length() != 9) {
            System.out.println("El nif debeser de 9 digitos");
        } else{
            if (!((nif.charAt(8) >= 'a' && nif.charAt(8) <= 'z' ) || (nif.charAt(8) >= 'A' && nif.charAt(8) <= 'Z'))) {
                System.out.println("Debe finalizar con una letra");
            } else{
                for (int i = 0; i < 7; i++) {
                    if (!(nif.charAt(i) >= '0' && nif.charAt(i) <= '9')) {
                        System.out.println("Los primeros 8 digitos deben ser numeros");
                    }
                }
            }
        }
    }
    
    public void comprobarDireccion(String direccion){
        if (direccion.isEmpty()) {
            System.out.println("La direccion no puede estar vacia");
        }
    }
    
    public void comprobarTelefono(String telefono){
        if (telefono.length() != 9) {
            System.out.println("Debe tener nueve numeros");
        } else{
            for (int i = 0; i < telefono.length(); i++) {
                if (!(telefono.charAt(i) >= '0' && telefono.charAt(i) <='9')) {
                    System.out.println("Solo se permiten números");
                }
            }
        }
    }
    
    public Empleado nuevoEmpleado(){
        Empleado e = new Empleado();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduce el id");
        long co = in.nextLong();
        e.comprobarId(co);
        e.setId(co);
        System.out.println("Introduce el nombre");
        String us = in.nextLine();
        e.comprobarNombre(us);
        e.setNombre(us);
        System.out.println("Introduce los apellidos");
        String ap = in.nextLine();
        e.comprobarApellidos(ap);
        e.setApellidos(ap);
        System.out.println("Introduce el NIF");
        String n = in.nextLine();
        e.comprobarNif(n);
        e.setNif(n);
        System.out.println("Introduce el telefono");
        String t = in.nextLine();
        e.comprobarTelefono(t);
        e.setTelefono(t);
    return e;}

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

}
