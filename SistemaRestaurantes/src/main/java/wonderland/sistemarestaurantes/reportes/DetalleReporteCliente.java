/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wonderland.sistemarestaurantes.reportes;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantes.utils.FontManager;
import wonderland.sistemarestaurantesdominio.dtos.ClienteFrecuenteDTO;
import wonderland.sistemarestaurantesnegocio.IClientesBO;

/**
 *
 * @author Dana Chavez
 */
public class DetalleReporteCliente extends javax.swing.JFrame {
    
    private IClientesBO clientesBO;
    private ClienteFrecuenteDTO clienteDTO;
    private ControlPresentacion control;
    private static final Logger LOG = Logger.getLogger(DetalleReporteCliente.class.getName());
    FontManager fontManager = new FontManager();
    
    public DetalleReporteCliente(ControlPresentacion control, IClientesBO clientesBO, ClienteFrecuenteDTO clienteDTO) {
        this.control = control;
        initComponents();
        this.clientesBO = clientesBO;
        this.clienteDTO = clienteDTO;
        setLocationRelativeTo(null);
        
        cargarDatosCliente(clienteDTO);
        configurarCamposNoEditables();
        
        
        revalidate();
        repaint();
    }
    
    private void configurarCamposNoEditables() {
        Color nonEditableBg = new Color(33, 32, 33); 
        
        jTextFieldNombreCliente.setEditable(false);
        jTextFieldApellidoPaterno.setEditable(false);
        jTextFieldApellidoMaterno.setEditable(false);
        jTextFieldFechaRegistro.setEditable(false);
        jTextFieldPuntos.setEditable(false);
        jTextFieldUltimaVisita.setEditable(false);
        
        jTextFieldNombreCliente.setBackground(nonEditableBg);
        jTextFieldApellidoPaterno.setBackground(nonEditableBg);
        jTextFieldApellidoMaterno.setBackground(nonEditableBg);
        jTextFieldFechaRegistro.setBackground(nonEditableBg);
        jTextFieldPuntos.setBackground(nonEditableBg);
        jTextFieldUltimaVisita.setBackground(nonEditableBg);
    }
    
    private void cargarDatosCliente(ClienteFrecuenteDTO cliente) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 

        String fechaRegistroFormateada = dateFormat.format(cliente.getFechaRegistro().getTime());
        
        String ultimaVisitaFormateada = "No registrada";
        if (cliente.getUltimaVisita() != null) {
            ultimaVisitaFormateada = dateFormat.format(cliente.getUltimaVisita().getTime());
        }

        jTextFieldNombreCliente.setText(cliente.getNombre());
        jTextFieldApellidoPaterno.setText(cliente.getApellidoPaterno());
        jTextFieldApellidoMaterno.setText(cliente.getApellidoMaterno());
        jTextFieldFechaRegistro.setText(fechaRegistroFormateada);
        jTextFieldUltimaVisita.setText(ultimaVisitaFormateada);
        jTextFieldPuntos.setText(String.valueOf(cliente.getPuntosFidelidad()) + " pts");
        
