package Entidades;

import Entidades.Bono;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {
    private long id;
    // Valores válidos: Números > 0 | Valores invalidos: <=0 | Otras restricciones: No se puede repetir y solo puede ser entero.
    private String nombre;
    // Valores validos: cualquier letra | Valores invalidos: números, vakir vacío y null.
    private String apellidos;
    // Valores validos: cualquier letra | Valores invalidos: números, vakir vacío y null.
    private String nif;
    // Valores válidos: Tiene que haber 8 números y una letra | Valores inválidos: Vacío o null.
    private String telefono;
    // Valores válidos: Cualquier numero entero | Valores inválidos: | Otras restricciones: No puede repetirse y solo pueden haber números enteros.
    private String email;   
    // Valores válidos: Cualquier carácter | Valores inválidos: Carácteres especiales exceptuando la arroba (@) | Otras restricciones: Tiene que contener una arroba(@).
    // Los usuarios pueden tener muchos bonos    
    private String password;
    // Valores validos, cualquiera puesto que cuantos mas valores diferentes mas segura es la contraseña.
    
    public Usuario () {
        
    }
    
    public Usuario (long id, String nombre, String apellidos, String nif, String telefono, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }
    
     public Usuario (Usuario usu){
        this.id = usu.id;
        this.nombre = usu.nombre;
        this.apellidos = usu.apellidos;
        this.nif = usu.nif;
        this.telefono = usu.telefono;
        this.email = usu.email;
        this.password = usu.password;
    }

    public Usuario(long id, String nombre, String apellidos, String nif, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.telefono = telefono;
        this.email = email;
    }

    public Usuario(String nombreUsuarioInsertado, String apellidoUsuarioInsertado, String nifUsuarioInsertado, String telefonoUsuarioInsertado, String emailUsuarioInsertado, String passwordUsuarioInsertado) {
        this.nombre = nombreUsuarioInsertado;
        this.apellidos = apellidoUsuarioInsertado;
        this.nif = nifUsuarioInsertado;
        this.telefono = telefonoUsuarioInsertado;
        this.email = emailUsuarioInsertado;
        this.password = passwordUsuarioInsertado;
    }
     
    public long getId () {
        return id;
    }
    
    public void setId (long id) {
        this.id = id ;
    }
    
    public String getNombre () {
        return nombre;
    }
    
    public void setNombre (String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos () {
        return apellidos;
    }
    
    public void setApellidos (String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getNif () {
        return nif;
    }
    
    public void setNif (String nif) {
        this.nif = nif;
    }
    
    public String getTelefono () {
        return telefono;
    }
    
    public void setTelefono (String telefono) {
        this.telefono = telefono;
    }
    
    public String getEmail () {
        return email;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public long generarId(){
       long idUsuario = 0;
       for (int i = 0; i < Utilidades.USUARIOS.length; i++){
           if (Utilidades.USUARIOS[i].id > idUsuario)
           {
               idUsuario = Utilidades.USUARIOS[i].id;
           }
       }
       
       return idUsuario +1;
    }
    
    @SuppressWarnings("empty-statement")
    public void comprobarNombre(String nombre){
        boolean condicion = false;
        if(nombre.isEmpty()){
            System.out.println("No puede estar vacío.");
            
        } else{
            for (int i = 0; i < nombre.length(); i++){
               if (nombre.charAt(i) >= '0' && nombre.charAt(i) <= '9'){
                   condicion = true;
                   break;
               } else {
                   condicion = false;
               }
            }
        }
        if (condicion) {
            System.out.println("No puede tener numeros.");
        } else {
            this.nombre = nombre;
        };
    };
    
    public void comprobarApellido(String apellidos){
        boolean condicion = false;
        if(apellidos.isEmpty()){
            System.out.println("No puede estar vacío.");
            
        } else{
            for (int i = 0; i < apellidos.length(); i++){
               if (apellidos.charAt(i) >= '0' && apellidos.charAt(i) <= '9'){
                   condicion = true;
                   break;
               } else {
                   condicion = false;
               }
            }
        }
        if (condicion) {
            System.out.println("No puede tener numeros.");
        } else {
            this.apellidos = apellidos;
        };
    };
    
    public void comprobarNif(String nif){
        boolean cond = false;
        if (nif.length() != 9) {
            System.out.println("El nif debe ser de 9 digitos");
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
            System.out.println("Este NIF ya esta registrado.");
        } else {
            this.nif = nif;
        }
    };
      
    public void comprobarTelefono(String telefono) {
        boolean condicion = false;
        if (telefono.contains(CharSequence.class.cast(" "))) {
            System.out.println("No puede haber espacios");
        } else {
            if (telefono.length() != 9) {
                System.out.println("Debe tener nueve numeros.");
                return;
            } else {
                for (int i = 0; i < telefono.length(); i++) {
                    if (!(telefono.charAt(i) >= '0' && telefono.charAt(i) <= '9')) {
                        condicion = true;
                        break;
                    } else {
                        condicion = false;
                    }
                }
            }

            if (condicion) {
                System.out.println("Solo se permiten números");
            } else {
                this.telefono = telefono;
            }
        }
    }
        // Patrón para validar un email.
    
    Pattern patron = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
    
    public void introducirEmail(){
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Introduce tu email: ");
        email = in.nextLine();
        
        Matcher correo = patron.matcher(email);
              
        if (correo.find() == true) {
            System.out.println("El email ingresado es válido.");
        } else {
            System.out.println("El email ingresado es inválido.");
            introducirEmail();
        }
    };
    
    public Usuario nuevoUsuario(){
        Usuario u = new Usuario();
        Scanner in = new Scanner(System.in);
        u.generarId();
        System.out.println("Introduce el nombre, por favor: ");
        String nom;
        do {
            in = new Scanner(System.in);
            nom = in.nextLine();
            u.comprobarNombre(nom);
        } while(u.getNombre() != nom);
        System.out.println("Ahora su apellido, por favor: ");
        String ape;
        do{
            in = new Scanner(System.in);
            ape = in.nextLine();
            u.comprobarApellido(ape);
        }while(u.getApellidos() != ape);
        System.out.println("Introduce ahora el DNI: ");
        String dni;
        do{
            in = new Scanner(System.in);
            dni = in.nextLine();
            u.comprobarNif(dni);
        } while(u.getNif() != dni);
        System.out.println("Introduce tu número de teléfono: ");
        String telefono;
        do {
            in = new Scanner (System.in);
            telefono = in.nextLine();
            u.comprobarTelefono(telefono);
        } while (u.getTelefono() != telefono);
        introducirEmail();
        
        String contraseña;
        System.out.println("Introduce tu contraseña: ");
        do {
            in = new Scanner (System.in);
            contraseña = in.nextLine();
        } while (u.getPassword()!= contraseña);
        
        u.guardarUsuario();
        return u;
        
    };

    @Override
    public String toString() {
        return "La ID del usuario es" + id + ", el nombre es " + nombre + "los apellidos son " + apellidos + "\n" +" el NIF es " + nif + " su telefono es " + telefono + " el email es " + email + '}';
    }
    
    /**
     * 
     * @param array
     * @return ArrayList de un Array de Usuarios
     */
    public static ArrayList<Usuario> convertirUsuarios(Usuario[] array) {
        ArrayList<Usuario> ret = new ArrayList<>();
        for (Usuario usuario : array) {
            ret.add((Usuario)usuario);
        }
        return ret;
    }
    
    /**
     *  Metodo para exportar los usuarios.
     * @return Un string que se añade al fichero exportado
     */
 
    public String data() {
        return this.id + "|" + this.nombre + "|" + this.apellidos + "|" + this.nif + "|" + this.telefono + "|" + this.email;
    }

    /**
     * Crea un archivo de texto donde con el metodo data se escriben en cada linea cada empleado del array 
     * @param usuarios a escribir en el fichero
     */
    public static void guardarUsuarios(ArrayList<Usuario> usuarios) {
        try {
            BufferedWriter bw = null;
            File f = new File("usuarios.txt");
            if (f.createNewFile()) {
                try {
                    FileWriter fw = new FileWriter(f, true);
                    bw = new BufferedWriter(fw);
                    for (Usuario u : usuarios) {
                        bw.write(u.data());
                        bw.newLine();
                    }
                } catch (IOException e) {
                    System.out.println("Error de Entrada/Salida");
                    e.getStackTrace();
                } finally {
                    try {
                        bw.close();
                    } catch (IOException ex) {
                        System.out.println("Error de Entrada/Salida");
                        ex.getStackTrace();
                    }
                }
                System.out.println("Se ha creado el archivo con los Usuarios.");
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     * Guarda un usuario
     */
    public void guardarUsuario() {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter("usuario.txt", true);
            bw = new BufferedWriter(fw);
            bw.write(this.data());
            bw.newLine();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
            ex.getStackTrace();

        } catch (IOException ex) {
            ex.getStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el Stream");
                    ex.getStackTrace();
                }
            }
            if (fw != null) {
                try{
                    fw.close();
                } catch(IOException ex){
                    System.out.println("No se ha podido cerrar el FileWriter");
                    ex.getStackTrace();
                }
            }
        }

    }
    
    
    /**
     * 
     * @param ruta
     * @return Un arrayList con el Usuario importado
     */
     public static ArrayList<Usuario> importarUsuario(String ruta) {
        ArrayList<Usuario> ret = new ArrayList<>();
        Usuario u;
        String texto;
        File f = new File(ruta);
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            try {
                while ((texto = br.readLine()) != null) {
                    u = new Usuario();
                    String[] array = texto.split("\\|");
                    u.setId(Long.valueOf(array[0]));
                    u.setNombre(array[1]);
                    u.setApellidos(array[2]);
                    u.setNif(array[3]);
                    u.setTelefono(array[4]);
                    u.setEmail(array[5]);
                    u.setPassword(array[6]);
                    ret.add(u);
                }
            } catch (IOException i) {
                System.out.println(i.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
            ex.getStackTrace();
        } finally{
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el BufferedReader");
                    ex.getStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el FileReader");
                    ex.getStackTrace();
                }
            }
        }
        return ret;
    }
     
     public static void guardarUsuariosBinario(ArrayList<Usuario> usuarios) {
        OutputStream os = null;
        ObjectOutput out = null;
        try {
            os = new FileOutputStream("usuariosbin.txt");
            out = new ObjectOutputStream(os);
            for (Usuario u : usuarios) {
                out.writeObject(u);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
            ex.getStackTrace();
        } catch (IOException ex) {
            System.out.println("No se ha podido crear el OutputStream");
            ex.getStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el OutputStream");
                    ex.getStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar ObjectOutputStream");
                    ex.getStackTrace();
                }
            }
        }
    }
     
    public void guardarUsuarioBinario() {
        OutputStream os = null;
        ObjectOutput out = null;
        try {
            os = new FileOutputStream("usuariobin.txt");
            out = new ObjectOutputStream(os);
            out.writeObject(this);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
            ex.getStackTrace();
        } catch (IOException ex) {
            System.out.println("No se ha podido crear el OutputStream");
            ex.getStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el ObjectOutputStream");
                    ex.getStackTrace();
                }
            }
            if (os != null) {
                try{
                    os.close();
                }catch(IOException ex){
                    System.out.println("No se ha podido cerrar el OutputStream");
                    ex.getStackTrace();
                }
            }
        }
    }
    
    public static void leerObjetoBinarioUsuario() {
        InputStream is = null;
        ObjectInput in = null;
        try {
            is = new FileInputStream("usuariobin.txt");
            in = new ObjectInputStream(is);
            Usuario u = (Usuario) in.readObject();
            System.out.println(u);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
            ex.getStackTrace();
        } catch (IOException ex) {
            System.out.println("Error");
            ex.getStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Fallo al convertir el objeto a jugador");
            ex.getStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el ObjectInputStream");
                    ex.getStackTrace();
                }
            }
            if (is != null) {
                try{
                    is.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el InputStream");
                    ex.getStackTrace();
                }
            }
        }
    }
    
         public static void leerFicheroBinarioEmpleados() {
        InputStream is = null;
        ObjectInput oi = null;
        try {
            is = new FileInputStream("usuariosbin.txt");
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
    
    public static ArrayList<Usuario> importarUsuariosBinarios(String ruta) {
        ArrayList<Usuario> ret = new ArrayList<>();
        InputStream is = null;
        ObjectInput oi = null;
        try {
            is = new FileInputStream(ruta);
            oi = new ObjectInputStream(is);
            while (is.available() > 0) {
                Usuario u = (Usuario) oi.readObject();
                System.out.println("Se ha importado con exito el usuario: ");
                System.out.println(u.data());
                ret.add(u);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
            ex.getStackTrace();
        } catch (IOException ex) {
            System.out.println("Se ha dado una IOException");
            ex.getStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada");
            ex.getStackTrace();
        } finally{
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el InputStream");
                    ex.getStackTrace();
                }
            }
            if (oi != null) {
                try {
                    oi.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el ObjectInputStream");
                    ex.getStackTrace();
                }
            }
        }
        return ret;
    }

    public static Usuario getUsuarioByIDFichero(long id) {
        Usuario u = new Usuario();
        String texto;
        File f = new File("usuarios.txt");
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            try {
                while ((texto = br.readLine()) != null) {
                    String[] array = texto.split("\\|");
                    if (Long.valueOf(array[0]) == id) {
                        u.setId(Long.valueOf(array[0]));
                        u.setNombre(array[1]);
                        u.setApellidos(array[2]);
                        u.setNif(array[3]);
                        u.setTelefono(array[4]);
                        u.setEmail(array[5]);
                        System.out.println(u);
                        return u;
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
                    ex.getStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el FileReader");
                    ex.getStackTrace();
                }
            }
        }
        return u;
    }
    
}
