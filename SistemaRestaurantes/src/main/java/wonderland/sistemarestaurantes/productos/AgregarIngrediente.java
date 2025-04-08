/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes.productos;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantes.ingredientes.BuscadorIngredientes;
import wonderland.sistemarestaurantes.ingredientes.IngredientePanel;
import wonderland.sistemarestaurantesdominio.Ingrediente;
import wonderland.sistemarestaurantesdominio.dtos.IngredienteProductoDTO;
import wonderland.sistemarestaurantesnegocio.IIngredientesBO;
import wonderland.sistemarestaurantesnegocio.IIngredientesProductosBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author payde
 */
public class AgregarIngrediente extends javax.swing.JFrame {

    private IIngredientesProductosBO ingredientesProductosBO;
    private IIngredientesBO ingredientesBO;
    private ControlPresentacion control;
    private Long idProducto;
    private Object padre;
    private List<IngredienteSeleccionPanel> panelesIngredientesSeleccion;
    private JPanel panelIngredientes;

    //Constructor
    public AgregarIngrediente(Long idProducto, IIngredientesBO ingredientesBO, IIngredientesProductosBO ingredientesProductosBO, Object padre, List<IngredienteProductoDTO> ingredientesYaSeleccionados) {
        this.idProducto = idProducto;
        this.ingredientesBO = ingredientesBO;
        this.ingredientesProductosBO = ingredientesProductosBO;
        this.padre = padre;

        initComponents();
        agregarBuscador();
        panelesIngredientesSeleccion = new ArrayList<>();

        try {
            panelIngredientes = new JPanel();
            panelIngredientes.setLayout(new BoxLayout(panelIngredientes, BoxLayout.Y_AXIS));
            panelIngredientes.setOpaque(false);

            List<Ingrediente> listaIngredientes = ingredientesBO.obtenerTodos();

            for (Ingrediente ingrediente : listaIngredientes) {
                IngredienteSeleccionPanel panel = new IngredienteSeleccionPanel(ingrediente);

                for (IngredienteProductoDTO ingredienteProductoDTO : ingredientesYaSeleccionados) {
                    if (ingrediente.getId().equals(ingredienteProductoDTO.getIdIngrediente())) {
                        panel.seleccionar(true); 
                        panel.setCantidad(ingredienteProductoDTO.getCantidad());
                        break;
                    }
                }

                panelesIngredientesSeleccion.add(panel);
                panelIngredientes.add(panel);
            }

            jScrollPaneIngredientesDisponibles.setViewportView(panelIngredientes);

        } catch (NegocioException ex) {
            ex.printStackTrace();
        }
    }

    public void mostrar() {
        setVisible(true);
    }

    public void cerrar() {
        setVisible(false);
        dispose();
    }

    public List<IngredienteProductoDTO> obtenerIngredientesSeleccionados() {
        List<IngredienteProductoDTO> seleccionados = new ArrayList<>();

        JPanel panelIngredientes = (JPanel) jScrollPaneIngredientesDisponibles.getViewport().getView();

        for (Component comp : panelIngredientes.getComponents()) {
            if (comp instanceof IngredienteSeleccionPanel panel) {
                if (panel.esSeleccionado()) {
                    Ingrediente ingrediente = panel.getIngrediente();
                    Float cantidad = panel.getCantidad();

                    if (cantidad != null && cantidad > 0) {
                        IngredienteProductoDTO ingredienteProductoDTO = new IngredienteProductoDTO();
                        ingredienteProductoDTO.setIngrediente(ingrediente);
                        ingredienteProductoDTO.setIdIngrediente(ingrediente.getId());
                        ingredienteProductoDTO.setCantidad(cantidad);

                        boolean actualizado = false;
                        for (int i = 0; i < seleccionados.size(); i++) {
                            if (seleccionados.get(i).getIdIngrediente().equals(ingrediente.getId())) {
                                seleccionados.set(i, ingredienteProductoDTO);
                                actualizado = true;
                                break;
                            }
                        }
                        if (!actualizado) {
                            seleccionados.add(ingredienteProductoDTO);
                        }
                    }
                }
            }
        }

        return seleccionados;
    }

