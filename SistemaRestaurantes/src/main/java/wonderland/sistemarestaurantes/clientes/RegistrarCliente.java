/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes.clientes;

import wonderland.sistemarestaurantes.utils.FontManager;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantesdominio.dtos.NuevoClienteFrecuenteDTO;
import wonderland.sistemarestaurantesnegocio.IClientesBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author Dana Chavez
 */
public class RegistrarCliente extends javax.swing.JFrame {
    
    private IClientesBO clientesBO;
    private ControlPresentacion control;
    private static final Logger LOG = Logger.getLogger(RegistrarCliente.class.getName());
    FontManager fontManager = new FontManager();
 
    /**
     * Creates new form ListaClientes
     */

    public RegistrarCliente(ControlPresentacion control, IClientesBO clientesBO) {
        this.control = control;
        this.clientesBO = clientesBO;
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void registrar(){        
        String nombre = this.jTextFieldNombres.getText();
        String apellidoPaterno = this.jTextFieldApellidoPaterno.getText();
        String apellidoMaterno = this.jTextFieldApellidoMaterno.getText();
        String correoElectronico = this.jTextFieldCorreoElectronico.getText();
        String telefono = this.jTextFieldTelefono.getText();
        
        NuevoClienteFrecuenteDTO nuevoCliente = new NuevoClienteFrecuenteDTO(nombre, apellidoPaterno, apellidoMaterno, correoElectronico, telefono);
        
        try {
            this.clientesBO.registrarCliente(nuevoCliente);
            JOptionPane.showMessageDialog(this, "Se registro el cliente con exito","Informacion", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarFormulario();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Informacion", JOptionPane.ERROR_MESSAGE);
            LOG.severe("No fue posible registrar el cliente" + ex.getMessage());
        }     
    }
    
    public void limpiarFormulario(){
        this.jTextFieldNombres.setText("    Nombre");
        this.jTextFieldApellidoPaterno.setText("    Apellido Paterno");
        this.jTextFieldApellidoMaterno.setText("    Apellido Materno");
        this.jTextFieldCorreoElectronico.setText("    Correo Electronico");
        this.jTextFieldTelefono.setText("    Telefono");
        
    }
    
    public void mostrar(){
        setVisible(true);
    }
    
    public void cerrar(){
        setVisible(false);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jButtonRegistrar = new javax.swing.JButton();
        jTextFieldApellidoMaterno = new javax.swing.JTextField();
        jTextFieldNombres = new javax.swing.JTextField();
        jTextFieldCorreoElectronico = new javax.swing.JTextField();
        jTextFieldApellidoPaterno = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jButtonAnterior = new javax.swing.JButton();
        jLabelClientesFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BotonRegistrar.png"))); // NOI18N
        jButtonRegistrar.setBorder(null);
        jButtonRegistrar.setContentAreaFilled(false);
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 590, 230, 40));

        jTextFieldApellidoMaterno.setBackground(new java.awt.Color(29, 39, 56));
        jTextFieldApellidoMaterno.setFont(fontManager.getNunitoBold(16f));
        jTextFieldApellidoMaterno.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldApellidoMaterno.setText("    Apellido Materno");
        jTextFieldApellidoMaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldApellidoMaterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldApellidoMaternoMousePressed(evt);
            }
        });
        jTextFieldApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidoMaternoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, 227, 40));

        jTextFieldNombres.setBackground(new java.awt.Color(29, 39, 56));
        jTextFieldNombres.setFont(fontManager.getNunitoBold(16f));
        jTextFieldNombres.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNombres.setText("    Nombre");
        jTextFieldNombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldNombres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldNombresMousePressed(evt);
            }
        });
        jTextFieldNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombresActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, 227, 40));

        jTextFieldCorreoElectronico.setBackground(new java.awt.Color(29, 39, 56));
        jTextFieldCorreoElectronico.setFont(fontManager.getNunitoBold(16f));
        jTextFieldCorreoElectronico.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldCorreoElectronico.setText("    Correo Electronico");
        jTextFieldCorreoElectronico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldCorreoElectronico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldCorreoElectronicoMousePressed(evt);
            }
        });
        jTextFieldCorreoElectronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCorreoElectronicoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, 227, 40));

        jTextFieldApellidoPaterno.setBackground(new java.awt.Color(29, 39, 56));
        jTextFieldApellidoPaterno.setFont(fontManager.getNunitoBold(16f));
        jTextFieldApellidoPaterno.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldApellidoPaterno.setText("    Apellido Paterno");
        jTextFieldApellidoPaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldApellidoPaterno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldApellidoPaternoMousePressed(evt);
            }
        });
        jTextFieldApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidoPaternoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, 227, 40));

        jTextFieldTelefono.setBackground(new java.awt.Color(29, 39, 56));
        jTextFieldTelefono.setFont(fontManager.getNunitoBold(16f));
        jTextFieldTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldTelefono.setText("    Telefono");
        jTextFieldTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldTelefonoMousePressed(evt);
            }
        });
        jTextFieldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 470, 227, 40));

        jButtonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BotonAnterior.png"))); // NOI18N
        jButtonAnterior.setContentAreaFilled(false);
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, -1, -1));

        jLabelClientesFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoRegistrarCliente.png"))); // NOI18N
        getContentPane().add(jLabelClientesFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidoMaternoActionPerformed

    private void jTextFieldCorreoElectronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCorreoElectronicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCorreoElectronicoActionPerformed

    private void jTextFieldApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidoPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidoPaternoActionPerformed

    private void jTextFieldTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelefonoActionPerformed

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        cerrar();
        control.mostrarListaClientes();
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        registrar();
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jTextFieldNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombresActionPerformed

    private void jTextFieldNombresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldNombresMousePressed
        if(jTextFieldNombres.getText().equals("    Nombre")){
            jTextFieldNombres.setText("");
        } 
        if(jTextFieldApellidoPaterno.getText().isEmpty()){
             jTextFieldApellidoPaterno.setText("    Apellido Paterno");
        }  
        if(jTextFieldApellidoMaterno.getText().isEmpty()){
             jTextFieldApellidoMaterno.setText("    Apellido Materno");
        }  
        if(jTextFieldTelefono.getText().isEmpty()){
             jTextFieldTelefono.setText("    Telefono");
        }  
        if(jTextFieldCorreoElectronico.getText().isEmpty()){
             jTextFieldCorreoElectronico.setText("    Correo Electronico");
        }
    }//GEN-LAST:event_jTextFieldNombresMousePressed

    private void jTextFieldApellidoPaternoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldApellidoPaternoMousePressed
        if(jTextFieldNombres.getText().isEmpty()){
            jTextFieldNombres.setText("    Nombre");
        } 
        if(jTextFieldApellidoPaterno.getText().equals("    Apellido Paterno")){
             jTextFieldApellidoPaterno.setText("");
        }  
        if(jTextFieldApellidoMaterno.getText().isEmpty()){
             jTextFieldApellidoMaterno.setText("    Apellido Materno");
        }  
        if(jTextFieldTelefono.getText().isEmpty()){
             jTextFieldTelefono.setText("    Telefono");
        }  
        if(jTextFieldCorreoElectronico.getText().isEmpty()){
             jTextFieldCorreoElectronico.setText("    Correo Electronico");
        }
    }//GEN-LAST:event_jTextFieldApellidoPaternoMousePressed

    private void jTextFieldApellidoMaternoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldApellidoMaternoMousePressed
        if(jTextFieldNombres.getText().isEmpty()){
            jTextFieldNombres.setText("    Nombre");
        } 
        if(jTextFieldApellidoPaterno.getText().isEmpty()){
             jTextFieldApellidoPaterno.setText("    Apellido Paterno");
        }  
        if(jTextFieldApellidoMaterno.getText().equals("    Apellido Materno")){
             jTextFieldApellidoMaterno.setText("");
        }  
        if(jTextFieldTelefono.getText().isEmpty()){
             jTextFieldTelefono.setText("    Telefono");
        }  
        if(jTextFieldCorreoElectronico.getText().isEmpty()){
             jTextFieldCorreoElectronico.setText("    Correo Electronico");
        }
    }//GEN-LAST:event_jTextFieldApellidoMaternoMousePressed

    private void jTextFieldTelefonoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoMousePressed
        if(jTextFieldNombres.getText().isEmpty()){
            jTextFieldNombres.setText("    Nombre");
        } 
        if(jTextFieldApellidoPaterno.getText().isEmpty()){
             jTextFieldApellidoPaterno.setText("    Apellido Paterno");
        }  
        if(jTextFieldApellidoMaterno.getText().isEmpty()){
             jTextFieldApellidoMaterno.setText("    Apellido Materno");
        }  
        if(jTextFieldTelefono.getText().equals("    Telefono")){
             jTextFieldTelefono.setText("");
        }  
        if(jTextFieldCorreoElectronico.getText().isEmpty()){
             jTextFieldCorreoElectronico.setText("    Correo Electronico");
        }
    }//GEN-LAST:event_jTextFieldTelefonoMousePressed

    private void jTextFieldCorreoElectronicoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldCorreoElectronicoMousePressed
        if(jTextFieldNombres.getText().isEmpty()){
            jTextFieldNombres.setText("    Nombre");
        } 
        if(jTextFieldApellidoPaterno.getText().isEmpty()){
             jTextFieldApellidoPaterno.setText("    Apellido Paterno");
        }  
        if(jTextFieldApellidoMaterno.getText().isEmpty()){
             jTextFieldApellidoMaterno.setText("    Apellido Materno");
        }  
        if(jTextFieldTelefono.getText().isEmpty()){
             jTextFieldTelefono.setText("    Telefono");
        }  
        if(jTextFieldCorreoElectronico.getText().equals("    Correo Electronico")){
             jTextFieldCorreoElectronico.setText("");
        }
    }//GEN-LAST:event_jTextFieldCorreoElectronicoMousePressed

    /**
     * @param args the command line arguments
     */

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JLabel jLabelClientesFondo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldApellidoMaterno;
    private javax.swing.JTextField jTextFieldApellidoPaterno;
    private javax.swing.JTextField jTextFieldCorreoElectronico;
    private javax.swing.JTextField jTextFieldNombres;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
