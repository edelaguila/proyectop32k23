/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
            //Hecho por: Karla Sofia Góomez Tobar 9959-21-1896
package Bancos.Vista;


import Bancos.Controlador.clsMovimientoDetallesBancos;
import Bancos.Controlador.clsConceptosBancos;
import Bancos.Controlador.clsCuentasBancos;
import Bancos.Controlador.clsTipoMovimientoBancos;
import Bancos.Controlador.clsBancoExterno;
import Bancos.Controlador.clsMovimientoDetallesBancos;
//import Cuentas_Corrientes.Controlador.clsCCorrientesProv;
import Seguridad.Controlador.clsBitacora;
import Bancos.Controlador.clsComprobanteProveedoresBancos;
import Bancos.Controlador.clsConceptosBancos;
import Bancos.Controlador.clsCuentasBancos;
import Bancos.Controlador.clsMovimientosEncabezadoBancos;
import Bancos.Controlador.clsReportes;
import Bancos.Controlador.clsTipoMovimientoBancos;
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
public class frmComprobanteproveedoresbancos extends javax.swing.JInternalFrame {
    
int codigoAplicacion=5011;

    public void llenadoDeCombos() {
        /*EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        List<Empleado> empleados = empleadoDAO.select();
        cbox_empleado.addItem("Seleccione una opción");
        for (int i = 0; i < empleados.size(); i++) {
            cbox_empleado.addItem(empleados.get(i).getNombreEmpleado());
        } */
    }
    public void llenadoDeComboBanco() {
        clsBancoExterno banco = new clsBancoExterno();
        List<clsBancoExterno> listadoBancosExternos = banco.getListadoBancosExternos();
        cbIdBanco.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbIdBanco.addItem("Seleccionar...");
        for (int i = 0; i < listadoBancosExternos.size(); i++) {
            clsBancoExterno Banco = listadoBancosExternos.get(i);
            String item = Banco.getCodigoBanco() + " - " + Banco.getNombreBanco();
            cbIdBanco.addItem(item);
        }
    }
    public void llenadoDeComboCuentas() {
        clsCuentasBancos cuentasB = new clsCuentasBancos();
        List<clsCuentasBancos> listaCuentasbancos = cuentasB.getListadoCuentas();
        cbIdCuenta.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbIdCuenta.addItem("Seleccionar...");
        for (int i = 0; i < listaCuentasbancos.size(); i++) {
            cbIdCuenta.addItem(String.valueOf(listaCuentasbancos.get(i).getIdCuenta()));
        }
    }
    public void llenadoDeComboTipoMovimiento() {
        clsTipoMovimientoBancos TipoMB = new clsTipoMovimientoBancos();
        List<clsTipoMovimientoBancos> listaTipoMovimientoBancos = TipoMB.getListadoTipoMovimiento();
        cbTipMov.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbTipMov.addItem("Seleccionar...");
        for (int i = 0; i < listaTipoMovimientoBancos.size(); i++) {
            clsTipoMovimientoBancos TipoMov = listaTipoMovimientoBancos.get(i);
            String item = TipoMov.getTipoMovimientoId() + " - " + TipoMov.getNombreMovimiento();
            cbTipMov.addItem(item);
        }
    }
    
