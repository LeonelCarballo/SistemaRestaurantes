
package wonderland.sistemarestaurantes.productos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantes.ingredientes.NuevoIngrediente;
import wonderland.sistemarestaurantesdominio.Producto;
import wonderland.sistemarestaurantesdominio.TipoProducto;
import wonderland.sistemarestaurantesdominio.dtos.IngredienteProductoDTO;
import wonderland.sistemarestaurantesdominio.dtos.NuevoProductoDTO;
import wonderland.sistemarestaurantesnegocio.IIngredientesBO;
import wonderland.sistemarestaurantesnegocio.IIngredientesProductosBO;
import wonderland.sistemarestaurantesnegocio.IProductosBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
import wonderland.sistemarestaurantesnegocio.implementaciones.IngredientesProductosBO;

/**
 *
 * @author Dana Chavez
 */
public class NuevoProducto extends javax.swing.JFrame {

    private ControlPresentacion control;
    private IIngredientesBO ingredientesBO;
    private IngredientesProductosBO ingredientesProductosBO;
    private IProductosBO productosBO;
    private static final Logger LOG = Logger.getLogger(NuevoProducto.class.getName());
    private Long idProductoActual;
    private List<IngredienteProductoDTO> ingredientesSeleccionados = new ArrayList<>();

    /**
     * Creates new form NuevoProducto
     */
    
    public NuevoProducto() {
        initComponents();
    }

    public NuevoProducto(ControlPresentacion control, IProductosBO productosBO, IIngredientesBO ingredientesBO, IIngredientesProductosBO ingredientesProductosBO) {
    this.control = control;
    this.productosBO = productosBO;
    this.ingredientesBO = ingredientesBO;
    this.ingredientesProductosBO = (IngredientesProductosBO) ingredientesProductosBO;
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
    
    public void limpiar(){
        jTextFieldNombreProducto.setText("Nombre");
        jTextFieldNombrePrecio.setText("0.00");
    }
    
    public void registrarProducto(){
        String nombre= this.jTextFieldNombreProducto.getText();
        float precio = Float.parseFloat(this.jTextFieldNombrePrecio.getText());
        
        try{
        TipoProducto tipo = TipoProducto.PLATILLO;
        if(jComboBoxCategoria.getSelectedItem().equals("Platillo")){
            tipo= TipoProducto.PLATILLO;
        }else if(jComboBoxCategoria.getSelectedItem().equals("Postre")){
            tipo= TipoProducto.POSTRE;
        }else if(jComboBoxCategoria.getSelectedItem().equals("Bebida")){
            tipo= TipoProducto.BEBIDA;
        }
        
        NuevoProductoDTO nuevoProducto = new NuevoProductoDTO(nombre, precio, tipo);            
        
        try{
            Producto productoRegistrado = this.productosBO.registrarProducto(nuevoProducto);
            Long idProducto = productoRegistrado.getId();
            this.idProductoActual = idProducto;
            AgregarIngrediente agregar = new AgregarIngrediente(idProducto, ingredientesBO, ingredientesProductosBO, this, ingredientesSeleccionados);          
            agregar.setVisible(true);
      
            }catch(NegocioException ex){
                LOG.severe("No se pudo registrar el producto" + ex.getMessage());
        }
        }catch(NumberFormatException ex){
            NegocioException negocioEx = new NegocioException("El precio ingresado no es valido");
        }
    }
    
    public void mostrarIngredientesSeleccionados(List<IngredienteProductoDTO> nuevos) {
        this.ingredientesSeleccionados = nuevos; 

        JPanel panelVisual = new JPanel();
        panelVisual.setLayout(new BoxLayout(panelVisual, BoxLayout.Y_AXIS));
        panelVisual.setOpaque(false);

        for (IngredienteProductoDTO ingredienteProductoDTO : nuevos) {
            String nombre = ingredienteProductoDTO.getIngrediente().getNombre();
            float cantidad = ingredienteProductoDTO.getCantidad();
            String unidad = ingredienteProductoDTO.getIngrediente().getUnidadMedida().toString();

            panelVisual.add(new IngredienteVisualPanel(nombre, cantidad, unidad));
        }

        jScrollPaneIngredientesSeleccionados.setViewportView(panelVisual);
        panelVisual.revalidate();
        panelVisual.repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonRegresar = new javax.swing.JButton();
        jTextFieldNombrePrecio = new javax.swing.JTextField();
        jTextFieldNombreProducto = new javax.swing.JTextField();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jButtonGuardar = new javax.swing.JButton();
        jButtonMostrarAgregarIgrediente = new javax.swing.JButton();
        jScrollPaneIngredientesSeleccionados = new javax.swing.JScrollPane();
        jLabelFondoNuevoProducto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonregresar.png"))); // NOI18N
        jButtonRegresar.setContentAreaFilled(false);
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 500, 280, 50));

        jTextFieldNombrePrecio.setBackground(new java.awt.Color(29, 39, 56));
        jTextFieldNombrePrecio.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextFieldNombrePrecio.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNombrePrecio.setText("    Precio");
        jTextFieldNombrePrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldNombrePrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombrePrecioActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNombrePrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 310, 40));

        jTextFieldNombreProducto.setBackground(new java.awt.Color(29, 39, 56));
        jTextFieldNombreProducto.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextFieldNombreProducto.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNombreProducto.setText("    Nombre");
        jTextFieldNombreProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTextFieldNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreProductoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 310, 40));

        jComboBoxCategoria.setBackground(new java.awt.Color(29, 39, 56));
        jComboBoxCategoria.setEditable(true);
        jComboBoxCategoria.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Platillo", "Postre", "Bebida" }));
        jComboBoxCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 346, 310, 40));

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, -1, 30));

        jButtonMostrarAgregarIgrediente.setText("AgregarIngrediente");
        jButtonMostrarAgregarIgrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarAgregarIgredienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMostrarAgregarIgrediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 180, -1, -1));
        getContentPane().add(jScrollPaneIngredientesSeleccionados, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 340, 240));

        jLabelFondoNuevoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoNuevoProducto.png"))); // NOI18N
        getContentPane().add(jLabelFondoNuevoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreProductoActionPerformed

    private void jTextFieldNombrePrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombrePrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombrePrecioActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        cerrar();
        control.mostrarListaProductos();
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        registrarProducto();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonMostrarAgregarIgredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarAgregarIgredienteActionPerformed
        AgregarIngrediente agregar = new AgregarIngrediente(
        null, 
        ingredientesBO,
        ingredientesProductosBO,
        this,
        ingredientesSeleccionados 
    );
    agregar.setVisible(true);
    }//GEN-LAST:event_jButtonMostrarAgregarIgredienteActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonMostrarAgregarIgrediente;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabelFondoNuevoProducto;
    private javax.swing.JScrollPane jScrollPaneIngredientesSeleccionados;
    private javax.swing.JTextField jTextFieldNombrePrecio;
    private javax.swing.JTextField jTextFieldNombreProducto;
    // End of variables declaration//GEN-END:variables
}
