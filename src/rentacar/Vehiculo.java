/*
 */
package rentacar;

import java.util.ArrayList;

/**
 *
 * @author Karina Madrigal
 */
public class Vehiculo {

    private String placa, marca, modelo, anno, color, cilindrada,
            combustible, pasajeros, alquiler, estado;
    private ArrayList<String> extras;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca,
            String modelo, String anno,
            String color, String cilindrada,
            String combustible, String pasajeros,
            String alquiler, String estado,
            ArrayList<String> extras) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anno = anno;
        this.color = color;
        this.cilindrada = cilindrada;
        this.combustible = combustible;
        this.pasajeros = pasajeros;
        this.alquiler = alquiler;
        this.estado = estado;
        this.extras = extras;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public String getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(String pasajeros) {
        this.pasajeros = pasajeros;
    }

    public String getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(String alquiler) {
        this.alquiler = alquiler;
    }

    public ArrayList<String> getExtras() {
        return extras;
    }

    public void setExtras(ArrayList<String> extras) {
        this.extras = extras;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", anno=" + anno + ", color=" + color + ", cilindrada=" + cilindrada + ", combustible=" + combustible + ", pasajeros=" + pasajeros + ", alquiler=" + alquiler + ", estado=" + estado + ", extras=" + extras + '}';
    }
    
    

}
