package Entidades;
// Guillermo Illera Vinatea
import java.util.ArrayList;
import java.util.Scanner;

public class GTrabajo {
    
    //VALORES VALIDOS: NÚMEROS ENTEROS,  HA DE SER ÚNICO PARA CADA INSTANCIA  > 0 && VALORES INVALIDOS: NÚMEROS ENTEROS <= 0
    private long id;
    //VALORES VALIDOS: NUMEROS ENTEROS => 1 y <=6 && VALORES INVALIDOS: CUALQUIER CARACTER O NUMERO DIFERENTE
    private long semana;
    
    // Valores validos: Numeros enteros mayores de 1 y menores de 12. Valores invalidos: Cualquier letra, o numero fuera del rango establecido.
    private long mes;
    
    // Se guarda una lista de los trabajadores que forman parte de grupo de trabajo
    private ArrayList<EmpleadoDeTeatro> EmpleadosTeatro = new ArrayList<>();
    
    // Se guarda la franquicia donde está el grupo de trabajo
    private static Franquicia franquicia;
    
    public GTrabajo(){};
    
    public GTrabajo(GTrabajo gt){
        this.id = gt.id;
        this.semana = gt.semana;
        this.EmpleadosTeatro = gt.EmpleadosTeatro;
        this.franquicia = gt.franquicia;
        this.mes = gt.mes;
    };
    
    public GTrabajo(long id, long semana, long mes,Franquicia franquicia, ArrayList<EmpleadoDeTeatro> EmpleadosTeatro) {
        this.id = id;
        this.semana = semana;
        this.franquicia = franquicia;
        this.EmpleadosTeatro = EmpleadosTeatro;
        this.mes = mes;
    }

    public long getId() {
        return id;
    }

    public long getSemana() {
        return semana;
    }

    public long getMes() {
        return mes;
    }

    public ArrayList<EmpleadoDeTeatro> getEmpleadosTeatro() {
        return EmpleadosTeatro;
    }

    public Franquicia getFranquicia() {
        return franquicia;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSemana(long semana) {
        this.semana = semana;
    }

    public void setMes(long mes) {
        this.mes = mes;
    }
    
    public void setEmpleadosTeatro(ArrayList<EmpleadoDeTeatro> EmpleadosTeatro) {
        this.EmpleadosTeatro = EmpleadosTeatro;
    }

    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }

    public long generarId() {
        long id = 0;
        for (GTrabajo gt : Utilidades.GTRABAJO) {
            if (id < gt.id) {
                id = gt.id;
            }
        }
    return id+1;}
    
    public void validarSemana(long semana){
        if (!(semana >= 1 && semana <=6)) {
            System.out.println("Solo puede estar entre la semana 1 y la 6");
        } else{
            this.semana = semana;
        }
    }
    
