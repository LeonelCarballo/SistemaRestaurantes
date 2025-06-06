/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes.comandas;

import Mapper.ProductoMapper;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Mapper.ProductoMapper;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantes.utils.FontManager;
import wonderland.sistemarestaurantesdominio.Mesa;
import wonderland.sistemarestaurantesdominio.Producto;
import wonderland.sistemarestaurantesdominio.dtos.ComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.DetalleComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.ProductoSeleccionadoDTO;
import wonderland.sistemarestaurantesnegocio.IDetallesComandasBO;
import wonderland.sistemarestaurantesnegocio.IProductosBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author Dana Chavez
 */
public class SeleccionarProductosComanda extends javax.swing.JFrame {

    private ControlPresentacion control;
    private Mesa mesa;
    private ComandaDTO comandaDTO;
    private IProductosBO productosBO;
    private IDetallesComandasBO detallesComandasBO;
    private DetalleComandaDTO detalleComandaDTO;
    private boolean esComandaNueva;

    private static final Logger LOG = Logger.getLogger(SeleccionarProductosComanda.class.getName());

    FontManager fontManager = new FontManager();

    private List<ProductoSeleccionadoDTO> productosSeleccionados;
    public SeleccionarProductosComanda() {
        initComponents();
    }

    public SeleccionarProductosComanda(ControlPresentacion control, Mesa mesa, ComandaDTO comandaDTO, IProductosBO productosBO, IDetallesComandasBO detallesComandasBO, DetalleComandaDTO detalleComandaDTO, boolean EsComandaNueva, List<ProductoSeleccionadoDTO> productosSeleccionados) {
        this.control = control;
        this.mesa = mesa;
        this.comandaDTO = comandaDTO;
        this.productosBO = productosBO;
        this.detallesComandasBO = detallesComandasBO;
        this.detalleComandaDTO = detalleComandaDTO;
        this.esComandaNueva = esComandaNueva;
        this.productosSeleccionados=productosSeleccionados;
        initComponents();
        setLocationRelativeTo(null);
        
        if (comandaDTO != null && comandaDTO.getFechaHoraCreacion() != null) {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd - MM - yyyy");
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH : mm : ss");

            Calendar fechaCreacion = comandaDTO.getFechaHoraCreacion();
            Date fecha = fechaCreacion.getTime();

            JLabel lblFecha = new JLabel("Fecha : " + formatoFecha.format(fecha));
            lblFecha.setFont(fontManager.getNunitoSemiBold(18f));
            lblFecha.setForeground(Color.WHITE);

            JLabel lblHora = new JLabel("Hora : " + formatoHora.format(fecha));
            lblHora.setFont(fontManager.getNunitoSemiBold(18f));
            lblHora.setForeground(Color.WHITE);

            jPanelFecha.removeAll(); 
            jPanelFecha.setLayout(new BorderLayout());
            jPanelFecha.add(lblFecha, BorderLayout.CENTER);
            jPanelFecha.revalidate();
            jPanelFecha.repaint();

            jPanelHora.removeAll(); 
            jPanelHora.setLayout(new BorderLayout());
            jPanelHora.add(lblHora, BorderLayout.CENTER);
            jPanelHora.revalidate();
            jPanelHora.repaint();
        } 
        
        mostrarProductos();
        cargarProductosSeleccionados();

        if (!esComandaNueva && (productosSeleccionados == null || productosSeleccionados.isEmpty())) {
            cargarProductosComandaExistente(comandaDTO);
        }

        jPanelListaProductos.setOpaque(false);
        jScrollPaneListsProductos.setOpaque(false);
        jScrollPaneListsProductos.getViewport().setOpaque(false);

        jPanelProductosSeleccionados.setOpaque(false);
        jScrollPaneProductosSeleccionados.setOpaque(false);
        jScrollPaneProductosSeleccionados.getViewport().setOpaque(false);
        jScrollPaneProductosSeleccionados.setBorder(null);

        BuscadorProductosComandas buscador = new BuscadorProductosComandas(productosBO, this);
        jPanelBuscador.setLayout(new BorderLayout());
        jPanelBuscador.add(buscador, BorderLayout.CENTER);
        buscador.setOpaque(false);
        
        if(comandaDTO.getCliente() != null){
            jButtonAsociarCliente.setVisible(false);
        }

        JLabel lblMesa = new JLabel("Mesa : " + (mesa != null ? mesa.getNumeroMesa() : "Desconocida"));
        lblMesa.setFont(fontManager.getNunitoSemiBold(18f));
        lblMesa.setForeground(Color.WHITE);

        JLabel lblFolio = new JLabel("Folio : " + (comandaDTO.getFolio() != null ? comandaDTO.getFolio() : "N/A"));
        lblFolio.setFont(fontManager.getNunitoSemiBold(18f));
        lblFolio.setForeground(Color.WHITE);

        jPanelFolio.setOpaque(false);
        jPanelFecha.setOpaque(false);
        jPanelHora.setOpaque(false);
        jPanelMesa.setOpaque(false);
        jPanelBuscador.setOpaque(false);

        jPanelCliente.setOpaque(false);

        jPanelFolio.add(lblFolio, BorderLayout.CENTER);
        jPanelMesa.add(lblMesa);
        
       
    }

