package rentacar;

/**
 * Clases dentro de paquete 'Cliente' importadas.
 * Librerias para uso de ArrayList, Collections y JOptionPane importadas.
 */
import Cliente.Cliente;
import Cliente.NodoC;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Clase 'RegistroCliente' representa el espacio para los registros de vehiculos.
 * Posee una interfaz grafica (JFrame).
 */
public class RegistroCliente extends javax.swing.JFrame {

    //Constructor crea nuevo formulario para 'RegistroCliente'.
    public RegistroCliente() {
        initComponents();
        setLocationRelativeTo(null);

        //Contador para ingreso de nuevos registros.
        for (int i = 0; i < regCliente.size(); i++) {
            inserta(regCliente.get(i));
        }
    }

    //Almacenamiento de la informacion dentro de la lista 'Cliente'.
    protected static ArrayList<Cliente> regCliente = new ArrayList<>();

    public static ArrayList<Cliente> getRegCliente() {
        return regCliente;
    }

    /**
     * Se sobreescribe 'RegCliente' con nuevo registro. 
     * @param regVehiculo Lista con nuevo registro.
     */
    public static void setRegCliente(ArrayList<Cliente> regCliente) {
        RegistroCliente.regCliente = regCliente;
    }

    //Lista.
    private NodoC cabeza;

    /**
     * Inserta un objeto cliente a una lista no ordenada.
     * @param p objeto tipo Vehiculo a insertar.
     */
    public void inserta(Cliente p) {
        //Si la cabeza de la lista es null.
        if (cabeza == null) {
            //Se crea nuevo nodo cabeza.
            cabeza = new NodoC(p);
        } else 
            //Si no hay nada luego de cabeza.
            if (cabeza.getNext() == null) { 
                //Se crea el nodo detras de la cabeza.
                cabeza.setNext(new NodoC(p));
            } else {
                NodoC aux = cabeza;

                while (aux.getNext() != null) {
                    //El auxiliar es lo que esta luego.
                    aux = aux.getNext();
                }
                //Se crea nodo temporal.
                NodoC temp = new NodoC(p);
                temp.setNext(aux.getNext());
                aux.setNext(temp);
            }
    }

    /**
     * Se asegura de que el cliente exista por medio del id.
     * @param id ID del cliente.
     * @return Si existe(true) o no(false).
     */
    public boolean existe(String id) {
        boolean exist = false;
        
        //Si la cabeza de la lista existe.
        if (cabeza != null) {
            NodoC aux = cabeza;
            
            while (aux != null) {
                if (aux.getDato().getId().equals(id)) {
                    return true;
                }
                aux = aux.getNext();
            }
            exist = (aux != null);
        }
        return exist;
    }
    
    /**
     * Este metodo se basa en lo expuesto por Jesús Equihua
     * Fuente: https://www.youtube.com/watch?v=W7t5ewx1vp4
     * Se eliminan clientes por medio del id de referencia.
     * @param id ID del cliente.
     */
    public void elimina(String id) {
        NodoC aux = cabeza;
        NodoC previous = null;
        boolean found = false;

        while (aux != null && found == false) {
            if (aux.getDato().getId().equals(id)) {
                if (previous == null) {
                    cabeza = aux.getNext();
                    aux.setNext(null);
                } else {
                    previous.setNext(aux.getNext());
                    aux.setNext(null);
                }
                found = true;
            }
            previous = aux;
            aux = aux.getNext();
        }
    }

