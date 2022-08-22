/*
 */
package Analisis;

/**
 *
 * @author Karina Madrigal
 */
public class Solicitud {

    private String placa;
    private String cedAlq;
    private String estado;
    private double alquiler;
    private int cantPlaca;
    private int cantCliente;
    private String catCliente;

    public Solicitud(String placa, String cedAlq,
            String estado, double alquiler, int cantPlaca,
            int cantCliente, String catCliente) {
        this.placa = placa;
        this.cedAlq = cedAlq;
        this.estado = estado;
        this.alquiler = alquiler;
        this.cantPlaca = cantPlaca;
        this.cantCliente = cantCliente;
        this.catCliente = catCliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCedAlq() {
        return cedAlq;
    }

    public void setCedAlq(String cedAlq) {
        this.cedAlq = cedAlq;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(double alquiler) {
        this.alquiler = alquiler;
    }

    public int getCantPlaca() {
        return cantPlaca;
    }

    public void setCantPlaca(int cantPlaca) {
        this.cantPlaca = cantPlaca;
    }

    public int getCantCliente() {
        return cantCliente;
    }

    public void setCantCliente(int cantCliente) {
        this.cantCliente = cantCliente;
    }

    public String getCatCliente() {
        return catCliente;
    }

    public void setCatCliente(String catCliente) {
        this.catCliente = catCliente;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Cedula: " + cedAlq + ","
                + " Estado: " + estado + ", "
                + "Monto alquiler (col): " + alquiler;
    }

}
