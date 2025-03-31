/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wonderland.sistemarestaurantes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dana Chavez
 */
public class PanelMesas extends JPanel{
    private int numeroMesa;

    public PanelMesas(int numeroMesa) {
        this.numeroMesa = numeroMesa;
        setLayout(new BorderLayout()); 
        setPreferredSize(new Dimension(100, 100));  
        
        setBackground(new Color(29, 39, 56)); 

        JLabel mesaLabel = new JLabel(String.valueOf(numeroMesa), JLabel.CENTER);
        mesaLabel.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 30)); 
        mesaLabel.setForeground(Color.BLACK);
        add(mesaLabel, BorderLayout.CENTER); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 

        g.setColor(Color.WHITE);
        g.fillOval(17, 10, 80, 80);  

    }
}
