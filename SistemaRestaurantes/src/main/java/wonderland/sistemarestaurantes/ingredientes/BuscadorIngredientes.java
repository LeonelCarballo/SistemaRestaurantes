/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package wonderland.sistemarestaurantes.ingredientes;

import Fonts.FontManager;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.logging.Logger;
import wonderland.sistemarestaurantesdominio.Ingrediente;
import wonderland.sistemarestaurantesnegocio.IIngredientesBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author leoca
 */
public class BuscadorIngredientes extends javax.swing.JPanel {

    private IIngredientesBO ingredientesBO;
    private Consumer<List<Ingrediente>> onResults;
    private static final Logger LOG = Logger.getLogger(BuscadorIngredientes.class.getName());
    FontManager fontManager = new FontManager();

    public BuscadorIngredientes(IIngredientesBO ingredientesBO, Consumer<List<Ingrediente>> onResults) {
        this.ingredientesBO = ingredientesBO;
        this.onResults = onResults;
        initComponents();
        setOpaque(false);
        jButtonBuscar.addActionListener(this::buscarIngredientes);
    }

    private void buscarIngredientes(ActionEvent e) {
        String filtroNombre = jTextFieldFiltroNombre.getText().toLowerCase();
        try {
            List<Ingrediente> ingredientesNombre = ingredientesBO.consultarIngredientesPorNombre(filtroNombre);

            LOG.info("Se encontraron " + ingredientesNombre.size() + " ingredientes");

            onResults.accept(List.copyOf(ingredientesNombre));
        } catch (NegocioException ex) {
            LOG.severe("Hubo un error al llenar la tabla" + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldFiltroNombre = new javax.swing.JTextField();

        jPanel1.setPreferredSize(new java.awt.Dimension(280, 30));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonBuscar.png"))); // NOI18N
        jPanel1.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 30, 30));

        jTextFieldFiltroNombre.setPreferredSize(new java.awt.Dimension(250, 30));
        jPanel1.add(jTextFieldFiltroNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldFiltroNombre;
    // End of variables declaration//GEN-END:variables
}
