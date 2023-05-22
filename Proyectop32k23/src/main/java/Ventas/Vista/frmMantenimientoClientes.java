/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Carlos Javier Sandoval Catalán
//9959-21-1324
//Mantenimiento Clientes
package Ventas.Vista;


import Seguridad.Controlador.clsBitacora;
import Ventas.Controlador.clsClientes;
import Seguridad.Controlador.clsUsuarioConectado;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author visitante
 */
public class frmMantenimientoClientes extends javax.swing.JInternalFrame {

    public void llenadoDeCombos() {
        /*EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        List<Empleado> empleados = empleadoDAO.select();
        cbox_empleado.addItem("Seleccione una opción");
        for (int i = 0; i < empleados.size(); i++) {
            cbox_empleado.addItem(empleados.get(i).getNombreEmpleado());
        } */
    }

    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Email");
        modelo.addColumn("Nit");
        modelo.addColumn("Haber");
        modelo.addColumn("Debe");
        clsClientes cliente = new clsClientes();
        //VendedorDAO vendedorDAO = new VendedorDAO();
        List<clsClientes> listaClientes = cliente.getListadoClientes();
        tablaClientes.setModel(modelo);
        String[] dato = new String[8];
        for (int i = 0; i < listaClientes.size(); i++) {
            dato[0] = Integer.toString(listaClientes.get(i).getIdCliente());
            dato[1] = listaClientes.get(i).getNombreCliente();
            dato[2] = listaClientes.get(i).getEstatusCliente();
            dato[3] = listaClientes.get(i).getTelefonoCliente();
            dato[4] = listaClientes.get(i).getEmailCliente();
            dato[5] = listaClientes.get(i).getNitCliente();
            dato[6] = Double.toString(listaClientes.get(i).getHaberCliente());
            dato[7] = Double.toString(listaClientes.get(i).getDebeCliente());
            modelo.addRow(dato);
        }       


    }


