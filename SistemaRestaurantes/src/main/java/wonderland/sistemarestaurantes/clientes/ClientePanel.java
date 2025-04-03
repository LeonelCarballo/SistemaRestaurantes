/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantes.clientes;

import Fonts.FontManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantesdominio.Cliente;
import wonderland.sistemarestaurantesdominio.ClienteFrecuente;
import wonderland.sistemarestaurantesdominio.dtos.ClienteFrecuenteDTO;


public class ClientePanel extends JPanel {

    public ClientePanel(ClienteFrecuente cliente) {
        FontManager fontManager = new FontManager();

        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.WHITE));
        setBackground(new Color(19, 28, 54));

        setPreferredSize(new Dimension(500, 130));
        setMinimumSize(new Dimension(500, 130));
        setMaximumSize(new Dimension(500, 130));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 10, 3, 10);

        JLabel lblTelefono = new JLabel(cliente.getTelefono());
        lblTelefono.setForeground(Color.WHITE);
        lblTelefono.setFont(fontManager.getNotoSerifCondensedRegular(16f));

        JLabel lblNombre = new JLabel(cliente.getNombre().toUpperCase() + " " + 
                                   cliente.getApellidoPaterno().toUpperCase());
        lblNombre.setFont(fontManager.getNotoSerifCondensedRegular(22f));
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setToolTipText(lblNombre.getText());

        lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
        lblNombre.setPreferredSize(new Dimension(350, 30)); 
        lblNombre.setMinimumSize(new Dimension(350, 30));
        lblNombre.setMaximumSize(new Dimension(350, 30));

        JButton btnInfo = new JButton("Información");
        btnInfo.setPreferredSize(new Dimension(130, 30)); 
        btnInfo.setMinimumSize(new Dimension(130, 30));
        btnInfo.setMaximumSize(new Dimension(130, 30));
        btnInfo.setBackground(Color.WHITE);
        btnInfo.setFont(fontManager.getNunitoRegular(12f));
        btnInfo.setForeground(new Color(0, 0, 0));

        btnInfo.addActionListener(e -> {
            ControlPresentacion control = new ControlPresentacion();
            control.mostrarPerfilCliente(cliente);
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        add(lblTelefono, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1; 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(lblNombre, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0; 
        gbc.fill = GridBagConstraints.NONE; 
        gbc.anchor = GridBagConstraints.EAST;
        add(btnInfo, gbc);

        JLabel lblCorreo = new JLabel(
            (cliente.getCorreoElectronico() != null && !cliente.getCorreoElectronico().isEmpty()) 
            ? cliente.getCorreoElectronico() 
            : "Correo electronico no registrado."); 
        lblCorreo.setFont(fontManager.getNotoSerifCondensedRegular(16f));
        lblCorreo.setForeground(new Color(178, 220, 251));

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        add(lblCorreo, gbc);
    }
}