    public void llenadoDeComboConcepto() {
    clsConceptosBancos Concep = new clsConceptosBancos();
    List<clsConceptosBancos> listaConceptoss = Concep.getListadoConceptos();
    cbIdConcepto.setAlignmentX(Component.CENTER_ALIGNMENT);
   cbIdConcepto.addItem("Seleccionar...");
    for (int i = 0; i < listaConceptoss.size(); i++) {
        clsConceptosBancos Concepto = listaConceptoss.get(i);
            String item = Concepto.getIdConcepto() + " - " + Concepto.getNombreConcepto();
        cbIdConcepto.addItem(item);
    }
}
    public void llenadoDeComboMovDetalle() {
    clsMovimientoDetallesBancos Detalle = new clsMovimientoDetallesBancos();
    List<clsMovimientoDetallesBancos> listaDetalles = Detalle.getListadoMovimiento();
    cbIdMovD.setAlignmentX(Component.CENTER_ALIGNMENT);
   cbIdMovD.addItem("Seleccionar...");
    for (int i = 0; i < listaDetalles.size(); i++) {
        clsMovimientoDetallesBancos Detalles = listaDetalles.get(i);
            String item = Detalles.getIdMovimientoDetalles() + " - " + Detalles.getMovimientoCosto();
        cbIdMovD.addItem(item);
    }
}
/*    public void llenadoDeComboproveedor() {
    clsCCorrientesProv Pr = new clsCCorrientesProv();
    List<clsCCorrientesProv> listaprov = Pr.getListadoCC();
    cbIdPr.setAlignmentX(Component.CENTER_ALIGNMENT);
   cbIdPr.addItem("Seleccionar...");
    for (int i = 0; i < listaprov.size(); i++) {
        clsCCorrientesProv Prov = listaprov.get(i);
            String item = Prov.getIdCCorrienteProv () + " - " + Prov.getNombreCCorrienteProv();
        cbIdPr.addItem(item);
    }
}
*/
        public void BusquedaComp() {
     clsComprobanteProveedoresBancos proveedor = new clsComprobanteProveedoresBancos();
    List<clsComprobanteProveedoresBancos> listaCompr = proveedor.getListadoComprobantesProveedores();
     cbID.removeAllItems();
    Set <Integer> idSet= new HashSet<>();
    cbID.addItem("Seleccionar...");
    cbID.setAlignmentX(Component.CENTER_ALIGNMENT);
    for (clsComprobanteProveedoresBancos pr : listaCompr){
        int Id = pr.getComId();
        if(!idSet.contains(Id)){
            cbID.addItem(String.valueOf(Id));
            idSet.add(Id);     
       }
    }
}
    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Fecha");
        modelo.addColumn("TopMov");
        modelo.addColumn("cueId");
        modelo.addColumn("concId");
        modelo.addColumn("codBanco");
        modelo.addColumn("movDetId");
        modelo.addColumn("idproveedor");

        clsComprobanteProveedoresBancos compPr = new clsComprobanteProveedoresBancos();
        //VendedorDAO vendedorDAO = new VendedorDAO();

