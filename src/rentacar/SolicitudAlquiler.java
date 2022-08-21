/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rentacar;

import Alquiler.NodoA;
import Analisis.Ordenamiento;
import Analisis.SeleccionVehiculo;
import Analisis.Solicitud;
import Vehiculo.Vehiculo;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author Karina Madrigal
 */
public class SolicitudAlquiler extends javax.swing.JFrame {

    /**
     * Creates new form RegistroVehiculo
     */
    public SolicitudAlquiler() {
        initComponents();
        setLocationRelativeTo(null);
        jtfPlacaAlquiler.setVisible(false);
        jbAlquilarVehiculo.setEnabled(false);

        for (int i = 0; i < vehiculo.getExtras().size(); i++) {
            jcbExtras.addItem(vehiculo.getExtras().get(i));
        }

        //Pila
        this.cima = null;
        this.longitud = 0;

    }

    //Objeto tipo RegistroVehiculo
    RegistroVehiculo vehiculo = new RegistroVehiculo();

    //Almacenamiento de la informacion
    private static ArrayList<Solicitud> solicAlquiler = new ArrayList<>();

    public static ArrayList<Solicitud> getSolicAlquiler() {
        return solicAlquiler;
    }

    public static void setSolicAlquiler(ArrayList<Solicitud> solicAlquiler) {
        SolicitudAlquiler.solicAlquiler = solicAlquiler;
    }

    //Esto es para la pila
    private NodoA cima;
    private int longitud;

    public boolean Vacia() {
        return cima == null;
    }

    public int tamano() {
        return longitud;
    }

    //se agregan nodos
    public void push(Vehiculo valor) {
        NodoA newNode = new NodoA();
        newNode.setValor(valor);
        if (this.Vacia()) {
            this.cima = newNode;
        } else {
            newNode.setSiguiente(this.cima);
            this.cima = newNode;
        }
        this.longitud++;
    }

    //elimina el nodo de la cima
    public void pop() {
        if (!Vacia()) {
            //Asigna como primer nodo al siguiente de la pila
            this.cima = this.cima.getSiguiente();
            //Decrementa el contador del tamaño de la pila
            this.longitud--;
        }
    }

    //Busca el nodo segun valor y retorna true si exise y false si no existe
    public boolean search(String placa) {
        //Crea una copia de la pila
        NodoA aux = cima;
        //Bandera para verificar si existe el elemento search
        boolean exist = false;
        //Recorre la pila hasta encontrar el node o llegar al final de la pila
        while (exist != true && aux != null) {
            //Compara si el valor del nodo es igual al reference
            if (placa.toLowerCase()
                    .equals(aux.getValor().getPlaca().toLowerCase())) {
                //Cambia el valor de la bandera
                exist = true;
            } else {
                //Avanza al siguiente node
                aux = aux.getSiguiente();
            }
        }
        //Retorna el valor de la bandera
        return exist;
    }

    //Elimina según referencia
    public void delete(String placa) {
        //Consulta si el valor existe en la pila
        if (search(placa)) {
            //Crea una pila auxiliar que guarda valores que se vayan 
            //desapilando en la pila original
            NodoA cimaPilaAux = null;
            //Recorre la pila hasta llegar al node que tenga el valor 
            //igual que el de reference
            while (!placa.toLowerCase()
                    .equals(cima.getValor().getPlaca().toLowerCase())) {
                //Cra un node temporal para agregarlos a la pila auxiliar
                NodoA temp = new NodoA();
                //Ingresa el valor al node temmporal
                temp.setValor(cima.getValor());
                //Consulta si la pila auxiliar no ha sido inicializada
                if (cimaPilaAux == null) {
                    //Inicializa la pila auxiliar
                    cimaPilaAux = temp;
                } //Caso contrario si la pila auxiliar ya contiene elementos
                //los agrega al start
                else {
                    temp.setSiguiente(cimaPilaAux);
                    cimaPilaAux = temp;
                }
                //Elimina el node del tope de la pila hasta llegar al node
                //que se desea eliminar
                pop();
            }
            //Elimina el node que coincide con el de reference
            pop();
            //Regresa los valores de la pila auxiliar a la pila original
            //mientras la pila auxiliar tenga elementos
            while (cimaPilaAux != null) {
                //Utiliza el metodo push para regresar elementos a la pila original
                push(cimaPilaAux.getValor());
            }
            //Libera la memoria utilizada por la pila auxiliar
            cimaPilaAux = null;
        } else {
            System.out.println("El nodo indicado no existe");
        }
    }