    /**
     * Modifica los datos del cliente segun el id de referencia.
     * @param p ID del cliente.
     */
    public void modificar(Cliente p) {
        //JOptionPane.showMessageDialog(null, p.getId());
        //Si el cliente no es null.
        if (p != null) {
            //Si el ID que se inserto existe dentro de la lista.
            if (existe(p.getId())) {
                //Nodo aux es igual a cabeza.
                NodoC aux = cabeza;
                
                //Se vuelven a setear todos los campos de informacion.
                while (aux != null) {
                    if (aux.getDato().getId().equals(p.getId())) {
                        aux.getDato().setNombre(JOptionPane.showInputDialog("Digite "
                            + "el nuevo nombre"));
                        aux.getDato().setNacimiento(JOptionPane.showInputDialog("Digite "
                            + "la nueva fecha de nacimiento"));
                        aux.getDato().setCorreo(JOptionPane.showInputDialog("Digite "
                            + "el nuevo correo"));
                        aux.getDato().setCategoria(JOptionPane.showInputDialog("Digite "
                            + "la nueva categoria\n Zafiro, Oro, Plata, Bronce"));
                    }
                    aux = aux.getNext();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe id");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe id");
        }
    }

    /**
     *  Se extraen clientes por medio del id de referencia.
     * @param id ID del cliente.
     * @return Cliente.
     */
    public Cliente extrae(String id) {
        Cliente valor = null;
        
        if (cabeza != null) {
            if (cabeza.getDato().getId().equals(id)) {
                valor = cabeza.getDato();
                cabeza = cabeza.getNext();
                elimina(id);
            } else {
                NodoC aux = cabeza;
                while (aux != null) {
                    if (aux.getDato().getId().equals(id)) {
                        valor = aux.getDato();
                        elimina(id);
                    }
                    aux = aux.getNext();
                }
            }
        }
        return valor;
    }

    /**
     * Obtiene los datos del cliente por medio del id.
     * @param id ID del cliente.
     * @return Cliente.
     */
    public Cliente obtain(String id) {
        Cliente valor = null;
        NodoC aux = cabeza;

        while (aux != null) {
            if (aux.getDato().getId().equals(id)) {
                valor = aux.getDato();
            }
            aux = aux.getNext();
        }
        return valor;
    }

    /**
     * Excribe los datos del cliente y los imprime.
     * @return Datos ordenados.
     */
    @Override
    public String toString() {
        NodoC aux = cabeza;
        String s = "";
        while (aux != null) {
            s += aux + ", \n";
            aux = aux.getNext();
        }
        return s;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbVolverRegCliente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtfCedula = new javax.swing.JTextField();
        jtfNacimiento = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfCorreo = new javax.swing.JTextField();
        jbRegistroCliente = new javax.swing.JButton();
        jcbCategoria = new javax.swing.JComboBox<>();
        jbModificarCleinte = new javax.swing.JButton();
        jbEliminarCliente = new javax.swing.JButton();
        jbMostrarClientes = new javax.swing.JButton();
        jbLimpiarV = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaClientes = new javax.swing.JTextArea();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Registro de cliente");

        jbVolverRegCliente.setBackground(new java.awt.Color(153, 204, 255));
        jbVolverRegCliente.setText("<---");
        jbVolverRegCliente.setToolTipText("");
        jbVolverRegCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverRegClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jbVolverRegCliente)
                .addGap(113, 113, 113)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jbVolverRegCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Cédula");

        jLabel3.setText("Nombre completo");

        jLabel4.setText("Fecha nacimiento");

        jLabel5.setText("Correo electrónico");

        jLabel10.setText("Categoría");

        jtfNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNacimientoActionPerformed(evt);
            }
        });

        jbRegistroCliente.setBackground(new java.awt.Color(204, 255, 255));
        jbRegistroCliente.setText("Registrar");
        jbRegistroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistroClienteActionPerformed(evt);
            }
        });

        jcbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Zafiro", "Oro", "Plata", "Bronce" }));
        jcbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCategoriaActionPerformed(evt);
            }
        });

        jbModificarCleinte.setBackground(new java.awt.Color(204, 204, 255));
        jbModificarCleinte.setText("Modificar");
        jbModificarCleinte.setToolTipText("");
        jbModificarCleinte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarCleinteActionPerformed(evt);
            }
        });

        jbEliminarCliente.setBackground(new java.awt.Color(255, 153, 153));
        jbEliminarCliente.setText("Eliminar");
        jbEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarClienteActionPerformed(evt);
            }
        });

        jbMostrarClientes.setBackground(new java.awt.Color(255, 255, 204));
        jbMostrarClientes.setText("Mostrar");
        jbMostrarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarClientesActionPerformed(evt);
            }
        });

        jbLimpiarV.setBackground(new java.awt.Color(102, 153, 255));
        jbLimpiarV.setText("Limpiar");
        jbLimpiarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(jtfCorreo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbLimpiarV)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jbRegistroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbModificarCleinte, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 10, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(jtfNombre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(5, 5, 5)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jbMostrarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jbLimpiarV)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jtfCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbRegistroCliente)
                    .addComponent(jbModificarCleinte)
                    .addComponent(jbEliminarCliente)
                    .addComponent(jbMostrarClientes))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtaClientes.setColumns(20);
        jtaClientes.setRows(5);
        jScrollPane1.setViewportView(jtaClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNacimientoActionPerformed
    }//GEN-LAST:event_jtfNacimientoActionPerformed

    /**
     * Boton 'Limpiar' ordena llevar a cabo acciones dentro del metodo.
     * @param evt Evento de seleccion.
     */
    private void jbLimpiarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarVActionPerformed
        //Se llama a metodo 'Limpiar'.
        Limpiar();
    }//GEN-LAST:event_jbLimpiarVActionPerformed

    /**
     * Boton 'VolverRegCliente' ordena llevar a cabo acciones dentro del metodo.
     * @param evt Evento de seleccion.
     */
    private void jbVolverRegClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverRegClienteActionPerformed
        NodoC aux = cabeza;

        while (aux != null) {
            regCliente.add(aux.getDato());
            aux = aux.getNext();
        }

        /**
         * Nuevo objeto Administracion se crea.
         * Interfaz grafica (JFrame) de 'Administracion' es llamada y mostrada en pantalla.
         */
        Administracion volv = new Administracion();
        volv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbVolverRegClienteActionPerformed
