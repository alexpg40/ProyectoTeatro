package Entidades;
// Guillermo Illera Vinatea
import java.util.ArrayList;
import java.util.Scanner;

public class GTrabajo {
    private long id;
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

    public void comprobarId(long id) {
        boolean cond = false;
        if (id < 0 || id == 0) {
            System.out.println("La id tiene que mayor estrictamente que cero");
        } else {
            cond = false;
            for (GTrabajo Empleado : Utilidades.GTRABAJO) {
                if (id == Empleado.getId()) {
                    cond = true;
                    break;
                } else {
                    cond = false;
                }
            }
            if (cond) {
                System.out.println("La id coincide con alguna ya guardada en la base");
            } else {
                this.id = id;
            }
        }
    }
    
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
        System.out.println("Introduce la id");
        long id;
        do {
            sc = new Scanner(System.in);
            id = sc.nextLong();
            gt.comprobarId(id);
        } while (gt.getId() != id || id == 0);
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
