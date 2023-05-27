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
import javax.swing.JOptionPane;
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
        comboBoxPerfilUsuario.addActionListener((ActionEvent event) -> {
            // Obtener el usuario seleccionado en el combo box
            int resultadoBitacora=0;
                    clsBitacora bitacoraRegistro = new clsBitacora();
                    resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "QRY");
            String usuario = comboBoxPerfilUsuario.getSelectedItem().toString();
            
            // Cargar la tabla con los perfiles asociados al usuario seleccionado
            cargarTabla2(usuario);
            
            
            
            // Repintar la tabla
            jTablePerfilUsuarioAsignado.repaint();
        });
        
        //Boton asignar trabajado por Maria Jose Veliz
btnAsignarPerfilUsuario.addActionListener((ActionEvent e) -> {
    // Obtener el perfil seleccionado en la tabla 1
    int filaSeleccionada = jTablePerfilUsuarioDisponible.getSelectedRow();
    if (filaSeleccionada == -1) {
        // No se ha seleccionado ninguna fila
        return;

    }
    String pernombre = jTablePerfilUsuarioDisponible.getValueAt(filaSeleccionada, 0).toString();

    // Mostrar ventana de confirmación
    Object[] options = { "Sí", "No" };
    int respuesta = JOptionPane.showOptionDialog(null, "¿Seguro que quieres asignar este perfil?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    if (respuesta == JOptionPane.YES_OPTION) {
        // Continuar con la acción del botón
        clsPerfilUsuario perfilUsuario = new clsPerfilUsuario();
        String usuario = comboBoxPerfilUsuario.getSelectedItem().toString();
        DefaultTableModel modelo = (DefaultTableModel) jTablePerfilUsuarioAsignado.getModel();
        perfilUsuario.asignarunPerfilesUsuario(pernombre, usuario);

        int resultadoBitacora = 0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "INS");
        cargarTabla2(usuario);
    } else {
        // No hacer nada
        return;
    }
});



         //Boton Eliminar trabajado por Carlos Hernandez
        btnEliminarPerfilUsuario.addActionListener((ActionEvent event) -> {
    // Obtener el perfil seleccionado en la tabla
    int filaSeleccionada = jTablePerfilUsuarioAsignado.getSelectedRow();
    String pernombre = jTablePerfilUsuarioAsignado.getValueAt(filaSeleccionada, 0).toString();
    if (filaSeleccionada == -1) {
                // No se ha seleccionado ninguna fila
                return;
                
            }   
    Object[] options = { "Sí", "No" };
    int respuesta = JOptionPane.showOptionDialog(null, "¿Seguro que quieres eliminar este perfil?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    if (respuesta == JOptionPane.YES_OPTION) {
            clsPerfilUsuario perfilUsuario = new clsPerfilUsuario();
            String usuario = comboBoxPerfilUsuario.getSelectedItem().toString();
           perfilUsuario.eliminarunPerfilesUsuario(pernombre, usuario);
         
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora (clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "DEL");
          cargarTabla2(usuario);
          } else {
        // No hacer nada
        return;
    }
});
        

        //Boton Eliminar todo trabajado por Carlos Sandoval
        btnEliminarTodoPerfilUsuario.addActionListener((ActionEvent event) -> {
            Object[] options = { "Sí", "No" };
    int respuesta = JOptionPane.showOptionDialog(null, "¿Seguro que quieres eliminar todos los perfiles?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    if (respuesta == JOptionPane.YES_OPTION) {
     clsPerfilUsuario perfilUsuario = new clsPerfilUsuario();       
    String usuario = comboBoxPerfilUsuario.getSelectedItem().toString();
    DefaultTableModel modelo = (DefaultTableModel) jTablePerfilUsuarioAsignado.getModel();
    perfilUsuario.eliminarPerfilesUsuario(modelo, usuario);
    int resultadoBitacora=0;
                    clsBitacora bitacoraRegistro = new clsBitacora();
                    resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "DEL");
    cargarTabla2(usuario);
    } else {
        // No hacer nada
        return;
    }
        });
    

        btnAsignarTodoPerfilUsuario.addActionListener((ActionEvent event) -> {
            Object[] options = { "Sí", "No" };
    int respuesta = JOptionPane.showOptionDialog(null, "¿Seguro que quieres asignar todos los perfiles?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    if (respuesta == JOptionPane.YES_OPTION) {
         clsPerfilUsuario perfilUsuario = new clsPerfilUsuario();  
         String usuario = comboBoxPerfilUsuario.getSelectedItem().toString();
          DefaultTableModel modelo = (DefaultTableModel) jTablePerfilUsuarioDisponible.getModel();
         cargarTabla2(comboBoxPerfilUsuario.getSelectedItem().toString());
        jTablePerfilUsuarioAsignado.repaint();
          perfilUsuario.asignartodoPerfilesUsuario(modelo, usuario);

        int resultadoBitacora=0; 
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "INS");
    cargarTabla2(usuario);
    } else {
        // No hacer nada
        return;
    }
        });
    }
    
