package Entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Utilidades {

    //He declarado la franquicia para que no me de error
    static Franquicia franquicia = new Franquicia();
    //long id, String nombre, String apellidos, String nif, String direccion, String telefono, franquicia franquicia
    public static final Empleado EMPLEADOS[] = {
        new Empleado(1, "Amelio", "Pascual", "12345678A", "Madrid, Las Rozas", "293932238", franquicia, franquicia.getId()),
        new Empleado(2, "Jose Juan", "Garcia", "23456789S", "Cantabria, Soto", "123431314", franquicia, franquicia.getId()),
        new Empleado(3, "Pepe", "Perez", "34567891A", "Alicante", "134123764", franquicia, franquicia.getId()),
        new Empleado(4, "Aitor", "Mendizabal", "54348943C", "Murcia", "345501459", franquicia, franquicia.getId()),
        new Empleado(5, "Josito", "Fernandez", "83774591A", "Galicia, Vigo", "123459230", franquicia, franquicia.getId()),
        new Empleado(6, "Alex", "Perez", "34912312A", "Cantabria", "124451123", franquicia, franquicia.getId()),
        new Empleado(7, "Guillermo", "Illera", "45913412F", "Cantabria", "459213459", franquicia, franquicia.getId()),
        new Empleado(8, "Sandra", "Burgos", "34939139A", "Cantabria", "864344459", franquicia, franquicia.getId()),
        new Empleado(9, "Pepito", "Garcia", "49583943V", "Almeria", "495459348", franquicia, franquicia.getId()),
        new Empleado(10, "Manolo", "Eliot", "98545621A", "Valencia", "987654123", franquicia, franquicia.getId()),
        new Empleado(11, "Jesus", "Garcia", "458325461A", "Andalucia, Malaga", "786594132", franquicia, franquicia.getId()),
        new Empleado(12, "Jose", "Pascual", "65748932A", "Cantabria, Rasines", "986574213", franquicia, franquicia.getId()),
        new Empleado(12, "Txema", "Fernandez", "98745821D", "Asturias, Oviedo", "987478652", franquicia, franquicia.getId()),
        new Empleado(13, "Pepe", "Mendizabal", "78496512A", "Galicia, A Coruña", "654796123", franquicia, franquicia.getId()),
        new Empleado(14, "Allejo", "Perez", "86496512A", "Galicia, A Coruña", "982796123", franquicia, franquicia.getId()),
        new Empleado(15, "Octavio", "Gonzales", "92496512D", "Galicia, A Coruña", "658796123", franquicia, franquicia.getId())};

    // long id, Date mesyano, otra vez ni puta idea de poner la fecha.
    public static final Nomina NOMINAS[] = {
        new Nomina(1, new Date(2010, 11, 28)),
        new Nomina(2, new Date(2016, 5, 10)),
        new Nomina(3, new Date(2014, 2, 21)),
        new Nomina(4, new Date(2019, 12, 12)),
        new Nomina(5, new Date(2010, 2, 31)),
        new Nomina(6, new Date(2009, 12, 5)),
        new Nomina(7, new Date(2019, 12, 12)),
        new Nomina(8, new Date(2019, 12, 12)),
        new Nomina(9, new Date(2019, 12, 12))
    };

    //He declarado un ArrayList para que no me de error
    static ArrayList<EmpleadoDeTeatro> empleadosTeatro = new ArrayList<>();

    // He declarado Informe, empleados y GTrabajo para que no diese error
    static Informe informe;
    static GTrabajo GTrabajo;
    static ArrayList<Empleado> Empleados = new ArrayList();

    public static final Franquicia FRANQUICIAS[] = {
        new Franquicia(1, new Date(2019, 12, 12), "Barcelona, Llissá de Munt", true, informe, Empleados, GTrabajo),
        new Franquicia(2, new Date(2019, 12, 12), "Madrid, Zofío", false, informe, Empleados, GTrabajo),
        new Franquicia(3, new Date(2019, 12, 12), "Cantabria, Santander", true, informe, Empleados, GTrabajo),
        new Franquicia(4, new Date(2019, 12, 12), "Galicia, Vigo", false, informe, Empleados, GTrabajo),
        new Franquicia(5, new Date(2019, 12, 12), "Almería, Níjar", true, informe, Empleados, GTrabajo),
        new Franquicia(6, new Date(2019, 12, 12), "Alicante, Benidorm", false, informe, Empleados, GTrabajo)
    };

    //char categoria, Nomina nomina
    public static final EmpleadoDeTeatro EMPLEADOSDETEATRO[] = {
        new EmpleadoDeTeatro(EMPLEADOS[0], 'A', NOMINAS[0]),
        new EmpleadoDeTeatro(EMPLEADOS[1], 'C', NOMINAS[1]),
        new EmpleadoDeTeatro(EMPLEADOS[2], 'B', NOMINAS[2]),
        new EmpleadoDeTeatro(EMPLEADOS[3], 'A', NOMINAS[3]),
        new EmpleadoDeTeatro(EMPLEADOS[4], 'D', NOMINAS[4]),
        new EmpleadoDeTeatro(EMPLEADOS[5], 'C', NOMINAS[5]),
        new EmpleadoDeTeatro(EMPLEADOS[6], 'D', NOMINAS[7]),
        new EmpleadoDeTeatro(EMPLEADOS[7], 'B', NOMINAS[6]),
        new EmpleadoDeTeatro(EMPLEADOS[8], 'A', NOMINAS[8]),};

    //protected int
    public static final EmpleadoDeOficina EMPLEADOSDEOFICINA[] = {
        new EmpleadoDeOficina(EMPLEADOS[9], 1),
        new EmpleadoDeOficina(EMPLEADOS[10], 2),
        new EmpleadoDeOficina(EMPLEADOS[11], 3),
        new EmpleadoDeOficina(EMPLEADOS[12], 4)

    };

    // long id, String nombre, String apellidos, String nif, String direccion, String telefono, int añosPlantillaD
    public static final Direccion DIRECCIONES[] = {
        new Direccion(EMPLEADOS[13], 4),
        new Direccion(EMPLEADOS[14], 10),
        new Direccion(EMPLEADOS[15], 1)
    };

    //Empleado e, char categoria, Nomina nomina
    public static final Limpieza LIMPIADORES[] = {
        new Limpieza(EMPLEADOS[0], 'A', NOMINAS[1]),
        new Limpieza(EMPLEADOS[1], 'C', NOMINAS[0]),
        new Limpieza(EMPLEADOS[2], 'B', NOMINAS[2])
    };
    //Empleado e, char categoria, Nomina nomina
    public static final Acomodador ACOMODADORES[] = {
        new Acomodador(EMPLEADOS[3], 'B', NOMINAS[3]),
        new Acomodador(EMPLEADOS[4], 'A', NOMINAS[4]),
        new Acomodador(EMPLEADOS[5], 'C', NOMINAS[5])
    };

    //long id, long semana, long mes, ArrayList <EmpleadosDeTeatro> empleadosTeatro, franquicia franquicia 
    public static final GTrabajo GTRABAJO[] = {
        new GTrabajo(1, 3, 2, FRANQUICIAS[1], empleadosTeatro, FRANQUICIAS[1].getId()),
        new GTrabajo(2, 1, 6, FRANQUICIAS[0], empleadosTeatro, FRANQUICIAS[0].getId()),
        new GTrabajo(5, 2, 8, FRANQUICIAS[2], empleadosTeatro, FRANQUICIAS[2].getId()),
        new GTrabajo(3, 6, 1, FRANQUICIAS[3], empleadosTeatro, FRANQUICIAS[3].getId()),
        new GTrabajo(9, 2, 12, FRANQUICIAS[4], empleadosTeatro, FRANQUICIAS[4].getId()),
        new GTrabajo(4, 4, 3, FRANQUICIAS[5], empleadosTeatro, FRANQUICIAS[5].getId())
    };

    // long id, Date fecha, double importe, Acomodador acomodador, Nomina nomina, Informe informe
    // long id, Date fecha, double importe, Limpieza limpieza, Nomina nomina, Informe informe
    public static final Coste COSTES[] = {
        new Coste(1, new Date(2010, 11, 28), 23, ACOMODADORES[0], LIMPIADORES[0], NOMINAS[0]),
        new Coste(2, new Date(2010, 11, 28), 800, LIMPIADORES[1], NOMINAS[1])};

    // long id, char tipo, int mes
    public static final Bono BONOS[] = {
        new Bono(1, 'C', 5),
        new Bono(2, 'P', 8),
        new Bono(3, 'C', 6),
        new Bono(4, 'C', 1),
        new Bono(5, 'P', 12)
    };

    // long id, String nombre, String apellidos, String nif, int telefono, String email e idBonos
    public static final Usuario USUARIOS[] = {
        new Usuario(1, " Guillermo ", "Illera ", "21141255T ", "648937009", "guillermo.illera97@gmail.com", 1),
        new Usuario(2, " Bernat ", "Cid ", "16874298G ", "648941259", "guillermo.illera97@gmail.com", 2),
        new Usuario(3, " Candido ", "Cuellar ", "65100987H", "612684941", "guillermo.illera97@gmail.com", 5),
        new Usuario(4, " Mireya ", "Bustos ", "65160165T ", "981985321", "guillermo.illera97@gmail.com", 7),
        new Usuario(5, " Elver ", "Galarga ", "91871326F ", "648919849", "guillermo.illera97@gmail.com", 3)
    };

    //Empleado e, char categoria, Nomina nomina
    public static final Taquillero TAQUILLEROS[] = {
        new Taquillero(EMPLEADOS[6], 'A', NOMINAS[6]),
        new Taquillero(EMPLEADOS[7], 'B', NOMINAS[7]),
        new Taquillero(EMPLEADOS[8], 'C', NOMINAS[8])
    };

    // long id, Date fecha, double importe, double reporte, Taquillero taquillero
    public static final Beneficio BENEFICIOS[] = {
        new Beneficio(1, new java.sql.Date(2019, 12, 12), 27.04, 300.3, TAQUILLEROS[0]),
        new Beneficio(2, new java.sql.Date(2019, 12, 12), 20.18, 300.6, TAQUILLEROS[1])
    };

    public static final Secretariado SECRETARIOS[] = {
        new Secretariado(EMPLEADOS[9], 1),
        new Secretariado(EMPLEADOS[10], 2),
        new Secretariado(EMPLEADOS[11], 3)
    };
    // He declarado un arraylist para que no me diese error
    static ArrayList<Beneficio> beneficios = new ArrayList<>();
    static ArrayList<Coste> Costes = new ArrayList<>();
    // long id, Date mesyano, double balance, Secretariado secretario, ArrayList<Beneficio> beneficios,  ArrayList<Coste> costes
    public static final Informe INFORMES[] = {
        new Informe(1, new Date(2019, 12, 12), 300.4, SECRETARIOS[0], beneficios, Costes),
        new Informe(2, new Date(2019, 12, 12), 400.3, SECRETARIOS[1], beneficios, Costes),
        new Informe(3, new Date(2019, 12, 12), 282.7, SECRETARIOS[2], beneficios, Costes),
        new Informe(4, new Date(2019, 12, 12), 274.4, SECRETARIOS[0], beneficios, Costes),
        new Informe(5, new Date(2019, 12, 12), 182.9, SECRETARIOS[1], beneficios, Costes),
        new Informe(6, new Date(2019, 12, 12), 455.3, SECRETARIOS[2], beneficios, Costes),
        new Informe(7, new Date(2019, 12, 12), 964.6, SECRETARIOS[0], beneficios, Costes),
        new Informe(8, new Date(2019, 12, 12), 412.01, SECRETARIOS[1], beneficios, Costes),
        new Informe(9, new Date(2019, 12, 12), 202.1, SECRETARIOS[2], beneficios, Costes)
    };

    public static boolean leerBoolean() {
        boolean ret;
        Scanner in;
        char resp;
        do {
            System.out.println("Pulse S para Sí o N para No");
            in = new Scanner(System.in, "ISO-8859-1");
            resp = in.nextLine().charAt(0);
            if (resp != 's' && resp != 'S' && resp != 'n' && resp != 'N') {
                System.out.println("Valor introducido incorrecto.");
            }
        } while (resp != 's' && resp != 'S' && resp != 'n' && resp != 'N');
        if (resp == 's' || resp != 'S') {
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    }

    /**
     * Función que pide al usuario una fecha mediante el año, el mes y el día.
     *
     * @return date (fecha)
     */
    public static Date dameFecha() {

        Scanner in = new Scanner(System.in);

        System.out.println("Dame el año:");
        int year = in.nextInt();
        System.out.println("Dame el mes:");
        int month = in.nextInt();
        System.out.println("Dame el día:");
        int day = in.nextInt();
        Date date = new Date(year, month, day);

        System.out.println("La fecha introducida es:" + date);
        return date;
    }
    ;
    
    private static final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
    
    public static void leerFichero(String ubicacion) {
        String texto;
        File f = new File(ubicacion);
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                while ((texto = br.readLine()) != null) {
                    System.out.println(texto);
                }
                br.close();
            } catch (IOException i) {
                System.out.println(i.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }
    
    public static void escribirFichero(String ubicacion) {
        String linea;
        BufferedWriter bw = null;
        BufferedReader br = null;
        File f = new File(ubicacion);
        try {
            FileWriter fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            System.out.println("Escribe para saltar de linea pulsa enter y para salir pulsa enter en una linea vacia para salir");
            do {
                linea = br.readLine();
                if (!linea.isEmpty()) {
                    bw.write(linea);
                    bw.newLine();
                }
            } while (!linea.isEmpty());
        } catch (IOException e) {
            System.out.println("Error");
        } finally {
            try {
                bw.close();
                br.close();
            } catch (IOException ex) {
                System.out.println("Error");
            }
        }
    }
}
