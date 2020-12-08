package pkg2teatro;
//Guillermo Illera Vinatea

import java.util.ArrayList;
import java.util.Date;

public class Informe {
    private long id;
    private Date mesyano;
    private double balance;
    // Se guarda el Secretario que realiza el informe
    private Secretariado secretario;
    // Se guarda una lista de los beneficios
    private ArrayList<Beneficio> beneficios = new ArrayList<Beneficio>();
    // Se guarda una lista de los costes
    private ArrayList<Coste> costes = new ArrayList<Coste>();
    
    public Informe (){};
    
    public Informe (Informe infor){
        this.id = infor.id;
        this.mesyano = infor.mesyano;
        this.balance = infor.balance;
        this.secretario = infor.secretario;
        this.beneficios = infor.beneficios;
    };

    public Informe(long id, Date mesyano, double balance, Secretariado secretario, ArrayList<Beneficio> beneficios,  ArrayList<Coste> costes) {
        this.id = id;
        this.mesyano = mesyano;
        this.balance = balance;
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
        return "Informe{" + "id=" + id + ", mesyano=" + mesyano + ", balance=" + balance + ", secretario=" + secretario + ", beneficios=" + beneficios + ", costes=" + costes + '}';
    }
    
    
    
    
}
