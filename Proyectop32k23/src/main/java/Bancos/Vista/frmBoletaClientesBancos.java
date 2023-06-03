/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Hecho por: Alyson Vannesa Rodríguez Quezada 9959-21-829
package Bancos.Vista;


import Bancos.Controlador.clsBoletaClientesBancos;
import Bancos.Controlador.clsBancoExterno;
import Ventas.Controlador.clsClientes;
import Bancos.Controlador.clsConceptosBancos;
import Bancos.Controlador.clsTipoMovimientoBancos;
import Bancos.Controlador.clsCuentasBancos;
import Bancos.Controlador.clsTipoMoneda;
import Seguridad.Controlador.clsBitacora;
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
public class frmBoletaClientesBancos extends javax.swing.JInternalFrame {
    int codigoAplicacion= 5012;

    public void llenadoCodigoBanco() {
       clsBancoExterno banco = new clsBancoExterno();
        List<clsBancoExterno> listaBancos = banco.getListadoBancosExternos();
        cbNombreBanco.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbNombreBanco.addItem("Seleccionar...");
        for (int i = 0; i < listaBancos.size(); i++) {
            clsBancoExterno bancoExterno = listaBancos.get(i);
            String item = bancoExterno.getCodigoBanco()+ " - "+bancoExterno.getNombreBanco();
            cbNombreBanco.addItem(item);
        }
    }
    
    //No encontre el numero de la factura
    /*public void actionPerformed(clsBoletaClientesBancos factura) {
        String seleccionado = (String) cbNombreCliente.getSelectedItem();
        if (!seleccionado.equals("Seleccionar...")) {
            // Obtener el número de factura asociado al cliente seleccionado
            String[] partes = seleccionado.split(" - ");
            String idCliente = partes[0];
            String numeroFactura = obtenerNumeroFactura(idCliente);

            // Mostrar el número de factura en el TextField
            txtFactura.setText(numeroFactura);
        } else {
            // Limpiar el TextField si no se selecciona ningún cliente
            txtFactura.setText("");
        }
    }*/
    
    
     public void llenadoDeComboNombreCliente() {
        clsClientes cliente = new clsClientes();
        List<clsClientes> listaClientes = cliente.getListadoClientes();
        cbNombreCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbNombreCliente.addItem("Seleccionar...");
        for (int i = 0; i < listaClientes.size(); i++) {
            clsClientes clienteNombre = listaClientes.get(i);
            String item = clienteNombre.getIdCliente() + " - " + clienteNombre.getNombreCliente();
            cbNombreCliente.addItem(item);
        }
     }
     
    /*public void llenadoConcepto() {
       clsConceptosBancos concepto = new clsConceptosBancos();
        List<clsConceptosBancos> listaConcepto = concepto.getListadoConceptos();
        cbConcepto.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbConcepto.addItem("Seleccionar...");
        for (int i = 0; i < listaConcepto.size(); i++) {
            clsConceptosBancos conceptosBancos = listaConcepto.get(i);
            String item = conceptosBancos.getIdConcepto()+ " - "+conceptosBancos.getNombreConcepto();
            cbConcepto.addItem(item);
        }
    }*/
    
    public void llenadoTipoMovimiento() {
       clsTipoMovimientoBancos movimiento = new clsTipoMovimientoBancos();
        List<clsTipoMovimientoBancos> listaMovimiento = movimiento.getListadoTipoMovimiento();
        cbCodigoMov.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbCodigoMov.addItem("Seleccionar...");
        for (int i = 0; i < listaMovimiento.size(); i++) {
            clsTipoMovimientoBancos movimientosBancos = listaMovimiento.get(i);
            String item = movimientosBancos.getTipoMovimientoId()+ " - "+movimientosBancos.getNombreMovimiento();
            cbCodigoMov.addItem(item);
        }
    }
    
