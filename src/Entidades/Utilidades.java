package Entidades;

import java.util.ArrayList;
import static javafx.scene.input.KeyCode.T;
import java.util.Date;


public class Utilidades {
    
    static final Date fecha1 = new Date(2010, 11, 28);
    static final Date fecha2 = new Date(2016, 5, 10);
    static final Date fecha3 = new Date(2014, 2, 21);
    static final Date fecha4 = new Date(2019, 12, 12);
    static final Date fecha5 = new Date(2020, 5, 24);
    static final Date fecha6 = new Date(2005, 1, 29);
    static final Date fecha7 = new Date(2002, 5, 28);
    static final Date fecha8 = new Date(1997, 7, 17);
    static final Date fecha9 = new Date(2010, 2, 13);
    static final Date fecha10 = new Date(2010, 9, 12);
    static final Date fecha11 = new Date(2015, 8, 30);
    static final Date fecha12 = new Date(2012, 7, 20);
    static final Date fecha13 = new Date(2013, 3, 15);
    static final Date fecha14 = new Date(2019, 8, 13);
    static final Date fecha15 = new Date(2017, 1, 18);
    static final Date fecha16 = new Date(2016, 2, 11);
    static final Date fecha17 = new Date(2014, 1, 10);
    static final Date fecha18 = new Date(2012, 10, 19);
    static final Date fecha19 = new Date(2011, 12, 17);
    static final Date fecha20 = new Date(2019, 12, 15);
      
    
          
    //He declarado la Franquicia para que no me de error
    static Franquicia Franquicia;
    //long id, String nombre, String apellidos, String nif, String direccion, String telefono, Franquicia Franquicia
    public static final Empleado EMPLEADOS[] = {
        new Empleado(1, "Amelio", "Pascual", "12345678A", "Madrid, Las Rozas", "293932238", Franquicia),
        new Empleado(2, "Jose Juan", "Garcia", "23456789S", "Cantabria, Soto", "123431314", Franquicia),
        new Empleado(3, "Pepe", "Perez", "34567891A", "Alicante", "134123764", Franquicia),
        new Empleado(4, "Aitor", "Mendizabal", "54348943C", "Murcia", "345501459", Franquicia),
        new Empleado(5, "Josito", "Fernandez", "83774591A", "Galicia, Vigo", "123459230", Franquicia),
        new Empleado(6, "Alex", "Perez", "34912312A", "Cantabria", "124451123", Franquicia),
        new Empleado(7, "Guillermo", "Illera", "45913412F", "Cantabria", "459213459", Franquicia),
        new Empleado(8, "Sandra", "Burgos", "34939139A", "Cantabria", "864344459", Franquicia),
        new Empleado(9, "Pepito", "Garcia", "49583943V", "Almeria", "495459348", Franquicia),

    };

    //He declarado un ArrayList para que no me de error
    static ArrayList<EmpleadoDeTeatro> EmpleadosTeatro = new ArrayList<>();
    //long id, long semana, ArrayList <EmpleadosDeTeatro> EmpleadosTeatro, Franquicia franquicia 
    public static final GTrabajo GTRABAJO[] = {
        new GTrabajo(1, 3, Franquicia, EmpleadosTeatro),
        new GTrabajo(2, 1, Franquicia, EmpleadosTeatro),
        new GTrabajo(5, 7, Franquicia, EmpleadosTeatro),
        new GTrabajo(3, 6, Franquicia, EmpleadosTeatro),
        new GTrabajo(9, 2, Franquicia, EmpleadosTeatro),};
    
        
    // long id, Date mesyano, otra vez ni puta idea de poner la fecha.
    
    public static final Nomina NOMINAS[] = {
        new Nomina(1,fecha1),
        new Nomina(2,fecha2),
        new Nomina(3,fecha3),
        new Nomina(4,fecha4),
        new Nomina(5,fecha5),
        new Nomina(6,fecha6),
        new Nomina(7,fecha7),
        new Nomina(8,fecha8),
        new Nomina(9,fecha9),
    };
    
    //char categoria, Nomina nomina
    public static final EmpleadoDeTeatro EMPLEADOSDETEATRO[] = {
        new EmpleadoDeTeatro(EMPLEADOS[0], 'A', NOMINAS[0]),
        new EmpleadoDeTeatro(EMPLEADOS[1], 'C', NOMINAS[1]),
        new EmpleadoDeTeatro(EMPLEADOS[2], 'B', NOMINAS[2]),
        new EmpleadoDeTeatro(EMPLEADOS[3], 'A', NOMINAS[3]),
        new EmpleadoDeTeatro(EMPLEADOS[4], 'D', NOMINAS[4])
    };

    //protected int
    public static final EmpleadoDeOficina EMPLEADOSDEOFICINA[] = {
        new EmpleadoDeOficina(EMPLEADOS[5], 1),
        new EmpleadoDeOficina(EMPLEADOS[6], 2),
        new EmpleadoDeOficina(EMPLEADOS[7], 3),
        new EmpleadoDeOficina(EMPLEADOS[8], 4)

    };
    
