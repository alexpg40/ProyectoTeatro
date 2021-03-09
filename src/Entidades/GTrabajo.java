package Entidades;
// Guillermo Illera Vinatea
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GTrabajo {
    
    //VALORES VALIDOS: NÚMEROS ENTEROS,  HA DE SER ÚNICO PARA CADA INSTANCIA  > 0 && VALORES INVALIDOS: NÚMEROS ENTEROS <= 0
    private long id;
    //VALORES VALIDOS: NUMEROS ENTEROS => 1 y <=6 && VALORES INVALIDOS: CUALQUIER CARACTER O NUMERO DIFERENTE
    private long semana;
    //VALORES VALIDOS: NÚMEROS ENTEROS => 1 Y <=12 && VALORES INVALIDOS: CUALQUIER CARACTER O NUMERO DIFRENTE
    private long mes;
    //ARRAY LIST DE LOS EMPLEADOS DE TEATRO QUE FORMAN EL GRUPO DE TRABAJO
    private ArrayList<EmpleadoDeTeatro> EmpleadosTeatro = new ArrayList<>();
    //FRANQUICIA DONDE TRABAJA EL GRUPO DE TRABAJO
    private Franquicia franquicia;
    //VALORES VALIDOS: NÚMEROS ENTEROS,  HA DE SER ÚNICO PARA CADA INSTANCIA  > 0 && VALORES INVALIDOS: NÚMEROS ENTEROS <= 0
    private long idfranquicia;

    public long getIdfranquicia() {
        return idfranquicia;
    }

    public void setIdfranquicia(long idfranquicia) {
        this.idfranquicia = idfranquicia;
    }
    
    public GTrabajo(){};
    
    public GTrabajo(GTrabajo gt){
        this.id = gt.id;
        this.semana = gt.semana;
        this.EmpleadosTeatro = gt.EmpleadosTeatro;
        this.franquicia = gt.franquicia;
        this.mes = gt.mes;
        this.idfranquicia = gt.idfranquicia;
    };
    
    public GTrabajo(long id, long semana, long mes,Franquicia franquicia, ArrayList<EmpleadoDeTeatro> EmpleadosTeatro, long idfranquicia) {
        this.id = id;
        this.semana = semana;
        this.franquicia = franquicia;
        this.EmpleadosTeatro = EmpleadosTeatro;
        this.mes = mes;
        this.idfranquicia= idfranquicia;
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

    /**
     * Recorre un array con los grupos de trabajo 
     * @return mayor id + 1
     */
    public long generarId() {
        long id = 0;
        for (GTrabajo gt : Utilidades.GTRABAJO) {
            if (id < gt.id) {
                id = gt.id;
            }
        }
    return id+1;}
    
    /**
     * Valida la semana y la setea en el grupo de trabajo
     * @param semana a validar
     * @return boolean
     */
    public boolean validarSemana(long semana){
        //Comprueba que el valor se ha un valor valido entre 1 y 6
        if (!(semana >= 1 && semana <=6)) {
            System.out.println("Solo puede estar entre la semana 1 y la 6");
            //Setea la semana al grupo de trabajo
        } else{
            return true;
        }
    return false;
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
            if (gt.validarSemana(semana)) {
                gt.setSemana(semana);
            }
        } while (gt.getSemana() != semana || semana <= 0 || semana > 6);
        
        System.out.println("¿Cuantos usuarios desea introducir en el grupo?" + "\n");
        int nUsuarios, opcionMenuUsuarios, opcionMenuFranquicias;
        nUsuarios = in.nextInt();
        Empleado empleadosGrupo[] = new Empleado[nUsuarios];
        int idUsuario = -2;
        
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
                       Scanner scId = new Scanner (System.in);
                       System.out.println("Introduce el ID del empleado que quieres añadir: ");
                       try {
                       idUsuario = scId.nextInt(); 
                       } catch (java.util.InputMismatchException e) {
                           break;
                       }
                       empleadosGrupo[i] = Empleado.añadirEmpleadobyID(idUsuario, empleadosTeatro);
                       System.out.println(Arrays.toString(empleadosGrupo));
                       continue;
                   
                   case 2: // Por NIF
                       break;
                    
                   case 3: // Por nombre y apellidos
                       break;
                   
                   default:
               }
               
            } while(opcionMenuUsuarios > 4);
        };
        if (idUsuario != -1 || idUsuario != 0){
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
                       try {
                       idFranquicia = scId.nextInt();
                       } catch (java.util.InputMismatchException e) {
                           System.out.println("Introduzca un valor correcto.");
                           e.getMessage();
                           break;
                       };
                       do {
                        Franquicia franquicia = Franquicia.buscarFranquicia(idFranquicia);
                           System.out.println("¿Es esta la Franquicia que quiere añadir?");
                           gt.setFranquicia(franquicia);
                           condicion = Utilidades.leerBoolean();
                       } while (condicion == false);
                       break;
                   
                   case 2: // Por NIF
                       break;
                   
                   default:
               }
               
            } while(opcionMenuFranquicias > 3);
        }
        
        
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
    
    public String data() {
        return this.id + "|" + this.semana + "|" + this.mes + "|" + this.EmpleadosTeatro + "|" + this.franquicia + "|" + this.idfranquicia;
    }
    
}
