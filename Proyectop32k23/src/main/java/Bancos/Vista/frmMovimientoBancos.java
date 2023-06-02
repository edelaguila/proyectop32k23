/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Vista;

import Bancos.Controlador.clsBancoExterno;
import Bancos.Controlador.clsMovimientoDetallesBancos;
import Bancos.Controlador.clsTipoMoneda;
import Bancos.Controlador.clsConceptosBancos;
import Bancos.Controlador.clsCuentaEmpresa;
import Bancos.Controlador.clsCuentasBancos;
import Bancos.Controlador.clsMovimientosEncabezadoBancos;
import Bancos.Controlador.clsReportes;
import Bancos.Controlador.clsTipoMovimientoBancos;
import Seguridad.Controlador.clsBitacora;
import Seguridad.Controlador.clsUsuarioConectado;
import java.awt.Component;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author visitante
 */
//NELSON JOSUÉ PINEDA CULAJAY 9959-21-10015
//KARLA SOFÍA GOMEZ TOBAR -
//TODO LO RELACIONADO EN COMBOBOXS.
public class frmMovimientoBancos extends javax.swing.JInternalFrame {
int codigoAplicacion= 5009;

    public void llenadoDeCombos() {
        /*EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        List<Empleado> empleados = empleadoDAO.select();
        cbox_empleado.addItem("Seleccione una opción");
        for (int i = 0; i < empleados.size(); i++) {
            cbox_empleado.addItem(empleados.get(i).getNombreEmpleado());
        } */
    }
public void llenadoDeComboDetallesTipoMoneda() {
    clsTipoMoneda TM = new clsTipoMoneda();
    List<clsTipoMoneda> listaTipoMonedas = TM.getListadoMonedas();
    cbMovimientoMoneda.setAlignmentX(Component.CENTER_ALIGNMENT);
    cbMovimientoMoneda.addItem("Seleccionar...");
    for (int i = 0; i < listaTipoMonedas.size(); i++) {
        clsTipoMoneda tipoMoneda = listaTipoMonedas.get(i);
            String item = tipoMoneda.getTipModId() + " - " + tipoMoneda.getTipMondAbreviacion();
        cbMovimientoMoneda.addItem(item);
    }
}

public void llenadoDeComboDetallesConcepto() {
    clsConceptosBancos Concep = new clsConceptosBancos();
    List<clsConceptosBancos> listaConceptoss = Concep.getListadoConceptos();
    cbConcepto.setAlignmentX(Component.CENTER_ALIGNMENT);
   cbConcepto.addItem("Seleccionar...");
    for (int i = 0; i < listaConceptoss.size(); i++) {
        clsConceptosBancos Concepto = listaConceptoss.get(i);
            String item = Concepto.getIdConcepto() + " - " + Concepto.getNombreConcepto();
        cbConcepto.addItem(item);
    }
}



public void llenadoDeComboA() {
        clsBancoExterno banco = new clsBancoExterno();
        List<clsBancoExterno> listadoBancosExternos = banco.getListadoBancosExternos();
        cbCodigo.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbCodigo.addItem("Seleccionar...");
        for (int i = 0; i < listadoBancosExternos.size(); i++) {
            clsBancoExterno Banco = listadoBancosExternos.get(i);
            String item = Banco.getCodigoBanco() + " - " + Banco.getNombreBanco();
            cbCodigo.addItem(item);
        }
    }
    public void llenadoDeComboB() {
        clsCuentasBancos cuentasB = new clsCuentasBancos();
        List<clsCuentasBancos> listaCuentasbancos = cuentasB.getListadoCuentas();
        cbIdCuenta.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbIdCuenta.addItem("Seleccionar...");
        for (int i = 0; i < listaCuentasbancos.size(); i++) {
            cbIdCuenta.addItem(String.valueOf(listaCuentasbancos.get(i).getIdCuenta()));
        }
    }
    public void llenadoDeComboC() {
        clsTipoMovimientoBancos TipoMB = new clsTipoMovimientoBancos();
        List<clsTipoMovimientoBancos> listaclsTipoMovimientoBancos = TipoMB.getListadoTipoMovimiento();
        cbTipMov.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbTipMov.addItem("Seleccionar...");
        for (int i = 0; i < listaclsTipoMovimientoBancos.size(); i++) {
            clsTipoMovimientoBancos TipoMov = listaclsTipoMovimientoBancos.get(i);
            String item = TipoMov.getTipoMovimientoId() + " - " + TipoMov.getNombreMovimiento();
            cbTipMov.addItem(item);
        }
    }
    public void llenadoDeComboD() {
        clsCuentaEmpresa TipoMB = new clsCuentaEmpresa();
        List<clsCuentaEmpresa> listaclsCuentaEmpresa = TipoMB.getListadoCuentaEmpresas();
        cbIdCuenEm.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbIdCuenEm.addItem("Seleccionar...");
        for (int i = 0; i < listaclsCuentaEmpresa.size(); i++) {
            cbIdCuenEm.addItem(String.valueOf(listaclsCuentaEmpresa.get(i).getIdCuentaEm()));
        }
    }

public void llenarOpcion(){
 
    tbTipoCargoAbono.addItem("Seleccionar...");
    tbTipoCargoAbono.addItem("Ambos");
    tbTipoCargoAbono.addItem("Cargo");
    tbTipoCargoAbono.addItem("Abono");
    String Seleccionar;
           Seleccionar = tbTipoCargoAbono.getSelectedItem().toString();
    if (Seleccionar.equals("Seleccionar...")) {
    txtAbono.setEnabled(false);
    txtCargo.setEnabled(false);
}
}


//NELSON JOSUÉ PINEDA CULAJAY 9959-21-10015
public void llenarClasificacionDetalles(){
     clsMovimientosEncabezadoBancos movEncabezado = new clsMovimientosEncabezadoBancos();
    List<clsMovimientosEncabezadoBancos> listaMovEncabezado = movEncabezado.getListadoMovEncabezado();
     cbClasificacion.removeAllItems();
    Set <Integer> idSet= new HashSet<>();
    cbClasificacion.addItem("Mostrar Todo");
    cbClasificacion.setAlignmentX(Component.CENTER_ALIGNMENT);
    for (clsMovimientosEncabezadoBancos movimientos : listaMovEncabezado){
        int Id = movimientos.getMovId();
        if(!idSet.contains(Id)){
            cbClasificacion.addItem(String.valueOf(Id));
            idSet.add(Id);     
} 

}
    
}
  

//NELSON JOSUÉ PINEDA CULAJAY 9959-21-10015
public void BusquedaDetallesEncabezado() {
    clsMovimientoDetallesBancos movEncabezado = new clsMovimientoDetallesBancos();
    List<clsMovimientoDetallesBancos> listaMovDetalles = movEncabezado.getListadoMovimiento();
     cbBusquedaID.removeAllItems();
    Set <Integer> idSet= new HashSet<>();
    cbBusquedaID.addItem("Seleccionar...");
    cbBusquedaID.setAlignmentX(Component.CENTER_ALIGNMENT);
    for (clsMovimientoDetallesBancos movimientos : listaMovDetalles){
        int Id = movimientos.getIdMovimientoDetalles();
        if(!idSet.contains(Id)){
            cbBusquedaID.addItem(String.valueOf(Id));
            idSet.add(Id);     
       }
    }
}     
            
//NELSON JOSUÉ PINEDA CULAJAY 9959-21-10015
    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Movimiento Detalles");
        modelo.addColumn("Id Movimiento Encabezado");
        modelo.addColumn("Abono");
        modelo.addColumn("Concepto");
        modelo.addColumn("Cargo");
        modelo.addColumn("Id Movimiento Moneda");
        clsMovimientoDetallesBancos tipou = new clsMovimientoDetallesBancos();
        //VendedorDAO vendedorDAO = new VendedorDAO();
        List<clsMovimientoDetallesBancos> listaTipoBancos = tipou.getListadoMovimiento();
        tablaUsuarios.setModel(modelo);
         float TotalAbonos =0;
   float TotalCargos =0;
   float TotalDiferencias=0;
        String[] dato = new String[6];
        for (int i = 0; i < listaTipoBancos .size(); i++) {
   dato[0] = Integer.toString(listaTipoBancos.get(i).getIdMovimientoDetalles());
        dato[1] = Integer.toString(listaTipoBancos.get(i).getIdMovimiento());
        dato[2] = Float.toString(listaTipoBancos.get(i).getMovimientoCosto());
        dato[3] = Integer.toString(listaTipoBancos.get(i).getIdConcepto());
        dato[4] = Float.toString(listaTipoBancos.get(i).getMovimientoSaldo());
        dato[5] = Integer.toString(listaTipoBancos.get(i).getIdTipoMovimiento());
            modelo.addRow(dato);
             TotalAbonos +=listaTipoBancos.get(i).getMovimientoCosto();
        TotalCargos += listaTipoBancos.get(i).getMovimientoSaldo();
   }
    
    
    TotalCargo.setText(Float.toString(TotalCargos));
   TotalAbono.setText(Float.toString(TotalAbonos));
   TotalDiferencia.setText(Float.toString(TotalCargos-TotalAbonos));
      }
         
   
