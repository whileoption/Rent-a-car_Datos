/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rentacar;

import Alquiler.NodoSolCons;
import Analisis.Solicitud;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Karina Madrigal
 */
public class ConsultaAlquileres extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaVehiculos
     */
    public ConsultaAlquileres() {
        initComponents();
        setLocationRelativeTo(null);
    }

    //Esto es para la cola
    private NodoSolCons frente; //Variable que define el primero en cola
    private NodoSolCons ultimo; //Variable que define el último en cola

    public void enCola(NodoSolCons d) {
        if (frente == null) { //La cola está vacía
            frente = d; //El frente es igual al úlitmo
            ultimo = d;
        } else { //La cola no está vacía
            ultimo.setAtras(d); //Se crea un enlace 'atras' con el nodo d 
            ultimo = d; //El nodo creado es ahora el último nodo en la cola
        }
    }

    public NodoSolCons atiende() {
        NodoSolCons aux = frente; //Se almacena el valor de frente antes de ser extraído
        if (frente != null) { //Existe un elemento para extraer
            frente = frente.getAtras(); //El elemento en frente es ahora el que estaba de segundo
            aux.setAtras(null); //Se remueve la referencia al nodo que estaba en frente
        }
        return aux; //Se obtiene el valor de frente original (el que se atiende)
    }

    public boolean encuentraPlaca(String placa) {
        String s = ""; //Cadena
        NodoSolCons aux = frente; //Se almacena el valor de frente
        while (aux != null) { //Siempre que exita un valor de frente
            if (placa.toLowerCase().equals(aux.getDato()
                    .getPlaca().toLowerCase())) {
                return true; //Retorna true si encuentra un valor igual en cola
            }
            aux = aux.getAtras(); //Aux se sitúa en la siguiente posición
        }
        return false; //Si el ciclo termina sin hallar el valor, retorna false 
    }

    public boolean encuentraCedula(String id) {
        String s = ""; //Cadena
        NodoSolCons aux = frente; //Se almacena el valor de frente
        while (aux != null) { //Siempre que exita un valor de frente
            if (id.equals(aux.getDato().getCedAlq())) {
                return true; //Retorna true si encuentra un valor igual en cola
            }
            aux = aux.getAtras(); //Aux se sitúa en la siguiente posición
        }
        return false; //Si el ciclo termina sin hallar el valor, retorna false 
    }

    @Override
    public String toString() {
        String s = ""; //Cadena
        NodoSolCons aux = frente;
        while (aux != null) { //Cuando existe un valor auxiliar
            s += aux + "\n"; //Se almacena el valor al frente
            aux = aux.getAtras(); //Aux se sitúa en la siguiente posición
        }
        return s; //Retorna la cadena con todos los valores de la cola
    }

    private static boolean existeFiltro = false;
    private ArrayList<Solicitud> filtro = new ArrayList<>();
    SolicitudAlquiler solic = new SolicitudAlquiler();

    public void filtrar() {

        existeFiltro = false;

        //Busqueda por placa y estado
        if (!jtfConsultaPlaca.getText().equals("")) {

            //Busqueda por placa, por cedula y estado
            if (!jtfConsultaCedula.getText().equals("")) {

                for (int i = 0; i < solic.getSolicAlquiler().size(); i++) {

                    if (solic.getSolicAlquiler().get(i).getEstado().toLowerCase()
                            .equals(jcbEstado.getSelectedItem()
                                    .toString().toLowerCase())
                            && solic.getSolicAlquiler().get(i).getPlaca()
                                    .toLowerCase().equals(jtfConsultaPlaca
                                            .getText().toLowerCase())
                            && solic.getSolicAlquiler().get(i).getCedAlq()
                                    .equals(jtfConsultaCedula.getText())) {
                        //Agrega
                        filtro.add(solic.getSolicAlquiler().get(i));
                        existeFiltro = true;
                    }
                }

            } else { //Busqueda por placa y estado
                for (int i = 0; i < solic.getSolicAlquiler().size(); i++) {

                    if (solic.getSolicAlquiler().get(i).getEstado().toLowerCase()
                            .equals(jcbEstado.getSelectedItem()
                                    .toString().toLowerCase())
                            && solic.getSolicAlquiler().get(i).getPlaca()
                                    .toLowerCase().equals(jtfConsultaPlaca
                                            .getText().toLowerCase())) {
                        //Agrega
                        filtro.add(solic.getSolicAlquiler().get(i));
                        existeFiltro = true;
                    }
                }

            }

        } else { //Busqueda unicamente por estado

            for (int i = 0; i < solic.getSolicAlquiler().size(); i++) {

                if (solic.getSolicAlquiler().get(i).getEstado().toLowerCase()
                        .equals(jcbEstado.getSelectedItem()
                                .toString().toLowerCase())) {
                    //Agrega
                    filtro.add(solic.getSolicAlquiler().get(i));
                    existeFiltro = true;
                }
            }

        }

        //Muestra cuando la busqueda no arroja resultados
        if (!existeFiltro) {
            JOptionPane.showMessageDialog(null, "No existen registros"
                    + " con los parámetros busados");
        }

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
        jbVolverAlquilProces = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtfConsultaPlaca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfConsultaCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox<>();
        jbBuscarSolicitud = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaConsulta = new javax.swing.JTextArea();
        jbOtraConsulta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Consulta Alquileres Procesados");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(100, 100, 100))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbVolverAlquilProces.setBackground(new java.awt.Color(255, 153, 153));
        jbVolverAlquilProces.setText("Volver");
        jbVolverAlquilProces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverAlquilProcesActionPerformed(evt);
            }
        });

        jLabel2.setText("Placa");

        jLabel3.setText("Cédula");

        jLabel4.setText("Estado");

        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Registrada", "Rechazada", "Finalizada" }));

        jbBuscarSolicitud.setBackground(new java.awt.Color(204, 255, 255));
        jbBuscarSolicitud.setText("Buscar");
        jbBuscarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarSolicitudActionPerformed(evt);
            }
        });

        jtaConsulta.setColumns(20);
        jtaConsulta.setRows(5);
        jScrollPane1.setViewportView(jtaConsulta);

        jbOtraConsulta.setBackground(new java.awt.Color(255, 255, 204));
        jbOtraConsulta.setText("Otra Consulta");
        jbOtraConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOtraConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbOtraConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbVolverAlquilProces, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfConsultaCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(87, 87, 87)
                                .addComponent(jtfConsultaPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(jbBuscarSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfConsultaPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfConsultaCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarSolicitud))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbVolverAlquilProces)
                    .addComponent(jbOtraConsulta))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVolverAlquilProcesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverAlquilProcesActionPerformed
        Administracion admi = new Administracion();
        admi.show(true);
        dispose();
    }//GEN-LAST:event_jbVolverAlquilProcesActionPerformed

    private void jbBuscarSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarSolicitudActionPerformed

        for (int i = 0; i < filtro.size(); i++) {
            filtro.remove(i);
        }

        filtrar();
        if (existeFiltro == true) {

            JOptionPane.showMessageDialog(null, "Tamano filtro" + filtro.size());

            for (int i = 0; i < filtro.size(); i++) {
                enCola(new NodoSolCons(filtro.get(i)));
            }
            jtaConsulta.setText(toString());
        }

    }//GEN-LAST:event_jbBuscarSolicitudActionPerformed

    private void jbOtraConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOtraConsultaActionPerformed

        jtfConsultaPlaca.setText("");
        jtfConsultaCedula.setText("");
        jcbEstado.setSelectedIndex(0);
        jtaConsulta.setText("");

    }//GEN-LAST:event_jbOtraConsultaActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaAlquileres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaAlquileres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaAlquileres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaAlquileres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaAlquileres().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscarSolicitud;
    private javax.swing.JButton jbOtraConsulta;
    private javax.swing.JButton jbVolverAlquilProces;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JTextArea jtaConsulta;
    private javax.swing.JTextField jtfConsultaCedula;
    private javax.swing.JTextField jtfConsultaPlaca;
    // End of variables declaration//GEN-END:variables
}
