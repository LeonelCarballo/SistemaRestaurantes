/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantes.ingredientes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantesdominio.Ingrediente;

/**
 *
 * @author leoca
 */
public class IngredientePanel extends JPanel {
    
    public IngredientePanel(Ingrediente ingrediente) {
                setPreferredSize(new Dimension(400, 50)); // Aumentar altura del panel
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.WHITE));
        setBackground(new Color(80, 80, 80)); // Gris medio oscuro

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 5, 8, 5); // Aumentar espacio vertical
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font font = new Font("Leelawadee UI Semilight", Font.PLAIN, 14);
        Color textColor = Color.WHITE;

        JLabel lblNombre = new JLabel(String.format("%-20s", ingrediente.getNombre().toUpperCase()));
        lblNombre.setFont(font);
        lblNombre.setForeground(textColor);
        lblNombre.setPreferredSize(new Dimension(150, 25));

        String stockText = (ingrediente.getStock() % 1 == 0) ? String.format("%.0f", ingrediente.getStock()) : String.format("%.2f", ingrediente.getStock());
        JLabel lblStock = new JLabel(stockText);
        lblStock.setFont(font);
        lblStock.setForeground(textColor);
        lblStock.setPreferredSize(new Dimension(60, 20));

        JLabel lblUnidad = new JLabel(String.format("%-15s", ingrediente.getUnidadMedida().getDescripcion()));
        lblUnidad.setFont(font);
        lblUnidad.setForeground(textColor);
        lblUnidad.setPreferredSize(new Dimension(100, 25));

        JButton btnEdit = new JButton("Editar");
        btnEdit.setFont(font);
        btnEdit.setBackground(new Color(180, 180, 180));
        btnEdit.setPreferredSize(new Dimension(70, 25));
        btnEdit.addActionListener(e -> {
            ControlPresentacion control = new ControlPresentacion();
            control.mostrarEditarNombreIngrediente(ingrediente);
        });
        
        JButton btnAdd = new JButton("Añadir");
        btnAdd.setFont(font);
        btnAdd.setBackground(new Color(200, 200, 200));
        btnAdd.setPreferredSize(new Dimension(70, 25));
        btnAdd.addActionListener(e -> {
            ControlPresentacion control = new ControlPresentacion();
            control.mostrarAñadirStockIngrediente(ingrediente);
        });

        // Configuración para una única línea horizontal con separación fija
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        add(lblNombre, gbc);

        gbc.gridx = 1;
        add(lblStock, gbc);

        gbc.gridx = 2;
        add(new JLabel(" - "), gbc);

        gbc.gridx = 3;
        add(lblUnidad, gbc);

        gbc.gridx = 4;
        gbc.weightx = 1;
        add(Box.createHorizontalGlue(), gbc); // Mantiene alineación

        gbc.gridx = 5;
        gbc.anchor = GridBagConstraints.EAST;
        add(btnEdit, gbc);

        gbc.gridx = 6;
        add(btnAdd, gbc);
    }
}