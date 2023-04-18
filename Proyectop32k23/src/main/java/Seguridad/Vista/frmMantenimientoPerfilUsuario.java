/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Carlos Emanuel Hernandez Garcia
//9959-21-363
package Seguridad.Vista;

import Seguridad.Controlador.clsBitacora;
import Seguridad.Controlador.clsPerfilUsuario;
import Seguridad.Controlador.clsUsuarioConectado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author visitante
 */


public class frmMantenimientoPerfilUsuario extends javax.swing.JInternalFrame {

int codigoAplicacion = 41;
    




    public frmMantenimientoPerfilUsuario() {
        initComponents();
        cargarTabla();
        cargarComboBox();

        
        //ComboBox trabajado por Carlos Hernandez y Carlos Sandoval
        comboBox.addActionListener((ActionEvent event) -> {
            // Obtener el usuario seleccionado en el combo box
            int resultadoBitacora=0;
                    clsBitacora bitacoraRegistro = new clsBitacora();
                    resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "QRY");
            String usuario = comboBox.getSelectedItem().toString();
            
            // Cargar la tabla con los perfiles asociados al usuario seleccionado
            cargarTabla2(usuario);
            
            
            
            // Repintar la tabla
            jTable2.repaint();
        });
        
        //Boton asignar trabajado por Maria Jose Veliz
        btnAsignar.addActionListener((ActionEvent e) -> {
            // Obtener el perfil seleccionado en la tabla 1
            int filaSeleccionada = jTable1.getSelectedRow();
            if (filaSeleccionada == -1) {
                // No se ha seleccionado ninguna fila
                return;
                
            }
            String pernombre = jTable1.getValueAt(filaSeleccionada, 0).toString();
            
            clsPerfilUsuario perfilUsuario = new clsPerfilUsuario();
            String usuario = comboBox.getSelectedItem().toString();
            DefaultTableModel modelo  = (DefaultTableModel) jTable2.getModel();
           perfilUsuario.asignarunPerfilesUsuario(pernombre, usuario);
         
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora (clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "INSERT");
          cargarTabla2(usuario);
        });
        
        //Boton Eliminar trabajado por Carlos Hernandez
 
        btnEliminar.addActionListener((ActionEvent event) -> {
    // Obtener el perfil seleccionado en la tabla
    int filaSeleccionada = jTable2.getSelectedRow();
    String pernombre = jTable2.getValueAt(filaSeleccionada, 0).toString();
    
    //ingreso la funcion de Bitacora
    int resultadoBitacora=0;
    clsBitacora bitacoraRegistro = new clsBitacora();
    resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "DEL");
    
    try {
        // Conectar a la base de datos
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC", "UsuPrueba", "123456");
        
        // Obtener el perid del perfil seleccionado
        Statement stmt = con.createStatement();
        String sql = "SELECT perid FROM tbl_perfil WHERE pernombre='" + pernombre + "'";
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        int perid = rs.getInt("perid");
        rs.close();
        stmt.close();
        
        // Obtener el usuid del usuario seleccionado en el combo box
        String usuario = comboBox.getSelectedItem().toString();
        stmt = con.createStatement();
        sql = "SELECT usuid FROM tbl_usuario WHERE usunombre='" + usuario + "'";
        rs = stmt.executeQuery(sql);
        rs.next();
        int usuid = rs.getInt("usuid");
        rs.close();
        stmt.close();
        
        // Eliminar el registro de la tabla tbl_perfilusuario
        PreparedStatement pstmt = con.prepareStatement("DELETE FROM tbl_perfilusuario WHERE usuid=? AND perid=?");
        pstmt.setInt(1, usuid);
        pstmt.setInt(2, perid);
        pstmt.executeUpdate();
        pstmt.close();
        
        // Cargar la tabla nuevamente para reflejar los cambios
        cargarTabla2(usuario);
        jTable2.repaint();
        
        // Cerrar la conexión
        con.close();
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
});
        
        //Boton asignar Todo trabajado por Meyglin Rosales 
        btnAsignarTodo.addActionListener((ActionEvent event) -> {
        clsPerfilUsuario perfilUsuario = new clsPerfilUsuario();  
        String usuario = comboBox.getSelectedItem().toString();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        cargarTabla2(comboBox.getSelectedItem().toString());
        jTable2.repaint();
        perfilUsuario.asignartodoPerfilesUsuario(modelo, usuario);
        
        int resultadoBitacora=0; 
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "INS");
    cargarTabla2(usuario);
        });
        

        //Boton Eliminar todo trabajado por Carlos Sandoval
        btnEliminarTodo.addActionListener((ActionEvent event) -> {
     clsPerfilUsuario perfilUsuario = new clsPerfilUsuario();       
    String usuario = comboBox.getSelectedItem().toString();
    DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
    perfilUsuario.eliminarPerfilesUsuario(modelo, usuario);
    int resultadoBitacora=0;
                    clsBitacora bitacoraRegistro = new clsBitacora();
                    resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "DEL");
    cargarTabla2(usuario);
        });
    

    }
    
private void cargarComboBox() {
    clsPerfilUsuario perfilUsuario = new clsPerfilUsuario();
    ArrayList<String> nombresUsuarios = perfilUsuario.obtenerNombresUsuarios();

    nombresUsuarios.forEach(nombreUsuario -> {
        comboBox.addItem(nombreUsuario);
        });
}

private void cargarTabla() {
        clsPerfilUsuario perfilUsuario = new clsPerfilUsuario();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Perfiles Disponibles");
        jTable1.setModel(modelo);
        perfilUsuario.cargarTabla(modelo);
    }





public void cargarTabla2(String usuario) {
    clsPerfilUsuario perfilUsuario = new clsPerfilUsuario();
    ArrayList<String> perfiles = perfilUsuario.obtenerPerfilesUsuario(usuario);
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("Perfiles Asignados");
    perfiles.forEach(perfil -> {
        Object[] fila = new Object[1];
        fila[0] = perfil;
        modelo.addRow(fila);
    });
    jTable2.setModel(modelo);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        comboBox = new javax.swing.JComboBox<>();
        btnAsignar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAsignarTodo = new javax.swing.JButton();
        btnEliminarTodo = new javax.swing.JButton();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento Perfiles");
        setVisible(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoje un Usuario" }));

        btnAsignar.setText("Asignar");
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAsignarTodo.setText("Asignar Todo");
        btnAsignarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarTodoActionPerformed(evt);
            }
        });

        btnEliminarTodo.setText("Eliminar Todo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()

                        .addGap(92, 92, 92)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)

                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEliminarTodo)
                                    .addComponent(btnAsignarTodo))
                                .addGap(79, 79, 79))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)))))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(btnAsignar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAsignarTodo)
                        .addGap(38, 38, 38)
                        .addComponent(btnEliminar)
                        .addGap(30, 30, 30)
                        .addComponent(btnEliminarTodo)))
                .addContainerGap(236, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarTodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAsignarTodoActionPerformed
 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnAsignarTodo;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarTodo;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    // End of variables declaration//GEN-END:variables
}