private void cargarComboBox() {
    clsPerfilUsuario perfilUsuario = new clsPerfilUsuario();
    ArrayList<String> nombresUsuarios = perfilUsuario.obtenerNombresUsuarios();

    nombresUsuarios.forEach(nombreUsuario -> {
        comboBoxPerfilUsuario.addItem(nombreUsuario);
        });
}

private void cargarTabla() {
        clsPerfilUsuario perfilUsuario = new clsPerfilUsuario();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Perfiles Disponibles");
        jTablePerfilUsuarioDisponible.setModel(modelo);
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
    jTablePerfilUsuarioAsignado.setModel(modelo);
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
        jScrollPanePerfilUsuario1 = new javax.swing.JScrollPane();
        jTablePerfilUsuarioDisponible = new javax.swing.JTable();
        jScrollPanePerfilUsuario2 = new javax.swing.JScrollPane();
        jTablePerfilUsuarioAsignado = new javax.swing.JTable();
        comboBoxPerfilUsuario = new javax.swing.JComboBox<>();
        btnAsignarPerfilUsuario = new javax.swing.JButton();
        btnAsignarTodoPerfilUsuario = new javax.swing.JButton();
        btnEliminarTodoPerfilUsuario = new javax.swing.JButton();
        btnEliminarPerfilUsuario = new javax.swing.JButton();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Asignación Perfiles a Usuarios");
        setVisible(true);

        jTablePerfilUsuarioDisponible.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPanePerfilUsuario1.setViewportView(jTablePerfilUsuarioDisponible);

        jTablePerfilUsuarioAsignado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPanePerfilUsuario2.setViewportView(jTablePerfilUsuarioAsignado);

        comboBoxPerfilUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoje un Usuario" }));

        btnAsignarPerfilUsuario.setText("Asignar");
        btnAsignarPerfilUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarPerfilUsuarioActionPerformed(evt);
            }
        });

        btnAsignarTodoPerfilUsuario.setText("Asignar Todo");

        btnEliminarTodoPerfilUsuario.setText("Eliminar Todo");

        btnEliminarPerfilUsuario.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jScrollPanePerfilUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAsignarPerfilUsuario)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarTodoPerfilUsuario)
                            .addComponent(btnAsignarTodoPerfilUsuario))
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEliminarPerfilUsuario)
                        .addGap(91, 91, 91)))
                .addComponent(jScrollPanePerfilUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
            .addGroup(layout.createSequentialGroup()
                .addGap(446, 446, 446)
                .addComponent(comboBoxPerfilUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(comboBoxPerfilUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPanePerfilUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPanePerfilUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(btnAsignarPerfilUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(btnAsignarTodoPerfilUsuario)
                        .addGap(50, 50, 50)
                        .addComponent(btnEliminarPerfilUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarTodoPerfilUsuario)))
                .addGap(363, 363, 363))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignarPerfilUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarPerfilUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAsignarPerfilUsuarioActionPerformed
 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarPerfilUsuario;
    private javax.swing.JButton btnAsignarTodoPerfilUsuario;
    private javax.swing.JButton btnEliminarPerfilUsuario;
    private javax.swing.JButton btnEliminarTodoPerfilUsuario;
    private javax.swing.JComboBox<String> comboBoxPerfilUsuario;
    private javax.swing.JScrollPane jScrollPanePerfilUsuario1;
    private javax.swing.JScrollPane jScrollPanePerfilUsuario2;
    private javax.swing.JTable jTablePerfilUsuarioAsignado;
    private javax.swing.JTable jTablePerfilUsuarioDisponible;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    // End of variables declaration//GEN-END:variables
}