    // long id, Date fecha, double importe, Acomodador acomodador, Nomina nomina, Informe informe
    // long id, Date fecha, double importe, Limpieza limpieza, Nomina nomina, Informe informe
    // Dan error porque no tengo ni puñetera idea de poner la fecha.
    
    static Acomodador acomodador;
    static Limpieza limpieza;
    static Informe informe;
    
    public static final Coste COSTES[] = {
        new Coste(1,fecha10, 23, acomodador, limpieza, NOMINAS[0] ,informe),
        new Coste(2,fecha11, 800, limpieza, NOMINAS[1] ,informe),
    };
    
    // long id, char tipo, int mes
    
    public static final Bono BONOS[] = {
        new Bono(1,'C', 5),
        new Bono(2, 'P', 8),
        new Bono(3, 'C', 6),
        new Bono(4, 'C', 1),
        new Bono(5, 'P', 12)
    };

    // long id, String nombre, String apellidos, String nif, String telefono, String email
    public static final Usuario USUARIOS[] = {
        new Usuario(1," Guillermo ", "Illera ", "21141255T ","648937009","guillermo.illera97@gmail.com"),
        new Usuario(1," Bernat ", "Cid ", "16874298G ","648941259","guillermo.illera97@gmail.com"),
        new Usuario(1," Candido ", "Cuellar ", "65100987H ","612684941","guillermo.illera97@gmail.com"),
        new Usuario(1," Mireya ", "Bustos ", "65160165T ","981985321","guillermo.illera97@gmail.com"),
        new Usuario(1," Elver ", "Galarga ", "91871326F ","648919849","guillermo.illera97@gmail.com")
    };
    
    
    
    // He declarado Informe, empleados y GTrabajo para que no diese error
    static Informe Informe;
    static GTrabajo GTrabajo;
    static ArrayList<Empleado> Empleados = new ArrayList();
    // long ID, Date fecha_creacion, String ubicacion, boolean accesibilidad_reducida, Informe informe, ArrayList<Empleado> empleados, GTrabajo grupotrabajo

    /**
     *
     */
    public static final Franquicia FRANQUICIAS[] = {
        new Franquicia (1,fecha12, "Barcelona, Llissá de Munt", true, Informe, Empleados, GTrabajo),
        new Franquicia (2,fecha13, "Madrid, Zofío", false, Informe, Empleados, GTrabajo),
        new Franquicia (3,fecha14, "Cantabria, Santander", true, Informe, Empleados, GTrabajo),
        new Franquicia (4,fecha15, "Galicia, Vigo", false, Informe, Empleados, GTrabajo),
        new Franquicia (5,fecha17, "Almería, Níjar", true, Informe, Empleados, GTrabajo),
        new Franquicia (6,fecha18,"Alicante, Benidorm", false, Informe, Empleados, GTrabajo)
    }; 


    // long id, String nombre, String apellidos, String nif, String direccion, String telefono, int añosPlantillaD
    public static final Direccion DIRECCIONES[] = {
        new Direccion (1, "Mario", "Martin", "72207652K", "Barcelona, Llissá de Munt", "654608343", 4)
    };
    
    // He declarado un arraylist para que no me diese error
    static ArrayList<Beneficio> beneficios = new ArrayList<>();
    // static ArrayList<Coste> costes = new ArrayList<>();
    // long id, Date mesyano, double balance, Secretariado secretario, ArrayList<Beneficio> beneficios,  ArrayList<Coste> costes
    static Secretariado secretariado;
    static ArrayList<Coste> Costes = new ArrayList<>();
    public static final Informe INFORMES[] = {
        new Informe (1, fecha10, 300.4, secretariado, beneficios, Costes),
        new Informe (2, fecha11, 400.3, secretariado, beneficios, Costes),
        new Informe (3, fecha12, 282.7, secretariado, beneficios, Costes),
        new Informe (4, fecha13, 274.4, secretariado, beneficios, Costes),
        new Informe (5, fecha14, 182.9, secretariado, beneficios, Costes),
        new Informe (6, fecha15, 455.3, secretariado, beneficios, Costes),
        new Informe (7, fecha16, 964.6, secretariado, beneficios, Costes),
        new Informe (8, fecha17, 412.01, secretariado, beneficios, Costes),
        new Informe (9, fecha18, 202.1, secretariado, beneficios, Costes)
    };

    // long id, Date fecha, double importe, double reporte, Taquillero taquillero
    static Taquillero taquillero;
    public static final Beneficio BENEFICIOS[] = {
        new Beneficio (1, fecha19, 27.04, 300.3, taquillero),
        new Beneficio (2, fecha20, 20.18, 300.6, taquillero)
    };
}
