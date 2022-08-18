/*
 */
package rentacar;

import Vehiculo.Nodo;
import Vehiculo.Vehiculo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Karina Madrigal
 */
public class RegistroVehiculo extends javax.swing.JFrame {

    /**
     * Creates new form RegistroVehiculo
     */
    public RegistroVehiculo() {
        initComponents();
        jbAceptar.setVisible(false);
        setLocationRelativeTo(null);

        for (int i = 0; i < regVehiculo.size(); i++) {
            inserta(regVehiculo.get(i));
        }

    }

    //Almacenamiento de la informacion
    private static ArrayList<Vehiculo> regVehiculo = new ArrayList<>();

    public static ArrayList<Vehiculo> getRegVehiculo() {
        return regVehiculo;
    }

    public static void setRegVehiculo(ArrayList<Vehiculo> regVehiculo) {
        RegistroVehiculo.regVehiculo = regVehiculo;
    }

    //Se hace uso de la lista circular
    private Nodo cabeza;
    private Nodo ultimo;

    /**
     * Inserta un objeto Vehiculo a una lista circular no ordenada
     *
     * @param p objeto tipo Vehiculo a insertar
     */
    public void inserta(Vehiculo p) {
        if (cabeza == null) { //si cabeza es igual a null
            cabeza = new Nodo(p); //se crea nuevo nodo cabeza
            ultimo = cabeza; //ultimo es igual a cabeza
        } else { //si ya existe cabeza, se ubica al final
            Nodo aux = cabeza; //nodo aux es igual a cabeza
            ultimo.setNext(new Nodo(p));
            ultimo = ultimo.getNext();
        }
        ultimo.setNext(cabeza); //el ultimo se conecta a cabeza
        cabeza.setBack(ultimo); //la cabeza se conecta al ultimo
    }

    public boolean existe(String placa) {
        boolean esta = false;
        Nodo aux = cabeza;

        if (cabeza != null) {
            
            if(cabeza.getDato().getPlaca().toLowerCase()
                        .equals(placa.toLowerCase())){
                esta = true;
            }
            
            while (aux != ultimo && !esta) {                
                if (aux.getDato().getPlaca().toLowerCase()
                        .equals(placa.toLowerCase())) {
                    esta = true;
                }
                aux = aux.getNext();
            }
        }
        return esta;
    }

    public Vehiculo obtain(String placa) {
        Vehiculo vehObtenido = null;
        if (cabeza != null) {
            if (cabeza.getDato().getPlaca().toLowerCase()
                    .equals(placa.toLowerCase())) {
                vehObtenido = cabeza.getDato();
            } else if (ultimo.getDato().getPlaca().toLowerCase()
                    .equals(placa.toLowerCase())) {
                vehObtenido = ultimo.getDato();
            } else {
                Nodo aux = cabeza;
                while (aux.getNext() != cabeza) {
                    if (aux.getDato().getPlaca().toLowerCase()
                            .equals(placa.toLowerCase())) {
                        vehObtenido = aux.getDato();
                    }
                    aux = aux.getNext();
                }
            }
        }
        return vehObtenido;
    }

    public void modifica(String placa) {

        if (cabeza != null) { //si cabeza no es null
            if (existe(placa)) {
                Vehiculo vehModif = obtain(placa);
                Nodo aux = cabeza; //nodo aux es igual a cabeza

                vehModif.setMarca(jtfMarca.getText());
                vehModif.setModelo(jtfModelo.getText());
                vehModif.setAnno(jtfAnno.getText());
                vehModif.setColor(jtfColor.getText());
                vehModif.setCilindrada(jtfCilindrada.getText());
                vehModif.setCombustible(jtfCombustible.getText());
                vehModif.setPasajeros(jtfPasajeros.getText());
                vehModif.setAlquiler(jtfAlquilerDia.getText());
                vehModif.setEstado(jcbEstado.getSelectedItem().toString());
                vehModif.setExtras(extras);

            }
        }
    }

