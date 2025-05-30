/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes.clientes;

import java.awt.BorderLayout;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantesdominio.ClienteFrecuente;
import wonderland.sistemarestaurantesdominio.dtos.ClienteFrecuenteDTO;
import wonderland.sistemarestaurantesnegocio.IClientesBO;
import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;

/**
 *
 * @author Dana Chavez
 */
public class ListaClientes extends javax.swing.JFrame {
    
    private IClientesBO clientesBO;
    private ControlPresentacion control;
    private Long idRol;
    private static final Logger LOG = Logger.getLogger(ListaClientes.class.getName());


    
    /**
     * Creates new form ListaClientes
     */

    public ListaClientes(ControlPresentacion control, IClientesBO clientesBO, Long idRol) {
        this.control = control;
        this.idRol = idRol;
        initComponents();
        this.clientesBO = clientesBO;
        setLocationRelativeTo(null);
        
        agregarBuscador();
        mostrarInformacionClientes();
        configurarVisibilidadBotones();
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
            dto.setVisitas(datosFidelidad.getVisitas());
            dto.setGastoTotal(datosFidelidad.getGastoTotal());
            dto.setPuntosFidelidad(datosFidelidad.getPuntosFidelidad());
        } catch (NegocioException ex) {
            dto.setPuntosFidelidad(0);
        }

        return dto;
    }

    private void actualizarListaClientes(List<ClienteFrecuente> clientes) {
        panelListaClientes.removeAll();
        for (ClienteFrecuente cliente : clientes) {

            ClienteFrecuenteDTO clienteDTO = crearClienteDTOConPuntos(cliente);

            ClientePanel panel = new ClientePanel(
                cliente, 
                "Información",
                e -> {control.mostrarPerfilCliente(cliente, clienteDTO);
                    cerrar();},
                    idRol
            );
            panel.actualizarPuntos(clienteDTO.getPuntosFidelidad()); 
            panelListaClientes.add(panel);
        }
        panelListaClientes.revalidate();
        panelListaClientes.repaint();
    }

    public void mostrarInformacionClientes() {
        panelListaClientes.removeAll(); 
        try {
            for (ClienteFrecuente cliente : clientesBO.obtenerClientes()) {
                
                ClienteFrecuenteDTO clienteDTO = crearClienteDTOConPuntos(cliente);

                ClientePanel panel = new ClientePanel(
                    cliente, 
                    "Información",
                    e -> {control.mostrarPerfilCliente(cliente, clienteDTO);
                    cerrar();}, idRol
                );

                panel.actualizarPuntos(clienteDTO.getPuntosFidelidad());

                panelListaClientes.add(panel);
            }
        } catch (NegocioException ex) {
            LOG.severe("No se pudo llenar la lista de clientes: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, 
                "Error al cargar clientes: " + ex.getMessage(),
                "Error", 
                JOptionPane.ERROR_MESSAGE);
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
    
    private void configurarVisibilidadBotones() {
        if(idRol == 2 || idRol == 3){
            jButtonRegistrarCliente.setVisible(false);
        }
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
        jButtonRegistrarCliente = new javax.swing.JButton();
        jPanelBuscador = new javax.swing.JPanel();
        jPanelColor = new javax.swing.JPanel();
        jScrollListaClientes = new javax.swing.JScrollPane();
        panelListaClientes = new javax.swing.JPanel();
        jLabelClientesFondo = new javax.swing.JLabel();

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

        jButtonRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BotonRegistrarCliente.png"))); // NOI18N
        jButtonRegistrarCliente.setContentAreaFilled(false);
        jButtonRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 190, 40));

        jPanelBuscador.setBackground(new java.awt.Color(10, 15, 31));
        jPanelBuscador.setLayout(new javax.swing.BoxLayout(jPanelBuscador, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(jPanelBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, 360, 40));

        jPanelColor.setBackground(new java.awt.Color(19, 28, 54));

        jScrollListaClientes.setBorder(null);
        jScrollListaClientes.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelListaClientes.setBackground(new java.awt.Color(19, 28, 54));
        panelListaClientes.setLayout(new javax.swing.BoxLayout(panelListaClientes, javax.swing.BoxLayout.Y_AXIS));
        jScrollListaClientes.setViewportView(panelListaClientes);

        javax.swing.GroupLayout jPanelColorLayout = new javax.swing.GroupLayout(jPanelColor);
        jPanelColor.setLayout(jPanelColorLayout);
        jPanelColorLayout.setHorizontalGroup(
            jPanelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelColorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollListaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE))
        );
        jPanelColorLayout.setVerticalGroup(
            jPanelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelColorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollListaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanelColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 720, 420));

        jLabelClientesFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoListaClientes.png"))); // NOI18N
        getContentPane().add(jLabelClientesFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        cerrar();
        control.mostrarVentanaPrincipal();
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarClienteActionPerformed
        cerrar();
        control.mostrarRegistrarCliente();
    }//GEN-LAST:event_jButtonRegistrarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonRegistrarCliente;
    private javax.swing.JLabel jLabelClientesFondo;
    private javax.swing.JPanel jPanelBuscador;
    private javax.swing.JPanel jPanelColor;
    private javax.swing.JScrollPane jScrollListaClientes;
    private javax.swing.JPanel panelListaClientes;
    // End of variables declaration//GEN-END:variables
}
