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
        setLocationRelativeTo(null);
        md = new DefaultTableModel(data, detalles);
        jtVehiculos.setModel(md);

        this.cima = null; //corresponde a pila
        this.longitud = 0; //corresponde a pila

    }

    //Informacion para tabla
    static DefaultTableModel md;
    private String data[][] = {};
    private String detalles[] = {"Placa", "Marca", "Modelo", "Año",
        "Color", "Cilindrada", "Combustible", "Num Pasajeros", "Alquiler/dia",
        "Estado", "Extras"};
    private TableRowSorter trsfiltro;

    Vehiculo veh = new Vehiculo();

    private Nodo cima; //corresponde a pila
    private int longitud; //corresponde a pila

    public boolean Vacia() { //corresponde a pila
        return cima == null;
    }

    public int tamano() { //corresponde a pila
        return longitud;
    }

    //se agregan nodos
    public void push(Vehiculo valor) {
        Nodo newNode = new Nodo();
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
    public boolean search(String reference) {
        Nodo aux = cima;
        boolean exist = false;
        while (exist != true && aux != null) {
            if (reference.toLowerCase().
                    equals(aux.getValor().getPlaca().toLowerCase())) {
                exist = true;
            } else {
                aux = aux.getSiguiente();
            }
        }
        return exist;
    }

    //Elimina según referencia
    public void delete(String reference) {
        //Consulta si el valor existe en la pila
        if (search(reference)) {
            Nodo cimaPilaAux = null;
            Nodo aux = cima;
            //Recorre la pila hasta llegar al nodo que tenga el valor 
            //igual que el de reference
            while (aux != null && reference.toLowerCase()
                    .equals(aux.getValor().getPlaca().toLowerCase())) {
                //Crea un nodo temporal para agregarlos a la pila auxiliar
                Nodo temp = new Nodo();
                //Ingresa el valor al node temmporal
                temp.setValor(aux.getValor());
                //Consulta si la pila auxiliar no ha sido inicializada
                if (cimaPilaAux == null) {
                    //Inicializa la pila auxiliar
                    cimaPilaAux = temp;
                } //Caso contrario si la pila auxiliar ya contiene elementos
                //los agrega
                else {
                    temp.setSiguiente(cimaPilaAux);
                    cimaPilaAux = temp;
                }
                //Elimina el nodo del tope de la pila hasta llegar al nodo
                //que se desea eliminar
                pop();
                aux = aux.getSiguiente();
            }
            //Elimina el nodo que coincide con el de reference
            pop();
            //Regresa los valores de la pila auxiliar a la pila original
            //mientras la pila auxiliar tenga elementos
            while (cimaPilaAux != null) {
                //Utiliza el metodo push para regresar elementos a la pila original
                push(cimaPilaAux.getValor());
            }
            //Libera la memoria utilizada por la pila auxiliar
            cimaPilaAux = null;
            JOptionPane.showMessageDialog(null, "El registro se eliminó "
                    + "exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "La placa indicada no esta "
                    + "registrada");
        }
    }

    //Busca el nodo segun valor y retorna vehiculo si exise y null si no existe
    public Vehiculo obtain(String reference) {
        Nodo aux = cima;
        Vehiculo exist = null;

        while (aux != null
                && search(reference)
                && aux.getValor().getPlaca().equals(reference.toLowerCase())) {

            exist = new Vehiculo(aux.getValor().getPlaca(),
                    aux.getValor().getMarca(), aux.getValor().getModelo(),
                    aux.getValor().getAnno(), aux.getValor().getColor(),
                    aux.getValor().getCilindrada(), aux.getValor().getCombustible(),
                    aux.getValor().getPasajeros(), aux.getValor().getAlquiler(),
                    aux.getValor().getEstado(), aux.getValor().getExtras());
            aux = aux.getSiguiente();
        }
        return exist;
    }

    //Se lista
    public String Listar() {
        String cad = "";
        //Crea una copia de la pila
        Nodo aux = cima;
        //Recorre la pila hasta el ultimo node
        while (aux != null) {
            cad += ("|\t" + aux.getValor() + "|\t");
            cad += ("-----------------");
            aux = aux.getSiguiente();
        }
        return cad;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtVehiculos = new javax.swing.JTable();

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
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAgregarExtra)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jtfAlquilerDia, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(jbLimpiarV))
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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
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
                                        .addComponent(jLabel9))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtfColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jtfAlquilerDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCilindrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(33, 33, 33)
                .addComponent(jbLimpiarV)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbMostrarV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminarV)
                    .addComponent(jbModificarV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRegistrarV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jtVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtVehiculos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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

    private void jtfModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfModeloActionPerformed

    private ArrayList<Vehiculo> pilaVeh = new ArrayList<>();

    public ArrayList<Vehiculo> getPilaVeh() {
        return pilaVeh;
    }

    public void setPilaVeh(ArrayList<Vehiculo> pilaVeh) {
        this.pilaVeh = pilaVeh;
    }


    private void jbRegistrarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarVActionPerformed

        if (ValidarCampos()) {
            push(new Vehiculo(this.jtfPlaca.getText(),
                    this.jtfMarca.getText(), this.jtfModelo.getText(),
                    this.jtfAnno.getText(), this.jtfColor.getText(),
                    this.jtfCilindrada.getText(), this.jtfCombustible.getText(),
                    this.jtfPasajeros.getText(), this.jtfAlquilerDia.getText(),
                    "Excelente", extras));
        } else {
            JOptionPane.showMessageDialog(null, "Complete todos los espacios "
                    + "antes de registrar un vehiculo");
        }

        Limpiar();

//        for (int i = 0; i < extras.size(); i++) {
//            extras.remove(i);
//        }

    }//GEN-LAST:event_jbRegistrarVActionPerformed

    private void jbLimpiarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarVActionPerformed
        Limpiar();
    }//GEN-LAST:event_jbLimpiarVActionPerformed

    private ArrayList<String> extras = new ArrayList<>();

    private void jbAgregarExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarExtraActionPerformed
        extras.add(this.jtfExtra.getText());
        this.jtfExtra.setText("");

    }//GEN-LAST:event_jbAgregarExtraActionPerformed

    private void jbEliminarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarVActionPerformed

        String placa = JOptionPane.showInputDialog("Ingrese la placa");
        int op = JOptionPane.showConfirmDialog(null, "Se eliminará este registro, ¿está seguro?");
        JOptionPane.showMessageDialog(null, search(placa));
        if (op == 0) {
            delete(placa);
        }
        JOptionPane.showMessageDialog(null, Listar());

    }//GEN-LAST:event_jbEliminarVActionPerformed

    private void jbModificarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarVActionPerformed

        jtfPlaca.setEnabled(false);
        String placa = JOptionPane.showInputDialog("Ingrese la placa");

        LlenarCampos(placa);
        jbModificarV.setEnabled(false);


    }//GEN-LAST:event_jbModificarVActionPerformed

    private void jbMostrarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarVActionPerformed

        md = (DefaultTableModel) jtVehiculos.getModel();
        Object[] vehic = new Object[11];

        JOptionPane.showMessageDialog(null, md.getRowCount());
        
        for (int i = 0; i < md.getRowCount(); i++) {
            md.removeRow(i);
        }
        
        Nodo aux = cima;
        while (aux != null) {

            vehic[0] = aux.getValor().getPlaca();
            vehic[1] = aux.getValor().getMarca();
            vehic[2] = aux.getValor().getModelo();
            vehic[3] = aux.getValor().getAnno();
            vehic[4] = aux.getValor().getColor();
            vehic[5] = aux.getValor().getCilindrada();
            vehic[6] = aux.getValor().getCombustible();
            vehic[7] = aux.getValor().getPasajeros();
            vehic[8] = aux.getValor().getAlquiler();
            vehic[9] = aux.getValor().getEstado();
            vehic[10] = aux.getValor().getExtras();

            md.addRow(vehic);

            aux = aux.getSiguiente();
        }


    }//GEN-LAST:event_jbMostrarVActionPerformed

    private void jbVolverAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverAdminActionPerformed

        Administracion volv = new Administracion();
        volv.setVisible(true);
        this.setVisible(false);


    }//GEN-LAST:event_jbVolverAdminActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregarExtra;
    private javax.swing.JButton jbEliminarV;
    private javax.swing.JButton jbLimpiarV;
    private javax.swing.JButton jbModificarV;
    private javax.swing.JButton jbMostrarV;
    private javax.swing.JButton jbRegistrarV;
    private javax.swing.JButton jbVolverAdmin;
    private javax.swing.JTable jtVehiculos;
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
