/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Empleado implements Serializable {

    private static final long serialVersionUID = 923841203981203L;
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
    //VALORES VALIDOS: NÚMEROS ENTEROS,  HA DE SER ÚNICO PARA CADA INSTANCIA  > 0 && VALORES INVALIDOS: NÚMEROS ENTEROS <= 0
    protected long idfranquicia;

    public long getIdfranquicia() {
        return idfranquicia;
    }

    public void setIdfranquicia(long idfranquicia) {
        this.idfranquicia = idfranquicia;
    }

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

    public Empleado(long id, String nombre, String apellidos, String nif, String direccion, String telefono, Franquicia franquicia, long idfranquicia) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.franquicia = franquicia;
        this.idfranquicia = idfranquicia;
    }

    public Empleado(Empleado e) {
        this.id = e.id;
        this.nombre = e.nombre;
        this.apellidos = e.apellidos;
        this.nif = e.nif;
        this.direccion = e.direccion;
        this.telefono = e.telefono;
        this.franquicia = e.franquicia;
        this.idfranquicia = e.idfranquicia;
    }

    /**
     * Recorre el array con todos los empleados y la id para el siguiente
     * empleado
     *
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
     *
     * @param nombre a validar
     * @return boolean
     */
    public boolean validarNombre(String nombre) {
        //Comprueba si el String esta vacio
        if (nombre.isEmpty()) {
            System.out.println("No puede estar vacio");
            //Comprueba si el String contiene algún numero
        } else if (nombre.matches(".*\\d.*")) {
            System.out.println("No puede tener numeros.");
            //Comprueba que el nombre se ha de una longitud mayor e igual que 2 y menor que 150
        } else if (nombre.length() <= 2 || nombre.length() > 150) {
            System.out.println("No puede ser menor de 2 carácteres o superior de 150.");
            //Devuelve true cuando pasa todos las validaciones
        } else {
            return true;
        }
        return false;
    }

    /**
     * Valida los apellidos
     *
     * @param apellidos a comprobar
     * @return boolean
     */
    public boolean validarApellidos(String apellidos) {
        //Comprueba si esta vacio
        if (apellidos.isEmpty()) {
            System.out.println("No puede estar vacio");
            //Comprueba si contiene algun numero
        } else if (apellidos.matches(".*\\d.*")) {
            System.out.println("No puede tener numeros.");
            //Comprueba si el String es mayor e igual que 2 o menor que 150.
        } else if (apellidos.length() <= 2 || apellidos.length() > 150) {
            System.out.println("No puede ser menor de 2 carácteres o superior de 150.");
            //Devuelve true si pasa las validaciones
        } else {
            return true;
        }
        return false;
    }

    /**
     * Valida nif del empleado
     *
     * @param nif a comprobar
     * @param empleados para saber si esta repetido
     * @return boolean
     */
    public boolean validarNIF(String nif, ArrayList<Empleado> empleados) {
        //Comprueba si el String esta vacio
        if (nif.isEmpty()) {
            System.out.println("No puede estar vacio.");
            //La longitud del String tiene que ser igual a 9
        } else if (nif.length() != 9) {
            System.out.println("El nif debe ser de 9 digitos.");
            //Los primeros 8 digitos tienen que ser números
        } else if (!Utilidades.isNumeric(nif.substring(0, 8))) {
            System.out.println("Los 8 primeros digitos deben ser numeros");
            //El primero digito debe ser una letra.
        } else if (!String.valueOf(nif.charAt(8)).matches("[a-zA-Z]")) {
            System.out.println("El último debe ser una letra");
        } else {
            //Recorre el array y comprueba no este ya registrado
            for (int i = 0; i < empleados.size(); i++) {
                if (empleados.get(i).nif.equals(nif)) {
                    System.out.println("No puede repertirse el nif.");
                    break;
                } else if (!empleados.get(i).nif.equals(nif) && i == (empleados.size() - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Valida la direccion del empleado
     *
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
     *
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
        } else if (!Utilidades.isNumeric(telefono)) {
            System.out.println("Solo se permiten números");
            //Devuelve true si pasa todas las validaciones
        } else {
            return true;
        }
        return false;
    }

    /**
     * Devuelve un empleado con los datos introducidos
     *
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
     *
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
     *
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
     *
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
     *
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
        return this.id + ". " + this.nombre + " " + this.apellidos + " Nif: " + this.nif + " Telefono: " + this.telefono + " (" + this.getClass().getSimpleName() + ")" + "trabaja en la franquicia con la id: ";
    }

    /**
     * Convierte un array de empleados en un array list de empleados
     *
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
     *
     * @param array
     */
    public static void mostrarEmpleados(ArrayList<Empleado> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).id + ". " + array.get(i).nombre + " " + array.get(i).apellidos + " Nif: " + array.get(i).nif + " Telefono: " + array.get(i).telefono + " (" + array.get(i).getClass().getSimpleName() + ")" + "trabaja en la franquicia de " + array.get(i).franquicia.getUbicacion());
        }
    }

    /**
     * Introduce el empleado en una franquicia.
     *
     * @param franquicia donde se guarda el empleado
     */
    public void trabajarEn(Franquicia franquicia) {
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

    /**
     *  Metodo para exportar los empleados fichero de texto
     * @return un string que se escribe en el fichero
     */
    public String data() {
        return this.id + "|" + this.nombre + "|" + this.apellidos + "|" + this.nif + "|" + this.direccion + "|" + this.telefono;
    }

    /**
     * Crea un archivo de texto donde con el metodo data se escriben en cada linea cada empleado del array 
     * @param empleados a escribir en el fichero
     */
    public static void guardarEmpledos(ArrayList<Empleado> empleados) {
        try {
            BufferedWriter bw = null;
            File f = new File("empleados.txt");
            if (f.createNewFile()) {
                try {
                    FileWriter fw = new FileWriter(f, true);
                    bw = new BufferedWriter(fw);
                    for (Empleado e : empleados) {
                        bw.write(e.data());
                        bw.newLine();
                    }
                } catch (IOException e) {
                    System.out.println("Error");
                } finally {
                    try {
                        bw.close();
                    } catch (IOException ex) {
                        System.out.println("Error");
                    }
                }
                System.out.println("Se ha creado el archivo con los empleados!");
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void guardarEmpleadosBinario(ArrayList<Empleado> empleados) {
        OutputStream os = null;
        ObjectOutput out = null;
        try {
            os = new FileOutputStream("empleadosbinario.txt");
            out = new ObjectOutputStream(os);
            for (Empleado e : empleados) {
                out.writeObject(e);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("No se ha podido crear el OutputStream");
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el OutputStream");
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar ObjectOutputStream");
                }
            }
        }
        System.out.println("Se ha creado el archivo con los empleados binarios!");
    }

    /**
     * Guarda un único empleado en un fichero binario
     */
    public void guardarEmpleadoBinario() {
        OutputStream os = null;
        ObjectOutput out = null;
        try {
            os = new FileOutputStream("empleadobinario.txt");
            out = new ObjectOutputStream(os);
            out.writeObject(this);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");;
        } catch (IOException ex) {
            System.out.println("No se ha podido crear el OutputStream");
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el ObjectOutputStream");
                }
            }
            if (os != null) {
                try{
                    os.close();
                }catch(IOException ex){
                    System.out.println("No se ha podido cerrar el OutputStream");
                }
            }
        }
    }

    /**
     * Lee un objeto empleado del archivo binario donde se guarda el anterior metodo
     */
    public static void leerObjetoBinarioEmpleado() {
        InputStream is = null;
        ObjectInput in = null;
        try {
            is = new FileInputStream("empleadobinario.txt");
            in = new ObjectInputStream(is);
            Empleado e = (Empleado) in.readObject();
            System.out.println(e);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Error");
        } catch (ClassNotFoundException ex) {
            System.out.println("Fallo al convertir el objeto a jugador");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el ObjectInputStream");
                }
            }
            if (is != null) {
                try{
                    is.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el InputStream");
                }
            }
        }
    }

    /**
     * Lee el archivo binario donde se guarda los empleados
     */
    public static void leerFicheroBinarioEmpleados() {
        InputStream is = null;
        ObjectInput oi = null;
        try {
            is = new FileInputStream("empleadosbinario.txt");
            oi = new ObjectInputStream(is);
            while(is.available() > 0){
                Empleado e = (Empleado) oi.readObject();
                System.out.println(e.toString());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("No se ha podido crear el ObjectInputStream");
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada");
        } finally{
            if (is !=null ) {
                try {
                    is.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el InputStream");
                }
            }
            if (oi != null) {
                try {
                    oi.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el ObjectInputStream");
                }
            }
        }
    }

    /**
     * Guarda un objeto de tipo empleado en el fichero de texto ya creado "empleados.txt", sin borrar los anteriores
     */
    public void guardarEmpleado() {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter("empleados.txt", true);
            bw = new BufferedWriter(fw);
            bw.write(this.data());
            bw.newLine();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");

        } catch (IOException ex) {
            Logger.getLogger(Empleado.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el Stream");
                }
            }
            if (fw != null) {
                try{
                    fw.close();
                } catch(IOException ex){
                    System.out.println("No se ha podido cerrar el FileWriter");
                }
            }
        }

    }
    /**
     * Importa los empleados guardados en un fichero guardado en el parametro ruta
     * @param ruta string de la ruta
     * @return un arraylist con los empleados importados
     */
    public static ArrayList<Empleado> importarEmpleadosBinarios(String ruta) {
        ArrayList<Empleado> ret = new ArrayList<>();
        InputStream is = null;
        ObjectInput oi = null;
        try {
            is = new FileInputStream(ruta);
            oi = new ObjectInputStream(is);
            while (is.available() > 0) {
                Empleado e = (Empleado) oi.readObject();
                System.out.println("Se ha importado con exito el empleado: ");
                System.out.println(e.data());
                ret.add(e);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Se ha dado una IOException");
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada");
        } finally{
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el InputStream");
                }
            }
            if (oi != null) {
                try {
                    oi.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el ObjectInputStream");
                }
            }
        }
        return ret;
    }

    /**
     * Importa los empleados de un fichero de texto de un ruta que has de pasar como parametro
     * @param ubicacion string con la ruta
     * @return arraylist de empleados importados
     */
    public static ArrayList<Empleado> importarEmpleados(String ubicacion) {
        ArrayList<Empleado> ret = new ArrayList<>();
        Empleado e;
        String texto;
        File f = new File(ubicacion);
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            try {
                while ((texto = br.readLine()) != null) {
                    e = new Empleado();
                    String[] array = texto.split("\\|");
                    e.setId(Long.valueOf(array[0]));
                    e.setNombre(array[1]);
                    e.setApellidos(array[2]);
                    e.setNif(array[3]);
                    e.setDireccion(array[4]);
                    e.setTelefono(array[5]);
                    ret.add(e);
                }
            } catch (IOException i) {
                System.out.println(i.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } finally{
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el BufferedReader");
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el FileReader");
                }
            }
        }
        return ret;
    }

    /**
     * Busca en el archivo de texto un empleado con la id introducida
     * @param id a buscar
     * @return empleado con la misma id que la introducida
     */
    public static Empleado getEmpleadoByIDFichero(long id) {
        Empleado e = new Empleado();
        String texto;
        File f = new File("empleados.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            try {
                while ((texto = br.readLine()) != null) {
                    String[] array = texto.split("\\|");
                    if (Long.valueOf(array[0]) == id) {
                        e.setId(Long.valueOf(array[0]));
                        e.setNombre(array[1]);
                        e.setApellidos(array[2]);
                        e.setNif(array[3]);
                        e.setDireccion(array[4]);
                        e.setTelefono(array[5]);
                        System.out.println(e);
                        return e;
                    }
                }
                System.out.println("No existe el empleado con el id introducido.");
            } catch (IOException i) {
                System.out.println(i.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha podido encontrar el archivo");
        } finally{
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el BufferedReader");
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el FileReader");
                }
            }
        }
        return e;
    }

}