    public String Listar() {
        //Crea una copia de la pila
        NodoA aux = cima;
        String s = "";
        //Recorre la pila hasta el ultimo node
        while (aux != null) {
            s += "|\t" + aux.getValor() + "|\t";
            s += "\n\n";
            aux = aux.getSiguiente();
        }
        return s;
    }

    //Variable para almacenar la info del accuracy ligado al vehiculo
    private static ArrayList<SeleccionVehiculo> accVehiculo = new ArrayList<>();
    private static boolean pas = false;

    public void buscarVehiculo() {

        pas = false;

        for (int i = 0; i < vehiculo.getRegVehiculo().size(); i++) {
            //Variable para calcular accuracy 
            int acc = 0;

            //Se busca vehiculos que tengan la cantidad minima de pasajeros
            if (Integer.parseInt(jtfCantPasajeros.getText())
                    <= Integer.parseInt(vehiculo.getRegVehiculo()
                            .get(i).getPasajeros())) {

                pas = true;
                acc += 5;

                if (jtfMarcaAlquilar.getText().toLowerCase()
                        .equals(vehiculo.getRegVehiculo()
                                .get(i).getMarca().toLowerCase())) {
                    acc += 1;
                }

                if (jtfModeloAlquilar.getText().toLowerCase()
                        .equals(vehiculo.getRegVehiculo()
                                .get(i).getModelo().toLowerCase())) {
                    acc += 1;
                }

                if (jtfAnnoAlquilar.getText().toLowerCase()
                        .equals(vehiculo.getRegVehiculo()
                                .get(i).getAnno().toLowerCase())) {
                    acc += 1;
                }

                if (jcbExtras.getSelectedItem().toString()
                        .toLowerCase().equals(vehiculo
                                .getRegVehiculo().get(i)
                                .getExtras().get(0)
                                .toLowerCase())) {
                    acc += 1;
                }

            }

            //Almacenamiento de placa y accuracy 
            accVehiculo.add(new SeleccionVehiculo(vehiculo.getRegVehiculo()
                    .get(i).getPlaca(), acc));

        }
        if (pas == false) { //cantidad minima de pasajeros no cumple
            JOptionPane.showMessageDialog(null, "No hay vehiculos que "
                    + "satisfagan la busqueda");

            solicAlquiler.add(new Solicitud(jtfPlacaAlquiler.getText(),
                    jtfCedulaAlquiler.getText(), "Rechazada", 0.0));
        }

        //Se ordena el arraylist
        Collections.sort(accVehiculo, new Ordenamiento());
        jbAlquilarVehiculo.setEnabled(true);

    }

    public void cambioCategoria(int dias, String cedula, String placa) {
        RegistroCliente cat = new RegistroCliente();

        //Por dias de alquiler
        if (dias >= 40) {
            for (int i = 0; i < cat.getRegCliente().size(); i++) {
                if (cat.getRegCliente().get(i).getId().equals(cedula)) {
                    cat.getRegCliente().get(i).setCategoria("oro");
                }
            }
        } else if (dias >= 30) {
            for (int i = 0; i < cat.getRegCliente().size(); i++) {
                if (cat.getRegCliente().get(i).getId().equals(cedula)) {

                    if (cat.getRegCliente().get(i).getCategoria().toLowerCase()
                            .equals("bronce")) {
                        cat.getRegCliente().get(i).setCategoria("plata");

                    } else if (cat.getRegCliente().get(i).getCategoria().toLowerCase()
                            .equals("plata")) {
                        cat.getRegCliente().get(i).setCategoria("oro");

                    } else if (cat.getRegCliente().get(i).getCategoria().toLowerCase()
                            .equals("oro")) {
                        cat.getRegCliente().get(i).setCategoria("zafiro");
                    }
                }
            }
        }

        //Por monto de alquiler
        if (calculoAlquiler(placa) >= 700000) {
            for (int i = 0; i < cat.getRegCliente().size(); i++) {
                if (cat.getRegCliente().get(i).getId().equals(cedula)) {

                    if (cat.getRegCliente().get(i).getCategoria().toLowerCase()
                            .equals("bronce")) {
                        cat.getRegCliente().get(i).setCategoria("plata");

                    } else if (cat.getRegCliente().get(i).getCategoria().toLowerCase()
                            .equals("plata")) {
                        cat.getRegCliente().get(i).setCategoria("oro");

                    } else if (cat.getRegCliente().get(i).getCategoria().toLowerCase()
                            .equals("oro")) {
                        cat.getRegCliente().get(i).setCategoria("zafiro");
                    }
                }
            }
        }

    }

