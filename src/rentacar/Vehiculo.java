/*
 */

package rentacar;

/**
 *
 * @author Karina Madrigal
 */
public class Vehiculo {

    private String placa, marca, modelo, color, 
            cilindrada, combustible, extras, status;
    private int year, capacidad;
    private double costo;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca, String modelo, 
            String color, String cilindrada, String combustible, 
            String extras, String status, int year, int capacidad, 
            double costo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.cilindrada = cilindrada;
        this.combustible = combustible;
        this.extras = extras;
        this.status = status;
        this.year = year;
        this.capacidad = capacidad;
        this.costo = costo;
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

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa=" + placa + ", "
                + "marca=" + marca + ", modelo=" + modelo + ", "
                + "color=" + color + ", cilindrada=" + cilindrada + ", "
                + "combustible=" + combustible + ", "
                + "extras=" + extras + ", status=" + status + ", "
                + "year=" + year + ", capacidad=" + capacidad + ", "
                + "costo=" + costo + '}';
    }
    
    
    
    
}