/**
     * Boton 'RegistrarCliente' ordena llevar a cabo acciones dentro del metodo.
     * @param evt Evento de seleccion.
     */
    private void jbRegistroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistroClienteActionPerformed
        //Si el texto de referencia insertado en el espacio 'Cedula' existe dentro de la lista.
        if (existe(jtfCedula.getText())) {
            JOptionPane.showMessageDialog(null, "Registro ya existe");
            Limpiar();
        } else {
            //Se llama al metodo 'inserta' para hacer la insersion del registro.
            inserta(new Cliente(jtfCedula.getText(), jtfNombre.getText(),
                jtfNacimiento.getText(), jtfCorreo.getText(),
                jcbCategoria.getSelectedItem().toString()));

            Limpiar();
        }
    }//GEN-LAST:event_jbRegistroClienteActionPerformed

    /**
     * Boton 'Modificar' ordena llevar a cabo acciones dentro del metodo.
     * @param evt Evento de seleccion.
     */
    private void jbModificarCleinteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarCleinteActionPerformed
        String cedula = JOptionPane.showInputDialog("Ingrese la cedula");
        modificar(obtain(cedula));
    }//GEN-LAST:event_jbModificarCleinteActionPerformed

    /**
     * Boton 'Eliminar' ordena llevar a cabo acciones dentro del metodo.
     * @param evt Evento de seleccion.
     */
    private void jbEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarClienteActionPerformed
        String cedula = JOptionPane.showInputDialog("Ingrese la cedula");
        int op = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar registro?");
        if (op == 0) {
            elimina(cedula);
            Limpiar();
        }
    }//GEN-LAST:event_jbEliminarClienteActionPerformed

    /**
     * Boton 'Mostrar' ordena llevar a cabo acciones dentro del metodo.
     * @param evt Evento de seleccion.
     */
    private void jbMostrarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarClientesActionPerformed
        for (int i = 0; i < regCliente.size(); i++) {
            regCliente.remove(i);
        }
        //Imprime los datos.
        jtaClientes.setText(toString());
    }//GEN-LAST:event_jbMostrarClientesActionPerformed

    private void jcbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCategoriaActionPerformed
    }//GEN-LAST:event_jcbCategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroCliente().setVisible(true);
            }
        });
    }

    //Se lleva a cabo la limpieza de los campos de texto.
    public void Limpiar() {
        this.jtfCedula.setText("");
        this.jtfNombre.setText("");
        this.jtfNacimiento.setText("");
        this.jtfCorreo.setText("");
        this.jcbCategoria.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEliminarCliente;
    private javax.swing.JButton jbLimpiarV;
    private javax.swing.JButton jbModificarCleinte;
    private javax.swing.JButton jbMostrarClientes;
    private javax.swing.JButton jbRegistroCliente;
    private javax.swing.JButton jbVolverRegCliente;
    private javax.swing.JComboBox<String> jcbCategoria;
    private javax.swing.JTextArea jtaClientes;
    private javax.swing.JTextField jtfCedula;
    private javax.swing.JTextField jtfCorreo;
    private javax.swing.JTextField jtfNacimiento;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}