    public boolean estadoAlquilado(String placa) {
        RegistroVehiculo estado = new RegistroVehiculo();
        boolean alquilado = false; //no está alquilado

        for (int i = 0; i < estado.getRegVehiculo().size(); i++) {

            if (estado.getRegVehiculo().get(i).getPlaca().toLowerCase()
                    .equals(placa.toLowerCase())) {
                if (estado.getRegVehiculo().get(i).getEstado().toLowerCase()
                        .equals("alquilado")) {
                    alquilado = true; //está alquilado
                }
            }
        }
        return alquilado;
    }

    public void cambioEstado(String placa) {
        RegistroVehiculo estado = new RegistroVehiculo();

        for (int i = 0; i < estado.getRegVehiculo().size(); i++) {

            if (estado.getRegVehiculo().get(i).getPlaca().toLowerCase()
                    .equals(placa.toLowerCase())) {

                if (!estado.getRegVehiculo().get(i).getEstado().toLowerCase()
                        .equals("alquilado")) {
                    estado.getRegVehiculo().get(i).setEstado("Alquilado");
                } else {
                    JOptionPane.showMessageDialog(null, "Vehiculo en uso\n"
                            + "Las disculpas del caso, intente nuevamente");
                }
            }
        }
    }

    public double calculoAlquiler(String placa) {

        RegistroVehiculo alq = new RegistroVehiculo();
        double alqDia = 0.0;

        int dias = Integer.parseInt(jtfDiasAlquilar.getText());

        for (int i = 0; i < alq.getRegVehiculo().size(); i++) {
            if (alq.getRegVehiculo().get(i).getPlaca().toLowerCase()
                    .equals(placa.toLowerCase())) {
                alqDia = Double.parseDouble(alq.getRegVehiculo()
                        .get(i).getAlquiler());
            }
        }

        return alqDia * dias * 1.13;
    }

