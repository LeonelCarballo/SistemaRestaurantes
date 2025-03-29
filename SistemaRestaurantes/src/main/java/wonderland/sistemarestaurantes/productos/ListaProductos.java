/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes.productos;

import wonderland.sistemarestaurantes.control.ControlPresentacion;

/**
 *
 * @author Dana Chavez
 */
public class ListaProductos extends javax.swing.JFrame {

    private ControlPresentacion control;
    
    /**
     * Creates new form Productos
     */
    public ListaProductos() {
        initComponents();
    }

    public ListaProductos(ControlPresentacion control) {
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

        jButtonAnadirProducto = new javax.swing.JButton();
        buscadorProductos = new javax.swing.JTextField();
        jScrollPaneBebidas = new javax.swing.JScrollPane();
        jScrollPanePostres = new javax.swing.JScrollPane();
        jScrollPanePlatillos = new javax.swing.JScrollPane();
        jButtonRegresar = new javax.swing.JButton();
        jLabelFondoMenu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAnadirProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonAnadirProducto.png"))); // NOI18N
        jButtonAnadirProducto.setContentAreaFilled(false);
        jButtonAnadirProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAnadirProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        buscadorProductos.setBackground(new java.awt.Color(255, 255, 255));
        buscadorProductos.setForeground(new java.awt.Color(0, 0, 0));
        buscadorProductos.setText("Productos");
        buscadorProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        buscadorProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorProductosActionPerformed(evt);
            }
        });
        getContentPane().add(buscadorProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 280, 30));
        getContentPane().add(jScrollPaneBebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 220, 270));
        getContentPane().add(jScrollPanePostres, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 220, 270));
        getContentPane().add(jScrollPanePlatillos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 220, 270));

        jButtonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonregresar.png"))); // NOI18N
        jButtonRegresar.setContentAreaFilled(false);
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 500, 280, 50));

        jLabelFondoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MenuFondo.png"))); // NOI18N
        getContentPane().add(jLabelFondoMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscadorProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorProductosActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        cerrar();
        control.mostrarVentanaPrincial();
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jButtonAnadirProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirProductoActionPerformed
        cerrar();
        control.mostrarNuevoProducto();
    }//GEN-LAST:event_jButtonAnadirProductoActionPerformed

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
            java.util.logging.Logger.getLogger(ListaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscadorProductos;
    private javax.swing.JButton jButtonAnadirProducto;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JLabel jLabelFondoMenu;
    private javax.swing.JScrollPane jScrollPaneBebidas;
    private javax.swing.JScrollPane jScrollPanePlatillos;
    private javax.swing.JScrollPane jScrollPanePostres;
    // End of variables declaration//GEN-END:variables
}
