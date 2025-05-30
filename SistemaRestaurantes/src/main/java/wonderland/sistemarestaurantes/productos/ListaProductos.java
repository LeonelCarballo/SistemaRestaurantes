/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes.productos;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantesdominio.Producto;
import wonderland.sistemarestaurantesdominio.TipoProducto;
import wonderland.sistemarestaurantesnegocio.IProductosBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;


/**
 *
 * @author Dana Chavez
 */
public class ListaProductos extends javax.swing.JFrame {
    private JPanel panelPlatillos;
    private JPanel panelPostres;
    private JPanel panelBebidas;
    private ControlPresentacion control;
    private IProductosBO productosBO;
    private Long idRol;
 
    /**
     * Creates new form Productos
     */
    public ListaProductos() {
        initComponents();
    }

    public ListaProductos(ControlPresentacion control, IProductosBO productosBO, Long idRol) {
        this.control = control;
        this.idRol = idRol;
       
        initComponents();
       
        setLocationRelativeTo(null);
        this.productosBO = (IProductosBO) productosBO;

        panelPlatillos = new JPanel();
        panelPostres = new JPanel();
        panelBebidas = new JPanel();

        panelPlatillos.setLayout(new javax.swing.BoxLayout(panelPlatillos, javax.swing.BoxLayout.Y_AXIS));
        panelPostres.setLayout(new javax.swing.BoxLayout(panelPostres, javax.swing.BoxLayout.Y_AXIS));
        panelBebidas.setLayout(new javax.swing.BoxLayout(panelBebidas, javax.swing.BoxLayout.Y_AXIS));
        
        configurarVisibilidadBotones();
        
        panelPlatillos.setOpaque(false);

        jScrollPanePlatillos.setOpaque(false);
        jScrollPanePlatillos.getViewport().setOpaque(false);
        jScrollPanePlatillos.setBorder(null); 

        panelPostres.setOpaque(false);
        jScrollPanePostres.setOpaque(false);
        jScrollPanePostres.getViewport().setOpaque(false);
        jScrollPanePostres.setBorder(null);

        panelBebidas.setOpaque(false);
        jScrollPaneBebidas.setOpaque(false);
        jScrollPaneBebidas.getViewport().setOpaque(false);
        jScrollPaneBebidas.setBorder(null);
        
        jScrollPanePlatillos.setViewportView(panelPlatillos);
        jScrollPanePostres.setViewportView(panelPostres);
        jScrollPaneBebidas.setViewportView(panelBebidas);
        
        BuscadorProductos buscador = new BuscadorProductos(this.productosBO, this);
        getLayeredPane().add(buscador, javax.swing.JLayeredPane.PALETTE_LAYER);
        buscador.setBounds(510, 130, 280, 30);
        buscador.setOpaque(false);
        
        jPanelBuscador.setOpaque(false);
        jPanelBuscador.add(buscador);
    }
    
    public void mostrar(){
        setVisible(true);
    }
    
    public void cerrar(){
        setVisible(false);
        dispose();
    }

    private void configurarVisibilidadBotones() {
        if(idRol == 2 || idRol == 3){
            jButtonAnadirProducto.setVisible(false);
        }
    }
    
    public void mostrarProductos(){
        try {
            panelPlatillos.removeAll();
            panelPostres.removeAll();
            panelBebidas.removeAll();
            
            List<Producto> platillos = productosBO.obtenerProductoPorTipo(TipoProducto.PLATILLO);
            List<Producto> postres = productosBO.obtenerProductoPorTipo(TipoProducto.POSTRE);
            List<Producto> bebidas = productosBO.obtenerProductoPorTipo(TipoProducto.BEBIDA);
            
            
            for (Producto producto : platillos) {
                panelPlatillos.add(new ProductoPanel(control, productosBO, producto,idRol));
            }
            
            for (Producto producto : postres) {
                panelPostres.add(new ProductoPanel(control, productosBO, producto,idRol));
            }
            
            for (Producto producto : bebidas) {
                panelBebidas.add(new ProductoPanel(control, productosBO, producto,idRol));
            }
            
            panelPlatillos.revalidate();
            panelPostres.revalidate();
            panelBebidas.revalidate();
            
            panelPlatillos.repaint();
            panelPostres.repaint();
            panelBebidas.repaint();
        } catch (NegocioException ex) {
            Logger.getLogger(ListaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarResultados(List<Producto> resultados) {
        panelPlatillos.removeAll();
        panelPostres.removeAll();
        panelBebidas.removeAll();

        for (Producto producto : resultados) {
            ProductoPanel panel = new ProductoPanel(control, productosBO, producto,idRol);
            switch (producto.getTipoProducto()) {
                case PLATILLO -> panelPlatillos.add(panel);
                case POSTRE -> panelPostres.add(panel);
                case BEBIDA -> panelBebidas.add(panel);
            }
        }
            panelPlatillos.revalidate();
            panelPostres.revalidate();
            panelBebidas.revalidate();
            panelPlatillos.repaint();
            panelPostres.repaint();
            panelBebidas.repaint();
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
        jPanelBuscador = new javax.swing.JPanel();
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
        getContentPane().add(jButtonAnadirProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));
        getContentPane().add(jPanelBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 270, 40));

        jScrollPaneBebidas.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        getContentPane().add(jScrollPaneBebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, 300, 370));

        jScrollPanePostres.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        getContentPane().add(jScrollPanePostres, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 300, 370));

        jScrollPanePlatillos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        getContentPane().add(jScrollPanePlatillos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 300, 370));

        jButtonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonregresar.png"))); // NOI18N
        jButtonRegresar.setContentAreaFilled(false);
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 680, 280, 50));

        jLabelFondoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoMenu.png"))); // NOI18N
        getContentPane().add(jLabelFondoMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
              
        control.mostrarVentanaPrincipal();
        cerrar(); 
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jButtonAnadirProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirProductoActionPerformed
     
        control.mostrarNuevoProducto();
        cerrar();
    }//GEN-LAST:event_jButtonAnadirProductoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnadirProducto;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JLabel jLabelFondoMenu;
    private javax.swing.JPanel jPanelBuscador;
    private javax.swing.JScrollPane jScrollPaneBebidas;
    private javax.swing.JScrollPane jScrollPanePlatillos;
    private javax.swing.JScrollPane jScrollPanePostres;
    // End of variables declaration//GEN-END:variables
}