int codigoAplicacion = 3001;

    public frmMantenimientoClientes() {
        initComponents();
        llenadoDeTablas();
        llenadoDeCombos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2Tienda = new javax.swing.JLabel();
        lbusuTienda = new javax.swing.JLabel();
        btnEliminarCliente = new javax.swing.JButton();
        btnRegistrarCliente = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        lbClienteT = new javax.swing.JLabel();
        btnModificarCliente = new javax.swing.JButton();
        lbnombreCliente = new javax.swing.JLabel();
        txtClientebuscado = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        btnLimpiarCliente = new javax.swing.JButton();
        jScrollPaneClientes = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        txtDireccionCliente = new javax.swing.JTextField();
        lbEstatusCliente = new javax.swing.JLabel();
        btnAyudaCliente = new javax.swing.JButton();
        lbBuscarCliente = new javax.swing.JLabel();
        btnActualizarClientes = new javax.swing.JButton();
        lbEstatusCliente1 = new javax.swing.JLabel();
        lbEstatusCliente2 = new javax.swing.JLabel();
        lbEstatusCliente3 = new javax.swing.JLabel();
        lbEstatusCliente4 = new javax.swing.JLabel();
        lbEstatusCliente5 = new javax.swing.JLabel();
        txtTelefonoCliente = new javax.swing.JTextField();
        txtEmailCliente = new javax.swing.JTextField();
        txtNitCliente = new javax.swing.JTextField();
        txtHaberCliente = new javax.swing.JTextField();
        txtDebeCliente = new javax.swing.JTextField();

        lb2Tienda.setForeground(new java.awt.Color(204, 204, 204));
        lb2Tienda.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Clientes");
        setVisible(true);

        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        btnRegistrarCliente.setText("Registrar");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        lbClienteT.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lbClienteT.setText("Clientes");

        btnModificarCliente.setText("Modificar");
        btnModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarClienteActionPerformed(evt);
            }
        });

        lbnombreCliente.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lbnombreCliente.setText("Nombre");

        txtNombreCliente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNombreCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        btnLimpiarCliente.setText("Limpiar");
        btnLimpiarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarClienteActionPerformed(evt);
            }
        });

        tablaClientes.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Vendedor", "ID Empleado", "Correo", "Telefono", "Direccion", "Porcentaje", "Comision"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneClientes.setViewportView(tablaClientes);

        txtDireccionCliente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtDireccionCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        lbEstatusCliente.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lbEstatusCliente.setText("Direccion");

        btnAyudaCliente.setText("Ayuda");
        btnAyudaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaClienteActionPerformed(evt);
            }
        });

        lbBuscarCliente.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lbBuscarCliente.setText("ID a buscar");

        btnActualizarClientes.setText("Actualizar");
        btnActualizarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClientesActionPerformed(evt);
            }
        });

        lbEstatusCliente1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lbEstatusCliente1.setText("Telefono");

        lbEstatusCliente2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lbEstatusCliente2.setText("Email");

        lbEstatusCliente3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lbEstatusCliente3.setText("Nit");

        lbEstatusCliente4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lbEstatusCliente4.setText("Haber(Q)");

        lbEstatusCliente5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lbEstatusCliente5.setText("Debe(Q)");

        txtTelefonoCliente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtTelefonoCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        txtEmailCliente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtEmailCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        txtNitCliente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtNitCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        txtHaberCliente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtHaberCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        txtDebeCliente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtDebeCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(52, 52, 52)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnModificarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnLimpiarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(14, 14, 14)
                                    .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lbBuscarCliente)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAyudaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtClientebuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbnombreCliente)
                                    .addComponent(lbEstatusCliente)
                                    .addComponent(lbEstatusCliente1)
                                    .addComponent(lbEstatusCliente2)
                                    .addComponent(lbEstatusCliente3))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNitCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                    .addComponent(txtEmailCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                    .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDireccionCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                        .addComponent(txtNombreCliente)))))
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbEstatusCliente4)
                        .addGap(18, 18, 18)
                        .addComponent(txtHaberCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lbEstatusCliente5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDebeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnActualizarClientes)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbClienteT)
                        .addGap(294, 592, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbClienteT)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPaneClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizarClientes)
                        .addContainerGap(54, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnombreCliente))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEstatusCliente))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbEstatusCliente1)
                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbEstatusCliente2)
                            .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbEstatusCliente3)
                            .addComponent(txtNitCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbEstatusCliente4)
                            .addComponent(lbEstatusCliente5)
                            .addComponent(txtHaberCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDebeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrarCliente)
                            .addComponent(btnEliminarCliente)
                            .addComponent(btnModificarCliente))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAyudaCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLimpiarCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtClientebuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbBuscarCliente)
                            .addComponent(btnBuscarCliente))
                        .addGap(38, 38, 38))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        // TODO add your handling code here:
        int registrosBorrados=0;
        clsClientes cliente = new clsClientes();
        cliente.setIdCliente(Integer.parseInt(txtClientebuscado.getText()));
        registrosBorrados=cliente.setBorrarCliente(cliente);
        JOptionPane.showMessageDialog(null, "Registro Borrado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        int resultadoBitacora=0;
                    clsBitacora bitacoraRegistro = new clsBitacora();
                    resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(),codigoAplicacion,"DEL"); 
        llenadoDeTablas();
        limpiarTextos();
        
        
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        clsClientes cliente = new clsClientes();
        cliente.setNombreCliente(txtNombreCliente.getText());
        cliente.setEstatusCliente(txtDireccionCliente.getText());
        cliente.setTelefonoCliente(txtTelefonoCliente.getText());
        cliente.setEmailCliente(txtEmailCliente.getText());
        cliente.setNitCliente(txtNitCliente.getText());
        cliente.setHaberCliente(Double.valueOf(txtHaberCliente.getText()));
        cliente.setDebeCliente(Double.valueOf(txtDebeCliente.getText()));
        cliente.setIngresarCliente(cliente);
        JOptionPane.showMessageDialog(null, "Registro Ingresado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "INS");
        llenadoDeTablas();
        limpiarTextos();
        
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // TODO add your handling code here:
        clsClientes cliente = new clsClientes();
        //aplicacion.setNombreAplicacion(txtbuscado.getText());        
       cliente.setIdCliente(Integer.parseInt(txtClientebuscado.getText()));        
        cliente = cliente.getBuscarInformacionClientePorId(cliente);
        System.out.println("Usuario retornado:" + cliente);        
        txtNombreCliente.setText(cliente.getNombreCliente());
        txtDireccionCliente.setText(cliente.getEstatusCliente());
        txtTelefonoCliente.setText(cliente.getTelefonoCliente());
        txtEmailCliente.setText(cliente.getEmailCliente());
        txtNitCliente.setText(cliente.getNitCliente());
        txtHaberCliente.setText(String.valueOf(cliente.getHaberCliente()));
        txtDebeCliente.setText(String.valueOf(cliente.getDebeCliente()));
         int resultadoBitacora=0;
                    clsBitacora bitacoraRegistro = new clsBitacora();
                    resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "QRY");
                 
        
        
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarClienteActionPerformed
//        // TODO add your handling code here:
        clsClientes cliente = new clsClientes();
        cliente.setIdCliente(Integer.parseInt(txtClientebuscado.getText()));
        cliente.setNombreCliente(txtNombreCliente.getText());
        cliente.setEstatusCliente(txtDireccionCliente.getText());
        cliente.setTelefonoCliente(txtTelefonoCliente.getText());
        cliente.setEmailCliente(txtEmailCliente.getText());
        cliente.setNitCliente(txtNitCliente.getText());
        cliente.setHaberCliente(Double.valueOf(txtHaberCliente.getText()));
        cliente.setDebeCliente(Double.valueOf(txtDebeCliente.getText()));
        cliente.setModificarCliente(cliente);
        JOptionPane.showMessageDialog(null, "Registro Modificado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);      
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "UPD");
        llenadoDeTablas();
        limpiarTextos();
    }//GEN-LAST:event_btnModificarClienteActionPerformed

    private void btnLimpiarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarClienteActionPerformed
        limpiarTextos();
        habilitarBotones();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarClienteActionPerformed
    public void limpiarTextos()
    {
        txtNombreCliente.setText("");
        txtDireccionCliente.setText("");
        txtTelefonoCliente.setText("");
        txtEmailCliente.setText("");
        txtNitCliente.setText("");
        txtHaberCliente.setText("");
        txtDebeCliente.setText("");
        txtClientebuscado.setText("");
    }
    public void habilitarBotones()
    {
        btnRegistrarCliente.setEnabled(true);
        btnModificarCliente.setEnabled(true);
        btnEliminarCliente.setEnabled(true);
    }
    public void desHabilitarBotones()
    {
        btnRegistrarCliente.setEnabled(false);
        btnModificarCliente.setEnabled(false);
        btnEliminarCliente.setEnabled(false);
    }    
    
    private void btnAyudaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaClienteActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\ayudas\\ProcesoMayor.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\ayudas\\ProcesoMayor.chm");
                p.waitFor();
            } else {
                System.out.println("La ayuda no Fue encontrada");
            }
            System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAyudaClienteActionPerformed

    private void btnActualizarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClientesActionPerformed
        // TODO add your handling code here:
        llenadoDeTablas();
    }//GEN-LAST:event_btnActualizarClientesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarClientes;
    private javax.swing.JButton btnAyudaCliente;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnLimpiarCliente;
    private javax.swing.JButton btnModificarCliente;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JScrollPane jScrollPaneClientes;
    private javax.swing.JLabel lb2Tienda;
    private javax.swing.JLabel lbBuscarCliente;
    private javax.swing.JLabel lbClienteT;
    private javax.swing.JLabel lbEstatusCliente;
    private javax.swing.JLabel lbEstatusCliente1;
    private javax.swing.JLabel lbEstatusCliente2;
    private javax.swing.JLabel lbEstatusCliente3;
    private javax.swing.JLabel lbEstatusCliente4;
    private javax.swing.JLabel lbEstatusCliente5;
    private javax.swing.JLabel lbnombreCliente;
    private javax.swing.JLabel lbusuTienda;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtClientebuscado;
    private javax.swing.JTextField txtDebeCliente;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtEmailCliente;
    private javax.swing.JTextField txtHaberCliente;
    private javax.swing.JTextField txtNitCliente;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}
