/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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

public class EmpleadoDeTeatro extends Empleado {

    private static final long serialVersionUID = 7402174013981203L;
    //VALORES VALIDOS: A, B, C, y D && VALORES INVALIDOS: CUALQUIER CARACTER DIFERENTE A A,B,C y D 
    protected char categoria;
    //CADA EMPLEADO DE TEATRO TIENE UNA NOMINA QUE ES CALCULADO POR SECRETARIO Y REVISADA POR DIRECCION
    private Nomina nomina;
    private long idGrupoDeTeatro;

    public EmpleadoDeTeatro() {
        super();
    }

    public EmpleadoDeTeatro(Empleado e) {
        super(e);
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public Nomina getNomina() {
        return nomina;
    }

    public void setNomina(Nomina nomina) {
        this.nomina = nomina;
    }

    public long getIdGrupoDeTeatro() {
        return idGrupoDeTeatro;
    }

    public void setIdGrupoDeTeatro(long idGrupoDeTeatro) {
        this.idGrupoDeTeatro = idGrupoDeTeatro;
    }
    
    public EmpleadoDeTeatro(long id, String nombre, String apellidos, String nif, String direccion, String telefono, char categoria, Nomina nomina) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.categoria = categoria;
        this.nomina = nomina;
    }

    public EmpleadoDeTeatro(Empleado e, char categoria, Nomina nomina) {
        super(e);
        this.categoria = categoria;
        this.nomina = nomina;
    }

    public EmpleadoDeTeatro(Empleado e, char categoria, long idGrupoDeTeatro){
        super(e);
        this.categoria = categoria;
        this.idGrupoDeTeatro = idGrupoDeTeatro;
    }
    
    /**
     * Valida la categoria de empleados de teatro
     *
     * @param categoria a validar
     * @return boolean
     */
    public boolean validarCategoria(char categoria) {
        //Comprueba que sea un categoria existente.
        if (categoria != 'A' && categoria != 'B' && categoria != 'C' && categoria != 'D') {
            System.out.println("La categoria solo puede ser A, B, C o D");
            //Setea la categoria del empleado.
        } else {
            return true;
        }
        return false;
    }

    /**
     * Crea y devuelve un empleado de teatro con los datos introducidos.
     *
     * @param empleados donde se añade
     * @return empleado de teatro
     */
    public static EmpleadoDeTeatro nuevoEmpleadoDeTeatro(ArrayList<Empleado> empleados) {
        Empleado e = Empleado.nuevoEmpleado(empleados);
        EmpleadoDeTeatro et = new EmpleadoDeTeatro(e);
        Scanner sc;
        System.out.println("Introduce la categoria");
        char c;
        do {
            c = 0;
            sc = new Scanner(System.in);
            c = sc.next().charAt(c);
            if (et.validarCategoria((char) c)) {
                et.setCategoria(c);
            }
        } while (et.getCategoria() != c);
        return et;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + ", direccion=" + direccion + ", telefono=" + telefono + ", categoria" + categoria + ", nomina" + nomina + '}';
    }

    @Override
    public String data() {
        return this.id + "|" + this.nombre + "|" + this.apellidos + "|" + this.nif + "|" + this.direccion + "|" + this.telefono + "|" + this.categoria + "|" + this.idnomina;
    }

    public static void guardarEmpleadosDeTeatro(ArrayList<EmpleadoDeTeatro> empleados) {
        try {
            BufferedWriter bw = null;
            File f = new File("empleadosdeteatro.txt");
            if (f.createNewFile()) {
                try {
                    FileWriter fw = new FileWriter(f, true);
                    bw = new BufferedWriter(fw);
                    for (EmpleadoDeTeatro e : empleados) {
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

    public static void guardarEmpleadosDeTeatroBinario(ArrayList<EmpleadoDeTeatro> empleados) {
        OutputStream os = null;
        ObjectOutput out = null;
        try {
            os = new FileOutputStream("empleadosdeteatrobinario.txt");
            out = new ObjectOutputStream(os);
            for (EmpleadoDeTeatro e : empleados) {
                out.writeObject(e);
                out.flush();
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

    public void guardarEmpleadoDeTeatroBinario() {
        OutputStream os = null;
        ObjectOutput out = null;
        try {
            os = new FileOutputStream("empleadodeteatrobinario.txt");
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
                try {
                    os.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el OutputStream");
                }
            }
        }
    }

    public static void leerObjetoBinarioEmpleadoDeTeatro() {
        InputStream is = null;
        ObjectInput in = null;
        try {
            is = new FileInputStream("empleadodeteatrobinario.txt");
            in = new ObjectInputStream(is);
            EmpleadoDeTeatro e = (EmpleadoDeTeatro) in.readObject();
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
                try {
                    is.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el InputStream");
                }
            }
        }

    }

    public static void leerFicheroBinarioEmpleadosDeTeatro() {
        InputStream is = null;
        ObjectInput oi = null;
        try {
            is = new FileInputStream("empleadosdeteatrobinario.txt");
            oi = new ObjectInputStream(is);
            while (is.available() > 0) {
                EmpleadoDeTeatro e = (EmpleadoDeTeatro) oi.readObject();
                System.out.println(e.toString());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("No se ha podido crear el ObjectInputStream");
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada");
        } finally {
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
    }

    public void guardarEmpleadoDeTeatro() {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter("empleadosdeteatro.txt", true);
            bw = new BufferedWriter(fw);
            bw.write(this.data());
            bw.newLine();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");

        } catch (IOException ex) {
            System.out.println("No se ha podido escribir el objeto");
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el Stream");
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ex) {
                    System.out.println("No se ha podido cerrar el FileWriter");
                }
            }
        }

    }

    public static ArrayList<EmpleadoDeTeatro> importarEmpleadosDeTeatroBinarios(String ruta) {
        ArrayList<EmpleadoDeTeatro> ret = new ArrayList<>();
        InputStream is = null;
        ObjectInput oi = null;
        try {
            is = new FileInputStream(ruta);
            oi = new ObjectInputStream(is);
            while (is.available() > 0) {
                EmpleadoDeTeatro e = (EmpleadoDeTeatro) oi.readObject();
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
        } finally {
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

    public static ArrayList<EmpleadoDeTeatro> importarEmpleadoDeTeatro(String ubicacion) {
        ArrayList<EmpleadoDeTeatro> ret = new ArrayList<>();
        EmpleadoDeTeatro e;
        String texto;
        File f = new File(ubicacion);
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            try {
                while ((texto = br.readLine()) != null) {
                    e = new EmpleadoDeTeatro();
                    String[] array = texto.split("\\|");
                    e.setId(Long.valueOf(array[0]));
                    e.setNombre(array[1]);
                    e.setApellidos(array[2]);
                    e.setNif(array[3]);
                    e.setDireccion(array[4]);
                    e.setTelefono(array[5]);
                    e.setCategoria(array[6].charAt(0));
                    e.setIdnomina(Long.parseLong(array[7]));
                    ret.add(e);
                }
            } catch (IOException i) {
                System.out.println(i.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } finally {
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

    public static Empleado getEmpleadoDeTeatroByIDFichero(long id) {
        EmpleadoDeTeatro e = new EmpleadoDeTeatro();
        String texto;
        File f = new File("empleadosdeteatro.txt");
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
                        e.setCategoria(array[6].charAt(0));
                        e.setIdnomina(Long.parseLong(array[7]));
                        return e;
                    }
                }
            } catch (IOException i) {
                System.out.println(i.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } finally {
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
