package Entidades;

import Entidades.Bono;
import java.util.ArrayList;
import java.util.Scanner;
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
    private ArrayList<Bono> bonos = new ArrayList<>();
    
    
    
    public Usuario () {
        
    }
    
    public Usuario (long id, String nombre, String apellidos, String nif, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.telefono = telefono;
        this.email = email;
    }
    
     public Usuario (Usuario usu){
        this.id = usu.id;
        this.nombre = usu.nombre;
        this.apellidos = usu.apellidos;
        this.nif = usu.nif;
        this.telefono = usu.telefono;
        this.email = usu.email;
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
    
    public void generarId(){
       this.id = Utilidades.USUARIOS.length + 1;
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
        return u;
        
    };
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", telefono=" + telefono + ", email=" + email + '}';
    }
}
