/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantesdominio.Empleado;
import wonderland.sistemarestaurantesdominio.dtos.EmpleadoDTO;
import wonderland.sistemarestaurantesnegocio.IEmpleadosBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
import wonderland.sistemarestaurantesnegocio.implementaciones.EmpleadosBO;

/**
 *
 * @author Dana Chavez
 */
public class IniciarSesion extends javax.swing.JFrame {

    ControlPresentacion control;
    IEmpleadosBO empleadosBO;

    /**
     * Creates new form IniciarSesion
     */

    public IniciarSesion() {
    }

    public IniciarSesion(ControlPresentacion control, IEmpleadosBO empleadosBO) {
        this.control = control;
        this.empleadosBO = empleadosBO;
        initComponents();
        setLocationRelativeTo(null);
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

        jTextFieldUsuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        jLabelFondoIniciarSesion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldUsuario.setText("Usuario");
        jTextFieldUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldUsuarioMousePressed(evt);
            }
        });
        jTextFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 230, 50));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(0, 0, 51));
        jButton1.setText("IniciarSesion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 550, 230, 50));

        jPasswordField.setText("*********");
        jPasswordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPasswordFieldMousePressed(evt);
            }
        });
        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, 230, 50));

        jLabelFondoIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoIniciarSesion.png"))); // NOI18N
        getContentPane().add(jLabelFondoIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombreUsuario = this.jTextFieldUsuario.getText();
        String contraseña = this.jPasswordField.getText();
        EmpleadoDTO empleado = new EmpleadoDTO();

        
        try {
            empleado = empleadosBO.iniciarSesion(nombreUsuario,contraseña);
        } catch (NegocioException ex) {
            Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (empleado != null) {
            control.iniciarFlujo(empleado.getIdRol());
            cerrar();
            
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo iniciar sesión. Verifica tu usuario y contraseña.", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioMousePressed
        if (jTextFieldUsuario.getText().equals("Usuario")) {
            jTextFieldUsuario.setText("");
        }
    }//GEN-LAST:event_jTextFieldUsuarioMousePressed

    private void jPasswordFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldMousePressed
        if (jTextFieldUsuario.getText().equals("*********")) {
            jTextFieldUsuario.setText("");
        }
    }//GEN-LAST:event_jPasswordFieldMousePressed

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelFondoIniciarSesion;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
