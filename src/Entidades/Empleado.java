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

    public long generarId() {
        long id = 0;
        for (Empleado e : Utilidades.EMPLEADOS) {
            if (id < e.id) {
                id = e.id;
            }
        }
    return id +1;}

    public void comprobarNombre(String nombre) {
        boolean cond = false;
        if (nombre.isEmpty()) {
            System.out.println("No puede estar vacio");
            return;
        } else {
            for (int i = 0; i < nombre.length(); i++) {
                if (!((nombre.charAt(i) >= 'a' && nombre.charAt(i) <= 'z') || (nombre.charAt(i) >= 'A' && nombre.charAt(i) <= 'Z'))) {
                    cond = true;
                    break;
                } else {
                    cond = false;
                }
            }

        }
        if (cond) {
            System.out.println("Solo se permiten letras");
        } else {
            this.nombre = nombre;
        }
    }

    public void comprobarApellidos(String apellidos) {
        boolean cond = false;
        if (apellidos.isEmpty()) {
            System.out.println("No puede estar vacio");
            return;
        } else {
            for (int i = 0; i < apellidos.length(); i++) {
                if (((apellidos.charAt(i) >= 'a' && apellidos.charAt(i) <= 'z') || (apellidos.charAt(i) >= 'A' && apellidos.charAt(i) <= 'Z'))) {
                    cond = false;                 
                } else if(apellidos.charAt(i) != ' '){
                    cond = true;
                    break;
                }
            }

        }
        if (cond) {
            System.out.println("Solo se permiten letras");
        } else {
            this.apellidos = apellidos;
        }
    }

    public void comprobarNif(String nif) {
        boolean cond = false;
        if (nif.length() != 9) {
            System.out.println("El nif debeser de 9 digitos");
            return;
        } else if (!((nif.charAt(8) >= 'a' && nif.charAt(8) <= 'z') || (nif.charAt(8) >= 'A' && nif.charAt(8) <= 'Z'))) {
            System.out.println("Debe finalizar con una letra");
            return;
        } else {
            for (int i = 0; i < 7; i++) {
                if (!(nif.charAt(i) >= '0' && nif.charAt(i) <= '9')) {
                    System.out.println("Los primeros 8 digitos deben ser numeros");
                } else {
                    for (Empleado e : Utilidades.EMPLEADOS) {
                        if (e.getNif().equals(nif)) {
                            cond = true;
                            break;
                        } else {
                            cond = false;
                        }
                    }
                }
            }
        }
        if (cond) {
            System.out.println("Este nif ya esta registrado en la base");
        } else {
            this.nif = nif;
        }
    }

    public void comprobarDireccion(String direccion) {
        if (direccion.isEmpty()) {
            System.out.println("La direccion no puede estar vacia");
        } else {
            this.direccion = direccion;
        }
    }

    public void comprobarTelefono(String telefono) {
        boolean cond = false;
        if (telefono.contains(CharSequence.class.cast(" "))) {
            System.out.println("No puede haber espacios");
            return;
        } else {
            if (telefono.length() != 9) {
                System.out.println("Debe tener nueve numeros");
                return;
            } else {
                for (int i = 0; i < telefono.length(); i++) {
                    if (!(telefono.charAt(i) >= '0' && telefono.charAt(i) <= '9')) {
                        cond = true;
                        break;
                    } else {
                        cond = false;
                    }
                }
            }

            if (cond) {
                System.out.println("Solo se permiten números");
            } else {
                this.telefono = telefono;
            }
        }
    }

    public Empleado nuevoEmpleado() {
        Empleado e = new Empleado();
        Scanner in = new Scanner(System.in);
        e.setId(e.generarId());
        System.out.println("Introduce el nombre");
        String us;
        do {
            in = new Scanner(System.in);
            us = in.nextLine();
            e.comprobarNombre(us);
        } while (e.getNombre() != us);
        System.out.println("Introduce los apellidos");
        String ap;
        do {
            in = new Scanner(System.in);
            ap = in.nextLine();
            e.comprobarApellidos(ap);
        } while (e.getApellidos() != ap);
        System.out.println("Introduce el NIF");
        String n;
        do {
            in = new Scanner(System.in);
            n = in.nextLine();
            e.comprobarNif(n);
        } while (e.getNif() != n);
        System.out.println("Introduce el telefono");
        String t;
        do {
            in = new Scanner(System.in);
            t = in.nextLine();
            e.comprobarTelefono(t);
        } while (e.getTelefono() != t);
        System.out.println("Introduce tu direccion");
        String d;
        do {
            in = new Scanner(System.in);
            d = in.nextLine();
            e.comprobarDireccion(d);
        } while (e.getDireccion() != d);

        return e;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

}
