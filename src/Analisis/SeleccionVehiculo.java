/*
 */

package Analisis;

/**
 *
 * @author Karina Madrigal
 */
public class SeleccionVehiculo {
    
     private String placa;
     private int acc;

    public SeleccionVehiculo(String placa, int acc) {
        this.placa = placa;
        this.acc = acc;
    }
     
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }

    
    @Override
    public String toString() {
        return "" + "placa " + placa + ", acc " + acc + "\n";
    }
     
     

}
