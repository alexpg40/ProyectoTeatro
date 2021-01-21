/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DarkB
 */
public class Empleado {

    //VALORES VALIDOS: NÚMEROS ENTEROS,  HA DE SER ÚNICO PARA CADA INSTANCIA  > 0 && VALORES INVALIDOS: NÚMEROS ENTEROS <= 0
    protected long id;
    //VALORES VALIDOS: CUALQUIER LETRA && VALORES INVALIDOS: CUALQUIER CARACTER DIFERENTE A UNA LETRA
    protected String nombre;
    //VALORES VALIDOS: CUALQUIER LETRA && VALORES INVALIDOS: CUALQUIER CARACTER DIFERENTE A UNA LETRA
    protected String apellidos;
    //VALORES VALIDOS: TIENE QUE TENER 8 NÚMEROS Y FINALIZAR CON UNA LETRA && VALORES INVALIDOS: CARACTERES ESPECIALES Y VACIO
    protected String nif;
    //VALORES VALIDOS: LETRAS,NÚMEROS && VALORES INVALIDOS: VACIO
    protected String direccion;
    //VALORES VALIDOS: NÚMEROS ENTEROS, 9 OBLIGATORIAMENTE && VALORES INVALIDOS: CUALQUIER CARACTER DIFERENTE A UN NUMERO
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
        this.telefono = e.telefono;
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

    public void validarNombre(String nombre) {
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

    public void validarApellidos(String apellidos) {
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

    public void validarNIF(String nif) {
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

    public void validarDireccion(String direccion) {
        if (direccion.isEmpty()) {
            System.out.println("La direccion no puede estar vacia");
        } else {
            this.direccion = direccion;
        }
    }

    public void validarTelefono(String telefono) {
        boolean cond = false;
        if (telefono.contains(CharSequence.class.cast(" "))) {
            System.out.println("No puede haber espacios");
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

    public static Empleado nuevoEmpleado() {
        Empleado e = new Empleado();
        Scanner in;
        e.setId(e.generarId());
        System.out.println("Introduce el nombre");
        String us;
        do {
            in = new Scanner(System.in);
            us = in.nextLine();
            e.validarNombre(us);
        } while (e.getNombre() != us);
        System.out.println("Introduce los apellidos");
        String ap;
        do {
            in = new Scanner(System.in);
            ap = in.nextLine();
            e.validarApellidos(ap);
        } while (e.getApellidos() != ap);
        System.out.println("Introduce el NIF");
        String n;
        do {
            in = new Scanner(System.in);
            n = in.nextLine();
            e.validarNIF(n);
        } while (e.getNif() != n);
        System.out.println("Introduce el telefono");
        String t;
        do {
            in = new Scanner(System.in);
            t = in.nextLine();
            e.validarTelefono(t);
        } while (e.getTelefono() != t);
        System.out.println("Introduce tu direccion");
        String d;
        do {
            in = new Scanner(System.in);
            d = in.nextLine();
            e.validarDireccion(d);
        } while (e.getDireccion() != d);

        return e;
    }

    /**
     * Busca la id introduciza y devuelve un objeto de la BD con la misma id 
     * @param id guarla la id a buscar
     * @return devuelve el objeto con la misma id
     */
    public Empleado getEmpleadobyID(long id){
        Empleado e = new Empleado();
        for (Empleado emp : Utilidades.EMPLEADOS) {
            if (id == emp.id) {
                e = emp;
            }
        }
        
    return e;}
    
    /**
     * Busca empleado en la BD por nif
     * @param nif guarda el nif a buscar
     * @return un objeto empleado con el mismo nif
     */
    public Empleado getEmpleadobyNIF(String nif){
        Empleado e = new Empleado();
        for (Empleado emp : Utilidades.EMPLEADOS) {
            if (nif.equals(emp.nif)) {
                e = emp;
            }
        }
    return e;}

    /**
     * Busca empleados con el nombre
     * @param nombre guarda el nombre a buscar
     * @return un array con los empleados que coincide con el nombre
     */
    public ArrayList<Empleado> getEmpleadobyNombre(String nombre){
        ArrayList<Empleado> array = new ArrayList<>();
        for (int i = 0; i < Utilidades.EMPLEADOS.length; i++) {
            if (nombre.equals(Utilidades.EMPLEADOS[i].nombre)) {
                array.add(Utilidades.EMPLEADOS[i]);
            }
        }
    return array;}
    
    /**
     * Busca empleados que coincide con el telefono
     * @param telefono guarda el telefono a buscar
     * @return devuelve el objeto con el mismo telefono
     */
    public Empleado getEmpleadobyTelefono(String telefono){
        Empleado e  = new Empleado();
        for (Empleado emp : Utilidades.EMPLEADOS) {
            if (telefono.equals(emp.telefono)) {
                e = emp;
            }
        }
    return e;}
    
    /**
     * Busca los objetos que coincide con los apellidos
     * @param apellidos guarda los apellidos a buscar
     * @return ArrayList con los empleados que los apellidos
     */
    public ArrayList<Empleado> getEmpleadobyApellidos(String apellidos){
        ArrayList<Empleado> array = new ArrayList<>();
        for (int i = 0; i < Utilidades.EMPLEADOS.length; i++) {
            if (apellidos.equals(Utilidades.EMPLEADOS[i].apellidos)) {
                array.add(Utilidades.EMPLEADOS[i]);
            }
        }
    return array;}
    
    /**
     * Busca empleados en una direccion
     * @param direccion guarda la direccion a buscar
     * @return ArrayList de empleados que vuelve los objetos empleados con esa direccion
     */
    public ArrayList<Empleado> getEmpleadobyDireccion(String direccion){
        ArrayList<Empleado> array = new ArrayList<>();
        for (Empleado e : Utilidades.EMPLEADOS) {
            if (direccion.equals(e.direccion)) {
                array.add(e);
            }
        }
    return array;}
    
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    /**
     * Convierte un array de empleados en un array list de empleados
     * @param array 
     * @return ararylist 
     */
    public static ArrayList<Empleado> convertirEmpleado(Empleado[] array){
        ArrayList<Empleado> ret = new ArrayList<>();
        for (Empleado e : array) {
            ret.add(e);
        }
    return ret;}
    
    /**
     * Recorre todos el array e imprime los objetos usandro el toString
     * @param array 
     */
    public static void mostrarEmpleados(ArrayList<Empleado> array){
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).toString());
        }
    }
    
}
