/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Hecho por: Alyson Vannesa Rodríguez Quezada 9959-21-829
package Bancos.Vista;


import Seguridad.Controlador.clsBitacora;
import Bancos.Controlador.clsCuentasBancos;
import Bancos.Controlador.clsPersonaBancos;
import Bancos.Controlador.clsTipoCuentas;
import Bancos.Controlador.clsTipoMoneda;
import Bancos.Controlador.clsBancoExterno;
import Seguridad.Controlador.clsUsuarioConectado;
import java.awt.Component;
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
public class frmMantenimientoCuentasBancos extends javax.swing.JInternalFrame {
    
int codigoAplicacion=5006;

    public void llenadoDeComboIdPersona() {
        clsPersonaBancos personas = new clsPersonaBancos();
        List<clsPersonaBancos> listaPersonas = personas.getListadoBancoPersonas();
        cbIdPersona.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbIdPersona.addItem("Seleccionar...");
        for (int i = 0; i < listaPersonas.size(); i++) {
            //clsPersonaBancos personaBanco = listaPersonas.get(i);
            //String item = personaBanco.getPerId()+ " - "+personaBanco.getPerNombre();
            //cbIdPersona.addItem(item);
            cbIdPersona.addItem(String.valueOf(listaPersonas.get(i).getPerId()));
        } 
        
    }

    public void llenadoDeComboTipoCuenta() {
        clsTipoCuentas cuentas = new clsTipoCuentas();
        List<clsTipoCuentas> listaTipoCuentas = cuentas.getListadoTipoCuentas();
        cbTipoCuenta.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbTipoCuenta.addItem("Seleccionar...");
        for (int i = 0; i < listaTipoCuentas.size(); i++) {
            //clsTipoCuentas cuentasbanco = listaTipoCuentas.get(i);
            //String item = cuentasbanco.getTipoCueId()+ " - "+cuentasbanco.getTipoCueDescripcion();
            //cbTipoCuenta.addItem(item);  
            cbTipoCuenta.addItem(String.valueOf(listaTipoCuentas.get(i).getTipoCueId()));
        } 
        
    }
    
    public void llenadoDeComboTipoMoneda() {
        clsTipoMoneda monedas = new clsTipoMoneda();
        List<clsTipoMoneda> listaTipoMoneda = monedas.getListadoMonedas();
        cbMoneda.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbMoneda.addItem("Seleccionar...");
        for (int i = 0; i < listaTipoMoneda.size(); i++) {
            //clsTipoMoneda tipoMoneda = listaTipoMoneda.get(i);
            //String item = tipoMoneda.getTipModId()+ " - "+tipoMoneda.getTipMondNombre();
            //cbMoneda.addItem(item);
            cbMoneda.addItem(String.valueOf(listaTipoMoneda.get(i).getTipModId()));
        } 
        
    }
    
    public void llenadoDeComboBanco() {
        clsBancoExterno banco = new clsBancoExterno();
        List<clsBancoExterno> listaBanco = banco.getListadoBancosExternos();
        cbBanco.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbBanco.addItem("Seleccionar...");
        for (int i = 0; i < listaBanco.size(); i++) {
            //clsBancoExterno bancoExterno = listaBanco.get(i);
            //String item = bancoExterno.getCodigoBanco()+ " - "+bancoExterno.getNombreBanco();
            //cbBanco.addItem(item);
            cbBanco.addItem(String.valueOf(listaBanco.get(i).getCodigoBanco()));
        } 
        
    }
    
    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Cuenta");
        modelo.addColumn("Saldo");
        modelo.addColumn("ID Persona");
        modelo.addColumn("Tipo Cuenta");
        modelo.addColumn("Estatus");
        modelo.addColumn("Moneda");
        modelo.addColumn("Banco");
        clsCuentasBancos cuenta = new clsCuentasBancos();
        
