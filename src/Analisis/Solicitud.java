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

    public Solicitud(String placa, String cedAlq,
            String estado, double alquiler) {
        this.placa = placa;
        this.cedAlq = cedAlq;
        this.estado = estado;
        this.alquiler = alquiler;
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

    @Override
    public String toString() {
        return "Placa: " + placa + ", Cedula: " + cedAlq + ","
                + " Estado: " + estado + ", "
                + "Monto alquiler (col): " + alquiler;
    }

}
