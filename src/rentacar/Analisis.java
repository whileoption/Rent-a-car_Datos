/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rentacar;

import Analisis.NodoOrden;
import Analisis.Solicitud;
import Vehiculo.Vehiculo;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.RowFilter.Entry;

/**
 *
 * @author Karina Madrigal
 */
public class Analisis extends javax.swing.JFrame {

    /**
     * Creates new form Analisis
     */
    public Analisis() {
        initComponents();
        setLocationRelativeTo(null);
    }

    //Variables para almacenar informacion
    SolicitudAlquiler solicitud = new SolicitudAlquiler();
    private static ArrayList<Solicitud> cliente = new ArrayList<>();
    private static ArrayList<Solicitud> vehiculo = new ArrayList<>();

    //Implementación de lista circular doble
    private NodoOrden cabezaC;
    private NodoOrden ultimoC;
    private NodoOrden cabezaV;
    private NodoOrden ultimoV;
    private int longVeh = 0;
    private int longCliente = 0;

    public void insertaCliente(Solicitud c) { //ordena de mayor a menor
        if (cabezaC == null) { //si no hay cabeza
            cabezaC = new NodoOrden(c); //se crea un nodo cabeza
            ultimoC = cabezaC; //el ultimo es igual a cabeza
        } else if (c.getCantCliente() < cabezaC.getDato().getCantCliente()) { 
            NodoOrden aux = new NodoOrden(c); //se crea un nuevo nodo aux
            aux.setNext(cabezaC); //el siguiente a aux es cabeza
            cabezaC = aux; //la cabeza es ahora el aux
        } else if (ultimoC.getDato().getCantCliente() <= c.getCantCliente()) { 
            ultimoC.setNext(new NodoOrden(c)); 
            ultimoC = ultimoC.getNext(); //el ultimo es ahora el siguiente
        } else { //si el dato esta entre la cabeza y el ultimo
            NodoOrden aux = cabezaC; //se crea nodo aux que es igual a cabeza
            while (aux.getNext().getDato().getCantCliente() < 
                    c.getCantCliente()) { 
                aux = aux.getNext(); //aux se actualiza
            }
            NodoOrden temp = new NodoOrden(c); //se crea nuevo nodo temporal
            temp.setNext(aux.getNext()); 
            temp.setBack(aux); //el anterior al temporal es el aux
            aux.setNext(temp); //el siguiente al aux es el temporal
            temp.getNext().setBack(temp); //se ubica el temporal  
        }
        ultimoC.setNext(cabezaC); //el ultimo se conecta a la cabeza
        cabezaC.setBack(ultimoC); //la cabeza se conecta al ultimo
        longCliente++;
        cliente.add(c);
    }

    public void insertaVehiculo(Solicitud v) { //ordena de mayor a menor
        if (cabezaV == null) { //si no hay cabeza
            cabezaV = new NodoOrden(v); //se crea un nodo cabeza
            ultimoV = cabezaV; //el ultimo es igual a cabeza
        } else if (v.getCantPlaca() < cabezaV.getDato().getCantPlaca()) { 
            NodoOrden aux = new NodoOrden(v); //se crea un nuevo nodo aux
            aux.setNext(cabezaV); //el siguiente a aux es cabeza
            cabezaV = aux; //la cabeza es ahora el aux
        } else if (ultimoV.getDato().getCantPlaca() <= v.getCantPlaca()) { 
            ultimoV.setNext(new NodoOrden(v)); 
            ultimoV = ultimoV.getNext(); //el ultimo es ahora el siguiente
        } else { //si el dato esta entre la cabeza y el ultimo
            NodoOrden aux = cabezaV; //se crea nodo aux que es igual a cabeza
            while (aux.getNext().getDato().getCantPlaca() < v.getCantPlaca()) { 
                aux = aux.getNext(); //aux se actualiza
            }
            NodoOrden temp = new NodoOrden(v); //se crea nuevo nodo temporal
            temp.setNext(aux.getNext()); 
            temp.setBack(aux); //el anterior al temporal es el aux
            aux.setNext(temp); //el siguiente al aux es el temporal
            temp.getNext().setBack(temp); //se ubica el temporal  
        }
        ultimoV.setNext(cabezaV); //el ultimo se conecta a la cabeza
        cabezaV.setBack(ultimoV); //la cabeza se conecta al ultimo
        longVeh++;
        vehiculo.add(v);
    }

    public void restablecerTodo() {
        cabezaC = null;
        cabezaV = null;
        vehiculo.clear();
        cliente.clear();
        totalZafiro = 0;
        cZaf = 0;
        totalOro = 0;
        cOro = 0;
        totalPlata = 0;
        cPl = 0;
        totalBronce = 0;
        cBr = 0;
        promZafiro = 0;
        promOro = 0;
        promPlata = 0;
        promBronce = 0;
    }

    private double totalZafiro, cZaf = 0;
    private double totalOro, cOro = 0;
    private double totalPlata, cPl = 0;
    private double totalBronce, cBr = 0;