    public void cargarListaDeProductos(List<Producto> productos) {
        jPanelListaProductos.removeAll();
        jPanelListaProductos.setLayout(new BoxLayout(jPanelListaProductos, BoxLayout.Y_AXIS));
        jPanelListaProductos.setOpaque(false);

        for (Producto producto : productos) {
            PanelProductoComanda panel = new PanelProductoComanda(producto, this::agregarProductoSeleccionado);
            jPanelListaProductos.add(panel);
        }

        jPanelListaProductos.revalidate();
        jPanelListaProductos.repaint();
    }

    private void agregarProductoSeleccionado(Producto producto) {
        PanelProductoSeleccionado panelSeleccionado = new PanelProductoSeleccionado(producto);
        jPanelProductosSeleccionados.setLayout(new BoxLayout(jPanelProductosSeleccionados, BoxLayout.Y_AXIS));
        jPanelProductosSeleccionados.add(panelSeleccionado);
        jPanelProductosSeleccionados.revalidate();
        jPanelProductosSeleccionados.repaint();
    }

    public void mostrarProductos() {
        try {
            List<Producto> productos = productosBO.obtenerTodos();
            cargarListaDeProductos(productos);
        } catch (NegocioException e) {
            LOG.getLogger(SeleccionarProductosComanda.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void mostrarResultados(List<Producto> resultados) {
        jPanelListaProductos.removeAll();
        jPanelListaProductos.setLayout(new BoxLayout(jPanelListaProductos, BoxLayout.Y_AXIS));
        jPanelListaProductos.setOpaque(false);

        for (Producto producto : resultados) {
            PanelProductoComanda panel = new PanelProductoComanda(producto, this::agregarProductoSeleccionado);
            jPanelListaProductos.add(panel);
        }

        jPanelListaProductos.revalidate();
        jPanelListaProductos.repaint();
    }

    public void cargarProductosComandaExistente(ComandaDTO comandaDTO) {
        try {
            List<ProductoSeleccionadoDTO> productosExistentes = detallesComandasBO.obtenerDetalleComandaPorComanda(comandaDTO);

            jPanelProductosSeleccionados.removeAll();

            for (ProductoSeleccionadoDTO productoDTO : productosExistentes) {
                agregarProductoDesdeDTO(productoDTO);
            }

            jPanelProductosSeleccionados.revalidate();
            jPanelProductosSeleccionados.repaint();
        } catch (NegocioException e) {
            LOG.log(Level.SEVERE, "Error al cargar productos existentes", e);
            JOptionPane.showMessageDialog(this, "Error al cargar productos de la comanda", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregarProductoDesdeDTO(ProductoSeleccionadoDTO productoSeleccionadoDTO) {
        Producto producto = productoSeleccionadoDTO.getProducto();
        PanelProductoSeleccionado panel = new PanelProductoSeleccionado(producto);

        panel.setCantidad(productoSeleccionadoDTO.getCantidad());
        panel.setNotas(productoSeleccionadoDTO.getNotas());

        jPanelProductosSeleccionados.setLayout(new BoxLayout(jPanelProductosSeleccionados, BoxLayout.Y_AXIS));
        jPanelProductosSeleccionados.add(panel);
        jPanelProductosSeleccionados.revalidate();
        jPanelProductosSeleccionados.repaint();
    }

    private void cargarProductosSeleccionados() {
        if (productosSeleccionados == null) {
            return;
        }

        for (ProductoSeleccionadoDTO productoSeleccionadoDTO : productosSeleccionados) {
            Producto producto = ProductoMapper.toProducto(productoSeleccionadoDTO);
            PanelProductoSeleccionado panel = new PanelProductoSeleccionado(producto);
            panel.cargarDesdeDTO(productoSeleccionadoDTO);
            jPanelProductosSeleccionados.setLayout(new BoxLayout(jPanelProductosSeleccionados, BoxLayout.Y_AXIS));
            jPanelProductosSeleccionados.add(panel);
        }

        jPanelProductosSeleccionados.revalidate();
        jPanelProductosSeleccionados.repaint();
    }
    
    public void mostrar() {
        setVisible(true);
    }

    public void cerrar() {
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

        jButtonSiguiente = new javax.swing.JButton();
        jPanelFolio = new javax.swing.JPanel();
        jPanelMesa = new javax.swing.JPanel();
        jPanelHora = new javax.swing.JPanel();
        jPanelFecha = new javax.swing.JPanel();
        jButtonAsociarCliente = new javax.swing.JButton();
        jPanelCliente = new javax.swing.JPanel();
        jButtonAnterior = new javax.swing.JButton();
        jScrollPaneProductosSeleccionados = new javax.swing.JScrollPane();
        jPanelProductosSeleccionados = new javax.swing.JPanel();
        jPanelBuscador = new javax.swing.JPanel();
        jScrollPaneListsProductos = new javax.swing.JScrollPane();
        jPanelListaProductos = new javax.swing.JPanel();
        jLabelFondoSeleccionarProductosComanda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BotonSiguiente.png"))); // NOI18N
        jButtonSiguiente.setContentAreaFilled(false);
        jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 630, 100, 100));

        jPanelFolio.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanelFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 680, 230, 30));
        getContentPane().add(jPanelMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 640, 130, 30));
        getContentPane().add(jPanelHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 200, 40));
        getContentPane().add(jPanelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 220, 40));

        jButtonAsociarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BotonAsociarCliente.png"))); // NOI18N
        jButtonAsociarCliente.setContentAreaFilled(false);
        jButtonAsociarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAsociarClienteActionPerformed(evt);
            }
        });
        jButtonAsociarCliente.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jButtonAsociarClientePropertyChange(evt);
            }
        });
        getContentPane().add(jButtonAsociarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, 180, 50));
        getContentPane().add(jPanelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, 180, 50));

        jButtonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BotonAnterior.png"))); // NOI18N
        jButtonAnterior.setContentAreaFilled(false);
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 100, 100));

        jPanelProductosSeleccionados.setLayout(new javax.swing.BoxLayout(jPanelProductosSeleccionados, javax.swing.BoxLayout.Y_AXIS));
        jScrollPaneProductosSeleccionados.setViewportView(jPanelProductosSeleccionados);

        getContentPane().add(jScrollPaneProductosSeleccionados, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, 450, 340));
        getContentPane().add(jPanelBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 250, 30));

        jScrollPaneListsProductos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneListsProductos.setViewportView(jPanelListaProductos);

        getContentPane().add(jScrollPaneListsProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 300, 520, 330));

        jLabelFondoSeleccionarProductosComanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoProductoComanda.png"))); // NOI18N
        getContentPane().add(jLabelFondoSeleccionarProductosComanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        control.mostrarVentanaInicioComanda();
        cerrar();
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonAsociarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAsociarClienteActionPerformed
        if (comandaDTO != null && comandaDTO.getId() != null) {
            control.mostrarAsociarCliente(comandaDTO);
        } else {
            JOptionPane.showMessageDialog(this, "La comanda aún no está inicializada correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAsociarClienteActionPerformed

    private void jButtonAsociarClientePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jButtonAsociarClientePropertyChange

    }//GEN-LAST:event_jButtonAsociarClientePropertyChange

    private void jButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteActionPerformed
        List<ProductoSeleccionadoDTO> productos = new ArrayList<>();
    for (Component comp : jPanelProductosSeleccionados.getComponents()) {
            if (comp instanceof PanelProductoSeleccionado) {
                PanelProductoSeleccionado panel = (PanelProductoSeleccionado) comp;
                ProductoSeleccionadoDTO productoSeleccionadoDTO = panel.toDTO();

                if (productoSeleccionadoDTO.getCantidad() <= 0) {
                    JOptionPane.showMessageDialog(this,
                            "La cantidad de todos los productos debe ser mayor a cero.",
                            "Cantidad inválida", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                System.out.println("Producto ID: " + productoSeleccionadoDTO.getIdProducto());
                // Validación adicional para el ID
                if (productoSeleccionadoDTO.getIdProducto() == null) {
                    JOptionPane.showMessageDialog(this,
                            "Error: Uno o más productos no tienen ID válido.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                productos.add(productoSeleccionadoDTO);
            }
        }

        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debes seleccionar al menos un producto para continuar con la comanda.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            control.mostrarResumenComanda(productos, comandaDTO, true);
            cerrar();
        }
        this.dispose();
    }//GEN-LAST:event_jButtonSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonAsociarCliente;
    private javax.swing.JButton jButtonSiguiente;
    private javax.swing.JLabel jLabelFondoSeleccionarProductosComanda;
    private javax.swing.JPanel jPanelBuscador;
    private javax.swing.JPanel jPanelCliente;
    private javax.swing.JPanel jPanelFecha;
    private javax.swing.JPanel jPanelFolio;
    private javax.swing.JPanel jPanelHora;
    private javax.swing.JPanel jPanelListaProductos;
    private javax.swing.JPanel jPanelMesa;
    private javax.swing.JPanel jPanelProductosSeleccionados;
    private javax.swing.JScrollPane jScrollPaneListsProductos;
    private javax.swing.JScrollPane jScrollPaneProductosSeleccionados;
    // End of variables declaration//GEN-END:variables
}
