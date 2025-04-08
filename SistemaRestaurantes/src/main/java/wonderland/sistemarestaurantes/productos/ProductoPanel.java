/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantes.productos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import wonderland.sistemarestaurantes.control.ControlPresentacion;
import wonderland.sistemarestaurantesdominio.Producto;
import wonderland.sistemarestaurantesnegocio.implementaciones.ProductosBO;

/**
 *
 * @author payde
 */

public class ProductoPanel extends JPanel {

    private ControlPresentacion control;
    private ProductosBO productosBO;
    private Producto producto;
    
    public ProductoPanel(ControlPresentacion control, ProductosBO productosBO, Producto producto) {
        this.control = control;
        this.productosBO = productosBO;
        this.producto = producto;
        
        
        setPreferredSize(new Dimension(320, 28));
        setMaximumSize(new Dimension(320, 28));
        setMinimumSize(new Dimension(320, 28));
        setLayout(new GridBagLayout());
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(1, 5, 1, 5));

        GridBagConstraints gbc = new GridBagConstraints();
        Font font = new Font("Century Gothic", Font.PLAIN, 14);
        Color textColor = Color.WHITE;

       
        String texto = String.format("%-18s __ $%.2f", producto.getNombre(), producto.getPrecio());
        JLabel lblInfo = new JLabel(texto);
        lblInfo.setFont(font);
        lblInfo.setForeground(textColor);

        
        JButton btnEditar = new JButton("✎");
        btnEditar.setIcon(new ImageIcon(getClass().getResource("/images/lapizitoEditar.png")));
        btnEditar.setFont(font);
        btnEditar.setContentAreaFilled(false);
        btnEditar.setBorderPainted(false);
        btnEditar.setFocusPainted(false);
        btnEditar.setPreferredSize(new Dimension(30, 30)); 
        btnEditar.setMargin(new Insets(0, 0, 0, 0));
        btnEditar.addActionListener(e -> {
            control.mostrarEditarProducto(producto);
        });
  
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 0); 
        add(lblInfo, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(btnEditar, gbc);
    }

}