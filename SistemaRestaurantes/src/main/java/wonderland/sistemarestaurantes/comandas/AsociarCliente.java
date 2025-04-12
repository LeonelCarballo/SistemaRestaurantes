/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes.comandas;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import wonderland.sistemarestaurantes.clientes.BuscadorClientes;
import wonderland.sistemarestaurantes.clientes.ClientePanel;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantesdominio.ClienteFrecuente;
import wonderland.sistemarestaurantesdominio.Comanda;
import wonderland.sistemarestaurantesdominio.dtos.ClienteFrecuenteDTO;
import wonderland.sistemarestaurantesdominio.dtos.ComandaDTO;
import wonderland.sistemarestaurantesnegocio.IClientesBO;
import wonderland.sistemarestaurantesnegocio.IComandasBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author Dana Chavez
 */
    public class AsociarCliente extends javax.swing.JFrame {

        private ControlPresentacion control;
        private IClientesBO clientesBO;
        private IComandasBO comandasBO;
        private ComandaDTO comandaDTO;

        public AsociarCliente(ControlPresentacion control, IClientesBO clientesBO, IComandasBO comandasBO, ComandaDTO comandaDTO) {
            this.control = control;
            this.clientesBO = clientesBO;
            this.comandasBO = comandasBO;
            this.comandaDTO = comandaDTO;
            initComponents();
            setLocationRelativeTo(null);

            agregarBuscador();
            mostrarInformacionClientes();

            jPanelListaClientes.setOpaque(false);
            jScrollPaneClientes.setOpaque(false);
            jScrollPaneClientes.getViewport().setOpaque(false);
            jScrollPaneClientes.setBorder(null);
            jPanelBuscador.setOpaque(false);

    }   
    
    private void agregarBuscador() {
        BuscadorClientes buscadorClientes = new BuscadorClientes(clientesBO, this::actualizarListaClientes);
        jPanelBuscador.add(buscadorClientes, BorderLayout.CENTER);
    }

    private ClienteFrecuenteDTO crearClienteDTOConPuntos(ClienteFrecuente cliente) {
        ClienteFrecuenteDTO dto = new ClienteFrecuenteDTO(
            cliente.getId(),
            cliente.getNombre(),
            cliente.getApellidoPaterno(),
            cliente.getApellidoMaterno(),
            cliente.getCorreoElectronico(),
            cliente.getTelefono(),
            cliente.getFechaRegistro()
        );

        try {
            ClienteFrecuenteDTO datosFidelidad = clientesBO.obtenerDatosFidelidad(cliente.getId());
            dto.setPuntosFidelidad(datosFidelidad.getPuntosFidelidad());
        } catch (NegocioException ex) {
            dto.setPuntosFidelidad(0);
        }

        return dto;
    }
    
    private void actualizarListaClientes(List<ClienteFrecuente> clientes) {
        jPanelListaClientes.removeAll();
        for (ClienteFrecuente cliente : clientes) {
            
            ClienteFrecuenteDTO clienteDTO = crearClienteDTOConPuntos(cliente);

            ClientePanel panel = new ClientePanel(
                cliente,
                "Seleccionar",
                e -> {
                    try {
                        Long idComanda = comandaDTO.getId();
                        Comanda comanda = comandasBO.obtenerComandaPorId(idComanda);
                        comandasBO.asociarClienteAComanda(comanda, cliente);
                        JOptionPane.showMessageDialog(this, "Cliente asociado exitosamente.");
                        dispose();
                    } catch (NegocioException ex) {
                        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            );
            panel.actualizarPuntos(clienteDTO.getPuntosFidelidad()); 
            jPanelListaClientes.add(panel);
        }
        jPanelListaClientes.revalidate();
        jPanelListaClientes.repaint();
    }

    private void mostrarInformacionClientes() {
        jPanelListaClientes.removeAll();
        try {
            for (ClienteFrecuente cliente : clientesBO.obtenerClientes()) {
                
                ClienteFrecuenteDTO clienteDTO = crearClienteDTOConPuntos(cliente);

                ClientePanel panel = new ClientePanel(
                    cliente,
                    "Seleccionar",
                    e -> {
                        try {
                            Long idComanda = comandaDTO.getId();
                            Comanda comanda = comandasBO.obtenerComandaPorId(idComanda);
                            comandasBO.asociarClienteAComanda(comanda, cliente);
                            JOptionPane.showMessageDialog(this, "Cliente asociado exitosamente.");
                            dispose();
                        } catch (NegocioException ex) {
                            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                );
                panel.actualizarPuntos(clienteDTO.getPuntosFidelidad()); 
                jPanelListaClientes.add(panel);
            }
        } catch (NegocioException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar clientes: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        jPanelListaClientes.revalidate();
        jPanelListaClientes.repaint();
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
        jPanelBuscador = new javax.swing.JPanel();
        jScrollPaneClientes = new javax.swing.JScrollPane();
        jPanelListaClientes = new javax.swing.JPanel();
        jLabelFondoAsociarCliente = new javax.swing.JLabel();

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

        jPanelBuscador.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanelBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 240, 360, 40));

        jScrollPaneClientes.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanelListaClientes.setLayout(new javax.swing.BoxLayout(jPanelListaClientes, javax.swing.BoxLayout.Y_AXIS));
        jScrollPaneClientes.setViewportView(jPanelListaClientes);

        getContentPane().add(jScrollPaneClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 700, 390));

        jLabelFondoAsociarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoAsociarCliente.png"))); // NOI18N
        getContentPane().add(jLabelFondoAsociarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed

    }//GEN-LAST:event_jButtonAnteriorActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JLabel jLabelFondoAsociarCliente;
    private javax.swing.JPanel jPanelBuscador;
    private javax.swing.JPanel jPanelListaClientes;
    private javax.swing.JScrollPane jScrollPaneClientes;
    // End of variables declaration//GEN-END:variables
}
