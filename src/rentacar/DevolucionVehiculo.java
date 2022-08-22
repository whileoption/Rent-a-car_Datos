package rentacar;

//Libreria para uso de JOptionPane importada.
import javax.swing.JOptionPane;

/**
 * Clase 'DevolucionVehiculo' representa el espacio para las devoluciones de vehiculos.
 * Posee una interfaz grafica (JFrame).
 */
public class DevolucionVehiculo extends javax.swing.JFrame {

    //Constructor crea nuevo formulario para 'DevolucionVehiculo'.
    public DevolucionVehiculo() {
        initComponents();
        setLocationRelativeTo(null);
    }

    SolicitudAlquiler devol = new SolicitudAlquiler();
    RegistroVehiculo regV = new RegistroVehiculo();

    //Se procede a hacer la devolucion del alquiler de un vehiculo.
    public void devolver() {
        boolean encontrada = false;
        
        for (int i = 0; i < devol.getSolicAlquiler().size(); i++) {
            //Se verifican los datos insertados contra los existentes.
            if (jtfCedulaDevolucion.getText().equals(devol.getSolicAlquiler()
                .get(i).getCedAlq())&& jtfPlacaDevolucion.getText().equals(devol
                .getSolicAlquiler().get(i).getPlaca())) {
                //Se procesa la devolucion.
                devol.getSolicAlquiler().get(i).setEstado("Finalizada");
                encontrada = true;
            }

            //Se verifica si la solicitud existe.
            if (encontrada == false) {
                JOptionPane.showMessageDialog(null,"La solicitud no fue encontrada");
            }
        }
    }

    //Se actualiza el estado del vehiculo.
    public void estadoVehiculo() {
        for (int i = 0; i < regV.getRegVehiculo().size(); i++) {
            //Se verifica la existencia de los datos insertados contra los existentes.
            if (jtfCedulaDevolucion.getText().equals(devol.getSolicAlquiler()
                .get(i).getCedAlq())&& jtfPlacaDevolucion.getText().equals(devol
                .getSolicAlquiler().get(i).getPlaca())) {
                //Se actualiza el estado del vehiculo.
                regV.getRegVehiculo().get(i).setEstado("Disponible");
            }
        }
    }
    
    //Se lleva a cabo la limpieza de los campos de texto.
    public void Limpiar(){
        jtfCedulaDevolucion.setText("");
        jtfPlacaDevolucion.setText("");
        jcbEstadoDevolucion.setSelectedIndex(0);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfCedulaDevolucion = new javax.swing.JTextField();
        jtfPlacaDevolucion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jcbEstadoDevolucion = new javax.swing.JComboBox<>();
        jbProcesarDevolucion = new javax.swing.JButton();
        jbVolverDevolVehiculo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Devolución Vehículo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Cédula Cliente");

        jLabel3.setText("Placa Vehículo");

        jLabel10.setText("Estado");

        jcbEstadoDevolucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Excelente", "Bien", "Mal", "Deplorable" }));
        jcbEstadoDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadoDevolucionActionPerformed(evt);
            }
        });

        jbProcesarDevolucion.setBackground(new java.awt.Color(204, 255, 255));
        jbProcesarDevolucion.setText("Procesar");
        jbProcesarDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProcesarDevolucionActionPerformed(evt);
            }
        });

        jbVolverDevolVehiculo.setBackground(new java.awt.Color(255, 153, 153));
        jbVolverDevolVehiculo.setText("Volver");
        jbVolverDevolVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverDevolVehiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfCedulaDevolucion)
                            .addComponent(jtfPlacaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbProcesarDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jcbEstadoDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbVolverDevolVehiculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jtfPlacaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jtfCedulaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbEstadoDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbVolverDevolVehiculo)
                    .addComponent(jbProcesarDevolucion))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Boton 'VolverDevolVehiculo' ordena llevar a cabo acciones dentro del metodo.
     * @param evt Evento de seleccion.
     */
    private void jbVolverDevolVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverDevolVehiculoActionPerformed
        /**
         * Nuevo objeto Administracion se crea.
         * Interfaz grafica (JFrame) de 'Administracion' es llamada y mostrada en pantalla.
         */
        Administracion admi = new Administracion();
        admi.show(true);
        dispose();
    }//GEN-LAST:event_jbVolverDevolVehiculoActionPerformed

    /**
     * Boton 'ProcesarDevolucion' ordena llevar a cabo acciones dentro del metodo.
     * @param evt Evento de seleccion.
     */
    private void jbProcesarDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProcesarDevolucionActionPerformed
        //Se llama al metodo 'devolver';
        devolver();
        try{
            //Se llama al metodo 'estadoVehiculo'.
            estadoVehiculo();
            JOptionPane.showMessageDialog(null, "Proceso efectuado con éxito");
            Limpiar();
        } catch (Exception e){
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Registro no encontrado");
        }
    }//GEN-LAST:event_jbProcesarDevolucionActionPerformed

    private void jcbEstadoDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadoDevolucionActionPerformed
    }//GEN-LAST:event_jcbEstadoDevolucionActionPerformed

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
            java.util.logging.Logger.getLogger(DevolucionVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DevolucionVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DevolucionVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DevolucionVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DevolucionVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbProcesarDevolucion;
    private javax.swing.JButton jbVolverDevolVehiculo;
    private javax.swing.JComboBox<String> jcbEstadoDevolucion;
    private javax.swing.JTextField jtfCedulaDevolucion;
    private javax.swing.JTextField jtfPlacaDevolucion;
    // End of variables declaration//GEN-END:variables
}