/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes.clientes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantesdominio.Cliente;
import wonderland.sistemarestaurantesnegocio.IClientesBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author Dana Chavez
 */
public class ListaClientes extends javax.swing.JFrame {
    
    private IClientesBO clientesBO;
    private ControlPresentacion control;
    private static final Logger LOG = Logger.getLogger(ListaClientes.class.getName());
    
    
    /**
     * Creates new form ListaClientes
     */

    public ListaClientes(ControlPresentacion control, IClientesBO clientesBO) {
        this.control = control;
        initComponents();
        this.clientesBO = clientesBO;
        setLocationRelativeTo(null);
        mostrarInformacionClientes();
    }
    
    public void mostrarInformacionClientes() {
        panelListaClientes.removeAll(); // Limpiar panel antes de agregar nuevos clientes
        try {
            for (Cliente cliente : clientesBO.obtenerClientes()) { // Método que retorna la lista de clientes
                panelListaClientes.add(new ClientePanel(cliente));
            }
        } catch (NegocioException ex) {
             LOG.severe("No se pudo llenar la lista de clientes: " + ex.getMessage());
        }

        panelListaClientes.revalidate();
        panelListaClientes.repaint();
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

        jButtonBuscar = new javax.swing.JButton();
        jButtonAnterior = new javax.swing.JButton();
        jButtonRegistrarCliente = new javax.swing.JButton();
        buscador = new javax.swing.JTextField();
        jPanelColor = new javax.swing.JPanel();
        jScrollListaClientes = new javax.swing.JScrollPane();
        panelListaClientes = new javax.swing.JPanel();
        jLabelClientesFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonBuscar.setBackground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonBuscar.setText("Filtrar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, -1, -1));

        jButtonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonAnterior.png"))); // NOI18N
        jButtonAnterior.setContentAreaFilled(false);
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        jButtonRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonRegistrarCliente.png"))); // NOI18N
        jButtonRegistrarCliente.setContentAreaFilled(false);
        jButtonRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, 50));

        buscador.setBackground(new java.awt.Color(255, 255, 255));
        buscador.setForeground(new java.awt.Color(0, 0, 0));
        buscador.setText("Cliente");
        getContentPane().add(buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 250, 30));

        jPanelColor.setBackground(new java.awt.Color(19, 28, 54));

        panelListaClientes.setBackground(new java.awt.Color(19, 28, 54));
        panelListaClientes.setLayout(new javax.swing.BoxLayout(panelListaClientes, javax.swing.BoxLayout.Y_AXIS));
        jScrollListaClientes.setViewportView(panelListaClientes);

        javax.swing.GroupLayout jPanelColorLayout = new javax.swing.GroupLayout(jPanelColor);
        jPanelColor.setLayout(jPanelColorLayout);
        jPanelColorLayout.setHorizontalGroup(
            jPanelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelColorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollListaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelColorLayout.setVerticalGroup(
            jPanelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelColorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollListaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanelColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 540, 300));

        jLabelClientesFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoClientes.png"))); // NOI18N
        getContentPane().add(jLabelClientesFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        cerrar();
        control.mostrarVentanaPrincial();
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarClienteActionPerformed
        cerrar();
        control.mostrarRegistrarCliente();
    }//GEN-LAST:event_jButtonRegistrarClienteActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String filtroBusqueda = buscador.getText().toLowerCase();
        panelListaClientes.removeAll();

        try {
            List<Cliente> clientesPorNombre = this.clientesBO.consultarClientesPorNombre(filtroBusqueda);
            List<Cliente> clientesPorTelefono = this.clientesBO.consultarClientesPorTelefono(filtroBusqueda);
            List<Cliente> clientesPorCorreo = this.clientesBO.consultarClientesPorCorreoElectronico(filtroBusqueda);

            Set<Cliente> clientesUnicos = new HashSet<>();
            clientesUnicos.addAll(clientesPorNombre);
            clientesUnicos.addAll(clientesPorTelefono);
            clientesUnicos.addAll(clientesPorCorreo);

            System.out.println("Clientes encontrados: " + clientesUnicos.size());

            for (Cliente cliente : clientesUnicos) {
                System.out.println("Procesando cliente: " + cliente.getNombre());
                panelListaClientes.add(new ClientePanel(cliente));
            } 

            panelListaClientes.revalidate();
            panelListaClientes.repaint();
        } catch (NegocioException ex) {
            LOG.severe("No se pudo llenar la lista de clientes: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField buscador;
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonRegistrarCliente;
    private javax.swing.JLabel jLabelClientesFondo;
    private javax.swing.JPanel jPanelColor;
    private javax.swing.JScrollPane jScrollListaClientes;
    private javax.swing.JPanel panelListaClientes;
    // End of variables declaration//GEN-END:variables
}
