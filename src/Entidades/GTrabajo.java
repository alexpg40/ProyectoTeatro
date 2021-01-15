package Entidades;
// Guillermo Illera Vinatea
import java.util.ArrayList;
import java.util.Scanner;

public class GTrabajo {
    
    //VALORES VALIDOS: NÚMEROS ENTEROS,  HA DE SER ÚNICO PARA CADA INSTANCIA  > 0 && VALORES INVALIDOS: NÚMEROS ENTEROS <= 0
    private long id;
    //VALORES VALIDOS: NUMEROS ENTEROS => 1 y <=6 && VALORES INVALIDOS: CUALQUIER CARACTER O NUMERO DIFERENTE
    private long semana;
    
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
    };
    
    public GTrabajo(long id, long semana, Franquicia franquicia, ArrayList<EmpleadoDeTeatro> EmpleadosTeatro) {
        this.id = id;
        this.semana = semana;
        this.franquicia = franquicia;
        this.EmpleadosTeatro = EmpleadosTeatro;
        
    }

    public long getId() {
        return id;
    }

    public long getSemana() {
        return semana;
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
    
    public void comprobarSemana(long semana){
        if (!(semana >= 1 && semana <=6)) {
            System.out.println("Solo puede estar entre la semana 1 y la 6");
        } else{
            this.semana = semana;
        }
    }
    
    public static GTrabajo nuevoGTrabajo(){
        GTrabajo gt = new GTrabajo();
        Scanner sc = new Scanner(System.in);
        gt.setId(gt.generarId());
        System.out.println("Introduce la semana");
        long semana;
        do {
            semana =-1;
            sc = new Scanner(System.in);
            semana = sc.nextLong();
            gt.comprobarSemana(semana);
        } while (gt.getSemana() != semana || semana <= 0 || semana > 6);
    return gt;}
    
    @Override
    public String toString() {
        return "GTrabajo{" + "id=" + id + ", semana=" + semana + ", EmpleadosTeatro=" + EmpleadosTeatro + ", franquicia=" + franquicia + '}';
    }
    
    
}
