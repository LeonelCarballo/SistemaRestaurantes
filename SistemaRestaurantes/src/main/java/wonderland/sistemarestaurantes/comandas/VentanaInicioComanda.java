/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes.comandas;

import wonderland.sistemarestaurantes.control.ControlPresentacion;

/**
 *
 * @author Dana Chavez
 */
public class VentanaInicioComanda extends javax.swing.JFrame {

    private ControlPresentacion control;
    
    /**
     * Creates new form ResumenComanda
     */
    public VentanaInicioComanda() {
        initComponents();
    }

    public VentanaInicioComanda(ControlPresentacion control) {
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

        jButtonAnterior = new javax.swing.JButton();
        jButtonNuevaComanda = new javax.swing.JButton();
        jButtonComandasAbiertas = new javax.swing.JButton();
        FondoInicioComandas = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonAnterior.png"))); // NOI18N
        jButtonAnterior.setContentAreaFilled(false);
        getContentPane().add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 100, 100));

        jButtonNuevaComanda.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        jButtonNuevaComanda.setText("N U E V A  C O M A N D A");
        jButtonNuevaComanda.setBorder(null);
        jButtonNuevaComanda.setContentAreaFilled(false);
        jButtonNuevaComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevaComandaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNuevaComanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 410, 100));

        jButtonComandasAbiertas.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        jButtonComandasAbiertas.setText("C O M A N D A S  A B I E R T A S");
        jButtonComandasAbiertas.setBorder(null);
        jButtonComandasAbiertas.setContentAreaFilled(false);
        jButtonComandasAbiertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComandasAbiertasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonComandasAbiertas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 410, 100));

        FondoInicioComandas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoInicioComandas.png"))); // NOI18N
        getContentPane().add(FondoInicioComandas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonComandasAbiertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComandasAbiertasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonComandasAbiertasActionPerformed

    private void jButtonNuevaComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevaComandaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNuevaComandaActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaInicioComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInicioComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInicioComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInicioComanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaInicioComanda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FondoInicioComandas;
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonComandasAbiertas;
    private javax.swing.JButton jButtonNuevaComanda;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
