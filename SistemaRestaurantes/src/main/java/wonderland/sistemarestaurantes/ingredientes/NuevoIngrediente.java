/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes.ingredientes;

import java.util.logging.Logger;
import javax.swing.JOptionPane;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantesdominio.UnidadMedida;
import wonderland.sistemarestaurantesdominio.dtos.NuevoIngredienteDTO;
import wonderland.sistemarestaurantesnegocio.IIngredientesBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author Dana Chavez
 */
public class NuevoIngrediente extends javax.swing.JFrame {

    private IIngredientesBO ingredientesBO;
    private ControlPresentacion control;
    private static final Logger LOG = Logger.getLogger(NuevoIngrediente.class.getName());
    
    /**
     * Creates new form AnadirIngrediente
     */
    public NuevoIngrediente() {
        initComponents();
    }

    public NuevoIngrediente(ControlPresentacion control, IIngredientesBO ingredientesBO) {
        this.control = control;
        this.ingredientesBO = ingredientesBO;
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
    
    public void registrar(){
       try {
        String nombre = this.jTextFieldNombre.getText();
        float stock = Float.parseFloat(this.jTextFieldCantidad.getText());

        UnidadMedida unidadMedida = UnidadMedida.PIEZA;
        if (jComboBoxUnidad.getSelectedItem().equals("Piezas")) {
            unidadMedida = UnidadMedida.PIEZA;
        } else if (jComboBoxUnidad.getSelectedItem().equals("gr")) {
            unidadMedida = UnidadMedida.GR;
        } else if (jComboBoxUnidad.getSelectedItem().equals("ml")) {
            unidadMedida = UnidadMedida.ML;
        }

        NuevoIngredienteDTO nuevoIngrediente = new NuevoIngredienteDTO(nombre, stock, unidadMedida);

        try {
            this.ingredientesBO.registrarIngrediente(nuevoIngrediente);
            JOptionPane.showMessageDialog(this, "Se registró el ingrediente con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
            this.limpiar();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            LOG.severe("No fue posible registrar el ingredientee: " + ex.getMessage());
        }

    } catch (NumberFormatException ex) {
        NegocioException negocioEx = new NegocioException("Error: La cantidad ingresada no es válida");
        JOptionPane.showMessageDialog(this, negocioEx.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        LOG.severe("Se ingresó incorrectamente la cantidad: " + negocioEx.getMessage());
    }
        
    }
    
    public void limpiar(){
        jTextFieldNombre.setText("Nombre");
        jTextFieldCantidad.setText("0");
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
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldCantidad = new javax.swing.JTextField();
        jComboBoxUnidad = new javax.swing.JComboBox<>();
        jLabelNombre = new javax.swing.JLabel();
        jLabelUnidad = new javax.swing.JLabel();
        jLabelCantidad = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jLabelFondoAnadirIngrediente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonAnterior.png"))); // NOI18N
        jButtonAnterior.setContentAreaFilled(false);
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 100, 100));

        jTextFieldNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldNombre.setText("Nombre");
        jTextFieldNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        jTextFieldNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldNombreMousePressed(evt);
            }
        });
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 300, 40));

        jTextFieldCantidad.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldCantidad.setText("0");
        jTextFieldCantidad.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        jTextFieldCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldCantidadMousePressed(evt);
            }
        });
        jTextFieldCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantidadActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 510, 300, 40));

        jComboBoxUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Piezas", "gr", "ml" }));
        jComboBoxUnidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxUnidadItemStateChanged(evt);
            }
        });
        jComboBoxUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUnidadActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 410, 300, 40));

        jLabelNombre.setFont(new java.awt.Font("Serif", 3, 30)); // NOI18N
        jLabelNombre.setForeground(new java.awt.Color(230, 230, 230));
        jLabelNombre.setText("Nombre Ingrediente:");
        getContentPane().add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 270, 40));

        jLabelUnidad.setFont(new java.awt.Font("Serif", 3, 30)); // NOI18N
        jLabelUnidad.setForeground(new java.awt.Color(230, 230, 230));
        jLabelUnidad.setText("Unidad:");
        getContentPane().add(jLabelUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 130, 40));

        jLabelCantidad.setFont(new java.awt.Font("Serif", 3, 30)); // NOI18N
        jLabelCantidad.setForeground(new java.awt.Color(230, 230, 230));
        jLabelCantidad.setText("Cantidad:");
        getContentPane().add(jLabelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 130, 40));

        jButtonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonConfirmar.png"))); // NOI18N
        jButtonConfirmar.setContentAreaFilled(false);
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 630, -1, 80));

        jLabelFondoAnadirIngrediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoNuevoIngrediente.png"))); // NOI18N
        getContentPane().add(jLabelFondoAnadirIngrediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUnidadActionPerformed
        
    }//GEN-LAST:event_jComboBoxUnidadActionPerformed

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        cerrar();
        control.mostrarListaIngredientes();
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        registrar();
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jComboBoxUnidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxUnidadItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxUnidadItemStateChanged

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jTextFieldCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCantidadActionPerformed

    private void jTextFieldNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldNombreMousePressed
        if(jTextFieldNombre.getText().equals("Nombre")){
            jTextFieldNombre.setText("");
        } 
        if(jTextFieldCantidad.getText().isEmpty()){
             jTextFieldCantidad.setText("0");
        }  
    }//GEN-LAST:event_jTextFieldNombreMousePressed

    private void jTextFieldCantidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldCantidadMousePressed
        if(jTextFieldCantidad.getText().equals("0")){
            jTextFieldCantidad.setText("");
        } 
        if(jTextFieldNombre.getText().isEmpty()){
             jTextFieldNombre.setText("Nombre");
        } 
    }//GEN-LAST:event_jTextFieldCantidadMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox<String> jComboBoxUnidad;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelFondoAnadirIngrediente;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelUnidad;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