        jLabelVisitas.setText(String.valueOf(cliente.getVisitas()));
        jLabelTotalAcumulado.setText(String.format("$%.2f", cliente.getGastoTotal()));
    }
    
    private void generarReportePDF(ClienteFrecuenteDTO clienteDTO) {
        Document documento = new Document();

        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar reporte de cliente");
            fileChooser.setSelectedFile(new File("Reporte_Cliente_" + 
                clienteDTO.getNombre().replace(" ", "_") + ".pdf"));

            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File outputFile = fileChooser.getSelectedFile();

                PdfWriter.getInstance(documento, new FileOutputStream(outputFile));
                documento.open();

                Paragraph titulo = new Paragraph("INFORME DE CLIENTE FRECUENTE", 
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20));
                titulo.setAlignment(Element.ALIGN_CENTER);
                titulo.setSpacingAfter(20f);
                documento.add(titulo);

                Paragraph subtitulo = new Paragraph("Generado el: " + 
                    new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()), 
                    FontFactory.getFont(FontFactory.HELVETICA, 10));
                subtitulo.setAlignment(Element.ALIGN_CENTER);
                subtitulo.setSpacingAfter(30f);
                documento.add(subtitulo);

                PdfPTable tablaDatos = new PdfPTable(2);
                tablaDatos.setWidthPercentage(90);
                tablaDatos.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaDatos.setSpacingBefore(20f);
                tablaDatos.setSpacingAfter(30f);

                float[] columnWidths = {1f, 3f};
                tablaDatos.setWidths(columnWidths);

                PdfPCell headerCell = new PdfPCell(new Phrase("DATOS PERSONALES", 
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
                headerCell.setColspan(2);
                headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                headerCell.setBackgroundColor(new com.itextpdf.text.BaseColor(200, 200, 200));
                headerCell.setPadding(8f);
                tablaDatos.addCell(headerCell);

                agregarFilaTabla(tablaDatos, "Nombre completo:", 
                    clienteDTO.getNombre() + " " + clienteDTO.getApellidoPaterno() + 
                    (clienteDTO.getApellidoMaterno() != null ? " " + clienteDTO.getApellidoMaterno() : ""));

                agregarFilaTabla(tablaDatos, "Correo electrónico:", 
                    clienteDTO.getCorreoElectronico() != null ? clienteDTO.getCorreoElectronico() : "No registrado");

                agregarFilaTabla(tablaDatos, "Teléfono:", 
                    clienteDTO.getTelefono() != null ? clienteDTO.getTelefono() : "No registrado");

                agregarFilaTabla(tablaDatos, "Fecha de registro:", 
                    new SimpleDateFormat("dd/MM/yyyy").format(clienteDTO.getFechaRegistro().getTime()));

                documento.add(tablaDatos);

                PdfPTable tablaEstadisticas = new PdfPTable(2);
                tablaEstadisticas.setWidthPercentage(90);
                tablaEstadisticas.setHorizontalAlignment(Element.ALIGN_CENTER);
                tablaEstadisticas.setSpacingBefore(20f);
                tablaEstadisticas.setSpacingAfter(30f);
                tablaEstadisticas.setWidths(columnWidths);

                PdfPCell statsHeader = new PdfPCell(new Phrase("ESTADÍSTICAS DE VISITAS", 
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
                statsHeader.setColspan(2);
                statsHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
                statsHeader.setBackgroundColor(new com.itextpdf.text.BaseColor(200, 200, 200));
                statsHeader.setPadding(8f);
                tablaEstadisticas.addCell(statsHeader);

                agregarFilaTabla(tablaEstadisticas, "Total de visitas:", 
                    String.valueOf(clienteDTO.getVisitas()));

                agregarFilaTabla(tablaEstadisticas, "Total gastado:", 
                    String.format("$%,.2f", clienteDTO.getGastoTotal()));

                agregarFilaTabla(tablaEstadisticas, "Puntos de fidelidad:", 
                    String.valueOf(clienteDTO.getPuntosFidelidad()) + " pts");

                agregarFilaTabla(tablaEstadisticas, "Última visita:", 
                    clienteDTO.getUltimaVisita() != null ? 
                    new SimpleDateFormat("dd/MM/yyyy").format(clienteDTO.getUltimaVisita().getTime()) : 
                    "No registrada");

                documento.add(tablaEstadisticas);

                Paragraph nota = new Paragraph("Este reporte fue generado automáticamente por el sistema de Wonderland Restaurantes", 
                    FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 8));
                nota.setAlignment(Element.ALIGN_CENTER);
                nota.setSpacingBefore(20f);
                documento.add(nota);

                documento.close();

                JOptionPane.showMessageDialog(this, 
                    "<html><b>¡Reporte generado con éxito!</b><br>" + 
                    "Guardado en: " + outputFile.getAbsolutePath() + "</html>", 
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error al generar el PDF: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            LOG.severe("Error al generar PDF: " + e.getMessage());
        }
    }

    private void agregarFilaTabla(PdfPTable tabla, String etiqueta, String valor) {
        PdfPCell celdaEtiqueta = new PdfPCell(new Phrase(etiqueta, 
            FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
        celdaEtiqueta.setBorder(Rectangle.NO_BORDER);
        celdaEtiqueta.setPadding(5f);

        PdfPCell celdaValor = new PdfPCell(new Phrase(valor, 
            FontFactory.getFont(FontFactory.HELVETICA, 10)));
        celdaValor.setBorder(Rectangle.NO_BORDER);
        celdaValor.setPadding(5f);

        tabla.addCell(celdaEtiqueta);
        tabla.addCell(celdaValor);
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

        jButtonGenerarReporte = new javax.swing.JButton();
        jTextFieldNombreCliente = new javax.swing.JTextField();
        jTextFieldApellidoPaterno = new javax.swing.JTextField();
        jTextFieldApellidoMaterno = new javax.swing.JTextField();
        jTextFieldPuntos = new javax.swing.JTextField();
        jTextFieldFechaRegistro = new javax.swing.JTextField();
        jTextFieldUltimaVisita = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabelTotal = new javax.swing.JLabel();
        jLabelNumVisitas = new javax.swing.JLabel();
        jLabelPuntos = new javax.swing.JLabel();
        jLabelUltimaVisita = new javax.swing.JLabel();
        jLabelFechaRegistro = new javax.swing.JLabel();
        jLabelApellidoMaterno = new javax.swing.JLabel();
        jLabelApellidoPaterno = new javax.swing.JLabel();
        jLabelNombreCliente = new javax.swing.JLabel();
        jLabelTituloNombre = new javax.swing.JLabel();
        jLabelVisitas = new javax.swing.JLabel();
        jLabelTotalAcumulado = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BotonDescargar.png"))); // NOI18N
        jButtonGenerarReporte.setContentAreaFilled(false);
        jButtonGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarReporteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 560, 80, 80));

        jTextFieldNombreCliente.setFont(fontManager.getNotoSerifCondensedRegular(20f)
        );
        jTextFieldNombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNombreCliente.setText("jTextField1");
        jTextFieldNombreCliente.setBorder(null);
        getContentPane().add(jTextFieldNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 210, 50));

        jTextFieldApellidoPaterno.setFont(fontManager.getNotoSerifCondensedRegular(20f)
        );
        jTextFieldApellidoPaterno.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldApellidoPaterno.setText("jTextField2");
        jTextFieldApellidoPaterno.setBorder(null);
        getContentPane().add(jTextFieldApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 210, 50));

        jTextFieldApellidoMaterno.setFont(fontManager.getNotoSerifCondensedRegular(20f)
        );
        jTextFieldApellidoMaterno.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldApellidoMaterno.setText("jTextField3");
        jTextFieldApellidoMaterno.setBorder(null);
        getContentPane().add(jTextFieldApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 406, 210, 50));

        jTextFieldPuntos.setFont(fontManager.getNotoSerifCondensedRegular(25f)
        );
        jTextFieldPuntos.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldPuntos.setText("jTextField5");
        jTextFieldPuntos.setBorder(null);
        jTextFieldPuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPuntosActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 90, 60));

        jTextFieldFechaRegistro.setFont(fontManager.getNotoSerifCondensedRegular(20f)
        );
        jTextFieldFechaRegistro.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldFechaRegistro.setText("jTextField6");
        jTextFieldFechaRegistro.setBorder(null);
        getContentPane().add(jTextFieldFechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 486, 210, 50));

        jTextFieldUltimaVisita.setFont(fontManager.getNotoSerifCondensedRegular(20f)
        );
        jTextFieldUltimaVisita.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldUltimaVisita.setText("jTextField7");
        jTextFieldUltimaVisita.setBorder(null);
        getContentPane().add(jTextFieldUltimaVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 566, 210, 50));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BotonAnterior.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 120, 110));

        jLabelTotal.setFont(fontManager.getNotoSerifCondensedRegular(22f)
        );
        jLabelTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotal.setText("Total Gastado:");
        getContentPane().add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 540, -1, -1));

        jLabelNumVisitas.setFont(fontManager.getNotoSerifCondensedRegular(22f)
        );
        jLabelNumVisitas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumVisitas.setText("Visitas:");
        getContentPane().add(jLabelNumVisitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 400, -1, -1));

        jLabelPuntos.setFont(fontManager.getNotoSerifCondensedRegular(22f)
        );
        jLabelPuntos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPuntos.setText("Puntos:");
        getContentPane().add(jLabelPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, -1, -1));

        jLabelUltimaVisita.setFont(fontManager.getNotoSerifCondensedRegular(22f)
        );
        jLabelUltimaVisita.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUltimaVisita.setText("Ultima Visita:");
        getContentPane().add(jLabelUltimaVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, -1, -1));

        jLabelFechaRegistro.setFont(fontManager.getNotoSerifCondensedRegular(22f)
        );
        jLabelFechaRegistro.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFechaRegistro.setText("Fecha Registro:");
        getContentPane().add(jLabelFechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, -1, -1));

        jLabelApellidoMaterno.setFont(fontManager.getNotoSerifCondensedRegular(22f)
        );
        jLabelApellidoMaterno.setForeground(new java.awt.Color(255, 255, 255));
        jLabelApellidoMaterno.setText("Apellido Materno:");
        getContentPane().add(jLabelApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, -1, -1));

        jLabelApellidoPaterno.setFont(fontManager.getNotoSerifCondensedRegular(22f)
        );
        jLabelApellidoPaterno.setForeground(new java.awt.Color(255, 255, 255));
        jLabelApellidoPaterno.setText("Apellido Paterno:");
        getContentPane().add(jLabelApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, -1));

        jLabelNombreCliente.setFont(fontManager.getNotoSerifCondensedRegular(22f)
        );
        jLabelNombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombreCliente.setText("Nombre cliente:");
        getContentPane().add(jLabelNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));

        jLabelTituloNombre.setFont(fontManager.getGreatVibesRegular(50f)
        );
        jLabelTituloNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloNombre.setText("Informacion ");
        getContentPane().add(jLabelTituloNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));

        jLabelVisitas.setFont(fontManager.getNotoSerifCondensedRegular(50f)
        );
        jLabelVisitas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVisitas.setText("jLabel1");
        getContentPane().add(jLabelVisitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, -1, -1));

        jLabelTotalAcumulado.setFont(fontManager.getNotoSerifCondensedRegular(22f)
        );
        jLabelTotalAcumulado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotalAcumulado.setText("jLabel1");
        getContentPane().add(jLabelTotalAcumulado, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 590, 60, 20));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoDetalleReporteCliente.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarReporteActionPerformed
        generarReportePDF(clienteDTO);
    }//GEN-LAST:event_jButtonGenerarReporteActionPerformed

    private void jTextFieldPuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPuntosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        control.mostrarReporteCliente();
        cerrar();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonGenerarReporte;
    private javax.swing.JLabel jLabelApellidoMaterno;
    private javax.swing.JLabel jLabelApellidoPaterno;
    private javax.swing.JLabel jLabelFechaRegistro;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelNombreCliente;
    private javax.swing.JLabel jLabelNumVisitas;
    private javax.swing.JLabel jLabelPuntos;
    private javax.swing.JLabel jLabelTituloNombre;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTotalAcumulado;
    private javax.swing.JLabel jLabelUltimaVisita;
    private javax.swing.JLabel jLabelVisitas;
    private javax.swing.JTextField jTextFieldApellidoMaterno;
    private javax.swing.JTextField jTextFieldApellidoPaterno;
    private javax.swing.JTextField jTextFieldFechaRegistro;
    private javax.swing.JTextField jTextFieldNombreCliente;
    private javax.swing.JTextField jTextFieldPuntos;
    private javax.swing.JTextField jTextFieldUltimaVisita;
    // End of variables declaration//GEN-END:variables
}