//KARLA SOFÍA GOMEZ TOBAR -
    
        public void llenadoDeTablas2() {
       DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("codigo Bancario");
        modelo.addColumn("ID cuenta");
        modelo.addColumn("Tipo Movimiento");
        modelo.addColumn("Fecha");
        modelo.addColumn("ID cuenta empresa");

        clsMovimientosEncabezadoBancos encabezado = new clsMovimientosEncabezadoBancos();
        //VendedorDAO vendedorDAO = new VendedorDAO();

        List<clsMovimientosEncabezadoBancos> listadoMovEncabezado = encabezado.getListadoMovEncabezado();
        String[] dato = new String[6];
        for (int i = 0; i < listadoMovEncabezado.size(); i++) {
            dato[0] = Integer.toString(listadoMovEncabezado.get(i).getMovId());
            dato[1] = Integer.toString(listadoMovEncabezado.get(i).getCodBanco());
            dato[2] = Integer.toString(listadoMovEncabezado.get(i).getCueId());
            dato[3] = Integer.toString(listadoMovEncabezado.get(i).getTipMovId());
            dato[4] = listadoMovEncabezado .get(i).getMovFecha();
            dato[5] = Integer.toString(listadoMovEncabezado.get(i).getCueEmId());
            modelo.addRow(dato);
        }  
              
    }


    public frmMovimientoBancos() {
        initComponents();
        llenadoDeTablas();
        llenadoDeCombos();
        llenadoDeComboDetallesTipoMoneda();
        llenadoDeComboDetallesConcepto();
        
        llenadoDeComboA();
        llenadoDeComboB();
        llenadoDeComboC();
        llenadoDeComboD();
        llenarOpcion();
        llenadoDeTablas2();
        llenarClasificacionDetalles();
        BusquedaDetallesEncabezado();

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
        btnRegistrar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label14 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        label18 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        label17 = new javax.swing.JLabel();
        cbIdCuenEm = new javax.swing.JComboBox<>();
        label15 = new javax.swing.JLabel();
        cbTipMov = new javax.swing.JComboBox<>();
        label16 = new javax.swing.JLabel();
        cbIdCuenta = new javax.swing.JComboBox<>();
        label13 = new javax.swing.JLabel();
        cbCodigo = new javax.swing.JComboBox<>();
        label12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        label6 = new javax.swing.JLabel();
        txtIdMovDetalles = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        txtAbono = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        label8 = new javax.swing.JLabel();
        cbConcepto = new javax.swing.JComboBox<>();
        label9 = new javax.swing.JLabel();
        cbMovimientoMoneda = new javax.swing.JComboBox<>();
        label19 = new javax.swing.JLabel();
        tbTipoCargoAbono = new javax.swing.JComboBox<>();
        label20 = new javax.swing.JLabel();
        label21 = new javax.swing.JLabel();
        TotalAbono = new javax.swing.JLabel();
        label11 = new javax.swing.JLabel();
        label24 = new javax.swing.JLabel();
        TotalCargo = new javax.swing.JLabel();
        TotalDiferencia = new javax.swing.JLabel();
        btnReportes = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        label26 = new javax.swing.JLabel();
        cbBusquedaID = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        label25 = new javax.swing.JLabel();
        btnClasificacion = new javax.swing.JButton();
        cbClasificacion = new javax.swing.JComboBox<>();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Movimiento Bancarios");
        setVisible(true);

        btnRegistrar.setText("Aceptar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Detalle de Movimientos");

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tablaUsuarios.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaUsuarios);

        jButton3.setText("Ayuda");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label14.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label14.setText("ID");

        txtid.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtid.setOpaque(false);
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        label18.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label18.setText("Fecha");

        txtFecha.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtFecha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtFecha.setOpaque(false);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        label17.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label17.setText("ID cuenta de la empresa");

        label15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label15.setText("Tipo Movimiento");

        label16.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label16.setText("ID Cuenta");

        cbIdCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIdCuentaActionPerformed(evt);
            }
        });

        label13.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label13.setText("Codigo Bancario");

        cbCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label17)
                        .addGap(18, 18, 18)
                        .addComponent(cbIdCuenEm, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipMov, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label14)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label18)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label17)
                    .addComponent(cbIdCuenEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label16)
                    .addComponent(cbIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label15)
                    .addComponent(cbTipMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label13)
                    .addComponent(cbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        label12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label12.setText("Encabezado:");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Id Movimiento Detalles");

        txtIdMovDetalles.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtIdMovDetalles.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtIdMovDetalles.setOpaque(false);

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Abono");

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("Cargo");

        txtAbono.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtAbono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtAbono.setOpaque(false);

        txtCargo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtCargo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtCargo.setOpaque(false);

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("Id Concepto");

        label9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label9.setText("Id TIpo Movimento Moneda");

        label19.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label19.setText("Tipo de Cuenta");

        tbTipoCargoAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbTipoCargoAbonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdMovDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(label9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMovimientoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(label19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbTipoCargoAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(label7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(label5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 30, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(txtIdMovDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbMovimientoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label9))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label8)
                            .addComponent(cbConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5)
                            .addComponent(txtAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label7)
                            .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbTipoCargoAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label19))
                        .addGap(22, 22, 22))))
        );

        label20.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label20.setText("DIFERENCIA:");

        label21.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label21.setText("TOTAL DE CARGOS:");

        TotalAbono.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        TotalAbono.setText("0");

        label11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label11.setText("Detalles:");

        label24.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label24.setText("TOTAL DE ABONOS:");

        TotalCargo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        TotalCargo.setText("0");

        TotalDiferencia.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        TotalDiferencia.setText("0");

        btnReportes.setText("Reporte");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label26.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label26.setText("Buscar el Id Detalle que deseeas accionar:");

        cbBusquedaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBusquedaIDActionPerformed(evt);
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

        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(label26, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbBusquedaID, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(label26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbBusquedaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar1)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label25.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label25.setText("Clasifiación de ID Encabezado");

        btnClasificacion.setText("Aceptar");
        btnClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClasificacionActionPerformed(evt);
            }
        });

        cbClasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClasificacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label25))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label25)
                .addGap(8, 8, 8)
                .addComponent(cbClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClasificacion)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TotalAbono)
                                .addGap(123, 123, 123)
                                .addComponent(label21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TotalCargo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TotalDiferencia)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label12)
                            .addComponent(label11)
                            .addComponent(label1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnReportes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(label12)
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(jButton3)
                    .addComponent(btnReportes)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(label1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label21)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TotalDiferencia)
                        .addComponent(label20))
                    .addComponent(TotalCargo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label24)
                        .addComponent(TotalAbono)))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
