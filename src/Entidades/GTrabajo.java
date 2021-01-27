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
    private Franquicia franquicia;
    
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
        GTrabajo gt = new GTrabajo();
        Scanner in;
        gt.setId(gt.generarId());
        System.out.println("Introduzca la semana: " + "\n");
        long semana;
        do {
            semana =-1;
            in = new Scanner(System.in);
            semana = in.nextLong();
            gt.validarSemana(semana);
        } while (gt.getSemana() != semana || semana <= 0 || semana > 6);
        System.out.println("La semana introducida es " + semana);
    return gt;}
    
    @Override
    public String toString() {
        String ret;
        ret = "GTrabajo{" + "id=" + id + ", semana=" + semana + ", EmpleadosTeatro=" + EmpleadosTeatro + ", franquicia=" + franquicia + '}';
            for(EmpleadoDeTeatro e : EmpleadosTeatro){
                ret += "Id del empleado= " + e.getId() + "\n";
                ret += "Nombre del empleado= " + e.getNombre() + "\n";
                ret += "Apellidos del empleado= " +e.getApellidos() + "\n";
                ret += "Nif del empleado= " + e.getNif() + "\n";
                ret += "Telefono del empleado" + e.getTelefono() + "\n";
                ret += "Direccion del empleado" + e.getDireccion() + "\n";
            }
    return ret + "\n";}
    
    /**
     * Busca en la BD un objeto con la misma id y la devuelve
     * @param id donde se guarda la id a buscar
     * @return Objeto con la id que coincide
     */
    public GTrabajo getGTrabajobyID(long id){
        GTrabajo gt = new GTrabajo();
        for (GTrabajo g : Utilidades.GTRABAJO) {
            if (g.id == id) {
                gt = g;
                break;
            }
        }
        
    return gt;}
    
    /**
     * Metodo que busca un objeto en la BD con la misma semana
     * @param semana variable donde se guarda la semana que quieres buscar
     * @return array con los objetos que coincide con la semana
     */
    public ArrayList<GTrabajo> getGTrabajobySemana(long semana){
        ArrayList<GTrabajo> array = new ArrayList<>();
        for (GTrabajo g : Utilidades.GTRABAJO) {
            if (g.semana == semana) {
                array.add(g);
            }
        }
    return array;}
    
}