        //VendedorDAO vendedorDAO = new VendedorDAO();
        List<clsCuentasBancos> listaCuenta = cuenta.getListadoCuentas();
        tablaCuentas.setModel(modelo);
        String[] dato = new String[7];
        for (int i = 0; i < listaCuenta.size(); i++) {
            dato[0] = Integer.toString(listaCuenta.get(i).getIdCuenta());
            dato[1] = Double.toString(listaCuenta.get(i).getSaldoCuenta());
            dato[2] = Integer.toString(listaCuenta.get(i).getIdPersona());
            dato[3] = Integer.toString(listaCuenta.get(i).getIdTipoCuenta());
            dato[4] = listaCuenta.get(i).getEstatusCuenta();
            dato[5] = Integer.toString(listaCuenta.get(i).getTipModId());
            dato[6] = Integer.toString(listaCuenta.get(i).getCodBanco());
            modelo.addRow(dato);
        }       
    }

    public frmMantenimientoCuentasBancos() {
        initComponents();
        llenadoDeTablas();
        llenadoDeComboIdPersona();
        llenadoDeComboTipoCuenta();
        llenadoDeComboTipoMoneda();
        llenadoDeComboBanco();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2 = new javax.swing.JLabel();
        lbusu = new javax.swing.JLabel();
        tipoEstatus = new javax.swing.ButtonGroup();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        txtbuscado = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCuentas = new javax.swing.JTable();
        txtSaldo = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        label4 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        label6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        label7 = new javax.swing.JLabel();
        label10 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();
        cbIdPersona = new javax.swing.JComboBox<>();
        cbTipoCuenta = new javax.swing.JComboBox<>();
        rbHabilitar = new javax.swing.JRadioButton();
        rbDeshabilitar = new javax.swing.JRadioButton();
        label11 = new javax.swing.JLabel();
        label12 = new javax.swing.JLabel();
        cbMoneda = new javax.swing.JComboBox<>();
        cbBanco = new javax.swing.JComboBox<>();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle(" Cuentas Bancos");
        setVisible(true);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Cuentas Bancarias");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tablaCuentas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaCuentas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaCuentas);

        txtSaldo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtSaldo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtSaldo.setOpaque(false);
        txtSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoActionPerformed(evt);
            }
        });

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Saldo");

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");

        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("ID a buscar");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("ID Persona");

        txtId.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtId.setOpaque(false);

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("ID");

        label10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label10.setText("Estatus");

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("Tipo Cuenta");

        cbIdPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIdPersonaActionPerformed(evt);
            }
        });

        cbTipoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoCuentaActionPerformed(evt);
            }
        });

        tipoEstatus.add(rbHabilitar);
        rbHabilitar.setText("Habilitado");
        rbHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbHabilitarActionPerformed(evt);
            }
        });

        tipoEstatus.add(rbDeshabilitar);
        rbDeshabilitar.setText("Deshabilitado");

        label11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label11.setText("Moneda");

        label12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label12.setText("Banco");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label7)
                        .addGap(108, 108, 108)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(14, 14, 14)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(406, 406, 406)
                                .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label5)
                                    .addComponent(label6))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSaldo)
                                    .addComponent(cbIdPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label8)
                                .addGap(310, 310, 310))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(label10)
                                            .addGap(83, 83, 83))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(label11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label12)
                                        .addGap(82, 82, 82)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbHabilitar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbDeshabilitar))
                                    .addComponent(cbTipoCuenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbMoneda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1)
                    .addComponent(btnActualizar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(cbIdPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label8)
                            .addComponent(cbTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label12))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbHabilitar)
                                    .addComponent(rbDeshabilitar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnEliminar)
                            .addComponent(btnModificar))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiar)
                            .addComponent(jButton2))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar)
                        .addContainerGap(110, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int registrosBorrados=0;
        clsCuentasBancos cuenta = new clsCuentasBancos();
        cuenta.setIdCuenta(Integer.parseInt(txtbuscado.getText()));
        registrosBorrados=cuenta.setBorrarCuenta(cuenta);
        JOptionPane.showMessageDialog(null, "Registro Borrado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        llenadoDeTablas();
        
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "DEL");
        
        limpiarTextos();
    }//GEN-LAST:event_btnEliminarActionPerformed
    //int contador=0; 
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        clsCuentasBancos cuenta = new clsCuentasBancos();
        
        cuenta.setIdCuenta(Integer.parseInt(txtId.getText()));    
        cuenta.setSaldoCuenta(Double.parseDouble(txtSaldo.getText()));
        cuenta.setIdPersona(Integer.parseInt(cbIdPersona.getSelectedItem().toString()));
        cuenta.setIdTipoCuenta(Integer.parseInt(cbTipoCuenta.getSelectedItem().toString()));

        if(rbHabilitar.isSelected()){
            cuenta.setEstatusCuenta("T");
        }
        
        else if(rbDeshabilitar.isSelected()){
            cuenta.setEstatusCuenta("F");
        }
        else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un estatus.");
            return;
        }
        
        cuenta.setTipModId(Integer.parseInt(cbMoneda.getSelectedItem().toString()));
        cuenta.setCodBanco(Integer.parseInt(cbBanco.getSelectedItem().toString()));
        
        cuenta.setIngresarCuenta(cuenta);
        JOptionPane.showMessageDialog(null, "Registro Ingresado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        
        llenadoDeTablas();
        
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "INS");
        
        limpiarTextos();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
            // TODO add your handling code here:
        clsCuentasBancos cuenta = new clsCuentasBancos();
        //usuario.setNombreUsuario(txtbuscado.getText());        
        cuenta.setIdCuenta(Integer.parseInt(txtbuscado.getText()));        
        cuenta = cuenta.getBuscarInformacionCuentaPorId(cuenta);
        System.out.println("Cuenta retornado:" + cuenta);        
        txtSaldo.setText(Double.toString(cuenta.getSaldoCuenta()));
        
        int IdPersona = cuenta.getIdPersona();
        for (int i = 1; i < cbIdPersona.getItemCount(); i++) {
            int item = Integer.parseInt(cbIdPersona.getItemAt(i).toString());
            if (item == IdPersona) {
                cbIdPersona.setSelectedIndex(i);
                break;
            }
        }
        
        int IdTipoCuenta = cuenta.getIdTipoCuenta();
        for (int i = 1; i < cbTipoCuenta.getItemCount(); i++) {
            int item = Integer.parseInt(cbTipoCuenta.getItemAt(i).toString());
            if (item == IdTipoCuenta) {
                cbTipoCuenta.setSelectedIndex(i);
                break;
            }
        }
   
        rbHabilitar.setSelected(cuenta.getEstatusCuenta().equals("T"));
        rbDeshabilitar.setSelected(cuenta.getEstatusCuenta().equals("F"));
        
        int TipModId = cuenta.getTipModId();
        for (int i = 1; i < cbMoneda.getItemCount(); i++) {
            int item = Integer.parseInt(cbMoneda.getItemAt(i).toString());
            if (item == TipModId) {
                cbMoneda.setSelectedIndex(i);
                break;
            }
        }
        
        int CodBanco = cuenta.getCodBanco();
        for (int i = 1; i < cbBanco.getItemCount(); i++) {
            int item = Integer.parseInt(cbBanco.getItemAt(i).toString());
            if (item == CodBanco) {
                cbBanco.setSelectedIndex(i);
                break;
            }
        }
        
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "QRY");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        clsCuentasBancos cuenta = new clsCuentasBancos();
        cuenta.setIdCuenta(Integer.parseInt(txtbuscado.getText()));
        cuenta.setSaldoCuenta(Double.parseDouble(txtSaldo.getText()));
        cuenta.setIdPersona(Integer.parseInt(cbIdPersona.getSelectedItem().toString()));
        cuenta.setIdTipoCuenta(Integer.parseInt(cbTipoCuenta.getSelectedItem().toString()));
  
       int contador = 0;
            String estatusCuenta = rbHabilitar.isSelected() ? "T" : (rbDeshabilitar.isSelected() ? "F" : "");
            if (!estatusCuenta.isEmpty()) {
                contador++;
                cuenta.setEstatusCuenta(estatusCuenta);
            }
            if (contador == 1) {
                // Los dos botones de cada ButtonGroup están seleccionados
                
                cuenta.setTipModId(Integer.parseInt(cbMoneda.getSelectedItem().toString()));
                cuenta.setCodBanco(Integer.parseInt(cbBanco.getSelectedItem().toString()));
                cuenta.setModificarCuenta(cuenta);   
        
                JOptionPane.showMessageDialog(null, "Registro Modificado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
                int resultadoBitacora=0;
                clsBitacora bitacoraRegistro = new clsBitacora();
                resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "INS");
                llenadoDeTablas();
                limpiarTextos();
            } else {
                // No se cumple la condición de selección de dos botones
                JOptionPane.showMessageDialog(null, "Debe seleccionar un estatus.");
            }


    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarTextos();
        habilitarBotones();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed
    public void limpiarTextos()
    {
        txtId.setText("");
        txtSaldo.setText("");
        txtbuscado.setText("");
        cbIdPersona.setSelectedIndex(0);
        cbTipoCuenta.setSelectedIndex(0);
        cbMoneda.setSelectedIndex(0);
        cbBanco.setSelectedIndex(0);
        tipoEstatus.clearSelection();
    }
    public void habilitarBotones()
    {
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }
    public void desHabilitarBotones()
    {
        btnRegistrar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }    
    public void esperar5min(){
        try {
            //Ponemos a "Dormir" el programa durante los minutos que querramos
            Thread.sleep(5*60*1000);
        } catch (Exception e) {
            System.out.println(e);}
    }   
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        llenadoDeTablas();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoActionPerformed

    private void cbIdPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIdPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbIdPersonaActionPerformed

    private void cbTipoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoCuentaActionPerformed

    private void rbHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbHabilitarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbHabilitarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbBanco;
    private javax.swing.JComboBox<String> cbIdPersona;
    private javax.swing.JComboBox<String> cbMoneda;
    private javax.swing.JComboBox<String> cbTipoCuenta;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label12;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JRadioButton rbDeshabilitar;
    private javax.swing.JRadioButton rbHabilitar;
    private javax.swing.JTable tablaCuentas;
    private javax.swing.ButtonGroup tipoEstatus;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtbuscado;
    // End of variables declaration//GEN-END:variables
}