// Funcion de condición para Encabezado
//NELSON JOSUÉ PINEDA CULAJAY 9959-21-10015
//KARLA SOFÍA GOMEZ TOBAR -
      String fecha = txtFecha.getText();
         String codigo = cbCodigo.getSelectedItem().toString();
         String cuenta= cbIdCuenta.getSelectedItem().toString();
         String tipmovimiento = cbTipMov.getSelectedItem().toString();
         String cuentaempresa = cbIdCuenEm.getSelectedItem().toString();
 
         // Funcion de condición para Detalles 
         String Concepto = cbConcepto.getSelectedItem().toString();
         String TipoMoneda= cbMovimientoMoneda.getSelectedItem().toString();
         String CargoAbono = tbTipoCargoAbono.getSelectedItem().toString();
         String Abono = txtAbono.getText();
         String Cargo = txtCargo.getText();
              
 if (codigo.equals("Seleccionar...")|| cuenta.equals("Seleccionar...")||tipmovimiento.equals("Seleccionar...")||cuentaempresa.equals("Seleccionar...")||
        Concepto.equals("Seleccionar...")||TipoMoneda.equals("Seleccionar...")||CargoAbono.equals("Seleccionar...")) {
   JOptionPane.showMessageDialog(null, "Error! Debe seleccionar todas las opciones", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
}else{
     
  //Registro de Encazeado y Detalles
  //Cuadro de Encabezado
           clsMovimientosEncabezadoBancos encabezado = new clsMovimientosEncabezadoBancos();
    encabezado.setMovId(Integer.parseInt(txtid.getText()));
        encabezado.setMovFecha(txtFecha.getText());
        
        String selectedItem = cbCodigo.getSelectedItem().toString();
        int item = Integer.parseInt(selectedItem.split(" - ")[0]);
        encabezado.setCodBanco(item);
  
        String selectedItem2 = cbIdCuenta.getSelectedItem().toString();
        int item2 = Integer.parseInt(selectedItem2.split(" - ")[0]);
        encabezado.setCueId(item2);
        
       String selectedItem3= cbTipMov.getSelectedItem().toString();
        int item3 = Integer.parseInt(selectedItem3.split(" - ")[0]);
        encabezado.setTipMovId(item3);
        
        String selectedItem4= cbIdCuenEm.getSelectedItem().toString();
        int item4 = Integer.parseInt(selectedItem4.split(" - ")[0]);
        encabezado.setCueEmId(item4);
    encabezado.setingresaMovimientosEncabezado(encabezado);
    
    //Cuadro de Detalles

           clsMovimientoDetallesBancos banco = new clsMovimientoDetallesBancos();
    banco.setIdMovimientoDetalles(Integer.parseInt(txtIdMovDetalles.getText()));
  
     int UltimoRegistro = 0;
      int item5 = Integer.parseInt(txtid.getText());
        if (item5 != UltimoRegistro){
    UltimoRegistro = item5;
}  
        banco.setIdMovimiento(item5);  
        
     String selectedItem6 = cbConcepto.getSelectedItem().toString();
        int item6 = Integer.parseInt(selectedItem6.split(" - ")[0]);
        banco.setIdConcepto(item6);   

     String selectedItem7 = cbMovimientoMoneda.getSelectedItem().toString();
        int item7 = Integer.parseInt(selectedItem7.split(" - ")[0]);
        banco.setIdTipoMovimiento(item7);  
        
     int SeleccionarIndex = tbTipoCargoAbono.getSelectedIndex();
    String vacio = ""; 
    String cero = "0";
    double totales = 0;
      if (SeleccionarIndex == 0){
    txtAbono.setText("");
          txtCargo.setText("");
               banco.setMovimientoCosto(Float.parseFloat(vacio));
               banco.setMovimientoSaldo(Float.parseFloat(vacio)); 
           
       }
      else if (SeleccionarIndex == 1){
            banco.setMovimientoCosto(Float.parseFloat(txtAbono.getText()));
            banco.setMovimientoSaldo(Float.parseFloat(txtCargo.getText()));
            totales =(Float.parseFloat(txtCargo.getText()))-(Float.parseFloat(txtAbono.getText()));
         
      }
    else if (SeleccionarIndex == 2){
        
            banco.setMovimientoCosto(Float.parseFloat(cero));
            banco.setMovimientoSaldo(Float.parseFloat(txtCargo.getText()));
            totales = (Float.parseFloat(txtCargo.getText()));
       
      }
    else if (SeleccionarIndex == 3){
            banco.setMovimientoSaldo(Float.parseFloat(cero));
            banco.setMovimientoCosto(Float.parseFloat(txtAbono.getText()));
            totales = -Float.parseFloat(txtAbono.getText());
         
      }
      
banco.setIngresarMovimiento(banco); 

String selectedItem10 = cbIdCuenEm.getSelectedItem().toString();
int item10 = Integer.parseInt(selectedItem10.split(" - ")[0]);
banco.setIdMovimientoDetalles(item10);
banco = banco.getBuscarInformacionBancoPorTipoMovimientoSaldo(banco, encabezado);
double saldoActual = banco.getAbonoCargo()+totales;

double resultado = saldoActual;

banco.setAbonoCargo(resultado);

banco.setModificarMovimientoSaldo(banco, encabezado);
    

        JOptionPane.showMessageDialog(null, "Registro Ingresado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "INS");
        llenarClasificacionDetalles();
        BusquedaDetallesEncabezado ();
        llenadoDeTablas();
LimpiarSoloTipoCuenta();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
 //NELSON JOSUÉ PINEDA CULAJAY 9959-21-10015
//KARLA SOFÍA GOMEZ TOBAR -
    //Buqueda de Detalles.
 
   txtAbono.setEnabled(true);
    txtCargo.setEnabled(true);
      PonerPosicion1();
   clsMovimientoDetallesBancos banco = new clsMovimientoDetallesBancos();
        banco.setIdMovimientoDetalles(Integer.parseInt(cbBusquedaID.getSelectedItem().toString())); 
        banco = banco.getBuscarInformacionBancoPorTipoMovimiento(banco);
        System.out.println("Usuario retornado:" + banco); 
       txtIdMovDetalles.setText(Integer.toString(banco.getIdMovimientoDetalles()));
       txtAbono.setText(Float.toString(banco.getMovimientoCosto()));
       txtCargo.setText(Float.toString(banco.getMovimientoSaldo()));
       
       
        int IdConcepto = banco.getIdConcepto();
         for (int i = 1; i <cbConcepto.getItemCount(); i++){
            String item1 = cbConcepto.getItemAt(i).toString();
          int itemcodigo1 = Integer.parseInt(item1.split(" - ")[0]);            
            if (itemcodigo1 == IdConcepto) {
               cbConcepto.setSelectedIndex(i);
                break;
            }
     
         }
     
     
      int TipMoneda = banco.getIdTipoMovimiento();
         for (int i = 1; i <cbMovimientoMoneda.getItemCount(); i++){
            String item2 = cbMovimientoMoneda.getItemAt(i).toString();
          int itemcodigo2 = Integer.parseInt(item2.split(" - ")[0]);            
            if (itemcodigo2 == TipMoneda) {
               cbMovimientoMoneda.setSelectedIndex(i);
                break;
            }
     
         }
           
 
        
    //Busqueda de Encabezado 

  clsMovimientosEncabezadoBancos encabezado = new clsMovimientosEncabezadoBancos();    
int movID = 0; // Variable para almacenar el valor de movID

if (banco != null) {
    movID = banco.getIdMovimiento();
}

encabezado.setMovId(movID); 
encabezado = encabezado.getBuscarMovimientosEncabezadoPorId(encabezado);

System.out.println("movDetalle retornado: " + encabezado);
txtFecha.setText(encabezado.getMovFecha());

                
        int cogidoBanco = encabezado.getCodBanco();
        for (int i = 1; i < cbCodigo.getItemCount(); i++) {
            String item4 = cbCodigo.getItemAt(i).toString();
          int itemcodigo4 = Integer.parseInt(item4.split(" - ")[0]);            
            if (itemcodigo4 == cogidoBanco) {
                cbCodigo.setSelectedIndex(i);
                break;
            }
        }
        
        
        int IdCuenta = encabezado.getCueId();
        for (int i = 1; i < cbIdCuenta.getItemCount(); i++) {
            String item5 = cbIdCuenta.getItemAt(i).toString();
          int itemcodigo5 = Integer.parseInt(item5.split(" - ")[0]);            
            if (itemcodigo5 == IdCuenta) {
                cbIdCuenta.setSelectedIndex(i);
                break;
            }
        }
        
       int TipMovID = encabezado.getTipMovId();
for (int i = 1; i < cbTipMov.getItemCount(); i++) {
    String item6 = cbTipMov.getItemAt(i).toString();
    int itemcodigo6 = Integer.parseInt(item6.split(" - ")[0]);
    if (itemcodigo6 == TipMovID) {
        cbTipMov.setSelectedIndex(i);
        break;
    }
}

        
          int CuentaEmID= encabezado.getCueEmId();
        for (int i = 1; i < cbIdCuenEm.getItemCount(); i++) {
            String item7 = cbIdCuenEm.getItemAt(i).toString();
          int itemcodigo7 = Integer.parseInt(item7.split(" - ")[0]);            
            if (itemcodigo7 == CuentaEmID) {
               cbIdCuenEm.setSelectedIndex(i);
                break;
            }
        }
        
        
     int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "QRY");     
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//NELSON JOSUÉ PINEDA CULAJAY 9959-21-10015
//KARLA SOFÍA GOMEZ TOBAR -
 // TODO add your handling code here:
       
  clsMovimientosEncabezadoBancos encabezado = new clsMovimientosEncabezadoBancos();
        clsMovimientoDetallesBancos banco = new clsMovimientoDetallesBancos();
        banco.setIdMovimientoDetalles(Integer.parseInt(cbBusquedaID.getSelectedItem().toString()));    
        String selectItem = cbConcepto.getSelectedItem().toString();
                
        String concep = selectItem.split(" - ")[0]; // Obtiene solo la ID
         banco.setIdConcepto(Integer.parseInt(concep));
        
          String selectItem2 = cbMovimientoMoneda.getSelectedItem().toString();
        String Tip = selectItem2.split(" - ")[0]; // Obtiene solo la ID
         banco.setIdTipoMovimiento(Integer.parseInt(Tip));
        
int SeleccionarIndex = tbTipoCargoAbono.getSelectedIndex();
    String vacio = ""; 
    String cero = "0";
    double totales = 0;
      if (SeleccionarIndex == 0){
     
               banco.setMovimientoCosto(Float.parseFloat(vacio));
               banco.setMovimientoSaldo(Float.parseFloat(vacio)); 
       }
      else if (SeleccionarIndex == 1){
            banco.setMovimientoCosto(Float.parseFloat(txtAbono.getText()));
            banco.setMovimientoSaldo(Float.parseFloat(txtCargo.getText()));
            totales =(Float.parseFloat(txtCargo.getText()))-(Float.parseFloat(txtAbono.getText()));
      }
    else if (SeleccionarIndex == 2){
            banco.setMovimientoCosto(Float.parseFloat(cero));
            banco.setMovimientoSaldo(Float.parseFloat(txtCargo.getText()));
            totales = (Float.parseFloat(txtCargo.getText()));
      }
    else if (SeleccionarIndex == 3){
  
            banco.setMovimientoSaldo(Float.parseFloat(cero));
            banco.setMovimientoCosto(Float.parseFloat(txtAbono.getText()));
            totales = -Float.parseFloat(txtAbono.getText());
      }
       int Movid =0;
       
  // Variable para almacenar el valor de Movid
if(banco !=null){
    Movid = banco.getIdMovimientoDetalles();   
         }  


         
// Codigo Encabezado:

        encabezado.setMovId(Movid);
        
           String selectItem3 =cbCodigo.getSelectedItem().toString();
        String codBan= selectItem3.split(" - ")[0]; // Obtiene solo la ID
         encabezado.setCodBanco(Integer.parseInt(codBan));
        
        String selectItem4 = cbIdCuenta.getSelectedItem().toString();
        String cue= selectItem4.split(" - ")[0]; // Obtiene solo la ID
         encabezado.setCueId(Integer.parseInt(cue));
     
         
          String selectItem5 = cbTipMov.getSelectedItem().toString();
        String T= selectItem5.split(" - ")[0]; // Obtiene solo la ID
        encabezado.setTipMovId(Integer.parseInt(T));
         
         

        encabezado.setMovFecha(txtFecha.getText());
        
         String selectItem6 = cbIdCuenEm.getSelectedItem().toString();
        String CueE= selectItem6.split(" - ")[0]; // Obtiene solo la ID
         encabezado.setCueEmId(Integer.parseInt(CueE));
        
 
         
         
            
         banco.setModificarMovimiento(banco);
   encabezado.setModificarMovimientosEncabezado(encabezado);
        
 String selectedItem10 = cbIdCuenEm.getSelectedItem().toString();
int item10 = Integer.parseInt(selectedItem10.split(" - ")[0]);
banco.setIdMovimientoDetalles(item10);
banco = banco.getBuscarInformacionBancoPorTipoMovimientoSaldo(banco, encabezado);
double saldoActual = banco.getAbonoCargo()+totales;

double resultado = saldoActual;

banco.setAbonoCargo(resultado);

banco.setModificarMovimientoSaldo(banco, encabezado);         
       
  
        JOptionPane.showMessageDialog(null, "Registro Modificado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);  
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "UPD");
        llenadoDeTablas();

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       //KARLA SOFÍA GOMEZ TOBAR -
//NELSON JOSUÉ PINEDA CULAJAY 9959-21-10015
        limpiarTextos();
        habilitarBotones();
           limpiarTextos2();
        habilitarBotones2();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed
    public void limpiarTextos()
    {
        cbConcepto.setSelectedIndex(0);
        cbMovimientoMoneda.setSelectedIndex(0);
        tbTipoCargoAbono.setSelectedIndex(0);
        txtAbono.setText("");
        txtIdMovDetalles.setText("");
        txtCargo.setText("");    
    }
    public void LimpiarSoloTipoCuenta(){
        tbTipoCargoAbono.setSelectedIndex(0);
    }
    public void PonerPosicion1(){
        tbTipoCargoAbono.setSelectedIndex(1);
    }
    public void habilitarBotones()
    {
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);

    }
    public void desHabilitarBotones()
    {
        btnRegistrar.setEnabled(false);
        btnModificar.setEnabled(false);
  
    }    
    
    public void limpiarTextos2()
    {
        txtid.setText("");
        txtFecha.setText("");
        cbCodigo.setSelectedIndex(0);
        cbIdCuenta.setSelectedIndex(0);
        cbTipMov.setSelectedIndex(0);
        cbIdCuenEm.setSelectedIndex(0);
        cbBusquedaID.setSelectedIndex(0);

    }
    public void habilitarBotones2()
    {
   
        btnEliminar1.setEnabled(true);
    }
    public void desHabilitarBotones2()
    {
       
      
        btnEliminar1.setEnabled(false);
    }    
    
    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
   //KARLA SOFÍA GOMEZ TOBAR -
//NELSON JOSUÉ PINEDA CULAJAY 9959-21-10015
    //Borrado de Detalles
   
 int idMovimientoDetalles = Integer.parseInt(cbBusquedaID.getSelectedItem().toString());
// Borrar todas las llaves foráneas en MovimientoIdDetalles
int registrosBorradosDetalles = 0;
clsMovimientoDetallesBancos banco = new clsMovimientoDetallesBancos();
banco.setIdMovimientoDetalles(idMovimientoDetalles);
registrosBorradosDetalles = banco.setBorrarMovimiento(banco);

// Encontrar el último encabezado con el idMovimiento coincidente
int contador = 0;
int ultimoEncabezadoId = 0;
clsMovimientosEncabezadoBancos encabezado = new clsMovimientosEncabezadoBancos();
encabezado.setMovId(idMovimientoDetalles);

List<clsMovimientosEncabezadoBancos> encabezados = encabezado.getListadoMovEncabezado();
for (clsMovimientosEncabezadoBancos enc : encabezados) {
    contador++;
    if (contador == encabezados.size()) {
        ultimoEncabezadoId = enc.getMovId();
    }
}
// Borrar el último encabezado encontrado
int registrosBorradosEncabezado = 0;
encabezado.setMovId(ultimoEncabezadoId);
registrosBorradosEncabezado = encabezado.setborrarMovimientosEncabezado(encabezado);

        JOptionPane.showMessageDialog(null, "Registro Borrado\n",
            "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        llenadoDeTablas2();
         llenadoDeTablas();
        limpiarTextos();
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "DEL");
         llenarClasificacionDetalles ();
         BusquedaDetallesEncabezado();
        limpiarTextos2();
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void cbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCodigoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
  try {
            if ((new File("src\\main\\java\\bancos\\ayuda\\ayudaMovimientoBancos.chm")).exists()) {
                Process p = Runtime
                .getRuntime()
                .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\bancos\\ayuda\\ayudaMovimientoBancos.chm");
                p.waitFor();
            } else {
                System.out.println("La ayuda no fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbTipoCargoAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbTipoCargoAbonoActionPerformed
        // TODO add your handling code here:  
        String Seleccionar;
           Seleccionar = tbTipoCargoAbono.getSelectedItem().toString();
if (Seleccionar.equals("Ambos")) {
    txtAbono.setEnabled(true);
    txtCargo.setEnabled(true);
    txtAbono.setText("");
    txtCargo.setText("");
} else if (Seleccionar.equals("Cargo")) {
    txtAbono.setEnabled(false);
    txtCargo.setEnabled(true);
 txtAbono.setText("");
    txtCargo.setText("");
} else if (Seleccionar.equals("Abono")) {
    txtAbono.setEnabled(true);
    txtCargo.setEnabled(false);
txtAbono.setText("");
    txtCargo.setText("");
}else if (Seleccionar.equals("Seleccionar...")) {
    txtAbono.setEnabled(false);
    txtCargo.setEnabled(false);
    txtAbono.setText("");
    txtCargo.setText("");
}
    

        
    }//GEN-LAST:event_tbTipoCargoAbonoActionPerformed

    private void btnClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClasificacionActionPerformed
        // TODO add your handling code here:
    clsMovimientoDetallesBancos tipou = new clsMovimientoDetallesBancos();
   List<clsMovimientoDetallesBancos> listaTipoBancos = tipou.getListadoMovimiento();
 int seleccionar = cbClasificacion.getSelectedIndex();
if (seleccionar == 0) {
    llenadoDeTablas();
    }
else{
         DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Movimiento Detalles");
        modelo.addColumn("Id Movimiento Encabezado");
        modelo.addColumn("Abono");
        modelo.addColumn("Concepto");
        modelo.addColumn("Cargo");
        modelo.addColumn("Id Movimiento Moneda");
   tablaUsuarios.setModel(modelo);
    int comparar;
    comparar = Integer.parseInt(cbClasificacion.getSelectedItem().toString());
   modelo.setRowCount(0);
   float TotalAbonos =0;
   float TotalCargos =0;
   float TotalDiferencias=0;
   for (clsMovimientoDetallesBancos movimiento : listaTipoBancos) {
    if (movimiento.getIdMovimiento() == comparar) {
        String[] dato = new String[6];
        dato[0] = Integer.toString(movimiento.getIdMovimientoDetalles());
        dato[1] = Integer.toString(movimiento.getIdMovimiento());
        dato[2] = Float.toString(movimiento.getMovimientoCosto());
        dato[3] = Integer.toString(movimiento.getIdConcepto());
        dato[4] = Float.toString(movimiento.getMovimientoSaldo());
        dato[5] = Integer.toString(movimiento.getIdTipoMovimiento());
        modelo.addRow(dato); 
        TotalAbonos += movimiento.getMovimientoCosto();
        TotalCargos += movimiento.getMovimientoSaldo();
   }
    
    }
    TotalCargo.setText(Float.toString(TotalCargos));
   TotalAbono.setText(Float.toString(TotalAbonos));
   TotalDiferencia.setText(Float.toString(TotalCargos-TotalAbonos));
   }    
    }//GEN-LAST:event_btnClasificacionActionPerformed

    private void cbClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClasificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbClasificacionActionPerformed

    private void cbBusquedaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBusquedaIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBusquedaIDActionPerformed

    private void cbIdCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIdCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbIdCuentaActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
 clsReportes reporte = new clsReportes();
        String customReportPath = "/src/main/java/bancos/reportes/rptMovimientoBancos.jrxml";
        reporte.setReportPath(customReportPath);
        reporte.generateReport();        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TotalAbono;
    private javax.swing.JLabel TotalCargo;
    private javax.swing.JLabel TotalDiferencia;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnClasificacion;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReportes;
    private javax.swing.JComboBox<String> cbBusquedaID;
    private javax.swing.JComboBox<String> cbClasificacion;
    private javax.swing.JComboBox<String> cbCodigo;
    private javax.swing.JComboBox<String> cbConcepto;
    private javax.swing.JComboBox<String> cbIdCuenEm;
    private javax.swing.JComboBox<String> cbIdCuenta;
    private javax.swing.JComboBox<String> cbMovimientoMoneda;
    private javax.swing.JComboBox<String> cbTipMov;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label11;
    private javax.swing.JLabel label12;
    private javax.swing.JLabel label13;
    private javax.swing.JLabel label14;
    private javax.swing.JLabel label15;
    private javax.swing.JLabel label16;
    private javax.swing.JLabel label17;
    private javax.swing.JLabel label18;
    private javax.swing.JLabel label19;
    private javax.swing.JLabel label20;
    private javax.swing.JLabel label21;
    private javax.swing.JLabel label24;
    private javax.swing.JLabel label25;
    private javax.swing.JLabel label26;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JComboBox<String> tbTipoCargoAbono;
    private javax.swing.JTextField txtAbono;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdMovDetalles;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
