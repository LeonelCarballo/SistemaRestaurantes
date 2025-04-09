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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import org.w3c.dom.events.DocumentEvent;
import wonderland.sistemarestaurantes.utils.FontManager;
import wonderland.sistemarestaurantesdominio.Producto;

/**
 *
 * @author Dana Chavez
 */
public class PanelProductoSeleccionado extends JPanel {
     private JTextField txtCantidad;
    private JTextField txtNotas;
    private JLabel lblImporte;
    private Producto producto;

    public PanelProductoSeleccionado(Producto producto) {
        this.producto = producto;
        FontManager fontManager = new FontManager();
        Font fuente = fontManager.getNunitoRegular(16f);

        setLayout(new GridBagLayout());
        setOpaque(false);
        setPreferredSize(new Dimension(420, 50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 5, 2, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel lblNombre = new JLabel(producto.getNombre());
        lblNombre.setFont(fuente);
        lblNombre.setForeground(Color.WHITE);
        gbc.gridx = 0;
        add(lblNombre, gbc);

        txtCantidad = new JTextField("Cantidad", 3);
        txtCantidad.setFont(fuente);
        gbc.gridx = 1;
        add(txtCantidad, gbc);

        lblImporte = new JLabel();
        lblImporte.setFont(fuente);
        lblImporte.setForeground(Color.WHITE);
        gbc.gridx = 2;
        add(lblImporte, gbc);
        actualizarImporte();

        txtNotas = new JTextField(12);
        txtNotas.setFont(fuente);
        gbc.gridx = 3;
        add(txtNotas, gbc);

        txtCantidad.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                actualizarImporte();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                actualizarImporte();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                actualizarImporte();
            }
        });
    }

    private void actualizarImporte() {
        try {
            int cantidad = Integer.parseInt(txtCantidad.getText().trim());
            if (cantidad < 0) cantidad = 0;
            double total = cantidad * producto.getPrecio();
            lblImporte.setText(String.format("$%.2f", total));
        } catch (NumberFormatException e) {
            lblImporte.setText("$0.00");
        }
    }

    public int getCantidad() {
        try {
            return Integer.parseInt(txtCantidad.getText().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public String getNotas() {
        return txtNotas.getText().trim();
    }

    public Producto getProducto() {
        return producto;
    }
    
    
}
