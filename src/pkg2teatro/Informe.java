package pkg2teatro;

import java.util.ArrayList;
import java.util.Date;

public class Informe {
    protected long id;
    private Date mesyano;
    private double balance;
    private Franquicia franquicia;
    private Secretariado secretario;
    private ArrayList<Beneficio> beneficios = new ArrayList<Beneficio>();
    private ArrayList<Coste> costes = new ArrayList<Coste>();
    
    public Informe (){};
    
    public Informe (Informe infor){
        this.id = infor.id;
        this.mesyano = infor.mesyano;
        this.balance = infor.balance;
        this.franquicia = infor.franquicia;
        this.secretario = infor.secretario;
        this.beneficios = infor.beneficios;
    };

    public Informe(long id, Date mesyano, double balance, Franquicia franquicia, Secretariado secretario, ArrayList<Beneficio> beneficios,  ArrayList<Coste> costes) {
        this.id = id;
        this.mesyano = mesyano;
        this.balance = balance;
        this.franquicia = franquicia;
        this.secretario = secretario;
        this.beneficios = beneficios;
        this.costes = costes;
    }

    public long getId() {
        return id;
    }

    public Date getMesyano() {
        return mesyano;
    }

    public double getBalance() {
        return balance;
    }

    public Franquicia getFranquicia() {
        return franquicia;
    }

    public Secretariado getSecretario() {
        return secretario;
    }

    public ArrayList<Beneficio> getBeneficios() {
        return beneficios;
    }

    public ArrayList<Coste> getCostes() {
        return costes;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMesyano(Date mesyano) {
        this.mesyano = mesyano;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }

    public void setSecretario(Secretariado secretario) {
        this.secretario = secretario;
    }

    public void setBeneficios(ArrayList<Beneficio> beneficios) {
        this.beneficios = beneficios;
    }

    public void setCostes(ArrayList<Coste> costes) {
        this.costes = costes;
    }

    @Override
    public String toString() {
        return "Informe{" + "id=" + id + ", mesyano=" + mesyano + ", balance=" + balance + ", franquicia=" + franquicia + ", secretario=" + secretario + ", beneficios=" + beneficios + ", costes=" + costes + '}';
    }
    
    
    
    
}
