/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes.reportes;

import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantesnegocio.implementaciones.ComandasBO;

/**
 *
 * @author Dana Chavez
 */
public class InicioReporte extends javax.swing.JFrame {
    ControlPresentacion control;
    ComandasBO comandasBO;

    public InicioReporte() {
        initComponents();
    }
    
    public InicioReporte(ControlPresentacion control) {
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

        jButtonReporteComandas = new javax.swing.JButton();
        jButtonReporteClientes = new javax.swing.JButton();
        jButtonAnterior = new javax.swing.JButton();
        jLabelFondoInicioRerporte = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonReporteComandas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BotonReportesComandas.png"))); // NOI18N
        jButtonReporteComandas.setContentAreaFilled(false);
        jButtonReporteComandas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporteComandasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonReporteComandas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 370, 120));

        jButtonReporteClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BotonReportesClientes.png"))); // NOI18N
        jButtonReporteClientes.setContentAreaFilled(false);
        jButtonReporteClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporteClientesActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonReporteClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 370, 120));

        jButtonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonAnterior.png"))); // NOI18N
        jButtonAnterior.setContentAreaFilled(false);
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 110, 110));

        jLabelFondoInicioRerporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoReportes.png"))); // NOI18N
        getContentPane().add(jLabelFondoInicioRerporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReporteComandasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporteComandasActionPerformed
        control.mostrarReporteComanda();
    }//GEN-LAST:event_jButtonReporteComandasActionPerformed

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        cerrar();
        control.mostrarVentanaPrincial();
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonReporteClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporteClientesActionPerformed
        cerrar();
        control.mostrarReporteCliente();
    }//GEN-LAST:event_jButtonReporteClientesActionPerformed

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
            java.util.logging.Logger.getLogger(InicioReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioReporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonReporteClientes;
    private javax.swing.JButton jButtonReporteComandas;
    private javax.swing.JLabel jLabelFondoInicioRerporte;
    // End of variables declaration//GEN-END:variables
}
