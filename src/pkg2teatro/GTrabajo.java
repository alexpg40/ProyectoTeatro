package pkg2teatro;

import java.util.ArrayList;

public class GTrabajo {
    protected long id;
    private long semana;
    private ArrayList<EmpleadoDeTeatro> EmpleadosTeatro = new ArrayList<EmpleadoDeTeatro>();
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

    @Override
    public String toString() {
        return "GTrabajo{" + "id=" + id + ", semana=" + semana + ", EmpleadosTeatro=" + EmpleadosTeatro + ", franquicia=" + franquicia + '}';
    }
    
    
}
