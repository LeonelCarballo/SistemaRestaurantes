/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantes.reportes;

import static java.awt.AWTEventMulticaster.add;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import wonderland.sistemarestaurantes.utils.FontManager;
import wonderland.sistemarestaurantesdominio.dtos.ComandaDTO;

public class PanelReporteComanda extends JPanel {
    
    private final ComandaDTO comanda;
    
    //TODO Falta el estado de la comanda y el importe total
    
    public PanelReporteComanda(ComandaDTO comanda) {
    this.comanda = comanda;

    FontManager fontManager = new FontManager();

    setPreferredSize(new Dimension(854, 50));
    setLayout(new GridBagLayout());
    setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.WHITE));
    setBackground(new Color(19, 28, 54));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.NONE; 
    gbc.anchor = GridBagConstraints.WEST;

    String folio = comanda.getFolio() != null ? comanda.getFolio().toString() : "--";
    String nombreCliente = comanda.getCliente() != null ? comanda.getCliente().getNombreCompleto() : "Sin cliente";
    String mesa = comanda.getMesa() != null ? comanda.getMesa().getNumeroMesa().toString() : "--";

    Calendar calendar = comanda.getFechaHoraCreacion();
    String fechaStr = calendar != null ? DateTimeFormatter.ofPattern("dd/MM/yy HH:mm")
            .format(calendar.toInstant().atZone(ZoneId.systemDefault())) : "--";

    // Folio
    JLabel lblFolio = new JLabel(folio);
    lblFolio.setFont(fontManager.getNotoSerifCondensedRegular(18f)); 
    lblFolio.setForeground(Color.WHITE);
    lblFolio.setToolTipText(folio); 
    gbc.gridx = 0;
    gbc.weightx = 0;
    gbc.insets = new Insets(3, 10, 3, 5);
    add(lblFolio, gbc);

    // Cliente 
    JLabel lblCliente = new JLabel(nombreCliente);
    lblCliente.setFont(fontManager.getNotoSerifCondensedRegular(18f));
    lblCliente.setForeground(Color.WHITE);
    lblCliente.setToolTipText(comanda.getCliente() != null ? comanda.getCliente().getNombreCompleto() : "");
    gbc.gridx = 1;
    gbc.weightx = 0.5; 
    gbc.insets = new Insets(3, 5, 3, 5);
    add(lblCliente, gbc);

    // Mesa
    JLabel lblMesa = new JLabel(mesa);
    lblMesa.setFont(fontManager.getNotoSerifCondensedRegular(18f));
    lblMesa.setForeground(Color.WHITE);
    gbc.gridx = 2;
    gbc.weightx = 0;
    add(lblMesa, gbc);

    // Fecha
    JLabel lblFecha = new JLabel(fechaStr);
    lblFecha.setFont(fontManager.getNotoSerifCondensedRegular(18f));
    lblFecha.setForeground(Color.WHITE);
    gbc.gridx = 3;
    gbc.weightx = 0;
    gbc.insets = new Insets(3, 5, 3, 10);
    add(lblFecha, gbc);

    setOpaque(false);
}
}
