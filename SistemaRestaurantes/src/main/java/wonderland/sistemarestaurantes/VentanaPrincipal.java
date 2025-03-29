/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes;

import wonderland.sistemarestaurantes.control.ControlPresentacion;

/**
 *
 * @author Dana Chavez
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private ControlPresentacion control;
    
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
    }

    public VentanaPrincipal(ControlPresentacion control) {
        this.control = control;
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

        jLabel1 = new javax.swing.JLabel();
        jButtonClientes = new javax.swing.JButton();
        jButtonMesas = new javax.swing.JButton();
        jButtonMenu = new javax.swing.JButton();
        jButtonReportes = new javax.swing.JButton();
        jButtonInventario = new javax.swing.JButton();
        jButtonComandas = new javax.swing.JButton();
        jLabelFondoVentanaPrincipal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REPORTES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        jButtonClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonClientes.png"))); // NOI18N
        jButtonClientes.setContentAreaFilled(false);
        jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientesActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, -1, -1));

        jButtonMesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonMesas.png"))); // NOI18N
        jButtonMesas.setContentAreaFilled(false);
        jButtonMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMesasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        jButtonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonMenu.png"))); // NOI18N
        jButtonMenu.setContentAreaFilled(false);
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, -1, -1));

        jButtonReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonReportes.png"))); // NOI18N
        jButtonReportes.setContentAreaFilled(false);
        jButtonReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportesActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 80, -1));

        jButtonInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonInventario.png"))); // NOI18N
        jButtonInventario.setContentAreaFilled(false);
        jButtonInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInventarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, -1, -1));

        jButtonComandas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonComandas.png"))); // NOI18N
        jButtonComandas.setContentAreaFilled(false);
        jButtonComandas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComandasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonComandas, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, -1, -1));

        jLabelFondoVentanaPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/VentanaPrincipalFondo.png"))); // NOI18N
        getContentPane().add(jLabelFondoVentanaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMesasActionPerformed
        cerrar();
        control.mostrarMesas();
    }//GEN-LAST:event_jButtonMesasActionPerformed

    private void jButtonComandasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComandasActionPerformed
        cerrar();
        control.mostrarVentanaInicioComanda();
    }//GEN-LAST:event_jButtonComandasActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        cerrar();
        control.mostrarListaProductos();
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void jButtonInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInventarioActionPerformed
        cerrar();
        control.mostrarListaIngredientes();
    }//GEN-LAST:event_jButtonInventarioActionPerformed

    private void jButtonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientesActionPerformed
        cerrar();
        control.mostrarListaClientes();
    }//GEN-LAST:event_jButtonClientesActionPerformed

    private void jButtonReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportesActionPerformed
        cerrar();
        control.mostrarIniciarReporte();
    }//GEN-LAST:event_jButtonReportesActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonComandas;
    private javax.swing.JButton jButtonInventario;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JButton jButtonMesas;
    private javax.swing.JButton jButtonReportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFondoVentanaPrincipal;
    // End of variables declaration//GEN-END:variables
}