    /*public void llenadoCuentas() {
       clsCuentasBancos cuentas = new clsCuentasBancos();
        List<clsCuentasBancos> listaCuentas = cuentas.getListadoCuentas();
        cbIdCuenta.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbIdCuenta.addItem("Seleccionar...");
        for (int i = 0; i < listaCuentas.size(); i++) {
            //clsCuentasBancos cuentasBancos = listaCuentas.get(i);
            //String item = cuentasBancos.getIdCuenta()+ " - "+cuentasBancos.getCodBanco();
            //cbIdCuenta.addItem(item);
            cbIdCuenta.addItem(String.valueOf(listaCuentas.get(i).getIdCuenta()));
        } 
    }*/
     
    public void llenadoMoneda() {
        clsTipoMoneda moneda = new clsTipoMoneda();
        List<clsTipoMoneda> listaTipoMonedas = moneda.getListadoMonedas();
        cbTipoMoneda.setAlignmentX(Component.CENTER_ALIGNMENT);
        cbTipoMoneda.addItem("Seleccionar...");
        for (int i = 0; i < listaTipoMonedas.size(); i++) {
            clsTipoMoneda tipoMoneda = listaTipoMonedas.get(i);
            String item = tipoMoneda.getTipModId() + " - " + tipoMoneda.getTipMondNombre();
            cbTipoMoneda.addItem(item);
        }
    }
     

    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Documento No.");
        modelo.addColumn("Banco");
        modelo.addColumn("Fecha");
        modelo.addColumn("Cliente");
        modelo.addColumn("Saldo");      
        modelo.addColumn("Movimiento");
        modelo.addColumn("Moneda");
        
        clsBoletaClientesBancos boleta = new clsBoletaClientesBancos();
        //VendedorDAO vendedorDAO = new VendedorDAO();
        List<clsBoletaClientesBancos> listadoBoletaCliente = boleta.getListadoBoletas();
     
