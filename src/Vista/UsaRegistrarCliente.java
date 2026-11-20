/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Cliente;
import Modelo.Contacto;
import Modelo.Empresa;
import Modelo.PersonaNatural;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author SamuelOT
 */
public class UsaRegistrarCliente extends javax.swing.JFrame {
    
    private ArrayList<Cliente> losClientes = new ArrayList<>();
    
    public ArrayList<Cliente> registrarCliente(ArrayList<Cliente> losClientes){
        String numeroIdentificacion;
        String nombre;
        String nombreCiudad;
        
        boolean entradaInvalida = false;
        String msgEntradaInvalida = "¡Operación fallida!.\nEntrada inválida.";
        
        numeroIdentificacion = jTextFieldNumeroIdentificacion.getText();        
        if(numeroIdentificacion.isEmpty() || numeroIdentificacion.isBlank()){
            entradaInvalida = true;           
            msgEntradaInvalida += "\n Numero Identificacion: vacio, Obligatorio";
        }
        
        nombre = jTextFieldNombre.getText();        
        if(nombre.isEmpty() || nombre.isBlank()){
            entradaInvalida = true;           
            msgEntradaInvalida += "\n Nombre: vacio, Obligatorio";
        }
        
        nombreCiudad = jTextFieldNombreCiudad.getText();        
        if(nombreCiudad.isEmpty() || nombreCiudad.isBlank()){
            entradaInvalida = true;           
            msgEntradaInvalida += "\n Nombre Ciudad: vacio, Obligatorio";
        }
        
        String tipoCliente = jComboBoxTipo.getSelectedItem().toString().toUpperCase();
        
        String numeroTelefono = null;
        String correo = null;
        
        Contacto suContacto;
        String nombreCompleto = null;
        String cargo = null;
        String telefono = null;
        String correoElectronico = null;
        
        switch(tipoCliente){
            case "PERSONA NATURAL":
                numeroTelefono = jTextFieldNumeroTelefonoPer.getText();        
                if(numeroTelefono.isEmpty() || numeroTelefono.isBlank()){
                    entradaInvalida = true;           
                    msgEntradaInvalida += "\n Numero Telefono: vacio, Obligatorio";
                }
                    
                correo = jTextFieldCorreoElectronicoPer.getText();        
                if(correo.isEmpty() || correo.isBlank()){
                    entradaInvalida = true;           
                    msgEntradaInvalida += "\n Correo: vacio, Obligatorio";
                }
                break;
            case "EMPRESA":
                nombreCompleto = jTextFieldNombreContacto.getText();        
                if(nombreCompleto.isEmpty() || nombreCompleto.isBlank()){
                    entradaInvalida = true;           
                    msgEntradaInvalida += "\n Nombre Completo: vacio, Obligatorio";
                }
                
                cargo = jTextFieldCargo.getText();        
                if(cargo.isEmpty() || cargo.isBlank()){
                    entradaInvalida = true;           
                    msgEntradaInvalida += "\n Cargo: vacio, Obligatorio";
                }
                
                telefono = jTextFieldNumeroTelefonicoEmp.getText();        
                if(telefono.isEmpty() || telefono.isBlank()){
                    entradaInvalida = true;           
                    msgEntradaInvalida += "\n Numero Telefono: vacio, Obligatorio";
                }
                correoElectronico = jTextFieldCorreoElectronicoEmp.getText();        
                if(correoElectronico.isEmpty() || correoElectronico.isBlank()){
                    entradaInvalida = true;           
                    msgEntradaInvalida += "\n Correo: vacio, Obligatorio";
                }
                break; 
        }
        if(entradaInvalida){
            JOptionPane.showMessageDialog(null, msgEntradaInvalida, "REGISTRO", JOptionPane.ERROR_MESSAGE);
        }else{
            Cliente objeto = null;
            switch(tipoCliente){
                case "PERSONA NATURAL":
                    objeto = new PersonaNatural(numeroTelefono,  correo,  numeroIdentificacion,  nombre,  nombreCiudad);
                    break;
                    
                case "EMPRESA":
                    suContacto = new Contacto (nombreCompleto,  cargo,  telefono, correoElectronico);
                    objeto = new Empresa (suContacto, numeroIdentificacion, nombre, nombreCiudad);
            }
            losClientes.add(objeto);
            JOptionPane.showMessageDialog(null, "¡Operación exitosa!.", "REGISTRO", JOptionPane.INFORMATION_MESSAGE);
        }
            
        
        
        return losClientes;
        
    }
    
