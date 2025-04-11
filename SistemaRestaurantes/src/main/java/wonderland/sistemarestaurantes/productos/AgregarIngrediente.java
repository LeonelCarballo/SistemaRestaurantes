package wonderland.sistemarestaurantes.productos;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import wonderland.sistemarestaurantes.comandas.PanelProductoComanda;
import wonderland.sistemarestaurantes.comandas.PanelProductoSeleccionado;
import wonderland.sistemarestaurantes.comandas.SeleccionarProductosComanda;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantes.ingredientes.BuscadorIngredientes;
import wonderland.sistemarestaurantes.ingredientes.IngredientePanel;
import wonderland.sistemarestaurantes.productos.IngredienteSeleccionCantidad;
import wonderland.sistemarestaurantes.productos.IngredienteSeleccionPanel;
import wonderland.sistemarestaurantesdominio.Ingrediente;
import wonderland.sistemarestaurantesdominio.Producto;
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
    private List<IngredienteSeleccionPanel> panelesIngredientesDisponibles;
    private List<IngredienteSeleccionCantidad> panelesIngredientesSeleccionados;
    private static final Logger LOG = Logger.getLogger(AgregarIngrediente.class.getName());

    //Constructor
    public AgregarIngrediente(Long idProducto, IIngredientesBO ingredientesBO, IIngredientesProductosBO ingredientesProductosBO, Object padre, List<IngredienteProductoDTO> ingredientesYaSeleccionados) {
        this.idProducto = idProducto;
        this.ingredientesBO = ingredientesBO;
        this.ingredientesProductosBO = ingredientesProductosBO;
        this.padre = padre;

        initComponents();
        mostrarIngredientes();
        agregarBuscador();
        panelesIngredientesDisponibles = new ArrayList<>();
        panelesIngredientesSeleccionados = new ArrayList<>();

    }

    public void mostrar() {
        setVisible(true);
    }

    public void cerrar() {
        setVisible(false);
        dispose();
    }

    public void cargarListaDeIngredientes(List<Ingrediente> ingredientes) {
        jPanelListaIngredientes.removeAll();
        jPanelListaIngredientes.setLayout(new BoxLayout(jPanelListaIngredientes, BoxLayout.Y_AXIS));
        jPanelListaIngredientes.setOpaque(false);

        for (Ingrediente ingrediente : ingredientes) {
            IngredienteSeleccionPanel panel = new IngredienteSeleccionPanel(ingrediente, this::agregarIngredienteSeleccionado);
            jPanelListaIngredientes.add(panel);
        }
        jPanelListaIngredientes.revalidate();
        jPanelListaIngredientes.repaint();
    }

    private void agregarIngredienteSeleccionado(Ingrediente ingrediente) {
        // Primero buscamos si ya existe un panel para este ingrediente
        Component[] componentes = jPanelListaIngredientesSeleccionados.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof IngredienteSeleccionCantidad) {
                IngredienteSeleccionCantidad panelExistente = (IngredienteSeleccionCantidad) componente;
                if (panelExistente.getIngrediente().equals(ingrediente)) {
                    // Si encontramos el panel para este ingrediente, lo eliminamos
                    jPanelListaIngredientesSeleccionados.remove(panelExistente);
                    jPanelListaIngredientesSeleccionados.revalidate();
                    jPanelListaIngredientesSeleccionados.repaint();
                    return; // Salimos del método después de eliminar
                }
            }
        }

        // Si no se encontró el ingrediente, creamos un nuevo panel
        IngredienteSeleccionCantidad panelSeleccionado = new IngredienteSeleccionCantidad(ingrediente);
        jPanelListaIngredientesSeleccionados.setLayout(new BoxLayout(jPanelListaIngredientesSeleccionados, BoxLayout.Y_AXIS));
        jPanelListaIngredientesSeleccionados.add(panelSeleccionado);
        jPanelListaIngredientesSeleccionados.revalidate();
        jPanelListaIngredientesSeleccionados.repaint();
    }

    public void mostrarIngredientes() {
        try {
            List<Ingrediente> ingredientes = ingredientesBO.consultarIngredientes();
            cargarListaDeIngredientes(ingredientes);
        } catch (NegocioException e) {
            LOG.getLogger(AgregarIngrediente.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public List<IngredienteProductoDTO> obtenerIngredientesSeleccionados() {
        List<IngredienteProductoDTO> seleccionados = new ArrayList<>();

        JPanel panelIngredientes = (JPanel) jScrollPaneConfirmarCantidad.getViewport().getView();

        for (Component comp : panelIngredientes.getComponents()) {
            if (comp instanceof IngredienteSeleccionCantidad panel) {

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

        return seleccionados;
    }

    private void guardarIngredientesSeleccionados(Long idProducto, List<IngredienteProductoDTO> ingredientesDTO) {
    try {
        ingredientesProductosBO.eliminarIngredientesPorProducto(idProducto);

        if (ingredientesDTO == null || ingredientesDTO.isEmpty()) {
            return;
        }

        for (IngredienteProductoDTO dto : ingredientesDTO) {
            if (dto.getCantidad() != null && dto.getCantidad() > 0) {
                dto.setIdProducto(idProducto);
                ingredientesProductosBO.registrarIngredienteProducto(dto);
            }
        }
    } catch (NegocioException e) {
        LOG.log(Level.SEVERE, "Error al guardar ingredientes", e);
        throw new RuntimeException("Error al guardar ingredientes", e);
    }
}

    private void actualizarListaIngredientes(List<Ingrediente> ingredientes) {
        jPanelListaIngredientes.removeAll();
        panelesIngredientesDisponibles.clear();

        for (Ingrediente ingrediente : ingredientes) {
            IngredienteSeleccionPanel panel = new IngredienteSeleccionPanel(ingrediente, this::agregarIngredienteSeleccionado);
            panelesIngredientesDisponibles.add(panel);
            jPanelListaIngredientes.add(panel);
        }

        jPanelListaIngredientes.revalidate();
        jPanelListaIngredientes.repaint();
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
        jPanelListaIngredientes = new javax.swing.JPanel();
        jButtonConfirmar = new javax.swing.JButton();
        jScrollPaneConfirmarCantidad = new javax.swing.JScrollPane();
        jPanelListaIngredientesSeleccionados = new javax.swing.JPanel();
        jLabelNombreIngrediente = new javax.swing.JLabel();
        jLabelCantidad = new javax.swing.JLabel();
        jLabelUnidad = new javax.swing.JLabel();
        jPanelBuscador = new javax.swing.JPanel();
        jLabelFondoAgregarIngrediente = new javax.swing.JLabel();
        jLabelNombreIngrediente1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPaneIngredientesDisponibles.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneIngredientesDisponibles.setToolTipText("");
        jScrollPaneIngredientesDisponibles.setMaximumSize(new java.awt.Dimension(410, 230));
        jScrollPaneIngredientesDisponibles.setViewportView(jPanelListaIngredientes);

        getContentPane().add(jScrollPaneIngredientesDisponibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 280, 230));

        jButtonConfirmar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonConfirmarOscuro.png"))); // NOI18N
        jButtonConfirmar.setBorderPainted(false);
        jButtonConfirmar.setContentAreaFilled(false);
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 170, 70));

        jScrollPaneConfirmarCantidad.setViewportView(jPanelListaIngredientesSeleccionados);

        getContentPane().add(jScrollPaneConfirmarCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 320, 170));

        jLabelNombreIngrediente.setBackground(new java.awt.Color(0, 0, 0));
        jLabelNombreIngrediente.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabelNombreIngrediente.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNombreIngrediente.setText("Nombre Ingrediente");
        getContentPane().add(jLabelNombreIngrediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabelCantidad.setBackground(new java.awt.Color(0, 0, 0));
        jLabelCantidad.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabelCantidad.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCantidad.setText("Cantidad");
        getContentPane().add(jLabelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, -1, -1));

        jLabelUnidad.setBackground(new java.awt.Color(0, 0, 0));
        jLabelUnidad.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabelUnidad.setForeground(new java.awt.Color(0, 0, 0));
        jLabelUnidad.setText("Unidad");
        getContentPane().add(jLabelUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, -1, -1));

        jPanelBuscador.setLayout(new javax.swing.BoxLayout(jPanelBuscador, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(jPanelBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 280, 30));

        jLabelFondoAgregarIngrediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondoAgregarIngrediente.png"))); // NOI18N
        getContentPane().add(jLabelFondoAgregarIngrediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 416));

        jLabelNombreIngrediente1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelNombreIngrediente1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabelNombreIngrediente1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNombreIngrediente1.setText("Nombre Ingrediente");
        getContentPane().add(jLabelNombreIngrediente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        List<IngredienteProductoDTO> ingredientesSeleccionados = obtenerIngredientesSeleccionados();

        if (ingredientesSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún ingrediente.");
            return;
        }

        guardarIngredientesSeleccionados(idProducto, obtenerIngredientesSeleccionados());

        if (padre instanceof NuevoProducto nuevo) {
            nuevo.mostrarIngredientesSeleccionados(ingredientesSeleccionados);
        } else if (padre instanceof EditarProducto editar) {
            editar.mostrarIngredientesSeleccionados(ingredientesSeleccionados);
        }

        JOptionPane.showMessageDialog(this, "Ingredientes agregados correctamente.");
        this.dispose();
    }//GEN-LAST:event_jButtonConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelFondoAgregarIngrediente;
    private javax.swing.JLabel jLabelNombreIngrediente;
    private javax.swing.JLabel jLabelNombreIngrediente1;
    private javax.swing.JLabel jLabelUnidad;
    private javax.swing.JPanel jPanelBuscador;
    private javax.swing.JPanel jPanelListaIngredientes;
    private javax.swing.JPanel jPanelListaIngredientesSeleccionados;
    private javax.swing.JScrollPane jScrollPaneConfirmarCantidad;
    private javax.swing.JScrollPane jScrollPaneIngredientesDisponibles;
    // End of variables declaration//GEN-END:variables
}
