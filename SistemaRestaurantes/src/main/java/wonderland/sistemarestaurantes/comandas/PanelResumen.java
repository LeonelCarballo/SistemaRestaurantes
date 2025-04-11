/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantes.comandas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import wonderland.sistemarestaurantes.utils.FontManager;
import wonderland.sistemarestaurantesdominio.dtos.ProductoSeleccionadoDTO;

/**
 *
 * @author Dana Chavez
 */
public class PanelResumen extends JPanel {
    
private final FontManager fontManager = new FontManager();
    
    public PanelResumen (ProductoSeleccionadoDTO producto) {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(450, 60)); 
        setMaximumSize(new Dimension(Short.MAX_VALUE, 60));
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.DARK_GRAY)); 
        setOpaque(false);

        Font fuenteBold = fontManager.getNunitoBold(16f);
        Color colorTexto = new Color(32, 56, 107);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 30, 30, 30);
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel lblNombre = new JLabel(producto.getNombreProducto());
        lblNombre.setFont(fuenteBold);
        lblNombre.setForeground(colorTexto);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0; 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(lblNombre, gbc);

        JLabel lblCantidad = new JLabel(String.valueOf(producto.getCantidad()));
        lblCantidad.setFont(fuenteBold);
        lblCantidad.setForeground(colorTexto);
        gbc.gridx = 1;
        gbc.weightx = 1.0; 
        add(lblCantidad, gbc);

        JLabel lblPrecio = new JLabel(String.format("$%.2f", producto.getPrecioUnitario()));
        lblPrecio.setFont(fuenteBold);
        lblPrecio.setForeground(colorTexto);
        gbc.gridx = 2;
        gbc.weightx = 1.0; 
        add(lblPrecio, gbc);

        Float importe = producto.getCantidad() * producto.getPrecioUnitario();
        JLabel lblImporte = new JLabel(String.format("$%.2f", importe));
        lblImporte.setFont(fuenteBold);
        lblImporte.setForeground(colorTexto);
        gbc.gridx = 3;
        gbc.weightx = 5.0; 
        add(lblImporte, gbc);

        JTextArea txtNotas = new JTextArea(producto.getNotas());
        txtNotas.setFont(fuenteBold);
        txtNotas.setForeground(colorTexto);
        txtNotas.setOpaque(false);
        txtNotas.setEditable(false);
        txtNotas.setLineWrap(true);
        txtNotas.setBorder(null);
        gbc.gridx = 4;
        gbc.weightx = 5.0; 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtNotas, gbc);
    }
}