    public void inicializarEntradasRegistro(){
        jTextFieldNumeroIdentificacion.setText("");
        jTextFieldNombre.setText("");
        jTextFieldNombreCiudad.setText("");
        jComboBoxTipo.setSelectedIndex(0);
        jTextFieldNumeroTelefonoPer.setText("");
        jTextFieldCorreoElectronicoPer.setText("");
        jTextFieldNombreContacto.setText("");
        jTextFieldCargo.setText("");
        jTextFieldNumeroTelefonicoEmp.setText("");
        jTextFieldCorreoElectronicoEmp.setText("");
    }

    /**
     * Creates new form UsaRegistrarCliente
     */
    public UsaRegistrarCliente() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldNumeroIdentificacion = new javax.swing.JTextField();
        jTextFieldNombreCiudad = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldNumeroTelefonoPer = new javax.swing.JTextField();
        jTextFieldNombreContacto = new javax.swing.JTextField();
        jTextFieldCargo = new javax.swing.JTextField();
        jTextFieldNumeroTelefonicoEmp = new javax.swing.JTextField();
        jTextFieldCorreoElectronicoEmp = new javax.swing.JTextField();
        jTextFieldCorreoElectronicoPer = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jButtonRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Registrar Cliente");

        jLabel2.setText("Numero Identificacion:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Tipo Cliente:");

        jLabel5.setText("Nombre Ciudad:");

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Persona Natural", "Empresa" }));
        jComboBoxTipo.addActionListener(this::jComboBoxTipoActionPerformed);

        jLabel6.setText("Numero Telefono:");

        jLabel7.setText("Correo Electronico:");

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        jLabel8.setText("Nombre Contacto:");

        jLabel9.setText("Cargo:");

        jLabel10.setText("Numero Telefono:");

        jLabel11.setText("Correo Electronico:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Persona Natural");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Empresa");

        jButtonSalir.setBackground(new java.awt.Color(255, 102, 102));
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(this::jButtonSalirActionPerformed);

        jButtonRegistrar.setBackground(new java.awt.Color(204, 255, 204));
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(this::jButtonRegistrarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldNumeroIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldNombreCiudad))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNumeroTelefonoPer, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCorreoElectronicoPer, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel13)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextFieldNombreContacto))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldCargo))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldNumeroTelefonicoEmp))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldCorreoElectronicoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonSalir)))
                                .addContainerGap(12, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel12))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNumeroIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombreCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldNumeroTelefonoPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldCorreoElectronicoPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldNumeroTelefonicoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldCorreoElectronicoEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalir)
                    .addComponent(jButtonRegistrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoActionPerformed
        if(jComboBoxTipo.getSelectedItem().equals("Persona Natural")){
            jTextFieldNumeroTelefonoPer.setEnabled(false); 
            jTextFieldCorreoElectronicoPer.setEnabled(false);
            jTextFieldNombreContacto.setEnabled(true);  
            jTextFieldCargo.setEnabled(true);
            jTextFieldNumeroTelefonicoEmp.setEnabled(true);
            jTextFieldCorreoElectronicoEmp.setEnabled(true);
        } else{
            jTextFieldNumeroTelefonoPer.setEnabled(true); 
            jTextFieldCorreoElectronicoPer.setEnabled(true);
            jTextFieldNombreContacto.setEnabled(false);  
            jTextFieldCargo.setEnabled(false);
            jTextFieldNumeroTelefonicoEmp.setEnabled(false);
            jTextFieldCorreoElectronicoEmp.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxTipoActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        JOptionPane.showMessageDialog(null, "Saliendo del Sistema");
        inicializarEntradasRegistro();
        System.exit(0);                   
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        losClientes = registrarCliente(losClientes);
        inicializarEntradasRegistro();
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new UsaRegistrarCliente().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldCargo;
    private javax.swing.JTextField jTextFieldCorreoElectronicoEmp;
    private javax.swing.JTextField jTextFieldCorreoElectronicoPer;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNombreCiudad;
    private javax.swing.JTextField jTextFieldNombreContacto;
    private javax.swing.JTextField jTextFieldNumeroIdentificacion;
    private javax.swing.JTextField jTextFieldNumeroTelefonicoEmp;
    private javax.swing.JTextField jTextFieldNumeroTelefonoPer;
    // End of variables declaration//GEN-END:variables
}