    //Este metodo se basa en lo expuesto por 
    //Tutoriales de Programación Explicada
    //Fuente: https://www.youtube.com/watch?v=bxvhZX_dwpo
    public void elimina(String placa) {
        boolean enc = false;
        Nodo aux = new Nodo();
        Nodo ant = new Nodo();
        aux = cabeza;
        ant = null;

        if (cabeza != null) {
            while (cabeza != null && !enc) {
                if (aux.getDato().getPlaca().toLowerCase()
                        .equals(placa.toLowerCase())) {
                    if (aux == cabeza) {
                        cabeza = cabeza.getNext();
                        cabeza.setBack(null);
                    } else if (aux == ultimo) {
                        ultimo = ultimo.getBack();
                        ultimo = ant;
                    } else {
                        ant.setNext(aux.getNext());
                        aux.getNext().setBack(ant);
                    }

                    enc = true;

                }
                ant = aux;
                aux = aux.getNext();
            }

        }
        cabeza.setBack(ultimo);
        ultimo.setNext(cabeza);

    }

    public Vehiculo extrae(String placa) {
        Vehiculo p = null;
        if (cabeza != null) {
            if (cabeza.getDato().getPlaca().toLowerCase()
                    .equals(placa.toLowerCase())) {
                p = cabeza.getDato();
                cabeza = cabeza.getNext();
            } else {
                Nodo aux = cabeza;
                Nodo ant = aux;
                while (aux.getNext() != cabeza
                        && aux.getNext().getDato().getPlaca().toLowerCase()
                                .equals(placa.toLowerCase())) {
                    p = aux.getNext().getDato();
                    aux.setNext(aux.getNext().getNext());
                    ant = aux;
                    aux = aux.getNext();
                }
                if (ultimo.getDato().getPlaca()
                        .toLowerCase().equals(placa.toLowerCase())) {
                    p = ultimo.getDato();
                    ultimo = ant;
                    ultimo.setNext(cabeza);
                    cabeza.setBack(ultimo);
                }
            }
        }
        return p;
    }