    public static GTrabajo nuevoGTrabajo(){
        
        ArrayList<EmpleadoDeTeatro> empleadosLimpiadores = GTrabajo.convertirEmpleadoTeatro(Utilidades.LIMPIADORES);
        ArrayList<EmpleadoDeTeatro> empleadosAcomodadores = GTrabajo.convertirEmpleadoTeatro(Utilidades.ACOMODADORES);
        ArrayList<EmpleadoDeTeatro> empleadosTaquilleros = GTrabajo.convertirEmpleadoTeatro(Utilidades.TAQUILLEROS);
        
        // Declaro un ArrayList para guardar los empleados de Teatro.
        ArrayList<EmpleadoDeTeatro> empleadosTeatro = new ArrayList<>();
        empleadosTeatro.addAll(empleadosLimpiadores);
        empleadosTeatro.addAll(empleadosAcomodadores);
        empleadosTeatro.addAll(empleadosTaquilleros);
        GTrabajo gt = new GTrabajo();
        
        Scanner in = new Scanner(System.in);
        gt.setId(gt.generarId());
        
        System.out.println("Introduzca la semana: " + "\n");
        long semana;
        do {
            semana =-1;
            in = new Scanner(System.in);
            semana = in.nextLong();
            gt.validarSemana(semana);
        } while (gt.getSemana() != semana || semana <= 0 || semana > 6);
        
        System.out.println("¿Cuantos usuarios desea introducir en el grupo?" + "\n");
        int nUsuarios, opcionMenuUsuarios, opcionMenuFranquicias;
        nUsuarios = in.nextInt();
        
        for (int i = 0; i < nUsuarios; i++) {
            do {
               System.out.println("¿Como desea introducir el usuario numero " + (i+1) + "?" + "\n" 
            +   "Pulse 1 para introducir por ID." + "\n" 
            +   "Pulse 2 para introducir por NIF." + "\n"
            +   "Pulse 3 para introducir por Nombre y apellidos." + "\n"
            +   "Pulse 4 para salir." + "\n");
               opcionMenuUsuarios = in.nextInt();
               
               if (opcionMenuUsuarios > 4){
                   System.out.println("Opcion invalida, introduzca otra por favor.");
               };
               
               switch (opcionMenuUsuarios) {
                   case 1: // Por ID
                       int idUsuario;
                       ArrayList <Empleado> nuevoGrupo = new ArrayList <Empleado>();
                       Scanner scId = new Scanner (System.in);
                       System.out.println("Introduce el ID del empleado que quieres añadir: ");
                       idUsuario = scId.nextInt();
                       nuevoGrupo.add(Empleado.añadirEmpleadobyID(idUsuario, empleadosTeatro, nuevoGrupo));
                       System.out.println(nuevoGrupo);
                       break;
                   
                   case 2: // Por NIF
                       break;
                    
                   case 3: // Por nombre y apellidos
                       break;
                   
                   default:
               }
               
            } while(opcionMenuUsuarios > 4);
        };
        
        do {
               System.out.println("¿Como desea registrar la Franquicia en la que trabajaran?" + "\n" 
            +   "Pulse 1 para introducir por ID." + "\n" 
            +   "Pulse 2 para introducir por Nombre y apellidos." + "\n"
            +   "Pulse 3 para salir." + "\n");
               
               opcionMenuFranquicias = in.nextInt();
               
               if (opcionMenuFranquicias > 3){
                   System.out.println("Opcion invalida, introduzca otra por favor.");
               };
               
               switch (opcionMenuFranquicias) {
                   case 1: // Por ID
                       int idFranquicia;
                       boolean condicion;
                       Scanner scId = new Scanner (System.in);
                       System.out.println("Introduce el ID de la Franquicia que quieres añadir: ");
                       
                       /*
                       
                       idFranquicia = scId.nextInt();
                       do {
                       
                        Franquicia.buscarFranquicia(idFranquicia);
                           System.out.println("¿Es esta la Franquicia que quiere añadir?");
                           gt.setFranquicia(franquicia);
                           condicion = Utilidades.leerBoolean();
                       } while (condicion == false);
                       
                       
                       
                       break; */
                   
                   case 2: // Por NIF
                       break;
                   
                   default:
               }
               
            } while(opcionMenuFranquicias > 3);
        
    return gt;}

    @Override
    public String toString() {
        String ret;
        ret = "El grupo de trabajo con " + "id " + id + " en la semana " + semana + " y el mes " + mes + " contó con los empleados " + EmpleadosTeatro + " en la franquicia " + franquicia;
        return ret + "\n";
    }
    
    /**
     * Busca en la BD un objeto con la misma id y la devuelve
     * @param id donde se guarda la id a buscar
     * @return Objeto con la id que coincide
     */
    public static GTrabajo getGTrabajobyID(long id){
        GTrabajo gt = new GTrabajo();
        for (GTrabajo g : Utilidades.GTRABAJO) {
            if (g.id == id) {
                gt = g;
                break;
            }
        }
        System.out.println(gt);
        return gt;
    }
    
    /**
     * Metodo que busca un objeto en la BD con la misma semana y el mismo mes.
     * @param semana variable donde se guarda la semana que quieres buscar
     * @param mes variable donde se guarda el mes que quieres buscar.
     * @return array con los objetos que coincide con la semana
     */
    public static ArrayList<GTrabajo> getGTrabajobySemana(long semana, long mes){
        ArrayList<GTrabajo> array = new ArrayList<>();
        for (GTrabajo g : Utilidades.GTRABAJO) {
            if (g.semana == semana && g.mes == mes) {
                array.add(g);
            }
        }
        System.out.println(array);
        return array;
    }
    
//     public static GTrabajo buscarGTrabajoID(long id) {
//            
//            Franquicia f = new Franquicia();
//                for (Franquicia fran : Utilidades.FRANQUICIAS) {
//                    if (id == fran.id) {
//                        f = fran;
//                        System.out.println(f);
//                    }
//                }
//            
//            return f;
//            
//        };
    
    public static ArrayList<GTrabajo> convertirGTrabajo(GTrabajo[] array) {
        ArrayList<GTrabajo> ret = new ArrayList<>();
        for (GTrabajo gtrabajo : array) {
            ret.add((GTrabajo)gtrabajo);
        }
        return ret;
    }
    
    public static void verGruposTrabajo(ArrayList<GTrabajo> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).toString());
        }
    }
    
    public static ArrayList<EmpleadoDeTeatro> convertirEmpleadoTeatro(EmpleadoDeTeatro[] array) {
        ArrayList<EmpleadoDeTeatro> ret = new ArrayList<>();
        for (EmpleadoDeTeatro e : array) {
            ret.add(e);
        }
        return ret;
    }
    
    
}
