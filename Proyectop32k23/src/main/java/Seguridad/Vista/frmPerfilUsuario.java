/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Vista;

/**
 *
 * @author Javier
 */
public class frmPerfilUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmPerfilUsuario
     */
    public frmPerfilUsuario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEditar = new javax.swing.JButton();
        jLabelAsignar = new javax.swing.JLabel();
        jLabelQuitar = new javax.swing.JLabel();
        btnAsignarTodo = new javax.swing.JButton();
        btnAsignar = new javax.swing.JButton();
        jLabelUsuarioSeleccionado = new javax.swing.JLabel();
        btnQuitarTodo = new javax.swing.JButton();
        jLabelPerfilAsignado = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblperfilesdisponibles = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblperfilesasignados = new javax.swing.JTextArea();
        jLabelPerfilesDisp = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        cbUsuarios = new javax.swing.JComboBox<>();

        setTitle("Mantenimiento Perfil Usuario");

        btnEditar.setText("Editar");

        jLabelAsignar.setText("Asignar");

        jLabelQuitar.setText("Quitar");

        btnAsignarTodo.setText(">>");

        btnAsignar.setText(">");

        jLabelUsuarioSeleccionado.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabelUsuarioSeleccionado.setText("Usuario Seleccionado ");

        btnQuitarTodo.setText("<<");

        jLabelPerfilAsignado.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabelPerfilAsignado.setText("Perfiles Asignados");

        tblperfilesdisponibles.setColumns(20);
        tblperfilesdisponibles.setRows(5);
        tblperfilesdisponibles.setText("Cajero\nContador\nAdministrador\nVendedor");
        jScrollPane2.setViewportView(tblperfilesdisponibles);

        tblperfilesasignados.setColumns(20);
        tblperfilesasignados.setRows(5);
        jScrollPane1.setViewportView(tblperfilesasignados);

        jLabelPerfilesDisp.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabelPerfilesDisp.setText("Perfiles Disponibles");

        btnQuitar.setText("<");

        cbUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario 1", "Usuario 2", "Usuario 3", "Usuario 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar)
                            .addComponent(btnQuitarTodo)
                            .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelQuitar)
                                .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAsignarTodo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelAsignar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelPerfilAsignado)
                        .addGap(89, 89, 89))))
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabelUsuarioSeleccionado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelPerfilesDisp)
                        .addGap(477, 477, 477))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(315, 315, 315))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelUsuarioSeleccionado)
                .addGap(18, 18, 18)
                .addComponent(cbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPerfilAsignado)
                                .addGap(25, 25, 25)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPerfilesDisp)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(36, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelAsignar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAsignarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelQuitar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnQuitarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnAsignarTodo;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnQuitarTodo;
    private javax.swing.JComboBox<String> cbUsuarios;
    private javax.swing.JLabel jLabelAsignar;
    private javax.swing.JLabel jLabelPerfilAsignado;
    private javax.swing.JLabel jLabelPerfilesDisp;
    private javax.swing.JLabel jLabelQuitar;
    private javax.swing.JLabel jLabelUsuarioSeleccionado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea tblperfilesasignados;
    private javax.swing.JTextArea tblperfilesdisponibles;
    // End of variables declaration//GEN-END:variables
}
