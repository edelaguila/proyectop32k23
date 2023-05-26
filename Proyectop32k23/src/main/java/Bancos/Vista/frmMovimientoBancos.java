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
        cbMovimientoMoneda.addItem(String.valueOf(listaTipoMonedas.get(i).getTipModId()));
    }
}

public void llenadoDeComboDetallesConcepto() {
    clsConceptosBancos Concep = new clsConceptosBancos();
    List<clsConceptosBancos> listaConceptoss = Concep.getListadoConceptos();
    cbConcepto.setAlignmentX(Component.CENTER_ALIGNMENT);
   cbConcepto.addItem("Seleccionar...");
    for (int i = 0; i < listaConceptoss.size(); i++) {
        cbConcepto.addItem(String.valueOf(listaConceptoss.get(i).getIdConcepto()));
    }
}

public void llenadoDeComboDetallesId() {
     clsMovimientosEncabezadoBancos movEncabezado = new clsMovimientosEncabezadoBancos();
    List<clsMovimientosEncabezadoBancos> listaMovEncabezado = movEncabezado.getListadoMovEncabezado();
   cbMovimientoEncabezado.removeAllItems();
    Set <Integer> idSet= new HashSet<>();
    cbMovimientoEncabezado.setAlignmentX(Component.CENTER_ALIGNMENT);
   cbMovimientoEncabezado.addItem("Seleccionar...");
    for (clsMovimientosEncabezadoBancos movimientos : listaMovEncabezado){
        int Id = movimientos.getMovId();
        if(!idSet.contains(Id)){
            cbMovimientoEncabezado.addItem(String.valueOf(Id));
            idSet.add(Id);
    }
    
    }
}

