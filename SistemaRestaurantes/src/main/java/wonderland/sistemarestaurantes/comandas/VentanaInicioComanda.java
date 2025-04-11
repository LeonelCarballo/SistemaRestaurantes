/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes.comandas;

import wonderland.sistemarestaurantes.utils.FontManager;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantesdominio.Mesa;
import wonderland.sistemarestaurantesdominio.dtos.ProductoSeleccionadoDTO;
import wonderland.sistemarestaurantesnegocio.IComandasBO;
import wonderland.sistemarestaurantesnegocio.IMesasBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author Dana Chavez
 */
public class VentanaInicioComanda extends javax.swing.JFrame {
    
    FontManager fontManager = new FontManager();
    private ControlPresentacion control;
    private IComandasBO comandasBO;
    private IMesasBO mesasBO;
    private List<Mesa> mesas;
    private static final Logger LOG = Logger.getLogger(VentanaInicioComanda.class.getName());

    public VentanaInicioComanda() {
        initComponents();
    }

    public VentanaInicioComanda(ControlPresentacion control, IMesasBO mesasBO) {
        this.control = control;
        this.mesasBO = mesasBO;
        initComponents();
        
        jScrollPaneMesas.setOpaque(false);
        jScrollPaneMesas.getViewport().setOpaque(false);
        jScrollPaneMesas.setBorder(BorderFactory.createEmptyBorder());
        jScrollPaneMesas.setViewportBorder(BorderFactory.createEmptyBorder());
        jScrollPaneMesas.setBackground(new Color(0, 0, 0, 0));
        jScrollPaneMesas.getVerticalScrollBar().setOpaque(false);
        jScrollPaneMesas.getVerticalScrollBar().setUnitIncrement(16);
        
        jPanelMesas.setOpaque(false);
        jPanelMesas.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        setLocationRelativeTo(null);
        cargarMesas();
    }
    
    private void cargarMesas() {
        try {
            mesas = mesasBO.mostrarMesas();
            
            jPanelMesas.setLayout(new java.awt.GridLayout(0, 5, 10, 10));            
            
            for (Mesa mesa : mesas) {
                PanelMesaComanda btnMesa = new PanelMesaComanda(mesa, this, control);
                btnMesa.setPreferredSize(new Dimension(120, 120));
                jPanelMesas.add(btnMesa);
            }
            
            int mesasFaltantes = (5 - (mesas.size() % 5)) % 5;
            for (int i = 0; i < mesasFaltantes; i++) {
                JPanel panelVacio = new JPanel();
                panelVacio.setOpaque(false);
                jPanelMesas.add(panelVacio);
            }
            
        } catch (NegocioException ex) {
            LOG.log(Level.SEVERE, "Error al cargar mesas", ex);
        }
        
        jPanelMesas.revalidate();
        jPanelMesas.repaint();
    }
    
    public void iniciarNuevaComanda(Mesa mesa) {
        System.out.println("Intentando mostrar confirmación para la mesa: " + mesa.getNumeroMesa());
        control.mostrarConfirmacionInicioComanda(mesa, this);
        
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

        jButtonAnterior = new javax.swing.JButton();
        jScrollPaneMesas = new javax.swing.JScrollPane();
        jPanelMesas = new javax.swing.JPanel();
        jLabelTituloComandas = new javax.swing.JLabel();
        jLabelFondoInicioComandas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BotonAnterior.png"))); // NOI18N
        jButtonAnterior.setContentAreaFilled(false);
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, -1, -1));

        jScrollPaneMesas.setViewportView(jPanelMesas);

        getContentPane().add(jScrollPaneMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 800, 400));

        jLabelTituloComandas.setFont(fontManager.getGreatVibesRegular(126f));
        jLabelTituloComandas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloComandas.setText("Comandas");
        getContentPane().add(jLabelTituloComandas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, -1));

        jLabelFondoInicioComandas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoInicioComandas.png"))); // NOI18N
        getContentPane().add(jLabelFondoInicioComandas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        cerrar();
        control.mostrarVentanaPrincial();
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JLabel jLabelFondoInicioComandas;
    private javax.swing.JLabel jLabelTituloComandas;
    private javax.swing.JPanel jPanelMesas;
    private javax.swing.JScrollPane jScrollPaneMesas;
    // End of variables declaration//GEN-END:variables
}
