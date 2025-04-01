/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes.clientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantesdominio.Cliente;
import wonderland.sistemarestaurantesdominio.dtos.ClienteDTO;
import wonderland.sistemarestaurantesnegocio.IClientesBO;

/**
 *
 * @author Dana Chavez
 */
public class PerfilCliente extends javax.swing.JFrame {
    
    private IClientesBO clientesBO;
    private ClienteDTO clienteDTO;
    private ControlPresentacion control;
    private static final Logger LOG = Logger.getLogger(PerfilCliente.class.getName());
    
    
    /**
     * Creates new form ListaClientes
     */
    public PerfilCliente() {
        initComponents();
    }

    public PerfilCliente(ControlPresentacion control, IClientesBO clientesBO, ClienteDTO clienteDTO) {
        this.control = control;
        initComponents();
        this.clientesBO = clientesBO;
        this.clienteDTO = clienteDTO;
        setLocationRelativeTo(null);
        
        cargarDatosCliente(clienteDTO);
        
        jButtonConfirmar.setVisible(false);
        jTextFieldFechaRegistro.setEditable(false);
        jTextFieldPuntos.setEditable(false);
        

        Color nonEditableBg = new Color(25, 30, 52); 
        jTextFieldFechaRegistro.setBackground(nonEditableBg);
        jTextFieldPuntos.setBackground(nonEditableBg);    
        
        Color editableBg = new Color(40, 45, 72); 
        jTextFieldNombreCliente.setBackground(editableBg);
        jTextFieldApellidoPaterno.setBackground(editableBg);
        jTextFieldApellidoMaterno.setBackground(editableBg);
        jTextFieldCorreo.setBackground(editableBg);
        jTextFieldTelefono.setBackground(editableBg);

        setEditableFields(false);
        
        
        actualizarNombreCliente(clienteDTO);
        revalidate();
        repaint();

    }
    
    public void actualizarNombreCliente(ClienteDTO cliente) {
        
        JLabel lblNombreCliente = new JLabel();
        lblNombreCliente.setFont(new Font("Vladimir Script", Font.PLAIN, 60));
        lblNombreCliente.setForeground(Color.WHITE); 

        jPanelNombreCliente.add(lblNombreCliente, BorderLayout.CENTER);
        
        String nombreCompleto = cliente.getNombre();
        String primerNombre = nombreCompleto.split(" ")[0]; 
        
        if (cliente != null) {
            lblNombreCliente.setText(primerNombre + " " + cliente.getApellidoPaterno());
        } else {
            lblNombreCliente.setText("Cliente Desconocido");
        }
    }
    
    private void cargarDatosCliente(ClienteDTO cliente) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        String fechaFormateada = dateFormat.format(cliente.getFechaRegistro().getTime());
        
