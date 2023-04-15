/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Seguridad.Vista;

import Seguridad.Controlador.clsAplicacion;
import Seguridad.Controlador.clsAplicacionPerfil;
import Seguridad.Controlador.clsPerfil;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author halld
 */
public class frmProcesoAplicacionPerfil extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmProcesoAplicacionPerfil
     */
    public frmProcesoAplicacionPerfil() {
        initComponents();
        llenadoDeTabla1();
        llenadoDeTabla2();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton7 = new javax.swing.JButton();
        rbInsertar = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        rbEditar = new javax.swing.JRadioButton();
        rbEliminar = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        rbImprimir = new javax.swing.JRadioButton();
        AsignarTodo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        AsignarUnaAp = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblApsAsignadas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblApsDisponibles = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        btnLimpiarPerfil = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdPerfil = new javax.swing.JTextField();
        txtNombrePerfil = new javax.swing.JTextField();
        btnBuscarPerfil = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Aplicacion Perfil");
        setVisible(true);

        jButton7.setText("Salir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbInsertar);
        rbInsertar.setText("Insertar");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Perfil Seleccionado");

        buttonGroup1.add(rbEditar);
        rbEditar.setText("Editar");

        buttonGroup1.add(rbEliminar);
        rbEliminar.setText("Eliminar");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Asignar");

        buttonGroup1.add(rbImprimir);
        rbImprimir.setText("Imprimir");

        AsignarTodo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AsignarTodo.setText(">>");
        AsignarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignarTodoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Permisos");

        AsignarUnaAp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AsignarUnaAp.setText(">");
        AsignarUnaAp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignarUnaApActionPerformed(evt);
            }
        });

        tblApsAsignadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Aplicaciones Asignadas"
            }
        ));
        jScrollPane3.setViewportView(tblApsAsignadas);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Quitar");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("<<");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tblApsDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Aplicaciones Disponibles"
            }
        ));
        jScrollPane4.setViewportView(tblApsDisponibles);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("<");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnLimpiarPerfil.setText("Limpia Perfil");
        btnLimpiarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPerfilActionPerformed(evt);
            }
        });

        jLabel2.setText("ID Perfil :");

        jLabel5.setText("Nombre :");

        btnBuscarPerfil.setText("Buscar Perfil");
        btnBuscarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPerfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscarPerfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(btnLimpiarPerfil))
                    .addComponent(txtNombrePerfil)
                    .addComponent(txtIdPerfil)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(56, 56, 56)))
                .addGap(291, 291, 291))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(244, 244, 244))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rbInsertar)
                            .addGap(18, 18, 18)
                            .addComponent(rbEditar)
                            .addGap(18, 18, 18)
                            .addComponent(rbEliminar)
                            .addGap(18, 18, 18)
                            .addComponent(rbImprimir)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AsignarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AsignarUnaAp, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel3)))
                        .addGap(65, 65, 65)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 461, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(txtIdPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombrePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnBuscarPerfil)
                                    .addComponent(btnLimpiarPerfil))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AsignarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AsignarUnaAp, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)))))
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbInsertar)
                            .addComponent(rbEditar)
                            .addComponent(rbEliminar)
                            .addComponent(rbImprimir))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(27, 27, 27))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void llenadoDeTabla1() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Aplicacion");
        modelo.addColumn("Nombre Aplicacion");
        clsAplicacion aplicacion = new clsAplicacion();
        List<clsAplicacion> listaAplicaciones = aplicacion.getListadoAplicaciones();
        tblApsDisponibles.setModel(modelo);
        String[] dato = new String[2];
        for (int i = 0; i < listaAplicaciones.size(); i++) {
            dato[0] = Integer.toString(listaAplicaciones.get(i).getIdAplicacion());
            dato[1] = listaAplicaciones.get(i).getNombreAplicacion();
            modelo.addRow(dato);
        }   
    }
    
    public void llenadoDeTabla2() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Aplicacion");
        modelo.addColumn("ID Perfil");
        modelo.addColumn("EDITAR");
        modelo.addColumn("INSERTAR");
        modelo.addColumn("ELIMINAR");
        modelo.addColumn("IMPRIMIR"); 
        clsAplicacionPerfil aplicacionPeril = new clsAplicacionPerfil();
        List<clsAplicacionPerfil> listadoPerfiles = aplicacionPeril.getListadoAplicaciones();
        tblApsAsignadas.setModel(modelo);
        String[] dato = new String[6];
        for (int i = 0; i < listadoPerfiles.size(); i++) {
            dato[0] = Integer.toString(listadoPerfiles.get(i).getIdAplicacion());
            dato[1] = Integer.toString(listadoPerfiles.get(i).getIdPerfil());
            dato[2] = listadoPerfiles.get(i).getEditarApPerfil();
            dato[3] = listadoPerfiles.get(i).getIngresarApPerfil();
            dato[4] = listadoPerfiles.get(i).getEliminarApPerfil();
            dato[5] = listadoPerfiles.get(i).getVerApPerfil();
            modelo.addRow(dato);
        }   
    }
    
    private void AsignarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarTodoActionPerformed
        // TODO add your handling code here:
        //REALIZADO POR MONICA GABRIELA PEREZ VELÁSQUEZ, 9959-21-1840
        String is=txtIdPerfil.getText();
        if(is.length()>0){
            if(rbInsertar.isSelected()||rbEditar.isSelected()||rbEliminar.isSelected()||rbImprimir.isSelected()){
                DefaultTableModel modeloOrigen = (DefaultTableModel)tblApsDisponibles.getModel(), modeloDestino = (DefaultTableModel)tblApsAsignadas.getModel();
                for (int i=0;i<tblApsDisponibles.getRowCount(); i++) {
                    Object fila [] = new Object [tblApsDisponibles.getColumnCount()];
                    for (int j=0; j<tblApsDisponibles.getColumnCount(); j++){
                        fila[j] = tblApsDisponibles.getValueAt(i,j);
                        String idAplicacion= tblApsDisponibles.getValueAt(i,j).toString();
                    }
                    String idAplicacion= tblApsDisponibles.getValueAt(i,0).toString();
                    clsAplicacionPerfil aplicacionPerfil = new clsAplicacionPerfil();
                    aplicacionPerfil.setIdAplicacion(Integer.parseInt(idAplicacion));
                    aplicacionPerfil.setIdPerfil(Integer.parseInt(txtIdPerfil.getText()));
                    if(rbInsertar.isSelected()){
                        aplicacionPerfil.setIngresarApPerfil("1");
                    }else{
                        aplicacionPerfil.setIngresarApPerfil("0");
                    }if(rbEditar.isSelected()){
                        aplicacionPerfil.setEditarApPerfil("1");
                    }else{
                        aplicacionPerfil.setEditarApPerfil("0");
                    }if(rbEliminar.isSelected()){
                        aplicacionPerfil.setEliminarApPerfil("1");
                    }else{
                        aplicacionPerfil.setEliminarApPerfil("0");
                    }if(rbImprimir.isSelected()){
                        aplicacionPerfil.setVerApPerfil("1");
                    }else{
                        aplicacionPerfil.setVerApPerfil("0");
                    }
                    aplicacionPerfil.setIngresarAplicacion(aplicacionPerfil);
                    JOptionPane.showMessageDialog(null, "Registro Ingresado\n","Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    modeloDestino.addRow(fila);
                    llenadoDeTabla2();
                }
            }else{
                JOptionPane.showMessageDialog(null,"Debe seleccionar por lo menos un permiso");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Debe ingresar el ID del Perfil que Desea buscar");
        }


    }//GEN-LAST:event_AsignarTodoActionPerformed

    private void AsignarUnaApActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignarUnaApActionPerformed
        // TODO add your handling code here:
        //Alan Abimael Galicia Ruano; 9959-21-3632
        String is=txtIdPerfil.getText();
        if(is.length()>0){
            if(rbInsertar.isSelected()||rbEditar.isSelected()||rbEliminar.isSelected()||rbImprimir.isSelected()){
                int FilaSeleccionada= tblApsDisponibles.getSelectedRow();
                if(FilaSeleccionada !=-1){
                    String idAplicacion, idPerfil=txtIdPerfil.getText();
                    idAplicacion= tblApsDisponibles.getValueAt(FilaSeleccionada,0).toString();
                    idPerfil= tblApsDisponibles.getValueAt(FilaSeleccionada,1).toString();

                    String datos[]={idAplicacion, idPerfil};
                    DefaultTableModel modeloAplicacionesAsignadas = (DefaultTableModel)tblApsAsignadas.getModel();
                    modeloAplicacionesAsignadas.addRow(datos);
                    clsAplicacionPerfil aplicacionPeril = new clsAplicacionPerfil();
                    aplicacionPeril.setIdAplicacion(Integer.parseInt(idAplicacion));
                    aplicacionPeril.setIdPerfil(Integer.parseInt(txtIdPerfil.getText()));
                    if(rbInsertar.isSelected()){
                        aplicacionPeril.setIngresarApPerfil("1");
                    }else{
                        aplicacionPeril.setIngresarApPerfil("0");
                    }if(rbEditar.isSelected()){
                        aplicacionPeril.setEditarApPerfil("1");
                    }else{
                        aplicacionPeril.setEditarApPerfil("0");
                    }if(rbEliminar.isSelected()){
                        aplicacionPeril.setEliminarApPerfil("1");
                    }else{
                        aplicacionPeril.setEliminarApPerfil("0");
                    }if(rbImprimir.isSelected()){
                        aplicacionPeril.setVerApPerfil("1");
                    }else{
                        aplicacionPeril.setVerApPerfil("0");
                    }
                    aplicacionPeril.setIngresarAplicacion(aplicacionPeril);
                    JOptionPane.showMessageDialog(null, "Registro Ingresado\n", 
                                "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    llenadoDeTabla2();
                }else{
                    JOptionPane.showMessageDialog(null,"Debe seleccionar un registro");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Debe seleccionar al menos un permiso");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Debe ingresar el ID del Perfil");
        }
    }//GEN-LAST:event_AsignarUnaApActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnLimpiarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPerfilActionPerformed
        // TODO add your handling code here:
        limpiarTextos();
    }//GEN-LAST:event_btnLimpiarPerfilActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    
    private void btnBuscarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPerfilActionPerformed
        // TODO add your handling code here:
       clsPerfil perfil = new clsPerfil();
        //usuario.setNombreUsuario(txtbuscado.getText());
        perfil.setIdPerfil(Integer.parseInt(txtIdPerfil.getText()));
        perfil = perfil.getBuscarInformacionPerfilPorId(perfil);
        System.out.println("Perfil retornado:" + perfil);
        txtNombrePerfil.setText(perfil.getNombrePerfil());
        clsAplicacionPerfil aplicacionPerfil = new clsAplicacionPerfil();
        aplicacionPerfil.setIdPerfil(Integer.parseInt(txtIdPerfil.getText()));
        aplicacionPerfil = aplicacionPerfil.getBuscarInformacionAplicacionPerfilPorId(aplicacionPerfil);
        DefaultTableModel model = (DefaultTableModel) tblApsAsignadas.getModel();
        String[] dato = new String[6];
        if (aplicacionPerfil != null) {
            // Rellenar el array con los datos del usuario
            dato[0] = Integer.toString(aplicacionPerfil.getIdAplicacion());
            dato[1] = Integer.toString(aplicacionPerfil.getIdPerfil());
            dato[2] = aplicacionPerfil.getEditarApPerfil();
            dato[3] = aplicacionPerfil.getIngresarApPerfil();
            dato[4] = aplicacionPerfil.getEliminarApPerfil();
            dato[5] = aplicacionPerfil.getVerApPerfil();
            // Agregar el array a la tabla
            model.addRow(dato);
        }else{
            JOptionPane.showMessageDialog(null, "El perfil no existe.");
        }
        //corregir bitácora
        
        /*int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "QRY");*/
    }  
    
    public void limpiarTextos()
    {
        txtNombrePerfil.setText("");
        txtIdPerfil.setText("");
    }//GEN-LAST:event_btnBuscarPerfilActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AsignarTodo;
    private javax.swing.JButton AsignarUnaAp;
    private javax.swing.JButton btnBuscarPerfil;
    private javax.swing.JButton btnLimpiarPerfil;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton rbEditar;
    private javax.swing.JRadioButton rbEliminar;
    private javax.swing.JRadioButton rbImprimir;
    private javax.swing.JRadioButton rbInsertar;
    private javax.swing.JTable tblApsAsignadas;
    private javax.swing.JTable tblApsDisponibles;
    private javax.swing.JTextField txtIdPerfil;
    private javax.swing.JTextField txtNombrePerfil;
    // End of variables declaration//GEN-END:variables
}
