package Entidades;
// Guillermo Illera Vinatea
import java.util.ArrayList;

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

    public void comprobarId(long id){
        if (id <= 0) {
            System.out.println("La Id tiene que ser mayor estrictamente que 0");
        } else if (id % 1 != 0) {
            System.out.println("La id tiene que ser un número entero");
        } else {
            for (GTrabajo gt : Utilidades.GTRABAJO) {
                if (id == gt.getId()) {
                    System.out.println("No se puede repetir la id");
                } else {
                    return;
                }
            }
        }
    }
    
    public void comprobarSemana(long id){
        if (!(id >= 1 && id <=6)) {
            System.out.println("Solo puede estar entre la semana 1 y la 6");
        }
    }
    
    @Override
    public String toString() {
        return "GTrabajo{" + "id=" + id + ", semana=" + semana + ", EmpleadosTeatro=" + EmpleadosTeatro + ", franquicia=" + franquicia + '}';
    }
    
    
}