    @Override
    public String toString() {
        Nodo aux = cabeza;
        String s = "";
        if (aux != null) {
            s += aux + ", \n";
            aux = aux.getNext();
            while (aux != cabeza) {
                s += aux + ", \n";
                aux = aux.getNext();
            }
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
        jbVolverAdmin = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtfPlaca = new javax.swing.JTextField();
        jtfModelo = new javax.swing.JTextField();
        jtfMarca = new javax.swing.JTextField();
        jtfAnno = new javax.swing.JTextField();
        jtfColor = new javax.swing.JTextField();
        jtfCilindrada = new javax.swing.JTextField();
        jtfCombustible = new javax.swing.JTextField();
        jtfPasajeros = new javax.swing.JTextField();
        jtfAlquilerDia = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jbAgregarExtra = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jtfExtra = new javax.swing.JTextField();
        jbLimpiarV = new javax.swing.JButton();
        jbMostrarV = new javax.swing.JButton();
        jbEliminarV = new javax.swing.JButton();
        jbModificarV = new javax.swing.JButton();
        jbRegistrarV = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox<>();
        jbAceptar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaVehiculos = new javax.swing.JTextArea();

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
        jLabel1.setText("Registro de vehiculo");

        jbVolverAdmin.setBackground(new java.awt.Color(153, 204, 255));
        jbVolverAdmin.setText("<---");
        jbVolverAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jbVolverAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(271, 271, 271))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jbVolverAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setText("Placa");

        jLabel3.setText("Marca");

        jLabel4.setText("Modelo");

        jLabel5.setText("Año");

        jLabel6.setText("Color");

        jLabel7.setText("Cilindrada");

        jLabel8.setText("Combustible");

        jLabel9.setText("Pasajeros");

        jLabel10.setText("Alquiler / día");

        jtfModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfModeloActionPerformed(evt);
            }
        });

        jtfMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMarcaActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbAgregarExtra.setText("Add");
        jbAgregarExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarExtraActionPerformed(evt);
            }
        });

        jLabel11.setText("Extras");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbAgregarExtra))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAgregarExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jbLimpiarV.setBackground(new java.awt.Color(102, 153, 255));
        jbLimpiarV.setText("Limpiar");
        jbLimpiarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarVActionPerformed(evt);
            }
        });

        jbMostrarV.setBackground(new java.awt.Color(255, 255, 204));
        jbMostrarV.setText("Mostrar");
        jbMostrarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarVActionPerformed(evt);
            }
        });

        jbEliminarV.setBackground(new java.awt.Color(255, 153, 153));
        jbEliminarV.setText("Eliminar");
        jbEliminarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarVActionPerformed(evt);
            }
        });

        jbModificarV.setBackground(new java.awt.Color(204, 204, 255));
        jbModificarV.setText("Modificar");
        jbModificarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarVActionPerformed(evt);
            }
        });

        jbRegistrarV.setBackground(new java.awt.Color(204, 255, 255));
        jbRegistrarV.setText("Registrar");
        jbRegistrarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarVActionPerformed(evt);
            }
        });

        jLabel12.setText("Estado");

        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Alquilado", "En reparación", "Fuera de circulación" }));

        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfAnno, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jtfModelo)
                                .addGap(37, 37, 37)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfColor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCilindrada, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfPasajeros, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCombustible, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addGap(18, 18, 18)
                            .addComponent(jcbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)
                            .addComponent(jtfAlquilerDia, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbRegistrarV, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbModificarV, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbEliminarV, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbMostrarV, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(jbLimpiarV)))
                .addGap(36, 36, 36))
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
                                .addComponent(jtfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8)
                                    .addComponent(jtfCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtfColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jtfAlquilerDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfCilindrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLimpiarV)
                    .addComponent(jbAceptar))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbMostrarV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminarV)
                    .addComponent(jbModificarV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRegistrarV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jtaVehiculos.setColumns(20);
        jtaVehiculos.setRows(5);
        jScrollPane2.setViewportView(jtaVehiculos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfModeloActionPerformed


    private void jbRegistrarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarVActionPerformed

        if (existe(jtfPlaca.getText())) {
            JOptionPane.showMessageDialog(null, "Registro ya existe");
            Limpiar();
        } else {

            if (ValidarCampos()) {
                inserta(new Vehiculo(this.jtfPlaca.getText(),
                        this.jtfMarca.getText(), this.jtfModelo.getText(),
                        this.jtfAnno.getText(), this.jtfColor.getText(),
                        this.jtfCilindrada.getText(), this.jtfCombustible.getText(),
                        this.jtfPasajeros.getText(), this.jtfAlquilerDia.getText(),
                        this.jcbEstado.getSelectedItem().toString(), extras));
            } else {
                JOptionPane.showMessageDialog(null, "Complete todos los espacios "
                        + "antes de registrar un vehiculo");
            }
            Limpiar();
            jtfPlaca.setEnabled(true);
            jbModificarV.setEnabled(true);

            
//            //Reiniciar la lista de extras
//            for (int i = 0; i < extras.size(); i++) {
//                extras.remove(i);
//            }

        }
    }//GEN-LAST:event_jbRegistrarVActionPerformed

    private void jbLimpiarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarVActionPerformed
        Limpiar();
    }//GEN-LAST:event_jbLimpiarVActionPerformed

    private ArrayList<String> extras = new ArrayList<>();

    private ArrayList<String> agregarExtras() {
        extras.add(this.jtfExtra.getText());
        this.jtfExtra.setText("");
        return extras;
    }

    private void jbAgregarExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarExtraActionPerformed
        agregarExtras();
    }//GEN-LAST:event_jbAgregarExtraActionPerformed

    private void jbEliminarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarVActionPerformed

        String placa = JOptionPane.showInputDialog("Ingrese la placa");
        int op = JOptionPane.showConfirmDialog(null, "Se eliminará este registro"
                + ", ¿está seguro?");
        if (op == 0) {
            elimina(placa);
        }


    }//GEN-LAST:event_jbEliminarVActionPerformed

    private void jbModificarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarVActionPerformed

        jtfPlaca.setEnabled(false);