    private void guardarIngredientesSeleccionados(Long idProducto) {
        try {
            // Elimina TODOS los ingredientes actuales del producto
            ingredientesProductosBO.eliminarIngredientesPorProducto(idProducto);

            // Agrega solo los nuevos seleccionados
            for (IngredienteSeleccionPanel panel : panelesIngredientesSeleccion) {
                if (panel.esSeleccionado()) {
                    Float cantidad = panel.getCantidad();
                    if (cantidad != null && cantidad > 0) {
                        Ingrediente ingrediente = panel.getIngrediente();

                        IngredienteProductoDTO ingredienteProductoDTO = new IngredienteProductoDTO();
                        ingredienteProductoDTO.setIdProducto(idProducto);
                        ingredienteProductoDTO.setIdIngrediente(ingrediente.getId());
                        ingredienteProductoDTO.setCantidad(cantidad);

                        ingredientesProductosBO.registrarIngredienteProducto(ingredienteProductoDTO);
                    }
                }
            }
        } catch (NegocioException e) {
            e.printStackTrace();
        }
    }

    private void actualizarListaIngredientes(List<Ingrediente> ingredientes) {
        panelIngredientes.removeAll();
        panelesIngredientesSeleccion.clear();

        for (Ingrediente ingrediente : ingredientes) {
            IngredienteSeleccionPanel panel = new IngredienteSeleccionPanel(ingrediente);
            panelesIngredientesSeleccion.add(panel);
            panelIngredientes.add(panel);
        }

        panelIngredientes.revalidate();
        panelIngredientes.repaint();
    }

    private void agregarBuscador() {
        BuscadorIngredientes buscadorIngredientes = new BuscadorIngredientes(ingredientesBO, this::actualizarListaIngredientes);
        jPanelBuscador.add(buscadorIngredientes, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneIngredientesDisponibles = new javax.swing.JScrollPane();
        jButtonConfirmar = new javax.swing.JButton();
        jLabelNombreIngrediente = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanelBuscador = new javax.swing.JPanel();
        jLabelFondoAgregarIngrediente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPaneIngredientesDisponibles.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneIngredientesDisponibles.setToolTipText("");
        jScrollPaneIngredientesDisponibles.setMaximumSize(new java.awt.Dimension(410, 230));
        getContentPane().add(jScrollPaneIngredientesDisponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 410, 230));

        jButtonConfirmar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonConfirmarOscuro.png"))); // NOI18N
        jButtonConfirmar.setBorderPainted(false);
        jButtonConfirmar.setContentAreaFilled(false);
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 170, 70));

        jLabelNombreIngrediente.setBackground(new java.awt.Color(0, 0, 0));
        jLabelNombreIngrediente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabelNombreIngrediente.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNombreIngrediente.setText("Nombre Ingrediente");
        getContentPane().add(jLabelNombreIngrediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Cantidad");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Unidad");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));

        jPanelBuscador.setLayout(new javax.swing.BoxLayout(jPanelBuscador, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(jPanelBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 250, 30));

        jLabelFondoAgregarIngrediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondoAgregarIngrediente.png"))); // NOI18N
        getContentPane().add(jLabelFondoAgregarIngrediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, 416));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        List<IngredienteProductoDTO> ingredientesSeleccionados = obtenerIngredientesSeleccionados();

        if (ingredientesSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún ingrediente.");
            return;
        }

        guardarIngredientesSeleccionados(idProducto);

        if (padre instanceof NuevoProducto nuevo) {
            nuevo.mostrarIngredientesSeleccionados(ingredientesSeleccionados);
        } else if (padre instanceof EditarProducto editar) {
            editar.mostrarIngredientesSeleccionados(ingredientesSeleccionados);
        }

        JOptionPane.showMessageDialog(this, "Ingredientes actualizados correctamente.");
        this.dispose();
    }//GEN-LAST:event_jButtonConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFondoAgregarIngrediente;
    private javax.swing.JLabel jLabelNombreIngrediente;
    private javax.swing.JPanel jPanelBuscador;
    private javax.swing.JScrollPane jScrollPaneIngredientesDisponibles;
    // End of variables declaration//GEN-END:variables
}
