/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes.clientes;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantesdominio.dtos.NuevoClienteDTO;
import wonderland.sistemarestaurantesnegocio.IClientesBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
import wonderland.sistemarestaurantesnegocio.implementaciones.ClientesBO;

/**
 *
 * @author Dana Chavez
 */
public class RegistrarCliente extends javax.swing.JFrame {
    
    private IClientesBO clientesBO;
    private ControlPresentacion control;
    private static final Logger LOG = Logger.getLogger(RegistrarCliente.class.getName());
 
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
        
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(nombre, apellidoPaterno, apellidoMaterno, correoElectronico, telefono);
        
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
        jButtonAnterior = new javax.swing.JButton();
        jPanelColor = new javax.swing.JPanel();
        jPanelColorBlanco = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonRegistrar = new javax.swing.JButton();
        jTextFieldApellidoMaterno = new javax.swing.JTextField();
        jTextFieldNombres = new javax.swing.JTextField();
        jTextFieldCorreoElectronico = new javax.swing.JTextField();
        jTextFieldApellidoPaterno = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jLabelClientesFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonAnterior.png"))); // NOI18N
        jButtonAnterior.setContentAreaFilled(false);
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        jPanelColor.setBackground(new java.awt.Color(29, 39, 56));
        jPanelColor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelColorBlanco.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelColorBlancoLayout = new javax.swing.GroupLayout(jPanelColorBlanco);
        jPanelColorBlanco.setLayout(jPanelColorBlancoLayout);
        jPanelColorBlancoLayout.setHorizontalGroup(
            jPanelColorBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        jPanelColorBlancoLayout.setVerticalGroup(
            jPanelColorBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanelColor.add(jPanelColorBlanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 270, 10));

        jLabelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Registrar Cliente");
        jPanelColor.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonRegistrar.png"))); // NOI18N
        jButtonRegistrar.setContentAreaFilled(false);
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        jPanelColor.add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 210, 40));

        jTextFieldApellidoMaterno.setBackground(new java.awt.Color(29, 39, 56));
        jTextFieldApellidoMaterno.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextFieldApellidoMaterno.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldApellidoMaterno.setText("    Apellido Materno");
        jTextFieldApellidoMaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidoMaternoActionPerformed(evt);
            }
        });
        jPanelColor.add(jTextFieldApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 210, 40));

        jTextFieldNombres.setBackground(new java.awt.Color(29, 39, 56));
        jTextFieldNombres.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextFieldNombres.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNombres.setText("    Nombre");
        jTextFieldNombres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombresActionPerformed(evt);
            }
        });
        jPanelColor.add(jTextFieldNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 210, 40));

        jTextFieldCorreoElectronico.setBackground(new java.awt.Color(29, 39, 56));
        jTextFieldCorreoElectronico.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextFieldCorreoElectronico.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldCorreoElectronico.setText("    Correo Electronico");
        jTextFieldCorreoElectronico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldCorreoElectronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCorreoElectronicoActionPerformed(evt);
            }
        });
        jPanelColor.add(jTextFieldCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 210, 40));

        jTextFieldApellidoPaterno.setBackground(new java.awt.Color(29, 39, 56));
        jTextFieldApellidoPaterno.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextFieldApellidoPaterno.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldApellidoPaterno.setText("    Apellido Paterno");
        jTextFieldApellidoPaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidoPaternoActionPerformed(evt);
            }
        });
        jPanelColor.add(jTextFieldApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 210, 40));

        jTextFieldTelefono.setBackground(new java.awt.Color(29, 39, 56));
        jTextFieldTelefono.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextFieldTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldTelefono.setText("    Telefono");
        jTextFieldTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelefonoActionPerformed(evt);
            }
        });
        jPanelColor.add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 210, 40));

        getContentPane().add(jPanelColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 310, 360));

        jLabelClientesFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoClientes.png"))); // NOI18N
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

    /**
     * @param args the command line arguments
     */

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JLabel jLabelClientesFondo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelColor;
    private javax.swing.JPanel jPanelColorBlanco;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldApellidoMaterno;
    private javax.swing.JTextField jTextFieldApellidoPaterno;
    private javax.swing.JTextField jTextFieldCorreoElectronico;
    private javax.swing.JTextField jTextFieldNombres;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