    public void Limpiar() {
        jtfCedulaAlquiler.setText("");
        jtfDiasAlquilar.setText("");
        jtfCantPasajeros.setText("");
        jtfMarcaAlquilar.setText("");
        jtfModeloAlquilar.setText("");
        jtfAnnoAlquilar.setText("");
        jtfPlacaAlquiler.setText("");
        jcbExtras.setSelectedIndex(0);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtfDiasAlquilar = new javax.swing.JTextField();
        jtfMarcaAlquilar = new javax.swing.JTextField();
        jtfCantPasajeros = new javax.swing.JTextField();
        jtfModeloAlquilar = new javax.swing.JTextField();
        jcbExtras = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jtfAnnoAlquilar = new javax.swing.JTextField();
        jtfPlacaAlquiler = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfCedulaAlquiler = new javax.swing.JTextField();
        jbVolverSolicVehiculo = new javax.swing.JButton();
        jbBuscarVehiculo = new javax.swing.JButton();
        jbAlquilarVehiculo = new javax.swing.JButton();

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
        jLabel1.setText("Solicitud de Alquiler");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(178, 178, 178)
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

        jLabel2.setText("Cantidad de días");

        jLabel3.setText("Cantidad pasajeros");

        jLabel4.setText("Marca");

        jLabel5.setText("Modelo");

        jLabel10.setText("Extras");

        jtfMarcaAlquilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMarcaAlquilarActionPerformed(evt);
            }
        });

        jcbExtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbExtrasActionPerformed(evt);
            }
        });

        jLabel6.setText("Año");

        jLabel7.setText("Cedula");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jcbExtras, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(99, 99, 99)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfModeloAlquilar, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                    .addComponent(jtfAnnoAlquilar)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfCantPasajeros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                    .addComponent(jtfDiasAlquilar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtfCedulaAlquiler, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtfMarcaAlquilar, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addComponent(jtfPlacaAlquiler)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jcbExtras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCedulaAlquiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jtfCantPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfMarcaAlquilar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))))
                    .addComponent(jtfDiasAlquilar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jtfPlacaAlquiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jtfModeloAlquilar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6))
                    .addComponent(jtfAnnoAlquilar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jbVolverSolicVehiculo.setBackground(new java.awt.Color(255, 153, 153));
        jbVolverSolicVehiculo.setText("Volver");
        jbVolverSolicVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverSolicVehiculoActionPerformed(evt);
            }
        });

        jbBuscarVehiculo.setBackground(new java.awt.Color(204, 255, 255));
        jbBuscarVehiculo.setText("Buscar");
        jbBuscarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarVehiculoActionPerformed(evt);
            }
        });

        jbAlquilarVehiculo.setBackground(new java.awt.Color(255, 255, 204));
        jbAlquilarVehiculo.setText("Alquilar");
        jbAlquilarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlquilarVehiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(jbAlquilarVehiculo)
                .addGap(75, 75, 75)
                .addComponent(jbBuscarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(jbVolverSolicVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbVolverSolicVehiculo)
                    .addComponent(jbBuscarVehiculo)
                    .addComponent(jbAlquilarVehiculo))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfMarcaAlquilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMarcaAlquilarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMarcaAlquilarActionPerformed

    private void jbVolverSolicVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverSolicVehiculoActionPerformed

        Usuario volUsuario = new Usuario();
        volUsuario.setVisible(true);
        this.setVisible(false);


    }//GEN-LAST:event_jbVolverSolicVehiculoActionPerformed

    private void jbBuscarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarVehiculoActionPerformed

        try {
            buscarVehiculo();

            //Se apilan las opciones de vehiculo
            for (int i = 0; i < accVehiculo.size(); i++) {

                for (int j = 0; j < vehiculo.getRegVehiculo().size(); j++) {

                    if (accVehiculo.get(i).getPlaca().toLowerCase()
                            .equals(vehiculo.getRegVehiculo().get(j)
                                    .getPlaca().toLowerCase())) {

                        push(vehiculo.getRegVehiculo().get(j));

                    }

                }

            }

            //Se decide mostrar al usuario hasta 3 opciones
            while (longitud > 3) {
                pop();
            }
            String placa = JOptionPane.showInputDialog(null, "Elija el vehiculo "
                    + "de preferencia\nInserte la placa\n\n" + Listar());

            //Eleccion
            try {
                NodoA aux = cima;
                while (aux != null) {
                    if (aux.getValor().getPlaca().toLowerCase()
                            .equals(placa.toLowerCase())) {
                        jtfCantPasajeros.setText(aux.getValor().getPasajeros());
                        jtfMarcaAlquilar.setText(aux.getValor().getMarca());
                        jtfModeloAlquilar.setText(aux.getValor().getModelo());
                        jtfAnnoAlquilar.setText(aux.getValor().getAnno());
                        jcbExtras.setSelectedItem(aux.getValor().getExtras().get(0));
                        jtfPlacaAlquiler.setText(aux.getValor().getPlaca());
                    }
                    aux = aux.getSiguiente();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error con la lectura "
                    + "de los valores ingresados, intente de nuevo");
        }


    }//GEN-LAST:event_jbBuscarVehiculoActionPerformed

    private void jcbExtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbExtrasActionPerformed

    }//GEN-LAST:event_jcbExtrasActionPerformed

    private void jbAlquilarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlquilarVehiculoActionPerformed

        if (!estadoAlquilado(jtfPlacaAlquiler.getText())) {
            solicAlquiler.add(new Solicitud(jtfPlacaAlquiler.getText(),
                    jtfCedulaAlquiler.getText(), "Registrada",
                    calculoAlquiler(jtfPlacaAlquiler.getText())));

            cambioCategoria((Integer.parseInt(jtfDiasAlquilar.getText())),
                    jtfCedulaAlquiler.getText(), jtfPlacaAlquiler.getText());
            cambioEstado(jtfPlacaAlquiler.getText());

            JOptionPane.showMessageDialog(null, "Solicitud procesada");
            Limpiar();
            jbAlquilarVehiculo.setEnabled(false);
        } else {
            solicAlquiler.add(new Solicitud(jtfPlacaAlquiler.getText(),
                    jtfCedulaAlquiler.getText(), "Rechazada",
                    calculoAlquiler(jtfPlacaAlquiler.getText())));

            cambioCategoria((Integer.parseInt(jtfDiasAlquilar.getText())),
                    jtfCedulaAlquiler.getText(), jtfPlacaAlquiler.getText());
            cambioEstado(jtfPlacaAlquiler.getText());

            JOptionPane.showMessageDialog(null, "Solicitud rechazada");
            Limpiar();
            jbAlquilarVehiculo.setEnabled(false);
        }

    }//GEN-LAST:event_jbAlquilarVehiculoActionPerformed

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
            java.util.logging.Logger.getLogger(SolicitudAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolicitudAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolicitudAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolicitudAlquiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SolicitudAlquiler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jbAlquilarVehiculo;
    private javax.swing.JButton jbBuscarVehiculo;
    private javax.swing.JButton jbVolverSolicVehiculo;
    private javax.swing.JComboBox<String> jcbExtras;
    private javax.swing.JTextField jtfAnnoAlquilar;
    private javax.swing.JTextField jtfCantPasajeros;
    private javax.swing.JTextField jtfCedulaAlquiler;
    private javax.swing.JTextField jtfDiasAlquilar;
    private javax.swing.JTextField jtfMarcaAlquilar;
    private javax.swing.JTextField jtfModeloAlquilar;
    private javax.swing.JTextField jtfPlacaAlquiler;
    // End of variables declaration//GEN-END:variables
}
