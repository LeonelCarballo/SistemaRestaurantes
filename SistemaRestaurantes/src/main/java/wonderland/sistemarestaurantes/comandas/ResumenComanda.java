/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes.comandas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantes.utils.FontManager;
import wonderland.sistemarestaurantesdominio.Comanda;
import wonderland.sistemarestaurantesdominio.EstadoMesa;
import wonderland.sistemarestaurantesdominio.Mesa;
import wonderland.sistemarestaurantesdominio.Producto;
import wonderland.sistemarestaurantesdominio.dtos.ComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.DetalleComandaDTO;
import wonderland.sistemarestaurantesdominio.dtos.ProductoSeleccionadoDTO;
import wonderland.sistemarestaurantesnegocio.IComandasBO;
import wonderland.sistemarestaurantesnegocio.IDetallesComandasBO;
import wonderland.sistemarestaurantesnegocio.IMesasBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author Dana Chavez
 */
public class ResumenComanda extends javax.swing.JFrame {

    private ControlPresentacion control;
    private ComandaDTO comandaDTO;
    private List<ProductoSeleccionadoDTO> productosSeleccionados;
    private IDetallesComandasBO detallesComandasBO;
    private IComandasBO comandasBO;
    private IMesasBO mesasBO;
    private Mesa mesa;
    private boolean esComandaNueva;
    
    FontManager fontManager = new FontManager();

    public ResumenComanda() {
        initComponents();
    }

    public ResumenComanda(ControlPresentacion control, List<ProductoSeleccionadoDTO> productosSeleccionados, ComandaDTO comandaDTO, 
                          IDetallesComandasBO detallesComandasBO, boolean esComandaNueva, IComandasBO comandasBO, Mesa mesa, IMesasBO mesasBO) {        
        this.control = control;
        this.productosSeleccionados = productosSeleccionados;
        this.comandaDTO = comandaDTO;
        this.detallesComandasBO = detallesComandasBO;
        this.comandasBO = comandasBO;
        this.esComandaNueva = esComandaNueva;
        this.mesa = mesa;
        this.mesasBO = mesasBO;
        initComponents();
        setLocationRelativeTo(null);

        cargarProductos(productosSeleccionados);
        configurarVisibilidadBotones();

        jPanelResumen.setOpaque(false);
        jScrollPaneResumen.setBorder(null);
        jScrollPaneResumen.getViewport().setOpaque(false);
        jScrollPaneResumen.setOpaque(false);
        jPanelTotal.setOpaque(false);
        
    }

    private void cargarProductos(List<ProductoSeleccionadoDTO> productos) {
        jPanelResumen.setLayout(new BoxLayout(jPanelResumen, BoxLayout.Y_AXIS));

        Float total = 0f;

        for (ProductoSeleccionadoDTO producto : productos) {

            jPanelResumen.add(new PanelResumen(producto));
            total += producto.getCantidad() * producto.getPrecioUnitario();
        }

        Color colorTexto = new Color(32, 56, 107);

        JLabel lblTotal = new JLabel(String.format("$%.2f", total));
        jPanelTotal.add(lblTotal, BorderLayout.WEST);
        lblTotal.setFont(fontManager.getNunitoBold(22f));
        lblTotal.setForeground(colorTexto);

        configurarVisibilidadBotones();
        jPanelResumen.revalidate();
    }

    public void confirmarComanda() {
        for (ProductoSeleccionadoDTO producto : productosSeleccionados) {
            DetalleComandaDTO detalleComandaDTO = new DetalleComandaDTO();
            detalleComandaDTO.setCantidadProducto(producto.getCantidad());
            detalleComandaDTO.setPrecio(producto.getPrecioUnitario());
            detalleComandaDTO.setNota(producto.getNotas());

            Producto productoEntidad = new Producto();
            productoEntidad.setId(producto.getIdProducto());
            detalleComandaDTO.setProducto(productoEntidad);

            Comanda comandaEntidad = new Comanda();
            comandaEntidad.setId(comandaDTO.getId());
            detalleComandaDTO.setComanda(comandaEntidad);

            try {
                if (esComandaNueva == false) {
                    this.detallesComandasBO.guardarDetalleComanda(detalleComandaDTO);
                } else if (esComandaNueva == true) {
                    this.detallesComandasBO.ActualizarDetallesComanda(detalleComandaDTO);
                }

                JOptionPane.showMessageDialog(this, "Se registro el detalle de la comanda con exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } catch (NegocioException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al guardar un detalle: " + e.getMessage());
            }
        }
    }

