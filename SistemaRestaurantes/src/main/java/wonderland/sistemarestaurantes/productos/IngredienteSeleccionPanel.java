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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import wonderland.sistemarestaurantesdominio.Ingrediente;

/**
 *
 * @author payde
 */
public class IngredienteSeleccionPanel extends JPanel{
    
   private JRadioButton radioSeleccionar;
    private JTextField txtCantidad;
    private JLabel lblUnidad;
    private Ingrediente ingrediente;

    public IngredienteSeleccionPanel(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;

        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        setOpaque(false);
        setMaximumSize(new Dimension(600, 35));
        setPreferredSize(new Dimension(600, 35));

        Font font = new Font("Century Gothic", Font.PLAIN, 18);
        Color textColor = Color.BLACK;

        radioSeleccionar = new JRadioButton(ingrediente.getNombre());
        radioSeleccionar.setFont(font);
        radioSeleccionar.setForeground(textColor);
        radioSeleccionar.setOpaque(false);

        txtCantidad = new JTextField(5);
        txtCantidad.setFont(font);
        txtCantidad.setVisible(false);

        lblUnidad = new JLabel(ingrediente.getUnidadMedida().toString());
        lblUnidad.setFont(font);
        lblUnidad.setForeground(textColor);
        lblUnidad.setVisible(false);

        radioSeleccionar.addActionListener(e -> {
            boolean selected = radioSeleccionar.isSelected();
            txtCantidad.setVisible(selected);
            lblUnidad.setVisible(selected);
            revalidate();
            repaint();
        });

        add(radioSeleccionar);
        add(txtCantidad);
        add(lblUnidad);
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
    