    public void calculoTotales() {

        for (int i = 0; i < solicitud.getSolicAlquiler().size(); i++) {

            if (solicitud.getSolicAlquiler().get(i).getCatCliente()
                    .toLowerCase().equals("zafiro")) {
                totalZafiro += solicitud.getSolicAlquiler().get(i).getAlquiler();
                cZaf++;
            } else if (solicitud.getSolicAlquiler().get(i).getCatCliente()
                    .toLowerCase().equals("oro")) {
                totalOro += solicitud.getSolicAlquiler().get(i).getAlquiler();
                cOro++;
            } else if (solicitud.getSolicAlquiler().get(i).getCatCliente()
                    .toLowerCase().equals("plata")) {
                totalPlata += solicitud.getSolicAlquiler().get(i).getAlquiler();
                cPl++;
            } else if (solicitud.getSolicAlquiler().get(i).getCatCliente()
                    .toLowerCase().equals("bronce")) {
                totalBronce += solicitud.getSolicAlquiler().get(i).getAlquiler();
                cBr++;
            }

        }

    }

    private double promZafiro = 0;
    private double promOro = 0;
    private double promPlata = 0;
    private double promBronce = 0;

    public void calculoPromedios() {

        try {
            promZafiro = totalZafiro / cZaf;
            jtfPromedioZafiro.setText("" + promZafiro);

            promOro = totalOro / cOro;
            jtfPromedioOro.setText("" + promOro);

            promPlata = totalPlata / cPl;
            jtfPromedioPlata.setText("" + promPlata);

            promBronce = totalBronce / cBr;
            jtfPromedioBronce.setText("" + promBronce);

        } catch (Exception e) {
            e.getMessage();
        }

    }

    public void Limpiar() {
        //this.jcbCategoria.setSelectedIndex(0);
        this.jtfClienteTop1.setText("");
        this.jtfClienteTop2.setText("");
        this.jtfClienteTop3.setText("");
        this.jtfClienteTop4.setText("");
        this.jtfClienteTop5.setText("");
        this.jtfVehiculoTop1.setText("");
        this.jtfVehiculoTop2.setText("");
        this.jtfVehiculoTop3.setText("");
        this.jtfVehiculoTop4.setText("");
        this.jtfVehiculoTop5.setText("");
        this.jtfPromedioZafiro.setText("");
        this.jtfPromedioOro.setText("");
        this.jtfPromedioPlata.setText("");
        this.jtfPromedioBronce.setText("");
        this.jtfTotalZafiro.setText("");
        this.jtfTotalOro.setText("");
        this.jtfTotalPlata.setText("");
        this.jtfTotalBronce.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jtfClienteTop1 = new javax.swing.JTextField();
        jtfClienteTop2 = new javax.swing.JTextField();
        jtfClienteTop3 = new javax.swing.JTextField();
        jtfClienteTop4 = new javax.swing.JTextField();
        jtfClienteTop5 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jtfVehiculoTop1 = new javax.swing.JTextField();
        jtfVehiculoTop2 = new javax.swing.JTextField();
        jtfVehiculoTop3 = new javax.swing.JTextField();
        jtfVehiculoTop4 = new javax.swing.JTextField();
        jtfVehiculoTop5 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jtfPromedioZafiro = new javax.swing.JTextField();
        jtfPromedioOro = new javax.swing.JTextField();
        jtfPromedioPlata = new javax.swing.JTextField();
        jtfPromedioBronce = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtfTotalBronce = new javax.swing.JTextField();
        jtfTotalPlata = new javax.swing.JTextField();
        jtfTotalOro = new javax.swing.JTextField();
        jtfTotalZafiro = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jbVolverAnalisis = new javax.swing.JButton();
        jbGenerar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Análisis");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(281, 281, 281))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfClienteTop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfClienteTop1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Top 1");

        jLabel3.setText("Top 3");

        jLabel4.setText("Top 4");

        jLabel5.setText("Top 2");