public void llenadoDeComboA() {
        clsBancoExterno banco = new clsBancoExterno();
        List<clsBancoExterno> listadoBancosExternos = banco.getListadoBancosExternos();
        cbCodigo.setAlignmentX(Component.CENTER_ALIGNMENT);
        for (int i = 0; i < listadoBancosExternos.size(); i++) {
            cbCodigo.addItem(String.valueOf(listadoBancosExternos.get(i).getCodigoBanco()));
        }
    }
    public void llenadoDeComboB() {
        clsCuentasBancos cuentasB = new clsCuentasBancos();
        List<clsCuentasBancos> listaCuentasbancos = cuentasB.getListadoCuentas();
        cbIdCuenta.setAlignmentX(Component.CENTER_ALIGNMENT);
        for (int i = 0; i < listaCuentasbancos.size(); i++) {
            cbIdCuenta.addItem(String.valueOf(listaCuentasbancos.get(i).getIdCuenta()));
        }
    }
    public void llenadoDeComboC() {
        clsTipoMovimientoBancos TipoMB = new clsTipoMovimientoBancos();
        List<clsTipoMovimientoBancos> listaclsTipoMovimientoBancos = TipoMB.getListadoTipoMovimiento();
        cbTipMov.setAlignmentX(Component.CENTER_ALIGNMENT);
        for (int i = 0; i < listaclsTipoMovimientoBancos.size(); i++) {
            cbTipMov.addItem(String.valueOf(listaclsTipoMovimientoBancos.get(i).getTipoMovimientoId()));
        }
    }
    public void llenadoDeComboD() {
        clsCuentaEmpresa TipoMB = new clsCuentaEmpresa();
        List<clsCuentaEmpresa> listaclsCuentaEmpresa = TipoMB.getListadoCuentaEmpresas();
        cbIdCuenEm.setAlignmentX(Component.CENTER_ALIGNMENT);
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
  

public void BusquedaDetallesEncabezado() {
     clsMovimientosEncabezadoBancos movEncabezado = new clsMovimientosEncabezadoBancos();
    List<clsMovimientosEncabezadoBancos> listaMovEncabezado = movEncabezado.getListadoMovEncabezado();
     cbEncabezadoId.removeAllItems();
    Set <Integer> idSet= new HashSet<>();
    cbEncabezadoId.addItem("Seleccionar...");
    cbEncabezadoId.setAlignmentX(Component.CENTER_ALIGNMENT);
    for (clsMovimientosEncabezadoBancos movimientos : listaMovEncabezado){
        int Id = movimientos.getMovId();
        if(!idSet.contains(Id)){
            cbEncabezadoId.addItem(String.valueOf(Id));
            idSet.add(Id);     
       }
    }
}     
            
                      
            
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
        llenadoDeComboDetallesId();
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
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        lb = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        btnLimpiar1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        btnRegistrar1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnBuscar1 = new javax.swing.JButton();
        label10 = new javax.swing.JLabel();
        btnModificar1 = new javax.swing.JButton();
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
        label3 = new javax.swing.JLabel();
        cbMovimientoEncabezado = new javax.swing.JComboBox<>();
        label8 = new javax.swing.JLabel();
        cbConcepto = new javax.swing.JComboBox<>();
        label9 = new javax.swing.JLabel();
        cbMovimientoMoneda = new javax.swing.JComboBox<>();
        label19 = new javax.swing.JLabel();
        tbTipoCargoAbono = new javax.swing.JComboBox<>();
        label20 = new javax.swing.JLabel();
        label21 = new javax.swing.JLabel();
        TotalAbono = new javax.swing.JLabel();
        label23 = new javax.swing.JLabel();
        label11 = new javax.swing.JLabel();
        label24 = new javax.swing.JLabel();
        TotalCargo = new javax.swing.JLabel();
        TotalDiferencia = new javax.swing.JLabel();
        btnClasificacion = new javax.swing.JButton();
        cbClasificacion = new javax.swing.JComboBox<>();
        label25 = new javax.swing.JLabel();
        cbEncabezadoId = new javax.swing.JComboBox<>();
        txtbuscadoDetalles = new javax.swing.JTextField();
        label26 = new javax.swing.JLabel();
        label27 = new javax.swing.JLabel();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Movimiento Bancarios");
        setVisible(true);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Aceptar");
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
        label1.setText("Detalle de Movimientos");

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

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");

        btnLimpiar1.setText("Limpiar");
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });

        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        btnRegistrar1.setText("Registrar");
        btnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar1ActionPerformed(evt);
            }
        });

        jButton3.setText("Ayuda");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnBuscar1.setText("Buscar");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        label10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label10.setText("ID a buscar deEncabezado");

        btnModificar1.setText("Modificar");
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
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
                .addGap(24, 24, 24)
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
                        .addGap(82, 82, 82)
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
                        .addComponent(cbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Id Movimiento Encabezado");

        cbMovimientoEncabezado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMovimientoEncabezadoActionPerformed(evt);
            }
        });

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
                    .addComponent(txtIdMovDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label3)
                        .addGap(18, 18, 18)
                        .addComponent(cbMovimientoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(label8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label19))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(label9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbMovimientoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(label7)))
                    .addComponent(label5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tbTipoCargoAbono, 0, 112, Short.MAX_VALUE)
                    .addComponent(txtAbono)
                    .addComponent(txtCargo))
                .addGap(108, 108, 108))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(label8)
                            .addComponent(cbConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdMovDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label19)
                            .addComponent(tbTipoCargoAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(cbMovimientoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbMovimientoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label9)
                        .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label7)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        label20.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label20.setText("DIFERENCIA:");

        label21.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label21.setText("TOTAL DE CARGOS:");

        TotalAbono.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        TotalAbono.setText("0");

        label23.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label23.setText("Eliminar un Id Detalles");

        label11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label11.setText("Detalles:");

        label24.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label24.setText("TOTAL DE ABONOS:");

        TotalCargo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        TotalCargo.setText("0");

        TotalDiferencia.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        TotalDiferencia.setText("0");

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

        label25.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label25.setText("Clasifiación de ID Encabezado");

        cbEncabezadoId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEncabezadoIdActionPerformed(evt);
            }
        });

        label26.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label26.setText("Modificar/Buscar EL Id Detalles");

        label27.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label27.setText("Modificar/Buscar/Eliminar EL Id Encabezado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TotalDiferencia)
                                .addGap(300, 300, 300))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label25)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(cbClasificacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btnClasificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label23)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label12)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label11)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRegistrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label27)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cbEncabezadoId, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnModificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label1)
                                        .addGap(686, 686, 686))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtbuscadoDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(label26))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(label12)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar1)
                            .addComponent(btnLimpiar1)
                            .addComponent(jButton3))
                        .addGap(32, 32, 32)
                        .addComponent(label27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbEncabezadoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar1)
                            .addComponent(btnModificar1)
                            .addComponent(btnBuscar1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label10)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnRegistrar)
                                .addComponent(btnLimpiar))
                            .addComponent(lb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(txtbuscadoDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(label25)
                        .addGap(13, 13, 13)
                        .addComponent(btnClasificacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label21)
                    .addComponent(TotalDiferencia)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TotalCargo)
                        .addComponent(label20))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label24)
                        .addComponent(TotalAbono)))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int registrosBorrados=0;
        clsMovimientoDetallesBancos banco = new clsMovimientoDetallesBancos();
        banco.setIdMovimientoDetalles(Integer.parseInt(txtbuscado.getText()));
        registrosBorrados=banco.setBorrarMovimiento(banco);
        JOptionPane.showMessageDialog(null, "Registro Borrado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "DEL");
        llenadoDeTablas();
        limpiarTextos();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

         String Encabezado = cbMovimientoEncabezado.getSelectedItem().toString();
         String Concepto = cbConcepto.getSelectedItem().toString();
         String TipoMoneda= cbMovimientoMoneda.getSelectedItem().toString();
         String CargoAbono = tbTipoCargoAbono.getSelectedItem().toString();
         String Abono = txtAbono.getText();
         String Cargo = txtCargo.getText();
         
 if (Encabezado.equals("Seleccionar...")|| Concepto.equals("Seleccionar...")||TipoMoneda.equals("Seleccionar...")||CargoAbono.equals("Seleccionar...")) {
   JOptionPane.showMessageDialog(null, "Error! Debe seleccionar todos los Id y el Tipo de Cuenta", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
}else{
           clsMovimientoDetallesBancos banco = new clsMovimientoDetallesBancos();
    banco.setIdMovimientoDetalles(Integer.parseInt(txtIdMovDetalles.getText()));
    banco.setIdMovimiento(Integer.parseInt(cbMovimientoEncabezado.getSelectedItem().toString()));
    banco.setIdConcepto(Integer.parseInt(cbConcepto.getSelectedItem().toString()));
    banco.setIdTipoMovimiento(Integer.parseInt(cbMovimientoMoneda.getSelectedItem().toString()));
    int SeleccionarIndex = tbTipoCargoAbono.getSelectedIndex();
    String vacio = ""; //Saldo = Cargo, Costo = Abono
    String cero = "0";
      if (SeleccionarIndex == 0){
               banco.setMovimientoCosto(Float.parseFloat(vacio));
               banco.setMovimientoSaldo(Float.parseFloat(vacio)); 
       }
      else if (SeleccionarIndex == 1){
            banco.setMovimientoCosto(Float.parseFloat(txtAbono.getText()));
            banco.setMovimientoSaldo(Float.parseFloat(txtCargo.getText()));  
      }
    else if (SeleccionarIndex == 2){
            banco.setMovimientoCosto(Float.parseFloat(cero));
            banco.setMovimientoSaldo(Float.parseFloat(txtCargo.getText()));  
      }
    else if (SeleccionarIndex == 3){
            banco.setMovimientoSaldo(Float.parseFloat(cero));
            banco.setMovimientoCosto(Float.parseFloat(txtAbono.getText())); 
      }
    
    
    banco.setIngresarMovimiento(banco);
        JOptionPane.showMessageDialog(null, "Registro Ingresado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "INS");
        llenarClasificacionDetalles();
        BusquedaDetallesEncabezado ();
        llenadoDeTablas();
        limpiarTextos();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
   txtAbono.setEnabled(true);
    txtCargo.setEnabled(true);
        
        clsMovimientoDetallesBancos banco = new clsMovimientoDetallesBancos();
        //aplicacion.setNombreAplicacion(txtbuscado.getText());        
        banco.setIdMovimientoDetalles(Integer.parseInt(txtbuscadoDetalles.getText()));        
        banco = banco.getBuscarInformacionBancoPorTipoMovimiento(banco);
        System.out.println("Usuario retornado:" + banco); 
       txtIdMovDetalles.setText(Integer.toString(banco.getIdMovimientoDetalles()));
       txtAbono.setText(Float.toString(banco.getMovimientoCosto()));
       txtCargo.setText(Float.toString(banco.getMovimientoSaldo()));
        int Encabezado = banco.getIdMovimiento();
   
for (int i = 1; i < cbMovimientoEncabezado.getItemCount(); i++) {
    int item = Integer.parseInt(cbMovimientoEncabezado.getItemAt(i).toString());
    if (item == Encabezado) {
        cbMovimientoEncabezado.setSelectedIndex(i);
        break;
     }
}
        
        int IdConcepto = banco.getIdConcepto();
        for (int i = 1; i <cbConcepto.getItemCount(); i++) {
            int item = Integer.parseInt(cbConcepto.getItemAt(i).toString());
            if (item == IdConcepto) {
                cbConcepto.setSelectedIndex(i);
                break;
            }
        }
    
        int TipMoneda = banco.getIdTipoMovimiento();
        for (int i = 1; i < cbMovimientoMoneda.getItemCount(); i++) {
            int item = Integer.parseInt(cbMovimientoMoneda.getItemAt(i).toString());
            if (item == TipMoneda) {
               cbMovimientoMoneda.setSelectedIndex(i);
                break;
            }
        }
        

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        // TODO add your handling code here:
        clsMovimientoDetallesBancos banco = new clsMovimientoDetallesBancos();
        banco.setIdMovimientoDetalles(Integer.parseInt(txtbuscadoDetalles.getText()));
        banco.setMovimientoCosto (Float.parseFloat(txtAbono.getText()));
        banco.setMovimientoSaldo(Float.parseFloat(txtCargo.getText()));
        banco.setIdMovimiento(Integer.parseInt(cbMovimientoEncabezado.getSelectedItem().toString()));
        banco.setIdConcepto(Integer.parseInt(cbConcepto.getSelectedItem().toString()));
        banco.setIdTipoMovimiento(Integer.parseInt(cbMovimientoMoneda.getSelectedItem().toString()));
         banco.setModificarMovimiento(banco);
     
    
        
        
        JOptionPane.showMessageDialog(null, "Registro Modificado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);  
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "UPD");
        BusquedaDetallesEncabezado ();
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
        cbMovimientoEncabezado.setSelectedIndex(0);
        cbConcepto.setSelectedIndex(0);
        cbMovimientoMoneda.setSelectedIndex(0);
        tbTipoCargoAbono.setSelectedIndex(0);
        txtAbono.setText("");
        txtIdMovDetalles.setText("");
        txtCargo.setText("");
        txtbuscadoDetalles.setText("");
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
    
    public void limpiarTextos2()
    {
        txtid.setText("");
        txtFecha.setText("");
        cbEncabezadoId.setSelectedIndex(0);
        cbCodigo.setSelectedIndex(0);
        cbIdCuenta.setSelectedIndex(0);
        cbTipMov.setSelectedIndex(0);
        cbIdCuenEm.setSelectedIndex(0);

    }
    public void habilitarBotones2()
    {
        btnRegistrar1.setEnabled(true);
        btnModificar1.setEnabled(true);
        btnEliminar1.setEnabled(true);
    }
    public void desHabilitarBotones2()
    {
        btnRegistrar1.setEnabled(false);
        btnModificar1.setEnabled(false);
        btnEliminar1.setEnabled(false);
    }    
    
    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        // TODO add your handling code here:
        int registrosBorrados=0;
        clsMovimientosEncabezadoBancos encabezado = new clsMovimientosEncabezadoBancos();
        encabezado.setMovId(Integer.parseInt(cbEncabezadoId.getSelectedItem().toString()));
        registrosBorrados=encabezado.setborrarMovimientosEncabezado(encabezado);
        JOptionPane.showMessageDialog(null, "Registro Borrado\n",
            "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        llenadoDeTablas2();

        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "DEL");
         llenarClasificacionDetalles ();
         BusquedaDetallesEncabezado();
         llenadoDeComboDetallesId();
        limpiarTextos2();
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar1ActionPerformed

        clsMovimientosEncabezadoBancos encabezado = new clsMovimientosEncabezadoBancos();
        encabezado.setMovId(Integer.parseInt(txtid.getText()));
        encabezado.setMovFecha(txtFecha.getText());
        encabezado.setCodBanco(Integer.parseInt(cbCodigo.getSelectedItem().toString()));
        encabezado.setCueId(Integer.parseInt(cbIdCuenta.getSelectedItem().toString()));
        encabezado.setTipMovId(Integer.parseInt(cbTipMov.getSelectedItem().toString()));
        encabezado.setCueEmId(Integer.parseInt(cbIdCuenEm.getSelectedItem().toString()));


        encabezado.setingresaMovimientosEncabezado(encabezado);
        JOptionPane.showMessageDialog(null, "Registro Ingresado\n",
            "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "INS");
        llenarClasificacionDetalles ();
        BusquedaDetallesEncabezado();
         llenadoDeComboDetallesId();
        llenadoDeTablas2();
        limpiarTextos2();

    }//GEN-LAST:event_btnRegistrar1ActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        // TODO add your handling code here:
        clsMovimientosEncabezadoBancos encabezado = new clsMovimientosEncabezadoBancos();
        //usuario.setNombreUsuario(txtbuscado.getText());
        encabezado.setMovId(Integer.parseInt(cbEncabezadoId.getSelectedItem().toString()));
        encabezado = encabezado.getBuscarMovimientosEncabezadoPorId(encabezado);
        System.out.println("movDetalle retornado:" + encabezado);
        txtFecha.setText(encabezado.getMovFecha());


        int cogidoBanc = encabezado.getCodBanco();
        for (int i = 0; i < cbCodigo.getItemCount(); i++) {
            int item = Integer.parseInt(cbCodigo.getItemAt(i).toString());
            if (item == cogidoBanc) {
                cbCodigo.setSelectedIndex(i);
                break;
            }
        }
        
        int IdCuenta = encabezado.getCueId();
        for (int i = 0; i < cbIdCuenta.getItemCount(); i++) {
            int item = Integer.parseInt(cbIdCuenta.getItemAt(i).toString());
            if (item == IdCuenta) {
                cbIdCuenta.setSelectedIndex(i);
                break;
            }
        }
        
        int TipMovID = encabezado.getTipMovId();
        for (int i = 0; i < cbTipMov.getItemCount(); i++) {
            int item = Integer.parseInt(cbTipMov.getItemAt(i).toString());
            if (item == TipMovID) {
                cbTipMov.setSelectedIndex(i);
                break;
            }
        }

        
        int CuentaEmID = encabezado.getCueEmId();
        for (int i = 0; i < cbIdCuenEm.getItemCount(); i++) {
            int item = Integer.parseInt(cbIdCuenEm.getItemAt(i).toString());
            if (item == CuentaEmID) {
                cbIdCuenEm.setSelectedIndex(i);
                break;
            }
        }
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "QRY");
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
         // TODO add your handling code here:
        clsMovimientosEncabezadoBancos encabezado = new clsMovimientosEncabezadoBancos();
        encabezado.setMovId(Integer.parseInt(cbEncabezadoId.getSelectedItem().toString()));
        encabezado.setCodBanco(Integer.parseInt(cbCodigo.getSelectedItem().toString()));
        encabezado.setCueId(Integer.parseInt(cbIdCuenta.getSelectedItem().toString()));
        encabezado.setTipMovId(Integer.parseInt(cbTipMov.getSelectedItem().toString()));
        encabezado.setMovFecha(txtFecha.getText());
        encabezado.setCueEmId(Integer.parseInt(cbIdCuenEm.getSelectedItem().toString()));

        encabezado.setModificarMovimientosEncabezado(encabezado);
        JOptionPane.showMessageDialog(null, "Registro Modificado\n",
            "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        llenadoDeTablas2();

        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "UPD");

        limpiarTextos2();
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void cbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCodigoActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        limpiarTextos2();
        habilitarBotones2();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
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
 
} else if (Seleccionar.equals("Abono")) {
    txtAbono.setEnabled(true);
    txtCargo.setEnabled(false);
 
}else if (Seleccionar.equals("Seleccionar...")) {
    txtAbono.setEnabled(false);
    txtCargo.setEnabled(false);
    txtAbono.setText("");
    txtCargo.setText("");
}
    

        
    }//GEN-LAST:event_tbTipoCargoAbonoActionPerformed

    private void cbMovimientoEncabezadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMovimientoEncabezadoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cbMovimientoEncabezadoActionPerformed

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

    private void cbEncabezadoIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEncabezadoIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEncabezadoIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TotalAbono;
    private javax.swing.JLabel TotalCargo;
    private javax.swing.JLabel TotalDiferencia;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnClasificacion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrar1;
    private javax.swing.JComboBox<String> cbClasificacion;
    private javax.swing.JComboBox<String> cbCodigo;
    private javax.swing.JComboBox<String> cbConcepto;
    private javax.swing.JComboBox<String> cbEncabezadoId;
    private javax.swing.JComboBox<String> cbIdCuenEm;
    private javax.swing.JComboBox<String> cbIdCuenta;
    private javax.swing.JComboBox<String> cbMovimientoEncabezado;
    private javax.swing.JComboBox<String> cbMovimientoMoneda;
    private javax.swing.JComboBox<String> cbTipMov;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
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
    private javax.swing.JLabel label23;
    private javax.swing.JLabel label24;
    private javax.swing.JLabel label25;
    private javax.swing.JLabel label26;
    private javax.swing.JLabel label27;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JComboBox<String> tbTipoCargoAbono;
    private javax.swing.JTextField txtAbono;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdMovDetalles;
    private javax.swing.JTextField txtbuscado;
    private javax.swing.JTextField txtbuscadoDetalles;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
