/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantes.clientes;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import wonderland.sistemarestaurantesdominio.Cliente;


public class ClientePanel extends JPanel {


    public ClientePanel(Cliente cliente) {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.WHITE));
        setBackground(new Color(19, 28, 54));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10); // Márgenes internos más definidos
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTelefono = new JLabel(cliente.getTelefono());
        lblTelefono.setForeground(Color.WHITE);
        lblTelefono.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));

        JLabel lblNombre = new JLabel(cliente.getNombre().toUpperCase() + " " + cliente.getApellidoPaterno().toUpperCase()+ " " + cliente.getApellidoMaterno().toUpperCase());
        lblNombre.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 18));
        lblNombre.setForeground(Color.WHITE);

        JLabel lblCorreo = new JLabel(cliente.getCorreoElectronico());
        lblCorreo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 14));
        lblCorreo.setForeground(new Color(178, 220, 251));

//        JLabel lblPuntos = new JLabel(cliente.getPuntos() + " pts");
//        lblPuntos.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 16));
//        lblPuntos.setForeground(Color.WHITE);

        JButton btnInfo = new JButton("Información");
        btnInfo.setBackground(Color.WHITE);
        btnInfo.setFont(new Font("Century Gothic", Font.BOLD, 12));

        // Primera fila: Teléfono
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        add(lblTelefono, gbc);

        // Segunda fila: Nombre
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        add(lblNombre, gbc);

        // Tercera fila: Correo
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        add(lblCorreo, gbc);

        // Puntos a la derecha
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.EAST;
//        add(lblPuntos, gbc);

        // Botón Información a la derecha
        gbc.gridy = 2;
        add(btnInfo, gbc);
    }
}