        List<clsComprobanteProveedoresBancos> listadoComprobante = compPr.getListadoComprobantesProveedores();
        tablaComprobante.setModel(modelo);
        String[] dato = new String[8];
        for (int i = 0; i < listadoComprobante.size(); i++) {
            dato[0] = Integer.toString(listadoComprobante.get(i).getComId());
            dato[1] = listadoComprobante .get(i).getConFechaEmision();
            dato[2] = Integer.toString(listadoComprobante.get(i).getTipMovid());
            dato[3] = Integer.toString(listadoComprobante.get(i).getCueId());
            dato[4] = Integer.toString(listadoComprobante.get(i).getConcId());
            dato[5] = Integer.toString(listadoComprobante.get(i).getCodBanco());
            dato[6] = Integer.toString(listadoComprobante.get(i).getMovDetId());
            dato[7] = Integer.toString(listadoComprobante.get(i).getidproveedor ());
            modelo.addRow(dato);
        }       
    }

    public frmComprobanteproveedoresbancos() {
        initComponents();
        llenadoDeTablas();
        llenadoDeCombos();
        llenadoDeComboBanco();
        llenadoDeComboCuentas();
        llenadoDeComboTipoMovimiento();
        llenadoDeComboConcepto();
        llenadoDeComboMovDetalle();
        //llenadoDeComboproveedor();
        BusquedaComp();
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
        estatus = new javax.swing.ButtonGroup();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        label4 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label14 = new javax.swing.JLabel();
        label18 = new javax.swing.JLabel();
        label15 = new javax.swing.JLabel();
        cbTipMov = new javax.swing.JComboBox<>();
        label16 = new javax.swing.JLabel();
        cbIdCuenta = new javax.swing.JComboBox<>();
        label19 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        label20 = new javax.swing.JLabel();
        label21 = new javax.swing.JLabel();
        cbIdPr = new javax.swing.JComboBox<>();
        cbIdMovD = new javax.swing.JComboBox<>();
        label22 = new javax.swing.JLabel();
        cbIdConcepto = new javax.swing.JComboBox<>();
        cbIdBanco = new javax.swing.JComboBox<>();
        label27 = new javax.swing.JLabel();
        cbID = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaComprobante = new javax.swing.JTable();
        btnReportes = new javax.swing.JButton();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Comprobante de pago a proveedores");
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

        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("Id disponibles:");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label14.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label14.setText("COMPROBANTE DE PAGO");

        label18.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label18.setText("Fecha:");

        label15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label15.setText("Tipo Movimiento");

        label16.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label16.setText("Con la cuenta No.");

        label19.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label19.setText("pagado a:");

        txtFecha.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtFecha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtFecha.setOpaque(false);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        label20.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label20.setText("Fue pagado po el banco:");

        label21.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label21.setText("Por el costo de:");

        label22.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label22.setText("Por concepto de:");

        cbIdBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIdBancoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(label15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbTipMov, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(label19)
                            .addGap(6, 6, 6)
                            .addComponent(cbIdPr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbIdMovD, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(label20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbIdBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(label22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbIdConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label14)
                    .addComponent(txtFecha)
                    .addComponent(label18))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label15)
                    .addComponent(cbTipMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbIdPr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label19)
                    .addComponent(label21)
                    .addComponent(cbIdMovD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label22)
                    .addComponent(cbIdConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label20)
                    .addComponent(cbIdBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label16)
                    .addComponent(cbIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        label27.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label27.setText("Para : Modificar/Buscar/Eliminar ");

        cbID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIDActionPerformed(evt);
            }
        });

        tablaComprobante.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaComprobante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Comprobante", "Fecha", "ID Tipo movimiento", "ID cuenta", "ID concepto", "ID Banco", "ID movimiento detalle", "ID proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaComprobante);

        btnReportes.setText("Reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(label4)
                                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(cbID, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(label27)))
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnLimpiar)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4)
                            .addComponent(btnBuscar))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar)
                            .addComponent(btnEliminar)
                            .addComponent(btnActualizar))
                        .addGap(14, 14, 14)
                        .addComponent(btnReportes))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int registrosBorrados=0;
        clsComprobanteProveedoresBancos comprobante = new clsComprobanteProveedoresBancos();
        comprobante.setComId(Integer.parseInt(cbID.getSelectedItem().toString()));
        registrosBorrados=comprobante.setBorrarComprobanteProveedores(comprobante);
        JOptionPane.showMessageDialog(null, "Registro Borrado\n",
            "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        llenadoDeTablas();

        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "DEL");
        limpiarTextos();
        BusquedaComp();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String fecha = txtFecha.getText();
        String tipmovimiento = cbTipMov.getSelectedItem().toString();
        String cuenta= cbIdCuenta.getSelectedItem().toString();
        String concepto = cbIdConcepto.getSelectedItem().toString();
        String banco = cbIdBanco.getSelectedItem().toString();
        String movD = cbIdMovD.getSelectedItem().toString();
        String proveedor = cbIdPr.getSelectedItem().toString();
 
         
 if (tipmovimiento.equals("Seleccionar...")|| cuenta.equals("Seleccionar...")||concepto.equals("Seleccionar...")||banco.equals("Seleccionar...")||movD.equals("Seleccionar...")||proveedor.equals("Seleccionar...")) {
   JOptionPane.showMessageDialog(null, "Error! Debe seleccionar todos los Id", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
}else{
           clsComprobanteProveedoresBancos Comprobante = new clsComprobanteProveedoresBancos();
        Comprobante.setConFechaEmision(txtFecha.getText());
        Comprobante.setTipMovid(Integer.parseInt(cbTipMov.getSelectedItem().toString()));
        Comprobante.setCueId(Integer.parseInt(cbIdCuenta.getSelectedItem().toString()));
        Comprobante.setConcId(Integer.parseInt(cbIdConcepto.getSelectedItem().toString()));
        Comprobante.setCodBanco(Integer.parseInt(cbIdBanco.getSelectedItem().toString()));
        Comprobante.setMovDetId(Integer.parseInt(cbIdMovD.getSelectedItem().toString()));
        Comprobante.setidproveedor(Integer.parseInt(cbIdPr.getSelectedItem().toString()));

    
    Comprobante.setIngresarComprobanteProveedores(Comprobante);
        JOptionPane.showMessageDialog(null, "Registro Ingresado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "INS");
        llenadoDeTablas();
        BusquedaComp();
        limpiarTextos();
  
 }  
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
            // TODO add your handling code here:
        clsComprobanteProveedoresBancos comp = new clsComprobanteProveedoresBancos();
        //usuario.setNombreUsuario(txtbuscado.getText());
        comp.setComId(Integer.parseInt(cbID.getSelectedItem().toString()));
        comp = comp.getBuscarInformacionComprobanteProveedoresPorId(comp);
        System.out.println("movDetalle retornado:" + comp);
        txtFecha.setText(comp.getConFechaEmision());

        int TipMovID = comp.getTipMovid();
        for (int i = 1; i < cbTipMov.getItemCount(); i++) {
            int item = Integer.parseInt(cbTipMov.getItemAt(i).toString());
            if (item == TipMovID) {
                cbTipMov.setSelectedIndex(i);
                break;
            }
        }

        int IdCuenta = comp.getCueId();
        for (int i = 1; i < cbIdCuenta.getItemCount(); i++) {
            int item = Integer.parseInt(cbIdCuenta.getItemAt(i).toString());
            if (item == IdCuenta) {
                cbIdCuenta.setSelectedIndex(i);
                break;
            }
        }
         
        
        int CuentaEmID = comp.getConcId();
        for (int i = 1; i < cbIdConcepto.getItemCount(); i++) {
            int item = Integer.parseInt(cbIdConcepto.getItemAt(i).toString());
            if (item == CuentaEmID) {
                cbIdConcepto.setSelectedIndex(i);
                break;
            }
        }
        
        int cogidoBanc = comp.getCodBanco();
        for (int i = 1; i < cbIdBanco.getItemCount(); i++) {
            int item = Integer.parseInt(cbIdBanco.getItemAt(i).toString());
            if (item == cogidoBanc) {
                cbIdBanco.setSelectedIndex(i);
                break;
            }
        }
        
                int MovDe = comp.getMovDetId();
        for (int i = 1; i < cbIdMovD.getItemCount(); i++) {
            int item = Integer.parseInt(cbIdMovD.getItemAt(i).toString());
            if (item == MovDe) {
                cbIdMovD.setSelectedIndex(i);
                break;
            }
        }
        
                int prov = comp.getidproveedor();
        for (int i = 1; i < cbIdPr.getItemCount(); i++) {
            int item = Integer.parseInt(cbIdPr.getItemAt(i).toString());
            if (item == prov) {
                cbIdPr.setSelectedIndex(i);
                break;
            }
        }
        
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "QRY");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        // TODO add your handling code here:
    clsComprobanteProveedoresBancos Comprobante = new clsComprobanteProveedoresBancos();
        Comprobante.setConFechaEmision(txtFecha.getText());
        Comprobante.setTipMovid(Integer.parseInt(cbTipMov.getSelectedItem().toString()));
        Comprobante.setCueId(Integer.parseInt(cbIdCuenta.getSelectedItem().toString()));
        Comprobante.setConcId(Integer.parseInt(cbIdConcepto.getSelectedItem().toString()));
        Comprobante.setCodBanco(Integer.parseInt(cbIdBanco.getSelectedItem().toString()));
        Comprobante.setMovDetId(Integer.parseInt(cbIdMovD.getSelectedItem().toString()));
        Comprobante.setidproveedor(Integer.parseInt(cbIdPr.getSelectedItem().toString()));
        Comprobante.setModificarComprobanteProveedores(Comprobante);
     
    
        
        
        JOptionPane.showMessageDialog(null, "Registro Modificado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);  
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "UPD");
        llenadoDeTablas();
        limpiarTextos();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarTextos();
        habilitarBotones();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed
    public void limpiarTextos()
    {
        txtFecha.setText("");
        cbIdPr.setSelectedIndex(0);
        cbIdCuenta.setSelectedIndex(0);
        cbTipMov.setSelectedIndex(0);
        cbIdMovD.setSelectedIndex(0);
        cbIdConcepto.setSelectedIndex(0);
        cbIdBanco.setSelectedIndex(0);

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

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void cbIdBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIdBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbIdBancoActionPerformed

    private void cbIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbIDActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        // TODO add your handling code here:
        clsReportes reporte = new clsReportes();
        String customReportPath = "/src/main/java/bancos/reportes/rptComprovantePr.jrxml";
        reporte.setReportPath(customReportPath);
        reporte.generateReport();
    }//GEN-LAST:event_btnReportesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReportes;
    private javax.swing.JComboBox<String> cbID;
    private javax.swing.JComboBox<String> cbIdBanco;
    private javax.swing.JComboBox<String> cbIdConcepto;
    private javax.swing.JComboBox<String> cbIdCuenta;
    private javax.swing.JComboBox<String> cbIdMovD;
    private javax.swing.JComboBox<String> cbIdPr;
    private javax.swing.JComboBox<String> cbTipMov;
    private javax.swing.ButtonGroup estatus;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label14;
    private javax.swing.JLabel label15;
    private javax.swing.JLabel label16;
    private javax.swing.JLabel label18;
    private javax.swing.JLabel label19;
    private javax.swing.JLabel label20;
    private javax.swing.JLabel label21;
    private javax.swing.JLabel label22;
    private javax.swing.JLabel label27;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaComprobante;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
