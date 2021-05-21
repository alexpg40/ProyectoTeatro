/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.BonoDAO;
import DAO.UsuarioDAO;
import DAO.FranquiciaDAO;
import Entidades.Usuario;
import Entidades.Utilidades;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

/**
 *
 * @author guill
 */
public class panelUsuario extends javax.swing.JFrame {

    /**
     * Creates new form panelUsuario
     */
    private String email;
    private String contrasena;
    private String nombre;
    private String apellido;
    private String nif;
    private String telefono;

    public panelUsuario() {
        initComponents();
    }

    public panelUsuario(String email, String contrasena, String nombre, String apellido, String nif, String telefono) {
        this.email = email;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nif = nif;
        this.telefono = telefono;
        initComponents();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuario getUsuarioActual(String emailUsuarioActual) {
        Usuario usuario = UsuarioDAO.selecionarActual(emailUsuarioActual);
        return usuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        checkboxNombre = new javax.swing.JCheckBox();
        checkboxApellidos = new javax.swing.JCheckBox();
        checkboxTelefono = new javax.swing.JCheckBox();
        checkboxEmail = new javax.swing.JCheckBox();
        campoNombre = new javax.swing.JTextField();
        campoApellidos = new javax.swing.JTextField();
        campoNif = new javax.swing.JTextField();
        campoTelefono = new javax.swing.JTextField();
        campoEmail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboboxTipos = new javax.swing.JComboBox<>();
        botonTarjetaCredito = new javax.swing.JRadioButton();
        botonTransferenciaBancaria = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaBonos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        jLabel9.setText("jLabel9");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jPanel2ComponentAdded(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Hola, " + this.nombre);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tus datos: ");

        jLabel3.setText("Nombre: ");

        jLabel4.setText("Apellidos:");

        jLabel5.setText("NIF:");

        jLabel6.setText("Telefono:");

        jLabel7.setText("Email:");

        checkboxNombre.setText("Editable");
        checkboxNombre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkboxNombreItemStateChanged(evt);
            }
        });

        checkboxApellidos.setText("Editable");
        checkboxApellidos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkboxApellidosStateChanged(evt);
            }
        });

        checkboxTelefono.setText("Editable");
        checkboxTelefono.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkboxTelefonoStateChanged(evt);
            }
        });
        checkboxTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkboxTelefonoMouseClicked(evt);
            }
        });

        checkboxEmail.setText("Editable");
        checkboxEmail.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkboxEmailStateChanged(evt);
            }
        });
        checkboxEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkboxEmailMouseClicked(evt);
            }
        });

        campoNombre.setEnabled(true);
        campoNombre.setEditable(false);
        campoNombre.setText(this.getNombre());

        campoApellidos.setEditable(false);
        campoApellidos.setText(this.getApellido());

        campoNif.setEditable(false);
        campoNif.setText(this.getNif());
        campoNif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNifActionPerformed(evt);
            }
        });

        campoTelefono.setEditable(false);
        campoTelefono.setText(this.getTelefono());

        campoEmail.setEditable(false);
        campoEmail.setText(this.getEmail());
        campoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEmailActionPerformed(evt);
            }
        });

        jButton1.setText("Cambiar contraseña");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        btnModificar.setText("Modificar campos");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(10, 15, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(campoApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                                    .addComponent(campoNombre))
                                .addComponent(campoNif, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkboxNombre)
                            .addComponent(checkboxApellidos)
                            .addComponent(checkboxTelefono)
                            .addComponent(checkboxEmail))
                        .addContainerGap(54, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxNombre)
                    .addComponent(jLabel3)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(checkboxApellidos)
                    .addComponent(campoApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxTelefono)
                    .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkboxEmail))
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inicio", jPanel2);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Comprar bono (Mensual)");

        jLabel10.setText("Tipo de bono: ");

        comboboxTipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo C - Completo", "Tipo P - Parcial" }));

        buttonGroup1.add(botonTarjetaCredito);
        botonTarjetaCredito.setText("Tarjeta de credito");

        buttonGroup1.add(botonTransferenciaBancaria);
        botonTransferenciaBancaria.setText("Transferencia bancaria");

        jLabel11.setText("Metodo de pago:");

        jButton2.setText("Comprar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Ver mis bonos");

        tablaBonos.setAutoCreateRowSorter(true);
        tablaBonos.setModel(new javax.swing.table.DefaultTableModel(

            UsuarioDAO.seleccionarBonosUsuario(this.getEmail()),
            new String [] {
                "Mes", "Tipo"

            }
        ));
        jScrollPane4.setViewportView(tablaBonos);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(225, 225, 225))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(botonTarjetaCredito)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(botonTransferenciaBancaria)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboboxTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(comboboxTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(botonTarjetaCredito)
                            .addComponent(botonTransferenciaBancaria)))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bonos", jPanel5);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            FranquiciaDAO.seleccionarFranquicias(),
            new String [] {
                "Ubicacion", "Cuenta con facilidades para la movilidad reducida"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Ver franquicias", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jPanel2ComponentAdded

    }//GEN-LAST:event_jPanel2ComponentAdded

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        String Nombre = this.nombre,
                Apellido = this.apellido,
                Telefono = this.telefono,
                Email = this.email;

        String nuevoNombre = campoNombre.getText(),
                nuevoApellido = campoApellidos.getText(),
                nuevoTelefono = campoTelefono.getText(),
                nuevoEmail = campoEmail.getText();

        if (JOptionPane.showConfirmDialog(this, "Nuevo nombre introducido: " + nuevoNombre + "\n"
                + "Nuevo apellido introducido: " + nuevoApellido + "\n"
                + "\n" + "Nuevo telefono introducido: " + nuevoTelefono + "\n" + "Nuevo email introducido: " + nuevoEmail) == 0) {

            if (campoNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo Nombre está sin rellenar.", "Error: Introduzca los datos necesarios.", WARNING_MESSAGE);
                evt.consume();
            } else if (campoNombre.getText().length() > 45) {
                JOptionPane.showMessageDialog(this, "El campo Nombre es mayor de 45 carácteres.", "Error: El Nombre es muy largo.", WARNING_MESSAGE);
                evt.consume();
            } else if (campoNombre.getText().matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(this, "El campo Nombre no puede tener numeros.", "Error: El nombre tiene letras.", WARNING_MESSAGE);
                evt.consume();
            } else if (!nuevoNombre.equals(Nombre)) {
                UsuarioDAO.actualizarNombreUsuario(nuevoNombre, this.nif, this.email, this.contrasena);
            }

            if (campoApellidos.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo Apellido está sin rellenar.", "Error: Introduzca los datos necesarios.", WARNING_MESSAGE);
                evt.consume();
            } else if (campoApellidos.getText().length() > 45) {
                JOptionPane.showMessageDialog(this, "El campo Apellido es mayor de 45 carácteres.", "Error: El apellido es muy largo.", WARNING_MESSAGE);
                evt.consume();
            } else if (campoApellidos.getText().matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(this, "El campo Apellido no puede tener numeros.", "Error: El apellido tiene numeros.", WARNING_MESSAGE);
                evt.consume();
            } else if (!nuevoApellido.equals(Apellido)) {
                UsuarioDAO.actualizarApellidoUsuario(nuevoApellido, this.nif, this.email, this.contrasena);
            }

            if (campoTelefono.getText().length() != 9) {
                JOptionPane.showMessageDialog(this, "El campo Telefono tiene que tener una longitud de 9 carácteres.", "Error: El NIF no tiene una longitud adecuada..", WARNING_MESSAGE);
                evt.consume();
            } else if (!Utilidades.isNumeric(campoTelefono.getText().substring(0, 8))) {
                JOptionPane.showMessageDialog(this, "El campo Telefono tiene que ser solo numeros.", "Error: El Telefono tiene letras.", WARNING_MESSAGE);
                evt.consume();
            } else if (!nuevoTelefono.equals(Telefono)) {
                UsuarioDAO.actualizarTelefonoUsuario(nuevoTelefono, this.nif, this.email, this.contrasena);
            }

            if (campoEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo Email no está introducido", "Error: El Email está vacío.", WARNING_MESSAGE);
                evt.consume();
            } else if (UsuarioDAO.comprobarCorreoRepetidoExcepto(nuevoEmail, Nombre)) {
                JOptionPane.showMessageDialog(this, "El email ya existe.", "Error: El Email ya existe.", WARNING_MESSAGE);
                evt.consume();

            } else {
                UsuarioDAO.actualizarEmailUsuario(this.getNif(), nuevoEmail, Email, this.contrasena);
                evt.consume();
                Principal p = new Principal();
                JOptionPane.showMessageDialog(this, "El cambio se ha realizado con exito, vuelva a iniciar sesion por favor.", "Exito", INFORMATION_MESSAGE);
                p.setVisible(true);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_btnModificarMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        cambioContrasenaUsuario ccu = new cambioContrasenaUsuario(this, true);
        ccu.setLocationRelativeTo(this);
        ccu.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void campoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEmailActionPerformed

    private void campoNifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNifActionPerformed

    private void checkboxEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkboxEmailMouseClicked

    }//GEN-LAST:event_checkboxEmailMouseClicked

    private void checkboxEmailStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkboxEmailStateChanged
        if (checkboxEmail.isSelected()) {
            campoEmail.setEditable(true);
        } else {
            campoEmail.setEditable(false);
        }
    }//GEN-LAST:event_checkboxEmailStateChanged

    private void checkboxTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkboxTelefonoMouseClicked

    }//GEN-LAST:event_checkboxTelefonoMouseClicked

    private void checkboxTelefonoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkboxTelefonoStateChanged
        if (checkboxTelefono.isSelected()) {
            campoTelefono.setEditable(true);
        } else {
            campoTelefono.setEditable(false);
        }
    }//GEN-LAST:event_checkboxTelefonoStateChanged

    private void checkboxApellidosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkboxApellidosStateChanged
        if (checkboxApellidos.isSelected()) {
            campoApellidos.setEditable(true);
        } else {
            campoApellidos.setEditable(false);
        }
    }//GEN-LAST:event_checkboxApellidosStateChanged

    private void checkboxNombreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkboxNombreItemStateChanged
        if (checkboxNombre.isSelected()) {
            campoNombre.setEditable(true);
        } else {
            campoNombre.setEditable(false);
        }
    }//GEN-LAST:event_checkboxNombreItemStateChanged

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        String metodoPago = "";
        String tipo = "";
        if (!botonTransferenciaBancaria.isSelected() && !botonTarjetaCredito.isSelected()) {
            JOptionPane.showMessageDialog(this, "Seleccione un metodo de pago.", "Error: Seleccione un metodo de pago.", WARNING_MESSAGE);
        } else if (botonTarjetaCredito.isSelected()) {
            metodoPago = "tc";
            int idUsuario = UsuarioDAO.seleccionarIdUsuario(this.getEmail());
            int mesActual = LocalDate.now().getMonthValue();
            if (BonoDAO.comprobarBono(mesActual, idUsuario) == false) {
                if (comboboxTipos.getSelectedIndex() == 0) {
                    tipo = "C";
                } else if (comboboxTipos.getSelectedIndex() == 1) {
                    tipo = "P";
                }
                CompraBonoTarjeta cb = new CompraBonoTarjeta(this, true, this.email, tipo);
                cb.setVisible(true);
            } else if (botonTransferenciaBancaria.isSelected()) {
            }
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(panelUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panelUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panelUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panelUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new panelUsuario().setVisible(true);
            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton botonTarjetaCredito;
    private javax.swing.JRadioButton botonTransferenciaBancaria;
    private javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoApellidos;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNif;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JCheckBox checkboxApellidos;
    private javax.swing.JCheckBox checkboxEmail;
    private javax.swing.JCheckBox checkboxNombre;
    private javax.swing.JCheckBox checkboxTelefono;
    private javax.swing.JComboBox<String> comboboxTipos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable tablaBonos;
    // End of variables declaration//GEN-END:variables
}