    private void marcarComandaEntregada(ComandaDTO comandaDTO) {
        try {
            this.comandasBO.modificarEstadoComanda(comandaDTO);

            mesasBO.cambiarEstadoMesa(mesa.getId(), EstadoMesa.DISPONIBLE);

            JOptionPane.showMessageDialog(this, "Comanda marcada como ENTREGADA");
            this.dispose();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelarComanda(ComandaDTO comandaDTO) {
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea cancelar esta comanda?",
                "Confirmar cancelacion",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                this.comandasBO.cancelarComanda(comandaDTO);

                mesasBO.cambiarEstadoMesa(mesa.getId(), EstadoMesa.DISPONIBLE);

                JOptionPane.showMessageDialog(this, "Comanda cancelada exitosamente");
                this.dispose();
            } catch (NegocioException ex) {
                JOptionPane.showMessageDialog(this,
                        "Error al cancelar: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void configurarVisibilidadBotones() {
        jButtonEliminarComanda.setVisible(!esComandaNueva);
        jButtonEditarComanda.setVisible(!esComandaNueva);
        jButtonComandaEntregada.setVisible(!esComandaNueva);
        jButtonAnterior.setVisible(!esComandaNueva);
        
        if(comandaDTO.getCliente() != null){
            jButtonAsociarCliente.setVisible(false);
        }

//        jButtonConfirmar.setVisible(esComandaNueva);
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

        jButtonEliminarComanda = new javax.swing.JButton();
        jButtonEditarComanda = new javax.swing.JButton();
        jButtonComandaEntregada = new javax.swing.JButton();
        jButtonAsociarCliente = new javax.swing.JButton();
        jPanelTotal = new javax.swing.JPanel();
        jButtonConfirmar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPaneResumen = new javax.swing.JScrollPane();
        jPanelResumen = new javax.swing.JPanel();
        jButtonAnterior = new javax.swing.JButton();
        FondoResumen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonEliminarComanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BotonEliminarComanda.png"))); // NOI18N
        jButtonEliminarComanda.setContentAreaFilled(false);
        jButtonEliminarComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarComandaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminarComanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, -1, -1));

        jButtonEditarComanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BotonEditarComanda.png"))); // NOI18N
        jButtonEditarComanda.setContentAreaFilled(false);
        jButtonEditarComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarComandaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEditarComanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 170, 50, 50));

        jButtonComandaEntregada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BotonComandaEntregada.png"))); // NOI18N
        jButtonComandaEntregada.setContentAreaFilled(false);
        jButtonComandaEntregada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComandaEntregadaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonComandaEntregada, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, -1, -1));

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
        getContentPane().add(jButtonAsociarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, 180, 50));

        jPanelTotal.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 550, 180, 50));

        jButtonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BotonConfirmarEscrito.png"))); // NOI18N
        jButtonConfirmar.setContentAreaFilled(false);
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 650, -1, -1));

        jLabel5.setFont(fontManager.getNotoSerifCondensedRegular(20f));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Notas");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 310, -1, -1));

        jLabel4.setFont(fontManager.getNotoSerifCondensedRegular(20f));
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Importe");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 310, -1, -1));

        jLabel3.setFont(fontManager.getNotoSerifCondensedRegular(20f));
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Precio");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, -1, -1));

        jLabel2.setFont(fontManager.getNotoSerifCondensedRegular(20f));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Q");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, -1, -1));

        jLabel1.setFont(fontManager.getNotoSerifCondensedRegular(20f));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, -1, -1));

        jScrollPaneResumen.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanelResumen.setLayout(new javax.swing.BoxLayout(jPanelResumen, javax.swing.BoxLayout.Y_AXIS));
        jScrollPaneResumen.setViewportView(jPanelResumen);

        getContentPane().add(jScrollPaneResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 580, 220));

        jButtonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BotonAnterior.png"))); // NOI18N
        jButtonAnterior.setContentAreaFilled(false);
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 130, 120));

        FondoResumen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoResumenComanda.png"))); // NOI18N
        getContentPane().add(FondoResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        control.mostrarSeleccionarProductosComanda(
                comandaDTO.getMesa(), 
                comandaDTO, 
                false, 
                productosSeleccionados);       
        
        cerrar();
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        try{
           confirmarComanda(); 
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Volviendo a la pantalla principal");
        }
        control.mostrarVentanaPrincial();
        cerrar();
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButtonEliminarComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarComandaActionPerformed
        cancelarComanda(comandaDTO);
        control.mostrarVentanaInicioComanda();
    }//GEN-LAST:event_jButtonEliminarComandaActionPerformed

    private void jButtonEditarComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarComandaActionPerformed
        control.mostrarSeleccionarProductosComanda(mesa, comandaDTO, false, productosSeleccionados);
        cerrar();
    }//GEN-LAST:event_jButtonEditarComandaActionPerformed

    private void jButtonComandaEntregadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComandaEntregadaActionPerformed

        marcarComandaEntregada(comandaDTO);
        control.mostrarVentanaPrincial();
    }//GEN-LAST:event_jButtonComandaEntregadaActionPerformed

    private void jButtonAsociarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAsociarClienteActionPerformed
        if (comandaDTO != null && comandaDTO.getId() != null) {
            control.mostrarAsociarCliente(comandaDTO);
        } else {
            JOptionPane.showMessageDialog(this, "La comanda aún no está inicializada correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAsociarClienteActionPerformed

    private void jButtonAsociarClientePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jButtonAsociarClientePropertyChange

    }//GEN-LAST:event_jButtonAsociarClientePropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FondoResumen;
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonAsociarCliente;
    private javax.swing.JButton jButtonComandaEntregada;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonEditarComanda;
    private javax.swing.JButton jButtonEliminarComanda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelResumen;
    private javax.swing.JPanel jPanelTotal;
    private javax.swing.JScrollPane jScrollPaneResumen;
    // End of variables declaration//GEN-END:variables
}