        jLabel6.setText("Top 5");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Top 5 - Clientes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfClienteTop4, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jtfClienteTop3)
                    .addComponent(jtfClienteTop2)
                    .addComponent(jtfClienteTop5)
                    .addComponent(jtfClienteTop1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfClienteTop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfClienteTop2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfClienteTop3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfClienteTop4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jtfClienteTop5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setText("Top 5");

        jLabel7.setText("Top 1");

        jLabel8.setText("Top 2");

        jLabel9.setText("Top 3");

        jLabel10.setText("Top 4");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Top 5 - Vehiculos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfVehiculoTop5, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jtfVehiculoTop4)
                    .addComponent(jtfVehiculoTop3)
                    .addComponent(jtfVehiculoTop2)
                    .addComponent(jtfVehiculoTop1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jtfVehiculoTop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfVehiculoTop2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfVehiculoTop3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfVehiculoTop4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jtfVehiculoTop5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setText("Zafiro");

        jLabel13.setText("Oro");

        jLabel14.setText("Plata");

        jLabel15.setText("Bronce");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Promedio / Total");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Categoría");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfPromedioBronce)
                            .addComponent(jtfPromedioPlata)
                            .addComponent(jtfPromedioOro)
                            .addComponent(jtfPromedioZafiro, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfTotalBronce)
                            .addComponent(jtfTotalPlata)
                            .addComponent(jtfTotalOro)
                            .addComponent(jtfTotalZafiro, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel17)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19))
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfPromedioZafiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfPromedioOro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfPromedioPlata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfPromedioBronce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jtfTotalZafiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfTotalOro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtfTotalPlata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtfTotalBronce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jbVolverAnalisis.setBackground(new java.awt.Color(255, 153, 153));
        jbVolverAnalisis.setText("Volver");
        jbVolverAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverAnalisisActionPerformed(evt);
            }
        });

        jbGenerar.setText("Generar");
        jbGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerarActionPerformed(evt);
            }
        });

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jbGenerar)
                        .addGap(41, 41, 41)
                        .addComponent(jbLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbVolverAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbVolverAnalisis)
                    .addComponent(jbGenerar)
                    .addComponent(jbLimpiar))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVolverAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverAnalisisActionPerformed
        Administracion admi = new Administracion();
        admi.show(true);
        dispose();
    }//GEN-LAST:event_jbVolverAnalisisActionPerformed

    private void jtfClienteTop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfClienteTop1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfClienteTop1ActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        Limpiar();
        restablecerTodo();

    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGenerarActionPerformed

        for (int i = 0; i < solicitud.getSolicAlquiler().size(); i++) {

            insertaCliente(new Solicitud(solicitud.getSolicAlquiler()
                    .get(i).getPlaca(), solicitud.getSolicAlquiler()
                    .get(i).getCedAlq(), solicitud.getSolicAlquiler()
                    .get(i).getEstado(), solicitud.getSolicAlquiler()
                    .get(i).getAlquiler(), solicitud.getSolicAlquiler()
                    .get(i).getCantPlaca(), solicitud.getSolicAlquiler()
                    .get(i).getCantCliente(), solicitud.getSolicAlquiler()
                    .get(i).getCatCliente()));

            insertaVehiculo(new Solicitud(solicitud.getSolicAlquiler()
                    .get(i).getPlaca(), solicitud.getSolicAlquiler()
                    .get(i).getCedAlq(), solicitud.getSolicAlquiler()
                    .get(i).getEstado(), solicitud.getSolicAlquiler()
                    .get(i).getAlquiler(), solicitud.getSolicAlquiler()
                    .get(i).getCantPlaca(), solicitud.getSolicAlquiler()
                    .get(i).getCantCliente(), solicitud.getSolicAlquiler()
                    .get(i).getCatCliente()));

        }

        try {
            //Cliente
            jtfClienteTop1.setText(cliente.get(0).getCedAlq());
            jtfClienteTop2.setText(cliente.get(1).getCedAlq());
            jtfClienteTop3.setText(cliente.get(2).getCedAlq());
            jtfClienteTop4.setText(cliente.get(3).getCedAlq());
            jtfClienteTop5.setText(cliente.get(4).getCedAlq());

        } catch (Exception e) {
            e.getMessage();
        }

        try {
            //Vehiculo
            jtfVehiculoTop1.setText(vehiculo.get(0).getPlaca());
            jtfVehiculoTop2.setText(vehiculo.get(1).getPlaca());
            jtfVehiculoTop3.setText(vehiculo.get(2).getPlaca());
            jtfVehiculoTop4.setText(vehiculo.get(3).getPlaca());
            jtfVehiculoTop5.setText(vehiculo.get(4).getPlaca());
        } catch (Exception e) {
            e.getMessage();
        }

        calculoTotales();
        calculoPromedios();
        jtfTotalZafiro.setText("" + totalZafiro);
        jtfTotalOro.setText("" + totalOro);
        jtfTotalPlata.setText("" + totalPlata);
        jtfTotalBronce.setText("" + totalBronce);

    }//GEN-LAST:event_jbGenerarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Analisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Analisis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbGenerar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbVolverAnalisis;
    private javax.swing.JTextField jtfClienteTop1;
    private javax.swing.JTextField jtfClienteTop2;
    private javax.swing.JTextField jtfClienteTop3;
    private javax.swing.JTextField jtfClienteTop4;
    private javax.swing.JTextField jtfClienteTop5;
    private javax.swing.JTextField jtfPromedioBronce;
    private javax.swing.JTextField jtfPromedioOro;
    private javax.swing.JTextField jtfPromedioPlata;
    private javax.swing.JTextField jtfPromedioZafiro;
    private javax.swing.JTextField jtfTotalBronce;
    private javax.swing.JTextField jtfTotalOro;
    private javax.swing.JTextField jtfTotalPlata;
    private javax.swing.JTextField jtfTotalZafiro;
    private javax.swing.JTextField jtfVehiculoTop1;
    private javax.swing.JTextField jtfVehiculoTop2;
    private javax.swing.JTextField jtfVehiculoTop3;
    private javax.swing.JTextField jtfVehiculoTop4;
    private javax.swing.JTextField jtfVehiculoTop5;
    // End of variables declaration//GEN-END:variables
}
