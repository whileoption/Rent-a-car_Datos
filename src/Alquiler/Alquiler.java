package Alquiler;

import java.util.ArrayList;

public class Alquiler {
    private String dias, id, pasajeros, marca, modelo, anno;
    //private ArrayList<String> extras;   
    
    public Alquiler() {
    }
    
    public Alquiler(String dias, String id, String pasajeros, String marca, String modelo, 
            String anno
            //, ArrayList<String> extras
    ) {
        this.dias = dias;
        this.id = id;
        this.pasajeros = pasajeros;
        this.marca = marca;
        this.modelo = modelo;
        this.anno = anno;
        //this.extras = extras;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(String pasajeros) {
        this.pasajeros = pasajeros;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

//    public ArrayList<String> getExtras() {
//        return extras;
//    }
//
//    public void setExtras(ArrayList<String> extras) {
//        this.extras = extras;
//    }
    
    @Override
    public String toString() {
        return "ID " + id + ", Dias " + dias + ", pasajeros " + pasajeros
                + ", marca " + marca + ", modelo " + modelo
                + ", anno " + anno;
    }
}