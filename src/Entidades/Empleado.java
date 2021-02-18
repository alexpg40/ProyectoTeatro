/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Scanner;


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

    /**
     * Recorre el array con todos los empleados y la id para el siguiente empleado 
     * @param empleados array a recorrer
     * @return id para el empleado
     */
    public long generarId(ArrayList<Empleado> empleados) {
        long id = 0;
        for (Empleado e : empleados) {
            if (id < e.id) {
                id = e.id;
            }
        }
        return id + 1;
    }

    /**
     * Valida el nombre del empleado
     * @param nombre a validar
     * @return boolean
     */
    public boolean validarNombre(String nombre) {
        //Comprueba si el String esta vacio
        if (nombre.isEmpty()) {
            System.out.println("No puede estar vacio");
            //Comprueba si el String contiene algún numero
        } else if(nombre.matches(".*\\d.*")){
            System.out.println("No puede tener numeros.");
            //Comprueba que el nombre se ha de una longitud mayor e igual que 2 y menor que 150
        } else if(nombre.length() <= 2 || nombre.length() > 150){
            System.out.println("No puede ser menor de 2 carácteres o superior de 150.");
            //Devuelve true cuando pasa todos las validaciones
        } else {
            return true;
        }
        return false;
    }

    /**
     * Valida los apellidos
     * @param apellidos a comprobar
     * @return boolean
     */
    public boolean validarApellidos(String apellidos) {
        //Comprueba si esta vacio
        if (apellidos.isEmpty()) {
            System.out.println("No puede estar vacio");
            //Comprueba si contiene algun numero
        } else if(apellidos.matches(".*\\d.*")){
            System.out.println("No puede tener numeros.");
            //Comprueba si el String es mayor e igual que 2 o menor que 150.
        } else if(apellidos.length() <= 2 || apellidos.length() > 150){
            System.out.println("No puede ser menor de 2 carácteres o superior de 150.");
            //Devuelve true si pasa las validaciones
        } else {
            return true;
        }
        return false;
    }

    /**
     * Valida nif del empleado 
     * @param nif a comprobar
     * @param empleados para saber si esta repetido
     * @return boolean
     */
    public boolean validarNIF(String nif, ArrayList<Empleado> empleados) {
        //Comprueba si el String esta vacio
        if (nif.isEmpty()) {
            System.out.println("No puede estar vacio.");
            //La longitud del String tiene que ser igual a 9
        } else if (nif.length() != 9){
            System.out.println("El nif debe ser de 9 digitos.");
            //Los primeros 8 digitos tienen que ser números
        } else if (!Utilidades.isNumeric(nif.substring(0, 8))){
            System.out.println("Los 8 primeros digitos deben ser numeros");
            //El primero digito debe ser una letra.
        } else if (!String.valueOf(nif.charAt(8)).matches("[a-zA-Z]")){
            System.out.println("El último debe ser una letra");
        } else{
            //Recorre el array y comprueba no este ya registrado
            for (int i = 0; i < empleados.size(); i++) {
                if (empleados.get(i).nif.equals(nif)) {
                    System.out.println("No puede repertirse el nif.");
                    break;
                } else if (!empleados.get(i).nif.equals(nif) && i == (empleados.size() -1)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Valida la direccion del empleado
     * @param direccion a comprobar
     * @return boolean
     */
    public boolean validarDireccion(String direccion) {
        //Comprueba si esta vacio el String
        if (direccion.isEmpty()) {
            System.out.println("La direccion no puede estar vacia");
        } else {
            return true;
        }
    return false;
    }

    /**
     * Valida el telefono del empleado
     * @param telefono a comprobar 
     * @return boolean
     */
    public boolean validarTelefono(String telefono) {
        //Comprueba que no tenga ningun espacio 
        if (telefono.contains(CharSequence.class.cast(" "))) {
            System.out.println("No puede haber espacios");
            //Comprueba que la longitud del telefono sea igual a 9
        } else if (telefono.length() != 9) {
            System.out.println("Tiene que tener 9 números.");
            //Comprueba que solo se permiten numeros
        } else if(!Utilidades.isNumeric(telefono) ){
            System.out.println("Solo se permiten números");
            //Devuelve true si pasa todas las validaciones
        } else {
            return true;
        }
    return false;}

    /**
     * Devuelve un empleado con los datos introducidos
     * @param empleados
     * @return 
     */
    public static Empleado nuevoEmpleado(ArrayList<Empleado> empleados) {
        Empleado e = new Empleado();
        Scanner in;
        e.setId(e.generarId(empleados));
        System.out.println("Introduce el nombre");
        String us;
        do {
            e.setNombre(" ");
            in = new Scanner(System.in);
            us = in.nextLine();
            if (e.validarNombre(us)) {
                e.setNombre(us);
            }
        } while (!e.getNombre().equals(us));
        System.out.println("Introduce los apellidos");
        String ap;
        do {
            e.setApellidos(" ");
            in = new Scanner(System.in);
            ap = in.nextLine();
            if (e.validarApellidos(ap)) {
                e.setApellidos(ap);
            }
        } while (!e.getApellidos().equals(ap));
        System.out.println("Introduce el NIF");
        String n;
        do {
            e.setNif(" ");
            in = new Scanner(System.in);
            n = in.nextLine();
            if (e.validarNIF(n, empleados)) {
                e.setNif(n);
            }
        } while (!e.getNif().equals(n));
        System.out.println("Introduce el telefono");
        String t;
        do {
            e.setTelefono(" ");
            in = new Scanner(System.in);
            t = in.nextLine();
            if (e.validarTelefono(t)) {
                e.setTelefono(t);
            }
        } while (!e.getTelefono().equals(t));
        System.out.println("Introduce tu direccion");
        String d;
        do {
            e.setDireccion(" ");
            in = new Scanner(System.in);
            d = in.nextLine();
            if (e.validarDireccion(d)) {
                e.setDireccion(d);
            }
        } while (!e.getDireccion().equals(d));

        return e;
    }

    /**
     * Busca la id introduciza y devuelve un objeto de la BD con la misma id
     *
     * @param id
     * @param array
     * @return devuelve el objeto con la misma id
     */
    public static Empleado getEmpleadobyID(long id, ArrayList<Empleado> array) {
        Empleado e = new Empleado();
        for (Empleado emp : array) {
            if (id == emp.id) {
                e = emp;
            }
        }

        return e;
    }
    
    

    /**
     * Busca empleado en la BD por nif
     *
     * @param nif
     * @param array
     * @return un objeto empleado con el mismo nif
     */
    public static Empleado getEmpleadobyNIF(String nif, ArrayList<Empleado> array) {
        Empleado e = new Empleado();
        for (Empleado emp : array) {
            if (nif.toLowerCase().equals(emp.nif.toLowerCase())) {
                e = emp;
            }
        }
        return e;
    }
    
    /**
     * Busca empleados con el nombre
     * @param nombre
     * @param array
     * @return un array con los empleados que coincide con el nombre
     */
    public static ArrayList<Empleado> getEmpleadobyNombre(String nombre, ArrayList<Empleado> array) {
        ArrayList<Empleado> ret = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).nombre.toLowerCase().contains(nombre.toLowerCase())) {
                ret.add(array.get(i));
            }
        }
        return ret;
    }

    /**
     * Busca empleados que coincide con el telefono
     * @param telefono
     * @param array
     * @return devuelve el objeto con el mismo telefono
     */
    public static Empleado getEmpleadobyTelefono(String telefono, ArrayList<Empleado> array) {
        Empleado e = new Empleado();
        for (Empleado emp : array) {
            if (telefono.equals(emp.telefono)) {
                e = emp;
            }
        }
        return e;
    }

    /**
     * Busca los objetos que coincide con los apellidos
     * @param apellidos
     * @param array
     * @return ArrayList con los empleados que los apellidos
     */
    public static ArrayList<Empleado> getEmpleadobyApellidos(String apellidos, ArrayList<Empleado> array) {
        ArrayList<Empleado> ret = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (apellidos.toLowerCase().contains(array.get(i).apellidos.toLowerCase())) {
                ret.add(array.get(i));
            }
        }
        return ret;
    }

    /**
     * Busca empleados en una direccion
     * @param direccion
     * @param array
     * @return ArrayList de empleados que vuelve los objetos empleados con esa
     * direccion
     */
    public static ArrayList<Empleado> getEmpleadobyDireccion(String direccion, ArrayList<Empleado> array) {
        ArrayList<Empleado> ret = new ArrayList<>();
        for (Empleado e : array) {
            if (e.direccion.toLowerCase().contains(direccion.toLowerCase())) {
                ret.add(e);
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        return this.id + ". " + this.nombre + " " + this.apellidos + " Nif: " + this.nif + " Telefono: " + this.telefono + " (" + this.getClass().getSimpleName() + ")" + "trabaja en la franquicia con la id: " + franquicia.getId();
    }

    /**
     * Convierte un array de empleados en un array list de empleados
     * @param array
     * @return ararylist
     */
    public static ArrayList<Empleado> convertirEmpleado(Empleado[] array) {
        ArrayList<Empleado> ret = new ArrayList<>();
        for (Empleado e : array) {
            ret.add(e);
        }
        return ret;
    }

    /**
     * Recorre todos el array e imprime los objetos usandro el toString
     * @param array
     */
    public static void mostrarEmpleados(ArrayList<Empleado> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).id + ". " + array.get(i).nombre + " " + array.get(i).apellidos + " Nif: " + array.get(i).nif + " Telefono: " + array.get(i).telefono  + " (" + array.get(i).getClass().getSimpleName() + ")" + "trabaja en la franquicia de " + array.get(i).franquicia.getUbicacion());
        }
    }
    
    /**
     * Introduce el empleado en una franquicia.
     * @param franquicia donde se guarda el empleado
     */
    public void trabajarEn(Franquicia franquicia){
        if (!franquicia.getEmpleados().contains(this)) {
            franquicia.getEmpleados().add(this);
        }
        if (this.getFranquicia() != franquicia) {
            this.setFranquicia(franquicia);
        }
    }
    
        
     public static Empleado añadirEmpleadobyID(long id, ArrayList<EmpleadoDeTeatro> empleadosTeatro) {
        Empleado e = new Empleado(); 
        for (EmpleadoDeTeatro empleadoTeatro : empleadosTeatro) {
            if (id == empleadoTeatro.id) {
                e = empleadoTeatro;
                System.out.println("Se ha añadido " + e);
            }
        }
        return e;
    }
    
}
