/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantes.productos;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import wonderland.sistemarestaurantesdominio.Ingrediente;

/**
 *
 * @author payde
 */
public class IngredienteSeleccionPanel extends JPanel {
    private final Ingrediente ingrediente;
    private final JRadioButton radioSeleccionar;
    private final JTextField txtCantidad;
    private final JLabel lblUnidad;

    public IngredienteSeleccionPanel(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;

        setLayout(new GridBagLayout());
        setOpaque(false);
        setMaximumSize(new Dimension(600, 35));
        setPreferredSize(new Dimension(600, 35));

        Font font = new Font("Century Gothic", Font.PLAIN, 18);
        Color textColor = Color.BLACK;

        radioSeleccionar = new JRadioButton(ingrediente.getNombre());
        radioSeleccionar.setFont(font);
        radioSeleccionar.setForeground(textColor);
        radioSeleccionar.setOpaque(false);
        radioSeleccionar.setHorizontalAlignment(SwingConstants.LEFT);

        txtCantidad = new JTextField(5);
        txtCantidad.setFont(font);
        txtCantidad.setVisible(false);
        txtCantidad.setPreferredSize(new Dimension(60, 30));

        lblUnidad = new JLabel(ingrediente.getUnidadMedida().toString());
        lblUnidad.setFont(font);
        lblUnidad.setForeground(textColor);
        lblUnidad.setVisible(false);
        lblUnidad.setPreferredSize(new Dimension(50, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 5, 0, 5);

        // Columna 0: radioSeleccionar (ocupa el resto del espacio horizontal, alineado a la izquierda)
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(radioSeleccionar, gbc);

        // Columna 1: txtCantidad (no se estira, posición fija)
        gbc.gridx = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        add(txtCantidad, gbc);

        // Columna 2: lblUnidad
        gbc.gridx = 2;
        add(lblUnidad, gbc);

        radioSeleccionar.addActionListener(e -> {
            boolean selected = radioSeleccionar.isSelected();
            txtCantidad.setVisible(selected);
            lblUnidad.setVisible(selected);
            revalidate();
            repaint();
        });
    }

    public boolean esSeleccionado() {
        return radioSeleccionar.isSelected();
    }

    public Float getCantidad() {
        try {
            return Float.parseFloat(txtCantidad.getText());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public void setCantidad(Float cantidad) {
        txtCantidad.setText(String.valueOf(cantidad));
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void seleccionar(boolean estado) {
        radioSeleccionar.setSelected(estado);
        txtCantidad.setVisible(estado);
        lblUnidad.setVisible(estado);
        if (!estado) {
            txtCantidad.setText("");
        }
    }
}
    