        if (cliente != null) {
            jTextFieldNombreCliente.setText(cliente.getNombre());
            jTextFieldApellidoPaterno.setText(cliente.getApellidoPaterno());
            jTextFieldApellidoMaterno.setText(cliente.getApellidoMaterno());
            jTextFieldTelefono.setText(cliente.getTelefono());
            jTextFieldCorreo.setText(cliente.getCorreoElectronico());
            jTextFieldFechaRegistro.setText(fechaFormateada);
            //jTextFieldPuntos.setText(String.valueOf(cliente.getPuntos()));

            jTextFieldFechaRegistro.setEditable(false);
            jTextFieldPuntos.setEditable(false);
            jTextFieldTelefono.setEditable(false);
        }
    }
    
    private void setEditableFields(boolean editable) {
        jTextFieldNombreCliente.setEditable(editable);
        jTextFieldApellidoPaterno.setEditable(editable);
        jTextFieldApellidoMaterno.setEditable(editable);
        jTextFieldTelefono.setEditable(editable);
        jTextFieldCorreo.setEditable(editable);

        Color bgColor = editable ? new Color(60, 65, 92) : new Color(40, 45, 72);
        jTextFieldNombreCliente.setBackground(bgColor);
        jTextFieldApellidoPaterno.setBackground(bgColor);
        jTextFieldApellidoMaterno.setBackground(bgColor);
        jTextFieldCorreo.setBackground(bgColor);
        jTextFieldTelefono.setBackground(bgColor);
    }
    
    public void mostrarInformacionCliente(){
        
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

        jPanel2 = new javax.swing.JPanel();
        jButtonConfirmar = new javax.swing.JButton();
        jLabelTituloCorreoElectronico2 = new javax.swing.JLabel();
        jLabelTituloFechaRegistro = new javax.swing.JLabel();
        jLabelTituloCorreoElectronico = new javax.swing.JLabel();
        jLabelTituloTelefono = new javax.swing.JLabel();
        jLabelTituloNombre = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanelNumVisitas = new javax.swing.JPanel();
        jLabelTituloTotal = new javax.swing.JLabel();
        jTextFieldPuntos = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldFechaRegistro = new javax.swing.JTextField();
        jTextFieldCorreo = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jTextFieldApellidoMaterno = new javax.swing.JTextField();
        jTextFieldApellidoPaterno = new javax.swing.JTextField();
        jTextFieldNombreCliente = new javax.swing.JTextField();
        jPanelNombreCliente = new javax.swing.JPanel();
        jButtonAnterior = new javax.swing.JButton();
        jLabelClientesFondo = new javax.swing.JLabel();
        jPanelTotalAcum1 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonConfirmar.png"))); // NOI18N
        jButtonConfirmar.setContentAreaFilled(false);
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, -1, -1));

        jLabelTituloCorreoElectronico2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTituloCorreoElectronico2.setFont(new java.awt.Font("Book Antiqua", 0, 24)); // NOI18N
        jLabelTituloCorreoElectronico2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloCorreoElectronico2.setText("Visitas");
        getContentPane().add(jLabelTituloCorreoElectronico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 310, -1, -1));

        jLabelTituloFechaRegistro.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTituloFechaRegistro.setFont(new java.awt.Font("Book Antiqua", 0, 24)); // NOI18N
        jLabelTituloFechaRegistro.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloFechaRegistro.setText("Fecha Registro");
        getContentPane().add(jLabelTituloFechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, -1, -1));

        jLabelTituloCorreoElectronico.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTituloCorreoElectronico.setFont(new java.awt.Font("Book Antiqua", 0, 24)); // NOI18N
        jLabelTituloCorreoElectronico.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloCorreoElectronico.setText("Correo Electronico");
        getContentPane().add(jLabelTituloCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, -1));

        jLabelTituloTelefono.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTituloTelefono.setFont(new java.awt.Font("Book Antiqua", 0, 24)); // NOI18N
        jLabelTituloTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloTelefono.setText("Telefono");
        getContentPane().add(jLabelTituloTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, -1, -1));

        jLabelTituloNombre.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTituloNombre.setFont(new java.awt.Font("Book Antiqua", 0, 24)); // NOI18N
        jLabelTituloNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloNombre.setText("Nombre Completo");
        getContentPane().add(jLabelTituloNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, -1));

        jToggleButton1.setBackground(new java.awt.Color(119, 151, 189));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonEditar.png"))); // NOI18N
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, 40, 40));

        jPanelNumVisitas.setBackground(new java.awt.Color(10, 15, 31));

        javax.swing.GroupLayout jPanelNumVisitasLayout = new javax.swing.GroupLayout(jPanelNumVisitas);
        jPanelNumVisitas.setLayout(jPanelNumVisitasLayout);
        jPanelNumVisitasLayout.setHorizontalGroup(
            jPanelNumVisitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanelNumVisitasLayout.setVerticalGroup(
            jPanelNumVisitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelNumVisitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 80, 80));

        jLabelTituloTotal.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTituloTotal.setFont(new java.awt.Font("Baskerville Old Face", 0, 24)); // NOI18N
        jLabelTituloTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloTotal.setText("Total acumulado:");
        getContentPane().add(jLabelTituloTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 510, -1, -1));

        jTextFieldPuntos.setBackground(new java.awt.Color(25, 33, 50));
        jTextFieldPuntos.setBorder(null);
        jTextFieldPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPuntosActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 140, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, 500, 10));

        jTextFieldFechaRegistro.setBackground(new java.awt.Color(25, 30, 52));
        jTextFieldFechaRegistro.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextFieldFechaRegistro.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldFechaRegistro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        jTextFieldFechaRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFechaRegistroActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldFechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 270, 30));

        jTextFieldCorreo.setBackground(new java.awt.Color(25, 30, 52));
        jTextFieldCorreo.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextFieldCorreo.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldCorreo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        jTextFieldCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 270, 30));

        jTextFieldTelefono.setBackground(new java.awt.Color(25, 30, 52));
        jTextFieldTelefono.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextFieldTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        jTextFieldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 270, 30));

        jTextFieldApellidoMaterno.setBackground(new java.awt.Color(25, 30, 52));
        jTextFieldApellidoMaterno.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextFieldApellidoMaterno.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldApellidoMaterno.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        jTextFieldApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidoMaternoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 130, 30));

        jTextFieldApellidoPaterno.setBackground(new java.awt.Color(25, 30, 52));
        jTextFieldApellidoPaterno.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextFieldApellidoPaterno.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldApellidoPaterno.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        jTextFieldApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidoPaternoActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 130, 30));

        jTextFieldNombreCliente.setBackground(new java.awt.Color(25, 30, 52));
        jTextFieldNombreCliente.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextFieldNombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNombreCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        jTextFieldNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 270, 30));

        jPanelNombreCliente.setBackground(new java.awt.Color(10, 15, 31));
        jPanelNombreCliente.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanelNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 430, 110));

        jButtonAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonAnterior.png"))); // NOI18N
        jButtonAnterior.setContentAreaFilled(false);
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        jLabelClientesFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoClientes.png"))); // NOI18N
        getContentPane().add(jLabelClientesFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanelTotalAcum1.setBackground(new java.awt.Color(10, 15, 31));

        javax.swing.GroupLayout jPanelTotalAcum1Layout = new javax.swing.GroupLayout(jPanelTotalAcum1);
        jPanelTotalAcum1.setLayout(jPanelTotalAcum1Layout);
        jPanelTotalAcum1Layout.setHorizontalGroup(
            jPanelTotalAcum1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        jPanelTotalAcum1Layout.setVerticalGroup(
            jPanelTotalAcum1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelTotalAcum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 500, 130, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreClienteActionPerformed

    private void jTextFieldTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelefonoActionPerformed

    private void jTextFieldCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCorreoActionPerformed

    private void jTextFieldFechaRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFechaRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFechaRegistroActionPerformed

    private void jTextFieldPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPuntosActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        boolean editando = jToggleButton1.isSelected();
        setEditableFields(editando);
        jButtonConfirmar.setVisible(editando);

        
        if (editando) {
            jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonCancelar.png")));
        } else {
            jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonEditar.png"))); 
            // cargarDatosCliente();
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jTextFieldApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidoPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidoPaternoActionPerformed

    private void jTextFieldApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidoMaternoActionPerformed

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        cerrar();
        control.mostrarListaClientes();
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        String nuevoNombre = this.jTextFieldNombreCliente.getText();
        String nuevoApellidoPaterno = this.jTextFieldApellidoPaterno.getText();
        String nuevoApellidoMaterno = this.jTextFieldApellidoMaterno.getText();
        String nuevoCorreoElectronico = this.jTextFieldCorreo.getText();
        String nuevoTelefono = this.jTextFieldTelefono.getText();
        
        Long idCliente = clienteDTO.getId();
        
        ClienteDTO clienteDTO = new ClienteDTO(idCliente);
        clienteDTO.setNombre(nuevoNombre);
        clienteDTO.setApellidoPaterno(nuevoApellidoPaterno);
        clienteDTO.setApellidoMaterno(nuevoApellidoMaterno);
        clienteDTO.setCorreoElectronico(nuevoCorreoElectronico);
        clienteDTO.setTelefono(nuevoTelefono);
        


        try {
            Cliente clienteEditado = this.clientesBO.editarCliente(clienteDTO);
            JOptionPane.showMessageDialog(this, "Cambios guardados exitosamente");

            jToggleButton1.setSelected(false);
            setEditableFields(false);
            jButtonConfirmar.setVisible(false);
            jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botonEditar.png")));
            
            jTextFieldNombreCliente.setText(clienteEditado.getNombre());
            jTextFieldApellidoPaterno.setText(clienteEditado.getApellidoPaterno());
            jTextFieldApellidoMaterno.setText(clienteEditado.getApellidoMaterno());
            jTextFieldCorreo.setText(clienteEditado.getCorreoElectronico());
            jTextFieldTelefono.setText(clienteEditado.getTelefono());
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),"Informacion", JOptionPane.ERROR_MESSAGE);
            LOG.severe("No fue posible registrar el cliente" + ex.getMessage());
        } 
        

    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JLabel jLabelClientesFondo;
    private javax.swing.JLabel jLabelTituloCorreoElectronico;
    private javax.swing.JLabel jLabelTituloCorreoElectronico2;
    private javax.swing.JLabel jLabelTituloFechaRegistro;
    private javax.swing.JLabel jLabelTituloNombre;
    private javax.swing.JLabel jLabelTituloTelefono;
    private javax.swing.JLabel jLabelTituloTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelNombreCliente;
    private javax.swing.JPanel jPanelNumVisitas;
    private javax.swing.JPanel jPanelTotalAcum1;
    private javax.swing.JTextField jTextFieldApellidoMaterno;
    private javax.swing.JTextField jTextFieldApellidoPaterno;
    private javax.swing.JTextField jTextFieldCorreo;
    private javax.swing.JTextField jTextFieldFechaRegistro;
    private javax.swing.JTextField jTextFieldNombreCliente;
    private javax.swing.JTextField jTextFieldPuntos;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