//        jbAceptar.setVisible(true);
        jbModificarV.setEnabled(false);
        String placa = JOptionPane.showInputDialog("Ingrese la placa");
        LlenarCampos(placa);
        modifica(placa);
        elimina(placa);
    }//GEN-LAST:event_jbModificarVActionPerformed

    private void jbMostrarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarVActionPerformed

        for (int i = 0; i < regVehiculo.size(); i++) {
            regVehiculo.remove(i);
        }

        jtaVehiculos.setText(toString());
    }//GEN-LAST:event_jbMostrarVActionPerformed

    private void jbVolverAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverAdminActionPerformed

        Nodo aux = cabeza;

        ultimo.setNext(null);
        while (aux != null) {
            regVehiculo.add(aux.getDato());
            aux = aux.getNext();
        }
        ultimo.setNext(cabeza);

        Administracion volv = new Administracion();
        volv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbVolverAdminActionPerformed

    private void jtfMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMarcaActionPerformed

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed

        Vehiculo vehi = new Vehiculo();
        //modifica(vehi.getPlaca()); 
        jbAceptar.setVisible(false);
        Limpiar();
        jbModificarV.setEnabled(true);
        jtfPlaca.setEnabled(true);
        if (cabeza != null) { //si cabeza no es null
            if (existe(vehi.getPlaca())) {
                Vehiculo vehModif = new Vehiculo();
                vehModif.setMarca(jtfMarca.getText());
                vehModif.setModelo(jtfModelo.getText());
                vehModif.setAnno(jtfAnno.getText());
                vehModif.setColor(jtfColor.getText());
                vehModif.setCilindrada(jtfCilindrada.getText());
                vehModif.setCombustible(jtfCombustible.getText());
                vehModif.setPasajeros(jtfPasajeros.getText());
                vehModif.setAlquiler(jtfAlquilerDia.getText());
                vehModif.setEstado(jcbEstado.getSelectedItem().toString());
                vehModif.setExtras(extras);
            }
        }
    }//GEN-LAST:event_jbAceptarActionPerformed

    public void Limpiar() {
        this.jtfPlaca.setText("");
        this.jtfMarca.setText("");
        this.jtfModelo.setText("");
        this.jtfAnno.setText("");
        this.jtfColor.setText("");
        this.jtfCilindrada.setText("");
        this.jtfCombustible.setText("");
        this.jtfPasajeros.setText("");
        this.jtfAlquilerDia.setText("");
        this.jtfExtra.setText("");
    }

    public boolean ValidarCampos() {
        if (this.jtfPlaca.getText().equals("")
                || this.jtfMarca.getText().equals("")
                || this.jtfModelo.getText().equals("")
                || this.jtfAnno.getText().equals("")
                || this.jtfColor.getText().equals("")
                || this.jtfCilindrada.getText().equals("")
                || this.jtfCombustible.getText().equals("")
                || this.jtfPasajeros.getText().equals("")
                || this.jtfAlquilerDia.getText().equals("")) {
            return false;
        }
        return true;
    }

    public void LlenarCampos(String placa) {

        Vehiculo vehi = obtain(placa);

        try {
            this.jtfPlaca.setText(vehi.getPlaca());
            this.jtfMarca.setText(vehi.getMarca());
            this.jtfModelo.setText(vehi.getModelo());
            this.jtfAnno.setText(vehi.getAnno());
            this.jtfColor.setText(vehi.getColor());
            this.jtfCilindrada.setText(vehi.getCilindrada());
            this.jtfCombustible.setText(vehi.getCombustible());
            this.jtfPasajeros.setText(vehi.getPasajeros());
            this.jtfAlquilerDia.setText(vehi.getAlquiler());
            this.jtfExtra.setText(vehi.getExtras().get(0));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Placa no se encuentra "
                    + "registrada");
            jtfPlaca.setEnabled(true);
            jbModificarV.setEnabled(true);
        }

    }

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
            java.util.logging.Logger.getLogger(RegistroVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbAgregarExtra;
    private javax.swing.JButton jbEliminarV;
    private javax.swing.JButton jbLimpiarV;
    private javax.swing.JButton jbModificarV;
    private javax.swing.JButton jbMostrarV;
    private javax.swing.JButton jbRegistrarV;
    private javax.swing.JButton jbVolverAdmin;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JTextArea jtaVehiculos;
    private javax.swing.JTextField jtfAlquilerDia;
    private javax.swing.JTextField jtfAnno;
    private javax.swing.JTextField jtfCilindrada;
    private javax.swing.JTextField jtfColor;
    private javax.swing.JTextField jtfCombustible;
    private javax.swing.JTextField jtfExtra;
    private javax.swing.JTextField jtfMarca;
    private javax.swing.JTextField jtfModelo;
    private javax.swing.JTextField jtfPasajeros;
    private javax.swing.JTextField jtfPlaca;
    // End of variables declaration//GEN-END:variables
}