        tablaMovimientos.setModel(modelo);
        String[] dato = new String[6];
        for (int i = 0; i < listadoBoletaCliente.size(); i++) {
            dato[0] = Integer.toString(listadoBoletaCliente.get(i).getIdBoleta());
            dato[1] = Integer.toString(listadoBoletaCliente.get(i).getCodigoBanco());
            dato[2] = listadoBoletaCliente.get(i).getFechaEmisionBoleta();
            dato[3] = Integer.toString(listadoBoletaCliente.get(i).getIdCliente());
            dato[4] = Float.toString(listadoBoletaCliente.get(i).getSaldoBoleta());
            dato[5] = Integer.toString(listadoBoletaCliente.get(i).getIdTipoMovimiento());
            dato[6] = Integer.toString(listadoBoletaCliente.get(i).getIdTipoMoneda());
            modelo.addRow(dato);
        }       
    }

    public frmBoletaClientesBancos() {
        initComponents();
        llenadoDeTablas();
        llenadoCodigoBanco();
        //llenadoConcepto();
        llenadoTipoMovimiento();
        //llenadoCuentas();
        llenadoMoneda();
        llenadoDeComboNombreCliente();
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
        Efecto = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMovimientos = new javax.swing.JTable();
        lb = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoDocumento = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbNombreCliente = new javax.swing.JComboBox<>();
        txtNoDeposito = new javax.swing.JTextField();
        btRegistro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtValorDeposito = new javax.swing.JTextField();
        label24 = new javax.swing.JLabel();
        label23 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        label4 = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        label25 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        cbCodigoMov = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        rbcargo = new javax.swing.JRadioButton();
        rbabono = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        txtvalor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbNombreBanco = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbTipoMoneda = new javax.swing.JComboBox<>();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle(" Cuentas Bancos");
        setVisible(true);

        tablaMovimientos.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tablaMovimientos.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaMovimientos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaMovimientos);

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");

        btnRegistrar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modificar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Eliminar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actualizar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("No. Deposito");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Nombre Cliente");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btRegistro.setText("+ Crear Deposito");
        btRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistroActionPerformed(evt);
            }
        });

        jLabel2.setText("No.Factura");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtFactura.setEditable(false);

        jLabel5.setText("Valor ");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtValorDeposito.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(btRegistro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtNoDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNoDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtCodigoDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtValorDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btRegistro)
                .addContainerGap())
        );

        label24.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label24.setText("TOTAL DE ABONOS:");

        label23.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label23.setText("TOTAL DE CARGOS:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
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
        label4.setText("ID a buscar");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(label4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpiar)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label4)
                    .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        label25.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label25.setText("TOTAL :");

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel9.setText("Efecto");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Efecto.add(rbcargo);
        rbcargo.setText("Cargo -");

        Efecto.add(rbabono);
        rbabono.setText("Abono +");

        jLabel10.setText("Valor");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Concepto");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Fecha Emisión");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Banco");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setText("Moneda");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(29, 29, 29)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(cbCodigoMov, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbNombreBanco, 0, 148, Short.MAX_VALUE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                        .addGap(170, 170, 170)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbcargo)
                                    .addComponent(rbabono))
                                .addGap(101, 101, 101))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbTipoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbNombreBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(rbcargo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbabono)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cbCodigoMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbTipoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(85, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label24)
                        .addGap(211, 211, 211)
                        .addComponent(label23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label25)
                        .addGap(203, 203, 203))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label24)
                    .addComponent(label23)
                    .addComponent(label25))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
       clsBoletaClientesBancos boleta = new clsBoletaClientesBancos();
       
        boleta.setIdBoleta(Integer.parseInt(txtCodigoDocumento.getText()));
        
        String selectedItem= cbNombreBanco.getSelectedItem().toString();
        int itemNombreBanco = Integer.parseInt(selectedItem.split(" - ")[0]);
        boleta.setCodigoBanco(itemNombreBanco);
        
        boleta.setFechaEmisionBoleta(txtFecha.getText());
        
        String selectedItem5= cbNombreCliente.getSelectedItem().toString();
        int itemNombre = Integer.parseInt(selectedItem.split(" - ")[0]);
        boleta.setIdCliente(itemNombre);
      
        boleta.setSaldoBoleta(Float.parseFloat(txtvalor.getText()));
        
        String selectedItem6 = cbCodigoMov.getSelectedItem().toString();
        int itemTipMov = Integer.parseInt(selectedItem.split(" - ")[0]);
        boleta.setIdTipoMovimiento(itemTipMov);
        
        String selectedItem7 = cbTipoMoneda.getSelectedItem().toString();
        int itemTipoMoneda = Integer.parseInt(selectedItem.split(" - ")[0]);
        boleta.setIdTipoMoneda(itemTipoMoneda);
        

        /*String selectedItem3= cbConcepto.getSelectedItem().toString();
        int itemConcepto = Integer.parseInt(selectedItem.split(" - ")[0]);
        boleta.setIdConcepto(itemConcepto);*/

        /*String selectedItem4= cbIdCuenta.getSelectedItem().toString();
        int itemCuenta = Integer.parseInt(selectedItem.split(" - ")[0]);
        boleta.setIdCuenta(itemCuenta);*/

        /*if(rbcargo.isSelected()){
            boleta.setEfectoBoleta("Cargo");
        }

        else if(rbabono.isSelected()){
            boleta.setEfectoBoleta("Abono");
        }
        else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Cargo.");
            return;
        }*/

        JOptionPane.showMessageDialog(null, "Registro Ingresado\n",
            "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);

        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "INS");
        llenadoDeTablas();
        limpiarTextos();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        /*   // TODO add your handling code here:
        clsTipoMovimientoBancos movimiento = new clsTipoMovimientoBancos();
        movimiento.setTipoMovimientoId(Integer.parseInt(txtbuscado.getText()));
        movimiento.setNombreMovimiento(txtNombre.getText());
        //movimiento.setEstatusMovimiento(txtEstatus.getText());
        //movimiento.setModificarTipoMovimiento(movimiento);

        int contador = 0;
        String estatusMovimiento = rbHabilitado.isSelected() ? "T" : (rbDeshabilitado.isSelected() ? "F" : "");
        if (!estatusMovimiento.isEmpty()) {
            contador++;
            movimiento.setEstatusMovimiento(estatusMovimiento);
        }
        if (contador == 1) {
            // Los dos botones de cada ButtonGroup están seleccionados
            movimiento.setModificarTipoMovimiento(movimiento);
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
        }*/
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int registrosBorrados=0;
        clsBoletaClientesBancos boleta= new clsBoletaClientesBancos();
        boleta.setIdBoleta(Integer.parseInt(txtbuscado.getText()));
        registrosBorrados=boleta.setBorrarBoleta(boleta);

        JOptionPane.showMessageDialog(null, "Registro Borrado\n",
            "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        llenadoDeTablas();
        int resultadoBitacora =0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "DEL");
        limpiarTextos();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        llenadoDeTablas();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        clsBoletaClientesBancos boleta = new clsBoletaClientesBancos();
        //usuario.setNombreUsuario(txtbuscado.getText());
        boleta.setIdBoleta(Integer.parseInt(txtbuscado.getText()));
        boleta = boleta.getBuscarInformacionBoletaPorId(boleta);
        System.out.println("Boleta retornada:" + boleta);
        txtCodigoDocumento.setText(Integer.toString(boleta.getCodigoBanco()));
        txtFecha.setText(boleta.getFechaEmisionBoleta());
        txtvalor.setText(Float.toString(boleta.getSaldoBoleta()));

        int tipoMonedaId = boleta.getIdTipoMoneda();
        for (int i = 1; i < cbTipoMoneda.getItemCount(); i++) {
            String item = cbTipoMoneda.getItemAt(i).toString();
            int itemId = Integer.parseInt(item.split(" - ")[0]); // Obtener el ID del item

            if (itemId == tipoMonedaId) {
                cbTipoMoneda.setSelectedIndex(i);
                break;
            }
        }

        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "QRY");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarTextos();
        habilitarBotones();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

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

    private void btRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistroActionPerformed
        /*txtFecha.setEnabled(false);
        cbNombreBanco.setEnabled(false);
        cbCodigoMov.setEnabled(false);
        rbcargo.setEnabled(false);
        rbabono.setEnabled(false);
        txtvalor.setEnabled(false);
        cbTipoMoneda.setEnabled(false);

        String deposito = txtNoDeposito.getText();
        String nombre = cbNombreCliente.getSelectedItem().toString();

        if (deposito.isEmpty() || nombre.equals("Seleccionar...")) {
        JOptionPane.showMessageDialog(null, "Error! Debe llenar todos los campos",
            "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        } else {
         boolean seleccionado = btRegistro.isSelected();

        if (seleccionado) {
        txtFecha.setEnabled(true);
        cbNombreBanco.setEnabled(true);
        cbCodigoMov.setEnabled(true);
        rbcargo.setEnabled(true);
        rbabono.setEnabled(true);
        txtvalor.setEnabled(true);
        cbTipoMoneda.setEnabled(true);
    }
}*/
    }//GEN-LAST:event_btRegistroActionPerformed
    public void limpiarTextos() {
        txtbuscado.setText("");
        tipoEstatus.clearSelection();
        //cbConcepto.setSelectedIndex(0);
            
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Efecto;
    private javax.swing.JButton btRegistro;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbCodigoMov;
    private javax.swing.JComboBox<String> cbNombreBanco;
    private javax.swing.JComboBox<String> cbNombreCliente;
    private javax.swing.JComboBox<String> cbTipoMoneda;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label23;
    private javax.swing.JLabel label24;
    private javax.swing.JLabel label25;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JPanel panel;
    private javax.swing.JRadioButton rbabono;
    private javax.swing.JRadioButton rbcargo;
    private javax.swing.JTable tablaMovimientos;
    private javax.swing.ButtonGroup tipoEstatus;
    private javax.swing.JLabel txtCodigoDocumento;
    private javax.swing.JTextField txtFactura;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNoDeposito;
    private javax.swing.JTextField txtValorDeposito;
    private javax.swing.JTextField txtbuscado;
    private javax.swing.JTextField txtvalor;
    // End of variables declaration//GEN-END:variables

}
